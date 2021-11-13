package Classes.AMenuItem;
/**
 * The Dessert Class
 * extends from AlaCarteItem
 * @author Lingyi
 * @version 1.0
 * @since 2021-11-01
 */
class Dessert extends AlaCarteItem {
    /**
     * Constructor to pass in all required parameters for Dessert
     *
     * @param ID          Dessert's ID.
     * @param name        Dessert's name.
     * @param description Dessert's description.
     * @param price       Dessert's price.
     */
    public Dessert(int ID, String name, double price, String description) {
        super(ID, name, price, description);
    }
}