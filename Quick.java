import java.util.*;
public class Quick{
  public static int quickselect( int [] data, int k){
    if (k < 0 || k >= data.length){throw new IllegalArgumentException("kth smallest interger does not exist");}
    if (data.length == 1) {return data[0];}
    int[] oldBounds;
    int[] bounds = new int[]{0, data.length-1};
    while (true){
      oldBounds = new int[] {bounds[0],bounds[1]};
      bounds = partitionDutch(data, bounds[0], bounds[1]);
      if (k >= bounds[0] && k < bounds[1]) {return data[k];}
      else if (k < bounds[0]){bounds = new int[]{oldBounds[0], bounds[0]};}
      else {bounds = new int[] {bounds[1], oldBounds[1]};}
    }
  }
  public static void fillRandom(int[] data){
    Random r = new Random();
    int index = 0;
    for(int i = 0; i < data.length; i++){
      data[i] = i;
    }
    for (int i = 0; i < data.length; i++){
      int copy = data[i];
      int rand = r.nextInt(data.length);
      data[i] = data[rand];
      data[rand] = copy;
    }
  }
  public static void scramble(int[] data){ //scrambles array
    Random r = new Random();
    int index = 0;
    for (int i = 0; i < data.length; i++){
      int copy = data[i];
      int rand = r.nextInt(data.length);
      data[i] = data[rand];
      data[rand] = copy;
    }
  }
  public static void printArray(int[] data){
    String out = "[";
    for(int i = 0; i < data.length; i++){
      out+=data[i];
      if (i != data.length-1){
        out+=", ";
      }
    }
    System.out.println(out+"]");
  }
  public static int[] partitionDutch(int[] data,int lo, int hi){
    if (hi == lo) {return new int[]{lo,lo+1};}
    int[] out = new int[2];
    Random r = new Random();
    int pick = r.nextInt(hi - lo) + lo;

    int copy = data[lo];
    data[lo] = data[pick]; //swap with lowest
    data[pick] = copy;

    int lt = lo;int gt = hi; int v = data[lo];
    int i = lt;
    while (i != gt+1){
      if (data[i] == v){
        i++;
      }
      else if (data[i] < v){
        copy = data[i];
        data[i] = data[lt];
        data[lt] = copy;
        lt++;
        i++;
      }
      else if (data[i] > v){
        copy = data[i];
        data[i] = data[gt];
        data[gt] = copy;
        gt--;
      }
      //printArray(data);
    }
    out[0] = lt; out[1] = gt+1; //printArray(out);
    return out;
  }
  public void quicksort(int[] data){

  }

  public static void main(String[] args){
    data = new int[] {0};
    for (int i = 0; i < data.length; i++){System.out.println(quickselect(data, i));}
  }
}
