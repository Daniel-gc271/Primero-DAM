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


declare
    v_nombre hr.employees.first_name%type; --Asigna el tipo de dato de la columna first_name de la tabla employees a la variable v_nombre
    v_salario hr.employees.salary%type;
    begin
    select first_name, salary into v_nombre, v_salario from hr.employees where employee_id = 100;
    dbms_output.put_line('El nombre del empleado es: ' || v_nombre '\nEl salario del empleado es: ' || v_salario);

    end;

    declare
      v_empleado hr.employees%ROWTYPE; --Declara una variable de tipo fila completa de la tabla employees
    begin
      select * 
      into v_empleado 
      from hr.employees 
      where employee_id = 100;
      dbms_output.put_line('Nombre: ' || v_empleado.first_name);
      dbms_output.put_line('Salario: ' || v_empleado.salary);
      dbms_output.put_line('Departamento: ' || v_empleado.department_id);
    end;
    declare
      v_empId hr.employees.employee_id%type := 100; --Declara una variable para el ID del empleado
      v_empleado hr.employees%ROWTYPE; --Declara una variable de tipo fila completa de la tabla employees
    begin
      select * 
      into v_empleado 
      from hr.employees 
      where employee_id = v_empId; --Utiliza la variable v_empId en la cláusula WHERE
      dbms_output.put_line('Nombre: ' || v_empleado.first_name);
      dbms_output.put_line('Salario: ' || v_empleado.salary);
      dbms_output.put_line('Departamento: ' || v_empleado.department_id);
    end;
  
  declare
    v_empId
  hr.employees.employee_id%type;
    v_nombre hr.employees.first_name%type;
    v_apellido1 hr.employees.last_name%type;
    v_apellido2 hr.employees.last_name%type;
    v_depId hr.employees.department_id%type;
    v_salario hr.employees.salary%type;
    v_count number;
    ex_no_employees exception;
    begin
    select count(*) into v_count from hr.employees where department_id = 50;
    
    if v_count = 0 then
      raise ex_no_employees;
    end if;
    
    for emp in (select employee_id, first_name, last_name, department_id, salary 
          from hr.employees where department_id = 50) 
          loop
      dbms_output.put_line('ID: ' || emp.employee_id || ', Nombre: ' || emp.first_name || 
                ', Apellido: ' || emp.last_name || ', Depto: ' || emp.department_id || 
                ', Salario: ' || emp.salary);
    end loop;
    
    exception
    when ex_no_employees then
      dbms_output.put_line('Error: No hay empleados en este departamento');
    when no_data_found then
      dbms_output.put_line('Error: No se encontraron datos');
    when others then
      dbms_output.put_line('Error inesperado: ' || sqlerrm);
    end;

--La funcion se puede llamar en una select, en un bloque anonimo, en un procedimiento almacenado, retorna valor etc
--el procedimiento almacenado se puede llamar desde una aplicacion externa, desde sql developer, retorno void etc
--la funcion devuelve un valor, el procedimiento almacenado no devuelve un valor, pero puede devolver un resultado a traves de parametros de salida
--Funcion para obtener el nombre de un empleado dado su ID
CREATE  FUNCTION get_employee_name (p_empId IN hr.employees.employee_id%type)
RETURN hr.employees.first_name%type
Create or replace procedure get_employee_info (p_empId IN hr.employees.employee_id%type, 
                                p_name OUT hr.employees.first_name%type, 
                                p_salary OUT hr.employees.salary%type)

CREATE  function saludarF (p_nombre IN varchar2) As begin
    return 'Hola ' || p_nombre || ', bienvenido a PL/SQL!';
end;
create procedure saludarP (p_nombre IN varchar2) As begin
    dbms_output.put_line('Hola ' || p_nombre || ', bienvenido a PL/SQL!');
end;

begin
    dbms_output.put_line(saludarF('Ruth'));
    saludarP('Ruth');
end;
exec  saludarP('Ruth');
--Llamar a la función en una consulta SQL
select cuadrado(4) as resultado from dual;
create or replace function cuadrado (p_num IN number) return number as
begin
    return p_num * p_num;
end;
declare
    v_num number := 5;
    v_result number;
begin
    v_result := cuadrado(v_num);
    dbms_output.put_line('El cuadrado de ' || v_num || ' es ' || v_result);
end;





CREATE OR REPLACE FUNCTION calcular_bonus (
    p_salario NUMBER
) RETURN NUMBER
IS
BEGIN
    RETURN p_salario * 0.10;
END;

CREATE OR REPLACE PROCEDURE mostrar_info_empleado (
    p_id_empleado EMPLEADOS.id_empleado%TYPE
)
IS
    v_nombre   EMPLEADOS.nombre%TYPE;
    v_salario  EMPLEADOS.salario%TYPE;
    v_bonus    NUMBER;
BEGIN
    SELECT nombre, salario
    INTO v_nombre, v_salario
    FROM EMPLEADOS
    WHERE id_empleado = p_id_empleado;

    v_bonus := calcular_bonus(v_salario);

    DBMS_OUTPUT.PUT_LINE('Nombre: ' || v_nombre || ' (ID: ' || p_id_empleado || ')');
    DBMS_OUTPUT.PUT_LINE('Salario: ' || v_salario || ' €');
    DBMS_OUTPUT.PUT_LINE('Bonus: ' || v_bonus || ' €');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No existe un empleado con ese ID.');
END;

BEGIN
    mostrar_info_empleado(1);
END;



create table datos (emp_no NUMBER(4) PRIMARY KEY);
insert into DATOS values (7566);
select * EMPLE;


declare
    v_empno emple.EMP_NO%TYPE;
    v_salarioActual emple.SALARIO%TYPE;
    v_job emple.OFICIO%TYPE;
    v_empls NUMBER;
    v_incre number := 0;
begin
  select EMP_NO into v_empno from datos;

  select SALARIO,OFICIO into v_salarioActual,v_job from datos where EMP_NO = v_empno;
  select count(*) v_empls;
  from EMPLE where DIR=v_empno;
  if v_empls = 0 then 
    v_incre := 50;
  else if v_empls = 1 then 
    v_incre := 80;
   else if v_empls = 2 or v_empls = 3 then 
    v_incre := 100;
  else  v_incre := 110;
  end if;

  if v_job = "PRESIDENTE" then v_incre := v_incre + 30;
  

 end;

select * from hr.DEPARTMENTS;

create or replace PROCEDURE eliminarDepartamento (numDpt NUMBER)
--cursor que obtiene todos los ids de los empleados a eliminar
is cursor c_empDep is select EMPLOYEE_ID  from HR.EMPLOYEES where DEPARTMENT_ID = numDpt;
BEGIN
    insert into HR.DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME,LOCATION_ID) VALUES (1,"Provisional",1)
    EXCEPTION 
         /*si el departamento ya existe no hacer nada*/
        when DUP_VAL_ON_INDEX then 
        --Excepcion buscada de IA no fiable 
        DBMS_OUTPUT.PUT_LINE("Y existe un departamento provisional")

END;


DECLARE
  v_tot number:=0;
  v_sal_alto number := 0;
BEGIN
  SELECT SUM(salario + comision), SUM(case when salario>2000 hten 1 else 0 end)
    into v_tot, v_sal_alto
    from EMPLE;
DBMS_OUTPUT.PUT_LINE('Total ganancias'|| v_tot) ;   
DBMS_OUTPUT.PUT_LINE('Empleados con salario mayor a dos mil euros'|| v_sal_alto);    
EXCEPTION

  When no_data_found then 
  DBMS_OUTPUT.PUT_LINE('No hay empleados en la tabla');
  When others then 
  DBMS_OUTPUT.PUT_LINE('Error inesperado');
    
END;