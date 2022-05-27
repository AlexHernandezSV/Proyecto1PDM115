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
                        "ID_AULA              CHAR(7),\n" +
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

                //Tabla Ciclo
                db.execSQL("create table CICLO (\n" +
                        "ID_CICLO           VARCHAR2(6)          not null, \n" +
                        "CICLO              VARCHAR2(6)         not null,\n" +
                        "FECHA_INICIO       VARCHAR2(20)         not null,\n" +
                        "FECHA_FIN          VARCHAR2(20)              not null,\n" +
                        "primary key (ID_CICLO)\n" +
                        ");");

                //Tabla Coordina
                db.execSQL("create table COORDINA (\n" +
                        "ID_ACTIVIDAD          VARCHAR2(6)          not null, \n" +
                        "ID_COORDINADOR          VARCHAR2(6)          not null, \n" +
                        "primary key (ID_ACTIVIDAD,ID_COORDINADOR),\n" +
                        "foreign key (ID_ACTIVIDAD)\n" +
                        "      references ACTIVIDAD (ID_ACTIVIDAD),\n" +
                        "foreign key (ID_COORDINADOR)\n" +
                        "      references MIEMBRO_UNIVERSITARIO (ID_COORDINADOR)\n" +
                        ");");

                //Tabla DETALLE_ACTIVIDAD_HORARIO
                db.execSQL("create table DETALLE_ACTIVIDAD_HORARIO (\n" +
                        "ID_HORARIO          VARCHAR2(6)          not null, \n" +
                        "ID_ACTIVIDAD          VARCHAR2(6)          not null, \n" +
                        "foreign key (ID_HORARIO)\n" +
                        "      references HORARIO (ID_HORARIO),\n" +
                        "foreign key (ID_ACTIVIDAD)\n" +
                        "      references ACTIVIDAD (ID_ACTIVIDAD)\n" +
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
    public String insertar(DetalleOferta detalleOferta) {
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        if(verificarIntegridad(detalleOferta,9))
        {
            ContentValues detalleOfertas = new ContentValues();
            detalleOfertas.put("grupo", detalleOferta.getGrupo());
            detalleOfertas.put("id_materias_activas", detalleOferta.getId_materias_activas());
            detalleOfertas.put("id_aula", detalleOferta.getId_aula());
            detalleOfertas.put("cant_inscritos", detalleOferta.getCant_inscritos());
            contador=db.insert("DETALLE_OFERTA", null, detalleOfertas);
        }
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

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
        hor.put("hasta_horario", horario.getHasta_horario());
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

    //Insertar Ciclo
    public String insertar(Ciclo ciclo) {
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues cic = new ContentValues();
        cic.put("id_ciclo", ciclo.getId_ciclo());
        cic.put("ciclo", ciclo.getCiclo());
        cic.put("fecha_inicio", ciclo.getFecha_inicio());
        cic.put("fecha_fin", ciclo.getFecha_fin());
        contador=db.insert("CICLO", null, cic);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    //Insertar Coordina
    public String insertar(Coordina coordina) {
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues coor = new ContentValues();
        coor.put("id_actividad", coordina.getId_actividad());
        coor.put("id_coordinador", coordina.getId_coordinador());
        contador=db.insert("COORDINA", null, coor);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }


    //Insertar Detalle Actividad Horario
    public String insertar(DetalleActividadHorario detalleActividadHorario) {
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues det = new ContentValues();
        det.put("id_horario", detalleActividadHorario.getId_horario());
        det.put("id_actividad", detalleActividadHorario.getId_actividad());
        contador=db.insert("DETALLE_ACTIVIDAD_HORARIO", null, det);
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

    //Actualizar Detalle_Oferta
    public String actualizar(DetalleOferta detalleOferta) {
        if(verificarIntegridad(detalleOferta, 10)){
            String[] id = {detalleOferta.getId_aula(), detalleOferta.getId_materias_activas(),
                    detalleOferta.getGrupo()};
            ContentValues cv = new ContentValues();
            cv.put("cant_inscritos", detalleOferta.getCant_inscritos());
            db.update("DETALLE_OFERTA", cv, "id_aula = ? AND id_materias_activas = ? AND grupo = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro no Existe";
        }
    }

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
        if(verificarIntegridad(materia, 8)){
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


//    //Actualizar Ciclo
//    public String actualizar(Ciclo ciclo){
//        if(verificarIntegridad(ciclo, pone bien el case de acá)){
//            String[] id = {ciclo.getId_materia()};
//            ContentValues cv = new ContentValues();
//            cv.put("id_materia", materia.getId_materia());
//            cv.put("id_escuela", materia.getId_escuela());
//            cv.put("nombre_materia", materia.getNombre_materia());
//            cv.put("ciclo_materia", materia.getCiclo_materia());
//            db.update("MATERIA", cv, "id_materia = ?", id);
//            return "Registro Actualizado Correctamente";
//        }else{
//            return "Registro con ID de materia " + materia.getId_materia() + " no existe";
//        }
//    }



//================================ FINAL - Bloque de todos los UPDATE =============================================


//================================ INICIO - Bloque de todos los DELETE =============================================

    //Eliminar carrera
    public String eliminar(Carrera carrera) {
        String regAfectados="filas afectadas= ";
        int contador=0;
        if (verificarIntegridad(carrera,4)) {
            contador+=db.delete("ESCUELA", "id_carrera='"+carrera.getId_carrera()+"'", null);
        }
        contador+=db.delete("CARRERA", "id_carrera='"+carrera.getId_carrera()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }

    //Eliminar DetalleOferta
    public String eliminar(DetalleOferta detalleOferta) {
        String regAfectados="filas afectadas= ";
        int contador=0;
        if (verificarIntegridad(detalleOferta,11)){
            contador+=db.delete("ACTIVIDAD", "grupo='"+detalleOferta.getGrupo()+"'", null);
        }
        if (verificarIntegridad(detalleOferta,12)){
            contador+=db.delete("TIPO_GRUPO", "grupo='"+detalleOferta.getGrupo()+"'", null);
        }
        String where="id_materias_activas='"+detalleOferta.getId_materias_activas()+"'";
        where=where+" AND id_aula='"+detalleOferta.getId_aula()+"'";
        where=where+" AND grupo="+detalleOferta.getGrupo();
        contador+=db.delete("DETALLE_OFERTA", where, null);
        regAfectados+=contador;
        return regAfectados;
    }


    //Eliminar Miembro_Universitario
    public String eliminar(MiembroUniversitario miembroUniversitario) {
        String regAfectados="filas afectadas= ";
        int contador=0;
        if (verificarIntegridad(miembroUniversitario,5)) {
            contador+=db.delete("COORDINA", "id_coordinador='"+miembroUniversitario.getId_coordinador()+"'", null);
        }
        if (verificarIntegridad(miembroUniversitario,6)) {
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
        if (verificarIntegridad(horario,7)) {
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


//================================ INICIO - Bloque de todos los Consultar =============================================

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
    public DetalleOferta consultarDetalleOferta(String id_materias_activas, String id_aula, String grupo) {
        String[] id = {id_materias_activas, id_aula, grupo};
        Cursor cursor = db.query("DETALLE_OFERTA", camposDetalleOferta, "id_materias_activas = ? AND id_aula = ? AND grupo = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            DetalleOferta detalleOferta = new DetalleOferta();
            detalleOferta.setGrupo(cursor.getString(0));
            detalleOferta.setId_materias_activas(cursor.getString(1));
            detalleOferta.setId_aula(cursor.getString(2));
            detalleOferta.setCant_inscritos(cursor.getInt(3));
            return detalleOferta;
        }else{
            return null;
        }
    }

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

    //Consultar Ciclo
    public Ciclo consultarCiclo(String id_ciclo){
        String[] id = {id_ciclo};
        Cursor cursor = db.query("CICLO", camposCiclo, "id_ciclo = ?",
                id, null, null, null);
        if(cursor.moveToFirst()){
            Ciclo ciclo= new Ciclo();
            ciclo.setId_ciclo(cursor.getString(0));
            ciclo.setCiclo(cursor.getString(1));
            ciclo.setFecha_inicio(cursor.getString(2));
            ciclo.setFecha_fin(cursor.getString(3));
            return ciclo;
        }else{
            return null;
        }
    }

    //Consultar Coordina
    public Coordina consultarCoordina(String id_actividad){
        String[] id = {id_actividad};
        Cursor cursor = db.query("COORDINA", camposCoordina, "id_actividad = ?",
                id, null, null, null);
        if(cursor.moveToFirst()){
            Coordina coordina= new Coordina();
            coordina.setId_actividad(cursor.getString(0));
            coordina.setId_coordinador(cursor.getString(1));
            return coordina;
        }else{
            return null;
        }
    }


    //Consultar Detalle_Actividad_Horario
    public DetalleActividadHorario consultarDetalleActividadHorario(String id_horario){
        String[] id = {id_horario};
        Cursor cursor = db.query("DETALLE_ACTIVIDAD_HORARIO", camposDetalleActividadHorario, "id_horario = ?",
                id, null, null, null);
        if(cursor.moveToFirst()){
            DetalleActividadHorario detalleActividadHorario= new DetalleActividadHorario();
            detalleActividadHorario.setId_horario(cursor.getString(0));
            detalleActividadHorario.setId_actividad(cursor.getString(1));
            return detalleActividadHorario;
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
//Se encontro Materia
                    return true;
                }
                return false;
            }
            case 9: {
//verificar que al insertar Detalle_Oferta exista Actividad y Tipo_Grupo
                DetalleOferta detalleOferta = (DetalleOferta) dato;
                String[] id1 = {detalleOferta.getId_materias_activas()};
                String[] id2 = {detalleOferta.getId_aula()};
//abrir();
                Cursor cursor1 = db.query("OFERTA_ACADEMICA", null, "id_materias_activas = ?", id1, null,
                        null, null);
                Cursor cursor2 = db.query("LOCAL", null, "id_aula = ?", id2,
                        null, null, null);
                if (cursor1.moveToFirst() && cursor2.moveToFirst()) {
//Se encontraron datos
                    return true;
                }
                return false;

            }
            case 10: {
//verificar que al modificar Detalle_Oferta exista Actividad y Tipo_Grupo
                DetalleOferta detalleOferta1 = (DetalleOferta) dato;
                String[] ids = {detalleOferta1.getId_materias_activas(), detalleOferta1.getId_aula(),
                        detalleOferta1.getGrupo()};
                abrir();
                Cursor c = db.query("DETALLE_OFERTA", null, "id_materias_activas = ? AND id_aula = ? AND grupo = ? ", ids, null, null, null);
                if (c.moveToFirst()) {
//Se encontraron datos
                    return true;
                }
                return false;
            }
            case 11: {
                //Verificaciòn de que si existe Detalle_Oferta dentro de Actividad al eliminar un Detalle_Oferta
                DetalleOferta detalleOferta = (DetalleOferta) dato;
                Cursor c = db.query(true, "ACTIVIDAD", new String[]{
                                "grupo"}, "grupo='" + detalleOferta.getGrupo() + "'", null,
                        null, null, null, null);
                if (c.moveToFirst())
                    return true;
                else
                    return false;
            }
            case 12: {
                //Verificaciòn de que si existe Detalle_Oferta dentro de Tipo_Grupo al eliminar un Detalle_Oferta
                DetalleOferta detalleOferta = (DetalleOferta) dato;
                Cursor c = db.query(true, "TIPO_GRUPO", new String[]{
                                "grupo"}, "grupo='" + detalleOferta.getGrupo() + "'", null,
                        null, null, null, null);
                if (c.moveToFirst())
                    return true;
                else
                    return false;
            }

            default:
                return false;
        }
    }


//================================ FINAL - Bloque de verificar integridad =============================================


//================================ INICIO - Bloque de llenado de datos =============================================

    public String llenarBD() {

        //Tabla Carrera
        final String[] Carreraid_carrera = {"I10515", "I10501", "I10502"};
        final String[] Carreranombre_carrera = {"Ingenieria de Sistemas Informaticos", "Ingenieria Civil", "Ingenieria Industrial"};

        //Tabla Detalle_Oferta
        final String[] DetalleOfertagrupo = {"G01","G02","G03"};
        final String[] DetalleOfertaid_materias_activas = {"PRN115","FIR115","MEP115"}; //fk
        final String[] DetalleOfertaid_aula = {"B-11","B-21","B-22"}; //fk
        final int[] DetalleOfertacant_inscritos = {100,80,70};


        //Tabla Miembro_Universitario
        final String[] Miembroid_coordinador = {"M01", "M02", "M03"};
        final String[] Miembronombre_coordinador = {"Juan","Raquel","Pablo"};
        final String[] Miembrotipo_miembro = {"Docente","Administrativo","Estudiante"};

        //Tabla Horario
        final String[] Horarioid_horario = {"H01","H02","H03"};
        final String[] Horariodesde_horario = {"8:00","9:50","13:20"};
        final String[] Horariohasta_horario = {"9:45","11:30","15:00"};

        //Tabla Materia
        final  String[] Materiaid_materia = {"MAT115","FIR315","TAD115","SYP115"};
        final  int[] Materiaid_escuela = {1,1,5,5};
        final  String[] Materianombre_materia = {"Matematicas 1","Fisica 3","Teoria Administrativa","Sistemas y Procedimientos"};
        final  int[] Materiaciclo_materia = {1,2,1,1};

        abrir();
        db.execSQL("DELETE FROM CARRERA");
        db.execSQL("DELETE FROM DETALLE_OFERTA");
        db.execSQL("DELETE FROM MIEMBRO_UNIVERSITARIO");
        db.execSQL("DELETE FROM HORARIO");
        db.execSQL("DELETE FROM MATERIA");

        Carrera carrera = new Carrera();
        for (int i = 0; i < 3; i++) {
            carrera.setId_carrera(Carreraid_carrera[i]);
            carrera.setNombre_carrera(Carreranombre_carrera[i]);
            insertar(carrera);
        }

        DetalleOferta detalleOferta = new DetalleOferta();
        for (int i = 0; i < 3; i++) {
            detalleOferta.setGrupo(DetalleOfertagrupo[i]);
            detalleOferta.setId_materias_activas(DetalleOfertaid_materias_activas[i]);
            detalleOferta.setId_aula(DetalleOfertaid_aula[i]);
            detalleOferta.setCant_inscritos(DetalleOfertacant_inscritos[i]);
            insertar(detalleOferta);
        }

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
