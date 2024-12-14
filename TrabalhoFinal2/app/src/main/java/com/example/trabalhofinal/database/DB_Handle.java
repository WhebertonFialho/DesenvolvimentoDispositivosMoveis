package com.example.trabalhofinal.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import com.example.trabalhofinal.model.Contato;

public class DB_Handle {
    private final SQLiteDatabase db;
    private static DB_Handle db_handle;
    public static DB_Handle getInstance(Context context) {
        if (db_handle == null) {
            db_handle = new DB_Handle(context);
        }
        return db_handle;
    }
    private DB_Handle(Context context) {
        db = new DBCore(context).getWritableDatabase();
    }

    public Contato insert(Contato contato) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBCore.NOME, contato.getNome());
        contentValues.put(DBCore.EMAIL, contato.getEmail());
        long id = db.insert(DBCore.TABLE_CONTATOS, null,
                contentValues);
        contato.setId((int) id);
        return contato;
    }

    public Contato updateContato(Contato contato) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBCore.NOME, contato.getNome());
        contentValues.put(DBCore.EMAIL, contato.getEmail());
        String whereClause = DBCore.ID + " = ?";
        String[] args = new String[]{"" + contato.getId()};
        db.update(DBCore.TABLE_CONTATOS, contentValues, whereClause,args);
        return contato;
    }

    public void delete(Contato contato) {
        String whereClause = DBCore.ID + " = ?";
        String[] args = {"" + contato.getId()};
        db.delete(DBCore.TABLE_CONTATOS, whereClause, args);
    }
    public ArrayList<Contato> getAll() {
        ArrayList<Contato> contatos;
        String[] projection = {DBCore.ID, DBCore.NOME, DBCore.EMAIL};
        Cursor cursor = db.query(
                DBCore.TABLE_CONTATOS,
                projection,
                null,
                null,
                null,
                null,
                DBCore.NOME + " ASC"
        );
        if (cursor.moveToFirst()) {
            contatos = new ArrayList<>(cursor.getCount() + 10);
            do {
                Contato contatormacao = new Contato(
                        cursor.getLong(0),
                        cursor.getString(1),
                        cursor.getString(2)
                );
                contatos.add(contatormacao);
            } while (cursor.moveToNext());
            cursor.close();
            return contatos;
        } else {
            cursor.close();
            contatos = new ArrayList<>();
            return contatos;
        }
    }
}
