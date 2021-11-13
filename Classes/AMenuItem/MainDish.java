package Classes.AMenuItem;

/**
* MainDish Class for Maindish Object
* extend from AlaCarteItem
* @version 1.0
*/
class MainDish extends AlaCarteItem {
    /**
     * Constructor to pass in all required parameters for Main dish
     *
     * @param ID          Menu item's ID.
     * @param name        Menu item's name.
     * @param description Menu item's description.
     * @param price       Menu item's price.
     */

    public MainDish(int ID, String name, double price, String description) {
        super(ID, name, price, description);
    }
}