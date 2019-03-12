import java.util.*;
public class Quick{
 public static int quickselect( int [] data, int k){
    int pivPos = -1;
    int start = 0; int end = data.length - 1; Random r = new Random();
    while(pivPos != k){ int prevEnd = end; int prevStart = start;
      int pick = 0;
      if (start < end){pick = r.nextInt(end-start) + start;}
      else {return data[start];}
      int pivot = data[pick];
      //swap with the front
      int copy = data[start];
      data[start] = data[pick];
      data[pick] = copy;
      start++;

      while (start != end && start < end){
        if (data[start] > pivot){
          copy = data[end];
          data[end] = data[start];
          data[start] = copy;
          end--;
        }
        else if (data[start] <= pivot){
          start++;
        }
      }

      if (data[prevStart] > data[end]) { copy = data[end]; data[end] = data[prevStart]; data[prevStart] = copy;}
      else {copy = data[end - 1]; data[end-1] = data[prevStart]; data[prevStart] = copy; end--; start--;}
      pivPos = end;
      if (k < end){start = prevStart; end--;}
      if (k > end){end = prevEnd; start++;}
      //printArray(data);
    }
    return data[pivPos];
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
  public static void scramble(int[] data){
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
    if (hi == lo) {return new int[]{lo,lo};}
    int[] out = new int[2];
    Random r = new Random();
    int pick = r.nextInt(hi - lo) + lo;

    int copy = data[lo];
    data[lo] = data[pick]; //swap with lowest
    data[pick] = copy;

    int lt = lo+1;int gt = hi; int v = data[lo];
    int i = lt;
    while (i != gt){
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
      printArray(data);
    }

    out[0] = lt; out[1] = gt; printArray(out);
    return out;
  }
  public void quicksort(int[] data){

  }

  public static void main(String[] args){
    int[] data = new int[10];
    /*fillRandom(data);
    for (int i : data){
      System.out.print(i+" ");
    }
    System.out.println();
    int select = (int) Math.abs(Math.random() * data.length);
    System.out.println(select+":"+quickselect(data, select));
   */
    data = new int[] {1,2,3,3,3,3,3,4,5,6};
    scramble(data);
    partitionDutch(data,0,data.length - 1);
  }
}
