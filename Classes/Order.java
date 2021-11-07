import java.util.ArrayList;
import java.util.Map;

public class Order{
    private int tableID;
    private int orderID;
    private static int globalID = 0;
    private Map<AMenuItem, Integer> itemList;
    private Staff createdBy;
    private final double TAX_RATE = 0.07; // 7% tax
    private final double DISCOUNT_RATE = 0.05;
    private double tax;
    private double subTotal; // before taxes, discounts included
    private double grandTotal; // after taxes
    private String dateTime;

    public Order (int tableID, Staff orderCreator, boolean isMember){
        this.orderID = globalID++;
        this.tableID = tableID;
        this.createdBy = orderCreator;
        this.itemList = new Map<AMenuItem, Integer>();
        this.subTotal = 0;
        this.dateTime  = DateTimeFormatHelper.formatToStringDate(DateTimeFormatHelper.getTodayDate(false));
        int i = 0;
        this.itemList = new Map<AMenuItem, Integer>(itemList); //Create a shallow copy

        if (isMember){ // check Membership status
            this.subTotal = (this.subTotal)*DISCOUNT_RATE;
        }

        this.grandTotal = subTotal*(1+TAX_RATE); // Add tax

    }

    public double getSubTotal(){
        return subTotal;
    }

    public double getGrandTotal(){
        return this.grandTotal;
    }

    public void removeItem(AMenuItem key, int quantity){
        if ((quantity > itemList.get(key)) || (quantity < 1)){
            System.out.println("Invalid quantity!");
            return;
        }
        this.itemList.put(key, this.itemList.get(key)-quantity);
    }
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

    }

    public String getDateTime(){
        return this.dateTime;
    }

    public double getTAX_RATE() {
        return this.TAX_RATE;
    }

    public double getDISCOUNT_RATE(){
        return this.DISCOUNT_RATE;
    }


}