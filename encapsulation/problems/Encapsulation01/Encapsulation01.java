package galvanize;

import encapsulation01_lib.Proposal;

public class Encapsulation01 {
  public static void main(String[] args){
    Proposal prop = new Proposal();
    prop.name = "Some thing";
    System.out.println(prop.name);

    prop.allInFavor = 24;
    System.out.println(prop.allInFavor);
    prop.allAgainst = 12;
    System.out.println(prop.allAgainst);
  }
}
