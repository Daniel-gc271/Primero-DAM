-- declare 
--     v_sal number(8,2);
-- begin
--     v_sal := 1000;
--     if v_sal < 1500 then
--         dbms_output.put_line('El salario es bajo');
--     elsif v_sal >= 1500 and v_sal < 3000 then
--         dbms_output.put_line('El salario es medio');
--     else
--         dbms_output.put_line('El salario es alto');
--     end if;
-- end;



declare
--Declarar las variables; diferentes tipos
    v_name varchar2(50):='Ruth';
    v_saludo varchar2(100);
    v_fecha date default sysdate;
    v_total number:=10*20;
    v_edad number;
    v_edad_exception exception;
begin
if v_edad is null then
    raise v_edad_exception;
    elsif v_edad < 18 then
        dbms_output.put_line('Eres menor de edad');
    else
        dbms_output.put_line('Eres mayor de edad');
end if;
exception
  when v_edad_exception then
    dbms_output.put_line('Error: La edad no puede ser nula');
  when zero_divide then
    dbms_output.put_line('Error: División por cero no permitida');
  when others then
    dbms_output.put_line('Error inesperado: ' || sqlerrm);
--Asignar el saludo
  v_saludo:='hola ' || v_name||' Bienvenida a DAM'
--Imprimir en consola el print o sout d toda la vida
  dbms_output.put_line(v_saludo)
  dbms_output.put_line(v_fecha)
  dbms_output.put_line(v_total)
end;