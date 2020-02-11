
public class Tree {
  private TreeNode root;
  private int size;
  
  public Tree(int data) {
    root = new TreeNode(data);
    size = 1;
  }
  
  public void insert(int data) {
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
  
  public void remove(int data) {
    root = removeHelp(data, root);
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
  
  public static void main(String[] args) {
    testInsert();
  }
  
  public static void testInsert() {
    Tree t = new Tree(8);
    t.insert(5);
    t.insert(10);
    t.insert(2);
    t.insert(6);
    t.insert(14);
    t.insert(4);
    t.insert(7);
    t.insert(13);
    System.out.println(t.getRoot().getLeft().getRight().getRight().getData());
  }
  
  public TreeNode getRoot() {
    return root;
  }
}
