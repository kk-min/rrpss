package Classes.AMenuItem;
/**
 * The Promotional Class
 * extends from AMenuItem
 * describes promotional set items
 * @author Lingyi
 * @version 1.0
 * @since 2021-11-01
 */
public class Promotional extends AMenuItem {
    /**
     *
     * Constructor to pass in all required parameters.
     * 
     * @param id          Promotional item's id.
     * @param name        Promotional item's name.
     * @param description Promotional item's description.
     * @param price       Promotional item's price.
     */
    public Promotional(int id, String name, double price, String description) {
        super(id, name, price, description);
        this.itemType = TYPE.PROMOTIONAL;
    }
}
