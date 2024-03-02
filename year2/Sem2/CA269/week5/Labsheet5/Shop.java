// everything in shop is an item - specific type
// different items have different storage conditions - e.g freezer, refridgeration
// shop uses securityTags on some items, procedure to attach and remove tags,
// tags must be removed when leaving the shop
// priceReductions on certain items - such as near expiry, or sales

// first object to consider is ITEM - everything is an item
// we make it an abstract class because the shops wants to use explicit types of items - subclasses

abstract class Item{
    final String name;
    double price;
    int expiryInDays;
}

// todo: create subclasses for specific items

// StorageCondition
// we use interface and not a class so that Item class does not need a variable for storagecondition
interface StorageCondition{ }

interface LockedShelves{ }
interface SecurityTag{ }
interface Refrigerated{
    void setOptimumTemp(int temp);
}
interface Cooled{
    void setOptimumTemp(int temp);
}
interface Frozen{
    void setOptimumTemp(int temp);
}
// we do this to allow multiple inhertiance, in case an item needs 2 conditions - refridgerator and locktags etc

// classes
// when an interface forces a setter to be implemeneted then it tells the class values can be changed
// if they were final values we would initialise them in the constructor
class Milk extends Item implements Refrigerated{
    int minTemp;
    int maxTemp;
    int optimumTemp;

    void setMinTemp(int minTemp){
        this.minTemp = minTemp;
    }
    void setMaxTemp(int maxTemp){
        this.maxTemp = maxTemp;
    }
    void setOptimumTemp(int optimumTemp){
        this.optimumTemp = optimumTemp;
    }
}

