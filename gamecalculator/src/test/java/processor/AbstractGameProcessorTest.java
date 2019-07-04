package processor;

import config.BoxType;
import org.junit.Test;

import static config.BoxType.*;
import static org.junit.Assert.assertEquals;


public class AbstractGameProcessorTest {

    private static BoxType[] BOXES120 = {HUNDERT, TWENTY, EXTRA, GAME_OVER};
    private static BoxType[] BOXES100 = {HUNDERT, GAME_OVER, EXTRA, GAME_OVER, GAME_OVER};
    private static BoxType[] BOXES_EXTRA = {HUNDERT, EXTRA, GAME_OVER, TWENTY, GAME_OVER};
    private GameSimulator gameSimulator = new GameSimulator();

    @Test
    public void testCreateBoxes(){
        assertEquals(4, this.gameSimulator.createBoxes(BOXES120).size());
    }

    @Test
    public void testRunRound(){
        assertEquals(120D,this.gameSimulator.runRound(this.gameSimulator.createBoxes(BOXES120)).getPrizeAmount(), 0.0001);
        assertEquals(100D,this.gameSimulator.runRound(this.gameSimulator.createBoxes(BOXES100)).getPrizeAmount(), 0.0001);
        assertEquals(120D,this.gameSimulator.runRound(this.gameSimulator.createBoxes(BOXES_EXTRA)).getPrizeAmount(), 0.0001);
    };

}
