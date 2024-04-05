import java.io.*;
import java.util.*;


class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		boolean[][] blue = new boolean[6][4];
		boolean[][] green = new boolean[6][4];
		
		int answer = 0;
		
		for(int i = 0 ; i < n ; i++) {
			String[] input = br.readLine().split(" ");
			int t = Integer.parseInt(input[0]);
			int x = Integer.parseInt(input[1]);
			int y = Integer.parseInt(input[2]);
			
			
			if(t == 1) {
				// x를 y로
				move(blue, x,x,1);
				// y를 y로
				move(green,y,y,1);
				answer += check(blue);
				answer += check(green);
			} 
			
			if(t == 2) {
				// x를 y로 2개
				move(blue, x,x,2);			
				// y를 y로 y+1
				move(green, y,y + 1,1);
				answer += check(blue);
				answer += check(green);

			}
			
			if(t == 3) {
				// x를 y, y+1
				move(blue,x,x+1,1);
				// y를 y
				move(green,y,y,2);
				answer += check(blue);
				answer += check(green);
			}
		}
		
		System.out.println(answer);
		System.out.println(count(blue) + count(green));
	}
	
	public static int count(boolean[][] arr) {
		int count = 0;
		for(int x = 0 ; x <= 5; x++) {
			for(int y = 0 ; y < 4; y++) {
				if(arr[x][y]) count++;
			}
		}
		return count;
	}
	
	public static void move(boolean[][] arr, int y1, int y2, int height) {
		
		int h = height - 1;
		// 위에서부터
		for(int x = 2; x <= 6; x++) {
			// 놓을 수 없다면 해당위치 한칸 위에 놓는다. 
			if(x == 6 || arr[x][y1] || arr[x][y2] || arr[x - h][y1] || arr[x - h][y2] ) {
				
				arr[x - 1][y1] = true;
				arr[x - 1][y2] = true;
				
				arr[x - h - 1][y1] = true;
				arr[x - h - 1][y2] = true;
				break;
			}
		}
		
		
	}
	
	
	public static void down(boolean[][] arr, int x) {
		int nx = x;
		for(;nx >= 0; nx--) {
			for(int y = 0; y < 4; y++) {
				arr[nx + 1][y] = arr[nx][y]; 
			}
		}
	}
	
	public static int check(boolean[][] arr) {
		int score = 0;
		
		//5부터 2까지
			int x = 5;
			outer:for(;x >= 2;x--) {
				for(int y = 0; y < 4; y++) {
					// 하나라도 비어있다면 다음행
					if(!arr[x][y]) continue outer;
				}
				
				// 전부 true라면 전부 사라지게해주고
				Arrays.fill(arr[x], false);
				
				// 점수 증가
				score++;
				// 그 위에 있는거 한칸식 down
				down(arr,x - 1);
				// 현재 행 부터 다시보자
				x++;
			}
			
			// x가 0,1에 뭐 있다면 클리어하고 그 만큼 아래 쳐내고
			// 다시 내려보내기
			int donwCount = 0;
			outer:for(x = 1; x >= 0; x--) {
				for(int y = 0; y < 4; y++) {
					// 하나라도 있다면
					if(arr[x][y]) {
						Arrays.fill(arr[5 + x - 1], false);
						donwCount++;
						continue outer;
					}
				}
			}
			
			for(;donwCount > 0;donwCount--) {
				down(arr,4);
			}
			
			Arrays.fill(arr[0], false);
			Arrays.fill(arr[1], false);
			

		return score;
	}
}