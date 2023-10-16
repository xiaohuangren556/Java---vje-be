package hr.java.production.main;

import hr.java.production.model.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Category[] categories = new Category[3];
            Boolean checker = false;
            Category categoryToCompare = null;
            for(int i = 0; i < 3; i++){
                do{
                    categoryToCompare = getCategory(scanner);
                    if(i >= 1){
                        checker = checkIdenticalCategories(categoryToCompare, categories);
                    }
                    if(checker){
                        System.out.println("You've entered identical categories. Please, repeat input.");
                    }
                }while(checker);
                categories[i] = categoryToCompare;
            }

            checker = false;
            Item[] items= new Item[3];
            Item itemToCompare = null;
            for(int i = 0; i < 3; i++){
                do{
                    itemToCompare = getItem(scanner);
                    if(i >= 1){
                        checker = checkIdenticalItems(itemToCompare, items);
                    }
                    if(checker){
                        System.out.println("You've entered identical items. Please, repeat input.");
                    }
                }while(checker);
                items[i] = itemToCompare;
            }

            checker = false;
            Factory[] factories = new Factory[2];
            Factory factoryToCompare = null;
            for(int i = 0; i < 2; i++){
                do{
                    factoryToCompare = getFactory(scanner);
                    if(i >= 1){
                        checker = checkIdenticalFactories(factoryToCompare, factories);
                    }
                    if(checker){
                        System.out.println("You've entered identical factories. Please, repeat input.");
                    }
                }while(checker);
                factories[i] = getFactory(scanner);
            }

            Factory withBiggestVolume = getBiggestVolume(factories);

            checker = false;
            Store[] stores = new Store[2];
            Store storeToCompare = null;
            for(int i = 0; i < 2; i++){
                do{
                    storeToCompare = getStore(scanner);
                    if(i >= 1){
                        checker = checkIdenticalStores(storeToCompare, stores);
                    }
                    if(checker){
                        System.out.println("You've entered identical stores. Please, repeat input.");
                    }
                }while(checker);
                stores[i] = storeToCompare;
            }

            Store withCheapestItem = getStoreWithCheapestItem(stores);
        }

        private static Category getCategory(Scanner iscanner){
               System.out.println("Enter the name of the category");
               String name = iscanner.nextLine();
               System.out.println("Enter the description of the category");
               String description = iscanner.nextLine();
               Category novaKat = new Category(name, description);
               return novaKat;
        }

        private static Item getItem(Scanner iScanner){
            System.out.println("Enter the name of the item");
            String name = iScanner.nextLine();
            System.out.println("Enter the category of the item");
            Category category = getCategory(iScanner);
            System.out.println("Enter the width of the item");
            BigDecimal width = iScanner.nextBigDecimal();
            iScanner.nextLine();
            System.out.println("Enter the height of the item");
            BigDecimal height = iScanner.nextBigDecimal();
            iScanner.nextLine();
            System.out.println("Enter the length of the item");
            BigDecimal length = iScanner.nextBigDecimal();
            iScanner.nextLine();
            System.out.println("Enter the production cost of the item");
            BigDecimal productionCost = iScanner.nextBigDecimal();
            iScanner.nextLine();
            System.out.println("Enter the selling price of the item");
            BigDecimal sellingPrice = iScanner.nextBigDecimal();
            iScanner.nextLine();
            Item noviArt = new Item(name, category, width, height, length, productionCost, sellingPrice);
            return noviArt;
        }

        private static Address getAddress(Scanner iScanner){
            System.out.println("Enter the name of the name of the street");
            String street = iScanner.nextLine();
            System.out.println("Enter the house number");
            String houseNumber = iScanner.nextLine();
            System.out.println("Enter the name of the city");
            String city = iScanner.nextLine();
            System.out.println("Enter the postal code of the city");
            String postalCode = iScanner.nextLine();
            Address tempAddress = new Address(street, houseNumber, city, postalCode);
            return tempAddress;
        }
        private static Factory getFactory(Scanner iScanner){
            System.out.println("Enter the name of the factory");
            String name = iScanner.nextLine();
            System.out.println("Enter the address of the factory");
            Address address = getAddress(iScanner);
            System.out.println("Enter the number of items:");
            int numberOfItems = iScanner.nextInt();
            iScanner.nextLine();
            Item[] items = new Item[numberOfItems];
            Item itemToCheck = null;
            Boolean checker = false;
            for(int i = 0; i < numberOfItems; i++){
                do{
                    itemToCheck = getItem(iScanner);
                    if(i >= 1){
                        checker = checkIdenticalItems(itemToCheck, items);
                    }
                    if(checker){
                        System.out.println("Youve entered identical items, please repeat input");
                    }
                }while(checker);
                items[i] = itemToCheck;
            }

            Factory tempFact = new Factory(name, address, items);
            return tempFact;
        }
        
        private static Store getStore(Scanner iScanner){
            System.out.println("Enter the name of the store");
            String name = iScanner.nextLine();
            System.out.println("Enter the address of the store");
            String address = iScanner.nextLine();
            System.out.println("Enter the number of items:");
            int numberOfItems = iScanner.nextInt();
            iScanner.nextLine();
            Item[] items = new Item[numberOfItems];
            Item itemToCheck = null;
            Boolean checker = false;
            for(int i = 0; i < numberOfItems; i++){
                do{
                    itemToCheck = getItem(iScanner);
                    if(i >= 1){
                        checker = checkIdenticalItems(itemToCheck, items);
                    }
                    if(checker){
                        System.out.println("You've entered identical items, please repeat input.");
                    }
                }while(checker);
                items[i] = itemToCheck;
            }

            Store tempStore = new Store(name, address, items);
            return tempStore;
        }

        private static BigDecimal calculateVolume(Item item) {
            BigDecimal volume = item.getHeight().multiply(item.getLength().multiply(item.getWidth()));
            return volume;
        }
        private static Factory getBiggestVolume(Factory[] factories){
            BigDecimal biggestVolume = calculateVolume(factories[0].getItems()[0]);
            Factory withBiggestVolume = factories[0];
            for(int i = 0; i < factories.length; i++){
                for(int j = 0; j < factories[i].getItems().length; j++){
                    BigDecimal tempVolume = calculateVolume(factories[i].getItems()[j]);
                    if(tempVolume.compareTo(biggestVolume) > 0){
                        biggestVolume = tempVolume;
                        withBiggestVolume = factories[i];
                    }
                }
            }
            return withBiggestVolume;
        }
        private static Store getStoreWithCheapestItem(Store[] stores){
            BigDecimal cheapestPrice = stores[0].getItems()[0].getSellingPrice();
            Store withCheapestPrice = stores[0];
            for(int i = 0; i < stores.length; i++) {
                for (int j = 0; j < stores[i].getItems().length; j++) {
                    BigDecimal tempPrice = stores[i].getItems()[j].getSellingPrice();
                    if (tempPrice.compareTo(cheapestPrice) < 0){
                        cheapestPrice = tempPrice;
                        withCheapestPrice = stores[i];
                    }

                }
            }
            return withCheapestPrice;
        }
    private static Boolean checkIdenticalCategories(Category categoryToCheck, Category[] categories){
        for(Category enteredCategory : categories){
            if(categoryToCheck.equals(enteredCategory))
                return true;
        }
        return false;
    }

    private static Boolean checkIdenticalItems(Item itemToCheck, Item[] items){
        for(Item enteredItem : items){
            if(itemToCheck.equals(enteredItem))
                return true;
        }
        return false;
    }
    private static Boolean checkIdenticalFactories(Factory factoryToCheck, Factory[] factories){
        for(Factory enteredFactory : factories){
            if(factoryToCheck.equals(enteredFactory))
                return true;
        }
        return false;
    }
    private static Boolean checkIdenticalStores(Store storeToCheck, Store[] stores){
        for(Store enteredStore : stores){
            if(storeToCheck.equals(enteredStore)){
                return true;
            }
        }
        return false;
    }

    }





