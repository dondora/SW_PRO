// 위상정렬
//
//5 4                 // 정점의 개수, 간선의 개수
//1, 3, 3, 5, 2, 3, 4, 5 //간선의 리스트


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2_3_1 {

	public static int G[][] = new int [10][10]; //G[x][0] input degree G[x][1] output degree
	public static int q[] = new int [10];
	public static int f, r;
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("day2_3.txt"));
		
		int V, E, i, u, v;
		
		V = sc.nextInt(); 
		E = sc.nextInt();
		
		f = r = -1;

		for (i = 0; i <= V; i++)
			G[i][0] = G[i][1] = 0;

		for (i = 0; i < E; i++)
		{
			u = sc.nextInt(); 
			v = sc.nextInt();
			G[u][++G[u][1] + 1] = v;
			G[v][0]++;
		}

		for (i = 1; i <= V; i++)
			if (G[i][0] == 0) q[++r] = i;

		int x;
		while (f != r)
		{
			System.out.printf("%d ", x = q[++f]);
			for (i = 0; i < G[x][1]; i++)
				if (--G[G[x][2 + i]][0] == 0) q[++r] = G[x][2 + i];
		}

		System.out.printf("\n");
		
		sc.close();
	}

}
