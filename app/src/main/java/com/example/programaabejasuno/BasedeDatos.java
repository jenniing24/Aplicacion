package com.example.programaabejasuno;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BasedeDatos extends SQLiteOpenHelper {

    public static final String DBName = "register.db";
    public BasedeDatos(@Nullable Context context) {
        super(context, DBName, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuarios(nomusuario TEXT primary key, clave TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
        db.execSQL("drop table if exists usuarios");
        db.execSQL("create table usuarios(id integer primary key, nomusuario text, clave text)");
    }

    public boolean insertData(String nomusuario, String clave){
        SQLiteDatabase myDB = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nomusuario", nomusuario);
        contentValues.put("clave",clave);
        long result = myDB.insert("usuarios",null, contentValues);
        if (result==-1) return false;
        else return true;
    }

    public boolean checarUsuario(String nomusuario){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from usuarios where nomusuario = ?", new String[]{nomusuario});
        if(cursor.getCount() > 0)
            return true;
        else return false;
    }

    public boolean checharNomUsuarioInicioS(String nomusuario, String clv){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from usuarios where nomusuario = ? and clave = ?", new String[]{nomusuario,clv});
        if(cursor.getCount() > 0)
            return true;
        else return false;
    }

}
