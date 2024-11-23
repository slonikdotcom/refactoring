package Main;

public class Item {
    private final ItemAttributes attributes;

    public Item(String name, int sellIn, int quality) {
        this.attributes = new ItemAttributes(
                new ItemName(name),
                new SellIn(sellIn),
                new Quality(quality)
        );
    }

    public ItemAttributes getAttributes() {
        return attributes;
    }

    @Override
    public String toString() {
        return attributes.getName().getValue() + ", " +
                attributes.getSellIn().getValue() + ", " +
                attributes.getQuality().getValue();
    }
}
