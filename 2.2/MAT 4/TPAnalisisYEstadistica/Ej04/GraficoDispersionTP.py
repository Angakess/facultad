from turtle import color
import matplotlib.pyplot as plt
import pandas as pd

df = pd.read_csv("ratings.csv")

#Variable pronosticadora
x_pts = df["quality"]

#Variables dependientes
w_pts = df["helpfulness"]
y_pts = df["clarity"]
z_pts = df["easiness"]

#Sacamos promedios
x_prom = x_pts.mean()
w_prom = w_pts.mean()
y_prom = y_pts.mean()
z_prom = z_pts.mean()

#Tenemos 3 casos, primero calculamos los valores que tengan en comun
x_diff = x_pts - x_prom
Sxx = ((x_diff)**2).sum()

x_min = x_pts.min() #Esto es para la recta
x_max = x_pts.max()

# Calculos del 1º grafico (helpfulness)
w_diff = w_pts - w_prom
Sww = ((w_diff)**2).sum()
Sxw = (x_diff * w_diff).sum()

b1_w = Sxw/Sxx
b0_w = w_prom - b1_w * x_prom

sigma_w = (Sww - ((Sxw)**2)/Sxx) / (x_pts.count() - 2)
Sce_w = (Sww - ((Sxw)**2)/Sxx)
coef_w = 1 - (Sce_w / Sww)


y1_w = b0_w + b1_w*x_min #Esto es para la recta
y2_w = b0_w + b1_w*x_max

# Calculos del 2º grafico (clarity)
y_diff = y_pts - y_prom
Syy = ((y_diff)**2).sum()
Sxy = (x_diff * y_diff).sum()

b1_y = Sxy/Sxx
b0_y = y_prom - b1_y * x_prom

sigma_y = (Syy - ((Sxy)**2)/Sxx) / (x_pts.count() - 2)
Sce_y = (Syy - ((Sxy)**2)/Sxx)
coef_y = 1 - (Sce_y / Syy)

y1_y = b0_y + b1_y*x_min #Esto es para la recta
y2_y = b0_y + b1_y*x_max

# Calculos del 3º grafico (easiness)
z_diff = z_pts - z_prom
Szz = ((z_diff)**2).sum()
Sxz = (x_diff * z_diff).sum()

b1_z = Sxz/Sxx
b0_z = z_prom - b1_z * x_prom

sigma_z = (Szz - ((Sxz)**2)/Sxx) / (x_pts.count() - 2)
Sce_z = (Szz - ((Sxz)**2)/Sxx)
coef_z = 1 - (Sce_z / Szz)

y1_z = b0_z + b1_z*x_min #Esto es para la recta
y2_z = b0_z + b1_z*x_max


#GRAFICOS
plt.rcParams["figure.subplot.wspace"]= 0.5
fig, ax = plt.subplots(1,3)
#Grafico 1
ax[0].scatter(x_pts, w_pts, s= 50.0, edgecolors= 'black' )
ax[0].plot([x_min, x_max],[y1_w, y2_w], color="red", lw= 3)
ax[0].set_xlabel('Calidad') #quality
ax[0].set_ylabel('Utilidad') #helpfulness
ax[0].set_title("Grafico 1")
#Grafico 2
ax[1].scatter(x_pts, y_pts, s= 50.0, color= 'green', edgecolors= 'black' )
ax[1].plot([x_min, x_max],[y1_y, y2_y], color="red", lw= 3)
ax[1].set_xlabel('Calidad') #quality
ax[1].set_ylabel('Claridad') #clarity
ax[1].set_title("Grafico 2")
#Grafico 3
ax[2].scatter(x_pts, z_pts, s= 50.0, color= 'yellow', edgecolors= 'black' )
ax[2].plot([x_min, x_max],[y1_z, y2_z], color="red", lw= 3)
ax[2].set_xlabel('Calidad') #quality
ax[2].set_ylabel('Facilidad') #easiness
ax[2].set_title("Grafico 3")

plt.show()

print(" sigma 1= ",sigma_w)
print(" sigma 2= ",sigma_y)
print(" sigma 3= ",sigma_z)
print("")
print(" coef 1= ",coef_w)
print(" coef 2= ",coef_y)
print(" coef 3= ",coef_z)

