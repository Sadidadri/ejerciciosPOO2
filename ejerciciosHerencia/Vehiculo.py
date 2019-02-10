'''
Created on 27 ene. 2019
Clase Vehiculo
@author: d18momoa
'''

class Vehiculo():
    
    kilometrosTotales = 0
    vehiculosCreados = 0
    
    def __init__(self,kmR):
        self.__kilometrosRecorridos = kmR
        self.kilometrosTotales += kmR
        self.vehiculosCreados += 1
    def getKmTotales(self):
        return self.kilometrosTotales
    def getVehiculosCreados(self):
        return self.vehiculosCreados
    def getKmRecorridos(self):
        return self.__kilometrosRecorridos
    def echarAAndar(self):
        print("En marcha!")  