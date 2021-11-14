package Classes.AMenuItem;

/**
 * The AMenuItem Class
 * @author Lingyi
 * @version 1.0
 * @since 2021-11-01
 */
public class AMenuItem {
    /**
     * The type of the menu item, whether AlaCarte or Promotional.
     */
    public enum TYPE {ALACARTE, PROMOTIONAL};
    /**
     * The type (ALACARTE, PROMOTIONAL) of the object
     */
    protected TYPE itemType;
    /**
     * The id of the menu item.
     */
    private int id;
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
     * @param  id           This menu item's id.
     * @param  name         This menu item's name.
     * @param  price        This menu item's price.
     * @param  description  This menu item's description.
     */
    public AMenuItem (int id, String name, double price, String description)
    {
        this.id = id;
        this.name = name; 
        this.price = price;
        this.description = description;
    }
    
    /* Methods in class
      getId()
      setId(int id)
      getName()
      setName(String name)
      getPrice()
      setPrice(double price)
      getDescription()
      setDescription(String description)
      getType()
     */

    /**
     * Accessor for id of the AMenuItem object
     * @return id 
     */
    public int getId() {
        return id;
    }
    /**
     * Mutator for id of the AMenuItem object
     * @param id id of AMenuItem object
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Accessor for Name of the AMenuItem object
     * @return Name of the AMenuItem object
     */
    public String getName() {
        return name;
    }
    /**
     * Mutator for Name of the AMenuItem object
     * @param name Name of the AMenuItem object
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *  Accessor for Price of the AMenuItem object
     * @return price 
     */
    public double getPrice() {
        return price;
    }
    /**
     * Mutator for Price of the AMenuItem object
     * @param price Price of the AMenuItem object
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * Accessor for Descriptioon of the AMenuItem object
     * @return Price of the AMenuItem object
     */
    public String getDescription() {
        return description;
    }
    /**
     * Mutator for Description of the AMenuItem object
     * @param description Description of the AMenuItem object
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Accessor for ItemType of the AMenuItem object
     * @return itemType  
     */
    public TYPE getType(){
        return this.itemType;
    }
}

