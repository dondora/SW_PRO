
/////// MST 가중치의 합 크루스칼

// input
//4
//0 1 5 4
//1 0 2 6
//5 2 0 3
//4 6 3 0
//5
//0 1 6 7 5
//1 0 2 9 8
//6 2 0 3 10
//7 9 3 0 4
//5 8 10 4 0

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2_1_2 {
	
	public static int adjM[][] = new int [11][11];
	public static int cost[] = new int [11];
	public static boolean selc[] = new boolean[11];
	public static int N, v, cnt, ans, min;
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("day2_1.txt"));
		
		int n, i, j;
		
		for(n = 0; n < 2; n++ )
		{
			N = sc.nextInt();
			
			for (i = 1; i <= N; i++)
			{
				for (j = 1; j <= N; j++)
					adjM[i][j] = 0;
				
				selc[i] = false;
				cost[i] = 0x7fffffff;
			}

			cost[1] = cnt = ans = 0;
			
			for (i = 1; i <= N; i++)
				for (j = 1; j <= N; j++)
					adjM[i][j] = sc.nextInt();
			
			while (cnt++ < N)
			{
				min = 0x12345678;
				for (j = 1; j <= N; j++)
					if (!selc[j] && cost[j] < min)
						min = cost[v = j];

				selc[v] = true;
				ans += cost[v];

				for (j = 1; j <= N; j++)
					if (!selc[j] && adjM[v][j] < cost[j])
						cost[j] = adjM[v][j];
			}
			System.out.printf("%d\n", ans);
		}
		sc.close();
	}
}
