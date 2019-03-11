import java.io.FileNotFoundException;

public class Driver {

  public static void main(String[] args) {
    try {
      System.out.println(USACO.bronze("makelake.5.in"));
      System.out.println(USACO.silver("ctravel.5.in"));
      System.out.println(USACO.silver("ctravel.3.in"));
    }
    catch(FileNotFoundException e){
      System.out.println("Invalid filename");
    }
  }
}