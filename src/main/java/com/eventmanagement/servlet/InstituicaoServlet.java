package com.eventmanagement.servlet;

import com.eventmanagement.dao.InstituicaoDAO;
import com.eventmanagement.model.Instituicao;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/instituicao")
public class InstituicaoServlet extends HttpServlet {
    private InstituicaoDAO dao = new InstituicaoDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            if (action == null || action.equals("list")) {
                List<Instituicao> list = dao.listarTodas();
                req.setAttribute("instituicoes", list);
                req.getRequestDispatcher("/instituicao/list.jsp").forward(req, resp);
            } else if ("new".equals(action)) {
                req.setAttribute("instituicao", new Instituicao());
                req.getRequestDispatcher("/instituicao/form.jsp").forward(req, resp);
            } else if ("edit".equals(action)) {
                Integer id = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("instituicao", dao.buscarPorId(id));
                req.getRequestDispatcher("/instituicao/form.jsp").forward(req, resp);
            } else if ("delete".equals(action)) {
                Integer id = Integer.parseInt(req.getParameter("id"));
                dao.deletar(id);
                resp.sendRedirect(req.getContextPath() + "/instituicao?action=list");
            }
        } catch (SQLException e) { 
            throw new ServletException(e); 
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        try {
            String idParam = req.getParameter("id");
            String nome = req.getParameter("nome");
            String tipo = req.getParameter("tipo");
            
            if (idParam == null || idParam.isEmpty()) {
                dao.inserir(new Instituicao(null, nome, tipo));
            } else {
                Integer id = Integer.parseInt(idParam);
                dao.atualizar(new Instituicao(id, nome, tipo));
            }
            resp.sendRedirect(req.getContextPath() + "/instituicao?action=list");
        } catch (SQLException e) { 
            throw new ServletException(e); 
        }
    }
}
