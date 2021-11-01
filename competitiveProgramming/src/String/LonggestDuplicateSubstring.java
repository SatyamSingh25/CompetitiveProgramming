package String;
import java.util.*;
public class LonggestDuplicateSubstring {
	/**
	 * @Brute_Force
	 * TC: O(n^2)
	 * SC: O(n^2)
	 */
	class Pair{
        int size, count;
        Pair(int i, int j){
            this.size = i;
            this.count = j;
        }
    }
    
    public String longestDupSubstring(String s) {
        String ans = "";
        HashMap<String, Pair> map = new HashMap<>();
        //generating all possible subStirng
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                String curr = s.substring(i, j+1);
                if(map.containsKey(curr)){
                    map.get(curr).count++;
                }
                else{
                    map.put(curr, new Pair(curr.length(), 1));
                }
            }
        }
        for(Map.Entry<String, Pair> itr: map.entrySet()){
        	if(itr.getValue().count > 1) {
        		if(ans.length() < itr.getValue().size) {
        			ans = itr.getKey();
        		}
        	}
        }
        return ans;
    }
    
    /**
     * @Efficent_approach
     */
    public String longestDupSubstring2(String s) {
        int low = 0;
        int high = s.length();
        int prime = (1 << 31) - 1;
        int letterSize = 26;
        String longestDupSub = "";
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            String dupSub = search(s, mid, prime, letterSize);
            if (dupSub == null) {
                high = mid - 1;
            } else {
                if (dupSub.length() > longestDupSub.length())
                    longestDupSub = dupSub;
                low = mid + 1;
            }
        }
        return longestDupSub;
    }

    public String search(String s, int windowSize, int Q, int L) {
        // calculate hash of first window
        long winHash = 0L;
        
        for (long i = 0; i < windowSize; i++)
            winHash = (L * winHash + s.charAt((int)i)) % Q;

        HashMap<Long, List<Integer>> map = new HashMap<Long, List<Integer>>();
        map.put(winHash, new ArrayList<>(Collections.singletonList(0)));

        long E = 1L; // L ^ pattern length mod Q
        for (long i = 1; i < windowSize; i++)
            E = L * E % Q;
        
        for (int i = 1; i <= s.length() - windowSize; i++) {
            // remove first char
            winHash = (winHash - E * s.charAt(i - 1) % Q + Q) % Q;
            // left shift
            winHash = winHash * L % Q;
            // add new last char
            winHash = (winHash + s.charAt(i + windowSize - 1)) % Q;

            // hash collision
            if (map.containsKey(winHash))
                for (int start : map.get(winHash))
                    if (isEqual(s, start, i, windowSize))
                        return s.substring(i, i + windowSize);
            
            map.computeIfAbsent(winHash, k -> new ArrayList<>()).add(i);
        }
        return null;
    }

    public boolean isEqual(String s, int previous, int current, int windowSize) {
        for (var j = 0; j < windowSize; j++)
            if (s.charAt(previous++) != s.charAt(current++))
                return false;
        return true;
    }
    
    public static void main(String[] args) {}

}
