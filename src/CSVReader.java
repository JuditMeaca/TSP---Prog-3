
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class CSVReader {

	private String path;
	
	public CSVReader(String path) {
		this.path = path;
	}
	
	public void read(Grafo<String> grafo) {
		// Obtengo una lista con las lineas del archivo
		// lines.get(0) tiene la primer linea del archivo
		// lines.get(1) tiene la segunda linea del archivo... y así
		ArrayList<String[]> lines = this.readContent();
		
		for (String[] line: lines) {
			// Cada linea es un arreglo de Strings, donde cada posicion guarda un elemento
			String origen = line[0].trim();// ciudad origen
			String destino = line[1].trim(); // ciudad destino
			Integer distancia = Integer.parseInt(line[2].trim());//distancia en kilometros
			
			// Aca instanciar lo que necesiten en base a los datos leidos
			// Agregar los vértices al grafo
            grafo.agregarCiudad(origen);
            grafo.agregarCiudad(destino);

            // Agregar el arco al grafo
            grafo.agregarRuta(origen, destino, distancia);
		}
	}

	private ArrayList<String[]> readContent() {
		ArrayList<String[]> lines = new ArrayList<String[]>();

		File file = new File(this.path);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				line = line.trim();
				lines.add(line.split(";"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}
		
		return lines;
	}

}