package com.example.coursefinalservlet.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/root")
public class MonitoramentoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Action Monitoramento Filter");
        long timeStarts = System.currentTimeMillis();

        filterChain.doFilter(servletRequest, servletResponse);
        String acao = servletRequest.getParameter("acao");
        long timeEnds = System.currentTimeMillis();


        System.out.printf("Action %s ->     Runtime = %d ms%n", acao,(timeEnds - timeStarts));

    }

}
