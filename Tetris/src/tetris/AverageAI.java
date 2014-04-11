package tetris;

public class AverageAI{
	
	TetrisController tc;
        

	AverageAI(int width, int height) {
		tc = new TetrisController();
	}
        
       
	void tick(int verb) {
		tc.tick(verb);
		
		if (!tc.gameOn) {
			stopGame();
		}
                
	}

	public void startGame() {
		tc.startGame();
		
		while(tc.gameOn){
			tick(TetrisController.DOWN);
		}
		
	}
	
	public void stopGame() {
		tc.gameOn = false;
	}


	public static void main(String[] args)
	
	{
		
		int total = 0;
		int count = 0;
		int max = 0;
		int min = 0;
		
		while(true){
			
			final AverageAI tetris = new AIAverager(TetrisController.WIDTH*22, (TetrisController.HEIGHT+TetrisController.TOP_SPACE)*22);	
	        
			tetris.startGame();

			int rows = tetris.tc.rowsCleared;
			total += rows;
			count ++;
			max = rows > max ? rows : max;
			min = rows < min || min == 0 ? rows : min;
			System.out.println("Iterations: " + count);
			System.out.println("score: " + tetris.tc.rowsCleared);
			System.out.println("Maximum: " + max);
			System.out.println("Minimum: " + min);
			System.out.println("");
			System.out.println("Average: " + total/count);
			System.out.println("-----------------------");

			
		}
                        
	}
        
}

	