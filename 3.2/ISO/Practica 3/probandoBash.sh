#!/bin/bash

arreglo=($*)

echo "Longitud: ${#arreglo[@]}"
echo "Todos los elementos: ${arreglo[@]}"
aux=${arreglo[1]}
arreglo[1]=${arreglo[3]}
arreglo[3]=$aux
echo "Elementos revertidos: ${arreglo[@]}"

