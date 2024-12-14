package com.example.trabalhofinal.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

import com.example.trabalhofinal.R;
import com.example.trabalhofinal.model.Contato;
import com.example.trabalhofinal.database.DB_Handle;

public class ContatoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recyclearview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<Contato> contatos = DB_Handle.getInstance(this).getAll();
        ContatoAdapter contatoAdpter = new ContatoAdapter(this, contatos);
        contatoAdpter = new ContatoAdapter(this, contatos);
        recyclerView.setAdapter(contatoAdpter);
    }
}
