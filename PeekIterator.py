# Below is the interface for Iterator, which is already defined for you.
#
# class Iterator:
#     def __init__(self, nums):
#         """
#         Initializes an iterator object to the beginning of a list.
#         :type nums: List[int]
#         """
#
#     def hasNext(self):
#         """
#         Returns true if the iteration has more elements.
#         :rtype: bool
#         """
#
#     def next(self):
#         """
#         Returns the next element in the iteration.
#         :rtype: int
#         """

class PeekingIterator:
    # Time, Space Complexity: O(1), O(1)
    def __init__(self, iterator):
        """
        Initialize your data structure here.
        :type iterator: Iterator
        """
        self.nums = iterator
        #self.c = 0
        self.queue = None

    def peek(self):
        """
        Returns the next element in the iteration without advancing the iterator.
        :rtype: int
        """
        if(self.queue!=None):
            return self.queue
        if(self.nums.hasNext()):
            x = self.nums.next()
            self.queue = x
            return x

    def next(self):
        """
        :rtype: int
        """
        if(self.queue!=None):
            x = self.queue
            self.queue = None
            return x
        if(self.nums.hasNext()):
            x = self.nums.next()
            return x
        

    def hasNext(self):
        """
        :rtype: bool
        """
        if(self.queue!=None or self.nums.hasNext()):
            return True
        else:
            return False
        

# Your PeekingIterator object will be instantiated and called as such:
# iter = PeekingIterator(Iterator(nums))
# while iter.hasNext():
#     val = iter.peek()   # Get the next element but not advance the iterator.
#     iter.next()         # Should return the same value as [val].
