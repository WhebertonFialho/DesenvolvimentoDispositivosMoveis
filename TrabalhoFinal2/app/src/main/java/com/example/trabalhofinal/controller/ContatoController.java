package com.example.trabalhofinal.controller;

import android.content.Context;

import com.example.trabalhofinal.database.DB_Handle;
import com.example.trabalhofinal.model.Contato;
public class ContatoController {
    public static boolean validarCadastroContato(String nome, String email, Context contexto){
        if (nome.isEmpty() || email.isEmpty()){
            return false;
        }else {
            Contato contato = new Contato();
            contato.setNome(nome);
            contato.setEmail(email);
            DB_Handle.getInstance(contexto).insert(contato);
            return true;
        }
    }
}
