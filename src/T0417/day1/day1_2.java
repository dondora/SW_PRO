// 최대상금
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day1_2 {
	public static int sol, ns, ii, jj, cnt;
	public static int [][]state = new int[11][720];
	public static int t[] = {1, 10, 100, 1000, 10000, 100000};

	public static int swap(int x, int i, int j)
	{
		ii = ((x / t[ns - i]) % 10);
		jj = ((x / t[ns - j]) % 10);
		return x - ii * t[ns - i] - jj * t[ns - j] + ii * t[ns - j] + jj * t[ns - i];
	}

	public static void findmax(int x, int s)
	{
		cnt++;
		if (s != 0 )
		{
			int i;
			for (i = 0; i < 720; i++)
			{
				if (state[s][i] == 0)
				{
					state[s][i] = x;
					break;
				}
				else if (state[s][i] == x) return;
			}
		}

		if (s == 0)
		{
			if (x > sol) sol = x;
		}
		else
		{
			for (int i = 1; i <= ns - 1; i++)
				for (int j = i + 1; j <= ns; j++)
				{
//					ii = ((x / t[ns - i]) % 10);
//					jj = ((x / t[ns - j]) % 10);
//					int xx = x - ii * t[ns - i] - jj * t[ns - j] + ii * t[ns - j] + jj * t[ns - i];
//					findmax(xx, s - 1);
					findmax(swap(x, i, j), s - 1);
				}
		}
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		long start = System.currentTimeMillis();

		Scanner sc = new Scanner(new File("day1_2.txt"));

		int N, n;
		N = sc.nextInt();
		for(n = 1; n <= N; n++)
		{
			int x, s, i, j;

			for (i = 1; i < 11; i++)
				for (j = 0; j < 720; j++)
					state[i][j] = 0;

			x = sc.nextInt();
			s = sc.nextInt();

			int t = x;
			ns = 1;
			while ((t /= 10) != 0) ns++;

			cnt = sol = 0;
			findmax(x, s);

			System.out.printf("#%d %d %d\n", n, sol, cnt);
			if(n == 9)
			System.out.println( "실행 시간 : " + ( System.currentTimeMillis() - start )/1000.0 ); 
		}
		sc.close();

		long end = System.currentTimeMillis();
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 ); 
	}

}
