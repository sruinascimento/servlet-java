package com.example.coursefinalservlet.action;

import com.example.coursefinalservlet.dao.EmpresaDao;
import com.example.coursefinalservlet.model.ActionServlet;
import com.example.coursefinalservlet.model.Empresa;
import com.example.coursefinalservlet.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.example.coursefinalservlet.model.Acao.LOGIN_FORM;

public class ListaEmpresa implements ActionServlet {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {



        EntityManager entityManager = JPAUtil.getEntityManager();
        EmpresaDao empresaDao = new EmpresaDao(entityManager);
        List<Empresa> empresas = empresaDao.getEmpresas();

        request.setAttribute("empresas", empresas);



        return "forward:todas-empresas.jsp";

    }
}
