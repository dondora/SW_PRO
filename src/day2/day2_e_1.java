//////  깊이 우선 탐색 
// 입력 데이터
// 1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2_e_1 {

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
	public static boolean visited[] = {false, false, false, false, false, false, false, false};
	public static int stack[] = new int [10];
	public static int top = -1;

	//재귀
	public static void DFSr(int G[][], int v)
	{
		visited[v] = true;
		System.out.printf("%d ", v);

		for (int i = 1; i <= 3 && G[v][i] != 0; i++)
			if (!visited[G[v][i]])
				DFSr(G, G[v][i]);
	}

	public static void DFS(int G[][], int V)
	{
		stack[++top] = V;

		while (top != -1)
		{
			int v = stack[top--];

			if (!visited[v])
			{
				visited[v] = true;
				System.out.printf("%d ", v);


				for (int i = G[v][0]; i > 0; i--)
					if (!visited[G[v][i]])
						stack[++top] = G[v][i];

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

		DFS(G, 1);
		sc.close();
	}
}


