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
          from hr.employees where department_id = 50) loop
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