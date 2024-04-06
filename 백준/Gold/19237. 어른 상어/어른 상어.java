
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


class Position {
	int x = 0;
	int y = 0;
	
	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Smell {
	int number = 0;
	int initTime = 0;
	
	Smell(int number, int initTime) {
		this.number = number;
		this.initTime = initTime;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + number + "," + initTime + ")";
	}
	
}

public class Main {
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String[] input = br.readLine().split(" ");
       
       // n x n 격자
       int n = Integer.parseInt(input[0]);
       // m 개 상어
       int m = Integer.parseInt(input[1]);
       // k 초 후 냄새 사라짐
       int k = Integer.parseInt(input[2]);
       
       // sharkPosition
       Position[] nowSharkP = new Position[m + 1];
       int[] nowSharkDir = new int[m + 1];
       
       // x개의 상어가 y개의 방향으로 4개의 우선순위
       int[][][] prDir = new int[m + 1][4][4];
       Smell[][] board = new Smell[n][n];
       
       
       // 격자, 0이 아닌 수 x는 x번 상어
       for(int x = 0 ; x < n ; x++) {
    	   String[] xs = br.readLine().split(" ");
    	   for(int y = 0 ; y < n ; y++) {
    		   int num = Integer.parseInt(xs[y]);
    		   
    		   if(num != 0) {
    			   board[x][y] = new Smell(num,0);
    			   nowSharkP[num] = new Position(x, y);
    		   }else {
    			   board[x][y] = new Smell(0,0);
    		   }
    	   }
       }
       
       // 1,2,3,4 위,아래,왼쪽,오른쪽
       int[] moveX = {-1,1,0,0};
       int[] moveY = {0,0,-1,1};
       
       
       // 현재 초기 방향
       String[] nowDir = br.readLine().split(" ");
       for(int i = 1 ; i <= nowDir.length ; i++) {
    	   nowSharkDir[i] = Integer.parseInt(nowDir[i - 1]) - 1;
       }
       
       
       // 상어마다 방향 우선순위
       // i번 상어
       for(int i = 1; i <= m; i++) {
    	   // j번 방향에서
    	   for(int j = 0; j < 4 ; j++) {
    		   // 우선순위
    		   String[] pr = br.readLine().split(" ");
    		  
    		   for(int z = 0; z < 4; z++) {
    			   prDir[i][j][z] = Integer.parseInt(pr[z]) - 1; 
    		   }
    	   }
       }
      
       int time = 0;
       outer : while(time <= 1000) {
    	   // 임시 저장 
    	   int[][] tmp = new int[n][n];
    	   time++;
    	   // 1번 샤크부터
    	   for(int num = 1 ; num < nowSharkP.length; num++) {
    		   // 이미 제외 당한거면 넘기기
    		   if(nowSharkP[num] == null) continue;
    		   // 현재 방향
    		   int d = nowSharkDir[num];
    		   Position p = nowSharkP[num];
    		   
    		   // 갈 수 있는 방향저장
    		   ArrayList<Integer> canGo = new ArrayList();
    		   // 냄새가 없는 칸 보기
    		   for(int dir = 0 ; dir < 4 ; dir++) {
    			  int nx = p.x + moveX[dir];
    			  int ny = p.y + moveY[dir];
    			  
    			  if(nx >= 0 && nx < board.length && ny >= 0 && ny < board.length && (board[nx][ny].number == 0 || time - board[nx][ny].initTime > k)) {
    				  canGo.add(dir);
    			  }
    			  
    		   }
    		   // 냄새가 없는칸이 없다면
    		   if(canGo.isEmpty()) {
    			   for(int dir = 0 ; dir < 4 ; dir++) {
    	    			 int nx = p.x + moveX[dir];
    	    			 int ny = p.y + moveY[dir];
    	    			  
    	    			 // 시간이 안지나더라도 같은거면 ㄱㄱ
    	    			 if(nx >= 0 && nx < board.length && ny >= 0 && ny < board.length && board[nx][ny].number == num) canGo.add(dir);
    	    		}
    			   int go = firstPdir(canGo, prDir[num][d]);
    			   // 저장 하자
    			   int nx = p.x + moveX[go];
    			   int ny = p.y + moveY[go];
    			   // 비어있거나 더 작다면
    			   if(tmp[nx][ny] == 0 || tmp[nx][ny] > num) {
    				   int remove = tmp[nx][ny];
    				   tmp[nx][ny] = num;
    				   nowSharkDir[num] = go;
    				   
    				   if(remove != 0) {
    					   nowSharkP[remove] = null;
    				   }
    			   } else {
    				   nowSharkP[num] = null;
    			   }
 
    		   } else { // 냄서없는칸있다면
    			   // 해당 
    			   int go = firstPdir(canGo, prDir[num][d]);

    			   // 저장 하자
    			   int nx = p.x + moveX[go];
    			   int ny = p.y + moveY[go];
    			   // 비어있거나 더 작다면
    			   if(tmp[nx][ny] == 0 || tmp[nx][ny] > num) {
    				   int remove = tmp[nx][ny];
    				   tmp[nx][ny] = num;
    				   nowSharkDir[num] = go;
    				   
    				   if(remove != 0) {
    					   nowSharkP[remove] = null;
    				   }
    			   }else {
    				   nowSharkP[num] = null;
    			   }
    		   }  
    	   }
    	   
    	   for(int x = 0 ; x < n ; x++) {
			   for(int y = 0 ; y < n ; y++) {
				   int newNum = tmp[x][y];
				   if(newNum > 0) {
					   // 냄새 남겨주고
					   board[x][y] = new Smell(newNum, time);
					   nowSharkP[newNum] = new Position(x, y);
				   }
			   }
		   }
	       
    	   
    	  
	       for(int i = 2 ; i <= m ; i++) {
	    	   if(nowSharkP[i] != null) continue outer;
	       }
	       
	       break;
    	   
       }
       
       if(time > 1000) {
    	   System.out.println(-1);
       } else {
    	   System.out.println(time);
       }
      
    }
    
    static int firstPdir(ArrayList<Integer> canGo, int[] pArr) {
    	for(int p : pArr) {
    		if(canGo.contains(p)) {
    			return p;
    		}
    	}
    	
    	return -1;
    }
}


 