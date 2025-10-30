# importar modulos
import math 
import random
from math import sqrt as RC
#usamos las funciones del modulo
potencia=math.pow(2,3)
while (True):
        aleatorio=random.randint(1,10)
        print(aleatorio)
        if aleatorio==5:
            break
#importar una funcion expecifia de los modulos

raiz=RC(2)
print(f"La raiz de dos es {raiz:.2f}")