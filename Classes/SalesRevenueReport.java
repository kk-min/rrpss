public class SalesRevenueReport {
    private Order[] orderList;
    private String period;
    private double totalRevenue;

    public SalesRevenueReport(Order[] orderList, String period){
        int i = 0;
        this.orderList = new Order[orderList.length];
        for (Order order: orderList){
            this.orderList[i] = order;
            i++;
        }

        this.period = period;



    }

    public void generateReport(){
        String Header = "SALES REVENUE REPORT" +" ("+this.period+")";
        int rowLength = 63;
        //Line 1:
        for (int i = 0; i < rowLength; i++) { // print a ----- row
            System.out.print("-");
        }
        System.out.println();
        //Line 2:
        String leftFormat = "%-"+((rowLength/2)-(Header.length()/2))+"s";
        String rightFormat = "%"+((rowLength/2)-(Header.length()/2))+"s";
        System.out.format(leftFormat, "|");
        System.out.print(Header);
        System.out.format(rightFormat, "|");
        System.out.println();
    }



}
