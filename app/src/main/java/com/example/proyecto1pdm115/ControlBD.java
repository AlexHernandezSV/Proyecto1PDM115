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
    //Campos de Materia
    private static final String[] camposMateria = new String[]
            {"id_materia", "id_escuela", "nombre_materia", "ciclo_materia"};
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

                //Tabla Materia
                db.execSQL("create table MATERIA (\n" +
                        "ID_MATERIA           CHAR(6)              not null, \n" +
                        "ID_ESCUELA           INTEGER,\n" +
                        "NOMBRE_MATERIA       VARCHAR2(50)         not null,\n" +
                        "CICLO_MATERIA        INTEGER              not null,\n" +
                        "primary key (ID_MATERIA),\n" +
                        "foreign key (ID_ESCUELA)\n" +
                        "      references ESCUELA (ID_ESCUELA));");

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

    //Insertar materia
    public String insertar(Materia materia) {
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues mat = new ContentValues();
        mat.put("id_materia", materia.getId_materia());
        mat.put("id_escuela", materia.getId_escuela());
        mat.put("nombre_materia", materia.getNombre_materia());
        mat.put("ciclo_materia", materia.getCiclo_materia());
        contador=db.insert("MATERIA", null, mat);
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

    //Actualizar Materia
    public String actualizar(Materia materia){
        if(verificarIntegridad(materia, 4)){
            String[] id = {materia.getId_materia()};
            ContentValues cv = new ContentValues();
            cv.put("id_materia", materia.getId_materia());
            cv.put("id_escuela", materia.getId_escuela());
            cv.put("nombre_materia", materia.getNombre_materia());
            cv.put("ciclo_materia", materia.getCiclo_materia());
            db.update("MATERIA", cv, "id_materia = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con ID de materia " + materia.getId_materia() + " no existe";
        }
    }

//================================ FINAL - Bloque de todos los UPDATE =============================================


//================================ INICIO - Bloque de todos los DELETE =============================================

    //Eliminar carrera
    public String eliminar(Carrera carrera) {
        String regAfectados="filas afectadas= ";
        int contador=0;
        if (verificarIntegridad(carrera,5)) {
            contador+=db.delete("ESCUELA", "id_carrera='"+carrera.getId_carrera()+"'", null);
        }
        contador+=db.delete("CARRERA", "id_carrera='"+carrera.getId_carrera()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }

    //Eliminar DetalleOferta


    //Eliminar Miembro_Universitario
    public String eliminar(MiembroUniversitario miembroUniversitario) {
        String regAfectados="filas afectadas= ";
        int contador=0;
        if (verificarIntegridad(miembroUniversitario,6)) {
            contador+=db.delete("COORDINA", "id_coordinador='"+miembroUniversitario.getId_coordinador()+"'", null);
        }
        if (verificarIntegridad(miembroUniversitario,7)) {
                contador+=db.delete("DETALLE_RESPONSABLE", "id_coordinador='"+miembroUniversitario.getId_coordinador()+"'", null);
        }
        contador+=db.delete("MIEMBRO_UNIVERSITARIO", "id_coordinador='"+miembroUniversitario.getId_coordinador()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }

    //Eliminar Horario
    public String eliminar(Horario horario) {
        String regAfectados="filas afectadas= ";
        int contador=0;
        if (verificarIntegridad(horario,8)) {
            contador+=db.delete("DETALLE_ACTIVIDAD_HORARIO", "id_horario='"+horario.getId_horario()+"'", null);
        }
        contador+=db.delete("HORARIO", "id_horario='"+horario.getId_horario()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }

    //Eliminar Materia
    public String eliminar(Materia materia) {
        String regAfectados="filas afectadas= ";
        int contador=0;
        if (verificarIntegridad(materia,9)) {
            contador+=db.delete("materia", "id_materia='"+materia.getId_materia()+"'", null);
        }
        contador+=db.delete("materia", "id_materia='"+materia.getId_materia()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }

//================================ FINAL - Bloque de todos los DELETE =============================================


//================================ INICIO - Bloque de todos los READ =============================================

    //Consultar Carrera
    public Carrera consultarCarrera(String id_carrera) {
        String[] id = {id_carrera};
        Cursor cursor = db.query("CARRERA", camposCarrera, "id_carrera = ?",
                id, null, null, null);
        if(cursor.moveToFirst()){
            Carrera carrera = new Carrera();
            carrera.setId_carrera(cursor.getString(0));
            carrera.setNombre_carrera(cursor.getString(1));
            return carrera;
        }else{
            return null;
        }
    }

    //Consultar Detalle_Oferta


    //Consultar Miembro_Universitario
    public MiembroUniversitario consultarMiembroUniversitario(String id_coordinador) {
        String[] id = {id_coordinador};
        Cursor cursor = db.query("MIEMBRO_UNIVERSITARIO", camposMiembroUniversitario, "id_coordinador = ?",
                id, null, null, null);
        if(cursor.moveToFirst()){
            MiembroUniversitario miembroUniversitario = new MiembroUniversitario();
            miembroUniversitario.setId_coordinador(cursor.getString(0));
            miembroUniversitario.setNombre_coordinador(cursor.getString(1));
            miembroUniversitario.setTipo_miembro(cursor.getString(2));
            return miembroUniversitario;
        }else{
            return null;
        }
    }

    //Consultar Horario
    public Horario consultarHorario(String id_horario) {
        String[] id = {id_horario};
        Cursor cursor = db.query("HORARIO", camposHorario, "id_horario = ?",
                id, null, null, null);
        if(cursor.moveToFirst()){
            Horario horario = new Horario();
            horario.setId_horario(cursor.getString(0));
            horario.setDesde_horario(cursor.getString(1));
            horario.setHasta_horario(cursor.getString(2));
            return horario;
        }else{
            return null;
        }
    }

    //Consultar Materia
    public Materia consultarMateria(String id_materia){
        String[] id = {id_materia};
        Cursor cursor = db.query("MATERIA", camposMateria, "id_materia = ?",
                id, null, null, null);
        if(cursor.moveToFirst()){
            Materia materia = new Materia();
            materia.setId_escuela(cursor.getInt(0));
            materia.setNombre_materia(cursor.getString(1));
            materia.setCiclo_materia(cursor.getInt(2));
            return materia;
        }else{
            return null;
        }
    }


//================================ FINAL - Bloque de todos los READ =============================================



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

            case 4: {
                //Verificaciòn de que si existe Carrera dentro de Escuela al eliminar una carrera
                Carrera carrera = (Carrera) dato;
                Cursor c = db.query(true, "ESCUELA", new String[]{
                                "id_carrera"}, "id_carrera='" + carrera.getId_carrera() + "'", null,
                        null, null, null, null);
                if (c.moveToFirst())
                    return true;
                else
                    return false;
            }

            case 5: {
                //Verificaciòn de que si existe MiembroUniversitario dentro de Coordina al eliminar un miembro
                MiembroUniversitario miembroUniversitario = (MiembroUniversitario) dato;
                Cursor c = db.query(true, "COORDINA", new String[]{
                                "id_coordinador"}, "id_coordinador='" + miembroUniversitario.getId_coordinador() + "'", null,
                        null, null, null, null);
                if (c.moveToFirst())
                    return true;
                else
                    return false;
            }

            case 6: {
                //Verificaciòn de que si existe MiembroUniversitario dentro de Detalle_Responsable al eliminar un miembro
                MiembroUniversitario miembroUniversitario = (MiembroUniversitario) dato;
                Cursor c = db.query(true, "DETALLE_RESPONSABLE", new String[]{
                                "id_coordinador"}, "id_coordinador='" + miembroUniversitario.getId_coordinador() + "'", null,
                        null, null, null, null);
                if (c.moveToFirst())
                    return true;
                else
                    return false;
            }

            case 7: {
                //Verificaciòn de que si existe Horario dentro de Detalle_Actividad_Horario al eliminar un horario
                Horario horario = (Horario) dato;
                Cursor c = db.query(true, "DETALLE_ACTIVIDAD_HORARIO", new String[]{
                                "id_horario"}, "id_horario='" + horario.getId_horario() + "'", null,
                        null, null, null, null);
                if (c.moveToFirst())
                    return true;
                else
                    return false;
            }
            case 8: {
//verificar que exista Materia
                Materia materia = (Materia) dato;
                String[] id = {materia.getId_materia()};
                abrir();
                Cursor c2 = db.query("MATERIA", null, "id_materia = ?", id, null, null,
                        null);
                if (c2.moveToFirst()) {
//Se encontro Carrera
                    return true;
                }
                return false;
            }

            default:
                return false;
        }
    }


//================================ FINAL - Bloque de verificar integridad =============================================


//================================ INICIO - Bloque de llenado de datos =============================================

    public String llenarBDCarnet() {

        //Tabla Carrera
        final String[] Carreraid_carrera = {"I10515", "I10501", "I10502"};
        final String[] Carreranombre_carrera = {"Ingeniería de Sistemas Informáticos", "Ingeniería Civil", "Ingeniería Industrial"};

        //Tabla Detalle_Oferta

        //Tabla Miembro_Universitario
        final String[] Miembroid_coordinador = {"001", "002", "003"};
        final String[] Miembronombre_coordinador = {"Juan","Raquel","Pablo"};
        final String[] Miembrotipo_miembro = {"Docente","Administrativo","Estudiante"};

        //Tabla Horario
        final String[] Horarioid_horario = {"001","002","003"};
        final String[] Horariodesde_horario = {"8:00","9:50","13:20"};
        final String[] Horariohasta_horario = {"9:45","11:30","15:00"};

        //Tabla Materia
        final  String[] Materiaid_materia = {"MAT115","FIR315","TAD115","SYP115"};
        final  int[] Materiaid_escuela = {1,1,5,5};
        final  String[] Materianombre_materia = {"Matematicas 1","Fisica 3","Teoria Administrativa","Sistemas y Procedimientos"};
        final  int[] Materiaciclo_materia = {1,2,1,1};

        abrir();
        db.execSQL("DELETE FROM carrera");
        //Falta Detalle_Oferta
        db.execSQL("DELETE FROM miembroUniversitario");
        db.execSQL("DELETE FROM Horario");
        db.execSQL("DELETE FROM Materia");


        Carrera carrera = new Carrera();
        for (int i = 0; i < 2; i++) {
            carrera.setId_carrera(Carreraid_carrera[i]);
            carrera.setNombre_carrera(Carreranombre_carrera[i]);
            insertar(carrera);
        }

        //Falta Detalle_Oferta

        MiembroUniversitario miembroUniversitario = new MiembroUniversitario();
        for (int i = 0; i < 3; i++) {
            miembroUniversitario.setId_coordinador(Miembroid_coordinador[i]);
            miembroUniversitario.setNombre_coordinador(Miembronombre_coordinador[i]);
            miembroUniversitario.setTipo_miembro(Miembrotipo_miembro[i]);
            insertar(miembroUniversitario);
        }

        Horario horario = new Horario();
        for (int i = 0; i < 3; i++) {
            horario.setId_horario(Horarioid_horario[i]);
            horario.setDesde_horario(Horariodesde_horario[i]);
            horario.setHasta_horario(Horariohasta_horario[i]);
            insertar(horario);
        }


        Materia materia = new Materia();
        for (int i = 0; i < 4; i++) {
            materia.setId_materia(Materiaid_materia[i]);
            materia.setId_escuela(Materiaid_escuela[i]);
            materia.setNombre_materia(Materianombre_materia[i]);
            materia.setCiclo_materia(Materiaciclo_materia[i]);
            insertar(materia);
        }

        cerrar();
        return "Guardo Correctamente";
    }

//================================ FINAL - Bloque de llenado de datos =============================================

}
