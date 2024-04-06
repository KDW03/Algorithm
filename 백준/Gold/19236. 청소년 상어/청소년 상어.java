import java.io.*;
import java.util.*;


class Fish {
	int num = 0;
	int dir = 0;
	
	public Fish(int num,int dir) {
		this.num = num;
		this.dir = dir;
	}
}

class Point {
	int x = 0;
	int y = 0;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}


class Main {
	
	static int[] moveX = { -1, -1, 0, 1, 1, 1 , 0 , -1}; 
	static int[] moveY = { 0, -1, -1, -1, 0, 1, 1, 1}; 
	static int max = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		Fish[][] fishs = new Fish[4][4];
		Point[] fishPositions = new Point[17]; 
		
		for(int x = 0 ; x < 4 ; x++) {
		
			String[] input = br.readLine().split(" ");
			
			for(int i = 0 ; i < 4 ; i++) {		
				int num = Integer.parseInt(input[i * 2]);
				int dir = Integer.parseInt(input[i * 2 + 1]) - 1;
				fishs[x][i] = new Fish(num,dir);
				fishPositions[num] = new Point(x,i); 
			}
			
		}
		
		// 먼저 처음 상어 놓을 위치 선정
		start(cloneFishs(fishs),fishPositions.clone(),0,0, fishs[0][0].dir, fishs[0][0].num);
		
		
		System.out.println(max);
	}
	
	static Fish[][] cloneFishs(Fish[][] original) {
		Fish[][] clone = new Fish[original.length][];
		for (int i = 0; i < original.length; i++) {
		    clone[i] = original[i].clone(); 
		}
		return clone;
	}
	

	public static void start(Fish[][] fishs, Point[] fishPositions, int x, int y, int d, int score) {
		
		fishPositions[fishs[x][y].num] = null;
		fishs[x][y] = null;
		
		
		// 1번 부터
		for(int i = 1; i < fishPositions.length ; i++) {
			Point p = fishPositions[i];		
			if(p == null) continue;
			
			int nx = p.x;
			int ny = p.y;
			// 자기 방향으로 이동
			int nd = fishs[nx][ny].dir;
			int nNum = fishs[nx][ny].num;
			
			// 방향
			for(int j = 0; j < moveX.length; j++) {
				int newD = (nd + j) % moveX.length;
				
				int gx = nx + moveX[newD]; 
				int gy = ny + moveY[newD];
				// 이 방향으로 갈 수 있다면, 즉 상어가 없거나 유효한 위치라면 break
				
				// 이동할수있다면
				if(gx >= 0 && gx < 4 && gy >= 0 && gy < 4 && (gx != x || gy != y)) {
					nx = gx;
					ny = gy;
					nd = newD;
					break;
				}
			}

			// 해당 물고기 swap
			
			// 이동하는 곳
			Fish a = fishs[nx][ny];
			// 이동하기전
			Fish b = new Fish(nNum,nd);
			
			if(a != null) {
				fishPositions[a.num] = new Point(p.x,p.y);
				fishPositions[b.num] = new Point(nx,ny);
						
				fishs[nx][ny] = b;
				fishs[p.x][p.y] = a;
			} else {
				// a가 null이라면 b만 이동
				fishPositions[b.num] = new Point(nx,ny);
				
				fishs[p.x][p.y] = a;
				fishs[nx][ny] = b;
			}
			
		}
		
		// 상어 움직이기 x,y에서 dir 중 갈 수 있는 곳 하나 선택
		
		boolean endFlag = true;
		for(int i = 1 ; i < 4 ; i++) {
			int nx = x + moveX[d] * i;
			int ny = y + moveY[d] * i;
			
			
			// 갈 수 있다면
			
			// 범위내에 있고
			if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && fishs[nx][ny] != null) {
				// 물고기가 있다면
				endFlag = false;
				start(cloneFishs(fishs),fishPositions.clone(), nx, ny, fishs[nx][ny].dir, score + fishs[nx][ny].num);
			}
		}
	
		if(endFlag) max = Math.max(max, score);
	}

}