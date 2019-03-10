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

  public static int silver(String filename) {
    return 0;
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
