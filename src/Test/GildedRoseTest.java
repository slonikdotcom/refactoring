package Test;

import Main.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void testFooItem() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item item = app.getItemCollection().getItems().get(0);
        ItemAttributes attributes = item.getAttributes();

        assertEquals("foo", attributes.getName().getValue());
        assertEquals(-1, attributes.getSellIn().getValue());
        assertEquals(0, attributes.getQuality().getValue());
    }
}
