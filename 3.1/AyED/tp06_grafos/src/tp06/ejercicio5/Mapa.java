package tp06.ejercicio5;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Mapa {
	private Grafo<String> mapaCiudades;

	public Mapa (Grafo<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}

	//**********************************************************************************************************************************
	
	public ListaGenerica<String> devolverCamino (String ciudad1, String ciudad2){
		boolean[]marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		ListaEnlazadaGenerica<String> lis = new ListaEnlazadaGenerica<String>();
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<Vertice<String>> aux = mapaCiudades.listaDeVertices();
		aux.comenzar();
		Vertice<String> vertice;
		boolean ok = false;
		int i = -1;
		while ((!aux.fin()) && (!ok)) {
			vertice = aux.proximo();
			if (vertice.dato() == ciudad1) {
				ok = true;
				i = vertice.getPosicion();
				lis.agregarFinal(vertice.dato());
			}
		}
		if (i != -1) {
			dfs (i,lis,camino,marca,ciudad2);
		}
		return camino;
	}
	private void dfs (int i,ListaEnlazadaGenerica<String> lis,ListaEnlazadaGenerica<String> camino,boolean[]marca,String ciudad2) {
		marca[i] = true;
		Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
		if (v.dato() == ciudad2) {
			clonar (lis,camino);
		}
		if (camino.esVacia()){
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while ((!ady.fin()) && (camino.esVacia())) {
				Vertice<String> destino = ady.proximo().verticeDestino();
				int j = destino.getPosicion();
				if (!marca[j]) {
					lis.agregarFinal(destino.dato());
					dfs(j,lis,camino,marca,ciudad2);
					lis.eliminarEn(lis.tamanio());
				}
			}
		}
	}

	//**********************************************************************************************************************************
	
	public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2,ListaGenerica<String> ciudades){
		boolean[]marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		ListaEnlazadaGenerica<String> lis = new ListaEnlazadaGenerica<String>();
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if (!ciudades.incluye(ciudad1) && !ciudades.incluye(ciudad2)){
			ListaGenerica<Vertice<String>> aux = mapaCiudades.listaDeVertices();
			aux.comenzar();
			Vertice<String> vertice;
			boolean ok = false;
			int i = -1;
			while ((!aux.fin()) && (!ok)) {
				vertice = aux.proximo();
				if (vertice.dato() == ciudad1) {
					ok = true;
					i = vertice.getPosicion();
					lis.agregarFinal(vertice.dato());
				}
			}
			if (i != -1) {
				dfsExceptuando (i,lis,camino,marca,ciudad2,ciudades);
			}
		}
		return camino;
	}
	private void dfsExceptuando (int i,ListaEnlazadaGenerica<String> lis,ListaEnlazadaGenerica<String> camino,boolean[]marca,String ciudad2,ListaGenerica<String> ciudades) {
		marca[i] = true;
		Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
		if (v.dato() == ciudad2) {
			clonar (lis,camino);
		}
		if (camino.esVacia()){
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while ((!ady.fin()) && (camino.esVacia())) {
				Vertice<String> destino = ady.proximo().verticeDestino();
				int j = destino.getPosicion();
				if ((!marca[j]) && (!(ciudades.incluye(destino.dato())))) {
					lis.agregarFinal(destino.dato());
					dfsExceptuando(j,lis,camino,marca,ciudad2,ciudades);
					lis.eliminarEn(lis.tamanio());
				}
			}
		}
	}

	//**********************************************************************************************************************************
	
	public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2){
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if(!mapaCiudades.esVacio()) {
			ListaGenerica<Vertice<String>> listaVertices = mapaCiudades.listaDeVertices();	
			int origen = -1;
			int dest = -1;
			listaVertices.comenzar();
			while((!listaVertices.fin())&&((origen == -1)||(dest == -1))) {
				Vertice<String> aux = listaVertices.proximo();
				if(aux.dato().equals(ciudad1)) {
					origen = aux.getPosicion();
				}
				if(aux.dato().equals(ciudad2)) {
					dest = aux.getPosicion();
				}
			}
			//si encontre ciudad1 y ciudad2

			if((origen != -1)&&(dest != -1)) {
				dijkstra(origen, dest, camino);
			}			
		}
		return camino;
	}
	
	private void dijkstra(int origen, int dest, ListaEnlazadaGenerica<String> camino) {
		boolean[] marcas = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		int[] dists = new int[mapaCiudades.listaDeVertices().tamanio() + 1];
		int[] prev = new int[mapaCiudades.listaDeVertices().tamanio() + 1];
		for(int i=1; i<=mapaCiudades.listaDeVertices().tamanio(); i++) {
			dists[i] = 999;
			prev[i] = -1;
		}
		dists[origen] = 0;
		
		for(int i=1; i<=mapaCiudades.listaDeVertices().tamanio(); i++) {
			int u = distMin(marcas, dists);
			marcas[u] = true;
			ListaGenerica<Arista<String>> adyacentesU = mapaCiudades.listaDeAdyacentes(mapaCiudades.vetice(u));
			adyacentesU.comenzar();
			while(!adyacentesU.fin()) {
				Arista<String> aux = adyacentesU.proximo();
				int w = aux.verticeDestino().getPosicion();
				int uwPeso = aux.peso();
				if(!marcas[w]) {
					if(dists[w] > dists[u] + uwPeso) {
						dists[w] = dists[u] + uwPeso;
						prev[w] = u;
					}
				}
			}
		}
		//dfgfdg
		int curr = dest;
		
		while(prev[curr] != -1) {
			camino.agregarInicio(mapaCiudades.listaDeVertices().elemento(curr).dato());
			curr = prev[curr];
		}
		camino.agregarInicio(mapaCiudades.vetice(origen).dato());
	}
	
	private int distMin(boolean[] marcas, int[] dists) {
		int idx = -1;
		int min = 9999;
		
		for(int i=1; i<marcas.length; i++) {
			if((!marcas[i])&&(min>dists[i])) {
				min = dists[i];
				idx = i;
			}
		}
		
		return idx;
	}

	//**********************************************************************************************************************************
	
	
	public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if(!mapaCiudades.esVacio()) {
			ListaGenerica<Vertice<String>> listaVertices = mapaCiudades.listaDeVertices();	
			int origen = -1;
			int dest = -1;
			listaVertices.comenzar();
			while((!listaVertices.fin())&&((origen == -1)||(dest == -1))) {
				Vertice<String> aux = listaVertices.proximo();
				if(aux.dato().equals(ciudad1)) {
					origen = aux.getPosicion();
				}
				if(aux.dato().equals(ciudad2)) {
					dest = aux.getPosicion();
				}
			}
			//si encontre ciudad1 y ciudad2

			if((origen != -1)&&(dest != -1)) {
				dijkstraLimite(origen, dest, camino, tanqueAuto);
			}			
		}
		return camino;
	}
	private void dijkstraLimite(int origen, int dest, ListaEnlazadaGenerica<String> camino, int tanqueAuto) {
		boolean[] marcas = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		int[] dists = new int[mapaCiudades.listaDeVertices().tamanio() + 1];
		int[] prev = new int[mapaCiudades.listaDeVertices().tamanio() + 1];
		for(int i=1; i<=mapaCiudades.listaDeVertices().tamanio(); i++) {
			dists[i] = 999;
			prev[i] = -1;
		}
		dists[origen] = 0;

		for(int i=1; i<=mapaCiudades.listaDeVertices().tamanio(); i++) {
			int u = distMin(marcas, dists);
			marcas[u] = true;
			ListaGenerica<Arista<String>> adyacentesU = mapaCiudades.listaDeAdyacentes(mapaCiudades.vetice(u));
			adyacentesU.comenzar();
			while(!adyacentesU.fin()) {
				Arista<String> aux = adyacentesU.proximo();
				int w = aux.verticeDestino().getPosicion();
				int uwPeso = aux.peso();
				if(!marcas[w]) {
					if(dists[w] > dists[u] + uwPeso) {
						dists[w] = dists[u] + uwPeso;
						prev[w] = u;
					}
				}
			}
		}
		//dfgfdg
		int curr = dest;

		if(dists[curr]<tanqueAuto) {
			while(prev[curr] != -1) {
				camino.agregarInicio(mapaCiudades.listaDeVertices().elemento(curr).dato());
				curr = prev[curr];
			}
			camino.agregarInicio(mapaCiudades.vetice(origen).dato());
		}
	}

	//**********************************************************************************************************************************
	/*
	public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if(!mapaCiudades.esVacio()) {
			ListaGenerica<Vertice<String>> listaVertices = mapaCiudades.listaDeVertices();
			int origen = -1;
			int dest = -1;
			while((!listaVertices.fin())&&((origen == -1)||(dest == -1))) {
				Vertice<String> aux = listaVertices.proximo();
				if(aux.dato().equals(ciudad1)) {
					origen = aux.getPosicion();
				}
				if(aux.dato().equals(ciudad2)) {
					dest = aux.getPosicion();
				}
			}
			if((origen != -1)&&(dest != -1)) {
				dijkstra3(origen, dest, camino, tanqueAuto);
			}
		}
		return camino;
	}
	private void dijkstra3(int origen, int dest, ListaEnlazadaGenerica<String> camino, int tanqueAuto) {
		boolean[] marcas = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		int[] dists = new int[mapaCiudades.listaDeVertices().tamanio() + 1];
		int[] prevs = new int[mapaCiudades.listaDeVertices().tamanio() + 1];
		for(int i=0; i<=mapaCiudades.listaDeVertices().tamanio(); i++) {
			dists[i] = 999;
			prevs[i] = -1;
		}
		dists[origen] = 0;
		int combustible = tanqueAuto;
		
		for(int i=1; i<=mapaCiudades.listaDeVertices().tamanio(); i++) {
			int u = distMin(marcas, dists);
			marcas[u] = true;
			combustible = combustible - dists[u];
			
			ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(mapaCiudades.vetice(u));
			adyacentes.comenzar();
			while(!adyacentes.fin()) {
				Arista<String> aux = adyacentes.proximo();
				int w = aux.verticeDestino().getPosicion();
				int uwPeso = aux.peso();
				if((!marcas[w])&&()) {
					if(dists[w] > dists[u] + uwPeso) {
						dists[w] = dists[u] + uwPeso;
						prevs[w] = u;
					}
				}
			}
		}
		*/
		











	private void clonar (ListaEnlazadaGenerica<String> lis,ListaEnlazadaGenerica<String> camino) {
		lis.comenzar();
		while(!lis.fin()) {
			camino.agregarFinal(lis.proximo());
		}
	}
}
