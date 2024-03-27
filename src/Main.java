import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String path = "datasets/dataset1.txt";
        CSVReader reader = new CSVReader(path);
        GrafoNoDirigido<String> grafo = new GrafoNoDirigido<>();
        reader.read(grafo);
        
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        String ciudadOrigen = "";

        while (!grafo.contieneCiudad(ciudadOrigen)) {
            System.out.print("Ingrese la ciudad de origen (con mayúscula y tildes cuando corresponda): \n");
            ciudadOrigen = scanner.nextLine();

            if (!grafo.contieneCiudad(ciudadOrigen)) {
                System.out.println("La ciudad de origen '" + ciudadOrigen + "' no existe en el grafo. Intente nuevamente.");
            }
        }

        System.out.println("La ruta de distancia más corta posible que visita cada ciudad exactamente una vez y regresa a la ciudad origen '"+ ciudadOrigen +"':\n");
        System.out.println("Greedy:");
        buscarYMostrarSolucionGreedy(grafo, ciudadOrigen);
        System.out.println("Backtracking:");
        buscarYMostrarSolucionBacktracking(grafo, ciudadOrigen);
    
    }

    private static void buscarYMostrarSolucionBacktracking( GrafoNoDirigido<String> grafo, String origen) {
    	Timer timer = new Timer();
        timer.start();

        Backtraking backtraking = new Backtraking();
        Solucion sol = backtraking.back(grafo, origen);
     
        if (sol != null) {
         	mostrarSolucion(sol, timer);
        } else {
        	System.out.println("Tiempo de ejecución: " + timer.stop() + " milisegundos\n");
            System.out.println("No se pudo encontrar una solución\n");
        }
		
	}

	public static void buscarYMostrarSolucionGreedy(GrafoNoDirigido<String> grafo, String origen) {
        Timer timer = new Timer();
        timer.start();

        Greedy greedy = new Greedy();
        Solucion sol = greedy.greedy(grafo, origen);

        if (sol != null) {
        	mostrarSolucion(sol, timer);
        } else {
        	System.out.println("Tiempo de ejecución: " + timer.stop() + " milisegundos\n");
            System.out.println("No se pudo encontrar una solución\n");
        }
    }

    public static void mostrarSolucion(Solucion sol, Timer timer) {
        System.out.println(sol.getCamino());
        System.out.println("Distancia total: "+sol.getDistancia() + " kms");
        System.out.println("Tiempo de ejecución: " + timer.stop() + " milisegundos\n");
    }
}
