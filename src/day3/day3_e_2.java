// 선택정렬 반복과 재귀

public class day3_e_2 {
	public static int ary[] = {5, 2, 7, 1, 3, 8, 9, 3, 5, 2};

	public static void recselectionsort(int ary[], int s, int e)
	{
		int mini = s;

		if(s == e) return;

		for(int j = s + 1; j < e; j++)
		{
			if(ary[j] < ary[mini])
				mini = j;
		}
		int t;
		t = ary[s];
		ary[s] = ary[mini];
		ary[mini] = t;

		recselectionsort(ary, s + 1, e);
	}

	public static void selectionsort()
	{
		int mini;
		for(int i = 0; i < 9; i++)
		{
			mini = i;
			for(int j = i + 1; j < 10; j++)
			{
				if(ary[j] < ary[mini])
					mini = j;
			}
			int t;
			t = ary[i];
			ary[i] = ary[mini];
			ary[mini] = t;
		}
	}
	
	public static void main(String[] args) 
	{
		//selectionsort();
		recselectionsort(ary, 0, 10);
		for(int i = 0; i < 10; i++)
			System.out.printf("%d ", ary[i]);
	}
}
