""" 
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
"""
#Comprobar tiempos de ejecucion
import time
inicio=time.time()
#codigo a ejecutar
fibonnaci=[0,1]
for i in range(2,30): 
    fibonnaci.append(fibonnaci[i-1]+fibonnaci[i-2])
    print(f"{fibonnaci[i]}\n")
fin=time.time()
print(f"El tiempo de ejecucion es {fin-inicio:.10f} segundos")