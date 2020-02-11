import java.util.NoSuchElementException;

public class CampManager {
  private CamperBST campers;
  private final static String [] CABIN_NAMES = new String[]{
      "Otter Overpass", "Wolverine Woodland", "Badger Bunkhouse"};
  
  public CampManager() {
    campers = new CamperBST();
  }
  
  public void enrollCamper(Camper newCamper) {
    if(newCamper.getAge()==8||newCamper.getAge()==9) {
      newCamper.assignCabin(CABIN_NAMES[0]);
    }
    else if(newCamper.getAge()>=10||newCamper.getAge()<=12) {
      newCamper.assignCabin(CABIN_NAMES[1]);
    }
    else {
      newCamper.assignCabin(CABIN_NAMES[2]);
    }
    campers.insert(newCamper);
  }
  
  public void unenrollCamper(Camper newCamper) throws NoSuchElementException{
    
  }
  
  public void printStatistics() {
    System.out.println(campers.size());
  }
}
