import StringUtils;

public class Order{
    private int tableID;
    private MenuItem[] itemList;
    private Staff orderCreator;
    private final TAX_RATE = 0.07; // 7% tax
    private final DISCOUNT_RATE = 0.05;
    private Customer patron;
    private double tax;
    private double subTotal; // before taxes, discounts included
    private double grandTotal; // after taxes
    //private Time timestamp; // TO DO!

    public Order(int tableID, MenuItem[] itemList, Staff orderCreator, Customer patron){
        this.tableID = tableID;
        this.orderCreator = orderCreator;
        this.patron = patron;
        this.itemList = new MenuItem[itemList.length];
        this.subTotal = 0;
        int i = 0;

        for (MenuItem item : itemList){
            this.itemList[i] = item; // insert all MenuItems from parameter list into our Order attribute
            this.subTotal += item.getPrice(); // add all prices of individual MenuItems into our subTotal attribute
        }

        if (Customer.isMember()){ // check Membership status
            this.subTotal = (this.subTotal)*DISCOUNT_RATE;
        }

        this.grandTotal = subTotal*(1+TAX_RATE); // Add tax
        if (Customer.isMember()){ // check Membership status
            this.grandTotal = (this.grandTotal)*DISCOUNT_RATE;
        }

    }

    public double getSubTotal(){
        return subTotal;
    }

    public double getGrandTotal(){
        return this.grandTotal;
    }

    public void printInvoice(){
        
    }


}