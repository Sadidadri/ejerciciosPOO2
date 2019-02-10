'''
Created on 29 ene. 2019
Clase Movil que hereda de Terminal
@author: d18momoa
'''
from ejerciciosHerencia.Terminal import Terminal
class Movil(Terminal):
    def __init__(self,num,tarifa):
        super().__init__(num)
        self.__costo = 0
        if(tarifa == "rata" or tarifa == "RATA" or tarifa == "mono" or tarifa == "MONO" or tarifa == "bisonte" or tarifa == "BISONTE" ):
            self.__tarifa = tarifa
        else:
            print("Esa tarifa no existe.")
            
    def llama(self,m2,tiempo):
        if (self.__tarifa == "rata" or self.__tarifa == "RATA"):
            self.__costo += (0.06 * ((tiempo/100)))
        elif (self.__tarifa == "mono" or self.__tarifa == "MONO"):
            self.__costo += (0.12 * ((tiempo/100)))
        elif (self.__tarifa == "bisonte" or self.__tarifa == "BISONTE"):
            self.__costo += (0.30 * ((tiempo/100)))    
        else:
            print("Error al realizar la llamada.")
        super().llama(m2, tiempo)
    def __str__(self):
        cadena = super().__str__()
        return cadena + ", tarificados "+str(round(self.__costo,2))+" euros"
if __name__ == '__main__':
    m1 = Movil("678 11 22 33","rata");
    m2 = Movil("644 74 44 69","mono");
    m3 = Movil("622 32 89 09","bisonte");
    print(m1);
    print(m2);
    m1.llama(m2, 320);
    m1.llama(m3, 200);
    m2.llama(m3, 550);
    print(m1);
    print(m2);
    print(m3);