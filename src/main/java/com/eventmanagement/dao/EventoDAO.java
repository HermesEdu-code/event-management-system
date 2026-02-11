package com.eventmanagement.dao;

import com.eventmanagement.model.Evento;
import com.eventmanagement.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO {

    public void inserir(Evento e) throws SQLException {
        String sql = "INSERT INTO evento (nome, data_inicial, data_final, ativo, instituicao_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement s = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            s.setString(1, e.getNome());
            s.setDate(2, Date.valueOf(e.getDataInicial()));
            s.setDate(3, Date.valueOf(e.getDataFinal()));
            s.setBoolean(4, e.getAtivo());
            s.setInt(5, e.getInstituicaoId());
            s.executeUpdate();

            try (ResultSet rs = s.getGeneratedKeys()) {
                if (rs.next()) e.setId(rs.getInt(1));
            }
        }
    }

    public void atualizar(Evento e) throws SQLException {
        String sql = "UPDATE evento SET nome = ?, data_inicial = ?, data_final = ?, ativo = ?, instituicao_id = ? WHERE id = ?";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement s = c.prepareStatement(sql)) {
            s.setString(1, e.getNome());
            s.setDate(2, Date.valueOf(e.getDataInicial()));
            s.setDate(3, Date.valueOf(e.getDataFinal()));
            s.setBoolean(4, e.getAtivo());
            s.setInt(5, e.getInstituicaoId());
            s.setInt(6, e.getId());
            s.executeUpdate();
        }
    }

    public void deletar(Integer id) throws SQLException {
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement s = c.prepareStatement("DELETE FROM evento WHERE id = ?")) {
            s.setInt(1, id);
            s.executeUpdate();
        }
    }

    public Evento buscarPorId(Integer id) throws SQLException {

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement s = c.prepareStatement("SELECT * FROM evento WHERE id = ?")) {
            s.setInt(1, id);
            try (ResultSet rs = s.executeQuery()) {
                if (rs.next()) return mapBasico(rs);
            }
        }
        return null;
    }

    public List<Evento> listarTodos() throws SQLException {
        List<Evento> eventos = new ArrayList<>();

        String sql =
            "SELECT e.*, i.nome AS nome_inst " +
            "FROM evento e " +
            "JOIN instituicao i ON e.instituicao_id = i.id " +
            "ORDER BY e.data_inicial DESC";

        try (Connection c = DatabaseConnection.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql)) {

            while (rs.next()) {
                Evento ev = mapBasico(rs);
                ev.setNomeInstituicao(rs.getString("nome_inst"));
                eventos.add(ev);
            }
        }
        return eventos;
    }

    public void atualizarStatusEventos() throws SQLException {
        String sql = "UPDATE evento SET ativo = CASE " +
                     "WHEN CURRENT_DATE BETWEEN data_inicial AND data_final THEN TRUE " +
                     "ELSE FALSE END";
        try (Connection c = DatabaseConnection.getConnection();
             Statement s = c.createStatement()) {
            s.executeUpdate(sql);
        }
    }

    private Evento mapBasico(ResultSet rs) throws SQLException {
        return new Evento(
            rs.getInt("id"),
            rs.getString("nome"),
            rs.getDate("data_inicial").toLocalDate(),
            rs.getDate("data_final").toLocalDate(),
            rs.getBoolean("ativo"),
            rs.getInt("instituicao_id")
        );
    }
}