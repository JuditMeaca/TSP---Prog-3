import java.util.ArrayList;


public class Solucion {
	
	private int distancia;
	private ArrayList<String> camino;
	
	public Solucion(){
		this.camino = new ArrayList<>();
		this.distancia = 0;
	}
	
	public Solucion(ArrayList<String> camino, int distancia){
		this.camino = camino;
		this.distancia = distancia;
	}
	
	public void agregarCiudad(String s){
		camino.add(s);
	}

	public int getDistancia() {
		return distancia;
	}

	public void sumarDistancia(int distancia) {
		this.distancia += distancia;
	}
	
	public void restarDistancia(int distancia) {
		this.distancia -= distancia;
	}

	public ArrayList<String> getCamino() {
		return new ArrayList<>(camino);
	}

	public String getUltimaCiudad() {
		String ultima = this.camino.get(this.camino.size()-1);
		return ultima;
	}

	public void clear() {
		this.camino.clear();
        this.distancia = 0;
		
	}

	public Solucion toSolucion() {
		return new Solucion(new ArrayList<>(this.camino), this.distancia);
	}

	
	

}
