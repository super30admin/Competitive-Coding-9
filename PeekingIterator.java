// Time Complexity :O(N)- Constructor O(1) remaining methods. 
// Space Complexity :O(N) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach:Store all the elements of iterator in the queue and then utilise the queue 
// functions to get the desired results.
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Queue<Integer> queue = new LinkedList<>();
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        while(iterator.hasNext())
        queue.add(iterator.next());       
	    
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return queue.peek();
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return queue.poll();
	}
	
	@Override
	public boolean hasNext() {
	    return queue.size()!=0;
	}
}