package com.example.coursefinalservlet.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.example.coursefinalservlet.model.Acao.LOGIN_FORM;
import static com.example.coursefinalservlet.model.Acao.LOGIN_USUARIO;

@WebFilter(urlPatterns = "/root")
public class AurorizacaoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Action Autorizacao Filter");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        String parametroAcao = request.getParameter("acao");
        boolean usuarioNaoLogado = session.getAttribute("usuarioLogado") == null;
        boolean acaoProtegida = !(LOGIN_FORM.toString().equals(parametroAcao) || LOGIN_USUARIO.toString().equals(parametroAcao));

        if(acaoProtegida && usuarioNaoLogado) {
            try {
                response.sendRedirect("/root?acao=" + LOGIN_FORM);
                return;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
