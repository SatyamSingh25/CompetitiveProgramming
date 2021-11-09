package bitManipulation;
/**
 * @Bit_Manipulation
 * @Hash_Table
 * @String
 * @Leetcode_1178
 */
import java.util.*;
public class NumberOfValidWordForEachPuzzle {
	
	private static ArrayList<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
		ArrayList<Integer> res = new ArrayList<>();
		HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
		for(int i=0; i<26; i++) {
			map.put((char)('a'+i), new ArrayList<Integer>());
		}
		//Making mask for each word
		for(String word: words) {
			int mask = 0;
			for(char ch: word.toCharArray()) {
				int bit = (int)ch-'a';
				mask = mask |(1<<bit);
			}
			HashSet<Character> unique = new HashSet<>();
			for(char ch: word.toCharArray()) {
				if(unique.contains(ch))
					continue;
				unique.add(ch);
				map.get(ch).add(mask);
			}
		}
		//compareing with each mask of word to puzzle mask
		for(String puzzle: puzzles) {
			int puzzleMask = 1;
			for(char ch: puzzle.toCharArray()) {
				int bit = (int)ch-'a';
				puzzleMask = puzzleMask | (1 << bit);
			}
			int count = 0;
			for(int wordMask: map.get(puzzle.charAt(0))) {
				if((wordMask & puzzleMask)==wordMask) {
					count++;
				}
			}
			res.add(count);
		}
		return res;
	}
	public static void main(String[] args) {
		String[] words = new String[] {"aaaa","asas","able","ability","actt","actor","access"};
		String[] puzzles = new String[] {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
		ArrayList<Integer> res = findNumOfValidWords(words, puzzles);
		System.out.println(res);
	}

	

}
