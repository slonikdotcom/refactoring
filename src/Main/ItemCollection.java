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
        ItemAttributes attributes = item.getAttributes();
        if (isLegendaryItem(attributes)) {
            return;
        }

        updateQualityForItem(attributes);
        attributes.getSellIn().decrease();

        if (attributes.getSellIn().isExpired()) {
            handleExpiredItem(attributes);
        }
    }

    private boolean isLegendaryItem(ItemAttributes attributes) {
        return attributes.getName().equals("Sulfuras, Hand of Ragnaros");
    }

    private void updateQualityForItem(ItemAttributes attributes) {
        if (attributes.getName().equals("Aged Brie")) {
            attributes.getQuality().increase();
            return;
        }

        if (attributes.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            updateBackstagePassQuality(attributes);
            return;
        }

        attributes.getQuality().decrease();
    }

    private void updateBackstagePassQuality(ItemAttributes attributes) {
        attributes.getQuality().increase();

        if (attributes.getSellIn().getValue() < 11) {
            attributes.getQuality().increase();
        }

        if (attributes.getSellIn().getValue() < 6) {
            attributes.getQuality().increase();
        }
    }

    private void handleExpiredItem(ItemAttributes attributes) {
        if (attributes.getName().equals("Aged Brie")) {
            attributes.getQuality().increase();
            return;
        }

        if (attributes.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            attributes.getQuality().reset();
            return;
        }

        attributes.getQuality().decrease();
    }
}
