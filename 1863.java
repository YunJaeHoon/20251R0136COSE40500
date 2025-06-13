import java.io.*;
import java.util.*;

class Main_1863
{
  static int n;
  static int[][] skyline;

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
    skyline = new int[n + 1][2];
    skyline[0][1] = 0;

    for(int i = 1; i <= n; i++)
    {
      st = new StringTokenizer(br.readLine());

      skyline[i][0] = Integer.parseInt(st.nextToken());
      skyline[i][1] = Integer.parseInt(st.nextToken());
    }
  }

  // 문제 풀이
  static void process()
  {
    int answer = 0;
    boolean[] visited = new boolean[500005];
    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
      return b - a;
    });

    for(int i = 1; i <= n; i++)
    {
      if(skyline[i - 1][1] > skyline[i][1])
      {
        while(!queue.isEmpty())
        {
          if(queue.peek() <= skyline[i][1]) {
            break;
          }

          int n = queue.poll();
          visited[n] = false;
        }
      }
      
      if(!visited[skyline[i][1]] && skyline[i][1] != 0)
      {
        visited[skyline[i][1]] = true;
        answer++;
        queue.add(skyline[i][1]);
      }
    }

    System.out.println(answer);
  }
}