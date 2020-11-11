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
public class JUnitTestingBST {
    
    @Test
    public void testEmpty() {
    	
    	BST tree = new BST();
    	
    	assertEquals("Calculate LCA of 2 and 3 in an empty tree:", -1, tree.findLCA(2, 3));
    	assertEquals("Calculate LCA of 0 and 0 in an empty tree:", -1, tree.findLCA(0, 0));
    	
    }

    @Test
    public void testStandardBST() {

        BST tree = new BST();

        tree.root = new Node(1); 					// 1
                                 				   // | |
        tree.root.left = new Node(2);             //  2 3
        tree.root.right = new Node(3);           // | | | |
                                                //  4 5 6 7
        tree.root.left.left = new Node(4);     //        |
        tree.root.left.right = new Node(5);   //         8
                                             //         | |
        tree.root.right.left = new Node(6); //          9 10
        tree.root.right.right = new Node(7);

        tree.root.right.right.right = new Node(8);

        tree.root.right.right.right.left = new Node(9);
        tree.root.right.right.right.right = new Node(10);

        assertEquals("Calculate the LCA of 4 and 5:", 2, tree.findLCA(4, 5));
        assertEquals("Calculate the LCA of 4 and 10:", 1, tree.findLCA(4, 10));
        assertEquals("Calculate the LCA of 7 and 9:", 7, tree.findLCA(7, 9));
        assertEquals("Calculate the LCA of 5 and 8:", 1, tree.findLCA(5, 8));

    }
    
    @Test public void testSingleNode() {
    	
    	BST tree = new BST();
    	
    	tree.root = new Node(1);
    	
    	assertEquals("Calculate the LCA of 1 and 2", -1, tree.findLCA(1, 2));
    	assertEquals("Calculate the LCA of 1 and 1", 1, tree.findLCA(1, 1));
    	
    }

}