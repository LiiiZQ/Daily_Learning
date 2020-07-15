import java.util.HashMap;
import java.util.Map;
// 两数之和
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] data = new int[2];
        /*(n^2-n)/2
        for(int i = 0; i < len-1; i++){
            for(int j = i+1; j < len; j++){
                if(nums[i]+nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;*/
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for(int i = 0; i < len; i++){
            if(hash.containsKey(nums[i])){
                data[0] = i;
                data[1] = hash.get(nums[i]);
                return data;
            }else{
                int index = target - nums[i];
                hash.put(index, i);
            }
        }
        return data;
    }
}
