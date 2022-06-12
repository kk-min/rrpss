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
     * @param id          MainDish's id.
     * @param name        MainDish's name.
     * @param description MainDish's description.
     * @param price       MainDish's price.
     */
    public MainDish(int id, String name, double price, String description) {
        super(id, name, price, description);
    }
}