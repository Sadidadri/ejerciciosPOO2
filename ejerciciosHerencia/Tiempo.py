'''
Created on 28 ene. 2019
Clase tiempo
@author: d18momoa
'''
class Tiempo():
    def __init__(self,h,m,s):
        if(h < 0):
            print("Las horas no pueden ser negativas")
        else:
            segundosTotales = s + 60*m + 3600*h
            self.__horas = int(segundosTotales/3600)
            self.__minutos = int((segundosTotales%3600)/60)
            self.__segundos = int((segundosTotales%3600)%60)
        """
        self.__segundos = s
        self.__minutos = m
        self.__horas = h
        if (self.__segundos >= 0 and self.__segundos < 60):
            pass
        elif (self.__segundos >= 60):
            while(self.__segundos >= 60):
                self.__segundos -= 60
                self.__minutos += 1
        else:
            self.__segundos = 0
            print("Los segundos no pueden ser negativos, por lo que lo igualo a 0.")
        if (self.__minutos >= 0 and self.__minutos < 60):
            pass
        elif (self.__minutos >= 60):
            while(self.__minutos >= 60):
                self.__minutos -= 60
                self.__horas += 1
        else:
            self.__minutos = 0
            print("Los minutos no pueden ser negativos, por lo que lo igualo a 0.")
        if(self.__horas < 0):
            print("Las horas no pueden ser negativas, por lo que lo igualo a 0")
            self.__horas = 0
        """
    def getHoras(self):
        return self.__horas
    def getMinutos(self):
        return self.__minutos
    def getSegundos(self):
        return self.__segundos        
    def __str__(self): 
        return str(self.__horas)+"h"+str(self.__minutos)+"m"+str(self.__segundos)+"s"  
    def suma(self,t2):
        t3 = Tiempo((self.__horas+t2.getHoras()),(self.__minutos+t2.getMinutos()),(self.__segundos+t2.getSegundos()))
        return t3
    def resta(self,t2):
        horas = self.__horas
        minutos = self.__minutos
        segundos = self.__segundos
     
        while(segundos < t2.getSegundos()):
            segundos +=60
            minutos -= 1
        while(minutos < t2.getMinutos()):
            minutos +=60;
            horas -= 1
        if (horas < t2.getHoras()):
            print("Error, el tiempo no puede ser negativo")
            return Tiempo(0,0,0)
        else:
            horas -= t2.getHoras();
            minutos -= t2.getMinutos();
            segundos -= t2.getSegundos();
            return Tiempo(horas,minutos,segundos)
          
if __name__ == '__main__':
    time1 = Tiempo(2,50,15)
    time2 = Tiempo(3,125,50)
    
    print("Primer tiempo:")
    print(time1)
    print("Segundo tiempo:")
    print(time2)
    
    print("T1 + T2:")
    print(time1.suma(time2))
    print("T2 - T1:")
    print(time2.resta(time1))
