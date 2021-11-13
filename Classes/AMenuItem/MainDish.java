package Classes.AMenuItem;
/**
 * The MainDish Class
 * extends from AlaCarteItem
 * @author Lingyi
 * @version 1.0
 * @since 2021-11-01
 */
class MainDish extends AlaCarteItem {
    /**
     * Constructor to pass in all required parameters for MainDish
     *
     * @param ID          MainDish's ID.
     * @param name        MainDish's name.
     * @param description MainDish's description.
     * @param price       MainDish's price.
     */
    public MainDish(int ID, String name, double price, String description) {
        super(ID, name, price, description);
    }
}