import java.util.Arrays;

public class MergeSort {
  private int[] data;
  
  public MergeSort(int[] data) {
    this.data = data;
  }
  
  public void merge(int[] data, int left, int middle, int right) {
    int mergedSize = right-left+1;
    int[] mergedData = new int[mergedSize];
    int mergePos = 0; //position to insert merged number
    int leftPos = left;
    int rightPos = middle+1;
    
    while(leftPos<=middle && rightPos<=right) {
      if(data[leftPos]<data[rightPos]) {
        mergedData[mergePos] = data[leftPos];
        leftPos++;
      }
      else {
        mergedData[mergePos] = data[rightPos];
        rightPos++;
      }
      mergePos++;
    }
    
    while(leftPos<=middle) {
      mergedData[mergePos] = data[leftPos];
      leftPos++;
      mergePos++;
    }
    
    while(rightPos<=right) {
      mergedData[mergePos] = data[rightPos];
      rightPos++;
      mergePos++;
    }
    
    for(mergePos=0; mergePos<mergedSize; mergePos++) {
      data[left+mergePos] = mergedData[mergePos];
    }
  }
  
  public void mergeSort(int[] data, int left, int right) {
    if(left<right) {
      int middle = (left+right)/2;
      mergeSort(data, left, middle);
      mergeSort(data, middle+1, right);
      
      merge(data, left, middle, right);
    }
  }
  
  public int[] getData() {
    return data;
  }
  
  public static void main(String[] args) {
    MergeSort ms = new MergeSort(new int[] {10, 7, 78, 4, 45, 32, 2, 11});
    System.out.println(Arrays.toString(ms.getData()));
    ms.mergeSort(ms.getData(), 0, 7);
    System.out.println(Arrays.toString(ms.getData()));
  }
}
