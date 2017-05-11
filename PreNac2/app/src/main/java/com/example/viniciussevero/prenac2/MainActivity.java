package com.example.viniciussevero.prenac2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private String prefName = "preferences";

    private EditText edtRm, edtSenha;
    private CheckBox chkLembrarLogin;
    private Button btnLogar, btnCadastrar;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.context = this;
        this.edtRm = (EditText) findViewById(R.id.edtRm);
        this.edtSenha = (EditText) findViewById(R.id.edtSenha);
        this.btnLogar = (Button) findViewById(R.id.btnLogar);
        this.btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        this.chkLembrarLogin = (CheckBox) findViewById(R.id.chkLembrarLogin);

        this.btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, Cadastro.class));
            }
        });
    }

    public void logar(View v){

        String rm = this.edtRm.getText().toString();
        String senha = this.edtSenha.getText().toString();

        if(!Util.verificarChave(this,prefName,"rm") && !Util.verificarChave(this,prefName,"senha")){
            Toast.makeText(context, "Cadastre um usuário primeiro", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(rm) || TextUtils.isEmpty(senha)){
            Toast.makeText(context, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        if(Util.retornaValor(context,prefName,"rm").equals(rm) && Util.retornaValor(context,prefName,"senha").equals(senha)){
            if(this.chkLembrarLogin.isChecked()){
                HashMap<String,String> map = new HashMap<>();
                map.put("lembrar","s");
                Util.gravarCaves(this,prefName,map);
            }else{
                HashMap<String,String> map = new HashMap<>();
                map.put("lembrar","n");
                Util.gravarCaves(this,prefName,map);
            }
            startActivity(new Intent(this, Lista.class));
        }else{
            Toast.makeText(context, "Usuário e/ou senha inválidos!", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(Util.verificarChave(this,prefName,"lembrar") && Util.retornaValor(this,prefName,"lembrar").equals("s")){
            this.chkLembrarLogin.setChecked(true);
            this.edtRm.setText(Util.retornaValor(this,prefName,"rm"));
            this.edtSenha.setText(Util.retornaValor(this,prefName,"senha"));
        }
    }
}
