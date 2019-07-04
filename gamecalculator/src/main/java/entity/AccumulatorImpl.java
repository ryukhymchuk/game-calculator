package entity;

import config.BoxType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AccumulatorImpl implements Accumulator {
    protected Double prizeAmount;
    protected int lifes;
    protected BoxType boxType;

    public AccumulatorImpl(BoxType boxType) {
        this.boxType = boxType;
        this.prizeAmount = boxType.getAmount();
        this.lifes = boxType.getLifes();
    }

    public AccumulatorImpl(Double prizeAmount, int lifes, BoxType boxType) {
        this.prizeAmount = prizeAmount;
        this.lifes = lifes;
        this.boxType = boxType;
    }

    public Accumulator openBox(Accumulator box) {
        return new AccumulatorImpl(this.prizeAmount + box.getPrizeAmount(),
                this.lifes + box.getLifes(),
                box.getBoxType());
    }

}
