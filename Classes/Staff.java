public class Staff {
    private int ID;
    private String name;
    private String gender;
    private String jobTitle;
 
    public Staff(int ID, String name, String gender, String jobTitle) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.jobTitle = jobTitle;
    }

    public Order createOrder(int tableID, MenuItem[] itemList, Customer patron) {
        Order newOrder = new Order(tableID, itemList, this, patron);
        return newOrder;
    }

    public MenuItem createMenuItem(Menu menu) {
        MenuItem newMenuItem = new MenuItem(); // TODO: pass in parameters, add new item to Menu
        return newMenuItem;
    }

    public void updateMenuItem(MenuItem item) {
        // TODO: take in parameters, update menu item
    }

    public removeMenuItem(Menu menu) {
        // TODO: remove menu item from menu
    }

    public createPromotion() {

    }

    public updatePromotion() {

    }

    public removePromotion() {

    }
}
