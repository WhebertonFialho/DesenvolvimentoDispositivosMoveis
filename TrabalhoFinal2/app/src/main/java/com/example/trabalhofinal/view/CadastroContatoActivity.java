package com.example.trabalhofinal.view;

import static com.example.trabalhofinal.controller.ContatoController.validarCadastroContato;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabalhofinal.R;

public class CadastroContatoActivity extends AppCompatActivity {
    private EditText nome, email;
    private Button btn_concluir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_contato);
        nome = findViewById(R.id.nome);
        email = findViewById(R.id.email);
        btn_concluir = findViewById(R.id.btn_concluir);
        btn_concluir.setOnClickListener(v -> {
            if
            (validarCadastroContato(nome.getText().toString(),email.getText().toString(),this)){
                Toast.makeText(this, "Contato cadastrado", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this, "Contato não foi cadastrado",Toast.LENGTH_LONG).show();
            }
        });
    }

}
