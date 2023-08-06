package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {
    private Shop shop;
    private Goods firstGood;
    private Goods secondGood;
    private Goods thirdGood;
    private Goods fourthGood;
    private Goods fifthGood;

    @Before
    public void setUp() throws OperationNotSupportedException {
        shop = new Shop();
        firstGood = new Goods("Frappe", "545");
        secondGood = new Goods("Coffee", "1003");
        thirdGood = new Goods("Beer", "777");
        fourthGood = new Goods("Whiskey", "8999");
        fifthGood = new Goods("Milk", "7777777777");

        shop.addGoods("Shelves1", firstGood);
        shop.addGoods("Shelves2", secondGood);
        shop.addGoods("Shelves3", thirdGood);

    }

    @Test(expected = IllegalArgumentException.class)
    public void addGoodsWithNonExistingShelf() throws OperationNotSupportedException {
        shop.addGoods("fakeShelf", secondGood);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addGoodsOnTakenShelf() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", thirdGood);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addGoodsWithExistingItem() throws OperationNotSupportedException {
        shop.addGoods("Shelves4", firstGood);
    }

    @Test
    public void addNonAddedItemOnEmptyShelf() throws OperationNotSupportedException {
        Assert.assertEquals("Goods: 8999 is placed successfully!", shop.addGoods("Shelves5", fourthGood));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeNonExistingShelf() {
        shop.removeGoods("Shelves123", firstGood);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeNonExistingItems() {
        shop.removeGoods("Shelves5", fifthGood);
    }

    @Test
    public void removeExistingItemOnTakenShelf() {
        Assert.assertEquals("Goods: 545 is removed successfully!", shop.removeGoods("Shelves1", firstGood));
        Assert.assertNull(shop.getShelves().get("Shelves1"));
    }
}