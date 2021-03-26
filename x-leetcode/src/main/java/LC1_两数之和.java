import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9 输出：[0,1] 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6 输出：[1,2] 示例 3：
 *
 * 输入：nums = [3,3], target = 6 输出：[0,1]  
 *
 * 提示：
 *
 * 2 <= nums.length <= 103 -109 <= nums[i] <= 109 -109 <= target <= 109 只会存在一个有效答案
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Yuqiu.He
 * @date 2021/3/26
 */
public class LC1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            // 这里把轮询求和 改为 去找某个值会不会好一点？
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    // 利用hash表，可以O(n)的查找复杂度降低至O(1)
    public int[] twoSum_optimize(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashtable.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target - nums[i]) && hashtable.get(target - nums[i]) != i) {
                return new int[] {i, hashtable.get(target - nums[i])};
            }
        }
        return null;
    }
}
