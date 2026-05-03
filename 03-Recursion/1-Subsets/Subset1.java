//Problem-Leetcode
//LC-78
//Difficulty-Medium

//Intution-this question doesnt require base case as you have to add all the subset unlike in combinations question where the size of subset is fixed here is no fixed sixe , so a subset can contain 1 element as well as 3 element so you have to add to the ans all the time without considering base case

//Approach-Use Backtracking for picking and not picking 

//Note-subtle difference between this ans combinations problem 

//Time:O(n+2^n);
//Space:O(2^N+ N);

//code-
import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currSeq = new ArrayList<>();
        return recursion(ans,currSeq,nums,0);
    }

    List<List<Integer>> recursion(List<List<Integer>> ans,List<Integer> currSeq,int[] nums , int st)
    {
        ans.add(new ArrayList<>(currSeq));
        //Recursive Case
        for(int i = st ; i<nums.length ; i++)
        {
            currSeq.add(nums[i]);
            ans = recursion(ans,currSeq,nums,i+1);
            currSeq.remove(currSeq.size()-1);
        }
        return ans;
            
        }
    
}