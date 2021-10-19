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

    public Order(int tableID, MenuItem[] itemList, Staff orderCreator, Customer patron){
        this.tableID = tableID;
        this.orderCreator = orderCreator;
        this.patron = patron;
        this.itemList = new MenuItem[itemList.length];
        this.subTotal = 0;
        //this.timestamp = ?
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
        String restaurantName = "Happy Chicken Diner";
        int rowLength = 63;
        for (int i = 0; i < rowLength; i++) { // print a ----- row
            System.out.print("-");
        }
        System.out.println();
        String leftFormat = "%-"+((rowLength/2)-(restaurantName.length()/2))+"s";
        String rightFormat = "%"+((rowLength/2)-(restaurantName.length()/2))+"s";
        System.out.format(leftFormat, "|");
        System.out.print(restaurantName);
        System.out.format(rightFormat, "|");
        for (int i = 0; i < rowLength; i++) { // print a ----- row
            System.out.print("-");
        }
        System.out.println();


    }


}