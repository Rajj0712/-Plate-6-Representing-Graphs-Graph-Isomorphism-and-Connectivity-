import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GO_Num_7 {
    public static void main(String[] args) {
        Graph graph = takeEdgeInput();
        graph.printIncidenceMatrix();
    }

    public static Graph takeEdgeInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of edges: ");
        int numEdges = sc.nextInt();
        sc.nextLine();

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < numEdges; i++) {
            System.out.print("Enter edge (format (u,v) count, 'end' to stop): ");
            String input = sc.nextLine();
            if (input.equals("end")) {
                break;
            }

            // Extracting u, v, and count from the input
            String[] parts = input.split(" ");
            String[] uv = parts[0].substring(1, parts[0].length() - 1).split(",");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);
            int count = Integer.parseInt(parts[1]);

            edges.add(new Edge(u, v, count));
        }

        return new Graph(edges);
    }

    static class Edge {
        int u;
        int v;
        int count;

        public Edge(int u, int v, int count) {
            this.u = u;
            this.v = v;
            this.count = count;
        }
    }

    static class Graph {
        private final List<Edge> edges;

        public Graph(List<Edge> edges) {
            this.edges = edges;
        }

        public void printIncidenceMatrix() {
            int numVertices = findNumVertices();
            int[][] incidenceMatrix = new int[numVertices][edges.size()];

            for (int i = 0; i < edges.size(); i++) {
                Edge edge = edges.get(i);
                incidenceMatrix[edge.u][i] = edge.count;
                incidenceMatrix[edge.v][i] = edge.count;
            }

            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < edges.size(); j++) {
                    System.out.print(incidenceMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        private int findNumVertices() {
            int maxVertex = -1;
            for (Edge edge : edges) {
                maxVertex = Math.max(maxVertex, Math.max(edge.u, edge.v));
            }
            return maxVertex + 1;
        }
    }
}
