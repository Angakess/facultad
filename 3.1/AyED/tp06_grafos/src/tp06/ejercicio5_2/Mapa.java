package tp06.ejercicio5_2;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class Mapa {
	private Grafo<String> mapaCiudades;
	
	public Mapa (Grafo<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}

	
//******************************************************************************************************************************************************
	public ListaGenerica<String> caminoMasCortoDIJKSTRA(String ciudad1, String ciudad2){
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
//******************************************************************************************************************************************************
	public ListaGenerica<String> caminoMasCortoDFS(String ciudad1, String ciudad2){
		Min minimo = new Min(9999);
		boolean[]marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		ListaEnlazadaGenerica<String> lis = new ListaEnlazadaGenerica<String>();
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<Vertice<String>> listaVertices = mapaCiudades.listaDeVertices();
		int origen = -1;
		listaVertices.comenzar();
		while ((!listaVertices.fin()) && (origen == -1)) {
			Vertice<String> aux = listaVertices.proximo();
			if (aux.dato() == ciudad1) {
				origen = aux.getPosicion();
				lis.agregarFinal(aux.dato());
			}
		}
		if (origen != -1) {
			int distancia = 0;
			dfs(origen,lis,camino,marca,ciudad2,minimo,distancia);
		}
		return camino;
		
	}
	
	private void dfs(int i,ListaEnlazadaGenerica<String> lis,ListaEnlazadaGenerica<String> camino,boolean[] marca,String ciudad2,Min minimo,int distancia) {
		marca[i] = true;
		Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
		if (v.dato() == ciudad2) {
			if (distancia < minimo.getMinimo()) {
				clonar(lis,camino);
				minimo.setMinimo(distancia);
			}
		}
		else {
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()){
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j]) {
					distancia+= arista.peso();
					lis.agregarFinal(arista.verticeDestino().dato());
					dfs(j,lis,camino,marca,ciudad2,minimo,distancia);
					lis.eliminarEn(lis.tamanio());
					marca[j] = false;
					distancia-=arista.peso();
				}
			}
		}
	}
	private void clonar(ListaGenerica<String> lis, ListaGenerica<String> camino) {
		camino.comenzar();
		while(!camino.fin()) {
			camino.eliminar(camino.proximo());
		}
		lis.comenzar();
		while(!lis.fin()) {
			camino.agregarFinal(lis.proximo());
		}
	}
	
//******************************************************************************************************************************************************
	public ListaGenerica<String> caminoMasCortoDFS2(String ciudad1, String ciudad2){
		boolean[]marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		ListaEnlazadaGenerica<String> lis = new ListaEnlazadaGenerica<String>();
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<Vertice<String>> listaVertices = mapaCiudades.listaDeVertices();
		int origen = -1;
		listaVertices.comenzar();
		while ((!listaVertices.fin()) && (origen == -1)) {
			Vertice<String> aux = listaVertices.proximo();
			if (aux.dato() == ciudad1) {
				origen = aux.getPosicion();
			}
		}
		if (origen != -1) {
			int distancia = 0;
			int min = 9999;
			dfs2(origen,lis,camino,marca,ciudad2,distancia, min);
		}
		return camino;
		
	}
	
	private int dfs2(int i,ListaEnlazadaGenerica<String> lis,ListaEnlazadaGenerica<String> camino,boolean[] marca,String ciudad2,int distancia, int min) {
		marca[i] = true;
		lis.agregarFinal(mapaCiudades.vetice(i).dato());
		if(mapaCiudades.vetice(i).dato().equals(ciudad2)) {
			if(min > distancia) {
				clonar2(lis, camino);
				min = distancia;
			}
		}
		else {
			ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(mapaCiudades.vetice(i));
			adyacentes.comenzar();
			while(!adyacentes.fin()) {
				Arista<String> aux = adyacentes.proximo();
				Vertice<String> sigVertice = aux.verticeDestino();
				if(!marca[sigVertice.getPosicion()]) {
					min = Math.min(min, dfs2(sigVertice.getPosicion(), lis, camino, marca, ciudad2, distancia + aux.peso(), min));
					lis.eliminarEn(lis.tamanio());
					marca[sigVertice.getPosicion()] = false;
				}
			}	
		}
		return min;
	}
	private void clonar2(ListaGenerica<String> lis, ListaGenerica<String> camino) {
		camino.comenzar();
		while(!camino.fin()) {
			camino.eliminar(camino.proximo());
		}
		lis.comenzar();
		while(!lis.fin()) {
			camino.agregarFinal(lis.proximo());
		}
	}
//******************************************************************************************************************************************************
	public ListaGenerica<String> caminoConMenorCargaDeCombustibleDIJKSTRA(String ciudad1, String ciudad2, int tanqueAuto){
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if(!mapaCiudades.esVacio()) {
			ListaGenerica<Vertice<String>> listaVertices = mapaCiudades.listaDeVertices();
			listaVertices.comenzar();
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
				dijkstra2(origen, dest, tanqueAuto, camino);
			}
		}
		return camino;
	}
	private void dijkstra2(int origen, int dest, int tanqueAuto, ListaGenerica<String> camino) {
		int cantR = 0;
		boolean[] marcas = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		int[] dists = new int[mapaCiudades.listaDeVertices().tamanio() + 1];
		int[] prev = new int[mapaCiudades.listaDeVertices().tamanio() + 1];
		int[] recargas = new int[mapaCiudades.listaDeVertices().tamanio() + 1];
		for(int i=1; i<=mapaCiudades.listaDeVertices().tamanio(); i++) {
			dists[i] = 999;
			prev[i] = -1;
			recargas[i] = 999;
		}
		dists[origen] = 0;
		recargas[origen] = 0;
		
		for(int i=1; i<=mapaCiudades.listaDeVertices().tamanio(); i++) {
			int u = distMin(marcas, dists);
			marcas[u] = true;
			ListaGenerica<Arista<String>> adyacentesU = mapaCiudades.listaDeAdyacentes(mapaCiudades.vetice(u));
			adyacentesU.comenzar();
			while(!adyacentesU.fin()) {
				Arista<String> aux = adyacentesU.proximo();
				int w = aux.verticeDestino().getPosicion();
				int uwPeso = aux.peso();
				if(tanqueAuto >= uwPeso) {
					if((tanqueAuto - (dists[u] + uwPeso)) < 0) {
						cantR++;
					}
					if(!marcas[w]) {
						if(recargas[w] >= recargas[u] + cantR) {
							if(dists[w] > dists[u] + uwPeso) {
								recargas[w] = recargas[u] + cantR;
								dists[w] = dists[u] + uwPeso;
								prev[w] = u;
							}
							
						}
					}
				}
			}
		}
		int curr = dest;
		while(prev[curr] != -1) {
			camino.agregarInicio(mapaCiudades.listaDeVertices().elemento(curr).dato());
			curr = prev[curr];
		}
		camino.agregarInicio(mapaCiudades.vetice(origen).dato());
	}
	
	
//******************************************************************************************************************************************************
	public ListaGenerica<String> caminoConMenorCargaDeCombustibleDFS(String ciudad1, String ciudad2, int tanqueAuto){
		boolean[]marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		ListaEnlazadaGenerica<String> lis = new ListaEnlazadaGenerica<String>();
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<Vertice<String>> listaVertices = mapaCiudades.listaDeVertices();
		int origen = -1;
		listaVertices.comenzar();
		while ((!listaVertices.fin()) && (origen == -1)) {
			Vertice<String> aux = listaVertices.proximo();
			if (aux.dato() == ciudad1) {
				origen = aux.getPosicion();
			}
		}
		if (origen != -1) {
			int distancia = 0;
			int cargas = 0;
			int min = 9999;
			dfs3(origen,lis,camino,marca,ciudad2,tanqueAuto,distancia, min, cargas);
		}
		return camino;
		
	}
	
	private int dfs3(int i,ListaEnlazadaGenerica<String> lis,ListaEnlazadaGenerica<String> camino,boolean[] marca,String ciudad2,int tanqueAuto,int distancia, int min, int cargas) {
		marca[i] = true;
		lis.agregarFinal(mapaCiudades.vetice(i).dato());
		if(mapaCiudades.vetice(i).dato().equals(ciudad2)) {
			if(min > cargas) {
				clonar3(lis, camino);
				min = cargas;
			}
		}
		else {
			ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(mapaCiudades.vetice(i));
			adyacentes.comenzar();
			while(!adyacentes.fin()) {
				Arista<String> aux = adyacentes.proximo();
				Vertice<String> sigVertice = aux.verticeDestino();
				if(!marca[sigVertice.getPosicion()]) {
					if((tanqueAuto - aux.peso()) >= 0) {
						if(tanqueAuto - distancia < 0) {
							min = Math.min(min, dfs3(sigVertice.getPosicion(), lis, camino, marca, ciudad2, tanqueAuto, distancia + aux.peso(), min, cargas+1));
						}
						else {
							min = Math.min(min, dfs3(sigVertice.getPosicion(), lis, camino, marca, ciudad2, tanqueAuto, distancia + aux.peso(), min, cargas));
						}
						lis.eliminarEn(lis.tamanio());
						marca[sigVertice.getPosicion()] = false;
					}
				}
			}	
		}
		return min;
	}
	private void clonar3(ListaGenerica<String> lis, ListaGenerica<String> camino) {
		camino.comenzar();
		while(!camino.fin()) {
			camino.eliminar(camino.proximo());
		}
		lis.comenzar();
		while(!lis.fin()) {
			camino.agregarFinal(lis.proximo());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vertice<String> v1 = new VerticeImplListAdy<String>("Buenos Aires");
		Vertice<String> v2 = new VerticeImplListAdy<String>("Santiago");
		Vertice<String> v3 = new VerticeImplListAdy<String>("Lima");
		Vertice<String> v4 = new VerticeImplListAdy<String>("Montevideo");
		Vertice<String> v5 = new VerticeImplListAdy<String>("Asuncion");
		Vertice<String> v6 = new VerticeImplListAdy<String>("Caracas");
		Vertice<String> v7 = new VerticeImplListAdy<String>("La Habana");
		Vertice<String> v8 = new VerticeImplListAdy<String>("Cordoba");

		Grafo<String> ciudades = new GrafoImplListAdy<String>();
		Grafo<String> grafoVacio = new GrafoImplListAdy<String>();
		
		ciudades.agregarVertice(v1);
		ciudades.agregarVertice(v2);
		ciudades.agregarVertice(v3);
		ciudades.agregarVertice(v4);
		ciudades.agregarVertice(v5);
		ciudades.agregarVertice(v6);
		ciudades.agregarVertice(v7);
		ciudades.agregarVertice(v8);

		ciudades.conectar(v1, v2,3);
		ciudades.conectar(v1, v3,2);
		ciudades.conectar(v1, v4,4);
		ciudades.conectar(v1, v5,10);
		ciudades.conectar(v2, v5,500);
		ciudades.conectar(v2, v7,4);
		ciudades.conectar(v3, v5,4);
		ciudades.conectar(v4, v5,1);
		ciudades.conectar(v6, v5,11);
		ciudades.conectar(v6, v7,10);
		ciudades.conectar(v2, v8,2);
		ciudades.conectar(v8, v5,1);
		
		Mapa m = new Mapa (ciudades);
		
		
		ListaGenerica<String> lis3 = m.caminoMasCortoDIJKSTRA("Buenos Aires","Asuncion");
		System.out.println("--- Se imprime caminoMasCortoDIJKSTRA ---");
		lis3.comenzar();
		while(!lis3.fin()) {
			System.out.println(lis3.proximo());
		}
		
		
		ListaGenerica<String> lis2 = m.caminoMasCortoDFS("Buenos Aires","Asuncion");
		System.out.println("--- Se imprime caminoMasCortoDFS ---");
		lis2.comenzar();
		while(!lis2.fin()) {
			System.out.println(lis2.proximo());
		}
		
		ListaGenerica<String> lis1 = m.caminoMasCortoDFS2("Buenos Aires","Asuncion");
		System.out.println("--- Se imprime caminoMasCortoDFS2 ---");
		lis1.comenzar();
		while(!lis1.fin()) {
			System.out.println(lis1.proximo());
		}
		
		ListaGenerica<String> lis4 = m.caminoConMenorCargaDeCombustibleDFS("Buenos Aires","Asuncion",10);
		System.out.println("--- Se imprime caminoConMenorCargaDeCombustibleDFS ---");
		lis4.comenzar();
		while(!lis4.fin()) {
			System.out.println(lis4.proximo());
		}
		
	}

}
