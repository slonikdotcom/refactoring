package Main;

public class GildedRose {
    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        if (isLegendaryItem(item)) {
            return;
        }

        updateQualityForItem(item);
        updateSellInForItem(item);

        if (item.sellIn < 0) {
            handleExpiredItem(item);
        }
    }

    private boolean isLegendaryItem(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private void updateQualityForItem(Item item) {
        if (item.name.equals("Aged Brie")) {
            increaseQuality(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            updateBackstagePassQuality(item);
        } else {
            decreaseQuality(item);
        }
    }

    private void updateBackstagePassQuality(Item item) {
        increaseQuality(item);

        if (item.sellIn < 11) {
            increaseQuality(item);
        }

        if (item.sellIn < 6) {
            increaseQuality(item);
        }
    }

    private void handleExpiredItem(Item item) {
        if (item.name.equals("Aged Brie")) {
            increaseQuality(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
        } else {
            decreaseQuality(item);
        }
    }

    private void updateSellInForItem(Item item) {
        item.sellIn--;
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}
