package Project_class;

class Node{
	   int value;
	   Node left, right;
	   
	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}

	class BinarySearchTree{
		Node root;
	  
		 /**
		    * recursive insert method (inserts a node into the tree)
		    * @param value
		    */
	   public void insert(int value){
	      //tree is empty
	      if(root == null){
	         root = new Node(value);
	         return;
	      }else{
	         Node current = root;
	         Node parent = null;
	         
	         while(true){
	            parent = current;
	            
	            if(value < current.value){
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }else{
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }
	           
	         }//closing while
	      
	      }//closing main if-else 
	   }
	   
	   /**
	    * pre-order traversal
	    * Prints the value of every node preorder Root-> left->right
	    * @param root The root node of the tree/subtree
	    */
	   public void preOrderTraversal(Node root){
		 //base case
		   if (root == null) {
			   return;
		   }
		   System.out.print(root.value+ " ");
		   //left recursively
		   preOrderTraversal(root.left);
		 //right recursively
		   preOrderTraversal(root.right);
	   }
	   
	   /**
	    * in-order traversal Left->Root->Right
	    * @param root The root node of the tree/subtree
	    */
	   public void inOrderTraversal(Node root){
		 //base case
		   if (root == null) {
			   return;
		   }
		   //left recursively
		   inOrderTraversal(root.left);
		   //process the root
		   System.out.print(root.value+ " ");
		   //right recursively
		   inOrderTraversal(root.right);
	   }
	   
	   /**
	    * post-order traversal Left->Right->Root
	    * @param root The root node of the tree/subtree
	    */	
	   public void postOrderTraversal(Node root){
		 //base case
		   if (root == null) {
			   return;
		   }
		   //left recursively
		   postOrderTraversal(root.left);
		   //right recursively
		   postOrderTraversal(root.right);
		   //process the root
		   System.out.print(root.value+ " ");
		   
	   }
	   
	   /**
	    * a method to find the node in the tree with a specific value
	    * @param root The root node of the tree/subtree
	    * @param key The value to search for
	    * @return true if found, false otherwise
	    */
	   public boolean find(Node root, int key){
		   //base case
		   if (root==null) {
			   return false;
		   }
		   if (root.value==key) {
			   return true;
		   }
		   else if (key < root.value) {
			   return find(root.left,key);
		   }
		   else {
			   return find(root.right,key);
		   }
		  
	   }
	   
	   /**
	    * a method to find the node in the tree with a smallest key
	    * @param root root The root node of the tree/subtree
	    * @return The minimum value
	    */
	   public int getMin(Node root){
		 //base case
		   if (root==null) {
			   return false;
		   }
		   if (root.value==key) {
			   return true;
		   }
		   else if (key < root.value) {
			   return find(root.left,key);
		   }
		   else {
			   return find(root.right,key);
		   }
	   }
	  
	   /**
		   * a method to find the node in the tree with a largest key
		   * @param root root The root node of the tree/subtree
		   * @return The maximum value
		   */
	   public int getMax(Node root){
      //implement in here
	   }
	   
	   /**
	    * this method will not compile until getMax is implemented
	    * @param rootThe root node of the tree/subtree
	    * @param key 
	    * @return the root
	    */
	   public Node delete(Node root, int key){
	      
	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;  
	   }
	}

/**
 * Test
 */

	public class TreeDemov1{
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert( 24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);
	            
	      System.out.print("in-order :   ");
	      t1.inOrderTraversal(t1.root);
	      System.out.println();
	      
	      System.out.print("Pre-order: ");
	      t1.preOrderTraversal(t1.root);
	      System.out.println();
	        
	      System.out.print("Post-order: ");
	      t1.postOrderTraversal(t1.root);
	      System.out.println();
	        
	      System.out.println("Find 22: " + t1.find(t1.root, 22));
	      System.out.println("Find 100: " + t1.find(t1.root, 100));
	        
	      System.out.println("Min value: " + t1.getMin(t1.root));
	      System.out.println("Max value: " + t1.getMax(t1.root)); 
	   }  
	}



