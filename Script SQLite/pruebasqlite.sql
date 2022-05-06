--==============================================================
-- Table: USUARIO
--==============================================================
create table USUARIO (
ID_USUARIO           CHAR(2)              not null,
NOM_USUARIO          VARCHAR2(30)         not null,
CLAVE                VARCHAR2(20)         not null,
primary key (ID_USUARIO)
);

--==============================================================
-- Table: OPCION_CRUD
--==============================================================
create table OPCION_CRUD (
ID_OPCION            CHAR(3)              not null,
DESCRIPCION          VARCHAR2(50)         not null,
NUM_CRUD             INTEGER              not null,
primary key (ID_OPCION)
);

--==============================================================
-- Table: ACCESO_USUARIO
--==============================================================
create table ACCESO_USUARIO (
ID_USUARIO           CHAR(2),
ID_OPCION            CHAR(3),
foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO),
foreign key (ID_OPCION)
      references OPCION_CRUD (ID_OPCION)
);

--==============================================================
-- Index: TIENE_2_FK
--==============================================================
create  index TIENE_2_FK on ACCESO_USUARIO (
ID_USUARIO ASC
);

--==============================================================
-- Index: BRINDA_FK
--==============================================================
create  index BRINDA_FK on ACCESO_USUARIO (
ID_OPCION ASC
);

--==============================================================
-- Table: TIPO_ACTIVIDAD
--==============================================================
create table TIPO_ACTIVIDAD (
ID_TIPO_ACTIVIDAD    INTEGER              not null,
NOMBRE_TIPO_ACTIVIDAD VARCHAR2(50)         not null,
primary key (ID_TIPO_ACTIVIDAD)
);

--==============================================================
-- Table: CARRERA
--==============================================================
create table CARRERA (
ID_CARRERA           VARCHAR2(6)          not null,
NOMBRE_CARRERA       VARCHAR2(50)         not null,
primary key (ID_CARRERA)
);

--==============================================================
-- Table: ESCUELA
--==============================================================
create table ESCUELA (
ID_ESCUELA           INTEGER              not null,
ID_CARRERA           VARCHAR2(6),
NOMBRE_ESCUELA       VARCHAR2(50)         not null,
primary key (ID_ESCUELA),
foreign key (ID_CARRERA)
      references CARRERA (ID_CARRERA)
);

--==============================================================
-- Table: MATERIA
--==============================================================
create table MATERIA (
ID_MATERIA           CHAR(6)              not null,
ID_ESCUELA           INTEGER,
NOMBRE_MATERIA       VARCHAR2(50)         not null,
CICLO_MATERIA        INTEGER              not null,
primary key (ID_MATERIA),
foreign key (ID_ESCUELA)
      references ESCUELA (ID_ESCUELA)
);

--==============================================================
-- Table: CICLO
--==============================================================
create table CICLO (
ID_CICLO             INTEGER              not null,
CICLO                VARCHAR2(6)          not null,
FECHA_INICIO         DATE                 not null,
FECHA_FIN            DATE                 not null,
primary key (ID_CICLO)
);

--==============================================================
-- Table: MIEMBRO_UNIVERSITARIO
--==============================================================
create table MIEMBRO_UNIVERSITARIO (
ID_COORDINADOR       INTEGER              not null,
NOMBRE_COORDINADOR   VARCHAR2(50)         not null,
TIPO_MIEMBRO         CHAR(10)             not null,
primary key (ID_COORDINADOR)
);

--==============================================================
-- Table: OFERTA_ACADEMICA
--==============================================================
create table OFERTA_ACADEMICA (
ID_MATERIAS_ACTIVAS  CHAR(6)              not null,
ID_CICLO             INTEGER,
ID_MATERIA           CHAR(6),
ID_COORDINADOR       INTEGER,
NOMBRE_MATERIAS_ACTIVAS VARCHAR2(20)         not null,
CICLO_MATERIA_ACTIVA INTEGER              not null,
primary key (ID_MATERIAS_ACTIVAS),
foreign key (ID_MATERIA)
      references MATERIA (ID_MATERIA),
foreign key (ID_CICLO)
      references CICLO (ID_CICLO),
foreign key (ID_COORDINADOR)
      references MIEMBRO_UNIVERSITARIO (ID_COORDINADOR)
);

--==============================================================
-- Table: ENCARGADO
--==============================================================
create table ENCARGADO (
ID_RESERVANTE        INTEGER              not null,
ID_USUARIO           CHAR(2),
NOMBRE_RESERVANTE    VARCHAR2(50)         not null,
TIPO_RESERVANTE      VARCHAR2(10)         not null,
primary key (ID_RESERVANTE),
foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO)
);

--==============================================================
-- Table: LOCAL
--==============================================================
create table LOCAL (
ID_AULA              INTEGER              not null,
ID_RESERVANTE        INTEGER,
NOMBRE_AULA          VARCHAR2(50)         not null,
CUPO                 CHAR(10)             not null,
primary key (ID_AULA),
foreign key (ID_RESERVANTE)
      references ENCARGADO (ID_RESERVANTE)
);

--==============================================================
-- Table: DETALLE_OFERTA
--==============================================================
create table DETALLE_OFERTA (
GRUPO                CHAR(3)              not null,
ID_MATERIAS_ACTIVAS  CHAR(6),
ID_AULA              INTEGER,
CANT_INSCRITOS       INTEGER              not null,
primary key (GRUPO),
foreign key (ID_MATERIAS_ACTIVAS)
      references OFERTA_ACADEMICA (ID_MATERIAS_ACTIVAS),
foreign key (ID_AULA)
      references LOCAL (ID_AULA),
foreign key (ID_MATERIAS_ACTIVAS)
      references OFERTA_ACADEMICA (ID_MATERIAS_ACTIVAS)
);

--==============================================================
-- Table: VALORACION
--==============================================================
create table VALORACION (
ID_VALORACION        INTEGER              not null,
VALORACION           VARCHAR2(50)         not null,
primary key (ID_VALORACION)
);

--==============================================================
-- Table: ACTIVIDAD
--==============================================================
create table ACTIVIDAD (
ID_ACTIVIDAD         INTEGER              not null,
ID_TIPO_ACTIVIDAD    INTEGER,
ID_VALORACION        INTEGER,
ID_RESERVANTE        INTEGER,
GRUPO                CHAR(3),
DESCRIPCION          VARCHAR2(50)         not null,
ESTADO               VARCHAR2(10)         not null,
FECHA_ACTIVIDAD      DATE                 not null,
DESDE_ACTIVIDAD      DATE                 not null,
HASTA_ACTIVIDAD      DATE                 not null,
primary key (ID_ACTIVIDAD),
foreign key (ID_TIPO_ACTIVIDAD)
      references TIPO_ACTIVIDAD (ID_TIPO_ACTIVIDAD),
foreign key (GRUPO)
      references DETALLE_OFERTA (GRUPO),
foreign key (ID_VALORACION)
      references VALORACION (ID_VALORACION),
foreign key (ID_RESERVANTE)
      references ENCARGADO (ID_RESERVANTE)
);

--==============================================================
-- Index: TIENE_FK
--==============================================================
create  index TIENE_FK on ACTIVIDAD (
ID_TIPO_ACTIVIDAD ASC
);

--==============================================================
-- Index: RELATIONSHIP_20_FK
--==============================================================
create  index RELATIONSHIP_20_FK on ACTIVIDAD (
GRUPO ASC
);

--==============================================================
-- Index: PUNTUA_FK
--==============================================================
create  index PUNTUA_FK on ACTIVIDAD (
ID_VALORACION ASC
);

--==============================================================
-- Table: COORDINA
--==============================================================
create table COORDINA (
ID_ACTIVIDAD         INTEGER              not null,
ID_COORDINADOR       INTEGER              not null,
primary key (ID_ACTIVIDAD, ID_COORDINADOR),
foreign key (ID_COORDINADOR)
      references MIEMBRO_UNIVERSITARIO (ID_COORDINADOR),
foreign key (ID_ACTIVIDAD)
      references ACTIVIDAD (ID_ACTIVIDAD)
);

--==============================================================
-- Index: COORDINA2_FK
--==============================================================
create  index COORDINA2_FK on COORDINA (
ID_COORDINADOR ASC
);

--==============================================================
-- Index: COORDINA_FK
--==============================================================
create  index COORDINA_FK on COORDINA (
ID_ACTIVIDAD ASC
);

--==============================================================
-- Table: DETALLE_ACTIVIDAD
--==============================================================
create table DETALLE_ACTIVIDAD (
ID_DETALLE           INTEGER              not null,
ID_AULA              INTEGER,
ID_ACTIVIDAD         INTEGER,
PARTICIPANTES        INTEGER              not null,
primary key (ID_DETALLE),
foreign key (ID_ACTIVIDAD)
      references ACTIVIDAD (ID_ACTIVIDAD),
foreign key (ID_AULA)
      references LOCAL (ID_AULA)
);

--==============================================================
-- Index: PERTENECE_2_FK
--==============================================================
create  index PERTENECE_2_FK on DETALLE_ACTIVIDAD (
ID_ACTIVIDAD ASC
);

--==============================================================
-- Table: HORARIO
--==============================================================
create table HORARIO (
ID_HORARIO           INTEGER              not null,
DESDE_HORARIO        DATE                 not null,
HASTA_HORARIO        DATE                 not null,
primary key (ID_HORARIO)
);

--==============================================================
-- Table: DETALLE_ACTIVIDAD_HORARIO
--==============================================================
create table DETALLE_ACTIVIDAD_HORARIO (
ID_HORARIO           INTEGER,
ID_ACTIVIDAD         INTEGER,
foreign key (ID_HORARIO)
      references HORARIO (ID_HORARIO),
foreign key (ID_ACTIVIDAD)
      references ACTIVIDAD (ID_ACTIVIDAD)
);

--==============================================================
-- Index: RELATIONSHIP_18_FK
--==============================================================
create  index RELATIONSHIP_18_FK on DETALLE_ACTIVIDAD_HORARIO (
ID_HORARIO ASC
);

--==============================================================
-- Index: RELATIONSHIP_19_FK
--==============================================================
create  index RELATIONSHIP_19_FK on DETALLE_ACTIVIDAD_HORARIO (
ID_ACTIVIDAD ASC
);

--==============================================================
-- Index: POSEE_FK 
--==============================================================
create  index POSEE_FK on DETALLE_OFERTA (
      -- Agregado ID_MATERIAS_ACTIVAS ASC (NO SEGURO)
ID_MATERIAS_ACTIVAS ASC
);

--==============================================================
-- Index: RELATIONSHIP_21_FK
--==============================================================
create  index RELATIONSHIP_21_FK on DETALLE_OFERTA (
ID_AULA ASC
);

--==============================================================
-- Table: DETALLE_RESPOSABLE
--==============================================================
create table DETALLE_RESPOSABLE (
ID_DETALLE_RESPONSABLE CHAR(10)             not null,
ID_COORDINADOR       INTEGER,
NOMB_TIPO_RESPONSABLE CHAR(10)             not null,
primary key (ID_DETALLE_RESPONSABLE),
foreign key (ID_COORDINADOR)
      references MIEMBRO_UNIVERSITARIO (ID_COORDINADOR)
);

--==============================================================
-- Index: RELATIONSHIP_22_FK
--==============================================================
create  index RELATIONSHIP_22_FK on DETALLE_RESPOSABLE (
ID_COORDINADOR ASC
);

--==============================================================
-- Index: ES_FK
--==============================================================
create  index ES_FK on ENCARGADO (
ID_USUARIO ASC
);

--==============================================================
-- Index: PERTENECE_FK
--==============================================================
create  index PERTENECE_FK on ESCUELA (
ID_CARRERA ASC
);

--==============================================================
-- Index: RELATIONSHIP_23_FK
--==============================================================
create  index RELATIONSHIP_23_FK on LOCAL (
ID_RESERVANTE ASC
);

--==============================================================
-- Index: TIENEN_2_FK
--==============================================================
create  index TIENEN_2_FK on MATERIA (
ID_ESCUELA ASC
);

--==============================================================
-- Index: RELATIONSHIP_16_FK
--==============================================================
create  index RELATIONSHIP_16_FK on OFERTA_ACADEMICA (
      -- NO SEGURO
ID_COORDINADOR ASC
);

--==============================================================
-- Index: PERTENECE_3_FK
--==============================================================
create  index PERTENECE_3_FK on OFERTA_ACADEMICA (
ID_MATERIA ASC
);

--==============================================================
-- Table: TIPO_GRUPO
--==============================================================
create table TIPO_GRUPO (
ID_TIPO_GRUPO        CHAR(2)              not null,
GRUPO                CHAR(3),
NOMBRE_TIPO_GRUPO    VARCHAR2(50)         not null,
primary key (ID_TIPO_GRUPO),
foreign key (GRUPO)
      references DETALLE_OFERTA (GRUPO)
);

--==============================================================
-- Index: RELATIONSHIP_17_FK
--==============================================================
create  index RELATIONSHIP_17_FK on TIPO_GRUPO (
GRUPO ASC
);

