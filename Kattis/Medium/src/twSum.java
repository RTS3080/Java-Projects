class Solution {

    public int[] twoSum(int[] nums, int target) {
        int i1 = -1;
        int i2 = -2;

        System.out.println(recur(0,0,nums,target));
        return new int [] {i1,i2};
    }
    int[] recur(int a, int b,int[] nums, int target){
        if(a<0 || a>=nums.length || b<0 || b>=nums.length){
            return new int [0];
        }
        if(nums[a] + nums[b] == target){
            return new int [] {a,b};
        }
        int[] a1 = recur(a, b+1,nums,target);
        int[] a2 = recur(a+1, b,nums,target);
        if(a1.length>a2.length){
            return a1;
        }
        return a2;
    }
}