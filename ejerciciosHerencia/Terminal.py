# -*- coding: utf-8 -*-
'''
Created on 29 ene. 2019
Clase Terminal
@author: d18momoa
'''
class Terminal():
    def __init__(self,num):
        self.__tiempoLlamada = 0
        self.__numero = num
        self.__n = num.replace(" ","")
        self.__n = self.__n.replace("-","")

        if (len(self.__n) == 9):
            self.__numero = num
        else:
            print("Error, debes asignar un numero valido de 9 digitos.")
        
    def __str__(self):
        return "Nº"+str(self.__numero)+" - "+str(self.__tiempoLlamada)+"s de conversacion"
    def llama(self,t2,tiempo):
        self.__tiempoLlamada += tiempo
        t2.__tiempoLlamada += tiempo
if __name__ == '__main__':
    t1 = Terminal("678 11 22 33");
    t2 = Terminal("644 74 44 69");
    t3 = Terminal("622 32 89 09");
    t4 = Terminal("664 73 98 18");
    print(t1);
    print(t2);
    t1.llama(t2, 320);
    t1.llama(t3, 200);
    print(t1);
    print(t2);
    print(t3);
    print(t4);