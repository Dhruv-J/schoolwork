
public class InterviewQuestions {
  public static void main(String[] args) {
    //System.out.println(palindromeChecker("asdfg"));
    //System.out.println(charRemover("yo yo yo", 's'));
    System.out.println(longestPalindromeFinder("banana"));
  }
  
  public static String longestPalindromeFinder(String str) {
    int n = str.length();
    int longest = 1;
    int start = 0;
    boolean[][] arr = new boolean[n][n];
    
    for(int j=0; j<n; j++) {
      arr[j][j] = true;
      for(int i=0; i<j; i++) {
        if(str.charAt(i)==str.charAt(j) && (i-j<=2||arr[i+1][j-1])) {
          arr[i][j] = true;
          if(j-i+1>longest) {
            longest = j-1+1;
            start = i;
          }
        }
      }
    }
    System.out.println("Longest: "+longest);
    return str.substring(start, start+longest);
  }
  
  public static String charRemover(String str, char c) {
    char[] arr = new char[str.length()];
    for(int i=0; i<str.length(); i++) {
      if(str.charAt(i)==c) {
        arr[i]=0;
      }
      else {
        arr[i] = str.charAt(i);
      }
    }
    str = "";
    for(int i=0; i<arr.length; i++) {
      if(arr[i]!=0) {
        str += ""+arr[i];
      }
    }
    return str;
  }
  
  public static boolean palindromeChecker(String str) {
    String reverse = new StringBuffer(str).reverse().toString();
    for(int i=0; i<str.length(); i++) {
      if(str.charAt(i)!=reverse.charAt(i)) {
        return false;
      }
    }
    return true;
  }
}
