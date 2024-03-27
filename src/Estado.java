import java.util.ArrayList;

public class Estado {
	
	private String ciudadInicial;
	private String ciudadActual;	
	private int distancia;
	private ArrayList<String> caminoActual;
	private ArrayList<String> ciudadesVisitadas;
	
	private int cantEstados;
	private int cantSoluciones;
		
	public Estado(String origen) {		
		this.ciudadInicial = origen;
		this.ciudadActual = origen;
		this.distancia = 0;
		this.caminoActual = new ArrayList<>();	
		this.ciudadesVisitadas = new ArrayList<>();
		
		this.cantEstados = 0;
		this.cantSoluciones = 0;
	}
	
	public int getCantEstados() {
		return cantEstados;
	}

	public void aumentarCantEstados() {
		this.cantEstados++;
	}
	
	public int getCantSoluciones() {
		return cantSoluciones;
	}

	public void aumentarCantSoluciones() {
		this.cantSoluciones++;
	}
	
	public String getCiudadInicial() {
		return this.ciudadInicial;
	}
	
	public void setCiudadInicial(String ciudadInicial) {
		this.ciudadInicial = ciudadInicial;
	}
	
	public String getCiudadActual() {
		return this.ciudadActual;
	}
	
	public void setCiudadActual(String ciudadActual) {
		this.ciudadActual = ciudadActual;
	}
	
	public int getSize() {
		return this.caminoActual.size();
	}
	
	public boolean isVisitada(String ciudad) {
		return ciudadesVisitadas.contains(ciudad);
	}
		
	public void marcarVisitada(String ciudad) {	
		this.ciudadesVisitadas.add(ciudad);
	}
	
	public void desmarcarVisitada(String ciudad) {
		this.ciudadesVisitadas.remove(ciudad);
	}
	
	public int ciudadesVisitadasSize() {
		return this.ciudadesVisitadas.size();
	}
	
	public void sumarDistancia(int distancia) {
		this.distancia += distancia;	
	}
	
	public void restarDistancia(int distancia) {
		this.distancia -= distancia;
	}
	
	public int getDistanciaCamino( ) {
		return this.distancia;
	}
	
	public void agregarAlCamino(String ruta) {
		this.caminoActual.add(ruta);
	}
	
	
	public void quitarUltimoDelCamino() {
		this.caminoActual.remove(this.caminoActual.size() - 1);
	}
	
	public ArrayList<String> getCamino() {
		ArrayList<String> camino = new ArrayList<>();
		
		for(String ruta : caminoActual) {
			camino.add(ruta);
		}
		
		return camino;
	}

	public String getUltimaCiudad(){
		String ultimaCiudad =this.getCamino().get(getSize()-1);
		return ultimaCiudad;
		
	}

	@Override
	public String toString() {
		return "Estado [distancia=" + distancia + ", caminoActual="
				+ caminoActual + "]";
	}


}
