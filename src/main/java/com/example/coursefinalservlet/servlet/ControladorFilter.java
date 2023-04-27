package com.example.coursefinalservlet.servlet;

import com.example.coursefinalservlet.model.ActionServlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControladorFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Action Controlador Filter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String parametroAcao = request.getParameter("acao");
        String className = "com.example.coursefinalservlet.action." + parametroAcao;
        String redirect = null;

        try {
            Class<?> classe = Class.forName(className);
            Object obj = classe.newInstance();
            ActionServlet action = (ActionServlet) obj;
            redirect = (String) action.execute(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();


            try {
                request.getRequestDispatcher("WEB-INF/view/not-found.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        String[] typeAndAdress = separatedString(redirect);

        if ("forward".equals(typeAndAdress[0])) {
            try {
                request.getRequestDispatcher("WEB-INF/view/" + typeAndAdress[1]).forward(request, response);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        }
        if ("redirect".equals(typeAndAdress[0])) {
            try {
                response.sendRedirect(typeAndAdress[1]);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static String[] separatedString(String sentence) {
        return sentence.split(":");
    }
}
