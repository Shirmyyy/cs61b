package proj1a;


public class LinkedListDeque<LochNess> {
	
	
	private class StuffNode {
		public LochNess item;
		public StuffNode next;
		public StuffNode previous;

		public StuffNode(LochNess i, StuffNode p,StuffNode n) {
			item = i;
			previous = p;
			next = n;
		}
		
		public LochNess getRecursive(int index) {
			if (index==0) {
				return item;
			}else {
				return next.getRecursive(index-1);
			}
		}
	} 
	
	private StuffNode sentinel;
	private int size;
	
	public LinkedListDeque() {
		sentinel = new StuffNode(null, null,null);
		sentinel.next=sentinel;
		sentinel.previous=sentinel;
		size = 0;
	}
	
	public void addFirst(LochNess x) {
		StuffNode s = new StuffNode(x, sentinel, sentinel.next);
		sentinel.next.previous=s;
		sentinel.next=s;
 		size += 1;
 	}
	
	public void addLast(LochNess x) {
		StuffNode s = new StuffNode(x, sentinel.previous, sentinel);
		sentinel.previous.next=s;
		sentinel.previous =s;
 		size += 1;

 	}

	public boolean isEmpty() {
		if (size ==0) {
			return true;
		}
		return false;
	}
	
	public LochNess removeFirst() {
		LochNess s = sentinel.next.item;
		sentinel.next.next.previous=sentinel;
		sentinel.next=sentinel.next.next;
		size -= 1;
		return s;
	}
	
	public LochNess removeLast() {
		LochNess s = sentinel.previous.item;
		sentinel.previous.previous.next=sentinel;
		sentinel.previous=sentinel.previous.previous;
		size -= 1;
		return s;
	}
	
	public LochNess get(int index) {
		int len=0;
		StuffNode current = sentinel;
		while (len<=index) {
			current=current.next;
			len+=1;
		}
		return current.item;
	}
	
	public LochNess getRecursive(int index) {
		return sentinel.getRecursive(index);
	}
	
	public int size() {
		return size;
	}
	
	public void printDeque() {
		StuffNode current = sentinel;
		while (current.next!=sentinel) {
			System.out.println(current.next.item);
			current=current.next;
		}
	}
}
