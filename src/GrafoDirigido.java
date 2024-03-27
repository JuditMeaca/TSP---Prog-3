import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

	private HashMap<String,ArrayList<Ruta<T>>> ciudadesMap;
	
	 public GrafoDirigido() {
	        this.ciudadesMap = new HashMap<>(); 
	 }
	
	@Override
	public void agregarCiudad(String ciudad) {
		ciudadesMap.putIfAbsent(ciudad, new ArrayList<Ruta<T>>());
	}

	@Override
	public void borrarCiudad(String ciudad) {
		this.ciudadesMap.remove(ciudad);
		for(String c: this.ciudadesMap.keySet()){//recorro cada vertice
			ArrayList <Ruta<T>> rutas = ciudadesMap.get(c);//le pido los arcos a cada clave
			
			boolean borrado = false;
			int i = 0;
			
			while(i < rutas.size() && !borrado){
				Ruta<T> arco = rutas.get(i);
				if(arco.getCiudadDestino().equalsIgnoreCase(ciudad)){
					rutas.remove(i);
					borrado = true;
				}
				i++;
			}
		}
	}

	@Override
	public void agregarRuta(String ciudad1, String ciudad2, int distancia) {
		if(this.contieneCiudad(ciudad1) && this.contieneCiudad(ciudad2)){
			ArrayList<Ruta<T>> arcos = this.ciudadesMap.get(ciudad1);
			
			boolean existe = false;
			int i = 0;
			
			while(i < arcos.size() && !existe){
				Ruta<T> arco = arcos.get(i);
				if(arco.getCiudadDestino().equalsIgnoreCase(ciudad2)){
					existe = true;
				}
				i++;
			}
		if(!existe){
			Ruta<T> nueva = new Ruta<T>(ciudad1, ciudad2, distancia);
			arcos.add(nueva);
		}
		
		}	
	}

	@Override
	public void borrarRuta(String ciudad1, String ciudad2) {
		 ArrayList<Ruta<T>> rutas = ciudadesMap.get(ciudad1);

		    if (rutas != null) {
		        for (int i = 0; i < rutas.size(); i++) {
		            Ruta<T> ruta = rutas.get(i);
		            if (ruta.getCiudadDestino().equalsIgnoreCase(ciudad2)) {
		                rutas.remove(i);
		                break; // Una vez encontrado y borrado el arco, salimos del bucle.
		            }
		        }
		    }
			
	}

	@Override
	public boolean contieneCiudad(String ciudad) {
		return this.ciudadesMap.containsKey(ciudad);
	}

	
	@Override
	public boolean existeRuta(String ciudad1, String ciudad2) {
		ArrayList <Ruta<T>> rutas = ciudadesMap.get(ciudad1);
			if(rutas!=null){
				for(Ruta<T> r: rutas){
					if(r.getCiudadDestino().equalsIgnoreCase(ciudad2)){
						return true;
					}
				}
			}
		return false;
	}

	@Override
	public Ruta<T> obtenerRuta(String ciudad1, String ciudad2) {
		ArrayList<Ruta<T>> rutas = ciudadesMap.get(ciudad1);

        if (rutas != null) {
            for (Ruta<T> ruta : rutas) {
                if (ruta.getCiudadDestino().equals(ciudad2)) {
                    return ruta;
                }
            }
        }
        return null; // Devuelve null si no se encuentra el arco
	}

	@Override
	public int cantidadCiudades() {
		 return this.ciudadesMap.size();
		
	}

	@Override
	public int cantidadRutas() {
		int totalRutas = 0;
        for (ArrayList<Ruta<T>> r : this.ciudadesMap.values()) {
            totalRutas += r.size();
        }
        return totalRutas;
	}

	@Override
	public Iterator<String> obtenerCiudades() {//devolver un iterador que le permita desde afuera navegar por los ids de los vertices
		
		return this.ciudadesMap.keySet().iterator();
	}

	@Override
	public Iterator<String> obtenerAdyacentes(String ciudad) {
		 ArrayList<Ruta<T>> rutas = this.ciudadesMap.get(ciudad);
	        if (rutas != null) {
	            ArrayList<String> adyacentes = new ArrayList<>();
	            for (Ruta<T> r : rutas) {
	                adyacentes.add(r.getCiudadDestino());
	            }
	            return adyacentes.iterator();
	        }
	        return null;
		
	}

	@Override
	public Iterator<Ruta<T>> obtenerRutas() {
		ArrayList<Ruta<T>> todasLasRutas = new ArrayList<>();
        for (ArrayList<Ruta<T>> r : this.ciudadesMap.values()) {
        	todasLasRutas.addAll(r);
        }
        return todasLasRutas.iterator();
	}

	@Override
	public Iterator<Ruta<T>> obtenerRutas(String ciudadId) {
		ArrayList<Ruta<T>> rutas = this.ciudadesMap.get(ciudadId);
        if (rutas != null) {
            return rutas.iterator();
        }
        return null;
    
	}
	
}
