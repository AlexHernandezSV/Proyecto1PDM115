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