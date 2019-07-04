package entity;

import org.junit.Before;
import org.junit.Test;

import static config.BoxType.*;
import static org.junit.Assert.*;

public class AccumulatorTest {

    private Accumulator hundertAcc;
    private Accumulator twentyAcc;
    private Accumulator fiveAcc;
    private Accumulator extraAcc;
    private Accumulator goAcc;


    @Before
    public void setUp() {
        hundertAcc = new AccumulatorImpl(HUNDERT);
        twentyAcc = new AccumulatorImpl(TWENTY);
        fiveAcc = new AccumulatorImpl(FIVE);
        extraAcc = new AccumulatorImpl(EXTRA);
        goAcc = new AccumulatorImpl(GAME_OVER);
    }

    @Test
    public void testAccumulatorInitialCreation(){
        assertEquals(HUNDERT, hundertAcc.getBoxType());
        assertEquals(TWENTY, twentyAcc.getBoxType());
        assertEquals(FIVE, fiveAcc.getBoxType());
        assertEquals(EXTRA, extraAcc.getBoxType());
        assertEquals(GAME_OVER, goAcc.getBoxType());
    }

    @Test
    public void testOpenPrizeBox(){
        Accumulator testPrizeBox = hundertAcc.openBox(twentyAcc);

        assertEquals(120D, testPrizeBox.getPrizeAmount(), 0.001);
        assertEquals(0, testPrizeBox.getLifes());
    }

    @Test
    public void testOpenExtraBox(){
        Accumulator testExtraBox = hundertAcc.openBox(extraAcc);

        assertEquals(100D, testExtraBox.getPrizeAmount(), 0.001);
        assertEquals(1, testExtraBox.getLifes());
    }

    @Test
    public void testOpenGameOverBox(){
        Accumulator testGoBox = hundertAcc.openBox(goAcc);

        assertEquals(100D, testGoBox.getPrizeAmount(), 0.001);
        assertEquals(-1, testGoBox.getLifes());
    }

}
