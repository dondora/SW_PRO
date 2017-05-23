
ó�� ȭ��	���� ����	����	ä�� ��Ȳ ����
"�̶��޾��̾ؾ� PRO��� 5�� ���ǰ��" 5��22��(��) 18:00 ~ 5��23��(ȭ) 06:00 , ���� �ڵ� ����, 5��23��(ȭ) 09:00~24:00
���� ��ȣ B: [SOL] ��������
�ð� ����: 1 Sec  �޸� ����: 128 MB
����: 5  �ذ� ���� ��: 3
[����]
���� ����
����� ���� ������ �����. ���� ������ N*M ũ���̰� 1*1ũ���� ���簢������ �������� �ִ�. ���� ������ �� ĭ�� �ٴ��̰ų� ���� �Ϻ��̴�. �׸���, �������� ������ ����ŷ�� ��ġ�� �ִ�. ���������� ����� ��ġ�� ������ ǥ���ߴ�.
���� ����� ������ ������ ���� ��θ� ���ؾ� �Ѵ�. ��δ� ���� ��� ��ġ���� ���۵Ǿ�� �ϰ�, ������ ��ġ���� ������ �Ѵ�. �Ź� ����� �̵��� ���� �����¿� �� �� �������� �̵��ؾ� �ϰ�, ������ ���� �� �ȴ�. ������, ����ŷ�� ��Ű� ���� ������� �̵��� ���̹Ƿ�, ����ŷ�� �����ؾ� �Ѵ�. �Ź� ����� �̵��� �Ŀ�, ����ŷ�� ����� �̵��� ���ؼ� �̵��� �� ���������� ������ �� �ִ�. ����� �����Ӱ� ����ŷ�� ������ ���̶� �θ���, �� ���� ���� �Ŀ� ������ ���� 2���� ������� Ȯ���� �� �ִ�.
1.    ����, ����� ����ŷ�� �ٶ󺸰� �ִٸ�(����ŷ�� ������, ���򼱻� ����� �ְ�, ���� �� ���̿� �ٴٸ� ���� ��) ����� �״´�.
2.    ����, ����� ���� ���� �ʾҰ�, ���� ��ġ�� �ִٸ� ����� ������ ���� ���̴�.
 
����ŷ�� ��� �����̰� ������� ����� ���� �ʰ� ������ ���� �� �ִ� ��θ� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
* C �ַ���� ���� �ڵ带 �����Ͻÿ�.
 
#include <stdio.h>
int N;//����ũ��
int M;//����ũ��
char map[710][710];//��������
int visit[710][710];
int limith[710][710];
int limitc[710][710];
struct st{
      int r, c;
};
struct st queue[710 * 710];
int wp, rp;
int tr, tc;//������ġ
int rr[] = { -1, 1, 0, 0 };
int cc[] = { 0, 0, -1, 1 };
int MIN(int a, int b){
      return (a < b) ? a : b;
}
void enqueue(int r, int c){
      queue[wp].r = r; queue[wp++].c = c;
}
void input_data(void){
      scanf("%d %d", &N, &M);
      for (int i = 1; i <= N; i++){
            scanf("%s", &map[i][1]);
      }
}
void BFS_Viking(int vr, int vc){
      for (int i = 1; i <= N; i++){
            for (int j = 1; j <= M; j++){
                  visit[i][j] = 1 << 30;
            }
      }
      wp = rp = 0;
      enqueue(vr, vc);
      visit[vr][vc] = 0;
      while (rp < wp){
            struct st d = queue[rp++];
            for (int i = 0; i < 4; i++){
                  vr = d.r + rr[i]; vc = d.c + cc[i];
                  if (map[vr][vc] != '.') continue;
                  if (visit[vr][vc] <= visit[d.r][d.c] + 1) continue;
                  enqueue(vr, vc);
                  visit[vr][vc] = visit[d.r][d.c] + 1;
            }
      }
}
void update_limit(void){
      for (int i = 1; i <= N; i++){
            limith[i][1] = visit[i][1];
            for (int j = 2; j <= M; j++){
                  if (map[i][j] == 'I') limith[i][j] = 1 << 30;
                  else limith[i][j] = MIN(visit[i][j], limith[i][j - 1]);
            }
            for (int j = M - 1; j > 0; j--){
                  if (map[i][j] != 'I') limith[i][j] = MIN(limith[i][j], limith[i][j + 1]);
            }
      }
      for (int j = 1; j <= M; j++){
            limitc[1][j] = visit[1][j];
            for (int i = 2; i <= N; i++){
                  if (map[i][j] == 'I') limitc[i][j] = 1 << 30;
                  else limitc[i][j] = MIN(visit[i][j], limitc[i - 1][j]);
            }
            for (int i = N - 1; i > 0; i--){
                  if (map[i][j] != 'I') limitc[i][j] = MIN(limitc[i][j], limitc[i + 1][j]);
            }
      }
      for (int i = 1; i <= N; i++){
            for (int j = 1; j <= M; j++){
                  if (limith[i][j] > limitc[i][j]) limith[i][j] = limitc[i][j];
            }
      }
}
int BFS(int sr, int sc){
      for (int i = 1; i <= N; i++){
            for (int j = 1; j <= M; j++){
                  visit[i][j] = 1 << 30;
            }
      }
      wp = rp = 0;
      enqueue(sr, sc);
      visit[sr][sc] = 0;
      while (rp < wp){
            struct st d = queue[rp++];
            for (int i = 0; i < 4; i++){
                  sr = d.r + rr[i]; sc = d.c + cc[i];
                  if (map[sr][sc] != '.') continue;
                  if (limith[sr][sc] <= visit[d.r][d.c] + 1) continue;
                  if (visit[sr][sc] <= visit[d.r][d.c] + 1) continue;
                  if ((sr == tr) && (sc == tc)) return 1;//����
                  enqueue(sr, sc);
                  visit[sr][sc] = visit[d.r][d.c] + 1;
            }
      }
      return -1;//����
}
int solve(void){
      int vr = 0, vc = 0, sr = 0, sc = 0;
      for (int i = 1; i <= N; i++){
            for (int j = 1; j <= M; j++){
                  if (map[i][j] == 'Y'){//����ġ
                        sr = i; sc = j;
                        map[i][j] = '.';
                  }
                  else if (map[i][j] == 'V'){//����ŷ��ġ
                        vr = i; vc = j;
                        map[i][j] = '.';
                  }
                  else if (map[i][j] == 'T'){//������ġ
                        tr = i; tc = j;
                        map[i][j] = '.';
                  }
            }
      }
      BFS_Viking(vr, vc);
      update_limit();
      return BFS(sr, sc);
}
int main(void){
      input_data();
      int ans = solve();
      if (ans == 1) printf("YES\n");
      else printf("NO\n");
      return 0;
}
�Է�
ù ��° �ٿ��� N�� M�� �������� ���еǾ� �Էµȴ�.
�� ��° �ٺ��� N���� �ٿ� ���� ������ �Էµȴ�. �� ���� M���� ���ڷ� �����Ǿ� �ִµ�, ��.���� �ٴ��̰� ��I���� ���̰�, ��V���� ����ŷ�� ��ġ�̰�, ��Y���� ���� ����� ��ġ�̰�, ��T���� ������ ��ġ�̴�. ��V��, ��Y��, ��T���� ��� �� ������ �����Ѵ�. (1��N,M��700)
���
����� ������ ���� �� ������ ��YES���� ����ϰ�, �׷��� ������ ��NO���� ����Ѵ�.

�Է� ����
5 7
Y.....V
..I....
..IIIII
.......
...T...
��� ����
YES
����
* JAVA �ַ���� ���� �ڵ带 �����Ͻÿ�.
 
import java.util.Scanner;
 
 
public class Main {
      static int N;//����ũ��
      static int M;//����ũ��
      static char map[][];//��������
      static int visit[][];
      static int limith[][];
      static int limitc[][];
      static class Q{
            int r, c;
            Q(int r, int c){
                  this.r=r; this.c=c;
            }
      };
      static Q queue[];
      static int wp, rp;
      static int tr, tc;//������ġ
      static int rr[] = { -1, 1, 0, 0 };
      static int cc[] = { 0, 0, -1, 1 };
      public static void main(String[] args) {
            input_data();
            int ans = solve();
            if (ans == 1) System.out.println("YES");
            else System.out.println("NO\n");
      }
      static int solve(){
            int vr = 0, vc = 0, sr = 0, sc = 0;
            visit = new int [N+2][M+2];
            limith = new int [N+2][M+2];
            limitc = new int [N+2][M+2];
            queue = new Q [N*M];
            for (int i = 1; i <= N; i++){
                  for (int j = 1; j <= M; j++){
                        if (map[i][j] == 'Y'){//����ġ
                             sr = i; sc = j;
                             map[i][j] = '.';
                        }
                        else if (map[i][j] == 'V'){//����ŷ��ġ
                             vr = i; vc = j;
                             map[i][j] = '.';
                        }
                        else if (map[i][j] == 'T'){//������ġ
                             tr = i; tc = j;
                             map[i][j] = '.';
                        }
                  }
            }
            BFS_Viking(vr, vc);
            update_limit();
            return BFS(sr, sc);
      }
      static int MIN(int a, int b){
            return (a < b) ? a : b;
      }
      static void input_data(){
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt(); M = sc.nextInt();
            map = new char [N+2][M+2];
            for (int i = 1; i <= N; i++) map[i] = ("\0" + sc.next() + "\0").toCharArray();
            sc.close();
      }
      static void BFS_Viking(int vr, int vc){
            for (int i = 1; i <= N; i++){
                  for (int j = 1; j <= M; j++){
                        visit[i][j] = 1 << 30;
                  }
            }
            wp = rp = 0;
            queue[wp++] = new Q(vr, vc);
            visit[vr][vc] = 0;
            while (rp < wp){
                  Q d = queue[rp++];
                  for (int i = 0; i < 4; i++){
                        vr = d.r + rr[i]; vc = d.c + cc[i];
                        if (map[vr][vc] != '.') continue;
                        if (visit[vr][vc] <= visit[d.r][d.c] + 1) continue;
                        queue[wp++] = new Q(vr, vc);
                        visit[vr][vc] = visit[d.r][d.c] + 1;
                  }
            }
      }
      static void update_limit(){
            for (int i = 1; i <= N; i++){
                  limith[i][1] = visit[i][1];
                  for (int j = 2; j <= M; j++){
                        if (map[i][j] == 'I') limith[i][j] = 1 << 30;
                        else limith[i][j] = MIN(visit[i][j], limith[i][j - 1]);
                  }
                  for (int j = M - 1; j > 0; j--){
                        if (map[i][j] != 'I') limith[i][j] = MIN(limith[i][j], limith[i][j + 1]);
                  }
            }
            for (int j = 1; j <= M; j++){
                  limitc[1][j] = visit[1][j];
                  for (int i = 2; i <= N; i++){
                        if (map[i][j] == 'I') limitc[i][j] = 1 << 30;
                        else limitc[i][j] = MIN(visit[i][j], limitc[i - 1][j]);
                  }
                  for (int i = N - 1; i > 0; i--){
                        if (map[i][j] != 'I') limitc[i][j] = MIN(limitc[i][j], limitc[i + 1][j]);
                  }
            }
            for (int i = 1; i <= N; i++){
                  for (int j = 1; j <= M; j++){
                        if (limith[i][j] > limitc[i][j]) limith[i][j] = limitc[i][j];
                  }
            }
      }
      static int BFS(int sr, int sc){
            for (int i = 1; i <= N; i++){
                  for (int j = 1; j <= M; j++){
                        visit[i][j] = 1 << 30;
                  }
            }
            wp = rp = 0;
            queue[wp++] = new Q(sr, sc);
            visit[sr][sc] = 0;
            while (rp < wp){
                  Q d = queue[rp++];
                  for (int i = 0; i < 4; i++){
                        sr = d.r + rr[i]; sc = d.c + cc[i];
                        if (map[sr][sc] != '.') continue;
                        if (limith[sr][sc] <= visit[d.r][d.c] + 1) continue;
                        if (visit[sr][sc] <= visit[d.r][d.c] + 1) continue;
                        if ((sr == tr) && (sc == tc)) return 1;//����
                        queue[wp++] = new Q(sr, sc);
                        visit[sr][sc] = visit[d.r][d.c] + 1;
                  }
            }
            return -1;//����
      }
}
[����]


��� �� �н����� �ʱ�ȭ ��û
(��)���� (010-3342-9323, keyseek@naver.com)