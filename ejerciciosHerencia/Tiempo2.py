'''
Created on 5 feb. 2019
Clase tiempo con Datetime
@author: d18momoa
'''
from datetime import datetime, date, time, timedelta
import calendar

def crearTiempo(horas,minutos,segundos):
    while(segundos >= 60):
        segundos -=60
        minutos += 1
    while(minutos >= 60):
        minutos -=60
        horas += 1
    return time(horas,minutos,segundos)
def resta(time1,time2):
    horas = time1.hour
    minutos = time1.minute
    segundos = time1.second
     
    while(segundos < time2.second):
        segundos +=60
        minutos -= 1
    while(minutos < time2.minute):
        minutos +=60;
        horas -= 1
    if (horas < time2.hour):
        print("Error, el tiempo no puede ser negativo")
        return crearTiempo(0,0,0)
    else:
        horas -= time2.hour
        minutos -= time2.minute
        segundos -= time2.second
        return crearTiempo(horas, minutos, segundos)
    
time1 = crearTiempo(2,50,15)
time2 = crearTiempo(3,125,50)
    
print("Primer tiempo:")
print(time1)
print("Segundo tiempo:")
print(time2)
    
print("T1 + T2:")
suma = crearTiempo(time1.hour+time2.hour,time1.minute+time2.minute,time1.second+time2.second)
print(suma)
print("T2 - T1:")
print(resta(time2,time1)) 
