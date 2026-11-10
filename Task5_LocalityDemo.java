public class Task5_LocalityDemo {
    public static void main(String[] args) {
        int size = 10_000_000;
        int[] data = new int[size];

        long startTemp = System.nanoTime();
        long accumulator = 0;
        for (int i = 0; i < size; i++) {
            accumulator += 5;
        }
        long endTemp = System.nanoTime();
        long startSpatial = System.nanoTime();
        long sum = 0;
        for (int i = 0; i < size; i++) {
            sum += data[i];
        }
        long endSpatial = System.nanoTime();

        System.out.printf("Temporal Locality Loop Time: %.4f ms\n", (endTemp - startTemp) / 1e6);
        System.out.printf("Spatial Locality Loop Time:  %.4f ms\n", (endSpatial - startSpatial) / 1e6);
    }
}