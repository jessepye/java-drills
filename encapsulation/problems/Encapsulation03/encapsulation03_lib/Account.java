package encapsulation03_lib;

public class Account {
  private int[] balance = new int[10];
  private int currentInsertionIndex = 0;

  public int balance() {
    int total = 0;
    for (int i = 0; i < currentInsertionIndex; i++) {
      total += balance[i];
    }
    return total;
  }

  public void deposit(int amount) {
    balance[currentInsertionIndex] = amount;
    currentInsertionIndex++;
  }

  public void withdraw(int amount) {
    balance[currentInsertionIndex] = -amount;
    currentInsertionIndex++;
  }
}
