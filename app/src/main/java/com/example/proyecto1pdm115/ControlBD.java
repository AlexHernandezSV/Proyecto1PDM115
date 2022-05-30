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
    //Campos de Encargado
    private static final String[] camposEncargado = new String[]
            {"id_reservante", "id_usuario", "nombre_reservante", "tipo_reservante"};
    //Agregar los demás campos
    //Campos de Escuela
    private static final String[] camposEscuela = new String[]
            {"id_escuela", "id_carrera", "nombre_escuela"};

    //Campos Detalle Actividad
    private static final String[] camposDetalleActividad = new String[]
            {"id_detalle", "id_aula", "id_actividad", "participantes"};
    //Campos Actividad
    private static final String[] camposActividad = new String[]
            {"id_actividad","id_tipo_actividad","id_valoracion","id_reservante","grupo","descripcion","estado","fecha_actividad","desde_actividad","hasta_actividad"};
    //Campos Detalle Responsable
    private static final String[] camposDetalleResponsable = new String[]
            {"id_detalle_responsable", "id_coordinador", "nomb_tipo_responsable"};

    //Campos de Tipo Grupo
    private static final String[] camposTipoGrupo = new String[]
            {"id_tipo_grupo", "grupo", "nombre_tipo_grupo"};
    //Campos de Tipo Actividad
    private static final String[] camposTipoActividad = new String[]
            {"id_tipo_actividad", "nombre_tipo_actividad"};

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
                        "ID_COORDINADOR       VARCHAR2(3)          not null,\n" +
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
                        "ID_ESCUELA           VARCHAR(6)           not null,\n" +
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

                //Tabla ACTIVIDAD
                db.execSQL("create table ACTIVIDAD (\n" +
                                "ID_ACTIVIDAD          VARCHAR2(6)          not null, \n" +
                                "ID_TIPO_ACTIVIDAD     VARCHAR2(6)          not null, \n" +
                                "ID_VALORACION         VARCHAR2(6)          not null, \n" +
                                "ID_RESERVANTE         VARCHAR2(6)          not null, \n" +
                                "GRUPO                 CHAR(3)              not null, \n" +
                                "DESCRIPCION           VARCHAR2(50)         not null, \n" +
                                "ESTADO                VARCHAR2(10)         not null, \n" +
                                "FECHA_ACTIVIDAD       VARCHAR(20)          not null, \n" +
                                "DESDE_ACTIVIDAD       VARCHAR(20)          not null, \n" +
                                "HASTA_ACTIVIDAD       VARCHAR(20)          not null, \n" +
                        "primary key (ID_ACTIVIDAD),\n" +
                        "foreign key (ID_TIPO_ACTIVIDAD)\n" +
                        "      references TIPO_ACTIVIDAD (ID_TIPO_ACTIVIDAD),\n" +
                        "foreign key (ID_VALORACION)\n" +
                        "      references VALORACION (ID_VALORACION),\n" +
                        "foreign key (ID_RESERVANTE)\n" +
                        "      references ENCARGADO (ID_RESERVANTE),\n" +
                        "foreign key (GRUPO)\n" +
                        "references DETALLE_OFERTA (GRUPO)\n" +
                        ");");

                //Tabla ESCUELA
                db.execSQL("create table ESCUELA (\n" +
                                "ID_ESCUELA           VARCHAR2(6)          not null, \n" +
                                "ID_CARRERA           VARCHAR2(6)          not null, \n" +
                                "NOMBRE_ESCUELA       VARCHAR2(50)         not null, \n" +
                                "primary key (ID_ESCUELA), \n" +
                        "foreign key (ID_CARRERA)\n"+
                        "references CARRERA (ID_CARRERA)\n"+
                        ");");

                //Tabla DETALLE RESPONSABLE
                db.execSQL("create table DETALLE_RESPONSABLE(\n" +
                        "ID_DETALLE_RESPONSABLE CHAR(10)           not null, \n" +
                        "ID_COORDINADOR         VARCHAR2(3)         not null, \n" +
                        "NOMB_TIPO_RESPONSABLE CHAR(10)            not null, \n" +
                        "primary key (ID_DETALLE_RESPONSABLE), \n" +
                        "foreign key (ID_COORDINADOR)\n"+
                        "references MIEMBRO_UNIVERSITARIO (ID_COORDINADOR)\n"+
                        ");");

                //Tabla TIPO ACTIVIDAD
                db.execSQL("create table TIPO_ACTIVIDAD (\n" +
                        "ID_TIPO_ACTIVIDAD     VARCHAR2(6)              not null, \n" +
                        "NOMBRE_TIPO_ACTIVIDAD VARCHAR2(50)         not null,\n" +
                        "primary key (ID_TIPO_ACTIVIDAD)\n" +
                        ");");

                //Tabla ENCARGADO
                db.execSQL("create table ENCARGADO (\n" +
                        "ID_RESERVANTE        VARCHAR2(7)              not null, \n" +
                        "ID_USUARIO           VARCHAR2(7)           not null,\n" +
                        "NOMBRE_RESERVANTE       VARCHAR2(50)         not null,\n" +
                        "TIPO_RESERVANTE         VARCHAR2(10)              not null,\n" +
                        "primary key (ID_RESERVANTE),\n" +
                        "foreign key (ID_USUARIO)\n" +
                        "      references USUARIO (ID_USUARIO));");

                //Tabla DETALLE ACTIVIDAD
                db.execSQL("create table DETALLE_ACTIVIDAD (\n" +
                        "ID_DETALLE           VARCHAR2(4)              not null, \n" +
                        "ID_AULA           VARCHAR2(6)           not null,\n" +
                        "ID_ACTIVIDAD       VARCHAR2(4)         not null,\n" +
                        "PARTICIPANTES        INTEGER              not null,\n" +
                        "primary key (ID_DETALLE),\n" +
                        "foreign key (ID_AULA)\n" +
                        "      references LOCAL (ID_AULA),\n" +
                        "foreign key (ID_ACTIVIDAD)\n" +
                        "      references ACTIVIDAD (ID_ACTIVIDAD));");

                //Tabla Tipo Grupo
                db.execSQL("create table TIPO_GRUPO (\n" +
                        "ID_TIPO_GRUPO           CHAR(2)              not null, \n" +
                        "GRUPO           VARCHAR(3),\n" +
                        "NOMBRE_TIPO_GRUPO       VARCHAR2(50)         not null,\n" +
                        "primary key (ID_TIPO_GRUPO),\n" +
                        "foreign key (GRUPO)\n" +
                        "      references DETALLE_OFERTA (GRUPO));");

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

    //Insertar Escuela
    public String insertar(Escuela escuela) {
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues esc = new ContentValues();
        esc.put("id_escuela", escuela.getId_escuela());
        esc.put("id_carrera", escuela.getId_carrera());
        esc.put("nombre_escuela", escuela.getNombre_escuela());
        contador=db.insert("ESCUELA", null, esc);
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
        //if(verificarIntegridad(detalleOferta,9))
        //{
            ContentValues detalleOfertas = new ContentValues();
            detalleOfertas.put("grupo", detalleOferta.getGrupo());
            detalleOfertas.put("id_materias_activas", detalleOferta.getId_materias_activas());
            detalleOfertas.put("id_aula", detalleOferta.getId_aula());
            detalleOfertas.put("cant_inscritos", detalleOferta.getCant_inscritos());
            contador=db.insert("DETALLE_OFERTA", null, detalleOfertas);
        //}
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
    public String insertar(Materia materia){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        /*if(verificarIntegridad(materia,31))
        {
            ContentValues materias = new ContentValues();
            materias.put("id_materia", materia.getId_materia());
            materias.put("id_escuela", materia.getId_escuela());
            materias.put("nombre_materia", materia.getNombre_materia());
            materias.put("ciclo_materia", materia.getCiclo_materia());
            contador=db.insert("MATERIA", null, materias);
        }
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }*/
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

        if(verificarIntegridad(coordina,13)){
            ContentValues coor = new ContentValues();
            coor.put("id_actividad", coordina.getId_actividad());
            coor.put("id_coordinador", coordina.getId_coordinador());
            contador=db.insert("COORDINA", null, coor);
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

    //Insertar Encargado
    public String insertar(Encargado encargado){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        /*if(verificarIntegridad(encargado,32))
        {
            ContentValues encargados = new ContentValues();
            encargados.put("id_reservante", encargado.getId_reservante());
            encargados.put("id_usuario", encargado.getId_usuario());
            encargados.put("nombre_reservante", encargado.getNombre_reservante());
            encargados.put("tipo_reservante", encargado.getTipo_reservante());
            contador=db.insert("ENCARGADO", null, encargados);
        }
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }*/
        return regInsertados;
    }

    //Insertar Actividad

    public String insertar(Actividad actividad) {
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues act = new ContentValues();
        act.put("id_actividad", actividad.getId_actividad());
        act.put("id_tipo_actividad", actividad.getId_tipo_actividad());
        act.put("id_valoracion", actividad.getId_valoracion());
        act.put("id_reservante", actividad.getId_reservante());
        act.put("grupo", actividad.getGrupo());
        act.put("descripcion", actividad.getDescripcion());
        act.put("estado", actividad.getEstado());
        act.put("fecha_actividad", actividad.getFecha_actividad());
        act.put("desde_actividad", actividad.getDesde_actividad());
        act.put("hasta_actividad", actividad.getHasta_actividad());
        contador=db.insert("ACTIVIDAD", null, act);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    //Insertar Detalle Actividad
    public String insertar(DetalleActividad detalleActividad){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        /*if(verificarIntegridad(detalleActividad,34))
        {
            ContentValues detactividades = new ContentValues();
            detactividades.put("id_detalle", detalleActividad.getId_detalle_actividad());
            detactividades.put("id_aula", detalleActividad.getId_aula());
            detactividades.put("id_actividad", detalleActividad.getId_actividad());
            detactividades.put("participantes", detalleActividad.getParticipantes());
            contador=db.insert("DETALLE_ACTIVIDAD", null, detactividades);
        }
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }*/
        return regInsertados;
    }

    //Insertar Detalle Responsable
    public String insertar(DetalleResponsable responsable) {
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues res = new ContentValues();
        res.put("id_detalle_responsable", responsable.getId_detalle_responsable());
        res.put("id_coordinador", responsable.getId_coordinador());
        res.put("nomb_tipo_responsable", responsable.getNomb_tipo_responsable());
        contador=db.insert("DETALLE_RESPONSABLE", null, res);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    //Insertar Tipo Actividad
    public String insertar(TipoActividad tipoActividad) {
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues tipo = new ContentValues();
        tipo.put("id_tipo_actividad", tipoActividad.getId_tipo_actividad());
        tipo.put("nombre_tipo_actividad", tipoActividad.getNombre_tipo_actividad());
        contador=db.insert("TIPO_ACTIVIDAD", null, tipo);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    //Insertar Tipo Grupo
    public String insertar(TipoGrupo tipoGrupo){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        /*if(verificarIntegridad(tipoGrupo,36))
        {
            ContentValues tipogrupos = new ContentValues();
            tipogrupos.put("id_tipo_grupo", tipoGrupo.getId_tipo_grupo());
            tipogrupos.put("grupo", tipoGrupo.getGrupo());
            tipogrupos.put("nombre_tipo_grupo", tipoGrupo.getNombre_tipo_grupo());
            contador=db.insert("TIPO_GRUPO", null, tipogrupos);
        }
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }*/
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
        }
        else{
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
        /*if(verificarIntegridad(materia, 8)){
            String[] id = {materia.getId_materia(), materia.getId_escuela()};
            ContentValues cv = new ContentValues();
            cv.put("nombre_materia", materia.getNombre_materia());
            cv.put("ciclo_materia", materia.getCiclo_materia());
            db.update("MATERIA", cv, "id_materia = ? AND id_escuela = ?", id);
            return "Registro Actualizado Correctamente";
        }else{*/
            return "Registro no Existe";
        //}

    }


//    //Actualizar Ciclo
    public String actualizar(Ciclo ciclo){
        String[] id = {ciclo.getId_ciclo()};
        ContentValues cv = new ContentValues();
        cv.put("id_ciclo", ciclo.getId_ciclo());
        cv.put("ciclo", ciclo.getCiclo());
        cv.put("fecha_inicio", ciclo.getFecha_inicio());
        cv.put("fecha_fin", ciclo.getFecha_fin());
        db.update("CICLO", cv, "id_ciclo = ?", id);
        return "Registro Actualizado Correctamente";
    }

    //Actualizar Coordinar
    public String actualizar(Coordina coordina){
        String[] id = {coordina.getId_actividad()};
        ContentValues cv = new ContentValues();
        cv.put("id_actividad", coordina.getId_actividad());
        cv.put("id_coordinador", coordina.getId_coordinador());
        db.update("COORDINA", cv, "id_actividad = ?", id);
        return "Registro Actualizado Correctamente";
    }



    //Actualizar Encargado
    public String actualizar(Encargado encargado){
        /*if(verificarIntegridad(encargado, 33)){
            String[] id = {encargado.getId_reservante(), encargado.getId_usuario()};
            ContentValues cv = new ContentValues();
            cv.put("nombre_reservante", encargado.getNombre_reservante());
            cv.put("tipo_reservante", encargado.getTipo_reservante());
            db.update("ENCARGADO", cv, "id_reservante = ? AND id_usuario = ?", id);
            return "Registro Actualizado Correctamente";
        }else{*/
        return "Registro no Existe";
        //}

    }

    //Actualizar Detalle Actividad
    public String actualizar(DetalleActividad detalleActividad){
        /*if(verificarIntegridad(detalleActividad, 35)){
            String[] id = {detalleActividad.getId_detalle_actividad(), detalleActividad.getId_aula(),
                    detalleActividad.getId_actividad()};
            ContentValues cv = new ContentValues();
            cv.put("participantes", detalleActividad.getParticipantes());
            db.update("DETALLE_ACTIVIDAD", cv, "id_detalle = ? AND id_aula = ? AND id_actividad = ?", id);
            return "Registro Actualizado Correctamente";
        }else{*/
            return "Registro no Existe";
        //}
    }

    //Actualizar Tipo Grupo
    public String actualizar(TipoGrupo tipoGrupo){
        /*if(verificarIntegridad(tipoGrupo, 37)){
            String[] id = {tipoGrupo.getId_tipo_grupo(), tipoGrupo.getGrupo()};
            ContentValues cv = new ContentValues();
            cv.put("nombre_tipo_grupo", tipoGrupo.getNombre_tipo_grupo());
            db.update("TIPO_GRUPO", cv, "id_tipo_grupo = ? AND grupo = ?", id);
            return "Registro Actualizado Correctamente";
        }else{*/
        return "Registro no Existe";
        //}

    }

    //Actualizar Escuela
    public String actualizar(Escuela escuela){
        if(verificarIntegridad(escuela, 69)){
            String[] id = {escuela.getId_escuela(), escuela.getId_carrera()};
            ContentValues cv = new ContentValues();
            cv.put("nombre_escuela", escuela.getNombre_escuela());
            db.update("ESCUELA", cv, "id_escuela = ? AND id_carrera = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
        return "Registro no Existe";
        }

    }

    //Actualizar Actividad
    public String actualizar(Actividad actividad){
        if(verificarIntegridad(actividad, 160)){
            String[] id = {actividad.getId_actividad(), actividad.getId_tipo_actividad(), actividad.getId_valoracion(), actividad.getId_reservante(), actividad.getGrupo()};
            ContentValues cv = new ContentValues();
            cv.put("descripcion", actividad.getDescripcion());
            cv.put("estado", actividad.getEstado());
            cv.put("fecha_actividad", actividad.getFecha_actividad());
            cv.put("desde_actividad", actividad.getDesde_actividad());
            cv.put("hasta_actividad", actividad.getHasta_actividad());
            db.update("ACTIVIDAD", cv, "id_actividad = ? AND id_tipo_actividad = ? AND id_valoracion = ? AND id_reservante = ? AND grupo = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro no Existe";
        }
    }

    //Actualizar Detalle Responsable
    public String actualizar(DetalleResponsable detalle){
        if(verificarIntegridad(detalle, 60)){
            String[] id = {detalle.getId_detalle_responsable(), detalle.getId_coordinador()};
            ContentValues cv = new ContentValues();
            cv.put("nomb_tipo_responsable", detalle.getNomb_tipo_responsable());
            db.update("DETALLE_RESPONSABLE", cv, "id_detalle_responsable = ? AND id_coordinador = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro no Existe";
        }

    }

    //Actualizar Tipo Actividad
    public String actualizar(TipoActividad tipo) {
        if(verificarIntegridad(tipo, 80)){
            String[] id = {tipo.getId_tipo_actividad()};
            ContentValues cv = new ContentValues();
            cv.put("nombre_tipo_actividad", tipo.getNombre_tipo_actividad());
            db.update("TIPO_ACTIVIDAD", cv, "id_tipo_actividad = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro no Existe";
        }
    }





//================================ FINAL - Bloque de todos los UPDATE =============================================


//================================ INICIO - Bloque de todos los DELETE =============================================

    //Eliminar carrera
    public String eliminar(Carrera carrera) {
        String regAfectados="filas afectadas= ";
        int contador=0;
        /*if (verificarIntegridad(carrera,4)) {
            contador+=db.delete("ESCUELA", "id_carrera='"+carrera.getId_carrera()+"'", null);
        }*/
        contador+=db.delete("CARRERA", "id_carrera='"+carrera.getId_carrera()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }

    //Eliminar DetalleOferta
    public String eliminar(DetalleOferta detalleOferta) {
        String regAfectados="filas afectadas= ";
        int contador=0;
        /*if (verificarIntegridad(detalleOferta,11)){
            contador+=db.delete("ACTIVIDAD", "grupo='"+detalleOferta.getGrupo()+"'", null);
        }
        if (verificarIntegridad(detalleOferta,12)){
            contador+=db.delete("TIPO_GRUPO", "grupo='"+detalleOferta.getGrupo()+"'", null);
        }*/
        /*String where="id_materias_activas='"+detalleOferta.getId_materias_activas()+"'";
        where=where+" AND id_aula='"+detalleOferta.getId_aula()+"'";
        where=where+" AND grupo="+detalleOferta.getGrupo();*/
        String where="grupo='"+detalleOferta.getGrupo()+"'";
        where=where+" AND id_materias_activas='"+detalleOferta.getId_materias_activas()+"'";
        where=where+" AND id_aula='"+detalleOferta.getId_aula()+"'";
        contador+=db.delete("DETALLE_OFERTA", where, null);
        regAfectados+=contador;
        return regAfectados;
    }


    //Eliminar Miembro_Universitario
    public String eliminar(MiembroUniversitario miembroUniversitario) {
        String regAfectados="filas afectadas= ";
        int contador=0;
        /*if (verificarIntegridad(miembroUniversitario,5)) {
            contador+=db.delete("COORDINA", "id_coordinador='"+miembroUniversitario.getId_coordinador()+"'", null);
        }
        if (verificarIntegridad(miembroUniversitario,6)) {
                contador+=db.delete("DETALLE_RESPONSABLE", "id_coordinador='"+miembroUniversitario.getId_coordinador()+"'", null);
        }*/
        contador+=db.delete("MIEMBRO_UNIVERSITARIO", "id_coordinador='"+miembroUniversitario.getId_coordinador()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }

    //Eliminar Horario
    public String eliminar(Horario horario) {
        String regAfectados="filas afectadas= ";
        int contador=0;
        /*if (verificarIntegridad(horario,7)) {
            contador+=db.delete("DETALLE_ACTIVIDAD_HORARIO", "id_horario='"+horario.getId_horario()+"'", null);
        }*/
        contador+=db.delete("HORARIO", "id_horario='"+horario.getId_horario()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }

    //Eliminar Materia
    public String eliminar(Materia materia){
        String regAfectados="filas afectadas= ";
        int contador=0;
        String where="id_materia='"+materia.getId_materia()+"'";
        where=where+" AND id_escuela='"+materia.getId_escuela()+"'";
        contador+=db.delete("MATERIA", where, null);
        regAfectados+=contador;
        return regAfectados;
    }




//    //Eliminar Ciclo

    public String eliminar(Ciclo ciclo) {
        String regAfectados="filas afectadas= ";
        int contador=0;
        contador+=db.delete("CICLO", "id_ciclo='"+ciclo.getId_ciclo()+"'", null);
        //contador+=db.delete("CICLO", "id_ciclo='"+ciclo.getId_ciclo()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }

    //Eliminar Encargado
    public String eliminar(Encargado encargado){
        String regAfectados="filas afectadas= ";
        int contador=0;
        String where="id_reservante='"+encargado.getId_reservante()+"'";
        where=where+" AND id_usuario='"+encargado.getId_usuario()+"'";
        contador+=db.delete("ENCARGADO", where, null);
        regAfectados+=contador;
        return regAfectados;
    }

    //Eliminar Detalle Actividad
    public String eliminar(DetalleActividad detalleActividad){
        String regAfectados="filas afectadas= ";
        int contador=0;
        String where="id_detalle='"+detalleActividad.getId_detalle_actividad()+"'";
        where=where+" AND id_aula='"+detalleActividad.getId_aula()+"'";
        where=where+" AND id_actividad="+detalleActividad.getId_actividad();
        contador+=db.delete("DETALLE_ACTIVIDAD", where, null);
        regAfectados+=contador;
        return regAfectados;
    }

    //Eliminar Tipo Grupo
    public String eliminar(TipoGrupo tipoGrupo){
        String regAfectados="filas afectadas= ";
        int contador=0;
        String where="id_tipo_grupo='"+tipoGrupo.getId_tipo_grupo()+"'";
        where=where+" AND grupo='"+tipoGrupo.getGrupo()+"'";
        contador+=db.delete("TIPO_GRUPO", where, null);
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
    public Materia consultarMateria(String id_materia, String id_escuela){
        String[] id = {id_materia, id_escuela};
        Cursor cursor = db.query("MATERIA", camposMateria, "id_materia = ? AND id_escuela = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            Materia materia = new Materia();
            materia.setId_materia(cursor.getString(0));
            materia.setId_escuela(cursor.getString(1));
            materia.setNombre_materia(cursor.getString(2));
            materia.setCiclo_materia(cursor.getInt(3));
            return materia;
        }else{
            return null;
        }

    }

    //Consultar Ciclo
    public Ciclo consultarCiclo(String id_ciclo){
        String[] id = {id_ciclo};
        Cursor cursor = db.query("CICLO", camposCiclo, "id_ciclo = ?", id, null, null, null);
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

    //Consultar Encargado
    public Encargado consultarEncargado(String id_reservante, String id_usuario){
        String[] id = {id_reservante, id_usuario};
        Cursor cursor = db.query("ENCARGADO", camposMateria, "id_reservante = ? AND id_usuario = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            Encargado encargado = new Encargado();
            encargado.setId_reservante(cursor.getString(0));
            encargado.setId_usuario(cursor.getString(1));
            encargado.setNombre_reservante(cursor.getString(2));
            encargado.setTipo_reservante(cursor.getString(3));
            return encargado;
        }else{
            return null;
        }

    }

    //Consultar Detalle Actividad
    public DetalleActividad consultarDetalleActividad(String id_detalle, String id_aula, String id_actividad){
        String[] id = {id_detalle, id_aula, id_actividad};
        Cursor cursor = db.query("DETALLE_ACTIVIDAD", camposDetalleActividad, "id_detalle = ? AND id_aula = ? AND id_actividad = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            DetalleActividad detalleActividad = new DetalleActividad();
            detalleActividad.setId_detalle_actividad(cursor.getString(0));
            detalleActividad.setId_aula(cursor.getString(1));
            detalleActividad.setId_actividad(cursor.getString(2));
            detalleActividad.setParticipantes(cursor.getInt(3));
            return detalleActividad;
        }else{
            return null;
        }
    }

    //Consultar Escuela
    public Escuela consultarEscuela(String id_escuela) {
        String[] id = {id_escuela};
        Cursor cursor = db.query("ESCUELA", camposEscuela, "id_escuela = ?",
                id, null, null, null);
        if(cursor.moveToFirst()){
            Escuela esc = new Escuela();
            esc.setId_escuela(cursor.getString(0));
            esc.setId_carrera(cursor.getString(1));
            esc.setNombre_escuela(cursor.getString(2));
            return esc;
        }else{
            return null;
        }
    }

    //Consultar Actividad
    public Actividad consultarActividad(String id_actividad) {
        String[] id = {id_actividad};
        Cursor cursor = db.query("ACTIVIDAD", camposActividad, "id_actividad = ?",
                id, null, null, null);
        if(cursor.moveToFirst()){
            Actividad act = new Actividad();
            act.setId_actividad(cursor.getString(0));
            act.setId_tipo_actividad(cursor.getString(1));
            act.setId_valoracion(cursor.getString(2));
            act.setId_reservante(cursor.getString(3));
            act.setGrupo(cursor.getString(4));
            act.setDescripcion(cursor.getString(5));
            act.setEstado(cursor.getString(6));
            act.setFecha_actividad(cursor.getString(7));
            act.setDesde_actividad(cursor.getString(8));
            act.setHasta_actividad(cursor.getString(9));
            return act;
        }else{
            return null;
        }
    }

    //Consultar TipoGrupo
    public TipoGrupo consultarTipoGrupo(String id_tipo_grupo, String grupo){
        String[] id = {id_tipo_grupo, grupo};
        Cursor cursor = db.query("TIPO_GRUPO", camposTipoGrupo, "id_tipo_grupo = ? AND grupo = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            TipoGrupo tipoGrupo = new TipoGrupo();
            tipoGrupo.setId_tipo_grupo(cursor.getString(0));
            tipoGrupo.setGrupo(cursor.getString(1));
            tipoGrupo.setNombre_tipo_grupo(cursor.getString(2));
            return tipoGrupo;
        }else{
            return null;
        }

    }

    //Consultar Detalle Responsable
    public DetalleResponsable consultarDetalleResponsable(String id_detalle_responsable) {
        String[] id = {id_detalle_responsable};
        Cursor cursor = db.query("DETALLE_RESPONSABLE", camposDetalleResponsable, "id_detalle_responsable = ?",
                id, null, null, null);
        if(cursor.moveToFirst()){
            DetalleResponsable detalle = new DetalleResponsable();
            detalle.setId_detalle_responsable(cursor.getString(0));
            detalle.setId_coordinador(cursor.getString(1));
            detalle.setNomb_tipo_responsable(cursor.getString(2));
            return detalle;
        }else{
            return null;
        }
    }

    //Consultar Tipo Actividad
    public TipoActividad consultarTipoActividad(String id_tipo_actividad) {
        String[] id = {id_tipo_actividad};
        Cursor cursor = db.query("TIPO_ACTIVIDAD", camposTipoActividad, "id_tipo_actividad = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            TipoActividad tipo = new TipoActividad();
            tipo.setId_tipo_actividad(cursor.getString(0));
            tipo.setNombre_tipo_actividad(cursor.getString(1));
            return tipo;
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
            case 8: { //para actualizar materia
                //verificar que al modificar Materia exista id de la materia, y el id de escuela
                Materia materia1 = (Materia) dato;
                String[] ids = {materia1.getId_materia(), materia1.getId_escuela()};
                abrir();
                Cursor c = db.query("MATERIA", null, "id_materia = ? AND id_escuela = ?", ids, null, null, null);
                if(c.moveToFirst()){
                    //Se encontraron datos
                    return true;
                }
                return false;
            }
            case 31:
            {
                //verificar que al insertar materia exista el ID de la escuela
                Materia materia = (Materia) dato;
                String[] id1 = {materia.getId_escuela()};
                //abrir();
                Cursor cursor1 = db.query("ESCUELA", null, "id_escuela = ?", id1, null,
                        null, null);
                if(cursor1.moveToFirst()){
                    //Se encontraron datos
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

            case 13:{
                //verificar que al insertar un dato en coordina id_actividad en actividad y id_coordinador en miembro universitrario
                Coordina coordina = (Coordina) dato;
                String[] id1 = {coordina.getId_actividad()};
                String[] id2 = {coordina.getId_coordinador()};
                //abrir();
                Cursor cursor1 = db.query("ACTIVIDAD", null, "id_actividad = ?", id1, null,
                        null, null);
                Cursor cursor2 = db.query("MIEMBRO_UNIVERSITARIO", null, "id_coordinador = ?", id2,
                        null, null, null);
                if(cursor1.moveToFirst() && cursor2.moveToFirst()){
                //Se encontraron datos
                    return true;
                }
                return false;
            }

            case 14:{
                //verificar que al modificar coordina exista id de actividad y id coordinador
                Coordina coordina2= (Coordina) dato;
                String[] ids = {coordina2.getId_actividad(), coordina2.getId_coordinador()};
                abrir();
                Cursor c = db.query("COORDINA", null, "id_actividad = ? AND id_coordinador = ? ", ids, null, null, null);
                if(c.moveToFirst()){
                //Se encontraron datos
                    return true;
                }
                return false;
            }

            case 15:{
                DetalleActividadHorario detalleActividadHorario = (DetalleActividadHorario) dato;
                Cursor c=db.query(true, "HORARIO", new String[] {
                                "id_horario" }, "id_horario='"+detalleActividadHorario.getId_horario()+"'",null,
                        null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;
            }
//            case 16:{
//                Ciclo ciclo = (Ciclo)dato;
//                Cursor cmat=db.query(true, "OFERTA_ACADEMICA", new String[] {
//                                "codmateria" },
//                        "codmateria='"+materia.getCodmateria()+"'",null, null, null, null, null);
//                if(cmat.moveToFirst())
//
//                return true;
//                else
//                return false;
//            }
            case 32:
            {
                //verificar que al insertar Encargado exista el ID del Usuario
                Encargado encargado = (Encargado) dato;
                String[] id1 = {encargado.getId_usuario()};
                //abrir();
                Cursor cursor1 = db.query("USUARIO", null, "id_usuario = ?", id1, null,
                        null, null);
                if(cursor1.moveToFirst()){
                    //Se encontraron datos
                    return true;
                }
                return false;
            }
            case 33: { //para actualizar Encargado
                //verificar que al modificar Encargado exista id del Reservante, y el id del Usuario
                Encargado encargado1 = (Encargado) dato;
                String[] ids = {encargado1.getId_reservante(), encargado1.getId_usuario()};
                abrir();
                Cursor c = db.query("ENCARGADO", null, "id_reservante = ? AND id_usuario = ?", ids, null, null, null);
                if(c.moveToFirst()){
                    //Se encontraron datos
                    return true;
                }
                return false;
            }
            case 34:
            {
                //verificar que al insertar Detalle Actividad exista el ID del Usuario
                DetalleActividad detalleActividad = (DetalleActividad) dato;
                String[] id1 = {detalleActividad.getId_aula()};
                String[] id2 = {detalleActividad.getId_actividad()};
                //abrir();
                Cursor cursor1 = db.query("LOCAL", null, "id_aula = ?", id1, null,
                        null, null);
                Cursor cursor2 = db.query("ACTIVIDAD", null, "id_actividad = ?", id2,
                        null, null, null);
                if(cursor1.moveToFirst() && cursor2.moveToFirst()){
                //Se encontraron datos
                    return true;
                }
                return false;
            }
            case 35:
            {
                //verificar que al modificar Detalle Actividad exista id_detalle, id_aula y el id_actividad
                DetalleActividad detalleActividad1 = (DetalleActividad) dato;
                String[] ids = {detalleActividad1.getId_detalle_actividad(), detalleActividad1.getId_aula(),
                        detalleActividad1.getId_actividad()};
                abrir();
                Cursor c = db.query("DETALLE_ACTIVIDAD", null, "id_detalle = ? AND id_aula = ? AND id_actividad = ?", ids, null, null, null);
                if(c.moveToFirst()){
                //Se encontraron datos
                    return true;
                }
                return false;
            }
            case 36:
            {
                //verificar que al insertar TipoGRUPO exista el ID del grupo en tabla Det Oferta
                TipoGrupo tipoGrupo = (TipoGrupo) dato;
                String[] id1 = {tipoGrupo.getGrupo()};
                //abrir();
                Cursor cursor1 = db.query("DETALLE_OFERTA", null, "grupo = ?", id1, null,
                        null, null);

                if(cursor1.moveToFirst()){
                    //Se encontraron datos
                    return true;
                }
                return false;
            }
            case 37: { //para actualizar TipoGrupo
                //verificar que al modificar TipoGrupo exista id del tipo grupo, y el grupo en Det Oferta
                TipoGrupo tipoGrupo1 = (TipoGrupo) dato;
                String[] ids = {tipoGrupo1.getId_tipo_grupo(), tipoGrupo1.getGrupo()};
                abrir();
                Cursor c = db.query("TIPO_GRUPO", null, "id_tipo_grupo = ? AND grupo = ?", ids, null, null, null);
                if(c.moveToFirst()){
                    //Se encontraron datos
                    return true;
                }
                return false;
            }
            case 69: { //para actualizar escuela
                //verificar que al modificar Escuela exista id de la escuela, y el id de la carrera
                Escuela escuela1 = (Escuela) dato;
                String[] ids = {escuela1.getId_escuela(), escuela1.getId_carrera()};
                abrir();
                Cursor c = db.query("ESCUELA", null, "id_escuela = ? AND id_carrera = ?", ids, null, null, null);
                if(c.moveToFirst()){
                    //Se encontraron datos
                    return true;
                }
                return false;
            }

            case 160: {//verificar que al modificar actividad exista id_actividad, tipo actividad, valoracion,
                Actividad actividad1 = (Actividad) dato;
                String[] ids = {actividad1.getId_actividad(), actividad1.getId_tipo_actividad(), actividad1.getId_valoracion(), actividad1.getId_reservante(), actividad1.getGrupo()};
                abrir();
                Cursor c = db.query("ACTIVIDAD", null, "id_actividad = ? AND id_tipo_actividad = ? AND id_valoracion = ? AND id_reservante = ? AND grupo = ?", ids, null, null, null);
                if(c.moveToFirst()){
                    //Se encontraron datos
                    return true;
                }
                return false;
            }

            case 60: { //para actualizar escuela
                //verificar que al modificar Escuela exista id de la escuela, y el id de la carrera
                DetalleResponsable detalle = (DetalleResponsable) dato;
                String[] ids = {detalle.getId_detalle_responsable(), detalle.getId_coordinador()};
                abrir();
                Cursor c = db.query("DETALLE_RESPONSABLE", null, "id_detalle_responsable = ? AND id_coordinador = ?", ids, null, null, null);
                if(c.moveToFirst()){
                    //Se encontraron datos
                    return true;
                }
                return false;
            }

            case 80: { //para actualizar tipo actividad
                //verificar que al modificar tipo de actividad exista id de el tipo de actividad
                TipoActividad tipo = (TipoActividad) dato;
                String[] ids = {tipo.getId_tipo_actividad()};
                abrir();
                Cursor c = db.query("TIPO_ACTIVIDAD", null, "id_tipo_actividad = ? ", ids, null, null, null);
                if(c.moveToFirst()){
                    //Se encontraron datos
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

    public String llenarBD() {

        //Tabla Carrera
        final String[] Carreraid_carrera = {"I10515", "I10501", "I10502"};
        final String[] Carreranombre_carrera = {"Ingenieria de Sistemas Informaticos", "Ingenieria Civil", "Ingenieria Industrial"};

        //Tabla Detalle_Oferta
        final String[] DetalleOfertagrupo = {"G01","G02","G03"};
        final String[] DetalleOfertaid_materias_activas = {"PRN115","FIR115","MEP115"}; //fk
        final String[] DetalleOfertaid_aula = {"B11","B21","B22"}; //fk
        final int[] DetalleOfertacant_inscritos = {100,80,70};


        //Tabla Miembro_Universitario
        final String[] Miembroid_coordinador = {"M01", "M02", "M03"};
        final String[] Miembronombre_coordinador = {"Juan","Raquel","Pablo"};
        final String[] Miembrotipo_miembro = {"Docente","Administrativo","Estudiante"};

        //Tabla Ciclo
        final String[] cicloId_ciclo = {"1235","8546","4563","7893"};
        final String[] ciclo_ciclo = {"01","02","01","02"};
        final String[] ciclo_fecha_inicio = {"12/02/2019","23/02/2020","04/02/2021","23/02/2022"};
        final String[] ciclo_fecha_fin = {"12/12/2019","21/06/2018","25/12/2022","28/11/2019"};

        //Tabla Coordina
        final String[] coodrinaId_actividad = {"1235","8546","4563","7893"};
        final String[] coordinaId_coordinador = {"M01", "M02", "M03"};

        //Tabla DetalleActividadHorario
        final String[] detalleActividadHorarioId_horario = {"H01","H02","H03"};
        final String[] detalleActividadHorarioId_actividad = {"01","02","01","02"};



        //Tabla Horario
        final String[] Horarioid_horario = {"H01","H02","H03"};
        final String[] Horariodesde_horario = {"8:00","9:50","13:20"};
        final String[] Horariohasta_horario = {"9:45","11:30","15:00"};

        //Tabla Materia
        final  String[] Materiaid_materia = {"MAT115","FIR315","TAD115","SYP115"};
        final  String[] Materiaid_escuela = {"I10501","I10501","I10515","I10515"};
        final  String[] Materianombre_materia = {"Matematicas 1","Fisica 3","Teoria Administrativa","Sistemas y Procedimientos"};
        final  int[] Materiaciclo_materia = {1,2,1,1};

        //Tabla Encargado
        final  String[] Encargadoid_reservante = {"HG16037","MT17005","VM15003","MR17130"};
        final  String[] Encargadoid_usuario = {"HG16037","MT17005","VM15003","MR17130"};
        final  String[] Encargadonombre_reservante = {"Alex","Jose","Maria","Zusana"};
        final  String[] Encargadotipo_reservante = {"Administrador","Administrador","Reservante","Reservante"};

        abrir();
        db.execSQL("DELETE FROM CARRERA");
        db.execSQL("DELETE FROM DETALLE_OFERTA");
        db.execSQL("DELETE FROM MIEMBRO_UNIVERSITARIO");
        db.execSQL("DELETE FROM HORARIO");
        db.execSQL("DELETE FROM MATERIA");
        db.execSQL("DELETE FROM ENCARGADO");
        db.execSQL("DELETE FROM CICLO");
        db.execSQL("DELETE FROM COORDINA");
        db.execSQL("DELETE FROM DETALLE_ACTIVIDAD_HORARIO");


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

        Encargado encargado = new Encargado();
        for (int i = 0; i < 4; i++) {
            encargado.setId_reservante(Encargadoid_reservante[i]);
            encargado.setId_usuario(Encargadoid_usuario[i]);
            encargado.setNombre_reservante(Encargadonombre_reservante[i]);
            encargado.setTipo_reservante(Encargadotipo_reservante[i]);
            insertar(encargado);
        }

        Ciclo ciclo = new Ciclo();
        for (int i = 0; i < 4; i++) {
            ciclo.setId_ciclo(cicloId_ciclo[i]);
            ciclo.setCiclo(ciclo_ciclo[i]);
            ciclo.setFecha_inicio(ciclo_fecha_inicio[i]);
            ciclo.setFecha_fin(ciclo_fecha_fin[i]);
            insertar(ciclo);
        }
        Coordina coordina = new Coordina();
        for (int i = 0; i < 2; i++) {
            coordina.setId_actividad(coodrinaId_actividad[i]);
            coordina.setId_coordinador(coordinaId_coordinador[i]);
            insertar(coordina);
        }

        DetalleActividadHorario detalleActividadHorario = new DetalleActividadHorario();
        for (int i = 0; i < 2; i++) {
            detalleActividadHorario.setId_horario(detalleActividadHorarioId_horario[i]);
            detalleActividadHorario.setId_actividad(detalleActividadHorarioId_actividad[i]);
            insertar(detalleActividadHorario);
        }



        cerrar();
        return "Guardo Correctamente";
    }

//================================ FINAL - Bloque de llenado de datos =============================================

}
