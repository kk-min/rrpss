package Classes.AMenuItem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * MenuInterface - the manager for our restaurant Menu
 * 
 * 
 */
public class MenuInterface  {

	private static Scanner input = new Scanner(System.in);
	
    private static ArrayList<MainDish> maindishes;
    private static ArrayList<Beverage> beverages;
    private static ArrayList<Dessert> desserts;
    private static ArrayList<Promotional> promotionals;

	public MenuInterface() {
        maindishes = new ArrayList<>();
		beverages = new ArrayList<>();
		desserts = new ArrayList<>();
		promotionals = new ArrayList<>();
		initialiseMenu();
    }

	/**
     * initialiseMenu()
	 * defalt menu options
     */
    public static void initialiseMenu()
	{
		MainDish myDish = new MainDish(1, "Chicken Rice", 3.00, "Flavourful chicken, juicy and fresh");
		maindishes.add(myDish);
		Beverage myBeverage = new Beverage(1, "Ice Milo", 1.00, "Chilling milo to start your day");
		beverages.add(myBeverage);
		Dessert myDessert = new Dessert(1, "Gelato", 5.00, "Silky smooth texture");
		desserts.add(myDessert);
		Promotional myPromo = new Promotional(1,"Chicken Family Combo", 10.00, "Fambam! Have 4 sets of chicken rice to feed the family.");
		promotionals.add(myPromo);
	}

	/**
     * The Food Menu Items Management Menu
     * generateMenuScreen
     * @return Exit Code. Return -1 to exit the program 
     */
	// every function is public static so that it can be accessed without creating an object
	public static int generateMenuScreen() {
		// TODO: make it loop
		System.out.println("Menu Items Management" );
        System.out.println("1) View Menu");
        System.out.println("2) Create a new A la Carte item");
        System.out.println("3) Update an existing A la Carte item's details");
        System.out.println("4) Delete an existing A la Carte item");
		System.out.println("5) Create a new Promotional item");
		System.out.println("6) Update an existing Promotional item's details");
		System.out.println("7) Delete an existing Promotional item");
        System.out.println("8) Back to main menu");

		int choice = input.nextInt();
        switch (choice) {
            case 1: // Prints menu
                displayMenu();
                break;
            case 2: // Create new menu item
                addAlaCarteItem();
                break;
            case 3: // Edit an existing menu item
				updateAlaCarteItem();
                break;
            case 4: // Delete an existing menu item
                deleteAlaCarteItem();
                break;
			case 5: // Create a new promo item
                addPromoItem();
                break;
			case 6: // Edit an existing promo item's details
				updatePromoItem();
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

		for(int i=0;i<maindishes.size();i++)
		{
			System.out.printf("%s %20s %20s %20.2f\n", maindishes.get(i).getId(), maindishes.get(i).getName(), maindishes.get(i).getDescription(), maindishes.get(i).getPrice());
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

    public static void addAlaCarteItem()
	{
		String Mname, Mdescription;
		Mname = "";
		Mdescription = "";
		double Mprice;

		System.out.println("What is the name of the new item?");
		Mname += input.nextLine();
		System.out.println("What is the price of this item?");
		Mprice = input.nextDouble();
		input.nextLine();
		System.out.println("What is the description of the item?");
		Mdescription += input.nextLine();
		System.out.println("What type of item is the new menu item (Main 1)/(Beverage 2)/(Dessert 3)?");
		int choice = input.nextInt();
		input.nextLine();
		switch (choice)
		{   
			case 1:
			{
				MainDish newitem = new MainDish((maindishes.size()+1), Mname, Mprice, Mdescription);
				maindishes.add(newitem);
				System.out.println("New Main Dish added successfully!");
			}
			break;
			case 2:
			{
				Beverage newitem = new Beverage((beverages.size()+1), Mname, Mprice, Mdescription);
				beverages.add(newitem);
				System.out.println("New Beverage added successfully!");
			}
			break;
			case 3:
			{
				Dessert newitem = new Dessert((desserts.size()+1), Mname, Mprice, Mdescription);
				desserts.add(newitem);
				System.out.println("New Dessert added successfully!");
			}
			break;
		}
	}

	public static void updateAlaCarteItem()
	{
		int id, choiceType, choiceDetail, check = 0;
		System.out.println("What type of item is the menu item to be updated (Main 1)/(Beverage 2)/(Dessert 3)?");
		choiceType = input.nextInt();
		input.nextLine();
		System.out.println("What is the ID of the item to be updated?");
		id = input.nextInt();
		System.out.println("What detail would you like to update (Name 1)/(Description 2)/(Price 3)?");
		choiceDetail = input.nextInt();
		input.nextLine();

		switch (choiceType)
		{
			case 1:
			{
				for(int i=0;i<maindishes.size();i++)
				{
					if (id == maindishes.get(i).getId())
					{
						switch (choiceDetail)
						{
							case 1:
							{
								System.out.println("What is the new name of the Main Dish?");
								String newname = input.nextLine();
								maindishes.get(i).setName(newname);
							}
							break;
							case 2: {
								System.out.println("What is the new description of the Main Dish?");
								String newdes = input.nextLine();
								maindishes.get(i).setDescription(newdes);
							}
							break;
							case 3: {
								System.out.println("What is the new price of the Main Dish?");
								double newprice = input.nextDouble();
								maindishes.get(i).setPrice(newprice);
							}
							break;
						}
						check = 1;
						break;
					}
				}
			}
			break;
			case 2:
			{
				for(int i=0;i<beverages.size();i++)
				{
					if (id==beverages.get(i).getId())
					{
						switch (choiceDetail)
						{
							case 1:
							{
								System.out.println("What is the new name of the Beverage?");
								String newname = input.nextLine();
								beverages.get(i).setName(newname);
							}
							break;
							case 2: {
								System.out.println("What is the new description of the Beverage?");
								String newdes = input.nextLine();
								beverages.get(i).setDescription(newdes);
							}
							break;
							case 3: {
								System.out.println("What is the new price of the Beverage?");
								double newprice = input.nextDouble();
								beverages.get(i).setPrice(newprice);
							}
							break;
						}
						check = 1;
						break;
					}
				}
			}
			break;
			case 3:
			{
				for(int i=0;i<desserts.size();i++)
				{
					if (id==desserts.get(i).getId())
					{
						switch (choiceDetail)
						{
							case 1:
							{
								System.out.println("What is the new name of the Dessert?");
								String newname = input.nextLine();
								desserts.get(i).setName(newname);
							}
							break;
							case 2: {
								System.out.println("What is the new description of the Dessert?");
								String newdes = input.nextLine();
								desserts.get(i).setDescription(newdes);
							}
							break;
							case 3: {
								System.out.println("What is the new price of the Dessert?");
								double newprice = input.nextDouble();
								desserts.get(i).setPrice(newprice);
							}
							break;
						}
						check = 1;
						break;
					}
				}
			}
			break;
		}

		if (check == 1)
			System.out.print("Updated successfully!");
		else
			System.out.println("Updating Failed...");
	}

	public static void deleteAlaCarteItem()
	{
		int id, check = 0;
		System.out.println("What type of item do you want to delete (Main 1)/(Beverage 2)/(Dessert 3)?");
		int choice = input.nextInt();
		System.out.println("What is the ID of the item to be deleted?");
		id = input.nextInt();

		switch (choice)
		{
			case 1:
			{
				for(int i=0;i<maindishes.size();i++)
				{
					if (id == maindishes.get(i).getId())
					{
						check = 1;
						maindishes.remove(i);
						for (int j = i; j < maindishes.size(); j++)
						{
							maindishes.get(j).setId(j+1);
						}
						break;
					}
				}
			}
			break;
			case 2:
			{
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
						break;
					}
				}
			}
			break;
			case 3:
			{
				for(int i=0;i<desserts.size();i++)
				{
					if (id == desserts.get(i).getId())
					{
						check = 1;
						desserts.remove(i);
						for (int j = i; j < desserts.size(); j++)
						{
							desserts.get(j).setId(j + 1);
						}
						break;
					}
				}
			}
			break;
		}
		
		if (check == 1)
			System.out.print("Deleted successfully!");
		else
			System.out.println("Deletion Failed...");
	}

	public static void addPromoItem()
	{
		String Mname,Mdescription;
		Mname = "";
		Mdescription = "";
		double Mprice;

		System.out.println("What is the name of the new promo Dish?");
		Mname += input.nextLine();
		System.out.println("What is the price of this item?");
		Mprice = input.nextDouble();
		input.nextLine();
		System.out.println("What is the description of the item?");
		Mdescription += input.nextLine();
		Promotional newitem = new Promotional((promotionals.size() + 1), Mname, Mprice, Mdescription);
		promotionals.add(newitem);
		System.out.println("Promotional item added successfully!");
	}

	public static void updatePromoItem()
	{
		System.out.println("What is the ID of the Promotional Item to be updated?");
		int id = input.nextInt();
		System.out.println("What detail would you like to update (Name 1)/(Description 2)/(Price 3)?");
		int choice = input.nextInt();
		input.nextLine();
		int check = 0;
		for(int i=0;i<promotionals.size();i++)
		{
			if (id == promotionals.get(i).getId())
			{
				switch (choice)
				{
					case 1:
					{
						System.out.println("What is the new name of the Promotional Item?");
						String newname = input.nextLine();
						promotionals.get(i).setName(newname);
					}
					break;
					case 2: {
						System.out.println("What is the new description of the Promotional Item?");
						String newdes = input.nextLine();
						promotionals.get(i).setDescription(newdes);
					}
					break;
					case 3: {
						System.out.println("What is the new price of the Promotional Item?");
						double newprice = input.nextDouble();
						promotionals.get(i).setPrice(newprice);
					}
					break;
				}
				check = 1;
				break;
			}
		}

		if (check == 1)
			System.out.print("Updated successfully!");
		else
			System.out.println("Update Failed...");
	}

	public static void deletePromoItem()
	{

		System.out.println("What is the ID of the Promotion Item to be deleted?");
		int id = input.nextInt();
		int check = 0;
		for(int i=0;i<promotionals.size();i++)
		{
			if (id==promotionals.get(i).getId())
			{
				check = 1;
				promotionals.remove(i);
				for (int j = i; j < promotionals.size(); j++)
				{
					promotionals.get(j).setId(j + 1);
				}
				break;
			}
		}

		if (check == 1)
			System.out.print("Deleted successfully!");
		else
			System.out.println("Deletion Failed...");
	}

	public static MainDish getMainDish(int Id) {
		return maindishes.get(Id-1);
	}

	public static Beverage getBeverage(int Id) {
		return beverages.get(Id-1);
	}

	public static Dessert getDessert(int Id) {
		return desserts.get(Id-1);
	}

	public static Promotional getPromotional(int Id) {
		return promotionals.get(Id-1);
	}
}
	

