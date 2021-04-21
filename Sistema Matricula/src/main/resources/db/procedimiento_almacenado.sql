CREATE TABLE no_normalizada (
                                estudiante VARCHAR (400),
                                profesor VARCHAR (400),
                                sede VARCHAR (400),
                                curso VARCHAR (400),
                                historial VARCHAR(400)
);


INSERT INTO no_normalizada (estudiante,profesor,sede,curso) VALUES ('111111111 - 2021040506 - 9AF337025F6D406F - Bryan - Vega - Godinez - b@gmail.com - Alajuela - 77777777, 121212121 - 2021040510 - 83C681BF868422EC - Jimmy - Vega - Godinez - j@gmail.com - Alajuela - 55555555','454545454 - Josue - Vega - Godinez - jos@gmail.com - Alajuela - 44444444 - 1 , 464646434 - Stuard - Vega - Vasquez - stuard@gmail.com - Alajuela - 33333333 - 1 ','Campus San Jose - San Jose, Campus San Carlos - San Carlos','IC123 - Bases1 - 25 - G90 - Ly M 7:00am a 9:00am - 1 - 1, IC124 - Bases2 - 25 - G95 - L y M 7:00am a 9:00am - 1 - 1');

CREATE OR REPLACE PROCEDURE importar_datos AS

    type arreglo is array(10) of VARCHAR(300);
    datos_estudiante arreglo;
    datos_profesor arreglo;
    datos_sede arreglo;
    datos_curso arreglo;
    indice number;

CURSOR c1 is
        (Select * from no_normalizada);

CURSOR split1(datos IN VARCHAR) is

        (SELECT trim(regexp_substr(datos, '[^,]+', 1, LEVEL)) dato
         FROM dual
         CONNECT BY LEVEL <= regexp_count(datos, ',')+1);

CURSOR split2(datos IN VARCHAR) is

        (SELECT trim(regexp_substr(datos, '[^-]+', 1, LEVEL)) dato
         FROM dual
         CONNECT BY LEVEL <= regexp_count(datos, '-')+1);

BEGIN

for i in c1 loop

            if i.estudiante is not NULL then
                DBMS_OUTPUT.PUT_LINE(trim(i.estudiante));
for tabla IN split1(i.estudiante)
                    LOOP
                        DBMS_OUTPUT.PUT_LINE(tabla.dato);
                        indice := 1;
                        datos_estudiante := arreglo();
                        datos_estudiante.extend(10);
for columna in split2(tabla.dato)
                            LOOP
                                DBMS_OUTPUT.PUT_LINE(columna.dato);
                                datos_estudiante(indice) := trim(columna.dato);
                                indice := indice+1;
END LOOP;
INSERT INTO estudiante(cedula,carne,pin,nombre,primer_apellido,segundo_apellido,correo,direccion,telefono)
values(datos_estudiante(1),datos_estudiante(2),datos_estudiante(3),datos_estudiante(4),datos_estudiante(5),datos_estudiante(6),datos_estudiante(7),datos_estudiante(8),datos_estudiante(9));
END LOOP;

end if;

            if i.profesor is not NULL then
                DBMS_OUTPUT.PUT_LINE(trim(i.profesor));
for tabla IN split1(i.profesor)
                    LOOP
                        DBMS_OUTPUT.PUT_LINE(tabla.dato);
                        indice := 1;
                        datos_profesor := arreglo();
                        datos_profesor.extend(9);
for columna in split2(tabla.dato)
                            LOOP
                                DBMS_OUTPUT.PUT_LINE(columna.dato);
                                datos_profesor(indice) := trim(columna.dato);
                                indice := indice+1;
END LOOP;
INSERT INTO profesor(cedula,nombre,primer_apellido,segundo_apellido,correo,direccion,telefono,id_sede)
values(datos_profesor(1),datos_profesor(2),datos_profesor(3),datos_profesor(4),datos_profesor(5),datos_profesor(6),datos_profesor(7),datos_profesor(8));
END LOOP;

end if;


            if i.sede is not NULL then
                DBMS_OUTPUT.PUT_LINE(trim(i.sede));
for tabla IN split1(i.sede)
                    LOOP
                        DBMS_OUTPUT.PUT_LINE(tabla.dato);
                        indice := 1;
                        datos_sede := arreglo();
                        datos_sede.extend(3);
for columna in split2(tabla.dato)
                            LOOP
                                DBMS_OUTPUT.PUT_LINE(columna.dato);
                                datos_sede(indice) := trim(columna.dato);
                                indice := indice+1;
END LOOP;
INSERT INTO sede(nombre,direccion)
values(datos_sede(1),datos_sede(2));
END LOOP;

end if;

            if i.curso is not NULL then
                DBMS_OUTPUT.PUT_LINE(trim(i.curso));
for tabla IN split1(i.curso)
                    LOOP
                        DBMS_OUTPUT.PUT_LINE(tabla.dato);
                        indice := 1;
                        datos_curso := arreglo();
                        datos_curso.extend(8);
for columna in split2(tabla.dato)
                            LOOP
                                DBMS_OUTPUT.PUT_LINE(columna.dato);
                                datos_curso(indice) := trim(columna.dato);
                                indice := indice+1;
END LOOP;
INSERT INTO curso(codigo,nombre,cupos,grupo,horario,id_sede,id_profesor)
values(datos_curso(1),datos_curso(2),datos_curso(3),datos_curso(4),datos_curso(5),datos_curso(6),datos_curso(7));
END LOOP;

end if;

end loop;
END;

exec importar_datos
select * from no_normalizada;