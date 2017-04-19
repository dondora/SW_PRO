/////// 도깨비언덕에 왜 왔니?

// input
//4 1 3
//0 1 5 4
//1 0 2 6
//5 2 0 3
//4 6 3 0
//5 1 4
//0 1 6 7 5
//1 0 2 9 8
//6 2 0 3 10
//7 9 3 0 4
//5 8 10 4 0

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2_2_1 {

	public static int map[][] = new int [100][100];
	public static boolean visited[][] = new boolean [100][100]; // 최단 경로에 포함되는지 여부를 저장
	public static int dist[][] = new int [100][100];;
	public static int N;
	
	
	public static boolean Check(int x, int y)
	{
		if (x < 0 || y < 0 || x > N - 1 || y > N - 1) return false;
		if (visited[x][y]) return false;
		return true;
	}
	
	
	public static void dijkstra()
	{
		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };
		int x, y, curx = 0, cury = 0, min;
		int i, j, k;

		visited[0][0] = true;
		dist[0][0] = 0;
		dist[0][1] = map[0][1];
		dist[1][0] = map[1][0];

		for (k = N*N - 1; k > 0; k--)
		{
			min = 0x7FFFFFFF;

			for (i = 0; i < N; i++)
				for (j = 0; j < N; j++)
				{
					if (visited[i][j] == false && dist[i][j] <= min)
					{
						min = dist[i][j];
						curx = i;
						cury = j;
					}
				}
			if(curx == N-1 && cury == N-1) return;
			visited[curx][cury] = true;

			for (i = 0; i < 4; i++)
			{
				x = curx + dx[i];
				y = cury + dy[i];
				if (Check(x, y) && (dist[x][y] > (dist[curx][cury] + map[x][y])))
					dist[x][y] = dist[curx][cury] + map[x][y];
			}
		}
	}

	
	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner sc = new Scanner(new File("day2_2_1.txt"));
		
		int i, j;

		for (int tc = 0; tc < 10; tc++)
		{
			N = sc.nextInt();

			for (i = 0; i < N; i++)
			{
				String ts = sc.next();
				for (j = 0; j < N; j++)
				{
					map[i][j] = ts.charAt(j) - '0';
					dist[i][j] = 0x7FFFFFFF;
					visited[i][j] = false;
				}
			}

			dijkstra();

			System.out.printf("%d\n", dist[N - 1][N - 1]);
		}
		sc.close();
	}

}
