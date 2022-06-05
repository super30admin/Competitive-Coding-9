// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer val;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
        if(this.iterator.hasNext()){
            val = this.iterator.next();
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return val;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer oldVal = val;
        if(iterator.hasNext()){
            val = this.iterator.next();
        }
        else{
            val = null;
        }
        return oldVal;
	}
	
	@Override
	public boolean hasNext() {
	    return (val != null);
	}
}

//time complexity O(1)
//space complexity O(n) where n is space use by iterator.