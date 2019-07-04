package processor;

import com.sun.org.apache.xpath.internal.SourceTree;
import entity.Accumulator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static config.GameConfig.BOXES;
import static config.GameConfig.PROMISED_BOXES;


public class GameCalculator extends AbstractGameProcessor{

    public static long countGameFlows(int n) {
        return LongStream.rangeClosed(2, n).reduce(1, (a, b) -> a * b);
    }

    public  List<Accumulator> getGameFlows(long no, List<Accumulator> items) {
        return permutation(no,
                new LinkedList<>(Objects.requireNonNull(items)),
                new ArrayList<>());
    }
    private  List<Accumulator> permutation(long no, LinkedList<Accumulator> in, List<Accumulator> out) {
        if (in.isEmpty()) return out;
        long subFactorial = countGameFlows(in.size() - 1);
        out.add(in.remove((int) (no / subFactorial)));
        return permutation((int) (no % subFactorial), in, out);
    }

    public Stream<List<Accumulator>> of(List<Accumulator> accumulators) {
        return LongStream.range(0, countGameFlows(accumulators.size()))
                .mapToObj(no -> getGameFlows(no, accumulators));
    }

    private Double getAvarage(List<Accumulator> boxes){
        return of(boxes)
                .map(this::runRound)
                .mapToDouble(Accumulator::getPrizeAmount)
                .sum() / countGameFlows(boxes.size());
    }

    public Double process() {
       System.out.println("Starting GameCalculator (estimated calculation time - 15 mins) ...");
       Double firstRoundResult = getAvarage(createBoxes(BOXES));
       return firstRoundResult +
               (createBoxes(PROMISED_BOXES).stream().mapToDouble(s -> s.getPrizeAmount()).sum() + firstRoundResult) / PROMISED_BOXES.length;
    }

}
