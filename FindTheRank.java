import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class FindTheRank {
	public static int findTheRank(int performance[][],int rank) {
		//total score & index stack
		Map<Integer,LinkedList<Integer>> map = new TreeMap<>(Collections.reverseOrder());
		int index = 1;
		for(int[] eachPer : performance) {
				int total = 0;
				for(int score : eachPer)
					total+=score;
				LinkedList<Integer> rankStu = map.getOrDefault(total, new LinkedList<Integer>());
				rankStu.add(index++);
				map.put(total, rankStu);
		}

		int cur = 1;
		int res = cur;
		for(int key : map.keySet()) {
			for(Integer s : map.get(key)) {
				if(cur == rank) {
					res = s;
					return s;
				}
				cur++;
			}
		}
		
		
		return res;
		

		
	}

	public static void main(String[] args) {
		int[][] performance = {{100,100,100},{100,100,100},{99,100,100},{98,100,100},{100,99,100}};
		
		int rank = findTheRank(performance, 4);
		System.out.println(rank);
	}

}
