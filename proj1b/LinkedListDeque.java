public class LinkedListDeque<Item> implements Deque<Item>{
	
	private class StuffNode {
		public Item item;
		public StuffNode next;
		public StuffNode previous;

		public StuffNode(Item i, StuffNode p,StuffNode n) {
			item = i;
			previous = p;
			next = n;
		}
		
		public Item getRecursive(int index) {
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
	
	@Override
	public void addFirst(Item x) {
		StuffNode s = new StuffNode(x, sentinel, sentinel.next);
		sentinel.next.previous=s;
		sentinel.next=s;
 		size += 1;
 	}
	
	@Override
	public void addLast(Item x) {
		StuffNode s = new StuffNode(x, sentinel.previous, sentinel);
		sentinel.previous.next=s;
		sentinel.previous =s;
 		size += 1;

 	}

	@Override
	public boolean isEmpty() {
		if (size ==0) {
			return true;
		}
		return false;
	}
	
	@Override
	public Item removeFirst() {
		if (size==0) {
			return null;
		}
		Item s = sentinel.next.item;
		sentinel.next.next.previous=sentinel;
		sentinel.next=sentinel.next.next;
		if (size!=0) {
			size -= 1;
		}
		return s;
	}
	
	@Override
	public Item removeLast() {
		if (size==0) {
			return null;
		}
		Item s = sentinel.previous.item;
		sentinel.previous.previous.next=sentinel;
		sentinel.previous=sentinel.previous.previous;
		if (size!=0) {
			size -= 1;
		}
		return s;
	}
	
	@Override
	public Item get(int index) {
		int len=0;
		StuffNode current = sentinel;
		while (len<=index) {
			current=current.next;
			len+=1;
		}
		return current.item;
	}
	
	
	public Item getRecursive(int index) {
		return sentinel.next.getRecursive(index);
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public void printDeque() {
		StuffNode current = sentinel;
		while (current.next!=sentinel) {
			System.out.println(current.next.item);
			current=current.next;
		}
	}
}
