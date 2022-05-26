package com.example.proyecto1pdm115;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ControlBD {

//================================ INICIO - Bloque de definición de campos de tablas =============================================

    //Campos de Carrera
    private static final String[] camposCarrera = new String[]
            {"id_carrera", "nombre_carrera"};
    //Campos de Detalle_Oferta
    private static final String[] camposDetalleOferta = new String[]
            {"grupo", "id_materias_activas", "id_aula", "cant_inscritos"};
    //Campos de MiembroUniversitario
    private static final String[] camposMiembroUniversitario = new String[]
            {"id_coordinador", "nombre_coordinador", "tipo_miembro"};
    //Campos de Horario
    private static final String[] camposHorario = new String[]
            {"id_horario", "desde_horario", "hasta_horario"};
    //Agregar los demás campos


//================================ FINAL - Bloque de definición de campos de tablas =============================================

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public ControlBD(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String BASE_DATOS = "grupo12.s3db";
        private static final int VERSION = 1;

        public DatabaseHelper(Context context) {
            super(context, BASE_DATOS, null, VERSION);
        }

//================================ INICIO - Bloque de scripts =============================================

        @Override
        //Este método va llevar todo el script de la bd, un desverge
        public void onCreate(SQLiteDatabase db) {
            try {

                //Tabla Carrera
                db.execSQL("create table CARRERA (\n" +
                        "ID_CARRERA           VARCHAR2(6)          not null,\n" +
                        "NOMBRE_CARRERA       VARCHAR2(50)         not null,\n" +
                        "primary key (ID_CARRERA)\n" +
                        ");");

                //Tabla Detalle_Oferta
                db.execSQL("create table DETALLE_OFERTA (\n" +
                        "GRUPO                CHAR(3)              not null,\n" +
                        "ID_MATERIAS_ACTIVAS  CHAR(6),\n" +
                        "ID_AULA              INTEGER,\n" +
                        "CANT_INSCRITOS       INTEGER              not null,\n" +
                        "primary key (GRUPO),\n" +
                        "foreign key (ID_MATERIAS_ACTIVAS)\n" +
                        "      references OFERTA_ACADEMICA (ID_MATERIAS_ACTIVAS),\n" +
                        "foreign key (ID_AULA)\n" +
                        "      references LOCAL (ID_AULA),\n" +
                        "foreign key (ID_MATERIAS_ACTIVAS)\n" +
                        "      references OFERTA_ACADEMICA (ID_MATERIAS_ACTIVAS)\n" +
                        ");");

                //Tabla Miembro_Universitario
                db.execSQL("create table MIEMBRO_UNIVERSITARIO (\n" +
                        "ID_COORDINADOR       VARCHAR2(3)              not null,\n" +
                        "NOMBRE_COORDINADOR   VARCHAR2(50)         not null,\n" +
                        "TIPO_MIEMBRO         CHAR(10)             not null,\n" +
                        "primary key (ID_COORDINADOR)\n" +
                        ");");

                //Tabla Horario
                db.execSQL("create table HORARIO (\n" +
                        "ID_HORARIO           VARCHAR2(3)              not null,\n" +
                        "DESDE_HORARIO        VARCHAR2(20)                 not null,\n" +
                        "HASTA_HORARIO        VARCHAR2(20)                 not null,\n" +
                        "primary key (ID_HORARIO)\n" +
                        ");");

                //Continuar tablas


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

//================================ FINAL - Bloque de scripts =============================================

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO Auto-generated method stub
        }
    }

    public void abrir() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return;
    }

    public void cerrar() {
        DBHelper.close();
    }

//================================ INICIO - Bloque de todos los INSERT =============================================

    //Insertar Carrera
    public String insertar(Carrera carrera) {
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues carr = new ContentValues();
        carr.put("id_carrera", carrera.getId_carrera());
        carr.put("nombre_carrera", carrera.getNombre_carrera());
        contador=db.insert("CARRERA", null, carr);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    //Insertar Detalle_Oferta
    //La debo porque tiene fks

    //Insertar Miembro_Universitario
    public String insertar(MiembroUniversitario miembroUniversitario) {
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues miem = new ContentValues();
        miem.put("id_coordinador", miembroUniversitario.getId_coordinador());
        miem.put("nombre_coordinador", miembroUniversitario.getNombre_coordinador());
        miem.put("tipo_miembro", miembroUniversitario.getTipo_miembro());
        contador=db.insert("MIEMBRO_UNIVERSITARIO", null, miem);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    //Insertar Horario
    public String insertar(Horario horario) {
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues hor = new ContentValues();
        hor.put("id_horario", horario.getId_horario());
        hor.put("desde_horario", horario.getDesde_horario());
        //hor.put("hasta_horario", horario.getHasta_horario());
        contador=db.insert("HORARIO", null, hor);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

//================================ FINAL - Bloque de todos los INSERT =============================================


//================================ INICIO - Bloque de todos los UPDATE =============================================

    //Actualizar carrera
    public String actualizar(Carrera carrera) {
        if(verificarIntegridad(carrera, 1)){
            String[] id = {carrera.getId_carrera()};
            ContentValues cv = new ContentValues();
            cv.put("nombre_carrera", carrera.getNombre_carrera());
            db.update("CARRERA", cv, "id_carrera = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con ID " + carrera.getId_carrera() + " no existe";
        }
    }

    //Insertar Detalle_Oferta
    //La debo porque tiene fks

    //Actualizar Miembro_Universitario
    public String actualizar(MiembroUniversitario miembroUniversitario) {
        if(verificarIntegridad(miembroUniversitario, 2)){
            String[] id = {miembroUniversitario.getId_coordinador()};
            ContentValues cv = new ContentValues();
            cv.put("nombre_coordinador", miembroUniversitario.getNombre_coordinador());
            cv.put("tipo_miembro", miembroUniversitario.getTipo_miembro());
            db.update("MIEMBRO_UNIVERSITARIO", cv, "id_coordinador = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con ID " + miembroUniversitario.getId_coordinador() + " no existe";
        }
    }

    //Actualizar Horario
    public String actualizar(Horario horario) {
        if(verificarIntegridad(horario, 3)){
            String[] id = {horario.getId_horario()};
            ContentValues cv = new ContentValues();
            cv.put("desde_horario", horario.getDesde_horario());
            cv.put("hasta_horario", horario.getHasta_horario());
            db.update("HORARIO", cv, "id_horario = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con ID " + horario.getId_horario() + " no existe";
        }
    }

//================================ FINAL - Bloque de todos los UPDATE =============================================


//================================ INICIO - Bloque de verificar integridad =============================================

    private boolean verificarIntegridad(Object dato, int relacion) throws SQLException {
        switch (relacion) {

            case 1: {
//verificar que exista carrera
                Carrera carrera2 = (Carrera) dato;
                String[] id = {carrera2.getId_carrera()};
                abrir();
                Cursor c2 = db.query("CARRERA", null, "id_carrera = ?", id, null, null,
                        null);
                if (c2.moveToFirst()) {
//Se encontro Carrera
                    return true;
                }
                return false;
            }

            case 2: {
//verificar que exista miembroUniversitario
                MiembroUniversitario miembroUniversitario2 = (MiembroUniversitario) dato;
                String[] id = {miembroUniversitario2.getId_coordinador()};
                abrir();
                Cursor c2 = db.query("MIEMBRO_UNIVERSITARIO", null, "id_coordinador = ?", id, null, null,
                        null);
                if (c2.moveToFirst()) {
//Se encontro miembro
                    return true;
                }
                return false;
            }

            case 3: {
//verificar que exista horario
                Horario horario2 = (Horario) dato;
                String[] id = {horario2.getId_horario()};
                abrir();
                Cursor c2 = db.query("HORARIO", null, "id_horario = ?", id, null, null,
                        null);
                if (c2.moveToFirst()) {
//Se encontro horario
                    return true;
                }
                return false;
            }

            default:
                return false;
        }
    }


//================================ FINAL - Bloque de verificar integridad =============================================

}
