package Classes.AMenuItem;
/**
* AMenuItem Class
* Contain all base variable and function for AlaCarteItem and Promotional
*@version 1.0
*/
public class AMenuItem {
    public enum TYPE {ALACARTE, PROMOTIONAL};
    protected TYPE itemType;
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
     * @param  ID          This menu item's ID.
     * @param  name         This menu item's name.
     * @param  price        This menu item's price.
     * @param  description  This menu item's description.
     */
    public AMenuItem (int ID, String name, double price, String description)
    {
        this.ID = ID;
        this.name = name; 
        this.price = price;
        this.description = description;
    }
    
    /* Methods in class
      getId()
      setId(int ID)
      getName()
      setName(String name)
      getPrice()
      setPrice(double price)
      getDescription()
      setDescription(String description)
      getType()
     */

    /**
     * Accessor for ID of the AmenuItem object
     * @return ID 
     */

    public int getId() {
        return ID;
    }
    /**
     * 
     * @param ID  Mutator for ID of the AmenuItem object
     * 
     */

    public void setId(int ID) {
        this.ID = ID;
    }
    /**
     * Accessor for Name of the AmenuItem object
     * @return name  
     */
    public String getName() {
        return name;
    }
    /**
     * @param name  Mutator for Name of the AmenuItem object
     * 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *  Accessor for Price of the AmenuItem object
     * @return price 
     * 
     */
    public double getPrice() {
        return price;
    }
    /**
     * @param price  Mutator for Price of the AmenuItem object
     * 
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * Accessor for Descriptioon of the AmenuItem object
     * @return description  
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description  Mutator for Descriptioon of the AmenuItem object
     * 
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Accessor for ItemType of the AmenuItem object
     * @return itemType  
     * 
     */
    public TYPE getType(){
        return this.itemType;
    }
}

