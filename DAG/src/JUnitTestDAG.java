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

}