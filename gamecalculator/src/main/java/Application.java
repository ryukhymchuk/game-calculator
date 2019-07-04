import processor.GameCalculator;
import processor.GameProcessor;
import processor.GameSimulator;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        GameProcessor[] processors = {new GameSimulator(), new GameCalculator()};
        Arrays.asList(processors).forEach(s -> System.out.println("Averaged box cost -> " + s.process()));
    }
}
