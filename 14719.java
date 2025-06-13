import java.io.*;
import java.util.*;

class Main_14719
{
  static int H, W;
  static int[] blocks;

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

    H = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());
    blocks = new int[W];

    st = new StringTokenizer(br.readLine());

    for(int i = 0; i < W; i++) {
      blocks[i] = Integer.parseInt(st.nextToken());
    }
  }

  // 문제 풀이
  static void process()
  {
    boolean[][] map = new boolean[W][H + 1];

    for(int i = 0; i < W; i++)
    {
      for(int j = 1; j <= H; j++)
      {
        if(j <= blocks[i]) {
          map[i][j] = true;
        } else {
          map[i][j] = false;
        }
      }
    }
 
    int answer = 0;

    for(int j = 1; j <= H; j++)
    {
      boolean isStart = false;
      int count = 0;

      for(int i = 0; i < W; i++)
      {
        if(map[i][j])
        {
          isStart = true;

          answer += count;
          count = 0;
        }
        else
        {
          if(isStart)
            count++;
        }
      }
    }

    System.out.println(answer);
  }
}