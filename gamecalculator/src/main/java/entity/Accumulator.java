package entity;

import config.BoxType;

public interface Accumulator {

    Double getPrizeAmount();

    int getLifes();

    BoxType getBoxType();

    Accumulator openBox(Accumulator accumulator);

}
