
public class Ruta<T> {
	
	private String ciudadOrigen;
	private String ciudadDestino;
	private int distancia;
	
	public Ruta(String ciudadOrigen, String ciudadDestino, int distancia) {
		this.ciudadOrigen = ciudadOrigen;
		this.ciudadDestino = ciudadDestino;
		this.distancia = distancia;
	}

	public String getCiudadOrigen() {
		return ciudadOrigen;
	}

	public String getCiudadDestino() {
		return ciudadDestino;
	}

	public int getDistancia() {
		return distancia;
	}
	
	public boolean equals(Object o) {
		try {
			@SuppressWarnings("unchecked")
			Ruta<T> ruta = (Ruta<T>) o;
			if(this.getCiudadOrigen().equals(ruta.getCiudadOrigen()) && this.getCiudadDestino().equals(ruta.getCiudadDestino()) && this.getDistancia() == ruta.getDistancia()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return	false;
		}
	}

	@Override
	public String toString() {
		return "Ruta [ciudadOrigen=" + ciudadOrigen + ", ciudadDestino="
				+ ciudadDestino + ", distancia=" + distancia + "]";
	}
	
	

}
