package Main;

import java.util.ArrayList;
import java.util.List;

public class ItemCollection {
    private final List<Item> items;

    public ItemCollection(Item[] items) {
        this.items = new ArrayList<>();
        for (Item item : items) {
            this.items.add(item);
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item != null) {
                updateItemQuality(item);
            }
        }
    }

    private void updateItemQuality(Item item) {
        if (isLegendaryItem(item)) {
            return;
        }

        updateQualityForItem(item);
        item.getSellIn().decrease();

        if (item.getSellIn().isExpired()) {
            handleExpiredItem(item);
        }
    }

    private boolean isLegendaryItem(Item item) {
        return item.getName().equals("Sulfuras, Hand of Ragnaros");
    }

    private void updateQualityForItem(Item item) {
        if (item.getName().equals("Aged Brie")) {
            item.getQuality().increase();
            return;
        }

        if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            updateBackstagePassQuality(item);
            return;
        }

        item.getQuality().decrease();
    }

    private void updateBackstagePassQuality(Item item) {
        item.getQuality().increase();

        if (item.getSellIn().getValue() < 11) {
            item.getQuality().increase();
        }

        if (item.getSellIn().getValue() < 6) {
            item.getQuality().increase();
        }
    }

    private void handleExpiredItem(Item item) {
        if (item.getName().equals("Aged Brie")) {
            item.getQuality().increase();
            return;
        }

        if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.getQuality().reset();
            return;
        }

        item.getQuality().decrease();
    }
}
