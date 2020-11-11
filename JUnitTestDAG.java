import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
//-------------------------------------------------------------------------
/**
 *  
 *
 *  @author Darragh Murray
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class JUnitTestDAG {
    
    @Test
    public void testConstructor() 
    {
    	DAG graph;
    	
    	graph = new DAG(5);
    	assertEquals("Create a graph with five vertices, if successful the number of vertices returned by the returnTotalVertices() function should return 5.", graph.returnTotalVertices(), 5);
    }
    
    @Test
    public void testReturnTotalVertices() 
    {
    	DAG graph;
    	
    	graph = new DAG(2);
    	assertEquals("Create a graph with five vertices, the number of vertices returned by the returnTotalVertices() function should return 2.", graph.returnTotalVertices(), 2);
    	
    	graph = new DAG(11);
    	assertEquals("Create a graph with five vertices, the number of vertices returned by the returnTotalVertices() function should return 11.", graph.returnTotalVertices(), 11);
    	
    	graph = new DAG(25);
    	assertEquals("Create a graph with five vertices, the number of vertices returned by the returnTotalVertices() function should return 25.", graph.returnTotalVertices(), 25);
    }
    
    @Test
    public void testReturnTotalEdges() 
    {
    	DAG graph;
    	
    	graph = new DAG(5);
    	
    	assertEquals("Create a graph with five vertices and no edges, the number of edges returned by the returnTotalEdges() function should return 0.", graph.returnTotalEdges(), 0);
    	
    	graph.addEdge(1, 4);
    	assertEquals("Add an edge, the number of edges returned by the returnTotalEdges() function should return 1.", graph.returnTotalEdges(), 1);
    	
    	graph.addEdge(1, 4);
    	graph.addEdge(0, 3);
    	assertEquals("Add two edges, the number of edges returned by the returnTotalEdges() function should return 3.", graph.returnTotalEdges(), 3);
    }
    
    @Test
    public void testValidateVertex() 
    {
    	DAG graph;
    	
    	graph = new DAG(2);
    	assertEquals("Create a graph with 2 vertices, vertex 2 should be invalid.", graph.validateVertex(2), false);
    	
    	graph = new DAG(5);
    	assertEquals("Create a graph with 5 vertices, vertex 4 should be valid.", graph.validateVertex(4), true);
    	
    	graph = new DAG(8);
    	assertEquals("Create a graph with 8 vertices, vertex 0 should be valid.", graph.validateVertex(0), true);
    	
    	graph = new DAG(5);
    	assertEquals("Create a graph with 5 vertices, vertex -1 should be invalid.", graph.validateVertex(-1), false);
    }
    
    @Test
    public void testAddEdge() 
    {
    	DAG graph;
    	
    	graph = new DAG(5);
    	
    	assertEquals("Create an edge from vertex one to vertex two. If edge was created, the function should return true.", graph.addEdge(1, 2), true);
    	
    	assertEquals("Create an edge from vertex three to vertex one. If edge was created, the function should return true.", graph.addEdge(3, 1), true);
    	
    	assertEquals("Create an edge from vertex zero to vertex four. If edge was created, the function should return true.", graph.addEdge(0, 4), true);
    	
    	assertEquals("Create an edge from vertex minus one to vertex three. If edge was created, the function should return true.", graph.addEdge(-1, 3), false);
    	
    	assertEquals("Create an edge from vertex four to vertex five. If edge was created, the function should return true.", graph.addEdge(4, 5), false);
    }

    @Test
    public void testIndegree() 
    {
    	DAG graph;
    	
    	graph = new DAG(5);
    	
    	graph.addEdge(1, 2);
    	assertEquals("Create an edge incident to vertex two. The indegree of vertex two should be 1.", graph.indegree(2), 1);
    	
    	graph.addEdge(3, 2);
    	graph.addEdge(4, 2);
    	assertEquals("Add two more edges incident to vertex two. The indegree of vertex two should be 3.", graph.indegree(2), 3);
    	
    	assertEquals("The indegree of vertex three with no edges incident to it should be 0.", graph.indegree(3), 0);
    	
    	assertEquals("Get the indegree of a vertex that does not exist, should return -1.", graph.indegree(5), -1);
    }
    
    @Test
    public void testOutdegree() 
    {
    	DAG graph;
    	
    	graph = new DAG(5);
    	
    	graph.addEdge(2, 1);
    	assertEquals("Create an edge incident from vertex two. The outdegree of vertex two should be 1.", graph.outdegree(2), 1);
    	
    	graph.addEdge(2, 3);
    	graph.addEdge(2, 4);
    	assertEquals("Add two more edges incident from vertex two. The outdegree of vertex two should be 3.", graph.outdegree(2), 3);
    	
    	assertEquals("The outdegree of vertex 0 with no edges incident from it should be 0.", graph.outdegree(0), 0);
    	
    	assertEquals("Get the outdegree of a vertex that does not exist, should return -1.", graph.indegree(5), -1);
    }
    
    @Test
    public void testFindCycleAndHasCycle() 
    {
    	DAG graph;
    	
    	graph = new DAG(5);
    	
    	graph.addEdge(1, 2);
    	graph.addEdge(2, 3);
    	graph.addEdge(3, 4);
    	graph.addEdge(4, 0);
    	graph.addEdge(0, 1);
    	graph.findCycle(1);
    	assertEquals("Create a graph with a cycle. The result of findCycle() should be true.", graph.hasCycle(), true);
    	
    	graph = new DAG(5);
    	
    	graph.addEdge(1, 2);
    	graph.addEdge(2, 3);
    	graph.addEdge(3, 4);
    	graph.addEdge(4, 0);
    	graph.findCycle(1);
    	assertEquals("Create a graph with no cycle. The result of findCycle() should be false.", graph.hasCycle(), false);
    }
    
    @Test
    public void testFindLCA() 
    {
    	DAG graph;
    	
    	graph = new DAG(10);
    	
    	graph.addEdge(0, 1);			//         0
    	graph.addEdge(0, 2);			//  1      2      3
    	graph.addEdge(0, 3);			//7   8         4   5
    	graph.addEdge(3, 4);			//                   6
    	graph.addEdge(3, 5);
    	graph.addEdge(5, 6);
    	graph.addEdge(1, 7);
    	graph.addEdge(1, 8);
    	
    	assertEquals("The LCA of vertex 1 and vertex 2 is vertex 0.", graph.findLCA(1, 2), 0);
    	assertEquals("The LCA of vertex 1 and vertex 3 is vertex 0.", graph.findLCA(1, 3), 0);
    	assertEquals("The LCA of vertex 7 and vertex 8 is vertex 1.", graph.findLCA(7, 8), 1);
    	assertEquals("The LCA of vertex 4 and vertex 6 is vertex 3.", graph.findLCA(4, 6), 3);
    	assertEquals("The LCA of vertex 4 and vertex 5 is vertex 3.", graph.findLCA(4, 5), 3);
    	assertEquals("The LCA of vertex 8 and vertex 4 is vertex 0.", graph.findLCA(8, 4), 0);
    }
    
}