//모든정점경유 최단거리 가지치기 greedy()
//
//
//시작 정점과 도착정점의 좌표가 주어진다.
//11개의 정점이 추가로 주어진다.
//시작 정점에서 추가로 주어진 정점들을 모두 경유하여 도착 정점으로 가는 경로의 길이 중 가장 짧은 거리의 값은 얼마인가 ?
//정점은 x 좌표, y 좌표로 주어진다.
//좌표의 범위는 x : 0 ~100, y : 0 ~100이다.
//거리는 두 정점 사이의 | x축 거리 | +| y축 거리 | 로 계산한다.
//예를 들어(0, 0) 정점과(100, 100) 정점의 거리는 200이다.
//
//5
//97 61 35 93
//62 64 96 39 36 36 9 59 59 96 61 7 64 43 43 58 1 36 55 55 88 88
//72 2 71 100
//29 48 74 51 27 0 58 0 35 2 43 47 50 49 44 100 66 96 55 55 88 88
//16 6 48 82
//80 21 49 34 60 25 93 90 26 96 12 100 44 69 28 15 57 63 55 55 88 88
//72 42 43 36
//59 44 52 57 34 49 65 79 14 20 41 9 0 39 100 94 53 3 55 55 88 88
//0 0 69 58
//100 31 67 67 58 66 83 22 44 24 68 3 76 85 63 87 7 86 55 55 88 88
//
//
//// 가지치기 + 그리드
//#1 398 1806506
//#2 293 107595
//#3 412 544012
//#4 387 1024215
//#5 431 1322756

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day3_3_1 {

	public static int x[] = new int [14], y[]= new int [14];
	public static int D[][] = new int [14][14];
	public static int a[] = new int [13];
	public static boolean chk[] = new boolean [12];
	public static int ans, N = 11, cnt;

	
	public static int ABS(int X)
	{
		if(X > 0) return X;
		return X * -1;
	}
	
	public static int getD(int x1, int x2, int y1, int y2)
	{
		return ABS(x1 - x2) + ABS(y1 - y2);
	}

	
	
	public static void greedy_ans()
	{
		int selc[] = new int [14];
		int selcC = 0, selcI, min, minI;

		ans = 0;

		min = D[0][1];
		minI = 1;
		
		for (int i = 2; i < N + 1; i++)
			if (min > D[0][i])
				min = D[0][minI = i];

		selc[selcI = minI] = 1;
		ans += min;

		while (selcC++ != N - 1)
		{
			min = 0x12345678;
			minI = 0;

			for (int j = 1; j < N + 1; j++)
			{
				if (selcI == j || selc[j] == 1) continue;
				if (D[selcI][j] < min)  min = D[selcI][minI = j];
			}
			selc[selcI = minI] = 1;
			ans += min;
		}

		ans += D[selcI][N + 1];
	}


	public static void solve(int k, int ith, int d) 
	{
		cnt++;

		if (k == N)
		{
			if (d + D[ith][N + 1] < ans) ans = d + D[ith][N + 1];
		}
		else
		{
			k++;

			for (int i = 1; i <= N; i++)
			{
				if (chk[i]) continue;

				chk[i] = true;

				if (d + D[ith][i] < ans) // 가지치기
					solve(k, i, d + D[ith][i]);

				chk[i] = false;
			}
		}
	}

	
	public static void solve(int k) 
	{
		cnt++;

		if (k == N)
		{
			int tsum = 0, i;

			tsum += getD(x[0], x[a[1]], y[0], y[a[1]]);
			
			for (i = 1; i < N; i++)
				tsum += getD(x[a[i]], x[a[i + 1]], y[a[i]], y[a[i + 1]]);
			
			
//			for (i = 1; i < N; i++)
//				tsum += D[a[i]][a[i + 1]];

			tsum += getD(x[a[i]], x[N + 1], y[a[i]], y[N+1]);
			
			if (tsum < ans) ans = tsum;
		}
		else
		{
			k++;

			for (int i = 1; i <= N; i++)
			{
				if (chk[i]) continue;

				chk[i] = true;
				a[k] = i;

				solve(k);

				chk[i] = false;
			}
		}
	}


	public static void main(String[] args) throws FileNotFoundException
	{
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(new File("day3_3_1.txt"));

		int i, j, tc, T;
		T = sc.nextInt();

		for (tc = 1; tc <= T; ++tc)
		{
			
			cnt = 0;
			ans = 0x12345678;

			x[0] = sc.nextInt();
			y[0] = sc.nextInt();
			x[N + 1] = sc.nextInt();
			y[N + 1] = sc.nextInt();;

			for (i = 1; i <= N; i++)
			{
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();;
			}


			for (i = 0; i < N + 1; i++)
				for (j = i + 1; j < N + 2; j++)
					D[i][j] = D[j][i] = getD(x[i], x[j], y[i], y[j]);

			for (i = 0; i < 12; i++) chk[i] = false;

			greedy_ans();
			solve(0, 0, 0);

			System.out.printf("#%d %d %d\n", tc, ans, cnt);
		}

		sc.close();
		
		long end = System.currentTimeMillis();
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 ); 
	}
}




