package tp06.ejercicio6;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class VisitaOslo {
	
	public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int maxTiempo, ListaGenerica<String> lugaresRestringidos){
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if(!lugares.esVacio()) {
			int origen = -1;
			ListaGenerica<Vertice<String>> listaVertices = lugares.listaDeVertices();
			listaVertices.comenzar();
			while((!listaVertices.fin())&&(origen == -1)) {
				Vertice<String> aux = listaVertices.proximo();
				if(aux.dato().equals("Ayuntamiento")) {
					origen = aux.getPosicion();
				}
			}
			if(lugares.vetice(origen).dato().equals("Ayuntamiento")) {
				ListaEnlazadaGenerica<String> lis = new ListaEnlazadaGenerica<String>();
				boolean[] marcas = new boolean[lugares.listaDeVertices().tamanio() + 1];
				dfs(origen, lugares, destino, maxTiempo, lugaresRestringidos, lis, camino, marcas);
			}
		}
		return camino;
	}
	private void dfs(int i, Grafo<String> lugares, String destino, int maxTiempo, ListaGenerica<String> lugaresRestringidos, ListaGenerica<String> lis,
	ListaGenerica<String> camino, boolean[] marcas) {
		String ciudadAct = lugares.vetice(i).dato();
		lis.agregarFinal(ciudadAct);
		marcas[i] = true;
		if(ciudadAct.equals(destino)) {
			clonar(lis, camino);
		}
		else {
			ListaGenerica<Arista<String>> adyacentes = lugares.listaDeAdyacentes(lugares.vetice(i));
			adyacentes.comenzar();
			while(!adyacentes.fin() && camino.esVacia()) {
				Arista<String> aux = adyacentes.proximo();
				Vertice<String> sig = aux.verticeDestino();
				if((!lugaresRestringidos.incluye(sig.dato()) && (maxTiempo - aux.peso() >= 0) && !marcas[sig.getPosicion()])) {
					dfs(sig.getPosicion(), lugares, destino, maxTiempo-aux.peso(), lugaresRestringidos, lis, camino, marcas);
					lis.eliminarEn(lis.tamanio());
				}
			}
		}
	}
	private void clonar(ListaGenerica<String> lis, ListaGenerica<String> camino) {
		while(!lis.fin()) {
			camino.agregarFinal(lis.proximo());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vertice<String> Holmenkollen = new VerticeImplListAdy<String>("Holmenkollen");
		Vertice<String> ParqueVigeland = new VerticeImplListAdy<String>("Parque Vigeland");
		Vertice<String> FolkMuseum  = new VerticeImplListAdy<String>("Folk Museum");
		Vertice<String> MuseoFram = new VerticeImplListAdy<String>("Museo Fram");
		Vertice<String> MuseoDelBarcoPolar= new VerticeImplListAdy<String>("Museo Del Barco Polar");
		Vertice<String> MuseoVikingo = new VerticeImplListAdy<String>("Museo Vikingo");
		Vertice<String> AkkerBrigge = new VerticeImplListAdy<String>("Akker Brigge");
		Vertice<String> PalacioReal = new VerticeImplListAdy<String>("Palacio Real");
		Vertice<String> Ayuntamiento  = new VerticeImplListAdy<String>("Ayuntamiento");
		Vertice<String> GaleriaNacional = new VerticeImplListAdy<String>("Galeria Nacional");
		Vertice<String> ParqueBotanico = new VerticeImplListAdy<String>("Parque Botanico");
		Vertice<String> MuseoMunch = new VerticeImplListAdy<String>("Museo Munch");
		Vertice<String> ElTigre = new VerticeImplListAdy<String>("El Tigre");
		Vertice<String> LaOpera = new VerticeImplListAdy<String>("La Opera");
		Vertice<String> FortalezaAkershus = new VerticeImplListAdy<String>("Fortaleza Akershus");
		
		Grafo<String> bicisendas = new GrafoImplListAdy<String>();
		
		bicisendas.agregarVertice(Holmenkollen);
		bicisendas.agregarVertice(ParqueVigeland);
		bicisendas.agregarVertice(FolkMuseum);
		bicisendas.agregarVertice(MuseoFram);
		bicisendas.agregarVertice(MuseoDelBarcoPolar);
		bicisendas.agregarVertice(MuseoVikingo);
		bicisendas.agregarVertice(AkkerBrigge);
		bicisendas.agregarVertice(PalacioReal);
		bicisendas.agregarVertice(Ayuntamiento);
		bicisendas.agregarVertice(GaleriaNacional);
		bicisendas.agregarVertice(ParqueBotanico);
		bicisendas.agregarVertice(MuseoMunch);
		bicisendas.agregarVertice(ElTigre);
		bicisendas.agregarVertice(LaOpera);
		bicisendas.agregarVertice(FortalezaAkershus);
		
		bicisendas.conectar(Holmenkollen, ParqueVigeland,30);
		bicisendas.conectar(ParqueVigeland, Holmenkollen,30);
		bicisendas.conectar(ParqueVigeland, FolkMuseum,20);
		bicisendas.conectar(ParqueVigeland, GaleriaNacional,10);
		bicisendas.conectar(FolkMuseum, ParqueVigeland,20);
		bicisendas.conectar(FolkMuseum, PalacioReal,5);
		bicisendas.conectar(FolkMuseum, AkkerBrigge,30);
		bicisendas.conectar(FolkMuseum, MuseoFram,5);
		bicisendas.conectar(MuseoFram, FolkMuseum,5);
		bicisendas.conectar(MuseoFram, MuseoDelBarcoPolar,5);
		bicisendas.conectar(MuseoDelBarcoPolar, MuseoFram,5);
		bicisendas.conectar(MuseoDelBarcoPolar, MuseoVikingo,5);
		bicisendas.conectar(MuseoVikingo, MuseoDelBarcoPolar,5);
		bicisendas.conectar(MuseoVikingo, AkkerBrigge,30);
		bicisendas.conectar(AkkerBrigge, MuseoVikingo,30);
		bicisendas.conectar(AkkerBrigge, FolkMuseum,30);
		bicisendas.conectar(AkkerBrigge, Ayuntamiento,20);
		bicisendas.conectar(PalacioReal, FolkMuseum,5);
		bicisendas.conectar(PalacioReal, Ayuntamiento,5);
		bicisendas.conectar(Ayuntamiento, PalacioReal,5);
		bicisendas.conectar(Ayuntamiento, AkkerBrigge,20);
		bicisendas.conectar(Ayuntamiento, ElTigre,15);
		bicisendas.conectar(Ayuntamiento, ParqueBotanico,10);
		bicisendas.conectar(GaleriaNacional, ParqueVigeland,10);
		bicisendas.conectar(GaleriaNacional, ParqueBotanico,15);
		bicisendas.conectar(ParqueBotanico, GaleriaNacional,15);
		bicisendas.conectar(ParqueBotanico, Ayuntamiento,10);
		bicisendas.conectar(ParqueBotanico, MuseoMunch,1);
		bicisendas.conectar(MuseoMunch, ParqueBotanico,1);
		bicisendas.conectar(MuseoMunch, ElTigre,15);
		bicisendas.conectar(ElTigre, MuseoMunch,15);
		bicisendas.conectar(ElTigre, Ayuntamiento,15);
		bicisendas.conectar(ElTigre, LaOpera,5);
		bicisendas.conectar(LaOpera, ElTigre,5);
		bicisendas.conectar(LaOpera, FortalezaAkershus,10);
		bicisendas.conectar(FortalezaAkershus, LaOpera,10);
		
		VisitaOslo v = new VisitaOslo();
		
		ListaEnlazadaGenerica<String> lugaresRestringidos = new ListaEnlazadaGenerica<String>();
		lugaresRestringidos.agregarFinal("Akker Brigge");
		lugaresRestringidos.agregarFinal("Palacio Real");
		ListaGenerica<String> lis = v.paseoEnBici(bicisendas,"Museo Vikingo",120,lugaresRestringidos);
		System.out.println("--- Se imprime primer camino ---");
		lis.comenzar();
		while(!lis.fin()) {
			System.out.println(lis.proximo());
		}

	}

}
