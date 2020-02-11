import java.util.ArrayList;
import java.util.Arrays;

public class Tree {
  private TreeNode root;
  private int size;
  
  public Tree(int data) {
    root = new TreeNode(data);
    size = 0;
  }
  
  public static void main(String[] args) {
    Tree t = new Tree(5);
    t.simpleInsert(2);
    t.simpleInsert(1);
    t.simpleInsert(3);
    t.simpleInsert(12);
    t.simpleInsert(9);
    t.simpleInsert(21);
    t.simpleInsert(19);
    t.simpleInsert(25);
    t.balanceTree();
    System.out.println(t.getRoot());
  }
  
  public void balanceTree() {
    ArrayList<Integer> arr = new ArrayList<Integer>(size);
    arrify(root, arr);
    System.out.println("Organized Array: "+Arrays.toString(arr.toArray()));
    root = btHelper(arr, 0, size-1);
  }
  
  public TreeNode btHelper(ArrayList<Integer> arr, int left, int right) {
    if(left>right) {
      return null;
    }
    
    int middle = (left+right)/2;
    TreeNode root = new TreeNode(arr.get(middle));
    root.setLeft(btHelper(arr, left, middle-1));
    root.setRight(btHelper(arr, middle+1, right));
    
    return root;
  }
  
  public void arrify(TreeNode curNode, ArrayList<Integer> arr) {
    if(curNode==null) {
      return;
    }
    arrify(curNode.getLeft(), arr);
    arr.add(curNode.getData());
    arrify(curNode.getRight(), arr);
  }
  
  public boolean isBalanced(TreeNode curNode) {
    if(curNode==null) {
      return true;
    }
    int lh=height(curNode.getLeft()), rh=height(curNode.getRight());
    
    if(Math.abs(lh-rh)<=1&&isBalanced(curNode.getLeft())&&isBalanced(curNode.getRight())) {
      return true;
    }
    else {
      return false;
    }    
  }
  
  public int height(TreeNode curNode) {
    if(curNode==null) {
      return 0;
    }
    return 1+Math.max(height(curNode.getLeft()), height(curNode.getRight()));
  }
  
  public void simpleInsert(int data) {
    insertHelp(data, root);
    size++;
  }
  
  private void insertHelp(int data, TreeNode curNode) {
    if(data<curNode.getData()) {
      if(curNode.getLeft()==null) {
        curNode.setLeft(new TreeNode(data));
      }
      else {
        insertHelp(data, curNode.getLeft());
      }
    }
    else if(data>curNode.getData()) {
      if(curNode.getRight()==null) {
        curNode.setRight(new TreeNode(data));
      }
      else {
        insertHelp(data, curNode.getRight());
      }
    }
    else {
      System.out.println("How did we get here?");
    }
  }
  
  public void simpleDelete(int data) {
    root = removeHelp(data, root);
    size--;
  }
  
  public TreeNode removeHelp(int data, TreeNode curNode) {
    if(data<curNode.getData()) {
      return removeHelp(data, curNode.getLeft());
    }
    else if(data>curNode.getData()) {
      return removeHelp(data, curNode.getRight());
    }
    else if(data==curNode.getData()){
      if(curNode.getLeft()==null&&curNode.getRight()==null) {
        return null;
      }
      else if(curNode.getLeft()!=null&&curNode.getRight()==null) {
        return curNode.getLeft();
      }
      else if(curNode.getLeft()==null&&curNode.getRight()!=null) {
        return curNode.getRight();
      }
      curNode.setData(successorFinder(curNode));
      curNode.setRight(removeHelp(successorFinder(curNode), curNode.getRight()));
    }
    else {
      return null;
    }
    return curNode;
  }
  
  public int successorFinder(TreeNode curNode) {
    if(curNode.getRight()==null&&curNode.getLeft()==null) {
      return curNode.getData();
    }
    else if(curNode.getRight()==null) {
      return successorFinder(curNode.getLeft());
    }
    else {
      return successorFinder(curNode.getRight());
    }
  }
  
  public TreeNode getRoot() {
    return root;
  }
}
