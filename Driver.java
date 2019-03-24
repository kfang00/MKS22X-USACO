import java.io.FileNotFoundException;

public class Driver {

  public static void main(String[] args) {
    try {
      System.out.println(USACO.bronze("makelake.1.in"));
      System.out.println(USACO.bronze("makelake.2.in"));
      System.out.println(USACO.bronze("makelake.3.in"));
      System.out.println(USACO.bronze("makelake.4.in"));
      System.out.println(USACO.bronze("makelake.5.in"));
      System.out.println(USACO.silver("ctravel.1.in"));
      System.out.println(USACO.silver("ctravel.2.in"));
      System.out.println(USACO.silver("ctravel.3.in"));
      System.out.println(USACO.silver("ctravel.4.in"));
      System.out.println(USACO.silver("ctravel.5.in"));
    }
    catch(FileNotFoundException e){
      System.out.println("Invalid filename");
    }
  }
}