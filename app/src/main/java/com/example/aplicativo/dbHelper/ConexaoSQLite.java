package com.example.aplicativo.dbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class ConexaoSQLite extends SQLiteOpenHelper {


    private static ConexaoSQLite INSTANCIA_CONEXAO;
    private static final int VERSAO_DB = 1;
    private static final String NOME_DB = "bella_doces_app";

    public ConexaoSQLite(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
    }

    public static ConexaoSQLite getInstancia(Context context) {
    if (INSTANCIA_CONEXAO == null) {
        INSTANCIA_CONEXAO = new ConexaoSQLite(context);
    }
    return INSTANCIA_CONEXAO;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sqlTabelaProduto =
                "CREATE TABLE IF NOT EXISTS produto" + //Irá criar a tabela somente se ela não existir.
                        "(" +
                        "id INTEGER PRIMARY KEY" +
                        "nome TEXT," + //TEXT é uma string.
                        "quantidade_em_estoque INTEGER," + //INTEGER é um inteiro.
                        "preco REAL" +
                        ")";

        sqLiteDatabase.execSQL(sqlTabelaProduto);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
