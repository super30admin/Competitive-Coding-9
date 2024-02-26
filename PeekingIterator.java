// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer pickedElement;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.iterator=iterator;
        pickedElement=null;    
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(pickedElement==null && iterator.hasNext()){
            pickedElement=iterator.next();
        }
        return pickedElement;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(pickedElement!=null){
            Integer next=pickedElement;
            pickedElement=null;
            return next;
        }
        return iterator.next();
	}
	
	@Override
	public boolean hasNext() {
	    return pickedElement!=null || iterator.hasNext();
	}
}