package String;
/**
 * @Longest_substring_without_repeating_character
 * @set @Two_Pointers @A_and_B
 */
import java.util.*;
public class LongestSubstringWithoutRepeatingCharacter {
	//Method
	public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        
        int a = 0, b = 0, max = Integer.MIN_VALUE;

        //Using set for string distinct characters
        HashSet<Character> set = new HashSet<Character>();
        
        while(b<s.length()){
            if(set.contains(s.charAt(b)) == false){
                set.add(s.charAt(b));
                b++;
                max = Math.max(max, set.size());
            }
            else{
            	set.remove(s.charAt(a));
            	a++;
            }
        }
        
        return max;
    }
	
	//Driver Code
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("geeksforgeeks")); 
		//output: 7 
		//substring: "eksforg"
	}

}
