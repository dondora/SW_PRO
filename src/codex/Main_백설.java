package codex;
//���� ��ȣ B: [SOL] �鼳 ����
//�ð� ����: 1 Sec  �޸� ����: 128 MB
//����: 10  �ذ� ���� ��: 5
//[����]
//���� ����
//�鼳 ���ֿ� N���� ������� �� �ӿ� ��� �ִ�. ������� ���꿡�� ���ϰ� �ִ� ���� �鼳 ���ִ� �Ҽ� ��Ʈ��ũ�� �ϰ� �ִ�.
//���� ��ħ ������� �� �ٷ� ���Ķ��� �Ҹ� �������� ����Ѵ�. �鼳 ���ִ� �� �ֺ��� ���ƴٴϸ鼭 ������ �� �Ҽ� ��Ʈ��ũ�� ���ε��Ѵ�.
//������� ���꿡 ����, �鼳 ���ִ� �ٽ� ������ ���ư��� ���� ���� �߿� ���ε� �� ���� ������ �����Ѵ�. ������ ������� ��� ���ڸ� ���� ������ ������ ������ �� C ������ �ִ�. ������ ���� ������� ���� �ִ� ������ ���� �� ���ݺ��� ���� ���� ���� ���̶�� ���� �����̴�. ��, ������ ������� K�� �����ְ�, K/2���� ���� ������� ���� ���� ���ٸ� ���� �����̴�.
//�鼳 ���ְ� ���� ���� M���� �� ������ ���� ������� �־����� ��, ���� �������� �ƴ����� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�.
//* C/C++ �ַ���� ���� �ڵ带 �����Ͻÿ�.
// 
//#include <stdio.h>
//#include <malloc.h>
//int N;//�������
//int C;//���ڻ����
//int A[300010];
//int M;//������
//struct st{
//      int c, cnt;//�����ȣ, ����
//};
//st tree[1 << 20];
//int * num[10010];
//int count[10010];
//void input_data(){
//      register int i, k;
//      scanf("%d %d", &N, &C);
//      for (i = 1; i <= N; i++){
//            scanf("%d", &A[i]);
//            count[A[i]]++;
//      }
//      for (i = 1; i <= C; i++){
//            num[i] = (int *)malloc(count[i] * sizeof(int));
//            count[i] = 0;
//      }
//      for (i = 1; i <= N; i++){
//            k = A[i];
//            num[k][count[k]++] = i;
//      }
//}
//void build(int node, int s, int e){
//      if (s == e){
//            tree[node] = { A[s], 1 };
//            return;
//      }
//      build(node * 2, s, (s + e) / 2);
//      build(node * 2 + 1, (s + e) / 2 + 1, e);
//      st L = tree[node * 2], R = tree[node * 2 + 1];
//      if (L.c == R.c){
//            tree[node] = { L.c, L.cnt + R.cnt };
//      }
//      else{
//            if (L.cnt > R.cnt){
//                  tree[node] = { L.c, L.cnt - R.cnt };
//            }
//            else{
//                  tree[node] = { R.c, R.cnt - L.cnt };
//            }
//      }
//}
//st query(int node, int s, int e, int qs, int qe){
//      st ret = { 0, 0 };
//      if ((qe < s) || (e < qs)) return ret;
//      if ((qs <= s) && (e <= qe)){
//            return tree[node];
//      }
//      st L = query(node * 2, s, (s + e) / 2, qs, qe);
//      st R = query(node * 2 + 1, (s + e) / 2 + 1, e, qs, qe);
//      if (L.c == R.c){
//            ret = { L.c, L.cnt + R.cnt };
//      }
//      else{
//            if (L.cnt > R.cnt) ret = { L.c, L.cnt - R.cnt};
//            else ret = { R.c, R.cnt - L.cnt};
//      }
//      return ret;
//}
//int bs_up(int * num, int s, int e, int d){
//      register int m, sol = 0;
//      while (s <= e){
//            m = (s + e) / 2;
//            if (num[m] <= d){
//                  sol = m; s = m + 1;
//            }
//            else e = m - 1;
//      }
//      return sol;
//}
//int bs_low(int * num, int s, int e, int d){
//      register int m, sol = 0;
//      while (s <= e){
//            m = (s + e) / 2;
//            if (num[m] >= d){
//                  sol = m; e = m - 1;
//            }
//            else s = m + 1;
//      }
//      return sol;
//}
//void solve(){
//      register int i, cnt;
//      st color;
//      int A, B;
//      scanf("%d", &M);
//      for (i = 1; i <= M; i++){
//            scanf("%d %d", &A, &B);
//            color = query(1, 1, N, A, B);
//            cnt = bs_up(num[color.c], 0, count[color.c]-1, B);
//            cnt -= bs_low(num[color.c], 0, count[color.c]-1, A);
//            if ((B - A + 1) < ((cnt + 1) * 2)) printf("yes %d\n", color.c);
//            else printf("no\n");
//      }
//}
//int main(){
//      input_data();
//      build(1, 1, N);
//      solve();
//      return 0;
//}
//�Է�
// ù° �ٿ� ������� �� N�� ���� ������ �� C�� �־�����. (3 �� N �� 300,000, 1 �� C �� 10,000)
//
//��° �ٿ��� ������ ������� ���� �ִ� ������ ������ ������� �־�����.
//��° �ٿ��� ������ �� M�� �־�����. (1 �� M �� 10,000)
//���� M�� �ٿ��� �� ���� A�� B�� �־�����. (1 �� A �� B �� N) �� ���� ������ ������ �ǹ��ϰ�, A��° ��������� B��° ��������� ������ �����ٴ� ���̴�.
//���
// ����� �� M ���̴�. �� ������ ������ �ʴٸ� "no"�� ����ϰ�, ���ڴٸ� "yes X"�� ����Ѵ�. ���� ������ ��쿡 X�� ������ ������ �Ѵ� ������ �����̴�.
//
//�Է� ����
//10 3
//1 2 1 2 1 2 3 2 3 3
//8
//1 2
//1 3
//1 4
//1 5
//2 5
//2 6
//6 9
//7 10
//��� ����
//no
//yes 1
//no
//yes 1
//no
//yes 2
//no
//yes 3
//����
// 
//
//* JAVA �ַ���� ���� �ڵ带 �����Ͻÿ�.
// 
import java.util.Scanner;
 
public class Main_�鼳 {
      static Scanner sc;
      static int N;//�������
      static int C;//���ڻ����
      static int A[];
      static int M;//������
      static class st{
            int c, cnt;//�����ȣ, ����
            st(int c, int cnt){
                  this.c=c; this.cnt=cnt;
            }
      };
      static st tree[] = new st [1<<20];
      static int num[][];
      static int count[];
      static void input_data(){
            int i;
            N = sc.nextInt(); C = sc.nextInt();
            A = new int [N+1]; count = new int [C+1];
            for (i = 1; i <= N; i++){
                  A[i] = sc.nextInt();
                  count[A[i]]++;
            }
            num = new int [C+1][];
            for(i = 1; i<= C; i++){
                  num[i] = new int [count[i]];
                  count[i] = 0;
            }
            for(i=1;i<=N;i++){
                  num[A[i]][count[A[i]]++] = i;
            }
      }
      static void build(int node, int s, int e){
            if (s == e){
                  tree[node] = new st ( A[s], 1 );
                  return;
            }
            build(node * 2, s, (s + e) / 2);
            build(node * 2 + 1, (s + e) / 2 + 1, e);
            st L = tree[node * 2], R = tree[node * 2 + 1];
            if (L.c == R.c){
                  tree[node] = new st( L.c, L.cnt + R.cnt );
            }
            else{
                  if (L.cnt > R.cnt){
                        tree[node] = new st ( L.c, L.cnt - R.cnt );
                  }
                  else{
                        tree[node] = new st ( R.c, R.cnt - L.cnt );
                  }
            }
      }
      static st query(int node, int s, int e, int qs, int qe){
            st ret = new st( 0, 0 );
            if ((qe < s) || (e < qs)) return ret;
            if ((qs <= s) && (e <= qe)){
                  return tree[node];
            }
            st L = query(node * 2, s, (s + e) / 2, qs, qe);
            st R = query(node * 2 + 1, (s + e) / 2 + 1, e, qs, qe);
            if (L.c == R.c){
                  ret = new st( L.c, L.cnt + R.cnt );
            }
            else{
                  if (L.cnt > R.cnt) ret = new st( L.c, L.cnt - R.cnt);
                  else ret = new st( R.c, R.cnt - L.cnt);
            }
            return ret;
      }
      static int bs_up(int num[], int s, int e, int d){
            int m, sol = 0;
            while (s <= e){
                  m = (s + e) / 2;
                  if (num[m] <= d){
                        sol = m; s = m + 1;
                  }
                  else e = m - 1;
            }
            return sol;
      }
      static int bs_low(int num[], int s, int e, int d){
            int m, sol = 0;
            while (s <= e){
                  m = (s + e) / 2;
                  if (num[m] >= d){
                        sol = m; e = m - 1;
                  }
                  else s = m + 1;
            }
            return sol;
      }
      static void solve(){
            int i, cnt;
            st color;
            int A, B;
            M = sc.nextInt();
            for (i = 1; i <= M; i++){
                  A = sc.nextInt(); B = sc.nextInt();
                  color = query(1, 1, N, A, B);
                  cnt = bs_up(num[color.c], 0, count[color.c]-1, B);
                  cnt -= bs_low(num[color.c], 0, count[color.c]-1, A);
                  if ((B - A + 1) < ((cnt + 1) * 2)) System.out.println("yes " + color.c);
                  else System.out.println("no");
            }
      }
      public static void main(String[] args) {
            sc = new Scanner(System.in);
            input_data();
            build(1, 1, N);
            solve();
            sc.close();
      }
}