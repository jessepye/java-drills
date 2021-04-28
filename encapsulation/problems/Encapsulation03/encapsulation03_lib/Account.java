package encapsulation03_lib;

public class Account {
  private int balance = 0;

  public int balance() {
    return balance;
  }

  public void deposit(int amount) {
    balance += amount;
  }

  public void withdraw(int amount) {
    balance -= amount;
  }
}
