package com.example.coursefinalservlet.action;

import com.example.coursefinalservlet.dao.EmpresaDao;
import com.example.coursefinalservlet.model.Acao;
import com.example.coursefinalservlet.model.ActionServlet;
import com.example.coursefinalservlet.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.coursefinalservlet.model.Acao.LISTA_EMPRESA;

public class RemoveEmpresa implements ActionServlet {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            EntityManager entityManager = JPAUtil.getEntityManager();
            EmpresaDao empresaDao = new EmpresaDao(entityManager);

            Long id = Long.valueOf(request.getParameter("id"));

            entityManager.getTransaction().begin();
            empresaDao.remove(id);
            entityManager.getTransaction().commit();

            return "redirect:root?acao="+ LISTA_EMPRESA;
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
