#Estructura if, elif, else
edad=int(input("Introduce tu edad: ")) 
if edad<18:
    print("Eres menor de edad") 
elif edad>=18:
    print("Eres mayor de edad")
carnet=input("¿Tienes carnet de conducir? (si/no): ").lower()
if carnet=="si":
    carnet=True
else:
    carnet=False    
if carnet and edad>=18:
    print("Puedes conducir")
elif carnet and edad<18:
    print("No puedes tener carnet, eres menor de edad!")
#Ejemplo anidado
A=1
B=2
C=3
if A<B<C:
    print("estan en orden creciente")
elif A>C>B:
        print("estan en orden decreciente")
else:
    print("no estan en orden")
if A<B<C:
    print("estan en orden creciente")
elif A>C>B:
        print("estan en orden decreciente")
else:
    print("no estan en orden")
if A<B<C:
    print("estan en orden creciente")
else:
    if A>C>B:
        print("estan en orden decreciente")
    else:
        print("no estan en orden")