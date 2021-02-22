// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Queue<Integer> qu;
    //Iterator<Inte>
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        qu=new LinkedList<>();
        while(iterator.hasNext()){
            qu.add(iterator.next());
        }
	    
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return qu.element();
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return qu.remove();
	}
	
	@Override
	public boolean hasNext() {
	    return !qu.isEmpty();
	}
}

//
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it;
    Integer peek;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.it=iterator;
        peek=null;
        //peek();
	    
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(peek==null){
            peek=it.next();
        }
        return peek;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if(peek!=null){
            Integer result=peek;
            // if(it.hasNext()){
            //     peek=it.next();
            // }
            peek=null;
            return result;
        }
        return it.next();
       
	}
	
	@Override
	public boolean hasNext() {
       // System.out.println(it.hasNext());
	    return it.hasNext() || peek!=null;
	}
}
