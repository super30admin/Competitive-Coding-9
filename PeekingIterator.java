// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class PeekingIterator implements Iterator<Integer> {
    Integer current;
    Iterator<Integer> iterator; 
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
        if(this.iterator.hasNext()) {
            current = this.iterator.next();
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        
        return current;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer oldCurrent = current;
        
        if(iterator.hasNext()) {
            current = iterator.next();
        } else {
            current = null;
        }
        
        return oldCurrent;
	}
	
	@Override
	public boolean hasNext() {
	    return current != null;
	}
}