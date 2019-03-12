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
    data = new int[] {1,2,4,4,4,4,4,4,4,2,3,3,3,2,2,4,5,6,4,5,6,8,7,5,3,2,4,6,7,8,9,7,5,4,3,2,2,2,4,4,5,6,7};
    System.out.println("hi:"+quickselect(data,20));
  }
}
