import java.util.Arrays;

public class QuickSort {
  int[] data;
  
  public QuickSort(int[] data) {
    this.data = data;
  }
  
  public int partition(int[] data, int left, int right) {
    int pivotPoint = left + (right-left)/2;
    int pivot = data[pivotPoint];
    boolean done = false;
    
    int leftPos = left;
    int rightPos = right;
    
    while(!done) {
      while(data[leftPos]<pivot) {
        leftPos++;
      }
      while(data[rightPos]>pivot) {
        rightPos--;
      }
      
      if(leftPos >= rightPos) {
        done=true;
      }
      else {
        int temp = data[leftPos];
        data[leftPos] = data[rightPos];
        data[rightPos] = temp;
        leftPos++;
        rightPos--;
      }
    }
    return rightPos;
  }
  
  public void quicksort(int[] data, int left, int right) {
    if(left>=right) {
      return;
    }
    
    int middle = partition(data, left, right);
    quicksort(data, left, middle);
    quicksort(data, middle+1, right);
  }
  
  public int[] getData() {
    return data;
  }
  
  public static void main(String[] args) {
    QuickSort qs = new QuickSort(new int[] {10, 7, 78, 4, 45, 32, 2, 11});
    System.out.println(Arrays.toString(qs.getData()));
    qs.quicksort(qs.getData(), 0, 7);
    System.out.println(Arrays.toString(qs.getData()));
  }
}
