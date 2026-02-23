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
begin
--Asignar el saludo
  v_saludo:='hola ' || v_name||' Bienvenida a DAM'
--Imprimir en consola el print o sout d toda la vida
  dbms_output.put_line(v_saludo)
  dbms_output.put_line(v_fecha)
  dbms_output.put_line(v_total)
end;