public class SalesRevenueReport {
    private ArrayList<Order> orderList;
    private Staff[] staffList;
    private String period;
    private double totalRevenue;

    public SalesRevenueReport(ArrayList<Order> orderList, Staff[] staffList, String period){
        int i = 0;
        this.totalRevenue = 0;
        this.orderList = new ArrayList<Order>;
        for (Order order: orderList){
            this.orderList[i].add(order);
            this.totalRevenue += order.getGrandTotal();

        }

        i = 0;
        this.staffList = new Staff[staffList.length];
        for (Staff staff : staffList){
            this.staffList[i] = staff;
        }

        this.period = period;
    }



}
