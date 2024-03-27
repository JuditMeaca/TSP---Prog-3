import java.util.ArrayList;
import java.util.Iterator;


public class Backtraking {
	
	private Solucion mejorSolucion;
	
	public void back(Estado estado, GrafoNoDirigido<String> grafo){
		estado.aumentarCantEstados();
	
		if(estado.ciudadesVisitadasSize() == grafo.cantidadCiudades()){
			estado.aumentarCantSoluciones();
			Ruta<String> rutaVuelta = grafo.obtenerRuta(estado.getUltimaCiudad(), estado.getCiudadInicial());
			if(rutaVuelta != null){
				// Sumar la distancia de la ruta de vuelta al camino
			    estado.sumarDistancia(rutaVuelta.getDistancia());
			    estado.agregarAlCamino(estado.getCiudadInicial());
				 
				 //operar solucion
				 if(this.mejorSolucion == null || this.mejorSolucion.getDistancia() > estado.getDistanciaCamino()){
					 this.mejorSolucion = new Solucion(estado.getCamino(), estado.getDistanciaCamino());
				 }
				 
				 estado.restarDistancia(rutaVuelta.getDistancia());
				 estado.quitarUltimoDelCamino();
			}	
		}else{
			ArrayList<String> adyacentes = new ArrayList<>();
			Iterator<String> it = grafo.obtenerAdyacentes(estado.getCiudadActual());
			String original = estado.getCiudadActual();
			while(it.hasNext()) {
				String ciudad = it.next();
				adyacentes.add(ciudad);
				
				if(!estado.isVisitada(ciudad)){//si no esta visitado el vecino
					//Aplico los cambios que resultan de tomar esa decicion
					Ruta<String> ruta = grafo.obtenerRuta(estado.getCiudadActual(), ciudad);
					estado.agregarAlCamino(ciudad);
					estado.setCiudadActual(ciudad);
					estado.sumarDistancia(ruta.getDistancia());
					estado.marcarVisitada(ciudad);
					
					//Si no debo podar
					if(!this.poda(estado)){//esta linea puede ir o no 
						//Llamo al backtraking
						this.back(estado, grafo);//esta linea siempre va
					}

					//Deshago los cambios que resultaron de tomar esa decision
						estado.quitarUltimoDelCamino();
						estado.setCiudadActual(original);
						estado.restarDistancia(ruta.getDistancia());
						estado.desmarcarVisitada(ciudad);
				}
			}
		}	
		
	}
	
	public Solucion back(GrafoNoDirigido<String> grafo, String origen){
		this.mejorSolucion = null;
		
		//generacion del estado inicial
		Estado estado = new Estado(origen);
		estado.agregarAlCamino(origen);
		estado.marcarVisitada(origen);
		
		//llamo al backtraking
		this.back(estado, grafo);
		System.out.println("Cantidad de Estados: " + estado.getCantEstados());
		System.out.println("Cantidad de Soluciones: " + estado.getCantSoluciones()+"\n");
	
		return this.mejorSolucion;
	}
	

	
	private boolean poda(Estado estado) {//si ya no vale la pena seguir x aca, no sigo busando por ahi (por este estado).
		return (this.mejorSolucion != null && estado.getDistanciaCamino() > this.mejorSolucion.getDistancia());
	}
	
	
}
