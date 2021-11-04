public class Order{
    private int tableID;
    private MenuItem[] itemList;
    private Staff orderCreator;
    private final double TAX_RATE = 0.07; // 7% tax
    private final double DISCOUNT_RATE = 0.05;
    private Customer patron;
    private double tax;
    private double subTotal; // before taxes, discounts included
    private double grandTotal; // after taxes
    //private Time timestamp; // TO DO!

    public Order(int tableID, MenuItem[] itemList, Staff orderCreator, boolean isMember){
        this.tableID = tableID;
        this.orderCreator = orderCreator;
        this.itemList = new MenuItem[itemList.length];
        this.subTotal = 0;
        //this.timestamp = ?
        int i = 0;

        for (MenuItem item : itemList){
            this.itemList[i] = item; // insert all MenuItems from parameter list into our Order attribute
            this.subTotal += item.getPrice(); // add all prices of individual MenuItems into our subTotal attribute
        }

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


}