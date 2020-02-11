import java.util.Arrays;

public class SelectionSort {
  private int[] data;
  
  public SelectionSort(int[] data) {
    this.data = data;
  }
  
  public void sort() {
    int[] temp = new int[data.length];
    for(int i=0; i<data.length; i++) {
      int lowest = data[0];
      int lowestIndex = 0;
      for(int j=0; j<data.length-i; j++) {
        if(lowest>=data[j]) {
          lowest = data[j];
          lowestIndex = j;
        }
      }
      temp[i] = lowest;
      for(int k=lowestIndex; k<data.length-i; k++) {
        if(k==data.length-i-1) {
          data[k] = 0;
        }
        else {
          data[k] = data[k+1];
        }
      }
    }
    data = temp;
  }
  
  public int[] getData() {
    return data;
  }
  
  public static void main(String[] args) {
    SelectionSort ss = new SelectionSort(new int[] {10, 7, 78, 4, 45, 32, 2, 11});
    System.out.println(Arrays.toString(ss.getData()));
    ss.sort();
    System.out.println(Arrays.toString(ss.getData()));
  }
}
