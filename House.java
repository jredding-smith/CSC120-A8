
import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building implements HouseRequirements {

  // Establishes the perameters needed for the house class in particular // 
  private ArrayList<Student> residents; 
  private boolean hasDiningRoom;
  private boolean elevator;

  /**
   * Constoctor 
   * @param name The name of the building / house 
   * @param address The address of the building / house 
   * @param nfloors The number of floors inside the building / house 
   * This constuctor also takes the rolls of addressing the new atributes that house has that the parent building does not 
   */
  public House(String name, String address, int nfloors, boolean elevator){
    super(name, address, nfloors);
    this.hasDiningRoom = true;
    this.residents = new ArrayList<Student>();  
    System.out.println("You have built a house: 🏠");
    this.elevator = elevator;
  }

  // This is an overloading the constuctor in case the user doesnt know if the house they are looking at has an elevator or not // 
  public House(String name, String address, int nfloors){
    this(name, address, nfloors, false);
  }

  public String toString(){
    return(super.toString() + System.lineSeparator() + "The resident(s) of this house is/are:" + this.residents + System.lineSeparator() + "Does it have a dinning hall?:" + this.hasDiningRoom);
  }



  /**
   * Accessor for hasDiningRoom
   * @return : True or false dependent on if the house has a dining room. 
   * Currently set to true 
   */
  public boolean hasDiningRoom(){
    return hasDiningRoom;
  }

  /**
   * Accessor for number of residents 
   * @return the size/number of residents within the residents list 
   */
  public int nResidents(){
    return this.residents.size();

  }

  /**
   * Updates the residents list with a student who will be moving in 
   * @param s name of the student who will be moving into the house 
   */
  public void moveIn(Student s){
    this.residents.add(s);
  }

  /**
   * Updates the residents array list to remove a student who will be moving out 
   * @param s student who will be moving out 
   * @return The name of the student that has/will be moving out
   */
  public Student moveOut(Student s){
    this.residents.remove(s);
    return s;
  }



  // Overloading moveOut() to evict everyone in the house // 
  public void moveOut(){
    this.residents.clear();
    System.out.println("Everyone has now been evicted.");
  }

  /**
   * A boolean method that will tell us if a student is a resident 
   * @param s student you want to check to see if they live there or not 
   * @return True or false. True being that the student in the peram is a resident, false if not 
   */
  public boolean isResident(Student s){
    return this.residents.contains(s);
  }


  @Override
  /**
   * This method would should the user the options within the building (house in this case)
   */
  public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + moveOut(s)\n + moveIn(s)");
  }
  
  /**
   * This code is very long as it needs to account for both having and not having and elevator, as well as the possible errors that may come with going up one floor at a time if there is not an elevator 
   * @param floorNum is the floor of intrest you want to go to within the library 
   */
  public void goToFloor(int floorNum) {

    // IF THERE IS A ELEVATOR //
    if (this.elevator == true){
      if (super.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
      }
      if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
      }
      System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      super.activeFloor = floorNum;
      } else {
        if (super.activeFloor == -1) {
          throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
          throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +"."); 
        }

      // IF THERE IS NOT A ELEVATOR //
      else {
        System.out.println("You can not go up to this floor imedietly as " + this.name + " does not have an elevator. Instead, you will go up one floor ");
        super.activeFloor += 1;
        // THE FLOOR THEY ARE TRYING TO GO TO IS NONEXISTENT // 
        if (super.activeFloor > this.nFloors){
          throw new RuntimeException("You are already on the heights floor you can be on, so instead you stop");
        }
        System.out.println("You are now on floor #" + super.activeFloor + " of " + this.name);
    }
    }
  }
  



  public static void main(String[] args) {
    Student jode = new Student("Jode", "50193739", 2029);
    Student Liz = new Student("Elizabeth", "50193737", 2029);
    House gardiner = new House("Gardiner", "1 paradise road", 4 , true);
    gardiner.moveIn(jode);
    gardiner.moveIn(Liz);
    gardiner.isResident(jode);
    gardiner.moveOut(Liz);
    System.out.println(gardiner.isResident(Liz));
    System.out.println(gardiner.isResident(jode));
    gardiner.showOptions();
    gardiner.enter();
    gardiner.goToFloor(4);
  }


}