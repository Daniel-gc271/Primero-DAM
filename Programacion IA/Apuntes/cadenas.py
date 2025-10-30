
#declaracion de cadenas

mensaje1 ="    Hola caracola       "
mensaje2='Hola caracola'
mensaje3= """Eu Lorem et voluptate reprehenderit laborum consequat cillum magna ullamco excepteur proident do consequat. Duis exercitation occaecat minim est nisi duis commodo fugiat anim enim proident ullamco aliqua eu. Ex ea excepteur ex deserunt quis laboris ea in proident minim dolor Lorem.  """
mensaje4='''In do ex quis dolor. '''

#operaciones con cadenas


print(len(mensaje1)) #Longitud de la cadena
print()
print("Antes") 
print(mensaje1) #Eliminar espacios del inicio y el final
print("Despues")
print(mensaje1.strip()) #Eliminar espacios del inicio y el final
print("En minusculas")
print(mensaje1.lower()) #Minusculas
print("En mayusculas")
print(mensaje1.upper()) #Mayusculas

mensaje5="Hola mundo"
mensaje6=mensaje5.replace("u","a")#reemplaza u por a
print(mensaje6)
print(mensaje5.replace("Hola","Adios"))

codigoArticulo="ABC-123-45678-XXX"
print(codigoArticulo.split("-"))
palabras=mensaje3.split(" ")

print(f"lista de palabras, ",palabras)