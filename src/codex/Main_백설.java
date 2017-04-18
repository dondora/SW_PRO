package codex;
//문제 번호 B: [SOL] 백설 공주
//시간 제한: 1 Sec  메모리 제한: 128 MB
//제출: 10  해결 문제 수: 5
//[제출]
//문제 설명
//백설 공주와 N명의 드워프가 숲 속에 살고 있다. 드워프가 광산에서 일하고 있는 동안 백설 공주는 소셜 네트워크를 하고 있다.
//매일 아침 드워프는 한 줄로 휘파람을 불며 광산으로 출근한다. 백설 공주는 그 주변을 돌아다니면서 사진을 찍어서 소셜 네트워크에 업로드한다.
//드워프가 광산에 들어가면, 백설 공주는 다시 집으로 돌아가서 찍은 사진 중에 업로드 할 예쁜 사진을 선택한다. 각각의 드워프는 모두 모자를 쓰고 있으며 모자의 색상은 총 C 가지가 있다. 사진에 찍힌 드워프가 쓰고 있는 모자의 색상 중 절반보다 많은 색이 같은 색이라면 예쁜 사진이다. 즉, 사진에 드워프가 K명 찍혀있고, K/2보다 많은 드워프의 모자 색이 같다면 예쁜 사진이다.
//백설 공주가 찍은 사진 M개와 각 사진에 찍힌 드워프가 주어졌을 때, 예쁜 사진인지 아닌지를 알아내는 프로그램을 작성하시오.
//* C/C++ 솔루션은 다음 코드를 참조하시오.
// 
//#include <stdio.h>
//#include <malloc.h>
//int N;//드워프수
//int C;//모자색상수
//int A[300010];
//int M;//사진수
//struct st{
//      int c, cnt;//색상번호, 개수
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
//입력
// 첫째 줄에 드워프의 수 N과 모자 색상의 수 C가 주어진다. (3 ≤ N ≤ 300,000, 1 ≤ C ≤ 10,000)
//
//둘째 줄에는 각각의 드워프가 쓰고 있는 모자의 색상이 순서대로 주어진다.
//셋째 줄에는 사진의 수 M이 주어진다. (1 ≤ M ≤ 10,000)
//다음 M개 줄에는 두 정수 A와 B가 주어진다. (1 ≤ A ≤ B ≤ N) 이 줄은 사진의 정보를 의미하고, A번째 드워프부터 B번째 드워프까지 사진에 찍혔다는 뜻이다.
//출력
// 출력은 총 M 줄이다. 각 사진이 예쁘지 않다면 "no"를 출력하고, 예쁘다면 "yes X"를 출력한다. 예쁜 사진인 경우에 X는 사진에 절반이 넘는 모자의 색상이다.
//
//입력 예시
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
//출력 예시
//no
//yes 1
//no
//yes 1
//no
//yes 2
//no
//yes 3
//도움말
// 
//
//* JAVA 솔루션은 다음 코드를 참조하시오.
// 
import java.util.Scanner;
 
public class Main_백설 {
      static Scanner sc;
      static int N;//드워프수
      static int C;//모자색상수
      static int A[];
      static int M;//사진수
      static class st{
            int c, cnt;//색상번호, 개수
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