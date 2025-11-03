#bucle que muuestra los numeros del 1 al 10
i=1
while i<=10:
    print(i)
    i+=1   
    
#bucle de valiuacion para que el usuario introduzca un numero posiitivo
numero=input("Introduce un numero positivo: ")
while int(numero)<0:     
    print("El numero no es positivo, vuelve a intentarlo")
    numero=input("Introduce un numero positivo: ")
print(f"El numero introducido es {numero}") 