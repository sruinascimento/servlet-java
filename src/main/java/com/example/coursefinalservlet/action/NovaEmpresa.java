package com.example.coursefinalservlet.action;

import com.example.coursefinalservlet.dao.EmpresaDao;
import com.example.coursefinalservlet.model.Acao;
import com.example.coursefinalservlet.model.ActionServlet;
import com.example.coursefinalservlet.model.Empresa;
import com.example.coursefinalservlet.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.coursefinalservlet.model.Acao.LISTA_EMPRESA;

public class NovaEmpresa implements ActionServlet {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String nomeEmpresa = request.getParameter("empresa");
        String cnpj = request.getParameter("cnpj");
        System.out.println("Params: ");
        System.out.println("Nome " + nomeEmpresa);
        System.out.println("CNPJ " + cnpj);
        Empresa empresa = new Empresa(nomeEmpresa, cnpj);
        System.out.println(empresa);
        EntityManager entityManager = JPAUtil.getEntityManager();
        EmpresaDao empresaDao = new EmpresaDao(entityManager);
        if (!cnpj.equals("") && !nomeEmpresa.equals("")) {
            entityManager.getTransaction().begin();
            empresaDao.save(empresa);
            entityManager.getTransaction().commit();
        }

//        try {
            request.setAttribute("empresa", empresa.getNome());
            request.setAttribute("cnpj", empresa.getCnpj());
            return "redirect:root?acao=" + LISTA_EMPRESA;
//            response.sendRedirect("/root?acao=" + Acao.LISTA_EMPRESA);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
