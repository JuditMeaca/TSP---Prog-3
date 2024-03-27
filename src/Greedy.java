import java.util.HashSet;
import java.util.Iterator;

public class Greedy {
    
    public Solucion greedy(GrafoNoDirigido<String> grafo, String origen) {
        HashSet<String> ciudadesVisitadas = new HashSet<>();
        Solucion solucion = new Solucion();
        
        solucion.agregarCiudad(origen);
        ciudadesVisitadas.add(origen);
        
        while (ciudadesVisitadas.size() < grafo.cantidadCiudades()) {
             String ciudadActual = solucion.getUltimaCiudad();
             String ciudadCercana = ciudadMasCercana(ciudadActual, ciudadesVisitadas, grafo);
                
             if (ciudadCercana != null) {
                Ruta<String> ruta = grafo.obtenerRuta(ciudadActual, ciudadCercana);
                solucion.agregarCiudad(ciudadCercana);
                solucion.sumarDistancia(ruta.getDistancia());
                ciudadesVisitadas.add(ciudadCercana);
             } else {
                return null;
              }
            }

            if (grafo.existeRuta(solucion.getUltimaCiudad(), origen)) {
                Ruta<String> rutaVuelta = grafo.obtenerRuta(solucion.getUltimaCiudad(), origen);
                solucion.agregarCiudad(origen);
                solucion.sumarDistancia(rutaVuelta.getDistancia());
            }else{
            	return null;
            }
    

        return solucion.toSolucion();
    }

    private String ciudadMasCercana(String ciudadActual, HashSet<String> ciudadesVisitadas, GrafoNoDirigido<String> grafo) {
        int menorDistancia = Integer.MAX_VALUE;
        String ciudadCercana = null;

        Iterator<String> adyacentesIterator = grafo.obtenerAdyacentes(ciudadActual);
        while (adyacentesIterator.hasNext()) {
            String ciudad = adyacentesIterator.next();

            if (!ciudadesVisitadas.contains(ciudad)) {
                Ruta<String> rutaActual = grafo.obtenerRuta(ciudadActual, ciudad);
                int distancia = rutaActual.getDistancia();

                if (distancia < menorDistancia) {
                    menorDistancia = distancia;
                    ciudadCercana = ciudad;
                }
            }
        }

        return ciudadCercana;
    }

}

