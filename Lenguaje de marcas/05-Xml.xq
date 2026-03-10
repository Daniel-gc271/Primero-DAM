(: Productos con stock entre 3 y 6:)
(://produc[stocka_actual>3 and stock_actual<6]:)
(:Apellido de los empleados del departamento 20:)
(://EMPLEADOS/EMP_ROW[ DEPT_NO=20]/APELLIDO:)
(: empleados cuyo sueldo sea mayor a 20000 :)
(: //empleado[@salario>2000] :)
(:Codigo de departamento con ermpleados cuyo sueldo sea mayor a 2000:)
(: //empleado[@salario>2000]/../codigo :)
(: Data: elimina las etiquetas xml  :)  
(: //EMPLEADOS/EMP_ROW/number(data(@salario)) :)
(:Substring subcadena desde la posicion indicada :)
(: //fila_socios/substring(NOMBRE,2) :)
(: //lower-case(data/(OFICIO)) :)
(: //concat("el oficio es: ",lower-case(data(OFICIO))) :)
(: empledao con salario entre 1000 y 2000 :)
(: //EMPLEADOS/EMP_ROW[SALARIO>=1000 and SALARIO<=2000]/concat("el empleado: ",APELLIDO," cobra entre 1000 y 2000 euros") :)
(: contains :)
(: //EMPLEADOS/EMP_ROW[contains(OFICIO,"EMP")] :)
(: starts-with :)
(: //EMPLEADOS/EMP_ROW[starts-with(OFICIO,"D")] :)
(: avg calcula la media :)
(: avg(//SALARIO) :)
(: count cuenta :)
(: count(//EMP_ROW[OFICIO="DIRECTOR"]) :)
(: count(//EMPLEADOS/EMP_ROW[SALARIO>=1000 and SALARIO<=2000]) :)
(: max(//SALARIO),
min(//SALARIO) :)
(: distinct-values omite repeticion :)
(: count(//OFICIO), :)
(: count(distinct-values(//OFICIO)) :)
(: mostrar el codigo de articulo de aquellos productos cuyo pvp supera la media de los pvp de todos los articulos :)
(: //facturastotal/articulo[//pvp>avg(/pvp)]/@codigo :)
(: distinct-values(//articulo[pvp>avg(//pvp)]/@codigo) :)
(: //EMP_ROW[SALARIO>avg(//SALARIO)]/APELLIDO :)
(: //EMPLEADOS/EMP_ROW[SALARIO=max(//EMP_ROW/SALARIO)]/EMP_NO :)
(: count(/EMPLEADOS/EMP_ROW) :)
(: count(//EMP_ROW[SALARIO>avg(//SALARIO)]/APELLIDO ) :) 
(: distinct-values(//OFICIO) :)
(: sum(//SALARIO) :)
(: sum(distinct-values(//SALARIO)) :)
(: sum(//EMPLEADOS/EMP_ROW[DEPT_NO=30 or DEPT_NO=20]/SALARIO) :)

(: //productos/produc[stock_actual<5] :)

(: //productos/produc[number(stock_actual)<=number(stock_minimo)] :)

(: Actividad :)
(: //productos/produc/concat("Denominacion: ",denominacion,"|", "Precio: ",precio) :)
(: //productos/produc[starts-with(denominacion,"P")] :)
(: //productos/produc[precio>60 and cod_zona=20] :)
(: count(//productos/produc[starts-with(denominacion,"M") and cod_zona=10]) :)
(: avg(//productos/produc[starts-with(denominacion,"M")]/precio ) :)
(: //productos/produc[number(stock_minimo)>number(stock_actual)] :)

(: //productos/produc[number(stock_minimo)>number(stock_actual)and cod_zona=40]/(denominacion ,precio) :)
(: //productos/produc[precio=max(//productos/produc/precio)] :)

(: //productos/produc[number(precio)=min(//productos/produc/precio) and number(//productos/produc/cod_zona = 20)] :)
(: //productos/produc[(precio=max(//productos/produc[cod_zona=10]/precio)) ] :)

(: correccion :)

(: //productos/produc[number(precio)=min(//productos/produc[cod_zona=20]/precio)] :)
(: empleado que mas y que menos cobra deol departamento 20 :)
(: dep 20  :)
(: /EMPLEADOS/EMP_ROW[DEPT_NO=20]/SALARIO :)
(: //EMP_ROW[SALARIO=max(//EMP_ROW[DEPT_NO=20]/SALARIO)] :)


(: //EMP_ROW[(SALARIO=max(//EMP_ROW[DEPT_NO=20]/SALARIO) or (SALARIO=min(//EMP_ROW[DEPT_NO=20]/SALARIO)) and DEPT_NO=20)] :)

(: Joins :)
(: //EMPLEADOS/EMP_ROW/concat(APELLIDO,' ',DEPT_NO) :)


(: Actividad 2 :)

(: A :)
(: //sucursales/sucursal/cuenta[@tipo="AHORRO"] :)

(: b :)
(: concat(//sucursales/sucursal/@codigo," ",count(//sucursales/sucursal/cuenta[@tipo="AHORRO"])) :)
(: correccion: :)
(: //sucursales/sucursal/concat(@codigo," : ",count(cuenta[@tipo="AHORRO"])) :)

(: c :)
(: //sucursales/sucursal[@codigo="SUC3"]/cuenta[@tipo="PENSIONES"] :)
(: correccion :)
(: //sucursales/sucursal[@codigo="SUC3"]/cuenta[@tipo="PENSIONES"] :)

(: d :)
(: correccion :)
(: //sucursales/sucursal/concat(@codigo, " - ", director, " - ",sum(cuenta/saldohaber)) :)
(: e :)
(: correccion :)
(: //sucursales/sucursal[count(cuenta)>3] :)
(: f :)
(: correccion :)
(: //sucursales/sucursal[count(cuenta/[@tipo="AHORRO"])>3] :)
(: g :)
(: correcion :)
(: //sucursal[count(cuenta)>3]/concat(director," - ",poblacion) :)


(: h :)
(: count(//sucursales/sucursal[poblacion = "Madrid"]) :)

(: i :)


//sucursales/sucursal/concat(/@codigo," - ",sum(/cuenta[@tipo="PENSIONES"]/saldohaber))
(: j  :)
//sucursales/sucursal/cuenta[saldohaber>10000]/concat(/nombre," ",/numero," ",/saldohaber)

(:k:)
//sucursales/sucursal[count(/cuenta/@tipo="AHORRO")>3]/concat(/@codigo, " ", sum(/cuenta/saldodebe)



(:Actividad 3:)

(:A:)
for $z in distinct-values(//produc/cod_zona)
return <resultado>
    <zona>{$z}</zona>
    <cantidad>{count(//produc[cod_zona=$z])}</cantidad>
</resultado>
(:B:)
for $p in //produc
return concat('<zona',$p/cod_zona,'>',$p/denominacion,'<zona',$p,'/>'+)

(:C:)
for $z in distinct-values(//produc/cod_zona)
let $maxPrecio := max(//produc[cod_zona=$z]/precio)
return <producto-mas-car>
    <zona>{$z}</zona>
    <denominacion>{//produc[cod_zona=$z and precio=$maxPrecio]/denominacion}</denominacion>
    <precio>{$maxPrecio}</precio>
</producto-mas-car>

-(:D:)
for $p in //produc
return typeswitch(true())
    case contains($p/denominacion, "Placa Base") return <placa>{$p/denominacion}</placa>
    case contains($p/denominacion, "Memoria") return <memoria>{$p/denominacion}</memoria>
    case contains($p/denominacion, "Micro") return <micro>{$p/denominacion}</micro>
    default return <otros>{$p/denominacion}</otros>
(:E:)
for $s in //sucursales/sucursal
return
<sucursal>
    <codigo>{$s/@codigo}</codigo>
    <ahorros>{count($s/cuenta[@tipo="AHORRO"])}</ahorros>
    <pensiones>{count($s/cuenta[@tipo="PENSIONES"])}</pensiones>
</sucursal>
(:F:)
for $s in //sucursales/sucursal
return <sucursal>
    <codigo>{$s/@codigo}</codigo>
    {$s/director}
    {$s/poblacion}
    <total-debe>{sum($s/cuenta/debe)}</total-debe>
    <total-haber>{sum($s/cuenta/haber)}</total-haber>
</sucursal>
-(:G:)
for $s in //sucursal
where count($s/cuentas/cuenta) > 3
return <sucursal>
    <director>{$s/director}</director>
    <codigo>{$s/codigo}</codigo>
    <poblacion>{$s/poblacion}</poblacion>
</sucursal>
-(:H:)
for $s in //sucursal
let $maxDebe := max($s/cuentas/cuenta/debe)
return <sucursal>
    <codigo>{$s/codigo}</codigo>
    <cuenta-mas-debe>
        <tipo>{$s/cuentas/cuenta[debe=$maxDebe]/tipo}</tipo>
        <debe>{$s/cuentas/cuenta[debe=$maxDebe]/debe}</debe>
        <haber>{$s/cuentas/cuenta[debe=$maxDebe]/haber}</haber>
    </cuenta-mas-debe>
</sucursal>
(:I:)
for $c in //sucursales/sucursal/cuenta[@tipo="PENSIONES"]
where $c/aportacion = max(//sucursales/sucursal/cuenta[@tipo="PENSIONES"]/aportacion)
return $c


