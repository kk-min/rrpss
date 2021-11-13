package Classes.AMenuItem;

/**
 * AlaCarteItem Class for AlaCarteItem object 
 * extend from AMenuItem
 *@version 1.0
 */
public class AlaCarteItem extends AMenuItem  {
    
    /**
     * Constructor to pass in all required parameters for menu item.
     *
     * @param ID          Menu item's ID.
     * @param name        Menu item's name.
     * @param description Menu item's description.
     * @param price       Menu item's price.
     */
	public AlaCarteItem(int ID, String name, double price, String description)
	{
        super(ID, name, price, description);
        this.itemType = TYPE.ALACARTE;
    }

}
    


