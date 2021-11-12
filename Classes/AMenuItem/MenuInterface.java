package Classes.AMenuItem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * MenuInterface- the interface for our restaurant Menu
 * 
 * 
 */
public class MenuInterface  {
	/**
     * initiateMenu()
     * generateMenuScreen()
     * displayMenu()
     * addMenuItem()
     * updateMenuItem()
     * addPromoItem()
     * deleteMenuItem()
     * deletePromoItem()
     * getMaindish(int Id)
	 * getBeverage(int Id)
	 * getDessert(int Id)
	 * getPromotional(int Id)
     */

   

    private static ArrayList<MainDish> maindishs = new ArrayList<>();
    private static ArrayList<Beverage> beverages = new ArrayList<>();
    private static ArrayList<Dessert> desserts = new ArrayList<>();
    private static ArrayList<Promotional>  promotionals = new ArrayList<>();
	/**
     * initiateMenu()
	 * defalt menu option
     */
    public static void initiateMenu()
	{
		MainDish myDish = new MainDish(1, "Chicken rice", 3.00, "Flavourful chicken, juicy and fresh");
		maindishs.add(myDish);
		Beverage mybeverage = new Beverage(1, "Ice Milo", 1.00, "Chilling milo to start your day");
		beverages.add(mybeverage);
		Dessert mydesert = new Dessert(1, "gelato", 5.00, "Silky smooth texture");
		desserts.add(mydesert);
		Promotional mypromo = new Promotional(1,"chicken rice *2",5.00,"hungry for 2?");
		promotionals.add(mypromo);
		//desserts mydesert = new 
	}
	/**
     * The Food Menu Items Management Menu
     * generateMenuScreen
     * @return Exit Code. Return -1 to exit the program 
     */
	
	//everyfunction is public static so that it can be accessed without creating a function
	public static int generateMenuScreen() {


		System.out.println("Menu Items Management" );
        System.out.println("1) Print existing menu");
        System.out.println("2) Create a new AlaCart item");
        System.out.println("3) Edit an existing AlaCart item's details");
        System.out.println("4) Delete a AlaCart item");
		System.out.println("5) Create a new promo item");
		System.out.println("6) Edit an existing promo item's details");
		System.out.println("7) Delete a promo item");
        System.out.println("8) Back to main menu");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
        switch (choice) {
            case 1: // Prints menu
                displayMenu();
                break;
            case 2: // Create new menu item
                addMenuItem();
                break;
            case 3: // Edit an existing menu item
				updateMenuItem();
                break;
            case 4: // Delete an existing menu item
                deleteMenuItem();
                break;
			case 5: // Create a new promo item
                addPromoItem();
                break;
			case 6: // Edit an existing promo item's details
				updateMenuItem();
                break;
			case 7: // Delete a promo item"
				deletePromoItem();
                break;
            case 8:
                return -1;


            default:
				return -1;
        }
        return 1;
        
    }


    public static void displayMenu()
	{

		System.out.printf("%s %15s %15s %15s", "Item ID", "Menu Item","Description","Price");
		System.out.println("");
		System.out.println("Main Dishes---------------------------------------");

		for(int i=0;i<maindishs.size();i++)
		{
			System.out.printf("%s %20s %20s %20.2f\n", maindishs.get(i).getId(), maindishs.get(i).getName(), maindishs.get(i).getDescription(), maindishs.get(i).getPrice());
		}
		System.out.println("");
		System.out.println("Desserts-----------------------------------------");
		for(int i=0;i<desserts.size();i++)
		{
			System.out.printf("%s %20s %20s %20.2f\n", desserts.get(i).getId(), desserts.get(i).getName(), desserts.get(i).getDescription(), desserts.get(i).getPrice());
		}
		System.out.println("");
		System.out.println("Beverages----------------------------------------");
		for(int i=0;i<beverages.size();i++)
		{
			System.out.printf("%s %20s %20s %20.2f\n", beverages.get(i).getId(), beverages.get(i).getName(), beverages.get(i).getDescription(), beverages.get(i).getPrice());
		}
		System.out.println("");
		System.out.println("Promotion Bundles----------------------------------------");
		for(int i=0;i<promotionals.size();i++)
		{
			System.out.printf("%s %20s %20s %20.2f\n", promotionals.get(i).getId(), promotionals.get(i).getName(), promotionals.get(i).getDescription(), promotionals.get(i).getPrice());
		}
		System.out.println("");
	}
	

    public static void addMenuItem()
	{
		String Mname,Mdescription;
		Mname = "";
		Mdescription = "";
		double Mprice;
		System.out.println("What type of item is the new menu item(Main 1)/(Beverage 2)/(Dessert 3)?");
		Scanner sc = new Scanner(System.in);
        
		int choice = sc.nextInt();
		sc.nextLine();
		switch (choice)
		{   

			case 1:
			{   
                
				System.out.println("What is the name of the new Main Dish?");
				Mname += sc.nextLine();
				System.out.println("What is the price of this item?");
				Mprice = sc.nextDouble();
				sc.nextLine();
				System.out.println("What is the description of the item?");
				Mdescription += sc.nextLine();
				MainDish newitem =new MainDish((maindishs.size()+1),Mname,Mprice,Mdescription);
				maindishs.add(newitem);
				System.out.println("Main Dish item added...");
                
			}
			break;
			case 2:
			{
				System.out.println("What is the name of the new Beverage?");
				Mname += sc.nextLine();
				System.out.println("What is the price of this item?");
				Mprice = sc.nextDouble();
				sc.nextLine();
				System.out.println("What is the description of the item?");
				Mdescription += sc.nextLine();
				Beverage newitem =new Beverage((beverages.size()+1),Mname,Mprice,Mdescription);
				beverages.add(newitem);
				System.out.println("Beverage item added...");
			}
			break;
			case 3:
			{
				System.out.println("What is the name of the new Dessert?");
				Mname += sc.nextLine();
				System.out.println("What is the price of this item?");
				Mprice = sc.nextDouble();
				sc.nextLine();
				System.out.println("What is the description of the item?");
				Mdescription += sc.nextLine();
				Dessert newitem =new Dessert((desserts.size()+1),Mname,Mprice,Mdescription);
				desserts.add(newitem);
				System.out.println("Dessert item added...");
			}
			break;
		}
	}

	public static void updateMenuItem()
	{
		int id;
		System.out.println("What type of item is the menu item to be updated(Main 1)/(Beverage 2)/(Dessert 3)?");
		Scanner sc = new Scanner(System.in);
        
		int choice = sc.nextInt();
		sc.nextLine();

		switch (choice)
		{
			case 1:
			{
				System.out.println("What is the Item ID of the Main Dish to be updated?");
				id = sc.nextInt();
				System.out.println("What of it would you like to update (Name 1)/(Description 2)/(Price 3)?");
				choice = sc.nextInt();
				sc.nextLine();
				int check =0;
				for(int i=0;i<maindishs.size();i++)
				{
					if (id == maindishs.get(i).getId())
					{
						switch (choice)
						{
							case 1:
							{
								System.out.println("What is the new name of the Main Dish?");
								String newname = sc.nextLine();
								maindishs.get(i).setName(newname);
							}
							break;
							case 2: {
								System.out.println("What is the new description of the Main Dish?");
								String newdes = sc.nextLine();
								maindishs.get(i).setDescription(newdes);
							}
							break;
							case 3: {
								System.out.println("What is the new price of the Main Dish?");
								double newprice = sc.nextDouble();
								maindishs.get(i).setPrice(newprice);
							}
							break;
						}
						check =1;
					}
				}
				if(check ==0)
				{
					System.out.println("Updating Failed...");
				}

			}
			break;
			case 2:
			{
				System.out.println("What is the Item ID of the Beverage to be updated?");
				id = sc.nextInt();
				System.out.println("What of it would you like to update (Name 1)/(Description 2)/(Price 3)?");
				choice = sc.nextInt();
				sc.nextLine();
				int check =0;
				for(int i=0;i<beverages.size();i++)
				{
					if (id==beverages.get(i).getId())
					{
						switch (choice)
						{
							case 1:
							{
								System.out.println("What is the new name of the Beverage?");
								String newname = sc.nextLine();
								beverages.get(i).setName(newname);
							}
							break;
							case 2: {
								System.out.println("What is the new description of the Beverage?");
								String newdes = sc.nextLine();
								beverages.get(i).setDescription(newdes);
							}
							break;
							case 3: {
								System.out.println("What is the new price of the Beverage?");
								double newprice = sc.nextDouble();
								beverages.get(i).setPrice(newprice);
							}
							break;
						}
						check =1;
					}
				}
				if(check ==0)
				{
					System.out.println("Updating Failed...");
				}
			}
			break;
			case 3:
			{
				System.out.println("What is the Item ID of the Dessert to be updated?");
				id = sc.nextInt();
				System.out.println("What of it would you like to update (Name 1)/(Description 2)/(Price 3)?");
				choice = sc.nextInt();
				sc.nextLine();
				int check =0;
				for(int i=0;i<desserts.size();i++)
				{
					if (id==desserts.get(i).getId())
					{
						switch (choice)
						{
							case 1:
							{
								System.out.println("What is the new name of the Dessert?");
								String newname = sc.nextLine();
								desserts.get(i).setName(newname);
							}
							break;
							case 2: {
								System.out.println("What is the new description of the Dessert?");
								String newdes = sc.nextLine();
								desserts.get(i).setDescription(newdes);
							}
							break;
							case 3: {
								System.out.println("What is the new price of the Dessert?");
								double newprice = sc.nextDouble();
								desserts.get(i).setPrice(newprice);
							}
							break;
						}
						check =1;
					}
				}
				if(check ==0)
				{
					System.out.println("Updating Failed...");
				}
			}
			break;
		}
	}
	public static void addPromoItem()
	{
		String Mname,Mdescription;
		Mname = "";
		Mdescription = "";
		double Mprice;
		Scanner sc = new Scanner(System.in);


		System.out.println("What is the name of the new promo Dish?");
		Mname += sc.nextLine();
		System.out.println("What is the price of this item?");
		Mprice = sc.nextDouble();
		sc.nextLine();
		System.out.println("What is the description of the item?");
		Mdescription += sc.nextLine();
		Promotional newitem =new Promotional((promotionals.size() + 1),Mname,Mprice,Mdescription);
		promotionals.add(newitem);
		System.out.println("promo item added...");
	}



	public static void updatePromoItem()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the Item ID of the Promotion to be updated?");
		int id = sc.nextInt();
		System.out.println("What of it would you like to update (Name 1)/(Description 2)/(Price 3)?");
		int choice = sc.nextInt();
		sc.nextLine();
		int check =0;
		for(int i=0;i<promotionals.size();i++)
		{
			if (id==promotionals.get(i).getId())
			{
				switch (choice)
				{
					case 1:
					{
						System.out.println("What is the new name of the Main Dish?");
						String newname = sc.nextLine();
						promotionals.get(i).setName(newname);
					}
					break;
					case 2: {
						System.out.println("What is the new description of the Main Dish?");
						String newdes = sc.nextLine();
						promotionals.get(i).setDescription(newdes);
					}
					break;
					case 3: {
						System.out.println("What is the new price of the Main Dish?");
						double newprice = sc.nextDouble();
						promotionals.get(i).setPrice(newprice);
					}
					break;
				}
				check =1;
			}
		}
		if(check ==0)
		{
			System.out.println("Updating Failed...");
		}
	}

	public static void deleteMenuItem()
	{
		int id ;
		System.out.println("What type of item is the menu item to be deleted (Main 1)/(Beverage 2)/(Dessert 3)?");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		switch (choice)
		{
			case 1:
			{
				System.out.println("What is the itemID of the Main Dish to be deleted?");
				id = sc.nextInt();
				int check = 0;
				for(int i=0;i<maindishs.size();i++)
				{
					if (id==maindishs.get(i).getId())
					{
						check = 1;
						maindishs.remove(i);
						for (int j = i; j < maindishs.size(); j++)
						{
							maindishs.get(j).setId(j+1);
						}
					}
				}
				if(check ==0)
				{
					System.out.println("Deleting Failed...");
				}
			}
			break;
			case 2:
			{
				System.out.println("What is the itemID of the Beverage to be deleted?");
				id = sc.nextInt();
				int check = 0;
				for(int i=0;i<beverages.size();i++)
				{
					if (id == beverages.get(i).getId())
					{
						check = 1;
						beverages.remove(i);
						for (int j = i; j < beverages.size(); j++)
						{
							beverages.get(j).setId(j + 1);
						}
					}
				}
				if(check ==0)
				{
					System.out.println("Deleting Failed...");
				}
			}
			break;
			case 3:
			{
				System.out.println("What is the itemID of the Beverage to be deleted?");
				id = sc.nextInt();
				int check = 0;
				for(int i=0;i<desserts.size();i++)
				{
					if (id ==desserts.get(i).getId())
					{
						check = 1;
						desserts.remove(i);
						for (int j = i; j < desserts.size(); j++)
						{
							desserts.get(j).setId( j + 1);
						}
					}
				}
				if(check ==0)
				{
					System.out.println("Deleting Failed...");
				}
			}
			break;
		}
	}
	public static void deletePromoItem()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the itemID of the Promotion Bundle to be deleted?");
		int id = sc.nextInt();
		int check = 0;
		for(int i=0;i<promotionals.size();i++)
		{
			if (id==promotionals.get(i).getId())
			{
				check = 1;
				promotionals.remove(i);
				for (int j = i; j < promotionals.size(); j++)
				{
					promotionals.get(j).setId (j + 1);
				}
			}
		}
		if(check ==0)
		{
			System.out.println("Deleting Failed...");
		}
	}

	public static MainDish getMaindish(int Id)
	{
		
		return maindishs.get(Id+1);

	}
	public static Beverage getBeverage(int Id)
	{
		
		return beverages.get(Id+1);

	}
	public static Dessert getDessert(int Id)
	{
		
		return desserts.get(Id+1);

	}
	public static Promotional getPromotional(int Id)
	{
		
		return promotionals.get(Id+1);

	}
			
		
	
	
}
	

