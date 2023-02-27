class PeekingIterator implements Iterator<Integer> {
    private Integer top = null;
    private Iterator<Integer> iter;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iter = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (top == null) 
            top = iter.next();
        return top;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = null;
        if (top != null) {
            res = top;
            top = null;
        } else 
            res = iter.next();
        return res;
	}
	
	@Override
	public boolean hasNext() {
	    return iter.hasNext() || top != null;
	}
}
