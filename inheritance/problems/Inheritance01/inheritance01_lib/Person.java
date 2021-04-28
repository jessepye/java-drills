package inheritance01_lib;

public class Person {
  public void printName(String first, String last) {
    System.out.println(first + " " + last);
  }
  public void printName(String f, String m, String l) { System.out.println(f + " " + m + " " + l); }
  public void printName(String f, String l, Boolean lastFirst) { System.out.println(l + ", " + f); }
}
