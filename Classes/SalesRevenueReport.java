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



}
