/*
    Time Complexity - O(N logN)
    Space Complexity - O(N) where N is the number of the elements in array "nums"
 */
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;

        for(int i = 0; i < nums.length; i+=2)
            result += nums[i];
        
        return result;
    }
}

