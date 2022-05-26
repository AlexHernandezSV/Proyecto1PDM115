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

    //Campos de ciclo
    private static final String[] camposCiclo = new String[]
            {"id_ciclo", "ciclo","fecha_inicio", "fecha_fin"};
    //Campos de Coordina
    private static final String[] camposCoordina = new String[]
            {"id_actividad", "id_coordinador"};
    //Campos Detalle Actividad Horario
    private static final String[] camposDetalleActividadHorario = new String[]
            {"id_horario", "nombre_actividad"};
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
        //Este método va llevar todo el script de la bd, un desverge xd
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
                        "ID_COORDINADOR       INTEGER              not null,\n" +
                        "NOMBRE_COORDINADOR   VARCHAR2(50)         not null,\n" +
                        "TIPO_MIEMBRO         CHAR(10)             not null,\n" +
                        "primary key (ID_COORDINADOR)\n" +
                        ");");

                //Tabla Horario
                db.execSQL("create table HORARIO (\n" +
                        "ID_HORARIO           INTEGER              not null,\n" +
                        "DESDE_HORARIO        DATE                 not null,\n" +
                        "HASTA_HORARIO        DATE                 not null,\n" +
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
        //hor.put("desde_horario", horario.getDesde_horario());
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


//================================ FINAL - Bloque de todos los INSERT =============================================
}
