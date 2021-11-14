package Classes.AMenuItem;

import java.util.ArrayList;

import Classes.Printer.UserInterfacePrinter;
/**
 * The MenuManager Class
 * our restaurant menu's manager
 * @author Lingyi
 * @author Her Huey
 * @version 2.0
 * @since 2021-11-03
 */
public class MenuManager extends UserInterfacePrinter{
	/**
     * The ArrayList to store MainDish Objects
     */
    private static ArrayList<MainDish> maindishes;
	/**
     * The ArrayList to store Beverage Objects
     */
    private static ArrayList<Beverage> beverages;
	/**
     * The ArrayList to store Dessert Objects
     */
    private static ArrayList<Dessert> desserts;
	/**
     * The ArrayList to store Dessert Promotional objects
     */
    private static ArrayList<Promotional> promotionals;

	/**
	 * Initialises default menu items in the menu
     */
    public static void initialiseMenu() {

		maindishes = new ArrayList<MainDish>();
		beverages = new ArrayList<Beverage>();
		desserts = new ArrayList<Dessert>();
		promotionals = new ArrayList<Promotional>();
		
		MainDish myDish = new MainDish(1, "Chicken Rice", 3.50, "Hainanese style, fragrant chicken rice.");
		maindishes.add(myDish);
		MainDish myDish1 = new MainDish(2, "Roasted Lemon Rosemary Chicken", 12.90, "A tender and flavourful oven-roasted chicken.");
		maindishes.add(myDish1);
		MainDish myDish2 = new MainDish(3, "Teriyaki Chicken Pasta", 9.80, "Delicious marriage of Japanese and Western cuisine.");
		maindishes.add(myDish2);

		Beverage myBeverage = new Beverage(1, "Iced Lemon Tea", 1.80, "Tangy, fruity, and refreshing for a hot summer day.");
		beverages.add(myBeverage);
		Beverage myBeverage1 = new Beverage(2, "Vanilla Milkshake", 5.60, "A sweet treat for you!");
		beverages.add(myBeverage1);
		Beverage myBeverage2 = new Beverage(3, "Chocolate Hazelnut Milk", 4.30, "A warm and fuzzy combination that hits home every time.");
		beverages.add(myBeverage2);

		Dessert myDessert = new Dessert(1, "Sweet Potato Soup with Barley", 2.50, "A healthy and earthy taste.");
		desserts.add(myDessert);
		Dessert myDessert1 = new Dessert(2, "Chicken and Waffles", 14.80, "The timeless sweet and savory combination.");
		desserts.add(myDessert1);
		Dessert myDessert2 = new Dessert(3, "Gelato", 5.00, "The silky smooth texture that you'll keep returning for.");
		desserts.add(myDessert2);

		Promotional myPromo = new Promotional(1,"Chicken Family Combo", 18.00, "Have 4 sets of chicken dishes to feed the family.");
		promotionals.add(myPromo);
		Promotional myPromo1 = new Promotional(2,"Full Roasted Chicken", 20.90, "A whole roasted chicken for sharing.");
		promotionals.add(myPromo1);
		Promotional myPromo2 = new Promotional(3,"Double Scoop Gelato", 8.00, "Double the fun!");
		promotionals.add(myPromo2);
	}

	/**
	 * Prints out the whole menu.
	 */
    public static void displayMenu()
	{
		// Line 1:
		System.out.printf("-".repeat(rowLength));
		System.out.println();

		// Line 2:
		String MenuName = "MENU";
		String leftFormat = "%-" + ((rowLength / 2) - (MenuName.length() / 2)) + "s";
		String rightFormat = "%" + ((rowLength / 2) - (MenuName.length() / 2)) + "s";
		System.out.format(leftFormat, " ");
		System.out.print(MenuName);
		System.out.format(rightFormat, " ");
		System.out.println();

		//Line 3:
		System.out.printf("-".repeat(rowLength));
		System.out.println();

		//Line 4:
		String mainString = "MAIN COURSE";
		leftFormat = "%-" + ((rowLength / 2) - (mainString.length() / 2)) + "s";
		rightFormat = "%" + ((rowLength / 2) - (mainString.length() / 2)) + "s";
		System.out.format(leftFormat, " ");
		System.out.print(mainString);
		System.out.format(rightFormat, " ");
		System.out.println();
		//Line 5:
		System.out.println();

		for(int i=0;i<maindishes.size();i++)
		{
			System.out.println("ID: "+maindishes.get(i).getId());
			System.out.println("Name: "+maindishes.get(i).getName());
			System.out.println("Description: "+maindishes.get(i).getDescription());
			System.out.printf("Price: S$%.2f\n", maindishes.get(i).getPrice());
			System.out.println();
		}
		System.out.printf("-".repeat(rowLength));
		System.out.println();

		String beveragesString = "BEVERAGES";
		leftFormat = "%-" + ((rowLength / 2) - (beveragesString.length() / 2)) + "s";
		rightFormat = "%" + ((rowLength / 2) - (beveragesString.length() / 2)) + "s";
		System.out.format(leftFormat, " ");
		System.out.print(beveragesString);
		System.out.format(rightFormat, " ");
		System.out.println();
		//Line 5:
		System.out.println();


		for(int i=0;i<beverages.size();i++)
		{
			System.out.println("ID: "+beverages.get(i).getId());
			System.out.println("Name: "+beverages.get(i).getName());
			System.out.println("Description: "+beverages.get(i).getDescription());
			System.out.printf("Price: S$%.2f\n",beverages.get(i).getPrice());
			System.out.println();
		}

		System.out.printf("-".repeat(rowLength));
		System.out.println();

		String dessertsString = "DESSERTS";
		leftFormat = "%-" + ((rowLength / 2) - (dessertsString.length() / 2)) + "s";
		rightFormat = "%" + ((rowLength / 2) - (dessertsString.length() / 2)) + "s";
		System.out.format(leftFormat, " ");
		System.out.print(dessertsString);
		System.out.format(rightFormat, " ");
		System.out.println();
		//Line 5:
		System.out.println();


		for(int i=0;i<desserts.size();i++)
		{
			System.out.println("ID: "+desserts.get(i).getId());
			System.out.println("Name: "+desserts.get(i).getName());
			System.out.println("Description: "+desserts.get(i).getDescription());
			System.out.printf("Price: S$%.2f\n",desserts.get(i).getPrice());
			System.out.println();
		}

		System.out.printf("-".repeat(rowLength));
		System.out.println();

		

		String promotionString = "PROMOTIONAL BUNDLES";
		leftFormat = "%-" + ((rowLength / 2) - (promotionString.length() / 2)) + "s";
		rightFormat = "%" + ((rowLength / 2) - (promotionString.length() / 2)) + "s";
		System.out.format(leftFormat, " ");
		System.out.print(promotionString);
		System.out.format(rightFormat, " ");
		System.out.println();
		//Line 5:
		System.out.println();

		for(int i=0;i<promotionals.size();i++)
		{
			System.out.println("ID: "+promotionals.get(i).getId());
			System.out.println("Name: "+promotionals.get(i).getName());
			System.out.println("Description: "+promotionals.get(i).getDescription());
			System.out.printf("Price: S$%.2f\n", promotionals.get(i).getPrice());
			System.out.println();
		}
		System.out.printf("-".repeat(rowLength));
		System.out.println();
	}

	/**
	 * Allows user to add an AlaCarte Item to the menu.
	 */
    public static void addAlaCarteItem()
	{
		String Mname, Mdescription;
		Mname = "";
		Mdescription = "";
		double Mprice;

		System.out.println("What is the name of the new item?");
		Mname += input.nextLine();
		System.out.println("What is the price of this item?");
		Mprice = input.nextDouble(); input.nextLine();
		System.out.println("What is the description of the item?");
		Mdescription += input.nextLine();
		System.out.println("What type of item is the new menu item (Main Dish 1)/(Beverage 2)/(Dessert 3)?");
		int choice = input.nextInt(); input.nextLine();
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

	/**
	 * Allows user to change the details of an AlaCarte Item on the menu.
	 */
	public static void updateAlaCarteItem()
	{
		System.out.println("Here is the current menu:\n---");
		displayMenu();
		int id, choiceType, choiceDetail, check = 0;
		System.out.println("What type of item is the menu item to be updated (Main Dish 1)/(Beverage 2)/(Dessert 3)?");
		choiceType = input.nextInt(); input.nextLine();
		System.out.println("What is the ID of the item to be updated?");
		id = input.nextInt(); input.nextLine();
		System.out.println("What detail would you like to update (Name 1)/(Description 2)/(Price 3)?");
		choiceDetail = input.nextInt(); input.nextLine();

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
								double newprice = input.nextDouble(); input.nextLine();
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
								double newprice = input.nextDouble(); input.nextLine();
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
								double newprice = input.nextDouble(); input.nextLine();
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

	/**
	 * Allows user to delete an AlaCarte Item on the menu.
	 */
	public static void deleteAlaCarteItem()
	{
		System.out.println("Here is the current menu:\n---");
		displayMenu();
		int id, check = 0;
		System.out.println("What type of item do you want to delete (Main Dish 1)/(Beverage 2)/(Dessert 3)?");
		int choice = input.nextInt(); input.nextLine();
		System.out.println("What is the ID of the item to be deleted?");
		id = input.nextInt(); input.nextLine();

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

	/**
	 * Allows user to add a Promotional Item onto the menu.
	 */
	public static void addPromoItem()
	{
		String Mname, Mdescription;
		Mname = "";
		Mdescription = "";
		double Mprice;

		System.out.println("What is the name of the new Promotional Item?");
		Mname += input.nextLine();
		System.out.println("What is the price of this item?");
		Mprice = input.nextDouble(); input.nextLine();
		System.out.println("What is the description of the item?");
		Mdescription += input.nextLine();
		Promotional newitem = new Promotional((promotionals.size() + 1), Mname, Mprice, Mdescription);
		promotionals.add(newitem);
		System.out.println("Promotional item added successfully!");
	}

	/**
	 * Allows user to make changes to details of a Promotional Item from the menu.
	 */
	public static void updatePromoItem()
	{
		System.out.println("Here is the current menu:\n---");
		displayMenu();
		System.out.println("What is the ID of the Promotional Item to be updated?");
		int id = input.nextInt(); input.nextLine();
		System.out.println("What detail would you like to update (Name 1)/(Description 2)/(Price 3)?");
		int choice = input.nextInt(); input.nextLine();
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
						double newprice = input.nextDouble(); input.nextLine();
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

	/**
	 * Allows user to remove a Promotional Item from the menu.
	 */
	public static void deletePromoItem()
	{
		System.out.println("Here is the current menu:\n---");
		displayMenu();
		System.out.println("What is the ID of the Promotional Item to be deleted?");
		int id = input.nextInt(); input.nextLine();
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

	/**
	 * Gets a menu item from the menu.
	 * @return a menu item or null if selected menu item is not found on the menu
	 */
	public static AMenuItem getMenuItem() {
		displayMenu();
		System.out.println("What is the type of the item (Main Dish 1)/(Beverage 2)/(Dessert 3)/(Promotional 4)?");
		int choice = input.nextInt(); input.nextLine();
		System.out.println("What is the ID of the item?");
		int id = input.nextInt(); input.nextLine();

		switch (choice)
		{
			case 1:
				return maindishes.get(id-1);
			case 2:
				return beverages.get(id-1);
			case 3:
				return desserts.get(id-1);
			case 4:
				return promotionals.get(id-1);
		}
		return null;
	}
}
	

