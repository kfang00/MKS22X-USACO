import java.util.*;
import java.io.*;

public class USACO {

  public static int bronze(String filename) throws FileNotFoundException{
    int[][] pasture, moves;
    int[] i1 = new int[4];
    File ff = new File(filename);
    Scanner in = new Scanner(ff);
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
        moves[d][e] = Integer.parseInt(in.next());
      }
    }

    for (int f = 0; f < moves.length; f++) {
      int max = 0;
      for (int g = moves[f][0] - 1; g < moves[f][0] + 2; g++) {
        for (int h = moves[f][1] - 1; h < moves[f][1] + 2; h++) {
	  if (pasture[g][h] > max) {
	    max = pasture[g][h];
          }
        }
      }
      for (int j = moves[f][0] - 1; j < moves[f][0] + 2; j++) {
        for (int k = moves[f][1] - 1; k < moves[f][1] + 2; k++) {
	  if (pasture[j][k] > (max - moves[f][2])) {
	    pasture[j][k] = (max - moves[f][2]);
          }
        }
      }
    }
    int sum = 0;
    for (int m = 0; m < pasture.length; m++) {
      for (int n = 0; n < pasture[0].length; n++) {
	if (pasture[m][n] < i1[2]) {
	  pasture[m][n] = (i1[2] - pasture[m][n]);
	  sum += pasture[m][n];
	}
	else {
	  pasture[m][n] = 0;
	}
      }
    }
    return (sum * 72 * 72);
  }

  public static int silver(String filename) throws FileNotFoundException{
    String[][] pasture;
    int[] se = new int[4];
    int[] i1 = new int[3];
    String s = "";
    File ff = new File(filename);
    Scanner in = new Scanner(ff);
    for (int a = 0; a < 3; a++) {
      i1[a] = Integer.parseInt(in.next());
    }
    pasture = new String[i1[0]][i1[1]];
    for (int b = 0; b < i1[0]; b++) {
      s = in.next();
      for (int c = 0; c < s.length(); c++) {
        pasture[b][c] = s.charAt(c) + "";
      }
    }
    for (int d = 0; d < 4; d++) {
      se[d] = Integer.parseInt(in.next());
    }
    for (int e = 0; e < pasture.length; e++) {
      for (int f = 0; f < pasture[0].length; f++) {
        if (pasture[e][f].equals("*")) {
	  pasture[e][f] = "-1";
        }
	else {
	  pasture[e][f] = "0";
	}
      }
    }
    for (int g = 0; g < i1[2] + 1; g++) {
      pasture = updatePasture(pasture, g, se[0] - 1, se[1] - 1);
      //System.out.println(toStringS(pasture));
    }
    return Integer.parseInt(pasture[se[2] - 1][se[3] - 1]);
  }

  public static String[][] updatePasture(String[][] arr, int time, int startR, int startC) {
    String[][] hold = new String[arr.length][arr[0].length];
    if ((time == 0) && (isValid(arr, startR, startC))) {
      for (int e = 0; e < arr.length; e++) {
        for (int f = 0; f < arr[0].length; f++) {
          if (arr[e][f].equals("-1")) {
	    hold[e][f] = "-1";
          }
	  else {
	    hold[e][f] = "0";
	  }
        }
      }
      hold[startR][startC] = "1";
    }
    else {
      for (int a = 0; a < arr.length; a++) {
        for (int b = 0; b < arr[0].length; b++) {
	  if (arr[a][b].equals("-1")) {
	    hold[a][b] = "-1";
	  }
          else if (!arr[a][b].equals("0")) {
	    hold[a][b] = "0";
          }
          else {
	    hold[a][b] = addFour(arr, a, b) + "";
          }
        }
      }
    }
    return hold;
  }

  public static int addFour(String[][] ar, int r, int c) {
    int[][] moves = {{0, -1},{0, 1},{1, 0},{-1, 0}};
    int sum = 0;
    for (int a = 0; a < moves.length; a++) {
      if (isValid(ar, r + moves[a][0], c + moves[a][1])) {
	sum += Integer.parseInt(ar[r + moves[a][0]][c + moves[a][1]]);
      }
    }
    return sum;
  }

  public static boolean isValid(String[][] arr, int r, int c) {
    if ((r >= arr.length) || (c >= arr[0].length) || (r < 0) || (c < 0) || (arr[r][c].equals("-1"))) {
      return false;
    }
    return true;
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

  public static String toStringS(String[][] arr) {
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
