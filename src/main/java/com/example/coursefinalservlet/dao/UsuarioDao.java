package com.example.coursefinalservlet.dao;

import com.example.coursefinalservlet.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class UsuarioDao {
    private EntityManager entityManager;

    public UsuarioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Usuario getUsuarioPorLoginESenha(String login, String senha) {
        String jpl = "SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha";
        try {

            return entityManager.createQuery(jpl, Usuario.class)
                    .setParameter("login", login)
                    .setParameter("senha", senha)
                    .getSingleResult();

        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }


    }

}
