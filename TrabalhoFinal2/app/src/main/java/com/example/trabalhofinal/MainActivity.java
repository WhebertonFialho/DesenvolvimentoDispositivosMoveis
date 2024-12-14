package com.example.trabalhofinal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.trabalhofinal.view.CadastroContatoActivity;
import com.example.trabalhofinal.view.ContatoActivity;

public class MainActivity extends AppCompatActivity {
    private Button btn_buscar_contatos, btn_cadastrar_contatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_buscar_contatos = findViewById(R.id.btn_solicitar);
        btn_buscar_contatos.setOnClickListener(v -> {
            Intent intent = new Intent(this, ContatoActivity.class);startActivity(intent);
        });
        btn_cadastrar_contatos = findViewById(R.id.btn_cadastrar);btn_cadastrar_contatos.setOnClickListener(view -> {
            Intent intent = new Intent(this, CadastroContatoActivity.class);
            startActivity(intent);
        });
    }
}
