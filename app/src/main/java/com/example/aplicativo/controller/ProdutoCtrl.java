package com.example.aplicativo.controller;
import com.example.aplicativo.DAO.ProdutoDAO;
import com.example.aplicativo.dbHelper.ConexaoSQLite;
import com.example.aplicativo.model.Produto;


public class ProdutoCtrl { //Controller é uma interface entre o view, banco de dados e DAO.

    private final ProdutoDAO produtoDAO;

    public ProdutoCtrl(ConexaoSQLite pConexaoSQLite) {
        produtoDAO = new ProdutoDAO(pConexaoSQLite);
    }

    public long salvarProdutoCtrl(Produto pProduto) {
        return this.produtoDAO.salvarProdutoDAO(pProduto);
    }









}
