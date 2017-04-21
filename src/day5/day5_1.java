// 트리의 높이와 넓이
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day5_1 {
	public static int tree[][] = new int [10001][3];
	public static int treeW[] = new int [10001];
	public static int CA, cnt, treeH, ec, nc, n1, n2;


	public static void init()
	{
		treeH = cnt = 0;

		for (int i = 0; i < ec; i++)
			treeW[i] = tree[i][0] = tree[i][1] = tree[i][2] = 0;
	}

	public static void traversal(int T, int d)
	{
		if (T != 0)
		{
			cnt++;
			treeW[d]++;
			if(treeH < d) treeH = d;
			d++;
			traversal(tree[T][0], d);
			traversal(tree[T][1], d);
		}
	}


	public static void main(String[] args) throws FileNotFoundException
	{
		long start = System.currentTimeMillis();

		Scanner sc = new Scanner(new File("day5_1.txt"));

		int  i, j, p, c, t, A;

		for(int n = 0; n < 2; n++) {

			init();
			ec = sc.nextInt();
			nc = sc.nextInt();
			n1 = sc.nextInt();
			n2 = sc.nextInt();

			for (j = 0; j < nc; j++)
			{
				p = sc.nextInt();  
				c = sc.nextInt();
				if (tree[p][0] == 0 ) tree[p][0] = c;
				else tree[p][1] = c;
				tree[c][2] = p;
			}

			A = tree[n1][2];
			tree[n1][2] = -1;

			while (A != 0)
			{
				t = A;
				A = tree[A][2];
				tree[t][2] = -1;
			}

			CA = tree[n2][2];

			while (tree[CA][2] != -1)
				CA = tree[CA][2];

			traversal(CA, 0);	

			int m = treeW[0];
			for(i = 1; i < ec; i++)
				if(treeW[i] > m)
					m = treeW[i];


			System.out.printf("%d %d %d\n", CA, treeH, m);
		}
		sc.close();

		long end = System.currentTimeMillis();
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 ); 

	}
}


