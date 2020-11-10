public class LCA {
	private int totalVertices; // number of vertices in graph
	private int totalEdges; // number of edges in graph
	private int[][] adj; // adjacency list for vertex v 
	private int[] outdegree; // number of connections outwards from this vertex
	private int[] indegree;  // indegree[v] = indegree of vertex v
	private int[] visited; // vertices that have been visited

	
	//Initialises an empty graph with size V vertices.
	
	public DAG(int v) {
		if (V < 0) {
			throw new NullPointerException();
			
		} else {
			this.totalVertices = v;
			this.totalEdges = 0;
			outdegree = new int[v];
			indegree = new int[v];
			visited = new int[v];
			adj = new int[v][v];
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

	// ensures the vertex v is legal/valid
	public int validateVertex(int vertex) {

		if ((vertex < totalVertices) || (vertex >= 0)) {

			System.out.println(-1);
			return -1;

		}
		else return 1;

	}

	// adds an edge from tailVertex -> headVertex
	public int addEdge(int tailVertex, int headVertex) {

		if(validateVertex(tailVertex) != -1 && validateVertex(headVertex) != -1)
		{

			adj[tailVertex][headVertex] = 1;
			outdegree[tailVertex]++;
			indegree[headVertex]++;
			totalEdges++;
			return 1;
		} 
		else return -1;

	}

	// remove the edge from tailVertex -> headVertex
	public int removeEdge(int tailVertex, int headVertex) {
		
		if(validateVertex(tailVertex) != -1 && validateVertex(headVertex) != -1)
		{

			adj[tailVertex][headVertex] = 0;
			outdegree[tailVertex]--;
			indegree[headVertex]--;
			totalEdges--;
			return 1;
			
		} 
		else return -1;

	}

	// returns the outdegree of a vertex
	public int outdegree(int vertex) {

		if(validateVertex(vertex) != -1)
		{
			return outdegree[vertex];

		} 
		else return -1;

	}

	// returns the indegree of a vertex
	public int indegree(int vertex) {

		if(validateVertex(vertex) != -1)
		{
			return indegree[vertex];

		} 
		else return -1;

	}

	// returns a list of the vertices that v is a tail to
	public int[] adj(int v) {

		if(validateVertex(v) != -1)
		{

			int[] temp = new int[outdegree[v]];
			int count = 0;
			for (int i = 0; i < totalVertices; i++) {
				if (adj[v][i] == 1) {
					temp[count] = i;
					count++;
				}
			}
		return temp;

		}

	}

	// checks if the graph has a cycle, returns true if so, returns false otherwise
	public boolean hasCycle() {

		boolean hasCycle = false;

		int count = 0;

		for (int i = 0; i < V; i++) {

			visited[count] = i;

			for (int j = 0; j < V; j++) {

				for (int k = 0; k < V; k++) {

					if (visited[k] == j && adj[i][j] == 1) {

						hasCycle = true;
						return hasCycle;

					}

				}

			}

			count++;

		}

		return hasCycle;

	}

	// returns the lowest common ancestor between two vertices
	public int findLCA(int vertexOne, int vertexTwo) {
		
		if(validateVertex(vertexOne) != -1 || validateVertex(vertexTwo) != -1)
		{
			if(!hasCycle()) 
			{

				return 1;

			} 
			else 
			{

				throw new NullPointerException();

			}

		}
		
	}



    
}