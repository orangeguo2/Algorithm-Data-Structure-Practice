
public class GridGame {
	
	static int[] dr = {-1,-1,-1,0,0,1,1,1};
	static int[] dc = {-1,0,1,-1,1,-1,0,1};
	
	public static int[][] gridGame(int[][] grid, int k, String[] rules){
		if(grid == null || grid.length == 0) return grid;
		
		int rowlen = grid.length;
		int collen = grid[0].length;
		
		for(int game = 0; game < k; game++) {
			for(int i = 0; i < rowlen; i++) {
				for(int j = 0; j < collen; j++) {
					int liveNor = 0;
					for(int d = 0; d < dr.length; d++) {
						int nrow = i + dr[d];
						int ncol = j + dc[d];
						if(nrow >= 0 
						&& nrow <  rowlen
						&& ncol >=0
						&& ncol < collen) {
							if(Math.abs(grid[nrow][ncol]) == 1) {
								liveNor++;
							}//end if
						}//end if in range
						
					}//end dir
					int res = rules[liveNor] == "alive"? 1:0;
					if(grid[i][j]!=res) //if change
							grid[i][j] = grid[i][j] == 1? -1 : 2;
				}
			
			}// end every cell update
			
			for(int i = 0; i < rowlen; i++) {
				for(int j = 0; j < collen; j++) {
					if(grid[i][j] == -1)
						grid[i][j] = 0;
					if(grid[i][j] == 2)
						grid[i][j] = 1;
				}
			}
			
		}
		
		
		return grid;
	}

	public static void main(String[] args) {
		String[] rule = {"alive","dead","dead","dead","dead","dead","dead","dead","dead"};
		int[][] grid = {{1,1,1},
						{0,0,1},
						{0,0,1}};
		int[][] res = gridGame(grid,3,rule);
		for(int[] r: res) {
			for(int e : r)
				System.out.print(e+ " ");
			System.out.println(" ");
		}

	}

}
