import java.io.FileNotFoundException;

public class Driver {

  public static void main(String[] args) {
    try {
      System.out.println(USACO.bronze("makelake.5.in"));
    }
    catch(FileNotFoundException e){
      System.out.println("Invalid filename");
    }
  }

}