// 너비우선탐색
// 입력 데이터
// 1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2_e_2 {
	public static int G[][] = new int [8][8];
	//	public static int G[][] = {
	//			{ 0, 0, 0, 0, 0, 0, 0, 0},
	//			{ 2, 2, 3, 0, 0, 0, 0, 0},  // 정점 1의 인접정점의 개수와 인접정점들
	//			{ 3, 1, 4, 5, 0, 0, 0, 0 },  // 정점 2의 인접정점의 개수와 인접정점들
	//			{ 2, 1, 7, 0, 0, 0, 0, 0 },  // 정점 3의 인접정점의 개수와 인접정점들
	//			{ 2, 2, 6, 0, 0, 0, 0, 0 },  // 정점 4의 인접정점의 개수와 인접정점들
	//			{ 2, 2, 6, 0, 0, 0, 0, 0 },  // 정점 5의 인접정점의 개수와 인접정점들
	//			{ 3, 4, 5, 7, 0, 0, 0, 0 },  // 정점 6의 인접정점의 개수와 인접정점들
	//			{ 2, 3, 6, 0, 0, 0, 0, 0 } };  // 정점 7의 인접정점의 개수와 인접정점들
	public static int q[] = new int [10];
	public static int f, r;
	public static boolean visited[] = {false, false, false, false, false, false, false, false};

	public static void BFS(int G[][], int w)
	{
		System.out.printf("%d ", q[++r] = w);
		visited[w] = true;

		while (f != r)
		{
			w = q[++f];
			for (int i = 1; i <= 3 ; i++)
			{
				if (G[w][i] > 0 && !visited[G[w][i]])
				{

					System.out.printf("%d ", q[++r] = G[w][i]);
					visited[G[w][i]] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("day2_e_1.txt"));
		int u, v, i;

		for (i = 0; i < 8; i++)
		{
			u = sc.nextInt();
			v = sc.nextInt();

			G[u][++G[u][0]] = v;
			G[v][++G[v][0]] = u;
		}

		f=r=-1;
		BFS(G, 1);
		sc.close();
	}
}
