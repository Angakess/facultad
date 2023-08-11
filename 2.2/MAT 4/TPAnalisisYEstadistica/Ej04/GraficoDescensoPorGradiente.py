import itertools
import math
from mpl_toolkits import mplot3d
import matplotlib.pyplot as plt
import matplotlib.animation as animation
import numpy as np


fig = plt.figure(figsize=plt.figaspect(2.))

#Grafico 3D
ax = fig.add_subplot(projection='3d')

# Grab some test data.
x = np.linspace(-8,8,100)
y = np.linspace(-8,8,100)

X, Y = np.meshgrid(x,y)

Z = np.sin((X**2 + Y**2)/5)

ax.plot(0,0,3)
ax.plot(0,0,-3)
ax.plot_surface(X, Y, Z, rstride=1, cstride=1, cmap='nipy_spectral', edgecolor='none')
ax.set_facecolor('k')
ax.set_xlabel('x')
ax.set_ylabel('y')
ax.set_zlabel('z')

#Grafico 2D
"""
a = int(input("Ingrese el punto inicial en x: "))
b = int(input("Ingrese el punto inicial en y: "))
c = (math.sin((a**2 + b**2)/5))

pasos = int(input("Ingrese la cantidad de pasos maxima: "))
factor = float(input("Ingrese el factor alfa: "))
tolerancia = float(input("Ingrese la tolerancia: "))
p=0
cambioZ = 1



def puntos():
    while (p<pasos) and (cambioZ > tolerancia):
    
        cAnt = c

        grad_a = (2*a*math.cos((a**2 + b**2)/5))/5
        grad_b = (2*b*math.cos((a**2 + b**2)/5))/5   

        a = a - (factor * grad_a)
        b = b - (factor * grad_b)
        print("x: ",a)
        print("y: ",b)

        c = math.sin((a**2 + b**2)/5)

        
        cambioZ = math.fabs(c - cAnt)

        p = p +1
        yield c

ax = fig.add_subplot(2,1,1)
line, = ax.plot([], [], lw=2)
ax.grid()

pasos = int(input("Ingrese la cantidad de pasos maxima: "))

def init():     #Iniciar el grafico sin nada
    ax.set_ylim(-8, 8)
    ax.set_xlim(-8, 8)
    line.set_data([], [])
    return line,

xdata, ydata = [],[]

def animate(i): 
    a = a - (factor * ((2*a*math.cos((a**2 + b**2)/5))/5))
    b = b - (factor * ((2*b*math.cos((a**2 + b**2)/5))/5))
    line.set_data(x, y)
    return line,

ani = animation.FuncAnimation(fig, run, data_gen, interval=10, init_func=init)
"""
plt.show()