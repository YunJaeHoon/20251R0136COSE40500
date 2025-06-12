import java.io.*;
import java.util.*;

class Main_20437
{
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();

  static String W;
  static int K;

  public static void main(String[] args) throws IOException
  {
    int T = Integer.parseInt(br.readLine());

    for(int i = 0; i < T; i++)
    {
      init();
      process();
    }
    
    System.out.println(sb);
  }

  // 입력
  static void init() throws IOException
  {
    W = br.readLine();
    K = Integer.parseInt(br.readLine());
  }

  // 문제 풀이
  static void process()
  {
    ArrayList<Integer>[] appearance = new ArrayList[26];

    for(int i = 0; i < 26; i++) {
      appearance[i] = new ArrayList<>();
    }

    for(int i = 0; i < W.length(); i++) {
      appearance[W.charAt(i) - 'a'].add(i);
    }

    int maxSize = -1;

    for(int i = 0; i < 26; i++) {
      maxSize = Math.max(maxSize, appearance[i].size());
    }

    if(maxSize < K)
    {
      sb.append(-1).append('\n');
      return;
    }

    int minLength = 10005;
    int maxLength = -1;

    for(int i = 0; i < 26; i++)
    {
      if(appearance[i].size() < K)
        continue;

      for(int j = 0; j < appearance[i].size() - K + 1; j++)
      {
        int length = appearance[i].get(j + K - 1) - appearance[i].get(j);

        minLength = Math.min(minLength, length);
        maxLength = Math.max(maxLength, length);
      }
    }

    sb.append(minLength + 1).append(' ').append(maxLength + 1).append('\n');
  }
}