class Test 
{
    public static void main(String[] args) 
	{ 
        BST tree = new BST(); 
        
        tree.root = new Node(1);                      //              1
                                                      //           |     |
		tree.root.left = new Node(2);                 //        2           3
        tree.root.right = new Node(3);                //       | |         | |
                                                      //     4     5     6     7
        tree.root.left.left = new Node(4);            //                        |
        tree.root.left.right = new Node(5);           //                         8
                                                      //                       |   |
        tree.root.right.left = new Node(6);           //                      9     10
        tree.root.right.right = new Node(7);

        tree.root.right.right.right = new Node(8);

        tree.root.right.right.right.left = new Node(9);
        tree.root.right.right.right.right = new Node(10);
		

        System.out.println("LCA(4, 5): " + tree.findLCA(4,5)); // answer is obviously 2
        System.out.println("LCA(5, 6): " + tree.findLCA(5,6)); // answer is obviously 1
        System.out.println("LCA(6, 8): " + tree.findLCA(6,8)); // answer is obviously 3
        System.out.println("LCA(10, 6): " + tree.findLCA(10,6)); // answer is obviously 3
	
	} 
}