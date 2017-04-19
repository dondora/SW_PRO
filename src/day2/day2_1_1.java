
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

public class day2_1_1 {

	public static int adjM[][] = new int [100][100];
	public static int Ed[] = new int [100];
	public static int uv[][] = new int [100][2];
	public static int parent[] = new int [100];
	public static int edgeNs, N, ans;
	

	public static int FindSet(int u)
	{
		if (u == parent[u]) return u;
		return FindSet(parent[u]);
	}

	public static void swapE(int i, int j)
	{
		int t = Ed[i]; Ed[i] = Ed[j]; Ed[j] = t;
		int t1 = uv[i][0];  uv[i][0] = uv[j][0]; uv[j][0] = t1;
		t1 = uv[i][1];  uv[i][1] = uv[j][1]; uv[j][1] = t1;
	}

	public static int partition(int l, int r)
	{
		int p = Ed[l];
		int i = l, j = r;

		while (i < j)
		{
			while (Ed[i] <= p) if (++i == r) break;
			while (Ed[j] >= p) if (--j == l) break;

			if (i < j) swapE(i, j);
		}
		swapE(l, j);

		return j;
	}

	public static void sortEdges(int l, int r)
	{
		int pivot;

		if (l < r)
		{
			pivot = partition(l, r);
			sortEdges(l, pivot - 1);
			sortEdges(pivot + 1, r);
		}
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("day2_1.txt"));
		int n, i, j;
		for(n = 0; n < 2; n++ )
		{
			N = sc.nextInt();
			
			for (i = 0; i < N; i++)
				for (j = 0; j < N; j++)
					adjM[i][j] = sc.nextInt();
			
			edgeNs =  ans = 0;
			
			for (i = 0; i < N; ++i)
				for (j = i + 1; j < N; ++j)
				{
					Ed[edgeNs] = adjM[i][j];
					uv[edgeNs][0] = i;
					uv[edgeNs++][1] = j;
				}	
			
			sortEdges(0, edgeNs - 1);

			for (i = 0; i < N; ++i)	parent[i] = i;

			int u, v, nS = 0;
			for (i = 0; i < edgeNs; ++i)
			{
				u = uv[i][0]; v = uv[i][1];

				if (FindSet(u) == FindSet(v)) continue;

				parent[FindSet(u)] = FindSet(v);

				ans += Ed[i];
				if (nS++ == N - 1) break;
			}

			System.out.printf("%d\n", ans);
		}
		sc.close();
	}
}
