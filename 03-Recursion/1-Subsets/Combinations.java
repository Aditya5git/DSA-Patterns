//Problem-Leetcode
//LC-77
//Difficulty-Medium

//Intution-At every step (or index of arr) store the element keeping in mind that size should not exceed k and the element added is added next to the previous one

//Approach-Use Backtracking for picking and not picking 

//Time:O(3^n);
//Space:O(3^N*N + N);


//code:
import java.util.*;
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int arr[] = new int[n];
        List<Integer> currSubset = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i<n ; i++)
        {
           arr[i] = i+1;
        }
        return Recursion(arr,k,currSubset,ans,0);
        
    }


    public List<List<Integer>> Recursion(int arr[], int k,List<Integer> currSubset,List<List<Integer>> ans , int start)
    {
        if(k==0)
        {
            ans.add(new ArrayList<>(currSubset));
            return ans;
        }
        for(int i = start ; i<arr.length ; i++)
        {
            currSubset.add(arr[i]);
            Recursion(arr,k-1,currSubset,ans,i+1);  
            currSubset.remove(currSubset.size()-1);
        }
        return ans;
    }
}