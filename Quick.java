import java.util.*;
public class Quick{
  public static int quickselect( int [] data, int k){
    if (k < 0 || k >= data.length){throw new IllegalArgumentException("kth smallest interger does not exist");}
    if (data.length == 1) {return data[0];}
    int[] bounds = new int[]{0, data.length-1};
    while (true){
      int[] oldBounds = new int[] {bounds[0],bounds[1]};
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
  public static void fillRandom(int[] data, int[] ary){
    Random r = new Random();
    int index = 0;
    for(int i = 0; i < data.length; i++){
      data[i] = i;
      ary[i] = i;
    }
    for (int i = 0; i < data.length; i++){
      int copy = data[i]; int copya = data[i];
      int rand = r.nextInt(data.length);
      data[i] = data[rand]; ary[i] = ary[rand];
      data[rand] = copy; ary[rand] = copya;
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
  public static int[] partitionDutch(int[] data,int lo, int hi){ //gt is the index after the duplicates
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
      if (data[i] == v){i++;}
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
    }
    out[0] = lt; out[1] = gt+1; //printArray(out);
    return out;
  }
  public static void quicksort(int[] data){
    quicksort(data, 0, data.length - 1);
  }
  public static void insertionSort(int[] ary,int lo, int hi){
		for (int i = lo+1; i < hi; i++){
			int orig = ary[i];
			int x = i-1;
			while(x >= lo && ary[x] > orig){
				ary[x+1] = ary[x];
				x--;
			}
			ary[x+1] = orig;
		}
  }
  public static void quicksort(int[] data, int lo, int hi){
    if (lo >= hi- 250){insertionSort(data,lo,hi+1); return;}
    int[] piv = partitionDutch(data, lo, hi);
    quicksort(data, lo, piv[0]-1);
    quicksort(data, piv[1], hi);
  }
  public static void mains(String[]args){
    int[] data = new int[] {1,2,3,45,5};
    printArray(data);
  }
  public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}



}
