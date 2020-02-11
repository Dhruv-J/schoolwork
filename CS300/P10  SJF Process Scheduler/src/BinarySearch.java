
public class BinarySearch {
  
  public int search(int[] arr, int start, int end, int key) {
    int middle = (start+end)/2;
    int middleVal = arr[middle];
    //System.out.println("start["+start+"]: "+arr[start]+" end["+end+"]: "+arr[end]+" middle["+middle+"]: "+arr[middle]);
    if(middleVal==key) {
      return middle;
    }
    if(middle==start&&middle==end) {
      return -1;
    }
    else if(middleVal>key) {
      return search(arr, start, middle-1, key);
    }
    else {
      return search(arr, middle+1, end, key);
    }
  }
  
  public static void main(String[] args) {
    BinarySearch bs = new BinarySearch();
    System.out.println(bs.search(new int[] {2, 4, 7, 10, 11, 32, 45, 78}, 0, 7, 78));
  }
  
}
