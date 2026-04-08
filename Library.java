
import java.util.Hashtable;
import java.util.Map;

/* This is a stub for the Library class */
public class Library extends Building implements LibraryRequirements {

  private Hashtable<String, Boolean> collection;

    /**
     * Constoctor 
     * @param name The name of the building / library 
     * @param address The address of the building / library 
     * @param nfloors The number of floors inside the building / library 
     * This constuctor also takes the rolls of addressing the new atributes that library has that the parent building does not 
     */
    public Library(String name, String address, int nfloors) {
      super(name, address, nfloors);
      this.collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }

    // Overloading code in case the user can not remeber the amount of floors the lirary has and thus we assume a general level of floors  // 
    public Library(String name, String address) {
      this(name, address, 5);
    }

    // // 
    public Library( String address, int nfloors) {
      this("<Name Unknown>", address, nfloors);
    }
    public String toString(){
      return(super.toString());
    }
  
    /**
     * This updates the containing hashtable with the title of a book and setting that books value to tru e
     * @param title title of the book to add 
     */
    public void addTitle(String title){
      this.collection.put(title, true);
    }

    /**
     * This will rmeove a tittle from the collection in the library 
     * @param title title that is going to be removed 
     * @return Ruturns the title that you are removing and has context 
     */

    public String removeTitle(String title){
      this.collection.remove(title);
      return ("The title "+title+" has been removed");
    }

    /**
     * Checkout out a book 
     * @param title title of the book that you want to check out
     */
    public void checkOut(String title){
      this.collection.replace(title, true, false);
      System.out.println("You've checked out " + title + ". Thank you");
    }

    /**
     * Returns a book that has already been checked out 
     * @param title of the book you are returning 
     */
    public void returnBook(String title){
      this.collection.replace(title, false, true);
      System.out.println("You've returned " + title + ". Thank you");
    }

    /**
     * This checks if a book is aviable or not
     * @param title of the book you looking to see if avaiable or not
     * @return the name of the book if the book is avaible/is withing the collection. If not, returns false 
     */
    public boolean isAvailable(String title){
      if(this.collection.contains(title)){
        System.out.println("This book is avaiable");
        return this.collection.contains(title);
      } else {
        System.out.println("This book is not avaible");
        return false;

      }
    }

      /**
       * 
       */
      public boolean containsTitle(String title){
        if (this.collection.containsKey(title)){
          System.out.println("The collection has this title");
          return this.collection.containsKey(title);
        } else {
          System.out.println("The collection doesnt have this title");
          return false;
        }
      }
      /**
       * Shows the libary collection in an easy to view format
       */
    public void printCollection(){
      if(this.collection.isEmpty()){
        System.out.println("The Library is currently empty");

      } else {
        for(Map.Entry<String,Boolean> entry : this.collection.entrySet()){
          String status = entry.getValue() ? "avaiable" : "Checked out";
          System.out.println("Title: "+entry.getKey() + ", Checked out status:" + status);
          
        }
        
      }
    }



    @Override
    /**
    * This method would should the user the options within the building (house in this case)
    */
      public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + printCollection()\n + containsTitle(String title)\n + isAvailable(String title)\n + returnBook(String title)\n + checkOut(String title)");
      }

      /**
       * Takes you to the floor you would like to go and gives you and error if you have not entered the building yet as well as trying to go to a floor that doesnt excist
       * @param floorNum is the floor of intrest you want to go to within the library 
       */
      public void goToFloor(int floorNum) {
        if (super.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        super.activeFloor = floorNum;
      }




    public static void main(String[] args) {
      Library ChicagoPublicLibrary = new Library("Chicago public library", "somewhere...", 5);
      // Adding books 
      ChicagoPublicLibrary.addTitle("Book1");
      ChicagoPublicLibrary.addTitle("Book2");
      ChicagoPublicLibrary.addTitle("Book3");

      // Showing collection
      ChicagoPublicLibrary.printCollection();

      // Checking out book1
      ChicagoPublicLibrary.checkOut("Book1");
      ChicagoPublicLibrary.removeTitle("Book1");

      // Showinf collection 
      ChicagoPublicLibrary.printCollection();

      // Return book1
      ChicagoPublicLibrary.addTitle("Book1");
      ChicagoPublicLibrary.returnBook("Book1");

      // show collecting 
      ChicagoPublicLibrary.printCollection();

      // checking if contain book 3 
      ChicagoPublicLibrary.containsTitle("Book3");

      ChicagoPublicLibrary.showOptions();

    }
  
  }