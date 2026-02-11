package com.eventmanagement.servlet;

import com.eventmanagement.dao.EventoDAO;
import com.eventmanagement.dao.InstituicaoDAO;
import com.eventmanagement.model.Evento;
import com.eventmanagement.model.Instituicao;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/evento")
public class EventoServlet extends HttpServlet {
    private EventoDAO eventoDAO = new EventoDAO();
    private InstituicaoDAO instDAO = new InstituicaoDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            if (action == null || action.equals("list")) {
                req.setAttribute("eventos", eventoDAO.listarTodos());
                req.setAttribute("instituicoes", instDAO.listarTodas());
                req.getRequestDispatcher("/evento/list.jsp").forward(req, resp);
            } else if ("new".equals(action)) {
                req.setAttribute("instituicoes", instDAO.listarTodas());
                req.getRequestDispatcher("/evento/form.jsp").forward(req, resp);
            } else if ("edit".equals(action)) {
                Integer id = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("evento", eventoDAO.buscarPorId(id));
                req.setAttribute("instituicoes", instDAO.listarTodas());
                req.getRequestDispatcher("/evento/form.jsp").forward(req, resp);
            } else if ("delete".equals(action)) {
                Integer id = Integer.parseInt(req.getParameter("id"));
                eventoDAO.deletar(id);
                resp.sendRedirect(req.getContextPath() + "/evento?action=list");
            }
        } catch (SQLException e) { throw new ServletException(e); }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        try {
            String idParam = req.getParameter("id");
            String nome = req.getParameter("nome");
            LocalDate di = LocalDate.parse(req.getParameter("dataInicial"));
            LocalDate df = LocalDate.parse(req.getParameter("dataFinal"));
            Integer instId = Integer.parseInt(req.getParameter("instituicaoId"));
            LocalDate hoje = LocalDate.now();
            boolean ativo = !hoje.isBefore(di) && !hoje.isAfter(df);
            
            if (idParam == null || idParam.isEmpty()) {
                eventoDAO.inserir(new Evento(null, nome, di, df, ativo, instId));
            } else {
                Integer id = Integer.parseInt(idParam);
                eventoDAO.atualizar(new Evento(id, nome, di, df, ativo, instId));
            }
            resp.sendRedirect(req.getContextPath() + "/evento?action=list");
        } catch (SQLException e) { 
            throw new ServletException(e); 
        }
        
    }
}
