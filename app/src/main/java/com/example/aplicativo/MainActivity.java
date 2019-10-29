package com.example.aplicativo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.aplicativo.activities.ActivityProduto;
import com.example.aplicativo.dbHelper.ConexaoSQLite;
import com.example.aplicativo.controller.ProdutoCtrl;


public class  MainActivity extends AppCompatActivity {

    private Button btnCadastroProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexaoSQLite.getInstancia(this); //método para testar o banco, verificar se a classe está instanciada ou não.


        this.btnCadastroProdutos = (Button) findViewById(R.id.btnCadastroProdutos); //converte o botão da interface, para cadastrar os produtos.

        this.btnCadastroProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //vai chamar a interface.
                //será executado ao clicar no botão
                Intent intent = new Intent(MainActivity.this, ActivityProduto.class);
                startActivity(intent);
            }
        });
    }
}
