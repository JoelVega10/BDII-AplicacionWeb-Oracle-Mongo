CREATE OR REPLACE TRIGGER guardar_historial_estudiante
	AFTER INSERT OR UPDATE OR DELETE
                    ON estudiante
                        FOR EACH ROW
DECLARE
    operacion VARCHAR2(1000);
    usuario VARCHAR2(1000);
    nombre_tabla VARCHAR2(1000);
    datos_viejos VARCHAR2(1000);
    id_tabla NUMBER;
    datos_nuevos VARCHAR2(1000);
    fecha DATE;
BEGIN

	    IF INSERTING THEN
	        operacion := 'Insertar';
	    ELSIF UPDATING THEN
	        operacion := 'Actualizar';
	    ELSIF DELETING THEN
	        operacion := 'Eliminar';
END IF;

SELECT SYSDATE INTO fecha
FROM dual;

SELECT USER INTO usuario
FROM dual;

nombre_tabla := 'estudiante';
	    id_tabla := :old.id;
                        datos_viejos := 'ID: '        || :old.id        || chr(10) ||
                        'CEDULA: '    || :old.cedula    || chr(10) ||
                        'CARNE: '    || :old.carne    || chr(10) ||
                        'PIN: '    || :old.pin    || chr(10) ||
						'NOMBRE: '    || :old.nombre    || chr(10) ||
                        'PRIMER_APELLIDO: '    || :old.primer_apellido    || chr(10) ||
                        'SEGUNDO_APELLIDO: '    || :old.segundo_apellido    || chr(10) ||
                        'CORREO: '    || :old.correo    || chr(10) ||
						'DIRECCION: ' || :old.direccion || chr(10) ||
						'TELEFONO: '  || :old.telefono  || chr(10);

	    	    datos_nuevos := 'ID: '        || :new.id        || chr(10) ||
                        'CEDULA: '    || :new.cedula    || chr(10) ||
                        'CARNE: '    || :new.carne    || chr(10) ||
                        'PIN: '    || :new.pin    || chr(10) ||
						'NOMBRE: '    || :new.nombre    || chr(10) ||
                        'PRIMER_APELLIDO: '    || :new.primer_apellido    || chr(10) ||
                        'SEGUNDO_APELLIDO: '    || :new.segundo_apellido    || chr(10) ||
                        'CORREO: '    || :new.correo    || chr(10) ||
						'DIRECCION: ' || :new.direccion || chr(10) ||
						'TELEFONO: '  || :new.telefono  || chr(10);


INSERT INTO historial(operacion,usuario,nombre_tabla,id_tabla,datos_anteriores,datos_nuevos)
VALUES(operacion, usuario, nombre_tabla, id_tabla, datos_viejos, datos_nuevos);

END;

CREATE OR REPLACE TRIGGER guardar_historial_profesor
    AFTER INSERT OR UPDATE OR DELETE
                    ON profesor
                        FOR EACH ROW
DECLARE
    operacion VARCHAR2(1000);
    usuario VARCHAR2(1000);
    nombre_tabla VARCHAR2(1000);
    datos_viejos VARCHAR2(1000);
    id_tabla NUMBER;
    datos_nuevos VARCHAR2(1000);
    fecha DATE;
BEGIN

    IF INSERTING THEN
        operacion := 'Insertar';
    ELSIF UPDATING THEN
        operacion := 'Actualizar';
    ELSIF DELETING THEN
        operacion := 'Eliminar';
END IF;

SELECT SYSDATE INTO fecha
FROM dual;

SELECT USER INTO usuario
FROM dual;

nombre_tabla := 'profesor';
    id_tabla := :old.id;
    datos_viejos := 'ID: '        || :old.id        || chr(10) ||
                    'CEDULA: '    || :old.cedula    || chr(10) ||
                    'NOMBRE: '    || :old.nombre    || chr(10) ||
                    'PRIMER_APELLIDO: '    || :old.primer_apellido    || chr(10) ||
                    'SEGUNDO_APELLIDO: '    || :old.segundo_apellido    || chr(10) ||
                    'CORREO: '    || :old.correo    || chr(10) ||
                    'DIRECCION: ' || :old.direccion || chr(10) ||
                    'TELEFONO: '  || :old.telefono  || chr(10) ||
                    'ID_SEDE: ' || :old.id_sede || chr(10);


    datos_nuevos := 'ID: '        || :new.id        || chr(10) ||
                    'CEDULA: '    || :new.cedula    || chr(10) ||
                    'NOMBRE: '    || :new.nombre    || chr(10) ||
                    'PRIMER_APELLIDO: '    || :new.primer_apellido    || chr(10) ||
                    'SEGUNDO_APELLIDO: '    || :new.segundo_apellido    || chr(10) ||
                    'CORREO: '    || :new.correo    || chr(10) ||
                    'DIRECCION: ' || :new.direccion || chr(10) ||
                    'TELEFONO: '  || :new.telefono  || chr(10) ||
                    'ID_SEDE: ' || :new.id_sede || chr(10);


INSERT INTO historial(operacion,usuario,nombre_tabla,id_tabla,datos_anteriores,datos_nuevos)
VALUES(operacion, usuario, nombre_tabla, id_tabla, datos_viejos, datos_nuevos);

END;

CREATE OR REPLACE TRIGGER guardar_historial_curso
    AFTER INSERT OR UPDATE OR DELETE
                    ON curso
                        FOR EACH ROW
DECLARE
    operacion VARCHAR2(1000);
    usuario VARCHAR2(1000);
    nombre_tabla VARCHAR2(1000);
    datos_viejos VARCHAR2(1000);
    id_tabla NUMBER;
    datos_nuevos VARCHAR2(1000);
    fecha DATE;
BEGIN

    IF INSERTING THEN
        operacion := 'Insertar';
    ELSIF UPDATING THEN
        operacion := 'Actualizar';
    ELSIF DELETING THEN
        operacion := 'Eliminar';
END IF;

SELECT SYSDATE INTO fecha
FROM dual;

SELECT USER INTO usuario
FROM dual;

nombre_tabla := 'curso';
    id_tabla := :old.id;
    datos_viejos := 'ID: '        || :old.id        || chr(10) ||
                    'CODIGO: '    || :old.codigo    || chr(10) ||
                    'NOMBRE: '    || :old.nombre    || chr(10) ||
                    'CUPOS: '    || :old.cupos    || chr(10) ||
                    'GRUPO: '    || :old.grupo    || chr(10) ||
                    'HORARIO: '    || :old.horario    || chr(10) ||
                    'ID_SEDE: ' || :old.id_sede || chr(10) ||
                    'ID_PROFESOR: '  || :old.id_profesor  || chr(10);


    datos_nuevos := 'ID: '        || :new.id        || chr(10) ||
                    'CODIGO: '    || :new.codigo    || chr(10) ||
                    'NOMBRE: '    || :new.nombre    || chr(10) ||
                    'CUPOS: '    || :new.cupos    || chr(10) ||
                    'GRUPO: '    || :new.grupo    || chr(10) ||
                    'HORARIO: '    || :new.horario    || chr(10) ||
                    'ID_SEDE: ' || :new.id_sede || chr(10) ||
                    'ID_PROFESOR: '  || :new.id_profesor  || chr(10);


INSERT INTO historial(operacion,usuario,nombre_tabla,id_tabla,datos_anteriores,datos_nuevos)
VALUES(operacion, usuario, nombre_tabla, id_tabla, datos_viejos, datos_nuevos);

END;

CREATE OR REPLACE TRIGGER guardar_historial_sede
    AFTER INSERT OR UPDATE OR DELETE
                    ON sede
                        FOR EACH ROW
DECLARE
operacion VARCHAR2(1000);
    usuario VARCHAR2(1000);
    nombre_tabla VARCHAR2(1000);
    datos_viejos VARCHAR2(1000);
    id_tabla NUMBER;
    datos_nuevos VARCHAR2(1000);
    fecha DATE;
BEGIN

    IF INSERTING THEN
        operacion := 'Insertar';
    ELSIF UPDATING THEN
        operacion := 'Actualizar';
    ELSIF DELETING THEN
        operacion := 'Eliminar';
END IF;

SELECT SYSDATE INTO fecha
FROM dual;

SELECT USER INTO usuario
FROM dual;

nombre_tabla := 'sede';
    id_tabla := :old.id;
    datos_viejos := 'ID: '        || :old.id        || chr(10) ||
                    'NOMBRE: '    || :old.nombre    || chr(10) ||
                    'DIRECCION: '  || :old.direccion  || chr(10);


    datos_nuevos := 'ID: '        || :new.id        || chr(10) ||
                    'NOMBRE: '    || :new.nombre    || chr(10) ||
                    'DIRECCION: '  || :new.direccion  || chr(10);


INSERT INTO historial(operacion,usuario,nombre_tabla,id_tabla,datos_anteriores,datos_nuevos)
VALUES(operacion, usuario, nombre_tabla, id_tabla, datos_viejos, datos_nuevos);

END;