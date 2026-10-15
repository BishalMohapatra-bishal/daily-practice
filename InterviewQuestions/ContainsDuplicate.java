package InterviewQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public static boolean isDuplicate(int[] nums) {
        // Map<Integer, Integer> map = new HashMap<>();

        // for (int i : nums) {
        //     map.put(i, map.getOrDefault(i, 0) + 1);
        // }
        // // List<Integer> mapValues = new ArrayList<>(map.values());
        
        // for(Integer anyDplicate : map.values()) {
        //     if(anyDplicate > 1) {
        //         return true;
        //     }
        // }
        //     return false; 

        Set<Integer> seen = new HashSet<>();

        for(int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }
}

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 5, 6, 7, 7, 7, 8, 9, 10, 10};

        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        if (Solution.isDuplicate(nums2)) {
            System.out.println("Contains Duplicate");
        } else {
            System.out.println("No duplicate found");
        }
    }
}





 // Integer value;

        // for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     Integer Key = entry.getKey();
        //     value = entry.getValue();

        //     System.out.println("Key: " + Key + " Value: " + value);
        // }

        // for(Integer values : map.values())