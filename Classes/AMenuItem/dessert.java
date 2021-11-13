package Classes.AMenuItem;

/**
* Dessert Class for Dessert object
* extend from AlaCarteItem
*@version 1.0
*/
class Dessert extends AlaCarteItem {
    /**
     * Constructor to pass in all required parameters for Dessert
     *
     * @param ID          Menu item's ID.
     * @param name        Menu item's name.
     * @param description Menu item's description.
     * @param price       Menu item's price.
     */

    public Dessert(int ID, String name, double price, String description) {
        super(ID, name, price, description);
    }
}