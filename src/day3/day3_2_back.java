//방배정
//주어진 명수의 사람을 4개의 방에 배정하려고 한다. 
//그리고 주어진 2차 행렬에 i번째 사람과 j번째 사람이 아는 사이일 경우 1을 모르는 사이일 경우 0의 값으로 표시하고 있다. 
//아는 사람끼리 같은 방에 배정되지 않도록 할 경우 총 경우의 수는 어떻게 되는가? 
//이 경우 중 가장 적은 방을 이용하여 배정한다면 최소 몇 개의 방이 필요한가?
//9
//0 0 0 0 0 0 1 1 1
//0 0 0 1 0 0 0 1 1
//0 0 0 0 0 0 0 0 1
//0 1 0 0 1 1 0 0 0
//0 0 0 1 0 0 0 0 0
//0 0 0 1 0 0 0 0 0
//1 0 0 0 0 0 0 0 0
//1 1 0 0 0 0 0 0 0
//1 1 1 0 0 0 0 0 0
//
//출력
// 2



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day3_2_back {

	public static int person_RNum[] = new int [10];   
	public static int relation[][] = new int [10][10];   
	public static int needed_room = 0x12345678; 
	public static int N, cnt;

	public static void process_solution()
	{
		int person_cnt_in_room[] = new int [5];  
		int t = 0, i;
		
		for (int kth_person = 2; kth_person < 10; kth_person++)
			for ( i = 1; i < kth_person; i++) // kth_person번째 이전 사람 중에....
				if (relation[kth_person][i] > 0 && person_RNum[i] == person_RNum[kth_person]) // 아는 사이인데 지금 배정하려는 방에 배정되어 있는지...
					return;

		for (i = 1; i <= 9; i++) person_cnt_in_room[person_RNum[i]]++;  

		for (i = 1; i <= 4; i++) if (person_cnt_in_room[i] > 0) t++;  

		if (t < needed_room) needed_room = t;

		
		if (t == 2)
		{
			for (i = 1; i <= 9; i++)
				System.out.printf("%d ", person_RNum[i]);
			System.out.println();
		}
	}


	public static void solve(int kth_person)
	{
		cnt++;
		if (kth_person == 9) process_solution();
		else
		{
			kth_person++;
			for (int i = 1; i <= 4; i++)
			{
				person_RNum[kth_person] = i; 
				solve(kth_person);
			}
		}
	}


	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("day3_2.txt"));

		N = sc.nextInt();

		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				relation[i][j] = sc.nextInt();

		solve(0);
		System.out.printf("%d %d\n", needed_room, cnt);

		sc.close();
	}
}
