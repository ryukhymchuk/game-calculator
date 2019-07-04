package processor;

import config.BoxType;
import entity.Accumulator;
import entity.AccumulatorImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractGameProcessor implements GameProcessor {


    public Accumulator runRound(List<Accumulator> acc){
        return acc.stream().reduce((curr, next) -> curr.getLifes() < 0 ? curr : curr.openBox(next)).get();
    }

    public List<Accumulator> createBoxes(BoxType[] boxes){
        return Arrays.asList(boxes).stream().map(AccumulatorImpl::new).collect(Collectors.toList());
    }

}
