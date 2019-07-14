import java.util.Arrays;
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robHouses(Arrays.copyOfRange(nums, 0, nums.length - 1)), robHouses(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    // Recursive solution to House Robber - helper function:
    // https://leetcode.com/problems/house-robber/description/
    public int robHouses(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] mem = new int[nums.length];
        mem[0] = nums[0];
        mem[1] = Math.max(nums[0], nums[1]);
        return robHouses(nums, mem, 2);
    }
    
    public int robHouses(int[] nums, int[] mem, int n) {
        if (n == nums.length) {
            return mem[mem.length - 1];
        } else {
            int max = Math.max(nums[n] + mem[n - 2], mem[n - 1]);
            mem[n] = max;
            return robHouses(nums, mem, n + 1);
        }
    }
    
    // Dynamic programming solution to House Robber:
    // https://leetcode.com/problems/house-robber/description/
    public int robHouses(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] mem = new int[nums.length];
        mem[0] = nums[0];
        mem[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            // Choose current house and house two houses away
            // or previous house
            mem[i] = Math.max(nums[i] + mem[i - 2], mem[i - 1]);
        }
        return mem[nums.length - 1];
    }
}