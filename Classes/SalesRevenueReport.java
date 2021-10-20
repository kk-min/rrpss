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



}
