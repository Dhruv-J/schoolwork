import java.util.Arrays;

public class InsertionSort {
  private int[] data;
  
  public InsertionSort(int[] data) {
    this.data = data;
  }
  
  public void sort() {
    for(int i=0; i<data.length; i++) {
      int partitionIndex = i;
      while(partitionIndex>0 && data[partitionIndex]<data[partitionIndex-1]) {
        int temp = data[partitionIndex];
        data[partitionIndex] = data[partitionIndex-1];
        data[partitionIndex-1] = temp;
        partitionIndex -= 1;
      }
    }
  }
  
  public int[] getData() {
    return data;
  }
  
  public static void main(String[] args) {
    InsertionSort is = new InsertionSort(new int[] {10, 7, 78, 4, 45, 32, 2, 11});
    System.out.println(Arrays.toString(is.getData()));
    is.sort();
    System.out.println(Arrays.toString(is.getData()));
  }
}
