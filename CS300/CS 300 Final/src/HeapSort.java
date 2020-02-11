import java.util.Arrays;

public class HeapSort {
  private int[] data;
  
  public HeapSort(int[] data) {
    this.data=data;
  }
  
  public void heapify(int[] data, int length, int root) {
    int largest = root;
    int left = 2*root+1;
    int right = 2*root+2;
    
    if(left<length&&data[left]>data[root]) {
      largest = left;
    }
    if(right<length&&data[right]>data[largest]) {
      largest = right;
    }
    if(largest!=root) {
      int temp = data[root];
      data[root] = data[largest];
      data[largest] = temp;
      
      heapify(data, length, largest);
    }
  }
  
  public void heapsort(int arr[]) {
    int length = arr.length;
    
    for(int i=length/2-1; i>=0; i--) {
      heapify(arr, length, i);
    }
    
    for(int j=length-1; j>=0; j--) {
      int temp = data[0];
      data[0] = data[j];
      data[j] = temp;
      
      heapify(data, j, 0);
    }
  }
  
  public int[] getData() {
    return data;
  }
  
  public static void main(String[] args) {
    HeapSort hs = new HeapSort(new int[] {10, 7, 78, 4, 45, 32, 2, 11});
    System.out.println(Arrays.toString(hs.getData()));
    hs.heapsort(hs.getData());
    System.out.println(Arrays.toString(hs.getData()));
  }
}
