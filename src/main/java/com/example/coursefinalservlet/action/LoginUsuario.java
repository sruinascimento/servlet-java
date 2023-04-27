package com.example.coursefinalservlet.action;

import com.example.coursefinalservlet.dao.UsuarioDao;
import com.example.coursefinalservlet.model.Acao;
import com.example.coursefinalservlet.model.ActionServlet;
import com.example.coursefinalservlet.model.Usuario;
import com.example.coursefinalservlet.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.example.coursefinalservlet.model.Acao.LISTA_EMPRESA;
import static com.example.coursefinalservlet.model.Acao.LOGIN_FORM;

public class LoginUsuario implements ActionServlet {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        EntityManager entityManager = JPAUtil.getEntityManager();
        UsuarioDao usuarioDao = new UsuarioDao(entityManager);

        Usuario usuario = usuarioDao.getUsuarioPorLoginESenha(login, senha);
        if (usuario == null) {
            return "redirect:root?acao=" + LOGIN_FORM;
        }

        HttpSession session = request.getSession();
        session.setAttribute("usuarioLogado", usuario);
        System.out.println("Session: " + session.getId());
        System.out.println(session.getAttribute("usuarioLogado"));
        System.out.println(session.getAttributeNames().toString());
        System.out.println(session.getCreationTime());
        System.out.println(session.getServletContext());

        return "redirect:root?acao=" + LISTA_EMPRESA;

    }
}
