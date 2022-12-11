package dSLab;

import java.util.Stack;

public class DSLab02_linkedlists {

	public static void main(String[] args) {
		/*
		 * class=objenin prototype�
		 * genericle kullan�l�r 
		 * type safety
		 * node = previous + value + next > double ll olmasayd� previous olmazd�
		 * next: bir sonraki nodeun referans�n� tutar
		 * recursive = signature + base case + call
		 * void methodda return kullanabiliriz ama yan�na bir �ey gelmez.methodu bitirir.
		 */
		LinkedList<Integer> myList = new LinkedList<Integer>();		
		myList.addFirst(1);
		myList.addLast(2); 
		myList.addLast(3);
		myList.addLast(5);
	
		myList.insertAfter(0, 8);
		myList.print();		
	}
}
class Node <E>{
	private E value;
	private Node<E> next, previous;
	
	public Node(E value) {
		this.value=value;
	}
	public E getValue() {return value;}
	public void setValue(E value) {this.value = value;}
	public Node<E> getNext() {return next;}
	public void setNext(Node<E> next) {this.next = next;}
	public Node<E> getPrevious() {return previous;}
	public void setPrevious(Node<E> previous) {this.previous = previous;}
}
class LinkedList<E>{
	private Node<E> head, tail;  //nodelardan linked list olu�turduk
	
	public boolean isEmpty() {
		if(this.head==null)
			return true;
		return false;
	}
	public static void reversePrintRecursive(Node llist) {
        if (llist == null)
            return;
		reversePrintRecursive(llist.getNext());
        System.out.println(llist.getValue());                
    }
	public void reversePrint(Node<E> llist) {
        Stack<E> s=new Stack<>();
        Node<E> n =llist;
        if(llist!= null){
            while(llist.getNext()!=null){
                s.push(n.getValue());
            }
        }
        for(int i=0;i<s.size();i++){
            System.out.println(s.pop());
        }
        
    }
	static boolean compareLists(Node head1, Node head2) {
        Node n1=head1;
        Node n2=head2;
        if(head1.getValue()!=head2.getValue())
            return false;
        else{
            while(n1.getNext()!=null && n2.getNext()!=null){
                if(n1.getNext().getValue()==n2.getNext().getValue()){
                    n1=n1.getNext();
                    n2=n2.getNext(); 
                    return true;
                } 
                else{
                   return false; 
                }                  
            }
        }
        return false;    
    }
	public Node<E> deleteNode(Node<E> head, int position) {
		int count=0;
		Node n=head; 
		while(head.getNext()!=null){
			if(position==0){
				return null;
			}
			if(count==position-1){
				n.setNext(n.getNext().getNext());
				return head;
			}
			n=n.getNext();   
			count++;
		}
		 while(n.getNext()!=null){
			 System.out.println(n);
			 n=n.getNext();   
		 }
		return head;
	}
	public void addLast(E value) {
		Node <E> newNode = new Node(value);
		if(this.isEmpty()) {
			this.head=newNode;
		}else {
			this.tail.setNext(newNode);
			newNode.setPrevious(tail);
		}
		this.tail=newNode;		
	}
	public void addFirst(E value) {
		Node <E> newNode = new Node(value);
		if(this.isEmpty()) {
			this.tail=newNode;
		}else {
			this.head.setPrevious(newNode);
			newNode.setNext(head);
		}
		this.head=newNode;	
	}
	public Node<E> getNode(int index) { //sayi fazlaysa taildan başla yoksa headden -- böyle optimize edilebilir
		if(index<0 || this.isEmpty()) {
			return null;
		}
		int count=0;
		Node<E> currentNode = head;
		while(currentNode!=null) {  //tailden ba�lay�p 0a kadar da gidebilir
			if(count==index) {
				return currentNode;
			}
			count++;
			currentNode=currentNode.getNext();
		}
		return null;
	}
	public void insertAfter(int index, E value) { //dizi bo�sa, ilk elemansa,son elemansa ,,temp kullan				
		Node<E> prevNode = this.getNode(index);
		if(prevNode==null) {
			throw new IllegalArgumentException();
		}
		Node<E> newNode = new Node(value);
		newNode.setNext(prevNode.getNext());
		prevNode.setNext(newNode);		
		newNode.setPrevious(prevNode);		
		if(newNode.getNext()!=null) {
			newNode.getNext().setPrevious(newNode);
		}else { //son elemansa direkt addlastı çağırabiliriz
			tail=newNode;
		}
	}	
	private void print(Node<E> node) { //public yaparsak parametreyi belirlemek zor olabilir
		if(node==null) {
			return;
		}
		System.out.println(node.getValue());
		print(node.getNext());
	}
  //override
	public void print() {
		this.print(this.head);
	}
	
	private void printReverse(Node<E> node) { 
		if(node==null) {
			return;
		}
		System.out.println(node.getValue());
		printReverse(node.getPrevious());
	}
	public void printReverse() {
		this.printReverse(this.tail);
	}



}