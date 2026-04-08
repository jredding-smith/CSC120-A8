/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements {

    private int nCoffeeOunces;
    private int nSugarPackets; 
    private int nCreams; 
    private int nCups;
    private boolean elevator;

    public Cafe(String name, String address, int nfloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, boolean elevator) {
        super(name, address, nfloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        this.elevator = elevator;
        System.out.println("You have built a cafe: ☕");
    }
    
    public String toString(){
        return(super.toString());
    }

    // Overloaded contructer in case the user is unsure of how much coffee in onces that the user wants and that they also dont know the amount of cream that they want  // 
    public Cafe(String name, String address, int nfloors, int nSugarPackets, int nCups, boolean elevator){
        this(name, address, nfloors, 16, nSugarPackets, 4, nCups, elevator);
    }

    /**
     * This wil sell a coffe acording to the customers intrest and remove what they ask for from the amount of recsouces the coffee shop has 
     * @param size is the size of the coffee they want 
     * @param nSugarPackets how many sugar packets they want
     * @param nCreams how much cream they want in their coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if(this.nCoffeeOunces >= size && this.nSugarPackets >= nSugarPackets && this.nCreams >= nCreams){
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
            System.out.println("Coffee sold. Enjoy your drink");
        } else {
            System.out.println("Low on stock, please give us a moment");
        }
    }

    // This overload happens in case the intergers that you are requesting are really just parts/floars of what you want // 
    public void sellCoffee(float size, float nSugarPackets, float nCreams){
        if(this.nCoffeeOunces >= size && this.nSugarPackets >= nSugarPackets && this.nCreams >= nCreams){
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
            System.out.println("Coffee sold. Enjoy your drink");
        } else {
            System.out.println("Low on stock, please give us a moment");
        }
    }



    /**
     * This will restock the stores suplly, if needed to do so  
     * @param nCoffeeOunces restocking how much coffe the cafe has 
     * @param nSugarPackets restocking how many sugar packets they have
     * @param nCreams restocking how many creams they have 
     * @param nCups restocking how many cups they have 
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    @Override
    /**
    * This method would should the user the options within the building (house in this case)
    */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee(int size, int nSugarPackets, int nCreams)");
    }

    public void goToFloor(int floorNum) {
        if (this.elevator = true){
            if (super.activeFloor == -1) {
                throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
            }
            if (floorNum < 1 || floorNum > this.nFloors) {
                throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
            }
            System.out.println("You can not go to this floor. The floor is only for employyees. ACCESS DENIED :<");
    }
    }



    public static void main(String[] args) {
        Cafe cc = new Cafe("CC", "somewhere...", 3, 200, 200, 200, 200, true);
        System.out.println(cc);

        cc.sellCoffee(16, 3, 2);
        cc.sellCoffee(12, 10, 1);
    }
    
}
