package com.example.coursefinalservlet.action;

import com.example.coursefinalservlet.dao.EmpresaDao;
import com.example.coursefinalservlet.model.ActionServlet;
import com.example.coursefinalservlet.model.Empresa;
import com.example.coursefinalservlet.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MostraEmpresa implements ActionServlet {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EmpresaDao empresaDao = new EmpresaDao(entityManager);
        try {
            Long id = Long.valueOf(request.getParameter("id"));
            Empresa empresa = empresaDao.getEmpresaById(id);
            request.setAttribute("empresa", empresa);
            return "forward:altera-empresa.jsp";
//            request.getRequestDispatcher("/altera-empresa.jsp")
//                    .forward(request, response);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
