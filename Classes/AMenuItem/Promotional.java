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
     * @param ID          Promotional item's ID.
     * @param name        Promotional item's name.
     * @param description Promotional item's description.
     * @param price       Promotional item's price.
     */
    public Promotional(int ID, String name, double price, String description) {
        super(ID, name, price, description);
        this.itemType = TYPE.PROMOTIONAL;
    }
}
