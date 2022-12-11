
public class binarysearch { 
    public static void main(String[] args) {
        bst b = new bst();

        b.insert(20);
        b.insert(18);
        b.insert(19);
        b.insert(22);
        b.insert(24);
        b.insert(21);

        b.inorder();
        b.delete(19);
        b.inorder();
    }   
 }
class bst{
    public Node root;

    public void insert(int value){
        root=insert(root,value);
    }
    private Node insert(Node currNode, int value){
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
    public void delete(int value){
        if(root!=null)
            delete(root, value);
        else{
            System.out.println("There is no " + value + " in the tree");
        }
    }
    private Node delete(Node currNode,int data){ 
        if(currNode==null){
            return currNode;
        }
        if(data==currNode.getValue()){
            if(currNode.left == null){
                currNode=currNode.right;
                return currNode;
            }
            if(currNode.right==null){
                currNode=currNode.left;
                return currNode;
            }
            currNode.setValue(findMax(currNode.right));
            currNode.right = delete(currNode.right, currNode.getValue());;                  
            return currNode;
        }
        if(data<currNode.getValue()){
            currNode.left = delete(currNode.left, data);
        }
        else{
            currNode.right = delete(currNode.right, data);
        }
        return currNode;
    }
    public int findMax(Node n){
        if(n.left==null){
            return n.getValue();
        }
        findMax(n.left); 
        return n.getValue();
    }
    public void preorder(){
        preorder(root);
    }
    private void preorder(Node currNode){ 
        if(currNode==null)
            return;
        System.out.println(currNode.getValue()); 
        preorder(currNode.left);
        preorder(currNode.right);
    }
    public void inorder(){
        inorder(root);
    }
    private void inorder(Node currNode){ 
        if(currNode==null)
            return;
        inorder(currNode.left);
        System.out.println(currNode.getValue()); 
        inorder(currNode.right);
    }
    public void postorder(){
       postorder(root);
    }
    private void postorder(Node currNode){ 
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
    public void setValue(int value) {
        this.value = value;
    }
}
