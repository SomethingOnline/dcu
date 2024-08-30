refactoring:
A simple definition of refactoring is changing the structure of existing code without changing
its intended impact or functionality
Identifying and removing duplicate code and creating a new common function that is reused
Identifying some code or method should be associated with a specific class
and moving it to be part of that class
Identifying some methods or classes are too long and breaking them into smaller
meaningful smaller pieces that can be used modularly
identifying complex code that leads to difficulties in comprehension and testing
and changing it by simplifying it or creating help functions

The overall goals are:
make code easier to understand 
making it easier to test or find bugs
improve the design of the code
increase efficiency by descreasing unwanted complexity

Factoring:
a factor is a part of parameter or constituent of a system which makes up its functionality
or determine its behahviour
for java, these would be classes as well as their fields and methods
the process of factoring refers to understanding a system as a complex system of parts:
1. understanding each part
2. what do they do
3. what their effects are
4. how they affect other parts
5. how do they work together

factoring is known as decomposition

example:
public static double billItems(Item[] items, OnSale Sale) {
    double total = 0; // store the total of items, starting from 0.00

    for (Item item : items) {
        // take out one item at a time, print it
        System.out.print(item);
        // add its price to the total, print the price
        total += item.price;
        System.out.print(" (" + item.price + ")");
        // check if item has special storage conditions and print it
        if (item instanceof StorageCondition) {
            System.out.print(" (Storage: ");
            if (item instanceof Refrigerate && ((Refrigerate) item).refrigerate(getCurrentTemperature())) {
                    System.out.print(((Refrigerate) item).storageProcedure());
            } else if (item instanceof SecureItem) {
                ((SecureItem) item).removeSecurityTag();
                System.out.print(((StorageCondition) item).storageProcedure());
            } else if (item instanceof StorageCondition) {
                System.out.print(((StorageCondition) item).storageProcedure());
            }
            System.out.print(")");
        }

        System.out.println();
    }

    if (Sale == null || Sale.saleCondition(items) == false) {
        return total;
    }

    System.out.println("Actual Total: " + total);
    System.out.println(Sale);
    total = Sale.reduction(total);

    return total;
}

here we observe the method is doing a lot of things:
calculating the total of items
printing the item details in specific format
checking for storage conditions including refrigerate and SecureItem
checking for validity of sale condition and updating the total

using refactoring we can move specific code to dedicated methods to make this easier 
public static double billItems(Item[] items){
	double total = getTotalOfItems(items);
	if (getApplicableSale(total, items)){
		total = getApplicableSale().reduction(total, items);
	}
	String billing = constructBillingMsg(items, total);
	prepareForDelivery(items, billing);
	return total;
}

The method has been made much smaller, most of the functionality moved to different functions
This makes it easier to test and that one method is not doing everything all at once

