/*
287. Find the Duplicate Number
Medium

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3

Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.


Follow up:

How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?
 */


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 2, 2};
        int expected1 = 2;
        int result1 = findDuplicate(nums1);
        System.out.println("Test Case 1 - Input: " + Arrays.toString(nums1));
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        int[] nums2 = {3, 1, 3, 4, 2};
        int expected2 = 3;
        int result2 = findDuplicate(nums2);
        System.out.println("Test Case 2 - Input: " + Arrays.toString(nums2));
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));
    }


    /**
     * Marking visited value within the array
     * Since all values of the array are between [1 - n] and the array size is n+1, while
     * scanning the array from left to right, we set the nums[n] to its negative value.
     * With extra O(1) space, with modifying the input.
     * Time Complexity: O(n).
     * Space Complexity: O(n).
     */
    public static int findDuplicate(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index] < 0) {
                return index;
            }
            nums[index] = -nums[index];
        }
        return length;
    }

    /**
     * Using a HashSet to record the occurrence of each number .With extra O(n)  space, without
     * modifying the input.
     * Time Complexity: O(n).
     * Space Complexity: O(n).
     */
    public static int findDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }

        return len;
    }

    /**
     * Count the frequency of the num in the array.With extra O(n)  space, without modifying the input.
     * Time Complexity: O(n).
     * Space Complexity: O(n).
     */
    public static int findDuplicate3(int[] nums) {
        int len = nums.length;
        int[] cnt = new int[len + 1];
        for (int i = 0; i < len; i++) {
            cnt[nums[i]]++;
            if (cnt[nums[i]] > 1) {
                return nums[i];
            }
        }

        return len;
    }


    /**
     * Sorting the array first, then use a loop from 111 to n With extra O(nlogn) space, modifying the input.
     * Time Complexity: O(nlogn).
     * Space Complexity: O(n2).
     */
    public static int findDuplicate4(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }

        return len;
    }

    /**
     * Brute Force (2 Loops)
     * Since solve the problem without modifying the array nums and uses only constant extra space, we can use Brute
     * Force to solve it.
     * It's easy to use 2 loops to do it, but the time complexity is O(n2), so it wouldn't accepted as timeout.
     * Time Complexity: O(n2).
     * Space Complexity: O(1)
     */
    public static int findDuplicate5(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }

        return len;
    }
}





