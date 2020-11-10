import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

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
		if (vertex > 0 && vertex <= this.totalVertices)
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


    public boolean findCycle(int v){
        marked[v] = true;
        stack[v] = true;

		for (int i : adj(v))
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
        stack[v] = false;
        return false;
	}
    
}