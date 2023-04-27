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
import java.util.Date;

import static com.example.coursefinalservlet.model.Acao.LISTA_EMPRESA;

public class AlteraEmpresa implements ActionServlet {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            Long id = Long.valueOf(request.getParameter("id"));
            EntityManager entityManager = JPAUtil.getEntityManager();
            EmpresaDao empresaDao = new EmpresaDao(entityManager);

            Empresa empresa = empresaDao.getEmpresaById(id);
            if (empresa != null) {
                empresa.setNome(request.getParameter("empresa"));
                empresa.setCnpj(request.getParameter("cnpj"));
                empresa.setDataCadastro(new Date());
                entityManager.getTransaction().begin();
                empresaDao.atualiza(empresa);
                entityManager.getTransaction().commit();
                entityManager.close();

            }
            return "redirect:root?acao=" + LISTA_EMPRESA;
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
