public class Counter{
  private final String name;
  private int count;

  public Counter(String id){
    name = id;
  }

  public void increment(){
    counter++;
  }

  public int tally(){return count;}

  public String toString(){return count + " "+ name;}
  
}
