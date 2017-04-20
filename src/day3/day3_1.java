//병원짓기
//N개의 마을이 있고 마을에 병원을 짓는 비용이 주어진다.
//도로로 직접 연결된 이웃 마을에서 병원 진료를 받을 수 있다.
//도로로 연결된 이웃 마을의 관계가 주어진다.
//모든 마을의 사람들이 병원 진료를 받을 수 있도록 최소 비용으로 병원을 짓고자 할때 최소 비용이 얼마인가?
//당연히 자기 마을에 병원이 있으면 자기 마을에서 병원 진료를 받을 수 있다.

//
//입력예
//5
//100 70 50 80 10
//0 1 0 1 0 
//1 0 1 0 1
//0 1 0 0 0
//1 0 0 0 0
//0 1 0 0 0
//출력예
//140



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day3_1 {

	public static int map[][] = new int [100][100];
	public static int cost[] = new int[100];
	public static boolean a[] = new boolean [100];
	public static int cnt, N, ans = 12345678;

	public static void solve(int k)
	{
		cnt++;
		if (k == N)
		{
			int tcnt = 0, tsum = 0;
			int con[] = new int [100];

			for (int i = 1; i <= N; i++)
			{
				if (a[i])
				{
					tsum += cost[i];

					con[i] = 1;
					for (int j = 1; j <= N; j++)
						if ( map[i][j] > 0 ) con[j] = 1;
				}
			}

			for (int i = 1; i <= N; i++) tcnt += con[i];

			if (tcnt == N && ans > tsum)	ans = tsum;
		}
		else
		{
			k++;
			a[k] = true;  solve(k);
			a[k] = false; solve(k);
		}
	}

	

	public static void solve(int k, int val_p)
	{
		cnt++;
		if (k == N)
		{
			int tcnt = 0;
			int con[] = new int [100];

			for (int i = 1; i <= N; i++)
			{
				if (a[i])
				{
					con[i] = 1;
					for (int j = 1; j <= N; j++)
						if (map[i][j] > 0) con[j] = 1;
				}
			}

			for (int i = 1; i <= N; i++) tcnt += con[i];

			if (tcnt == N && ans > val_p)
			{
				for (int i = 1; i <= N; i++)
					if (a[i]) System.out.printf("a[%d] %d ", i, cost[i]);
				System.out.println();

				ans = val_p;
			}
		}
		else
		{
			k++;
			//if (ans > val_p + cost[k])	// 가지치기
			{ a[k] = true; solve(k, val_p + cost[k]); }

			a[k] = false; solve(k, val_p);
		}
	}


	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("day3_1.txt"));

		N = sc.nextInt();

		int i, j;
		for (i = 1; i <= N; i++)
			cost[i] = sc.nextInt();

		for (i = 1; i <= N; i++)
			for (j = 1; j <= N; j++)
				map[i][j] = sc.nextInt();;

		solve(0, 0);

		System.out.println(ans + " " + cnt);

		sc.close();
	}
}

