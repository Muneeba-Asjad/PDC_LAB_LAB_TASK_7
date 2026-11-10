import java.util.Random;

public class Task2_LoopOrderingComparison {
    private static final int N = 2048;

    public static void main(String[] args) {
        double[][] A = new double[N][N];
        double[][] B = new double[N][N];
        Random rand = new Random(42);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = rand.nextDouble();
                B[i][j] = rand.nextDouble();
            }
        }
        String[] orders = { "i-j-k", "i-k-j", "j-i-k", "j-k-i", "k-i-j", "k-j-i" };
        double[] executionTimes = new double[6];
        for (int m = 0; m < orders.length; m++) {
            double[][] C = new double[N][N];
            long startTime = System.nanoTime();
            switch (orders[m]) {
                case "i-j-k":
                    for (int i = 0; i < N; i++)
                        for (int j = 0; j < N; j++)
                            for (int k = 0; k < N; k++)
                                C[i][j] += A[i][k] * B[k][j];
                    break;
                case "i-k-j":
                    for (int i = 0; i < N; i++)
                        for (int k = 0; k < N; k++)
                            for (int j = 0; j < N; j++)
                                C[i][j] += A[i][k] * B[k][j];
                    break;
                case "j-i-k":
                    for (int j = 0; j < N; j++)
                        for (int i = 0; i < N; i++)
                            for (int k = 0; k < N; k++)
                                C[i][j] += A[i][k] * B[k][j];
                    break;
                case "j-k-i":
                    for (int j = 0; j < N; j++)
                        for (int k = 0; k < N; k++)
                            for (int i = 0; i < N; i++)
                                C[i][j] += A[i][k] * B[k][j];
                    break;
                case "k-i-j":
                    for (int k = 0; k < N; k++)
                        for (int i = 0; i < N; i++)
                            for (int j = 0; j < N; j++)
                                C[i][j] += A[i][k] * B[k][j];
                    break;
                case "k-j-i":
                    for (int k = 0; k < N; k++)
                        for (int j = 0; j < N; j++)
                            for (int i = 0; i < N; i++)
                                C[i][j] += A[i][k] * B[k][j];
                    break;
            }
            long endTime = System.nanoTime();
            executionTimes[m] = (endTime - startTime) / 1e9;
            System.out.printf("Order %-7s executed in: %8.4f seconds\n", orders[m], executionTimes[m]);
        }
    }
}