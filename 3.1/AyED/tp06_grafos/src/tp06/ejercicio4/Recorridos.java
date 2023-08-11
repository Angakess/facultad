package tp06.ejercicio4;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Recorridos<T> {
	
	public ListaGenerica<Vertice<T>> dfs(Grafo<T> grafo){
		ListaEnlazadaGenerica<Vertice<T>> lista = new ListaEnlazadaGenerica<Vertice<T>>();
		boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio() + 1];
		for(int i = 1; i <= grafo.listaDeVertices().tamanio(); i++) {
			if(!visitados[i]) {
				dfs(i,grafo,lista,visitados);
			}
		}
		return lista;
	}
	private void dfs(int i, Grafo<T> grafo, ListaEnlazadaGenerica<Vertice<T>> lista, boolean[] visitados) {
		visitados[i] = true;
		Vertice<T> v = grafo.vetice(i);
		lista.agregarFinal(v);
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin()) {
			int j = ady.proximo().verticeDestino().getPosicion();
			if(!visitados[j]) {
				dfs(j,grafo,lista,visitados);
			}
		}
	}
	
	public ListaGenerica<Vertice<T>> bfs(Grafo<T> grafo){
		ListaEnlazadaGenerica<Vertice<T>> lista = new ListaEnlazadaGenerica<Vertice<T>>();
		boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio() + 1];
		ColaGenerica<Vertice<T>> cola = new ColaGenerica<Vertice<T>>();
		for(int i=1; i<= grafo.listaDeVertices().tamanio(); i++) {
			if(!visitados[i]) {
				Vertice<T> v = grafo.vetice(i);
				cola.encolar(v);
				visitados[i] = true;
				while(!cola.esVacia()) {
					Vertice<T> act = cola.desencolar();
					lista.agregarFinal(act);
					ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(act);
					ady.comenzar();
					while(!ady.fin()) {
						Vertice<T> vAdy = ady.proximo().verticeDestino();
						int j = vAdy.getPosicion();
						if(!visitados[j]) {
							cola.encolar(vAdy);
							visitados[j] = true;
						}
					}
				}
			}
		}
		
		return lista;
	}
	
	
	
}
