package Classes.Order;

import java.util.HashMap;
import java.util.Map;

import Classes.AMenuItem.AMenuItem;
import Classes.Staff.Staff;
import Classes.Time.DateTimeFormatHelper;

/**
 Contains information about  the items ordered by a single Customer/Table.
 @author  Min
 @version 1.0
 @since   2021-11-12
 */
public class Order{
    /**
     * The table from which the order was made.
     */
    private int tableID;
    /**
     * ID of the order
     */
    private int orderID;
    /**
     * Variable that is assigned and incremented in order to ensure orderID is unique for every instance of order
     */
    private static int globalID = 1;
    /**
     * Flag that indicates whether the order was made by a member
     */
    private boolean isMember;
    /**
     * A Map that contains a Menu Item object as a key and the total numbers of that item ordered in a single order as the value
     */
    private Map<AMenuItem, Integer> itemList;
    /**
     * Name of the staff who created the order
     */
    private Staff createdBy;
    /**
     * The tax rate to be applied to the total cost of the items
     */
    private final double TAX_RATE = 0.07; // 7% tax
    /** The discount rate to be applied to the total cost if the customer is a member
     *
     */
    private final double DISCOUNT_RATE = 0.05;
    /**
     *  Total price of the items before taxes, discounts included
     */
    private double subTotal; // before taxes, discounts included
    /**
     * Total price including taxes and discounts
     */
    private double grandTotal; // after taxes
    /**
     * The date the order was made in the form DD/MM/YYYY
     */
    private String dateTime;

    /**
     * Creates a new order with the given tableID and orderCreator
     * @param tableID The Table ID where the order was made
     * @param orderCreator The name of the Staff who crated the order
     * @param isMember Flag value that checks whether order was made by a member to apply discount
     */
    public Order (int tableID, Staff orderCreator, boolean isMember){
        this.orderID = globalID++;
        this.tableID = tableID;
        this.createdBy = orderCreator;
        this.isMember = isMember;
        this.itemList = new HashMap<AMenuItem, Integer>();
        this.subTotal = 0;
        this.dateTime  = DateTimeFormatHelper.formatToStringDate(DateTimeFormatHelper.inbuiltDate());
        this.itemList = new HashMap<AMenuItem, Integer>(itemList); //Create a shallow copy

        if (isMember){ // check Membership status
            this.subTotal = (this.subTotal)*(1-DISCOUNT_RATE);
        }

        this.grandTotal = subTotal*(1+TAX_RATE); // Add tax
    }

    /**
     * Gets the subtotal for this order
     * @return the subtotal price (after discount, before taxes)
     */
    public double getSubTotal(){
        return subTotal;
    }

    /**
     * Gets the grand total for this order
     * @return the grand total price (including discounts taxes)
     */
    public double getGrandTotal(){
        return this.grandTotal;
    }

    /**
     * Removes an item from this order
     * @param key the specific AMenuItem we wish to remove
     * @param quantity the quantity of the item to remove
     */
    public void removeItem(AMenuItem key, int quantity){
        if ((quantity > itemList.get(key)) || (quantity < 1)){
            System.out.println("Invalid quantity!");
            return;
        }
        this.itemList.put(key, this.itemList.get(key)-quantity);

        updateOrder(); // Update the subTotal and grandTotal with values of the new item

        System.out.println("Successfully removed.");
    }

    /**
     * Adds an item to this order
     * @param key the specific AMenuItem we wish to add
     * @param quantity the quantity of the item to add
     */
    public void addItem(AMenuItem key, int quantity){
        if (quantity < 1){
            System.out.println("Invalid quantity!");
            return;
        }

        if (this.itemList.containsKey(key)){ // item key is already inside the map
            this.itemList.put(key, this.itemList.get(key)+quantity);
        }
        else{ // Item key is not inside the map
            this.itemList.put(key, quantity);
        }
        
        updateOrder(); // Update the subTotal and grandTotal with values of the new item

        System.out.println("Successfully added.");
    }

    public void updateOrder(){
        this.subTotal = 0;
        this.grandTotal = 0;
        for (var entry : this.itemList.entrySet()){
            AMenuItem item = entry.getKey();
            int count = entry.getValue();
            this.subTotal += item.getPrice()*count;
        }

        if (this.isMember){ // Order made by a member
            this.subTotal = this.subTotal*(1-DISCOUNT_RATE);
        }
        this.grandTotal = this.subTotal*(1+TAX_RATE);
    }

    /**
     * Gets the order's ID
     * @return this Order's orderID
     */
    public int getID(){
        return this.orderID;
    }

    /**
     * Gets the order's tableID
     * @return this Order's tableID
     */
    public int getTableID(){
        return this.tableID;
    }

    /**
     * Gets the order's itemList
     * @return this Order's itemList
     */
    public Map<AMenuItem, Integer> getItemList(){
        return this.itemList;
    }

    /**
     * Gets the order's creator
     * @return this Order's creator (Staff)
     */
    public Staff getCreator(){
        return this.createdBy;
    }

    /**
     * Gets the order's creation date
     * @return this Order's creation date
     */
    public String getDateTime(){
        return this.dateTime;
    }

    /**
     * Gets the tax rate imposed on the Order
     * @return the tax rate imposed on the Order
     */
    public double getTAX_RATE() {
        return this.TAX_RATE;
    }

    /**
     * Gets the discount rate that can be applied on the order (if the customer is a member)
     * @return the discount rate that can be applied on the order
     */
    public double getDISCOUNT_RATE(){
        if (isMember) return this.DISCOUNT_RATE;
        else return 0;
    }
}