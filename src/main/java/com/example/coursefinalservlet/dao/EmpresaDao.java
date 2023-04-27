package com.example.coursefinalservlet.dao;

import com.example.coursefinalservlet.model.Empresa;

import javax.persistence.EntityManager;
import java.util.List;

public class EmpresaDao {
    private EntityManager entityManager;

    public EmpresaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Empresa empresa) {
        entityManager.persist(empresa);
    }

    public List<Empresa> getEmpresas() {
        List<Empresa> empresas = this.entityManager
                .createQuery("SELECT e FROM Empresa e")
                .getResultList();
        return empresas;
    }

    public void remove(Long id) {
        Empresa empresa = this.entityManager.find(Empresa.class, id);
        if(empresa != null) {
            this.entityManager.merge(empresa);
            this.entityManager.remove(empresa);
        }
    }

    public Empresa getEmpresaById(Long id) {
        return entityManager.find(Empresa.class, id);
    }


    public void atualiza(Empresa empresa) {
        this.entityManager.merge(empresa);
        this.entityManager.persist(empresa);
    }
}
