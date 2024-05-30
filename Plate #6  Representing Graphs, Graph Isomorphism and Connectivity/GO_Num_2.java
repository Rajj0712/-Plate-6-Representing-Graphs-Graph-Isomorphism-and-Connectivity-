import org.ejml.simple.SimpleMatrix;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GO_Num_2 {
    public static void main(String[] args) {
        SimpleMatrix matrix = takeAdjacencyMatrixInput();
        if (matrix != null) {
            final Graph g = new Graph(matrix);
            g.printEdgesWithCounts();
        } else {
            System.out.println("Failed to create the adjacency matrix.");
        }
    }

    public static SimpleMatrix takeAdjacencyMatrixInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();
        sc.nextLine();

        double[][] matrix = new double[vertices][vertices];

        for (int i = 0; i < vertices; i++) {
            System.out.printf("Enter row %d of adjacency matrix: ", i + 1);
            String[] input = sc.nextLine().split(" ");

            Set<Integer> visited = new HashSet<>();
            int j = 0;
            for (String v : input) {
                int val = Integer.parseInt(v);
                if (!visited.contains(val)) {
                    matrix[i][j++] = val;
                    visited.add(val);
                }
            }
        }

        return new SimpleMatrix(matrix);
    }
}
