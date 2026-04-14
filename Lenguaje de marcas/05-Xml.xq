Productos con stock entre 3 y 6
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


(: //sucursales/sucursal/concat(/@codigo," - ",sum(/cuenta[@tipo="PENSIONES"]/saldohaber))
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
return <producto-mas-caro>
    <zona>{$z}</zona>
    <denominacion>{//produc[cod_zona=$z and precio=$maxPrecio]/denominacion}</denominacion>
    <precio>{$maxPrecio}</precio>
</producto-mas-caro>

(:D:)
for $p in //produc
return
    if (contains($p/denominacion, "Placa Base")) then <placa>{data($p/denominacion)}</placa>
    else if (contains($p/denominacion, "Memoria")) then <memoria>{data($p/denominacion)}</memoria>
    else if (contains($p/denominacion, "Micro")) then <micro>{data($p/denominacion)}</micro>
    else () 
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
for $s in //sucursales/sucursal
where count($s/cuenta) > 3
return <sucursal>
    <director>{$s/director}</director>
    <codigo>{$s/codigo}</codigo>
    <poblacion>{$s/poblacion}</poblacion>
</sucursal>
-(:H:)
for $s in //sucursales/sucursal
let $maxDebe := max($s/cuenta/debe)
return <sucursal>
    <codigo>{$s/codigo}</codigo>
    <cuenta-mas-debe>
        <tipo>{$s/cuenta[debe=$maxDebe]/tipo}</tipo>
        <debe>{$s/cuenta[debe=$maxDebe]/debe}</debe>
        <haber>{$s/cuenta[debe=$maxDebe]/haber}</haber>
    </cuenta-mas-debe>
</sucursal>
(:I:)
for $c in //sucursales/sucursal/cuenta[@tipo="PENSIONES"]
where $c/aportacion = max(//sucursales/sucursal/cuenta[@tipo="PENSIONES"]/aportacion)
return $c
(:If:)
return if (:condicion:) then (:codijo/instruccion:)
else () En cualquier caso :)

(:Ejercicio 5:)
	(: for $suc in //sucursal
let $max := max($suc/cuenta/saldohaber)
let $nombre := $suc/cuenta[saldohaber = $max]/nombre
return concat($suc/@codigo, " - ", $max," - ", $nombre) :)



(: for $suc in //sucursal
let $maxSal := max($suc/cuenta/saldodebe)
for $cta in $suc/cuenta[@tipo='AHORRO']
return if($cta/saldodebe = $maxSal)
then <saldoMax>{$suc/@codigo}<sal>{$maxSal}</sal>{$cta/nombre}</saldoMax>
else () :)


(: for $productos in //produc
let $producto:= $productos/denominacion
for $zonas in /zonas/zona
let $nombre_zona:=$zonas/nombre
where $zonas/cod_zona=$productos/cod_zona
return concat($producto,' --- ', $nombre_zona) :)


(: for $den in /productos/produc[stock_minimo>5]
for $zona in /zonas/zona[cod_zona=$den/cod_zona]
let $prod:=$den/denominacion
let $nomdir:=$zona/director
return concat('codigo zona', $zona/cod_zona,'stock minimo >5', $prod,'nombre director',$nomdir,'nombre producto',$den/denominacion) :)


(:Modificaciones e inserciones:)
(:inserciones:)

(:update insert ELEMENTO into EXPRESION :) (:insertamos a una etiqueta xml/estruuctura dentro al final:)
(: update insert ELEMENTO following EXPRESION :) (:insertamos a una etiqueta xml/estructura despues de:)
(: update insert ELEMENTO preceding EXPRESION :) (:insertamos a una etiqueta xml/estructura antes de:)

(:
update insert 
<zona><cod_zona>50</cod_zona> 
<nombre>Madrid-OESTE </nombre> 
<director>Alicia Ramos Martin</director> </zona> into /zonas

:)
(: 
update insert 
<zona><cod_zona>35</cod_zona> 
<nombre>Valladolid-Valladolid </nombre> 
<director>Sergi Tenés Canos</director> </zona> preceding /zonas/zona[cod_zona=40] 
:)

(:
update insert 
<zona><cod_zona>45</cod_zona> 
<nombre>Valladolid-Valladolid </nombre> 
<director>Juanmi Latassa</director> </zona> following /zonas/zona[cod_zona=40] :)

(:
update insert 
<cuenta tipo="PENSIONES"><nombre>Alberto Morales 
</nombre><numero>30302900</numero> 
<aportacion>5000</aportacion></cuenta> 
into /sucursales/sucursal[@codigo="SUC1"]

:)


(: update replace NODO with VALOR NUEVO :)
(:Cambia el nodo completo:)
(: update replace 
/zonas/zona[cod_zona=40]/director 
with <directora>Pilar Martin Ramos</directora> :)

(: update value NODO with 'VALOR NUEVO' :)
(: actualiza un valor  :)



(: update delete NODO :)
(: Borra un valor:)
(: update delete //zona[cod_zona=50] :)

(:update rename /EMPLEADOS/EMP_ROW as 'fila_emple' :)
(: Renombra el nodo :)


(: COn for incremento del salario un 10% de los empleados del departamento 20 :)
(: for $empDpt in /EMPLEADOS/EMP_ROW[DEPT_NO=20]
return update value $empDpt/SALARIO with  ROUND(($empDpt/SALARIO) * 1.10) :)


(: Reemplazar los valores en oficio por empleado/a :)

(: for $empOfic in /EMPLEADOS/EMP_ROW[OFICIO="EMPLEADO"]
return update value $empOfic/OFICIO with "Empleado/Empleada" :)

(: update value /EMPLEADOS/EMP_ROW[OFICIO="EMPLEADO"]/OFICIO with "Empleado/Empleada" :)
(: Ejercicio 6 xml :)
ejercicio 1.


update insert
<EMP_ROW>
<SALARIO>2340</SALARIO>
<OFICIO>TECNICO</OFICIO>
<APELLIDO>PEDRO FRAILE</APELLIDO></EMP_ROW>
following //EMP_ROW[1]

(: 
  update insert
<EMP_ROW>
<SALARIO>2340</SALARIO>
<OFICIO>TECNICO</OFICIO>
<APELLIDO>PEDRO FRAILE</APELLIDO></EMP_ROW>
following  //EMP_ROW[1]

o

for $depart in //DEP_ROW[2]/DEPT_NO
return
update insert
<EMP_ROW>
<SALARIO>2340</SALARIO>
<OFICIO>TECNICO</OFICIO>
<APELLIDO>PEDRO FRAILE</APELLIDO>
<DEPT_NO>{data($depart)}</DEPT_NO></EMP_ROW>
into /EMPLEADOS




Ejercicio 2.


update replace /EMPLEADOS/EMP_ROW[EMP_NO=7902] with
<EMP_ROW> 
<EMP_NO>8043</EMP_NO> 
<APELLIDO>González</APELLIDO> 
<OFICIO>Programador</OFICIO> 
<DIR>7566</DIR> 
<FECHA_ALT>2013-05-23</FECHA_ALT> 
<SALARIO>2800</SALARIO> 
<DEPT_NO>60</DEPT_NO> 
</EMP_ROW>


Ejercicio 3

update insert 
<DEP_ROW><DEPT_NO>60</DEPT_NO><DNOMBRE>INFORMATICA</DNOMBRE><LOC>VALLADOLID</LOC></DEP_ROW>
into /departamentos

update insert 
<DEP_ROW><DEPT_NO>60</DEPT_NO><DNOMBRE>INFORMATICA</DNOMBRE><LOC>VALLADOLID</LOC></DEP_ROW>
following /departamentos/DEP_ROW[DEPT_NO=40]



Ejercicio 4.


for $em in /EMPLEADOS/EMP_ROW[DEPT_NO =20]
let $sal:= number($em/SALARIO + 100)
return update replace $em/SALARIO
with <SALARIO>{$sal}</SALARIO>


for $empl in /EMPLEADOS/EMP_ROW[DEPT_NO=20]
let $salario:=$empl/SALARIO
return update replace $salario with <SALARIO>{data($salario)+100}</SALARIO>



for $emp in /EMPLEADOS/EMP_ROW[DEPT_NO=20]
let $nuevosal:=$emp/SALARIO 
return update value $emp/SALARIO with data($nuevosal)+100



Ejercicio 5.


update rename /departamentos/DEP_ROW as 'filadepar'



Ejercicio 6. 


update delete 
//EMP_ROW[DEPT_NO=//DEP_ROW[LOC='VALLADOLID']/DEPT_NO]


opción

for $emple in //departamentos/filadep[LOC='VALLADOLID']
let $dep:=$emple/DEPT_NO
return update delete /EMPLEADOS/fila_emple[DEPT_NO=$dep]

opción 2

for $dep in (/EMPLEADOS/EMP_ROW/DEPT_NO)
for $depd in (/departamentos/DEP_ROW[LOC='VALLADOLID']/DEPT_NO)
return if($dep=$depd) then update delete /EMPLEADOS/EMP_ROW[DEPT_NO=$depd]
else()



Ejercicoi 7

A

for $dep in distinct-values(/departamentos/DEP_ROW/DEPT_NO)
let $media:=avg(/EMPLEADOS/EMP_ROW[DEPT_NO=$dep]/SALARIO)
return update insert <media>{$media}</media> into /departamentos/DEP_ROW[DEPT_NO=$dep]

for $dep in /departamentos/DEP_ROW
let $numdep:=data($dep/DEPT_NO), $sal:=avg(/EMPLEADOS/EMP_ROW[DEPT_NO=$numdep]/SALARIO)
return update insert <media> {$sal} </media> into $dep

B

update rename //empleados/EMP_ROW/OFICIO as 'puesto'

C

for $dep in //departamentos/EMP_ROW/DEPT_NO
return update insert <NUMEMPLE> {count(//empleados/EMP_ROW[DEP_NO=dep])}


D

idea recorrer todos los departamentos, bucle externo
luego buscar el numero de empleado con el sueldo mas alto entre todos los empleados en cierto departamento
posteriormente eliminar empleadomcon ese codigo
for $dep in //departamentos/filadep/DEPT_NO
let $empEliminar := //empleados/EMP_ROW[DEPT_NO=$dep and SALARIO = max(//empleados/EMP_ROW[DEPT_NO=$dep)/SALARIO]/EMP_NO
update delete //empleados/EMP_ROW[EMP_NO=$empEliminar]

E

update value
//EMP_ROW/OFICIO[./='VENDEDOR'] with 'COMERCIAL'


https://app.blackbox.ai/share/3d34d4aa-9fc4-4965-a4f1-0fdbab541cf2
