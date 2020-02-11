import java.util.NoSuchElementException;

public class CamperBST {
  public CampTreeNode root;
  private int size;
  
  public CamperBST() {
    root = new CampTreeNode();
    size = 0;
  }
  
  //starts tree insertion by calling insertHelp() on the root and
  //assigning root to be the subtree returned by that method
  public void insert(Camper newCamper) {
    root = insertHelp(root, newCamper);
    size++;
  }
  
  /** Recursive helper method to insert.
   * @param current, The "root" of the subtree we are inserting into,
   * ie the node we are currently at.
   * @param newCamper, the camper to be inserted into the tree
   * @return the root of the modified subtree we inserted into
   */
  private CampTreeNode insertHelp(CampTreeNode current, Camper newCamper) { 
    if(current==null) {
      current = new CampTreeNode();
      current.setData(newCamper);
      return current;
    }
    if(current.getData().compareTo(newCamper)<0) {
      return insertHelp(current.getRightNode(), newCamper);
    }
    return insertHelp(current.getLeftNode(), newCamper);
  }
  
  /** Deletes a Camper into the binary search tree if it exists.
  * @param key, the camper to be deleted from the tree
  * @throws NoSuchElementException if it is thrown by deleteHelp
  */
  public void delete (Camper key) throws NoSuchElementException {
    root = deleteHelp(root, key);
  }
  
  /** Recursive helper method to delete.
  * @param current, The "root" of the subtree we are deleting from,
  * ie the node we are currently at.
  * @param key, the camper to be deleted from the tree
  * @return the root of the modified subtree we deleted from
  * @throws NoSuchElementException if the camper is not in the tree
  */
  private CampTreeNode deleteHelp(CampTreeNode current, Camper key) throws NoSuchElementException{
    if(current.getData().compareTo(key)<0) {
      return deleteHelp(current.getLeftNode(), key);
    }
    else if(current.getData().compareTo(key)>0) {
      return deleteHelp(current.getRightNode(), key);
    }
    else if(current.getData().compareTo(key)==0){
      if(current.getLeftNode()==null) {
        return current.getRightNode();
      }
      else if(current.getRightNode()==null) {
        return current.getLeftNode();
      }
      
      current.setData(successorFinder(current.getRightNode()));
      current.setRightNode(deleteHelp(current.getRightNode(), current.getData()));
    }
    else {
      throw new NoSuchElementException("Value not found.");
    }
    return current;
  }
  
  private Camper successorFinder(CampTreeNode current){
    if(current.getLeftNode()==null&&current.getRightNode()==null) {
      return current.getData();
    }
    else if(current.getLeftNode()!=null) {
      return successorFinder(current.getLeftNode());
    }
    else {
      return successorFinder(current.getRightNode());
    }
  }
  
  public void print() { 
    printHelp(root); 
  }
  
  private void printHelp(CampTreeNode current){
    if(current==null) {
      return;
    }
    printHelp(current.getLeftNode());
    System.out.println(current.getData());
    printHelp(current.getRightNode());
  }
  
  public int size() {
    return size;
  }
  
  public boolean isEmpty() {
    return size==0;
  }
}
