package exercise1;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class abracadabra {

	public static void main(String[] args) {
		String str="abracadabra";
		HashMap<Character,Integer> freq=new HashMap();
		for (Character c : str.toCharArray()) {  //find frequencies
			freq.put(c, freq.getOrDefault(c, 0)+1);		
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n->n.freq)); 
		for (Map.Entry<Character,Integer> e : freq.entrySet()) {	  //sort frequencies
			pq.add(new Node(e.getKey(), e.getValue(), null, null));		
		}
		while(pq.size()>1){  
			Node n1=pq.poll();
			Node n2=pq.poll();
			int f=n1.freq+n2.freq;
			Node newNode = new Node(null, f, n1, n2);
			pq.add(newNode);
			
		}		
		HashMap<Character,String> h=new HashMap();
		encode(pq.poll(), "", h);	
		for (Map.Entry<Character,String> e : h.entrySet()) {	  
			System.out.println(e.getKey() + " "+e.getValue());		
		}
	}		
	public static void encode(Node currentNode, String str, 
							  HashMap<Character,String> map){
		if(currentNode==null)
			return;
		if(currentNode.left!=null){
			encode(currentNode.left, str+"0", map);
		}
		if(currentNode.right!=null){
			encode(currentNode.right, str+"1", map);	
		}
	    map.put(currentNode.c, str);		
	}
}
class Node{
	Character c;
	int freq;
	Node left,right;

	public Node(Character c, int freq, Node left, Node right) {
		this.left = left;
		this.right = right;
		this.freq = freq;
		this.c = c;
	}
		
}
