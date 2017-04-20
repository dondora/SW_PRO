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

public class day3_2_prun {

	public static int person_RNum[] = new int [10];   
	public static int relation[][] = new int [10][10];   
	public static int needed_room = 0x12345678; 
	public static int N, cnt, flag;

	
	public static boolean check(int room_num, int kth_person)
	{
		for (int i = 1; i < kth_person; i++) 
			if (person_RNum[i] == room_num)
			{
				flag = 0;
				if (relation[kth_person][i] > 0) return true;
			}

		return false;
	}

	public static void solve(int kth_person,  int room_cnt)
	{
		cnt++;
		if (kth_person == 9)
		{
			if (room_cnt < needed_room) needed_room = room_cnt;

			if (room_cnt == 2)
			{
				for (int i = 1; i <= 9; i++)
					System.out.printf("%d ", person_RNum[i]);
				System.out.println();
			}		
		}
		else
		{
			kth_person++;
			for (int i = 1; i <= 4; i++)
			{
				flag = 1;
				if (check(i, kth_person)) continue;

				if (room_cnt + flag >= needed_room) continue;

				person_RNum[kth_person] = i;
				solve(kth_person, room_cnt + flag);
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

		solve(0, 0);
		System.out.printf("%d %d\n", needed_room, cnt);

		sc.close();
	}
}
