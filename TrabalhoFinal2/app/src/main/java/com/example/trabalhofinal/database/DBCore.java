package com.example.trabalhofinal.database;

import android.app.backup.BackupManager;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBCore extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "contatos.db";
    private static final int VERSAO = 1;
    public DBCore(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }
    public static final String TABLE_CONTATOS = "contatos";
    public static final String ID = "_id";
    public static final String EMAIL = "email";
    public static final String NOME = "nome";
    private static final String CREATE_TABLE_CONTATOS=
            "create table " + TABLE_CONTATOS +
                    "(" +
                    ID + " integer primary key autoincrement, " +NOME + " text not null, " +
                    EMAIL + " int )";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CONTATOS);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
}
