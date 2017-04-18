package T0418;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.chrono.MinguoDate;
import java.util.Scanner;

public class Goblin {
	static int N;
	static char A[][];
	static int dp[][];
	static int dy[], dx[];
	static int visited[][];

	//64개에서 막힘. DP 가 필요할듯?
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();

		System.setIn(new FileInputStream("src\\day2\\day2_2.txt"));
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		A = new char[N + 1][N + 1];
		dp = new int[N + 1][N + 1];
		visited = new int[N + 1][N + 1];
		dy = new int[] { 1, 0, 0, -1 };
		dx = new int[] { 0, 1, -1, 0 };
		for (int n = 1; n <= N; n++) {
			A[n] = (" " + sc.next()).toCharArray();
		}

		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= N; x++)
				dp[y][x] = Integer.MAX_VALUE;
		}

		dp[1][1] = 1;
		check(1, 1, 0);
		sc.close();
		System.out.println(minDamage);
		System.out.println("End");
		long end = System.currentTimeMillis();
		System.out.println("실행 시간 : " + (end - start) / 1000.0);
	}

	public static int minDamage = Integer.MAX_VALUE;

	public static void check(int y, int x, int sum) {

		if (y == N && x == N) {
			if (sum < minDamage)
				minDamage = sum;
			return;
		}


			for (int d = 0; d < 4; d++) {
				int yy = y + dy[d];
				int xx = x + dx[d];

				if (yy <= 0 || yy > N || xx <= 0 || xx > N || visited[yy][xx] == 1
						/* || dp[yy][xx] != Integer.MAX_VALUE)*/
						|| dp[yy][xx] <= sum + Integer.parseInt(A[yy][xx] + ""))
					continue;

				int Avalue = Integer.parseInt(A[yy][xx] + "");
				visited[yy][xx] = 1;
				dp[yy][xx] = sum + Avalue;
				check(yy, xx, dp[yy][xx]);
				visited[yy][xx] = 0;

			}
		
	}

}
