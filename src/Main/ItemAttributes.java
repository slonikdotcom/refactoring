package Main;

public class ItemAttributes {
    private final ItemName name;
    private final SellIn sellIn;
    private final Quality quality;

    public ItemAttributes(ItemName name, SellIn sellIn, Quality quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public ItemName getName() {
        return name;
    }

    public SellIn getSellIn() {
        return sellIn;
    }

    public Quality getQuality() {
        return quality;
    }
}
