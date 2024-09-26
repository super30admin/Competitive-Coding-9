class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hashmap = dict()
        for i in s:
            if i not in hashmap:
                hashmap[i]=0
            hashmap[i]+=1
        ans = ""
        for i in order:
            if(i in hashmap):
                for _ in range(hashmap[i]):
                    ans+=i
                hashmap.pop(i)
        for i in hashmap:
            for j in range(hashmap[i]):
                ans+=i
        return ans
        
#         st = set([i for i in order])
        
#         rest = ""
#         m = dict()
#         for i in s:
#             if i in st:
#                 if i not in m:
#                     m[i] = 0
#                 m[i]+=1
#             else:
#                 rest+=i
#         for i in order[::-1]:
#             if(i in m):
#                 for _ in range(m[i]):
#                     rest = i+rest
#         return rest
        