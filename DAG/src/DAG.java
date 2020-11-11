
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class DAG {
    private int totalVertices; // The number of Vertices in the graph
    private int totalEdges; // The number of edges in the graph
    private ArrayList<Integer>[] adj; // An adjancencies list for each node in the graph
    private int[] indegree; // stores the number of adjancencies pointing towards this node
    private boolean marked[]; // tracks visited vertices
    private boolean hasCycle; // will be true if a cycle is found within the graph
    private boolean stack[]; // The visited order of vertices
    private int[] distTo; // used for finding the shortest paths in the list
    private int[] edgeTo; // used to document the route of the paths in the list

    public DAG(int totalVertices){

        if (totalVertices < 0) throw new IllegalArgumentException("The number of vertices in the graph must be greater than 0.");

        //initialise variables
        this.totalVertices = totalVertices;
        this.totalEdges = 0;
        this.indegree = new int[totalVertices];
        this.marked = new boolean[totalVertices];
        this.stack = new boolean[totalVertices];
        this.adj = (ArrayList<Integer>[]) new ArrayList[totalVertices];

        //initialise all the values of the adjancency list
        for (int i = 0; i < totalVertices; i++){
            adj[i] = new ArrayList<Integer>();
        }

    }

    // returns the number of vertices
    public int returnTotalVertices(){
        return totalVertices;
    }

    // return the number of edges
    public int returnTotalEdges(){
        return totalEdges;
    }

    // checks that the vertex exists in the graph
    public boolean validateVertex(int vertex){
		if (vertex >= 0 && vertex < this.totalVertices)
		{
			return true;
		}
		else 
		{
            return false;
        }
    }

    // add a directed edge from arg1 to arg2
    public boolean addEdge(int from, int to){
		if (validateVertex(from) && validateVertex(to))
		{
            adj[from].add(to);  //add adjanceny to list
            indegree[to]++;     //increase the tracking of the number of edges pointin into this node
            totalEdges++;
            return true;
		}
		else
		{
            System.out.println("Please enter vertices which exist within the graph");
            return false;
        }
    }


    // returns the number of edges incident to the input argument vertex
    public int indegree(int v){
		if (!validateVertex(v))
		{
            //if the vertex does not exist return an error
            return -1;
		} 
		else {
            return this.indegree[v];
        }
    }

    // returns the number of edges incident from the input argument vertex
    public int outdegree(int v){
		if (!validateVertex(v))
		{
            //return error case if vertex does not exist
            return -1;
		} 
		else 
		{
            return this.adj[v].size();
        }
    }

  
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    
    public boolean hasCycle(){ return this.hasCycle;}


    public boolean findCycle(int vertex){
        marked[vertex] = true;
        stack[vertex] = true;

		for (int i : adj(vertex))
		{
            //go through the adjacencies
			if (!marked[i])
			{
                //recursively find cycle for this node and its adjacencies
                findCycle(i);
            } 
			else if (stack[i])
			{
                //the node has already been visited
                hasCycle = true;
                return true;    //return true as cycle is found
            }
        }

        //remove the node 
        stack[vertex] = false;
        return false;
	}
 
	// Performs a breadth first search of the DAG using the queue technique
    public ArrayList<Integer> BFS(int source){
        //crate an array to store visited vertices
        boolean visited[] = new boolean[this.totalVertices];

        LinkedList<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> order = new ArrayList<Integer>();

        //mark the source as visited
        visited[source] = true;
        //add the source to the queue
        queue.add(source);

        //while there are no vertices left in the queue
        while (queue.size()!=0){
            //Dequeue , return the head of the list
            source = queue.poll();
            order.add(source); //add the source to the return order
            
            
            //Go through all adj vertices of the source, mark as visited and add to the queue
            Iterator<Integer> iter = adj(source).iterator();
            while (iter.hasNext()){
                int node = iter.next();
                if (!visited[node]){
                    visited[node] = true;
                    queue.add(node);
                }
            }

        }

        //return the nodes visited to get to the start of the queue
        return order;
    }

    
    // returns a new DAG with the edges reversed
    public DAG reverse(){
        DAG reversedDAG = new DAG(this.totalVertices);
        for (int i = 0; i < this.totalVertices; i++){
            //loop through each vertice
            for (int j: adj(i)) {
                reversedDAG.addEdge(j, i); //reverse the direction of all edges
            }
        }
        return reversedDAG;
    }



    public int findLCA(int vertexOne, int vertexTwo){
        if (findCycle(0)){
            System.out.println("Cycle found in the graph, graph is not a DAG");
            return -1; //return error case
        }
        
        //validate search nodes exist
        if (!this.validateVertex(vertexOne) || !this.validateVertex(vertexTwo)) return -1;

        DAG reversed = this.reverse();
        ArrayList<Integer> vertexOnePath = reversed.BFS(vertexOne);
        ArrayList<Integer> vertexTwoPath = reversed.BFS(vertexTwo);
        ArrayList<Integer> commonAncestors = new ArrayList<Integer>();

        boolean commonAncestorFound = false;

        //loop through the path lists and find the earliest ancestor (brute force)
        for (int i = 0; i < vertexOnePath.size(); i++){
            for (int j = 0; j < vertexTwoPath.size(); j++){
                if (vertexOnePath.get(i) == vertexTwoPath.get(j)){
                    
                    //a common ancestor has been found, add it to the list of ancestors ()
                    commonAncestors.add(vertexOnePath.get(i));
                    commonAncestorFound = true;
                }
            }
        }

        if (commonAncestorFound){
            return commonAncestors.get(0); //return the first one found
        } else {
            return -1; //return the error case 
        }
        
	}

}