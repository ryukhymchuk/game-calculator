package processor;


import config.BoxType;
import entity.Accumulator;
import entity.AccumulatorImpl;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import static config.GameConfig.BOXES;
import static config.GameConfig.PROMISED_BOXES;

public class GameSimulator extends AbstractGameProcessor {

   public Double process(){
       System.out.println("Starting GameSimulator ...");
       return IntStream.range(1, 10_000_000).mapToObj(s -> getBoxes()).mapToDouble(this::processOneGame).average().getAsDouble();
   }

    private Double processOneGame(List<Accumulator> acc) {
        BoxType extraBox = this.runExtraRound();
        switch(extraBox) {
            case EXTRA_ROUND:
                return DoubleStream.of(runRound(acc).getPrizeAmount(), runRound(acc).getPrizeAmount()).sum();
            default: return runRound(acc).openBox(new AccumulatorImpl(extraBox)).getPrizeAmount();
        }
    }

    public BoxType runExtraRound(){
        Random random = new Random();
        return PROMISED_BOXES[random.nextInt(PROMISED_BOXES.length)];
    }

    public List<Accumulator> getBoxes(){
        List<Accumulator> boxes =  createBoxes(BOXES);
        Collections.shuffle(boxes);
        return boxes;
    }

}
