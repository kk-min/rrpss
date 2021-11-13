package Classes.AMenuItem;

/**
* Beverage Class for Beverage object 
* extend from AlaCarteItem
*@version 1.0
*/
class Beverage extends AlaCarteItem {
    /**
     * Constructor to pass in all required parameters for Beverage
     *
     * @param ID          Menu item's ID.
     * @param name        Menu item's name.
     * @param description Menu item's description.
     * @param price       Menu item's price.
     */
    public Beverage(int ID, String name, double price, String description) {
        super(ID, name, price, description);
    }
}

