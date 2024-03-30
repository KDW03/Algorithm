import java.io.*;
import java.util.*;

public class Main {
	
	static int totalSum = 0;
	
	public static void main (String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n + 1][n + 1];
		
		for(int x = 1 ; x <= n ; x++) {
			 String[] input = br.readLine().split(" ");
			 for(int y = 1 ; y <= n ; y++) {
				 int num = Integer.parseInt(input[y - 1]);
				 totalSum += num;
				 arr[x][y] = num;
			 }
		}
		
		int answer = Integer.MAX_VALUE;
		
		// 한 x,y점을 뽑음 400
		for(int x = 1; x <= n ; x++) {
			for(int y = 1; y <= n ; y++) {
				
				// d1,d2 뽑음 400
				for(int d1 = 1 ; d1 <= n ; d1++) {
					for(int d2 = 1 ; d2 <= n ; d2++) {
						
						if(x + d1 + d2 <= n && y - d1 >= 1 && y + d2 <= n) {
							answer = Math.min(answer, calculate(deepCopy(arr), x, y, d1, d2, n));
						}
						
		
					}
				}		
			}
		}
		
		System.out.println(answer);
	}
	
	
	static int[][] deepCopy(int[][] original) {
	    if (original == null) {
	        return null;
	    }

	    int[][] copy = new int[original.length][];
	    for (int i = 0; i < original.length; i++) {
	        copy[i] = original[i].clone(); // 배열의 두 번째 차원도 복제
	    }
	    return copy;
	}


	static int calculate(int[][] arrC, int x , int y , int d1, int d2, int n) {
		// 5번 구역 먼저 0으로 바꾸기
		// (x, y), (x+1, y-1), ..., (x+d1, y-d1)
		for(int i = 0 ; i < d1 ; i++) arrC[x + i][y - i] = 0;
		
		// (x, y), (x+1, y+1), ..., (x+d2, y+d2)
		for(int i = 0 ; i < d2 ; i++) arrC[x + i][y + i] = 0;
		
		// (x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
		for(int i = 0 ; i < d2 ; i++) arrC[x + d1 + i][y - d1 + i] = 0;
		
		// (x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
		for(int i = 0 ; i <= d1 ; i++) arrC[x + d2 + i][y + d2 - i] = 0;
		
		ArrayList<Integer> partSum = new ArrayList(); 
		int nowPartSum = 0;
		int nowTotal = 0;
		// 1번 구역 1 ≤ r < x+d1, 1 ≤ c ≤ y
		for(int r = 1; r < x + d1 ; r++) {
			for(int c = 1 ; c <= y; c++) {
				if(arrC[r][c] == 0) break;
				nowPartSum += arrC[r][c];
			}
		}
		
		partSum.add(nowPartSum);
		nowTotal += nowPartSum;
		nowPartSum = 0;
		// 2번 구역 1 ≤ r ≤ x+d2, y < c ≤ N
		for(int r = 1; r <= x + d2 ; r++) {
			for(int c = n ; c > y ; c--) {
				if(arrC[r][c] == 0) break;
				nowPartSum += arrC[r][c];
			}
		}
		
		partSum.add(nowPartSum);
		nowTotal += nowPartSum;
		nowPartSum = 0;
		
		// 3번 구역 x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
		for(int r = x + d1 ; r <= n ; r++) {
			for(int c = 1 ; c < y - d1 + d2 ; c++) {
				if(arrC[r][c] == 0) break;
				nowPartSum += arrC[r][c];
			}
		}
		partSum.add(nowPartSum);
		nowTotal += nowPartSum;
		nowPartSum = 0;
		
		// 4번 구역 x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
		for(int r = x + d2 + 1 ; r <= n ; r++) {
			for(int c = n ; c >= y - d1 + d2 ; c--) {
				if(arrC[r][c] == 0) break;
				nowPartSum += arrC[r][c];
			}
		}
		partSum.add(nowPartSum);
		nowTotal += nowPartSum;
		nowPartSum = 0;
		
		partSum.add(totalSum - nowTotal);
		Collections.sort(partSum);
		int min = partSum.get(0);
		int max = partSum.get(4);
		
		return max - min;
	}
	
}