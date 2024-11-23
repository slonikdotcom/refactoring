package Main;

public class Item {
    public final ItemName name;
    private final SellIn sellIn;
    private final Quality quality;

    public Item(String name, int sellIn, int quality) {
        this.name = new ItemName(name);
        this.sellIn = new SellIn(sellIn);
        this.quality = new Quality(quality);
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

    @Override
    public String toString() {
        return name.getValue() + ", " + sellIn.getValue() + ", " + quality.getValue();
    }
}