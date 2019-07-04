package config;


public enum BoxType {

    HUNDERT(100D, 0),
    TWENTY(20D, 0),
    TEN(10D, 0),
    FIVE(5D, 0),
    EXTRA(0D, 1),
    GAME_OVER(0D, -1),
    EXTRA_ROUND(0D, 0);

    BoxType(Double amount, int life) {
        this.amount = amount;
        this.lifes = life;
    }

    private Double amount;
    private int lifes;

    public Double getAmount() {
        return amount;
    }

    public int getLifes() {
        return lifes;
    }
}
