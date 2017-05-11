package com.example.viniciussevero.prenac2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class Cadastro extends AppCompatActivity {

    private String prefName = "preferences";

    private EditText edtNome, edtRm, edtSenha;
    private Button btn, btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        this.edtNome = (EditText) findViewById(R.id.edtNome);
        this.edtRm = (EditText) findViewById(R.id.edtRm);
        this.edtSenha = (EditText) findViewById(R.id.edtSenha);
        this.btn = (Button) findViewById(R.id.btnCadastrar);
        this.btnVoltar = (Button) findViewById(R.id.btnVoltar);
    }

    public void cadastrar(View v){
        String strNome = edtNome.getText().toString();
        String strRm = edtRm.getText().toString();
        String strSenha = edtSenha.getText().toString();

        Toast.makeText(this, strNome+strSenha+strRm, Toast.LENGTH_SHORT).show();
        if(TextUtils.isEmpty(strNome) || TextUtils.isEmpty(strRm)|| TextUtils.isEmpty(strSenha)) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("nome", strNome);
        map.put("rm", strRm);
        map.put("senha", strSenha);
        Util.gravarCaves(this,prefName,map);

        String msg = Util.retornaValor(this,prefName,"nome")+" Salvo com sucesso!";
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void voltar(View v) {
        finish();
    }


}
