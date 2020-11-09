public class LCA {
	private int totalVertices;// # of vertices in graph
	private int totalEdges;// # of edges in graph
	private int[][] adj; // adjacency list for vertex v 
	private int[] outdegree;// outdegree of vertex v
	private int[] indegree;  // indegree[v] = indegree of vertex v
	private int[] visited; // vertices that have been visited

	
	//Initialises an empty graph with size V vertices.
	
	public DAG(int V) {
		if (V < 0) {
			throw new NullPointerException();
			
		} else {
			this.totalVertices = V;
			this.totalEdges = 0;
			outdegree = new int[V];
			indegree = new int[V];
			visited = new int[V];
			adj = new int[V][V];
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					adj[i][j] = 0;
				}
			}
		}
    }

    // returns total vertices in the graph
    public int getTotalVertices() {
		return totalVertices;
    }
    
    // returns total vertices in the graph
    public int getTotalEdges() {
		return totalEdges;
	}
    
}