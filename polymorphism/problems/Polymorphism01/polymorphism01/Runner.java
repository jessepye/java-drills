package polymorphism01;

public class Runner {
  public void run(Object o) {
    ((Importer) o).importData();
  }
}
