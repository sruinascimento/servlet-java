package com.example.coursefinalservlet.servlet;

import com.example.coursefinalservlet.dao.EmpresaDao;
import com.example.coursefinalservlet.model.Empresa;
import com.example.coursefinalservlet.util.JPAUtil;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/empresas")
public class EmpresaServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EmpresaDao empresaDao = new EmpresaDao(entityManager);

        List<Empresa> empresas = empresaDao.getEmpresas();

        String typeData = req.getHeader("Accept");
        System.out.println("data " +  typeData);
        String data = null;

        resp.setContentType("application/json");

        if (typeData.contains("json")) {
            Gson gson = new Gson();
            data = gson.toJson(empresas);
        } else if (typeData.contains("xml")) {
            XStream xStream = new XStream();
            xStream.alias("empresa", Empresa.class);
            data = xStream.toXML(empresas);
            resp.setContentType("application/xml");
        } else {
            data = "{'message': 'no content'}";
        }


//
//
//        resp.getWriter().println(xml);


        resp.getWriter().println(data);

    }
}
