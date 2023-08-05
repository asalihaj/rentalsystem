package net.ubt.rentalsystem.entity.car;

public enum Category {
    SUV("SUV"),
    COUPE("Coupe"),
    HATCHBACK("Hatchback"),
    MINIVAN("Minivan"),
    SEDAN("Sedan"),
    SPORT("Sport"),
    VAN("Van"),
    EV("Electric vehicle"),
    LIMOUSINE("Limousine");

    private String category;

    Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

}
