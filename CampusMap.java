import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */

    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    /**
     * @return The content of the class by foing it in a list kind of way, as this toString is for a map and a list presenation of a map makes more sense. The list being all of the places on the map and thier information 
     */
    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";
        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new House("Lamont","Address 1", 4));
        myMap.addBuilding(new House("Gardiner", "Address 2", 4, false));
        myMap.addBuilding(new House("Parsons", "Address 3", 4, true));
        myMap.addBuilding(new House("Cutter", "Address 4", 3, true));
        myMap.addBuilding(new Library("forbes", "Address 5"));
        myMap.addBuilding(new Library("Address 6", 3));
        myMap.addBuilding(new Library("Hillyer", "Address 7", 3));
        myMap.addBuilding(new Cafe("CC", "Address 8", 3, 16, 4, 3, 1, true));
        myMap.addBuilding(new Cafe("CampusCaff", "Address 9", 5, 16, 4, 3, 1, true));
        myMap.addBuilding(new Cafe("Random Cafe Somwhere ", "Address 10", 3, 16, 4, 3, 1, true));
        System.out.println(myMap);
    }
    
}
