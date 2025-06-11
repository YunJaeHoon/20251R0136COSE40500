import java.io.*;
import java.util.*;

class Main_16928
{
  static int N, M;
  static Map<Integer, Integer> ladder = new HashMap<>();
  static Map<Integer, Integer> snake = new HashMap<>();

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

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for(int i = 0; i < N; i++)
    {
      st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      ladder.put(x, y);
    }

    for(int i = 0; i < M; i++)
    {
      st = new StringTokenizer(br.readLine());

      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      snake.put(u, v);
    }
  }

  // 문제 풀이
  static void process()
  {
    int[] count = new int[101];

    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(1);

    while(!queue.isEmpty())
    {
      int num = queue.poll();

      for(int i = 1; i <= 6; i++)
      {
        int next = num + i;

        if(next > 100)
          next = 100;

        if(ladder.containsKey(next)) {
          next = ladder.get(next);
        }

        if(snake.containsKey(next)) {
          next = snake.get(next);
        }

        if(count[next] == 0) {
          count[next] = count[num] + 1;
          queue.add(next);
        }
      }
    }

    System.out.println(count[100]);
  }
}
