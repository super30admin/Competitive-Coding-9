// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

//Time -O(1)
//space - O(1)
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Queue<Integer> q;
    Integer prev;
    boolean hasPrev;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator= iterator;
        this.q = new LinkedList<>();
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(iterator.hasNext() && hasPrev==false){
            prev = iterator.next();
            hasPrev = true;
        }
        return prev;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(hasPrev) {
            hasPrev = false;
            return prev;
        }
        
        return iterator.next();
	}
	
	@Override
	public boolean hasNext() {
	    if(hasPrev || iterator.hasNext()) return true;
        return false;
	}
}