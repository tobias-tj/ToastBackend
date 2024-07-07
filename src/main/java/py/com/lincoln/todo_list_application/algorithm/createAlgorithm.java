package py.com.lincoln.todo_list_application.algorithm;

import java.util.*;

public class createAlgorithm {
    /**
     * Encuentra la ruta más corta desde un nodo inicial hasta todos los demás nodos en un grafo ponderado no dirigido.
     * Utiliza el algoritmo de Dijkstra.
     *
     * @param n         Número de nodos en el grafo.
     * @param edges     Lista de aristas, donde cada arista está representada como un arreglo [u, v, w]
     *                  que indica una arista de peso w entre los nodos u y v.
     * @param startNode Nodo inicial desde donde se calculan las distancias.
     * @return          Arreglo de distancias más cortas desde el nodo inicial hasta todos los demás nodos.
     */
    public int[] algorithmPath(int n, int[][] edges, int startNode){
        // 1. Inicialización del grafo como una lista de listas de aristas
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        // 2. Construcción del grafo a partir de las aristas proporcionadas
        for(int[] edge: edges){
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            int w = edge[2];
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        // 3. Inicialización de distancias con valor infinito y distancia 0 para el nodo inicial
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startNode - 1] = 0;

        // 4. Cola de prioridad para explorar nodos en orden de menor distancia acumulada
        PriorityQueue<Node> pq = new PriorityQueue<Node>(Comparator.comparing(node -> node.distance));
        pq.offer(new Node(startNode - 1, 0));

        // 5. Procesamiento de nodos mientras la cola no esté vacía
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.node;
            int currentDistance = current.distance;

            // Si la distancia actual es mayor que la almacenada, se descarta el nodo
            if (currentDistance > distances[currentNode]) {
                continue;
            }

            // Para cada vecino del nodo actual, se actualiza la distancia si se encuentra un camino más corto
            for (Edge neighbor : graph.get(currentNode)) {
                int newDistance = currentDistance + neighbor.weight;

                // Si se encuentra un camino más corto hacia el vecino, se actualiza la distancia y se añade a la cola
                if (newDistance < distances[neighbor.dest]) {
                    distances[neighbor.dest] = newDistance;
                    pq.offer(new Node(neighbor.dest, newDistance));
                }
            }
        }

        // 6. Construcción del resultado final, convirtiendo distancias infinitas en -1 para nodos inalcanzables
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            result[i] = distances[i] == Integer.MAX_VALUE ? -1 : distances[i];
        }

        return result;
    }

    // Clase para representar una arista
    static class Edge {
        int dest;
        int weight;

        public Edge(int dest, int weight){
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Clase para representar un nodo con su distancia acumulada desde el nodo inicial
    static class Node{
        int node;
        int distance;

        public Node(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }
}
