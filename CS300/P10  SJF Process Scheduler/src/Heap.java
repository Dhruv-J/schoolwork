import java.util.Arrays;

public class Heap {
  private final int INITIAL_CAPACITY = 20;
  private int[] data;
  private int size;
  
  public Heap() {
    //data = new int[INITIAL_CAPACITY];
    data = new int[] {10, 90, 80, 70, 40, 30, 20};
    size = data.length;
  }
  
  public void maxHeapPercolateUp(int node) {
    int child = node;
    int parent = (node-1)/2;
    while(parent>=0&&data[child]>data[parent]) {
      int temp = data[child];
      data[child] = data[parent];
      data[parent] = temp;
      child = parent;
      parent = (child-1)/2;
    }
  }
  
  public void maxHeapPercolateDown(int node) {
    int last = data[0];
    int largest=-1;
    
    while(true) {
      int left = node*2+1, right=node*2+2;
      
      if(left>=size) {
        break;
      }
      
      if(left==size-1) {
        System.out.println("this if called");
        largest = left;
      }
      else if(data[left]>data[right]) {
        largest = left;
      }
      else {
        largest = right;
      }
      
      System.out.println("left["+left+"]: "+data[left]);
      System.out.println("right["+right+"]: "+data[right]);
      System.out.println("largest["+largest+"]: "+data[largest]);
      
      if(last>data[largest]) {
        break;
      }
      else {
        data[node] = data[largest];
        node = largest;
      }
      System.out.println("data: "+Arrays.toString(data));
    }
    data[largest] = last;
  }
  
  public int[] getData() {
    return data;
  }
  
  public int getSize() {
    return size;
  }
  
  public static void main(String[] args ) {
    Heap h = new Heap();
    System.out.println(Arrays.toString(h.getData()));
    h.maxHeapPercolateDown(0);
    //h.maxHeapPercolateUp(7);
    System.out.println(Arrays.toString(h.getData()));
  }
}
