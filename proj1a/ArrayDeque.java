public class ArrayDeque<Item> {
	private Item[] items;
    private int size;
    private int front=3;
    private int end=2;

    /** Creates an empty list. */
    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        
        if (front>end) {
        	System.arraycopy(items, front, a, a.length-(items.length-front), items.length-front);
            System.arraycopy(items, 0, a, 0, end+1);
            front=a.length-(items.length-front);
        }else {
        	System.arraycopy(items, front, a, 0, size);
        	front=0;
        	end=size-1;
        }
        
        items = a;
    }
    
    public void addFirst(Item x) {
    	if (size == items.length) {
            resize(size*2);
        }
    	size++;
    	front-=1;
    	if (front<0) {
        	front=items.length-1;
        }
    	items[front] = x;
    }

    /** Inserts X into the back of the list. */
    public void addLast(Item x) {
    	
        if (size == items.length) {
            resize(size*2);
        }
        size++;
        end+=1;
        if (end==items.length) {
        	end=0;
        }
    	items[end] = x;
    	
    }

    public boolean isEmpty() {
    	return size==0;
    }
    
    /** Returns the item from the back of the list. */
    private Item getLast() {
        return items[end];
    }
    
    private Item getFirst() {
        return items[front];
    }
    
    public Item removeFirst() {
    	if (size==0) {
    		return null;
    	}
    	
    	Item x = getFirst();
        items[front] = null;
        front+=1;
        
        if (front==items.length) {
        	front=0;
        }
		size -= 1;
        if (items.length>8 & size<=items.length*0.2) {
        	resize((int) (items.length*0.2+1));
        }
        return x;
    }
    
    /** Deletes item from back of the list and
     * returns deleted item. */
   public Item removeLast() {
	   if (size==0) {
	   		return null;
	   	}
       Item x = getLast();
       items[end] = null;
       end-=1;
      
       if (end<0) {
       	end=items.length-1;
       }
       size -= 1;       
       if (items.length>8 & size<=items.length*0.2) {
          	resize((int) (items.length*0.2+1));
          }
       
       return x;
   }
   
    
    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i) {
    	if (front+i>=items.length) {
    		return items[front+i-items.length];
    	}
        return items[front+i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    public void printDeque() {
    	for (Item i : items) {
    		System.out.println(i);
    	}
    }
    
    /*public static void main(String[] args) {
    	ArrayDeque a = new ArrayDeque();
    	a.addFirst(1);
    	a.addFirst(0);
    	a.addLast(2);
    	a.addLast(3);
    	a.addLast(4);
    	a.addLast(5);
    	a.addLast(6);
    	a.addLast(7);
    	a.addLast(8);
    	a.removeLast();
    	a.removeFirst();
    	System.out.println("size"+a.size);
        System.out.println("front"+a.front);
        System.out.println("end"+a.end);
    	for (Object i : a.items) {
    		System.out.println(i);
    	}
    }*/
}
