public class SalesRevenueReport {
    private Order[] orderList;
    private Staff[] staffList;
    private String period;
    private double totalRevenue;

    public SalesRevenueReport(Order[] orderList, Staff[] staffList, String period){

        int i = 0;
        this.totalRevenue = 0;
        this.orderList = new Order[orderList.length];
        for (Order order: orderList){
            this.orderList[i] = order;
            this.totalRevenue += order.getGrandTotal();
            i++;
        }

        i = 0;
        this.staffList = new Staff[staffList.length];
        for (Staff staff : staffList){
            this.staffList[i] = staff;
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

        //Line 3:
        for (int i = 0; i < rowLength; i++) { // print a ----- row
            System.out.print("-");
        }
        System.out.println();

        //Line 4 and 5:
        String totalStaffString = "| Total Staff: "+staffList.length;
        System.out.print(totalStaffString);
        System.out.format("%"+(rowLength-totalStaffString.length())+"s", "|");
        System.out.println();
        String totalOrderString = "| Orders fulfilled: "+orderList.length;
        System.out.print(totalOrderString);
        System.out.format("%"+(rowLength-totalOrderString.length())+"s", "|");
        System.out.println();

        //Line 6:
        for (int i = 0; i < rowLength; i++) { // print a ----- row
            System.out.print("-");
        }
        System.out.println();

        //Line 7:
        System.out.print("| Sales Revenue");
        String revenueFormat = "%"+(rowLength-15)+"s";
        String revenueString = "|    $"+this.totalRevenue+"    |";
        System.out.format(revenueFormat, revenueString);
        System.out.println();
        //Line 8:

        for (int i = 0; i < rowLength; i++) { // print a ----- row
            System.out.print("-");
        }
        System.out.println();

        //Line 9:
        System.out.print("| Earnings before income tax");
        String beforeTaxFormat = "%"+(rowLength-28)+"s";
        String beforeTaxString = "|    $"+(this.totalRevenue)+"    |";
        System.out.format(beforeTaxFormat, beforeTaxString);
        System.out.println();

        //Line 10:
        for (int i = 0; i < rowLength; i++) { // print a ----- row
            System.out.print("-");
        }
        System.out.println();

        //Line 11:

        System.out.println("| Income tax expense");
        String incomeTaxFormat = "%"+(rowLength-20)+"s";
        String incomeTaxString = "|    $"+(this.totalRevenue*(double)(7/107))+"    |";
        System.out.format(incomeTaxFormat, incomeTaxString);
        System.out.println();

        //Line 12:
        for (int i = 0; i < rowLength; i++) { // print a ----- row
            System.out.print("-");
        }
        System.out.println();

        //Line 13:

        System.out.println("| Net income");
        String netIncomeFormat = "%"+(rowLength-12)+"s";
        String netIncomeString = "|    $"+(this.totalRevenue*(double)(100/107))+"    |";
        System.out.format(netIncomeFormat, netIncomeString);
        System.out.println();

        //Line 14:

        for (int i = 0; i < rowLength; i++) { // print a ----- row
            System.out.print("-");
        }
        System.out.println();



    }



}
