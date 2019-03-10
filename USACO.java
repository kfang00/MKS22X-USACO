import java.util.*;
import java.io.*;

public class USACO {

  public static int bronze(String filename) {
    int[][] pasture, moves;
    int[] i1 = new int[4];
    File f = new File(filename);
    Scanner in = new Scanner(f);
    for (int a = 0; a < 4; a++) {
      i1[a] = Integer.parseInt(in.next());
    }
    pasture = new int[i1[0]][i1[1]];
    for (int b = 0; b < i1[0]; b++) {
      for (int c = 0; c < i1[1]; c++) {
        pasture[b][c] = Integer.parseInt(in.next());
      }
    }
    moves = new int[i1[3]][3];
    for (int d = 0; d < i1[3]; d++) {
      for (int e = 0; e < 3; e++) {
        pasture[d][e] = Integer.parseInt(in.next());
      }
    }
    System.out.println(toString(pasture));
    System.out.println(toString(moves));
    return 0;
  }

  public static int silver(String filename) {

  }

  public static String toString(int[][] arr) {
    String s = "";
    for (int d = 0; d < arr.length; d++) {
      for (int e = 0; e < arr[0].length; e++) {
	s += arr[d][e] + " ";
      }
      s += "\n";
    }
    return s;
  }
}
