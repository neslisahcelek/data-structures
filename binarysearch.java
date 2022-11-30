

//soldaki nodelar küçük or eşit, sağdakiler büyük
//inorder: left root right
//preorder: root left right
public class binarysearch { 
    public static void main(String[] args) {
        bst b = new bst();

        b.insert(20);
        b.insert(18);
        //b.insert(18);
        b.insert(22);
        b.insert(24);
        b.insert(21);
        //b.insert(7);
        //b.insert(16);
        //b.insert(15);
        //b.insert(17);
          
        b.preorder();
        b.delete(18);
        
        b.preorder();
        //System.out.println(b.root.right.getValue());
    

    }   
 }
class bst{
    public static Node root;

    public static void insert(int value){
        root=insert(root,value);
    }
    private static Node insert(Node currNode, int value){
        if(currNode==null){
            currNode=new Node(value);  
            return currNode;     
        }
        if(value<=currNode.getValue()){
            currNode.left = insert(currNode.left,value);
        }
        else{
            currNode.right = insert(currNode.right,value);
        }
        return currNode; 
    }   
    public static void delete(int value){
        if(root!=null)
            delete(root, value);
    }
    /*
     * root null mı
     * değilse 3 iht
     * datadan büyük mü küçük mü, sağ sol dallan
     * eşitse 
     * çocuğu var mı
     * tek çocuksa kendisiyle yer değiştir sil
     * iki çocuksa findmaxtaki nodela değiştir sil
     */
    private static void delete(Node currNode,int data){ 
        if(currNode==null){
            return;
        }
        if(data==currNode.getValue()){
            if(currNode.left != null){
                if(currNode.right!=null){
                    currNode=findMax(currNode.right);
                }
                else
                    currNode=currNode.left;
            }
            else
                currNode=currNode.right;          
        }
        if(data<currNode.getValue()){
            delete(currNode.left, data);
        }
        else
            delete(currNode.right, data);
    }
    public static Node findMax(Node n){
        if(n.left.equals(null)){
            return n;
        }
        findMax(n.left); 
        return n;
    }
    public static void preorder(){
        preorder(root);
    }
    private static void preorder(Node currNode){ 
        if(currNode==null)
            return;
        System.out.println(currNode.getValue()); 
        preorder(currNode.left);
        preorder(currNode.right);
    }
    public static void inorder(){
        inorder(root);
    }
    private static void inorder(Node currNode){ 
        if(currNode==null)
            return;
        inorder(currNode.left);
        System.out.println(currNode.getValue()); 
        inorder(currNode.right);
    }
    public static void postorder(){
       postorder(root);
    }
    private static void postorder(Node currNode){ 
        if(currNode==null)
            return;
        postorder(currNode.left);
        postorder(currNode.right);
        System.out.println(currNode.getValue()); 
    }
}
class Node{
	private int value;
	public Node left, right;

    public Node(int value) {
		this.value=value;
	}	
    public int getValue() {
        return value;
    }
}