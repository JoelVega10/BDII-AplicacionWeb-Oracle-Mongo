create or replace function desencriptar (tmp_carne integer) return integer is
pin_desencriptado integer;
begin
select UTL_RAW.CAST_TO_varchar2(DBMS_CRYPTO.decrypt(getPin(tmp_carne), 4353, UTL_RAW.CAST_TO_RAW ('A1A2A3A4A5A6CAFE'))) into pin_desencriptado from dual;
return (pin_desencriptado);
end;

create or replace function getPin (tmp_carne integer) return varchar2 is
pin_encriptado varchar2(100);
begin
SELECT pin into pin_encriptado from estudiante where carne = tmp_carne;
return (pin_encriptado);
end;

create or replace function encriptar (pin integer) return varchar2 is
pin_encriptado varchar2(100);
begin
select DBMS_CRYPTO.encrypt(UTL_RAW.CAST_TO_RAW(pin), 4353, UTL_RAW.CAST_TO_RAW ('A1A2A3A4A5A6CAFE')) into pin_encriptado from dual;
return (pin_encriptado);
end;