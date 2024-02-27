-- Trigger para la tabla VIDEO
CREATE OR REPLACE TRIGGER trg_video_audit
AFTER INSERT OR UPDATE ON VIDEO
FOR EACH ROW
BEGIN
    IF INSERTING THEN
        INSERT INTO AUDITORIA (ID, TABLA_AFECTADA, FECHA_ACCION, ACCION)
        VALUES (:NEW.ID, 'video', SYSDATE, 'insert');
    ELSIF UPDATING THEN
        INSERT INTO AUDITORIA (ID, TABLA_AFECTADA, FECHA_ACCION, ACCION)
        VALUES (:NEW.ID, 'video', SYSDATE, 'update');
    END IF;
END;

-- Trigger para la tabla IMAGEN
CREATE OR REPLACE TRIGGER trg_imagen_audit
AFTER INSERT OR UPDATE ON IMAGEN
FOR EACH ROW
BEGIN
    IF INSERTING THEN
        INSERT INTO AUDITORIA (ID, TABLA_AFECTADA, FECHA_ACCION, ACCION)
        VALUES (:NEW.ID, 'imagen', SYSDATE, 'insert');
    ELSIF UPDATING THEN
        INSERT INTO AUDITORIA (ID, TABLA_AFECTADA, FECHA_ACCION, ACCION)
        VALUES (:NEW.ID, 'imagen', SYSDATE, 'update');
    END IF;
END;

-- Trigger para la tabla PDF
CREATE OR REPLACE TRIGGER trg_pdf_audit
AFTER INSERT OR UPDATE ON PDF
FOR EACH ROW
BEGIN
    IF INSERTING THEN
        INSERT INTO AUDITORIA (ID, TABLA_AFECTADA, FECHA_ACCION, ACCION)
        VALUES (:NEW.ID, 'pdf', SYSDATE, 'insert');
    ELSIF UPDATING THEN
        INSERT INTO AUDITORIA (ID, TABLA_AFECTADA, FECHA_ACCION, ACCION)
        VALUES (:NEW.ID, 'pdf', SYSDATE, 'update');
    END IF;
END;