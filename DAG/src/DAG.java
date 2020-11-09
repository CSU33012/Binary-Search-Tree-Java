public class LCA {
	private int V;// # of vertices in graph
	private int E;// # of edges in graph
	private int[][] adj; // adjacency list for vertex v 
	private int[] outdegree;// outdegree of vertex v
	private int[] indegree;  // indegree[v] = indegree of vertex v
	private int[] visited; // vertices that have been visited

	
	//Initialises an empty graph with size V vertices.
	
	public DAG(int V) {
		if (V < 0) {
			throw new NullPointerException();
			
		} else {
			this.V = V;
			this.E = 0;
			indegree = new int[V];
			indegree = new int[V];
			outdegree = new int[V];
			visited = new int[V];
			adj = new int[V][V];
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					adj[i][j] = 0;
				}
			}
		}
    }
    
}