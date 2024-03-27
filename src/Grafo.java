import java.util.Iterator;

public interface Grafo<T> { 
	
		// Agrega un vertice 
		public void agregarCiudad(String ciudad);

		// Borra un vertice
		public void borrarCiudad(String ciudad);

		// Agrega un arco con una etiqueta, que conecta el verticeId1 con el verticeId2
		public void agregarRuta(String ciudad1, String ciudad2, int distancia);

		// Borra el arco que conecta el verticeId1 con el verticeId2
		public void borrarRuta(String ciudad1, String ciudad2);

		// Verifica si existe un vertice
		public boolean contieneCiudad(String ciudad);  

		// Verifica si existe un arco entre dos vertices
		public boolean existeRuta(String ciudad1, String ciudad2);
		
		// Obtener el arco que conecta el verticeId1 con el verticeId2
		public Ruta<T> obtenerRuta(String ciudad1, String ciudad2);

		// Devuelve la cantidad total de vertices en el grafo
		public int cantidadCiudades();

		// Devuelve la cantidad total de arcos en el grafo
		public int cantidadRutas();

		// Obtiene un iterador que me permite recorrer todos los vertices almacenados en el grafo 
		public Iterator<String> obtenerCiudades();

		// Obtiene un iterador que me permite recorrer todos los vertices adyacentes a verticeId 
		public Iterator<String> obtenerAdyacentes(String ciudad);

		// Obtiene un iterador que me permite recorrer todos los arcos del grafo
		public Iterator<Ruta<T>> obtenerRutas();
			
		// Obtiene un iterador que me permite recorrer todos los arcos que parten desde verticeId
		public Iterator<Ruta<T>> obtenerRutas(String ciudad);

	
}
