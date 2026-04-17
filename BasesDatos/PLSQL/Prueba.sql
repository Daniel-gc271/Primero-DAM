
-- #region E1
/*
Realizar un PL/SQL que liste los empleados (EMPLOYEES del esquema
HR de Oracle) de un departamento realizando las siguientes
instrucciones:
1. Declaración de variables: Deben coincidir con la definición de la
tabla.
2. SELECT INTO: Se usa para contar empleados y para asignar valores
en el bucle.
3. Bucle : Recorre los resultados de una consulta.
4. Excepciones:
o NO_DATA_FOUND: Excepción predefinida.
o ex_no_employees: Excepción personalizada para cuando no
hay empleados en el departamento.
o OTHERS: Captura cualquier otro error.
5. Muestra resultados en consola de las siguientes columnas:
EMPLOYEE_ID, FIRST_NAME, LAST_NAME, DEPARTMENT_ID, SALARY.
E1
*/

DECLARE
/*1.
    Declaración de variables: Deben coincidir con la definición de la
    tabla. (%TYPE)
*/
    v_empl_id hr.EMPLOYEES.EMPLOYEE_ID%TYPE;
    v_empl_app1 hr.EMPLOYEES.FIRST_NAME%TYPE;
    v_empl_app2 hr.EMPLOYEES.LAST_NAME%TYPE;
    v_empl_sal hr.EMPLOYEES.SALARY%TYPE;
    v_dept_id hr.EMPLOYEES.DEPARTMENT_ID%TYPE := 50;
    v_num_emp NUMBER;
BEGIN
/*
    2. SELECT INTO: Se usa para contar empleados y para asignar valores
    en el bucle.
*/
    select count(*) into  v_num_emp
    from hr.EMPLOYEES
    where DEPARTMENT_ID =v_dept_id;
    if (v_count_e =0) then {
        raise ex_no_empleados;
    } end if;
/*  
    3. Bucle : Recorre los resultados de la consulta.
*/
    for emp in (
        select * from hr.EMPLOYEES where DEPARTMENT_ID = v_dept_id
    ) loop 
    v_empl_id := emp.EMPLOYEE_ID;
    v_empl_app1 emp.FIRST_NAME;
    v_empl_app2 emp.LAST_NAME;
    v_empl_sal emp.SALARY;
/*
    5. Muestra resultados en consola de las siguientes columnas:
    EMPLOYEE_ID, FIRST_NAME, LAST_NAME, DEPARTMENT_ID, SALARY.
*/
    DBMS_OUTPUT.PUT_LINE('Id:'|| v_empl_id ||'-Nombre:'|| v_empl_app1 ||' '||v_empl_app2 ||'Salario:'|| v_empl_sal emp.SALARY;);
    end loop;
/*
4. Excepciones:
o NO_DATA_FOUND: Excepción predefinida.
o ex_no_employees: Excepción personalizada para cuando no
hay empleados en el departamento.
o OTHERS: Captura cualquier otro error.
*/
EXCEPTION
     WHEN ex_no_empleados THEN
     DBMS_OUTPUT.PUT_LINE('No hay empleados para ese departamento');   
  WHEN NO_DATA_FOUND THEN
     DBMS_OUTPUT.PUT_LINE('No hay empleados en el dpto'|| v_dpto_id);
  WHEN OTHERS THEN 
     DBMS_OUTPUT.PUT_LINE('ERROR DESCONOCIDO');       
END;
-- #endregion
/*
Crear una función llamada calcular_bonus que reciba el salario de un
empleado y devuelva el bonus (10% del salario).
- Crear un procedimiento llamado mostrar_info_empleado que:
Reciba el id_empleado. Si no existe el empleado se controlará la excepción
y se mostrará el mensaje “No existe un empleado con ese ID.”.
• Obtenga su nombre y salario.
• Llame a la función calcular_bonus.
• Muestre por pantalla el nombre, salario y bonus.
*/
/*
    1- Recibo el salario en forma de number
*/
    create or replace function calcular_bonus(
        emple_sal number
    )   return number 
    is
/*
    2- Declaro la variable con el bonus
*/
    v_bonus :=0;
    begin
/*
    3- Calculo el bonus
*/
    v_bonus:= emple_sal*0.10;
/*
    4- Recibo el salario en forma de number
*/
    return v_bonus;
    end;

create or replace procedure mostrar_info_empleado (
    empl_id number;
)   is 
select nombre, salario 
into v_nombre, v_salario 
from empleados 
where Id_empleado = empl_number;

