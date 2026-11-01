public class Task5_LocalityDemo {
    public static void main(String[] args) {
        int size = 10_000_000;
        int[] data = new int[size];

        // Temporal Locality Demonstration: Repeated access to single variable
        long startTemp = System.nanoTime();
        long accumulator = 0;
        for (int i = 0; i < size; i++) {
            accumulator += 5; // 'accumulator' remains in CPU Register/L1 Cache
        }
        long endTemp = System.nanoTime();

        // Spatial Locality Demonstration: Sequential access to contiguous memory
        long startSpatial = System.nanoTime();
        long sum = 0;
        for (int i = 0; i < size; i++) {
            sum += data[i]; // 'data[i]' accesses adjacent memory loaded into cache lines
        }
        long endSpatial = System.nanoTime();

        System.out.printf("Temporal Locality Loop Time: %.4f ms\n", (endTemp - startTemp) / 1e6);
        System.out.printf("Spatial Locality Loop Time:  %.4f ms\n", (endSpatial - startSpatial) / 1e6);
    }
}