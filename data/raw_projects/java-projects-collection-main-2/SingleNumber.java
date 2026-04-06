class Solution {
    public int singleNumber(int[] nums) {
        int x[] = new int[nums.length];
        if(nums.length < 2) return nums[0];
        else{
            for(int i=0;i<nums.length;i++){
                int c = 0;
                for(int j=0;j<nums.length;j++){
                    if(nums[i]==nums[j]) c++;
                }
                if(c!=2) x[i] = nums[i];
                else x[i] = 0; 
            }
            for(int i:x){
                if(i!=0) return i;
            }
        }
        return 0;
    }
}