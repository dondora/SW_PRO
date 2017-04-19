// 위상정렬
//
//5 4                 // 정점의 개수, 간선의 개수
//1, 3, 3, 5, 2, 3, 4, 5 //간선의 리스트


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2_3_2 {

	public static int in[][] = new int [10][10];
	public static int cnt[] = new int [10];
	public static boolean done[]= new boolean [10];
	public static int n, e;
	
	public static void dfs(int a)
	{
		for (int i = 0; i < cnt[a]; i++)
		{
			if (!done[in[a][i]])	dfs(in[a][i]);
		}

		done[a] = true;
		System.out.printf("  %d", a);
	}

	public static void find()
	{
		for (int i = 1; i <= n; i++)
		{
			if (!done[i])	dfs(i);
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("day2_3.txt"));
		
		n = sc.nextInt(); 
		e = sc.nextInt();
		
		for (int i = 0; i <= n; i++)
		{
			done[i] = false; 
			cnt[i] = 0;
		}

		for (int i = 0; i < e; i++)
		{
			int a, b;
			a = sc.nextInt(); 
			b = sc.nextInt();

			in[b][cnt[b]] = a;
			cnt[b]++;
		}
		
		find();
		
		System.out.printf("\n");
		
		sc.close();
	}

}
