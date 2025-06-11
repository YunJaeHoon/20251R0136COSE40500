import java.io.*;
import java.util.*;

class Main_2138
{
  static int N;
  static char[] original, target;

  public static void main(String[] args) throws IOException
  {
    init();
    process();
  }

  // 입력
  static void init() throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    original = new char[N];
    target = new char[N];

    original = br.readLine().toCharArray();
    target = br.readLine().toCharArray();
  }

  // 문제 풀이
  static void process()
  {
    char[] a = original.clone();
    char[] b = original.clone();

    b[0] = (b[0] == '0') ? '1' : '0';
    b[1] = (b[1] == '0') ? '1' : '0';

    int countA = 0, countB = 1;

    for(int i = 1; i < N; i++)
    {
      if(a[i - 1] != target[i - 1])
      {
        countA++;

        a[i - 1] = (a[i - 1] == '0') ? '1' : '0';
        a[i] = (a[i] == '0') ? '1' : '0';

        if(i < N - 1)
          a[i + 1] = (a[i + 1] == '0') ? '1' : '0';
      }

      if(b[i - 1] != target[i - 1])
      {
        countB++;

        b[i - 1] = (b[i - 1] == '0') ? '1' : '0';
        b[i] = (b[i] == '0') ? '1' : '0';

        if(i < N - 1)
          b[i + 1] = (b[i + 1] == '0') ? '1' : '0';
      }
    }

    if(target[N - 1] != a[N - 1] && target[N - 1] != b[N - 1])
      System.out.println(-1);
    else if(target[N - 1] == a[N - 1] && target[N - 1] != b[N - 1])
      System.out.println(countA);
    else if(target[N - 1] != a[N - 1] && target[N - 1] == b[N - 1])
      System.out.println(countB);
    else
      System.out.println(Math.min(countA, countB));
  }
}