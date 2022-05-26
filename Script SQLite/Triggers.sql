-- =========================================================================
-- Trigger que impide insertar en DETALLE_OFERTA sin que existan 
-- registros en la tabla OFERTA_ACADEMICA.
-- =========================================================================
CREATE TRIGGER fk_ofertaAcademica_detalleOferta
BEFORE INSERT ON DETALLE_OFERTA
FOR EACH ROW
BEGIN
 SELECT CASE
 WHEN ((SELECT ID_MATERIAS_ACTIVAS FROM OFERTA_ACADEMICA WHERE ID_MATERIAS_ACTIVAS = NEW.ID_MATERIAS_ACTIVAS) IS NULL)
 THEN RAISE(ABORT, 'No existe la asignatura')
END;
END;


-- =========================================================================
-- Trigger que impide insertar en DETALLE_OFERTA sin que existan 
-- registros en la tabla LOCAL.
-- =========================================================================
CREATE TRIGGER fk_local_detalleoferta
BEFORE INSERT ON DETALLE_OFERTA
FOR EACH ROW
BEGIN
 SELECT CASE
 WHEN ((SELECT ID_AULA FROM LOCAL WHERE ID_AULA = NEW.ID_AULA) IS NULL)
 THEN RAISE(ABORT, 'No existe el local')
END;
END;

<<<<<<< HEAD
-- =========================================================================
-- Trigger que impide insertar en MATERIA sin que existan
-- registros en la tabla ESCUELA a la ue pertenece.
-- =========================================================================
CREATE TRIGGER fk_escuela_materia
BEFORE INSERT ON MATERIA
FOR EACH ROW
BEGIN
 SELECT CASE
 WHEN ((SELECT ID_ESCUELA FROM ESCUELA WHERE ID_ESCUELA = NEW.ID_ESCUELA) IS NULL)
 THEN RAISE(ABORT, 'No existe la escuela')
END;
END;


-- =========================================================================
-- Trigger que impide insertar en DETALLE_ACTIVIDAD sin que existan
-- registros en la tabla LOCAL a la Que pertenece.
-- =========================================================================
CREATE TRIGGER fk_local_detalleactividad
BEFORE INSERT ON DETALLE_ACTIVIDAD
FOR EACH ROW
BEGIN
 SELECT CASE
 WHEN ((SELECT ID_AULA FROM LOCAL WHERE ID_AULA = NEW.ID_AULA) IS NULL)
 THEN RAISE(ABORT, 'No existe el local')
END;
END;

-- =========================================================================
-- Trigger que impide insertar en DETALLE_ACTIVIDAD sin que existan
-- registros en la tabla ACTIVIDAD a la Que pertenece.
-- =========================================================================
CREATE TRIGGER fk_actividad_detalleactividad
BEFORE INSERT ON DETALLE_ACTIVIDAD
FOR EACH ROW
BEGIN
 SELECT CASE
 WHEN ((SELECT ID_ACTIVIDAD FROM ACTIVIDAD WHERE ID_ACTIVIDAD = NEW.ID_ACTIVIDAD) IS NULL)
 THEN RAISE(ABORT, 'No existe el local')
END;
END;


INSERT INTO MATERIA VALUES ('03','01','PYE115',2);
=======

-- =========================================================================
-- Trigger que impide insertar en DETALLE_OFERTA si se excede la cantidad
-- de inscritos en una actividad desarrollada en un local con cupo limitado
-- dentro de la tabla LOCAL. 
-- =========================================================================
CREATE TRIGGER update_cupos
BEFORE INSERT ON DETALLE_OFERTA
FOR EACH ROW
BEGIN
 SELECT CASE
 WHEN new.CANT_INSCRITOS > (SELECT CUPO FROM LOCAL WHERE ID_AULA = NEW.ID_AULA)
 THEN RAISE(ABORT, 'Cupos insuficientes')
END;
END;
>>>>>>> e3bd3cbe6549f62c22b88e8f5dacb40234c1dce5




-- Triggers de pedro

-- =========================================================================
-- Trigger que impide insertar en OFERTA_ACADEMICA sin que existan
-- registros en la tabla MIEMBRO_UNIVRSITARIO.
-- =========================================================================
CREATE TRIGGER fk_ofertaAcademica_miembroUniversitario
BEFORE INSERT ON OFERTA_ACADEMICA
FOR EACH ROW
BEGIN
 SELECT CASE
 WHEN ((SELECT ID_COORDINADOR FROM MIEMBRO_UNIVERSITARIO WHERE ID_COORDINADOR = NEW.ID_COORDINADOR) IS NULL)
 THEN RAISE(ABORT, 'Error: No existe el miembro universitario')
END;
END;


-- =========================================================================
-- Trigger que impide insertar en OFERTA_ACADEMICA sin que existan
-- registros en la tabla MATERIA.
-- =========================================================================
CREATE TRIGGER fk_ofertaAcademica_materia
BEFORE INSERT ON OFERTA_ACADEMICA
FOR EACH ROW
BEGIN
 SELECT CASE
 WHEN ((SELECT ID_MATERIA FROM MATERIA WHERE ID_MATERIA = NEW.ID_MATERIA) IS NULL)
 THEN RAISE(ABORT, 'Error: No existe la materia')
END;
END;

-- =========================================================================
-- Trigger que impide insertar en OFERTA_ACADEMICA sin que existan
-- registros en la tabla CICLO.
-- =========================================================================
CREATE TRIGGER fk_ofertaAcademica_ciclo
BEFORE INSERT ON OFERTA_ACADEMICA
FOR EACH ROW
BEGIN
 SELECT CASE
 WHEN ((SELECT ID_CICLO FROM CICLO WHERE ID_CICLO = NEW.ID_CICLO) IS NULL)
 THEN RAISE(ABORT, 'Error: No existe el ciclo a ingresar')
END;
END;

-- =========================================================================
-- Trigger que impide insertar en LOCAL sin que existan
-- registros en la tabla ENCARGADO.
-- =========================================================================
CREATE TRIGGER fk_local_encargado
BEFORE INSERT ON LOCAL
FOR EACH ROW
BEGIN
 SELECT CASE
 WHEN ((SELECT ID_RESERVANTE FROM ENCARGADO WHERE ID_RESERVANTE = NEW.ID_RESERVANTE) IS NULL)
 THEN RAISE(ABORT, 'Error: No existe el encargado del local')
END;
END;

--fin de los triggers de pedro
