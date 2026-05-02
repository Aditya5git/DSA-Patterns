//Problem-Leetcode
//LC-77
//Difficulty-Medium

//Intution-first map the digits with their respective letters (for eg 2-->abc)
//using map now pick the digit from given string and for currentdigit create a combination of letters associated with currentdigit and the digit next to current digit,using recursion 
/*             {}
            /  |  \  
           a   b   c  picked from level 1 (first recurison call)digit 1
         /|\ 
        d e f 
       / / /
     ad ae af 
 */

//Approach-Use Backtracking for picking and not picking 

//Time:O(n*4^n)
//Space:O(N);

//code-
import java.util.*;
class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer,String> m = new HashMap<>();
        m.put(2,"abc");
        m.put(3,"def");
        m.put(4,"ghi");
        m.put(5,"jkl");
        m.put(6,"mno");
        m.put(7,"pqrs");
        m.put(8,"tuv");
        m.put(9,"wxyz");
        List<String> ans = new ArrayList<>();
        StringBuilder currStr = new StringBuilder("");
        return recursion(digits ,m ,currStr,ans,0);
        
        
    }
    List<String> recursion(String digits , Map<Integer,String> m , StringBuilder currStr , List<String> ans,int st)
    {  
        //Base case
        if(currStr.length()==digits.length())
        {
            ans.add(currStr.toString());
            return ans;
        }

        //Recursive Case
            int c = digits.charAt(st)-'0';
            String s = m.get(c);
            for(int j = 0 ; j<s.length();j++)
            {
                currStr.append(s.charAt(j));
                ans =recursion(digits ,m ,currStr,ans,st+1);
                currStr.deleteCharAt(currStr.length()-1);
            }
                return ans;
    }
}