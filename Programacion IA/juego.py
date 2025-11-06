import random
#crear variables
user_input=0 #Numero que da el usuario
numero_intentos=0 #Contador de intentos
target_number= random.randint(0,100) #Generar numero aleatorio
print("Vienvenido al casino de ciudad malvalona,")
print("en este casino tndras que acertar un numero entre 0 y 100 incluidos, buena suerte")
print("se trata de un torneo y aquel que acierte en menos intentos se llevara el bote")
print("Comienza el juego")
while(user_input!=target_number): #bucle que se itera hasta atinar el objetivo
    numero_intentos+=1
    user_input=int(input("Introduce un numero entre 0 y 100"))
    if user_input>target_number:
        print("El numero secreto es menor al numero introducido")
    else:
        print("El numero secreto es mayor al numero introducido")
print(f"Enhorabuena, te ha tomado {numero_intentos} acertar en numero secreto")