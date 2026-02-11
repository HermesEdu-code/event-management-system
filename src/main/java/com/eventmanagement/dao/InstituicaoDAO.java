package com.eventmanagement.dao;

import com.eventmanagement.model.Instituicao;
import com.eventmanagement.util.DatabaseConnection;
import java.sql.*;
import java.util.*;

public class InstituicaoDAO {
    
    public void inserir(Instituicao i) throws SQLException {
        String sql = "INSERT INTO instituicao (nome, tipo) VALUES (?, ?)";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement s = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            s.setString(1, i.getNome());
            s.setString(2, i.getTipo());
            s.executeUpdate();
            ResultSet rs = s.getGeneratedKeys();
            if (rs.next()) i.setId(rs.getInt(1));
        }
    }

    public void atualizar(Instituicao i) throws SQLException {
        String sql = "UPDATE instituicao SET nome = ?, tipo = ? WHERE id = ?";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement s = c.prepareStatement(sql)) {
            s.setString(1, i.getNome());
            s.setString(2, i.getTipo());
            s.setInt(3, i.getId());
            s.executeUpdate();
        }
    }

    public void deletar(Integer id) throws SQLException {
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement s = c.prepareStatement("DELETE FROM instituicao WHERE id = ?")) {
            s.setInt(1, id);
            s.executeUpdate();
        }
    }

    public Instituicao buscarPorId(Integer id) throws SQLException {
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement s = c.prepareStatement("SELECT * FROM instituicao WHERE id = ?")) {
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                return new Instituicao(rs.getInt("id"), rs.getString("nome"), rs.getString("tipo"));
            }
        }
        return null;
    }

    public List<Instituicao> listarTodas() throws SQLException {
        List<Instituicao> list = new ArrayList<>();
        try (Connection c = DatabaseConnection.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery("SELECT * FROM instituicao ORDER BY nome")) {
            while (rs.next()) {
                list.add(new Instituicao(rs.getInt("id"), rs.getString("nome"), rs.getString("tipo")));
            }
        }
        return list;
    }
}
