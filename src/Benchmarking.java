import java.util.Random;

public class Benchmarking {

    private MetodosOrdenamiento mOrdenamiento;
    
    public Benchmarking() {
        long currentMillis = System.currentTimeMillis();  //sacar fecha
        long currentNano = System.nanoTime();
        System.out.println("Mili:  " + currentMillis);
        System.out.println("Nano:  " +currentNano);

        mOrdenamiento = new MetodosOrdenamiento();
        int[] arreglo = generarArregloAleatorio(1_000_000);
        Runnable tarea = ()-> mOrdenamiento.burbujaTradicional(arreglo);

        double tiempoDuracionMillis = medirConCurrentTimeMiles(tarea);
        double tiempoDuracionNano = medirConNanoTime(tarea);


        System.out.println("Tiempo Milisegundos: " + tiempoDuracionMillis);
        System.out.println("Tiempo Nanosegundos: " + tiempoDuracionNano);
    } 
 
    
    private int[] generarArregloAleatorio(int tamano) {
        // 0 al 99999
        int[] array = new int[tamano];
        Random random = new Random();
        for (int i = 0; i < tamano; i++) {
            array[i] = random.nextInt(100000);
        }
        return array;
    }
    
    public double medirConCurrentTimeMiles(Runnable tarea) {
        long inicio = System.currentTimeMillis();
        tarea.run();
        long fin = System.currentTimeMillis();
        double tiempoSegundos = (fin - inicio) / 1000.0; 
        return tiempoSegundos;
    }

    public double medirConNanoTime(Runnable tarea) {
        long inicio = System.nanoTime();
        tarea.run();
        long fin = System.nanoTime();
        double tiempoSegundos = (fin - inicio) / 1_000_000_000.0; 
        return tiempoSegundos;
    }
}