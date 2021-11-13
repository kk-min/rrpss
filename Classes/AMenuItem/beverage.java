package Classes.AMenuItem;
/**
 * The Beverage Class
 * extends from AlaCarteItem
 * @author Lingyi
 * @version 1.0
 * @since 2021-11-01
 */
class Beverage extends AlaCarteItem {
    /**
     * Constructor to pass in all required parameters for Beverage
     *
     * @param ID          Beverage's ID.
     * @param name        Beverage's name.
     * @param description Beverage's description.
     * @param price       Beverage's price.
     */
    public Beverage(int ID, String name, double price, String description) {
        super(ID, name, price, description);
    }
}

