
public class GrafoNoDirigido<T> extends GrafoDirigido<T> {

	@Override
	public void agregarRuta(String ciudad1, String ciudad2, int distancia) {
		super.agregarRuta(ciudad1, ciudad2, distancia);
		super.agregarRuta(ciudad2, ciudad1, distancia);
	}
	
	@Override
	public void borrarRuta(String ciudad1, String ciudad2) {
		super.borrarRuta(ciudad1, ciudad2);
		super.borrarRuta(ciudad2, ciudad1);
	}
	
	@Override
	public int cantidadRutas() {
		return super.cantidadRutas() / 2;
	}

}
