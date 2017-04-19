///////// 과자먹기
//
//주어진 행렬에서 9는 로봇을 1, 2, 3, 4, 5, 6 로봇이 도달해야 할 목표를 의미한다.로봇에서 타깃까지 상하좌우 직선으로만 이동한다.
//한칸 이동할 때 1초가 소요된다.하나의 로봇이 타깃에 도착하는 순간 다른 로봇이 이동한다.이동 시간의 합의 최소값을 구하라
//// input
//0 0 0 0 0 0 0 0 0 0
//0 1 0 0 0 0 0 0 0 0
//0 0 0 0 0 9 0 5 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 9 0 2 0 0 0
//0 9 0 0 0 0 0 9 0 0
//0 0 0 0 0 0 9 0 0 0
//0 0 0 3 0 0 0 0 4 0
//0 0 0 0 0 6 0 0 0 0
//0 0 0 9 0 0 0 0 0 0
//
//// 로봇과 타깃의 이동거리
////5 2 3 7 8 6
////6 5 2 4 7 5
////4 9 6 4 9 7
////10 3 2 6 3 5
////10 5 2 4 3 3
////10 11 8 2 7 3
//
//// ans = 16
////1 2 0 4 5 3
//
//



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day3_e_3 {
	public static int map[][] = new int[11][11];
	public static int rx[] = new int[7], ry[] = new int[7];
	public static int tx[] = new int[7], ty[] = new int[7];
	public static int dist[][] = new int[7][7];
	public static int arr[] = new int[10];
	public static int ans = 0x12345678;
	public static int cnt;
	public static boolean chk[] = new boolean [10];

	public static int ABS(int X)
	{
		if(X > 0) return X;
		return X * -1;
	}
	
	public static int getD(int x1, int x2, int y1, int y2)
	{
		return ABS(x1 - x2) + ABS(y1 - y2);
	}

	//순열 백트래킹 
	public static void solve(int k)
	{
		cnt++;
		if (k == 6)
		{
			int ts = 0;
			for (int i = 1; i <= 6; i++) ts += dist[i][arr[i]];
			if (ts < ans)  ans = ts;
		}
		else
		{
			k++;

			for (int i = 1; i <= 6; i++)
			{
				if (chk[i]) continue;
				chk[i] = true;
				arr[k] = i;
				solve(k);
				chk[i] = false;
			}
		}
	}

	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("day3_e_3.txt"));
		
		int rcnt = 1, tcnt = 1, i, j;

		for (i = 1; i <= 10; i++)
			for (j = 1; j <= 10; j++)
				map[i][j] = sc.nextInt();

		for (i = 1; i <= 10; i++)
			for (j = 1; j <= 10; j++)
			{
				if (map[i][j] == 9) {rx[rcnt] = i; ry[rcnt++] = j;}
				else if (map[i][j] > 0) {tx[tcnt] = i; ty[tcnt++] = j;}
			}

		for (i = 1; i <= 6; i++)
			for (j = 1; j <= 6; j++)
				dist[i][j] = getD(rx[i], tx[j], ry[i], ty[j]);

		solve(0);
		System.out.printf("%d %d\n", ans, cnt);

		sc.close();
	}
}
