package Classes.AMenuItem;
public class Amenuitem {

    /**
    * AlaCartitem Class
    *
    */




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
     * Constructor to pass in all required parameters for a general restaurant item.
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

