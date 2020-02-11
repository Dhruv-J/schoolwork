
public class Recursion {
  public int gcdFinder(int x, int y) {
    int gcdVal;
    if(x==y) {
      return x;
    }
    else if(x>y) {
      x -= y;
      return gcdFinder(x, y);
    }
    else {
      y -= x;
      return gcdFinder(x, y);
    }
  }
  
  public static void main(String[] args) {
    Recursion r = new Recursion();
    System.out.println(r.gcdFinder(7, 12382));
  }
}
