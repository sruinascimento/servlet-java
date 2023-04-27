package com.example.coursefinalservlet.model;

public enum Acao {
    LISTA_EMPRESA("ListaEmpresa"),
    REMOVE_EMPRESA("RemoveEmpresa"),
    MOSTRA_EMPRESA("MostraEmpresa"),
    ALTERA_EMPRESA("AlteraEmpresa"),
    NOVA_EMPRESA("NovaEmpresa"),
    CADASTRO_EMPRESA_FORM("CadastroEmpresaForm"),
    LOGIN_USUARIO("LoginUsuario"),
    LOGIN_FORM("LoginForm"),

    LOGOUT("Logout");

    private String acao;

    Acao(String acao) {
        this.acao = acao;
    }

    @Override
    public String toString() {
        return acao;
    }
}
