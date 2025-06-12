import java.io.*;
import java.util.*;

class Main_14940
{
  static int n, m;
  static int[][] map;

  static int startX, startY;

  public static void main(String[] args) throws IOException
  {
    init();
    process();
  }

  // 입력
  static void init() throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new int[n][m];

    for(int i = 0; i < n; i++)
    {
      st = new StringTokenizer(br.readLine());

      for(int j = 0; j < m; j++)
      {
        int code = Integer.parseInt(st.nextToken());

        map[i][j] = code;

        if(code == 2)
        {
          startX = i;
          startY = j;
        }
      }
    }
  }

  // 문제 풀이
  static void process()
  {
    int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] answer = new int[n][m];
    boolean[][] visited = new boolean[n][m];

    visited[startX][startY] = true;

    ArrayDeque<Integer> queue = new ArrayDeque<>();

    queue.add(startX);
    queue.add(startY);
    queue.add(0);

    while(!queue.isEmpty())
    {
      int x = queue.poll();
      int y = queue.poll();
      int distance = queue.poll();

      for(int i = 0; i < 4; i++)
      {
        int nx = x + DIR[i][0];
        int ny = y + DIR[i][1];

        if(nx < 0 || ny < 0 || nx >= n || ny >= m)
          continue;

        if(map[nx][ny] == 0)
          continue;

        if(visited[nx][ny])
          continue;

        visited[nx][ny] = true;
        answer[nx][ny] = distance + 1;

        queue.add(nx);
        queue.add(ny);
        queue.add(distance + 1);
      }
    }

    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < n; i++)
    {
      for(int j = 0; j < m; j++)
      {
        sb.append(answer[i][j]).append(' ');
      }
      sb.append('\n');
    }

    System.out.println(sb);
  }
}