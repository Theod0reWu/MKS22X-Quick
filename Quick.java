import java.util.*;
public class Quick{
 public static int quickselect( int [] data, int k){
    int pivPos = k + 1;
    int start = 0; int end = data.length - 1; Random r = new Random();
    while(pivPos + 1 != k){ int prevEnd = end; int prevStart = start;
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
        else if (data[start] < pivot){
          start++;
        }
      }

      if (data[prevStart] > data[end]) { copy = data[end]; data[end] = data[prevStart]; data[prevStart] = copy;}
      else {copy = data[end - 1]; data[end-1] = data[prevStart]; data[prevStart] = copy; end--; start--;}
      pivPos = end;
      if (k-1 < end){start = prevStart; end--;}
      if (k-1 > end){end = prevEnd; start++;}
    }
    return data[pivPos];
  }
  public static void main(String[] args){
    int[] data = new int[300];
    for (int i = 0; i < 300; i++){
      data[299-i] = i+1;
    }
    System.out.println("(0)"+data[0]);
    System.out.println("(1)"+data[1]);
    for (int i = 0; i < 300; i++){
      System.out.println(i+": "+quickselect(data,i));
    }
  }
}
