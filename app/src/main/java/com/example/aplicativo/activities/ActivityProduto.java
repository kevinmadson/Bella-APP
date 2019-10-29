package com.example.aplicativo.activities;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.aplicativo.R;
import com.example.aplicativo.controller.ProdutoCtrl;
import com.example.aplicativo.dbHelper.ConexaoSQLite;
import com.example.aplicativo.model.Produto;

public class ActivityProduto extends AppCompatActivity {

    private EditText edtIdProduto; //É o código de barras do produto.
    private EditText edtNomeProduto;
    private EditText edtQuantidadeProduto;
    private EditText edtPrecoProduto;

    private Button btnSalvarProduto;

    private Produto produto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        edtIdProduto = (EditText) findViewById(R.id.edtIdProduto); //faz a conversão do xml para o componente java.
        edtNomeProduto = (EditText) findViewById(R.id.editNomeProduto);
        edtQuantidadeProduto = (EditText) findViewById(R.id.edtQuantidadeProduto);
        edtPrecoProduto = (EditText) findViewById(R.id.edtPrecoProduto);

        btnSalvarProduto = (Button) findViewById (R.id.btnSalvarProduto);

        this.clickNoBotaoSalvarListener(); //chamando o click no botão.

    }

    private void clickNoBotaoSalvarListener () { //listener é um escutador, ele fica esperando o usuário clicar no botão.

        this.btnSalvarProduto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Produto produtoACadastrar = getDadosProdutoDoFormulario();

                if(produtoACadastrar != null) { //se o produto a cadastrar for diferente de nulo, ele irá salvar.

                    ProdutoCtrl produtoCtrl = new ProdutoCtrl(ConexaoSQLite.getInstancia(ActivityProduto.this)); //controller para dar acessso ao banco.
                    long idProduto = produtoCtrl.salvarProdutoCtrl(produtoACadastrar); //se o id do produto for 0, terá que enviar uma mensagem ao usuário.

                    if (idProduto > 0) {
                        Toast.makeText(ActivityProduto.this, "Produto salvo com sucesso!", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(ActivityProduto.this, "Produto não pode ser salvo!", Toast.LENGTH_LONG).show();
                    }

                }else {
                    Toast.makeText(ActivityProduto.this, "Todos os campos são obrigatórios!", Toast.LENGTH_LONG).show(); //Toast é um pop-up onde aparece um texto dentro dele.
                } //LENGTH_LONG significa tempo mais longo do texto aparecer para o usuário.

            }
        });

    }

    private Produto getDadosProdutoDoFormulario() {
        this.produto = new Produto();

        if (this.edtIdProduto.getText().toString().isEmpty() == false) { //testar se o ID é vazio.
            this.produto.setId(Long.parseLong(this.edtIdProduto.getText().toString()));
        } else {
            return null;
        }
        if(this.edtNomeProduto.getText().toString().isEmpty() == false) {
            this.produto.setNome(this.edtNomeProduto.getText().toString());
      }else {
         return null;
        }

        if(edtQuantidadeProduto.getText().toString().isEmpty() == false) {
            int quantidadeproduto = Integer.parseInt(this.edtQuantidadeProduto.getText().toString());
            this.produto.setQuantidadeEmEstoque(quantidadeproduto);
        }else {
            return null;
        }
        if (edtPrecoProduto.getText().toString().isEmpty() == false) {
            double precoProduto = Double.parseDouble(this.edtPrecoProduto.getText().toString());
        }else {
            return null;
        }
        return produto;
    }

}

