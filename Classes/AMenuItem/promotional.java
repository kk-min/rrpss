package Classes.AMenuItem;

/**
 * Promotional Class extend from AMenuItem
 */
public class Promotional extends AMenuItem {
    /**
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
