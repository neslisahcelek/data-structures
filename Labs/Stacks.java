package dSLab;
public interface Stacks<E> {
	void push(E entity);
	public E pop();
	public E top();
	public Boolean isEmpty();
	public int size();
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
	class LinkedStack<E> implements Stacks<E>{
		Node<E> n;

		@Override
		public void push(E entity) {
			if(this.top()==null) {
				top=n;
			}
			n.next=top();
		}

		@Override
		public E pop() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public E top() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean isEmpty() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	class ArrayStack<E> implements Stacks<E>{
		private E[] data;
		private int index=0;
		
		ArrayStack(){
			data=(E[])new Object[1000]; ///cast ettik
		}
		public static void main(String[] args) {
			ArrayStack<Integer> arr=new ArrayStack<Integer>();
			/*
			 * arr.push(1);
			 * 	arr.push(3);
			arr.push(2);
			System.out.println(arr.isEmpty());
			arr.push(4);
			 */
		
			
			//System.out.println(arr.size());
			//arr.top().toString();
	
		}

		public void push(E entity) {
			this.data[index]=entity;
			index=index+1;
		}


		@Override
		public Boolean isEmpty() {
			if(this.index==0){
				return true;
			}
			return false;
		}

		@Override
		public int size() {
			return index;
		}


		@Override
		public E pop() {
			this.index--;
			return data[index];
		}


		@Override
		public E top() {
			return data[index];
		}

	}

	
}
