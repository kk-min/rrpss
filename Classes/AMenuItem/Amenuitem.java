package Classes.AMenuItem;

/**
* AMenuItem Class
*
*/
public class AMenuItem {
    /**
     * The ID of the menu item.
     */
    private int ID;
    /**
     * The name of the menu item.
     */
    private String name;
    /**
     * The price of the menu item.
     */
    private double price;
        /**
     * The description of the menu item.
     */
    private String description;

    /**
     * Constructor to pass in all required parameters for a general menu item.
     *
     * ID           This menu item's ID.
     * name         This menu item's name.
     * price        This menu item's price.
     * description  This menu item's description.
     */
    public AMenuItem (int ID, String name, double price, String description)
    {
        this.ID = ID;
        this.name = name; 
        this.price = price;
        this.description = description;
    }
    
    /**
     * getId()
     * setId(int ID)
     * getName()
     * setName(String name)
     * getPrice()
     * setPrice(double price)
     * getDescription()
     * setDescription(String description)
     * 
     */

    public int getId() {
        return ID;
    }

    public void setId(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
 
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

