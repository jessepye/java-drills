package galvanize;

import encapsulation02_lib.Proposal;

public class Encapsulation02 {
  public static void main(String[] args){
    Proposal prop = new Proposal();
    prop.setName("Some thing");
    System.out.println(prop.getName());
  }
}
