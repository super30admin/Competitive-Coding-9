// Time Complexity : O(1) for peek() and next()
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// get next() and store in peek variable, on peek() return peek, on calling next() return current peek and set peek to iterator.next() 

class PeekingIterator implements Iterator<Integer> {
    Integer peek=null;
    Iterator<Integer> iterator;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    peek = iterator.next();   
        this.iterator = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peek;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer next = peek;
        if(iterator.hasNext()){
            peek = iterator.next();    
        }
        else{
            peek = null;
        }
        
        return next;
	}
	
	@Override
	public boolean hasNext() {
	    return peek!=null;
	}
}