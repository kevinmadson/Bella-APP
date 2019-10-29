package com.example.aplicativo.DAO;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.example.aplicativo.dbHelper.ConexaoSQLite;
import com.example.aplicativo.model.Produto;

public class ProdutoDAO {

    private final ConexaoSQLite conexaoSQLite;

    public ProdutoDAO(ConexaoSQLite conexaoSQLite) {
        this.conexaoSQLite = conexaoSQLite;
    }

    public long salvarProdutoDAO(Produto pProduto, ContentValues ContentValues_values) { // long irá retornar o id do produto inserido.
        SQLiteDatabase db = conexaoSQLite.getWritableDatabase(); //pega essa conexao sqlite e faz uma abertura no banco de dados que eu possa escrever.

        try {

            ContentValues contantvalues = new ContentValues();
            contantvalues.put("id",pProduto.getId());
            contantvalues.put("nome",pProduto.getNome());
            contantvalues.put("quantidade_em_estoque", pProduto.getQuantidadeEmEstoque());
            contantvalues.put("preco", pProduto.getPreco());

            return db.insert("produto", null, contantvalues);

            //objetos que armazenam chaves e valores. Tem uma chave com um nome e um valor para essa chave.
            //A chave vai ser o nome do campo do Banco de Dados e o valor vai ser qualquer um que quisemos inserir nesse campo.

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public long salvarProdutoDAO(Produto pProduto) {
    return 0;
    }
}
