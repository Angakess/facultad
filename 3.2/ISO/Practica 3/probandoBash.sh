#!/bin/bash
cadena1="hola"
cadena2="mundo"
concatenada=$(expr "$cadena1" : '\(.*\)'"$cadena2")
echo $concatenada

