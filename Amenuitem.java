/**
 * Amenuitem Class

 */
public class Amenuitem {

    /**
     * The ID of the restaurant item.
     */
    private int ID;
    /**
     * The name of the restaurant item.
     */
    private String name;
    /**
     * The price of the restaurant item.
     */
    private double price;
        /**
     * The describtion of the restaurant item.
     */
    private String description;


    /**
     * Constructor to pass in all required parameters for a restaurant item.
     *
     * ID    This restaurant item's ID.
     * name  This restaurant item's name.
     * price This restaurant item's price.
     * describtion This restaurant item's describtion.
     */
    public Amenuitem (int ID,String name, double price,String description)
    {
        this.ID = ID;
        this.name = name; 
        this.price = price;
        this.description = description;
  
    }
    /**
     * Accessor for Restaurant Item type.
     *
     * @return Gets the restaurant item's ID.
     */
    public int getId() {
        return ID;
    }

    /**
     * Mutator for Restaurant Item ID.
     *
     * @param restaurantItemID Sets the restaurant item's ID.
     */
    public void setId(int ID) {
        this.ID = ID;
    }

    /**
     * Accessor for Restaurant Item name.
     *
     * @return Gets the restaurant item's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Mutator for Restaurant Item name.
     *
     * @param name Sets the restaurant item's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Accessor for Restaurant Item price.
     *
     * @return Gets the restaurant item's price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Mutator for Restaurant Item price.
     *
     * @param price Sets the restaurant item's price.
     */
    public void setPrice(double price) {
        this.price = price;
    }
        /**
     * Accessor for Restaurant Item name.
     *
     * @return Gets the restaurant item's describtion.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Mutator for Restaurant Item name.
     *
     * @param name Sets the restaurant item's describtion.
     */
    public void setDescription(String description) {
        this.description = description;
    }

}

