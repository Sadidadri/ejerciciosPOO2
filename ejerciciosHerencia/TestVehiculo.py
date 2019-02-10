'''
Created on 27 ene. 2019

@author: d18momoa
'''
from ejerciciosHerencia.Vehiculo import Vehiculo
from ejerciciosHerencia.Bicicleta import Bicicleta
from ejerciciosHerencia.Coche import Coche
def mostrarOpciones():
    print("VEHICULOS:\n1. Anda con la Bicicleta.\n2. Haz el caballito con la Bicicleta. \n3. Anda con el coche. \n4. Quema rueda con el coche."
           "\n5.Ver kilometraje de la bicicleta. \n6. Ver kilometraje del coche. \n7. Ver kilometraje total. \n8. Salir.\n")
#main
  
bici = Bicicleta(200)
coche = Coche(15000)

gestionarMenu = True

while (gestionarMenu):
    mostrarOpciones()
    opcionElegida = int(input("Elija una opcion:\n"))
    
    if(opcionElegida == 1):
        bici.echarAAndar()
    elif(opcionElegida == 2):
        bici.hacerCaballito()
    elif(opcionElegida == 3):
        coche.echarAAndar()
    elif(opcionElegida == 4):
        coche.quemarRueda()
    elif(opcionElegida == 5):
        print("La bici ha recorrido "+str(bici.getKmRecorridos())+ " kilometros")
    elif(opcionElegida == 6):
        print("El coche ha recorrido "+str(coche.getKmRecorridos())+" kilometros")
    elif(opcionElegida == 7):
        print("En total se han recorrido "+str(coche.getKmTotales())+" kilometros")
    elif(opcionElegida == 8):
        gestionarMenu = False
        print("Saliendo...")
        
    else:
        print("Has introducido una opcion no valida.")