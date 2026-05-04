//Problem-Leetcode
//LC-90
//Difficulty-Medium

//Intution-Look this question is little bit different because you have to generate subset(power set) of array which is containing duplicates , so [1,2,3,2] so first sort it so that it becomes [1,2,2,3] now you have to understand somethings 
/*
first-->st-->represents level(level means recursion level)
second-->if(i==st)-->it means we are on this level first time here i represents the element of array
third-->if (i>st) means we are on this level not the first time we have now deleted something which we have added on the previous level after backtracking we have come to this to add element which comes after the deleted element now at this point we will check if the deleted element  
is equal to the element we are now going to add if it is that means we will have 2 same subset on the same level which is wrong so we will continue it and the element wont be added to our answer list;
 */

/* 
Level 0 (start = 0)
[]

 ├── pick 1 → [1]
 │     (start = 1)
 │
 │     ├── pick 2 → [1,2]
 │     │     (start = 2)
 │     │
 │     │     ├── pick 2 → [1,2,2] ✅
 │     │     └── done
 │     │
 │     └── skip second 2 ❌ (duplicate at same level)
 │
 ├── pick 2 → [2]
 │     (start = 2)
 │
 │     ├── pick 2 → [2,2] ✅
 │     └── done
 │
 └── skip second 2 ❌ (duplicate at same level) */

//Approach-Use Backtracking for picking and not picking 

//Time:O(n*2^n);
//Space:O(n*2^n);

//code-
import java.util.*;
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currRow = new ArrayList<>();
        Arrays.sort(nums);
        return Recursion(ans,currRow,nums,0);

        
    }
        List<List<Integer>> Recursion(List<List<Integer>> ans , List<Integer> currRow , int nums[] , int st)
        {
            ans.add(new ArrayList<>(currRow));


            for(int i = st ; i<nums.length ; i++)
            {
                if(i>st && nums[i]==nums[i-1])
                {
                    continue;
                }
                currRow.add(nums[i]);
                Recursion(ans,currRow,nums,i+1);
                currRow.remove(currRow.size()-1);
            }

            return ans;
        }

}