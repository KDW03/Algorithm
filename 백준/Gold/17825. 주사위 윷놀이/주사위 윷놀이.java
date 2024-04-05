import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;



class Point {
	int score = 0;
	ArrayList<Point> next = new ArrayList();
	
	public Point(int score) {
		this.score = score;
	}
	
	public Point cp(int score) {
		Point newP = new Point(score);
		next.add(newP);
		return newP;
	}
}




class Main {

	static int[] nums = new int[10];
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		for(int i = 0; i < 10; i++) {
			String s = inputs[i];
			int num = Integer.parseInt(s);
			nums[i] = num;
		}
		
		Point start = new Point(0);
		Point point10 = start.cp(2).cp(4).cp(6).cp(8).cp(10);
		
		
		// 빨간
		Point point20 = point10.cp(12).cp(14).cp(16).cp(18).cp(20);
		// 파랑 25연결
		Point point25 = point10.cp(13).cp(16).cp(19).cp(25);
		
		
		// 빨강
		Point point30 = point20.cp(22).cp(24).cp(26).cp(28).cp(30);
		// 파랑 25연결
		point20.cp(22).cp(24).next.add(point25);

		
		// 빨강
		Point point40 = point30.cp(32).cp(34).cp(36).cp(38).cp(40);
		// 파랑 25 연결
		point30.cp(28).cp(27).cp(26).next.add(point25);
		
		
		
		point25.cp(30).cp(35).next.add(point40);
		// 마지막
		point40.cp(0);
		
		
		// 빨강은 첫번째다.
		
		
		// dfs로 모든 경우
		
		Point[] nowP = new Point[4];  
		for(int i = 0 ; i < 4 ; i++) nowP[i] = start;	
		
		System.out.println(dfs(nowP,0,0));
	}
	
	
	static int dfs(Point[] nowP, int nowDiceIndex, int sumScore) {
		if(nowDiceIndex == 10) return sumScore; 
		int k = nums[nowDiceIndex];
		int max = sumScore;
		
		outer:for(int i = 0 ; i < 4 ; i++) {
			if(nowP[i].next.isEmpty()) continue;
			Point pre = nowP[i];
			nowP[i] = move(nowP[i],k);
			
			for(int j = 0 ; j < 4 ; j++) {
				if(i == j) continue;
				// 출발지나 도착지가 아닌데 같은곳이 있다면 안됌
				if(nowP[i].score != 0 && nowP[i].equals(nowP[j])) {
					nowP[i] = pre;
					continue outer;
				}
			}
			
			max = Math.max(max, dfs(nowP,nowDiceIndex + 1, sumScore + nowP[i].score));
			nowP[i] = pre;
		}
		
		return max;
	}
	
	
	static Point move(Point p, int count) {
		Point now = p;
		
		if(now.next.size() >= 2) {
			now = now.next.get(1); 
		} else {
			now = now.next.get(0);
		}
		
		for(int i = 0; i < count - 1 ; i++) {
			if(now.next.isEmpty()) break;
			now = now.next.get(0);
		}
		
		return now;
	}
	
	public static Point makeAndConnectPoint(Point p, int score) {
		Point newP = new Point(score);
		p.next.add(newP);
		return newP;
	}
	
	
}