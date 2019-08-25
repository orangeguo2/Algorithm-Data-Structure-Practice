import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MatrixGame {
	public int matrixGame(int[][] matrix) {
		if(matrix == null || matrix.length == 0) return 0;
		
		int diff = 0;
		int rowlen = matrix.length;
		int collen = matrix[0].length;
		
		//how many cols' max value is this key
		Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
		
		for(int c = 0; c < collen; c++) {
			int colmax = matrix[0][c];
			for(int r = 0; r < rowlen; r++) {
				colmax = Math.max(colmax,matrix[r][c]);
			}
			map.put(colmax, map.getOrDefault(colmax, 0)+1);
		}
		
		boolean diffcancel = true;
		
		for(int key : map.keySet()) {
			int size = map.get(key);
			if(!diffcancel) {
				diff-=key;
				size--;
				diffcancel = true;
			}
			if(size % 2 == 0) continue;
			else {
				diff+=key;
				diffcancel = false;
			}
		}
		
		return diff;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatrixGame test = new MatrixGame();
		int[][] matrix = {{6,1,9,1,8,4,1},
						  {1,5,2,2,4,8,4},
						  {9,3,8,1,7,6,8}};
		int diff = test.matrixGame(matrix);
		System.out.println(diff);
	}

}
