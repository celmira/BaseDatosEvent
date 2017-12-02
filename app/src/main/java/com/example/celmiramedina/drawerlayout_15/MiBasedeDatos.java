package com.example.celmiramedina.drawerlayout_15;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.celmiramedina.drawerlayout_15.Modelo.Evento;
import com.example.celmiramedina.drawerlayout_15.Modelo.Usuario_asistente;
import com.example.celmiramedina.drawerlayout_15.Modelo.Usuario_guia;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Celmira Medina on 18/11/2017.
 */

public class MiBasedeDatos extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "miBasedeDatos.db";

    public static final String TABLA_ASISTENTE = "usuario";
    public static final String COLUMNA_ASISTENTE_ID = "_id";
    public static final String COLUMNA_ASISTENTE_NOMBRE = "nombre";
    public static final String COLUMNA_ASISTENTE_FECHANACIMIENTO = "fecha";
    public static final String COLUMNA_ASISTENTE_CEDULA = "cedula";
    public static final String COLUMNA_ASISTENTE_CORREO = "correo";
    public static final String COLUMNA_ASISTENTE_GENERO = "genero";
    public static final String COLUMNA_ASISTENTE_INTERESES = "intereses";
    public static final String COLUMNA_ASISTENTE_EPS = "eps";
    public static final String COLUMNA_ASISTENTE_FOTO = "foto";

    public static final String TABLA_GUIA = "guia";
    public static final String COLUMNA_GUIA_ID = "_id";
    public static final String COLUMNA_GUIA_NOMBRE = "nombre";
    public static final String COLUMNA_GUIA_GENERO = "genero";
    public static final String COLUMNA_GUIA_CORREO = "correo";
    public static final String COLUMNA_GUIA_PERFIL = "perfil";
    public static final String COLUMNA_GUIA_FOTO = "foto";
    public static final String COLUMNA_GUIA_CEDULA = "cedula";
    public static final String COLUMNA_GUIA_FECHANAC = "fecha";


    public static final String TABLA_EVENTO = "evento";
    public static final String COLUMNA_EVENTO_ID = "_id";
    public static final String COLUMNA_EVENTO_NOMBRE = "nombre";
    public static final String COLUMNA_EVENTO_DESCRIPCION = "descripcion";
    public static final String COLUMNA_EVENTO_ENCUENTRO = "encuentro";
    public static final String COLUMNA_EVENTO_SUBCATEGORIA = "subcategoria";
    public static final String COLUMNA_EVENTO_FECHAINICIO = "fechainicio";
    public static final String COLUMNA_EVENTO_FECHAFIN = "fechafin";
    public static final String COLUMNA_EVENTO_PRECIO = "precio";
    public static final String COLUMNA_EVENTO_GUIA = "guia_id";

    private static final String SQL_CREAR_EVENTO = "create table"
            + TABLA_EVENTO + "(" + COLUMNA_EVENTO_ID + " integer primary key autoincrement, "
            + COLUMNA_EVENTO_NOMBRE + " text not null,"
            + COLUMNA_EVENTO_DESCRIPCION + " text not null,"
            + COLUMNA_EVENTO_ENCUENTRO + "text not null,"
            + COLUMNA_EVENTO_SUBCATEGORIA+"integer,"
            + COLUMNA_EVENTO_FECHAINICIO + "integer,"
            + COLUMNA_EVENTO_FECHAFIN + "integer,"
            + COLUMNA_EVENTO_PRECIO +  "integer,"
            + "FOREIGN KEY ("+COLUMNA_EVENTO_GUIA + ") REFERENCES" + TABLA_GUIA+"("+COLUMNA_GUIA_ID+"));";

    private static final String SQL_CREAR_ASISTENTE = "create table "
            + TABLA_ASISTENTE + "(" + COLUMNA_ASISTENTE_ID + " integer primary key autoincrement, "
            + COLUMNA_ASISTENTE_NOMBRE + " text not null, "
            + COLUMNA_ASISTENTE_FECHANACIMIENTO + " integer, "
            + COLUMNA_ASISTENTE_CEDULA + " integer not null, "
            + COLUMNA_ASISTENTE_CORREO + " text, "
            + COLUMNA_ASISTENTE_GENERO + " text, "
            + COLUMNA_ASISTENTE_INTERESES + " text, "
            + COLUMNA_ASISTENTE_EPS + " text, "
            + COLUMNA_ASISTENTE_FOTO + " text);";

    private static final String SQL_CREAR_GUIA = "create table"
            + TABLA_GUIA + "(" + COLUMNA_GUIA_ID + " integer primary key autoincrement,"
            + COLUMNA_GUIA_NOMBRE + " text not null, "
            + COLUMNA_GUIA_PERFIL + " text, "
            + COLUMNA_GUIA_CEDULA + "integer not null, "
            + COLUMNA_GUIA_CORREO + " text,"
            + COLUMNA_GUIA_GENERO + " text, "
            + COLUMNA_GUIA_FECHANAC + "integer, "
            + COLUMNA_GUIA_FOTO + " text;";

    private static MiBasedeDatos miBasedeDatos;
    public static MiBasedeDatos getInstance(Context context){
        if(miBasedeDatos ==null){
            miBasedeDatos = new MiBasedeDatos(context);
        }
        return miBasedeDatos;
    }

    private MiBasedeDatos(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREAR_ASISTENTE);

//        sqLiteDatabase.execSQL(SQL_CREAR_EVENTO);
  //      sqLiteDatabase.execSQL(SQL_CREAR_GUIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void CrearEvento(Evento evento) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMNA_EVENTO_NOMBRE, evento.getNombre());
        values.put(COLUMNA_EVENTO_DESCRIPCION, evento.getDescripcion());
        values.put(COLUMNA_EVENTO_ENCUENTRO, evento.getPuntoEncuentro());
        values.put(COLUMNA_EVENTO_FECHAFIN, evento.getFechaFin());
        values.put(COLUMNA_EVENTO_FECHAINICIO, evento.getFechaInicio());
        values.put(COLUMNA_EVENTO_GUIA, evento.getGuia());
        values.put(COLUMNA_EVENTO_ID, evento.getId());
        values.put(COLUMNA_EVENTO_PRECIO, evento.getPrecio());
        values.put(COLUMNA_EVENTO_SUBCATEGORIA, evento.getSubcategoria());

        db.insert(TABLA_EVENTO, null, values);
        db.close();
    }

    public List<Evento> leerEvento() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMNA_EVENTO_ID, COLUMNA_EVENTO_NOMBRE, COLUMNA_EVENTO_DESCRIPCION,COLUMNA_EVENTO_ENCUENTRO,
                                COLUMNA_EVENTO_FECHAFIN,COLUMNA_EVENTO_FECHAINICIO,COLUMNA_EVENTO_GUIA,COLUMNA_EVENTO_PRECIO,
                                COLUMNA_EVENTO_SUBCATEGORIA};
        List<Evento> list = new ArrayList<Evento>();

        Cursor cursor = db.query(TABLA_EVENTO, projection, null, null, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    Integer id = cursor.getInt(cursor.getColumnIndex(COLUMNA_EVENTO_ID));
                    String nombre = cursor.getString(cursor.getColumnIndex(COLUMNA_EVENTO_NOMBRE));
                    String descripcion = cursor.getString(cursor.getColumnIndex(COLUMNA_EVENTO_DESCRIPCION));
                    String encuentro = cursor.getString(cursor.getColumnIndex(COLUMNA_EVENTO_ENCUENTRO));
                    Integer fin = cursor.getInt(cursor.getColumnIndex(COLUMNA_EVENTO_FECHAFIN));
                    Integer inicio = cursor.getInt(cursor.getColumnIndex(COLUMNA_EVENTO_FECHAINICIO));
                    Integer idGuia = cursor.getInt(cursor.getColumnIndex(COLUMNA_EVENTO_GUIA));
                    Integer precio = cursor.getInt(cursor.getColumnIndex(COLUMNA_EVENTO_PRECIO));
                    Integer idSubcategoria = cursor.getInt(cursor.getColumnIndex(COLUMNA_EVENTO_SUBCATEGORIA));

                    Evento evento = new Evento(nombre,descripcion,encuentro,id,idSubcategoria,inicio,fin,precio,idGuia);
                    list.add(evento);
                    cursor.moveToNext();
                }
            }
            db.close();
        }
        return list;
    }

    public void actualizarEvento(Evento evento) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMNA_EVENTO_NOMBRE, evento.getNombre());
        values.put(COLUMNA_EVENTO_DESCRIPCION, evento.getDescripcion());
        values.put(COLUMNA_EVENTO_ENCUENTRO, evento.getPuntoEncuentro());
        values.put(COLUMNA_EVENTO_FECHAFIN, evento.getFechaFin());
        values.put(COLUMNA_EVENTO_FECHAINICIO, evento.getFechaInicio());
        values.put(COLUMNA_EVENTO_PRECIO, evento.getPrecio());
        values.put(COLUMNA_EVENTO_SUBCATEGORIA, evento.getSubcategoria());

        int i = db.update(TABLA_EVENTO, values, "id=?", new String[]{String.valueOf(evento.getId())});
        db.close();
    }

    public boolean eliminarEvento(int id) {

        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.delete(TABLA_EVENTO, "id=?", new String[]{String.valueOf(id)});
            db.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    // Metodos para el crud de la tabla Usuario_Guia

    public  void CrearGuia(Usuario_guia usuarioGuia){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMNA_GUIA_NOMBRE, usuarioGuia.getNombre());
        values.put(COLUMNA_GUIA_GENERO, usuarioGuia.getGenero());
        values.put(COLUMNA_GUIA_CORREO, usuarioGuia.getCorreo());
        values.put(COLUMNA_GUIA_PERFIL, usuarioGuia.getDescripcionPerfil());
        values.put(COLUMNA_GUIA_FOTO, usuarioGuia.getFoto());
        values.put(COLUMNA_GUIA_ID, usuarioGuia.getId());
        values.put(COLUMNA_GUIA_CEDULA, usuarioGuia.getCedula());
        values.put(COLUMNA_GUIA_FECHANAC, usuarioGuia.getFechaNacimiento());

        db.insert(TABLA_ASISTENTE,null,values);
        db.close();
    }


    public List<Usuario_guia> leerGuia(){
        SQLiteDatabase db  = this.getReadableDatabase();
        String[] projection = {COLUMNA_GUIA_ID , COLUMNA_GUIA_NOMBRE, COLUMNA_GUIA_FECHANAC, COLUMNA_GUIA_CEDULA,
                                COLUMNA_GUIA_CORREO,COLUMNA_GUIA_GENERO,COLUMNA_GUIA_PERFIL,COLUMNA_GUIA_FOTO
                               };
        List<Usuario_guia> list = new ArrayList<Usuario_guia>();

        Cursor cursor = db.query(TABLA_GUIA,projection,null,null,null,null,null,null);
        if(cursor != null){
            if(cursor.moveToFirst()){
                while(!cursor.isAfterLast()){
                    String nombre = cursor.getString(cursor.getColumnIndex(COLUMNA_GUIA_NOMBRE));
                    Integer fecha = cursor.getInt(cursor.getColumnIndex(COLUMNA_GUIA_FECHANAC));
                    Integer cedula = cursor.getInt(cursor.getColumnIndex(COLUMNA_GUIA_CEDULA));
                    String correo = cursor.getString(cursor.getColumnIndex(COLUMNA_GUIA_CORREO));
                    String genero = cursor.getString(cursor.getColumnIndex(COLUMNA_GUIA_GENERO));
                    String perfil = cursor.getString(cursor.getColumnIndex(COLUMNA_GUIA_PERFIL));
                    String foto = cursor.getString(cursor.getColumnIndex(COLUMNA_GUIA_FOTO));
                    Integer id = cursor.getInt(cursor.getColumnIndex(COLUMNA_GUIA_ID));

                    Usuario_guia usuarioGuia = new Usuario_guia(nombre, genero,correo,perfil,foto,id,cedula,fecha);
                    list.add(usuarioGuia);
                    cursor.moveToNext();
                }
            }
            db.close();
        }
        return list;
    }

    public void actualizarGuia (Usuario_guia usuarioGuia){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMNA_GUIA_NOMBRE, usuarioGuia.getNombre());
        values.put(COLUMNA_GUIA_GENERO, usuarioGuia.getGenero());
        values.put(COLUMNA_GUIA_FECHANAC, usuarioGuia.getFechaNacimiento());
        values.put(COLUMNA_GUIA_PERFIL, usuarioGuia.getDescripcionPerfil());
        values.put(COLUMNA_GUIA_FOTO, usuarioGuia.getFoto());

        int i = db.update(TABLA_GUIA,values,"id=?",new String[] {String.valueOf(usuarioGuia.getId())});
        db.close();
    }

    public  boolean eliminarGuia(int id){

        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.delete(TABLA_GUIA,"id=?",new String[]{String.valueOf(id)});
            db.close();
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    // Metodos para el crud de la tabla Usuario_asistente

    public  void CrearAsistente(Usuario_asistente usuarioAsistente){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMNA_ASISTENTE_NOMBRE, usuarioAsistente.getName());
        values.put(COLUMNA_ASISTENTE_FECHANACIMIENTO, usuarioAsistente.getFechaNacimiento());
        values.put(COLUMNA_ASISTENTE_CEDULA, usuarioAsistente.getCedula());
        values.put(COLUMNA_ASISTENTE_CORREO, usuarioAsistente.getCorreo());
        values.put(COLUMNA_ASISTENTE_GENERO, usuarioAsistente.getGenero());
        values.put(COLUMNA_ASISTENTE_INTERESES, usuarioAsistente.getIntereses());
        values.put(COLUMNA_ASISTENTE_EPS, usuarioAsistente.getEps());
        values.put(COLUMNA_ASISTENTE_FOTO, usuarioAsistente.getFoto());

        db.insert(TABLA_ASISTENTE,null,values);
        db.close();
    }

    public List<Usuario_asistente> leerAsistente(){
        SQLiteDatabase db  = this.getReadableDatabase();
        String[] projection = {COLUMNA_ASISTENTE_ID , COLUMNA_ASISTENTE_NOMBRE, COLUMNA_ASISTENTE_FECHANACIMIENTO, COLUMNA_ASISTENTE_CEDULA, COLUMNA_ASISTENTE_CORREO,COLUMNA_ASISTENTE_GENERO,COLUMNA_ASISTENTE_INTERESES,COLUMNA_ASISTENTE_FOTO,COLUMNA_ASISTENTE_EPS};
        List<Usuario_asistente> list = new ArrayList<Usuario_asistente>();

        Cursor cursor = db.query(TABLA_ASISTENTE,projection,null,null,null,null,null,null);
        if(cursor != null){
            if(cursor.moveToFirst()){
                while(!cursor.isAfterLast()){
                    String nombre = cursor.getString(cursor.getColumnIndex(COLUMNA_ASISTENTE_NOMBRE));
                    Integer fecha = cursor.getInt(cursor.getColumnIndex(COLUMNA_ASISTENTE_FECHANACIMIENTO));
                    Integer cedula = cursor.getInt(cursor.getColumnIndex(COLUMNA_ASISTENTE_CEDULA));
                    String correo = cursor.getString(cursor.getColumnIndex(COLUMNA_ASISTENTE_CORREO));
                    String genero = cursor.getString(cursor.getColumnIndex(COLUMNA_ASISTENTE_GENERO));
                    String intereses = cursor.getString(cursor.getColumnIndex(COLUMNA_ASISTENTE_INTERESES));
                    String foto = cursor.getString(cursor.getColumnIndex(COLUMNA_ASISTENTE_FOTO));
                    String eps = cursor.getString(cursor.getColumnIndex(COLUMNA_ASISTENTE_EPS));

                    Integer id = cursor.getInt(cursor.getColumnIndex(COLUMNA_ASISTENTE_ID));
                    Usuario_asistente usuarioAsistente = new Usuario_asistente(nombre, fecha, cedula,eps,id,correo,genero,intereses,foto);
                    list.add(usuarioAsistente);
                    cursor.moveToNext();
                }
            }
            db.close();
        }
        return list;
    }

    public void actualizarAsistente (Usuario_asistente usuarioAsistente){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMNA_ASISTENTE_NOMBRE, usuarioAsistente.getName());
        values.put(COLUMNA_ASISTENTE_FECHANACIMIENTO, usuarioAsistente.getFechaNacimiento());
        values.put(COLUMNA_ASISTENTE_EPS, usuarioAsistente.getFechaNacimiento());
        values.put(COLUMNA_ASISTENTE_FOTO, usuarioAsistente.getFechaNacimiento());
        values.put(COLUMNA_ASISTENTE_INTERESES, usuarioAsistente.getFechaNacimiento());
        values.put(COLUMNA_ASISTENTE_EPS, usuarioAsistente.getFechaNacimiento());

        int i = db.update(TABLA_ASISTENTE,values,"id=?",new String[] {String.valueOf(usuarioAsistente.getId())});
        db.close();
    }

    public  boolean eliminarAsistente(int id){

        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.delete(TABLA_ASISTENTE,"id=?",new String[]{String.valueOf(id)});
            db.close();
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    public Cursor leerAsistenteCursor(){

        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMNA_ASISTENTE_ID,COLUMNA_ASISTENTE_NOMBRE,COLUMNA_ASISTENTE_GENERO,COLUMNA_ASISTENTE_CEDULA,
                COLUMNA_ASISTENTE_CORREO,COLUMNA_ASISTENTE_EPS,COLUMNA_ASISTENTE_FECHANACIMIENTO,COLUMNA_ASISTENTE_FOTO,COLUMNA_ASISTENTE_INTERESES};
        List<Usuario_asistente> list = new ArrayList<Usuario_asistente>();
        Cursor cursor = db.query(TABLA_ASISTENTE,projection,null,null,null,null,null,null);

        if (cursor != null){
            cursor.moveToFirst();
        }
        return cursor;
    }
}
