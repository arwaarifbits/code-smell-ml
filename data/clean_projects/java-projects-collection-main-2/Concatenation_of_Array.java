class Solution {
    public int[] getConcatenation(int[] nums) {
        int x[] = new int[nums.length*2];
        for(int i=0;i<nums.length;i++){
            x[i] = nums[i];
            x[i+nums.length] = nums[i];
        }
        return x;
    }
}

    