# Time Complexity :O(1)
# Space Complexity :O(1) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class PeekingIterator(object):
    def __init__(self, iterator):
        """
        Initialize your data structure here.
        :type iterator: Iterator
        """
        # initialization
        self.iterator = iterator
        self.peeked = None
        

    def peek(self):
        """
        Returns the next element in the iteration without advancing the iterator.
        :rtype: int
        """
        # if there is no peek get next and save it
        if not self.peeked:
            self.peeked = self.iterator.next()
        # return peeked
        return self.peeked
        

    def next(self):
        """
        :rtype: int
        """
        # if there is a peek save it delete peeked then return it
        if self.peeked:
            toret = self.peeked
            self.peeked = None
            return toret
        mynext = self.iterator.next()
        # if no next stop raise and exception
        if not mynext:
            raise StopIteration()
        else:
            return mynext
        

    def hasNext(self):
        """
        :rtype: bool
        """
        # if no peeked or next return false else return true
        if self.peeked or self.iterator.hasNext():
            return True
        return False