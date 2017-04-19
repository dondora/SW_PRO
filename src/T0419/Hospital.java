package T0419;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {

	public static int N;
	public static int Val[];
	public static int G[][];
	public static int visited[];
	public static Vertex q[] ;
	// public static ArrayList<Integer> G[];
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("src\\day3\\day3_1.txt"));
		Scanner sc = new Scanner(System.in);

		// 전체 정점을 순회한다. 다만, 1단계만 진행했을때 모두 visited로 변경한다.
		N = sc.nextInt();
		Val = new int[N + 1];
		G = new int[N + 1][N + 1];
		visited = new int[N + 1];
		q = new Vertex[N*2];

		for (int i = 1; i <= N; i++) {
			Val[i] = sc.nextInt();
		}
		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= N; x++) {
				G[y][x] = sc.nextInt();
			}
		}

		
		for(int i=1;i<=N;i++)
		{
			visited = new int[N + 1];
			int val = bfs(new Vertex(i, Val[i], 0));
			if(visitCnt==N && val<minV)
				minV=val;
		}
		System.out.println(minV);
		sc.close();
	}

	public static int minV = Integer.MAX_VALUE;

	public static int f, r, visitCnt;
	public static int bfs(Vertex v) {
		f = r = -1;
		int ret=0;
		
		q[++f] = v;
		while(f!=r)
		{
			Vertex tmp = (Vertex)q[++r];
			if(visited[tmp.v]!=1)
			{
				visited[tmp.v] = 1;
				visitCnt++;
			}
			for(int x=1;x<=N;x++)
			{
				if(visited[x]!=1 && G[tmp.v][x]==1)
				{
					q[++f] = new Vertex(x, Val[x], tmp.depth+1);
				}
			}
			if(tmp.depth%2 == 0)
				ret+=tmp.w;
			System.out.println(tmp.v);
			
		}
		return ret;		
	}
	static class Vertex
	{
		int v;
		int w;
		int depth;
		public Vertex(int v, int w, int depth)
		{
			this.v=v;
			this.w=w;
			this.depth=depth;
		}
	}
}
