# boleanos.py
# Ejemplos y explicación de booleanos en Python (True / False)

# 1) Literales booleanas
a = True
b = False
print("a =", a, "type:", type(a))
print("b =", b, "type:", type(b))
print()

# 2) Comparaciones (devuelven booleanos)
x = 10
y = 3
print("x > y ->", x > y)
print("x == y ->", x == y)
print("x != y ->", x != y)
print("Comparaciones encadenadas: 1 < x < 20 ->", 1 < x < 20)
print()

# 3) Conversión con bool(): qué es truthy y falsy
print("bool(0) ->", bool(0))           # 0 es falso
print("bool(1) ->", bool(1))           # cualquier entero distinto de 0 es verdadero
print("bool('') ->", bool(''))         # cadena vacía es falsa
print("bool('hola') ->", bool('hola')) # cadena no vacía es verdadera
print("bool([]) ->", bool([]))         # lista vacía es falsa
print("bool([1,2]) ->", bool([1,2]))   # lista no vacía es verdadera
print("bool(None) ->", bool(None))     # None es falso
print()

# 4) Operadores lógicos: and, or, not
p = True
q = False
print("p and q ->", p and q)   # True si ambos son True
print("p or q  ->", p or q)    # True si alguno es True
print("not p   ->", not p)     # invierte el valor
print()

# 5) Cortocircuito (short-circuit) en and/or
def lado_efecto():
    print(">>> función evaluada")
    return True

print("False and lado_efecto() ->", False and lado_efecto())  # lado_efecto NO se evalúa
print("True or lado_efecto() ->", True or lado_efecto())      # lado_efecto NO se evalúa
print("True and lado_efecto() ->", True and lado_efecto())    # lado_efecto se evalúa
print()

# 6) Booleanos como enteros: True == 1, False == 0
print("True == 1 ->", True == 1)
print("False == 0 ->", False == 0)
print("True + True ->", True + True)   # suma como enteros -> 2
print()

# 7) XOR lógico: usar != o el operador bit a bit ^
r1 = True
r2 = False
print("r1 != r2 (XOR) ->", r1 != r2)
print("r1 ^ r2 (bitwise XOR) ->", r1 ^ r2)
print()

# 8) Uso en estructuras de control
edad = 17
es_mayor = edad >= 18
if es_mayor:
    print("Acceso permitido")
else:
    print("Acceso denegado")
print()

# 9) Buenas prácticas
# - Usar booleanos para condiciones claras.
# - Evitar comparar con True/False usando "=="; es preferible "if condicion:" o "if not condicion:".
activo = True
if activo:           # correcto
    print("Activo")
if activo == True:   # redundante, pero válido
    print("Activo (comparado con True)")