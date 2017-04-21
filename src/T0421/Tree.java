package T0421;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Tree {

	public static int N, E, A, B, H;
	public static int[] P,C;
	public static int[] tree;
	public static int[] h, histA, histB;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("src\\day5\\day5_1.txt"));
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		E=sc.nextInt();		
		A=sc.nextInt();
		B=sc.nextInt();
		
		tree = new int[N+1];
		h = new int[N+1];
		histA = new int[N+1];
		histB = new int[N+1];
		P = new int[E+1];
		C = new int[E+1];
		
		for(int i=1;i<=E;i++)
		{
			P[i] = sc.nextInt();
			C[i] = sc.nextInt();

		}
		sort();
		build();
		findNode(0, histA, A);
		findNode(0, histB, B);
		sc.close();
	}

	public static void findNode(int d, int hist[], int a)
	{
		if(a==0 || d==h[a])
			return;
		hist[d] = a;
		findNode(d+1, hist, tree[a]);
	}
	public static void build()
	{
		int max=0;
		for(int i=1;i<=E;i++)
		{
			tree[C[i]] = P[i];
			h[C[i]] = h[P[i]] + 1;
			if(h[C[i]] > max)
				max = h[C[i]];
		}
		H=max;
	}
	
	public static void sort()
	{
		for(int i=1;i<=E;i++)
		{
			for(int j=i+1;j<=E;j++)
			{
				if(P[i]>P[j])
				{
					int tmp = P[i];
					P[i] = P[j];
					P[j] = tmp;
					
					int tmp2 = C[i];
					C[i] = C[j];
					C[j] = tmp2;
				}
			}
		}
	}
	

}
