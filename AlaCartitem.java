/**
 * AlaCartitem Class 
 * extend from A menu item
 *
 */

public class AlaCartitem extends Amenuitem  {
    /**
     * Constructor to pass in all required parameters for menu item.
     *
     * @param ID          Menu item's ID.
     * @param name        Menu item's name.
     * @param description Menu item's description.
     * @param price       Menu item's price.
     */
    public int Type;
	public AlaCartitem(int ID,String name, double price,String description)
	{
        super(ID, name, price, description);
    }

}
    


