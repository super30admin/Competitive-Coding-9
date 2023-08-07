// Time Complexity : O(1) for all three methods
// Space Complexity : O(1) no auxiliary space used
// Did this code successfully run on Leetcode :yes
import java.util.Iterator;

public class Problem2 {
    class PeekingIterator implements Iterator<Integer> {
        private Iterator<Integer> it;
        private Integer next;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.it = iterator;
            this.next = iterator.next();

        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            int current = next;
            if(it.hasNext()){
                next = it.next();
            }else{
                next = null;
            }
            return current;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }
    }
}
