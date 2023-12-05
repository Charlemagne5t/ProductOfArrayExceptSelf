public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProdLeftToRight = new int[nums.length];
        prefixProdLeftToRight[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            prefixProdLeftToRight[i] = prefixProdLeftToRight[i - 1] * nums[i];
        }
        int[] prefixProdRightToLeft = new int[nums.length];
        prefixProdRightToLeft[prefixProdRightToLeft.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            prefixProdRightToLeft[i] = prefixProdRightToLeft[i + 1] * nums[i];
        }
        int[] result = new int[nums.length];
        result[0] = prefixProdRightToLeft[1];
        result[nums.length - 1] = prefixProdLeftToRight[nums.length - 2];

        for(int i = 1; i < result.length - 1; i++){
            result[i] = prefixProdLeftToRight[i - 1] * prefixProdRightToLeft[i + 1];
        }
        return result;
    }

}
