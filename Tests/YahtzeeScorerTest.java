import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by okellyj on 9/21/17.
 */
public class YahtzeeScorerTest {
    protected YahtzeeScorer yah;

    @Before
    public void setup(){
        yah = new YahtzeeScorer();
    }

    /*
    Test to see if you can only play a Yahtzee when it is free
     */
    @Test
    public void playYahtzeeTest(){
        assertTrue(yah.playYahtzee(1,1,1,1,1));
        assertTrue(!yah.playYahtzee(1,1,1,1,1));
    }

    @Test
    public void playLargeStraightTest(){
        assertTrue(yah.playLargeStraight(1,2,3,4,5));
        assertTrue(!yah.playLargeStraight(1,2,3,4,5));
    }

    @Test
    public void playFullHouseTest(){
        assertTrue(yah.playFullHouse(1, 1, 1, 2, 2));
        assertTrue(!yah.playFullHouse(1, 1, 1, 2, 2));
    }

    @Test
    public void playThreeOfAKindTest(){
        assertTrue(yah.playThreeOfAKind(1, 1, 1, 2, 3));
        assertTrue(!yah.playThreeOfAKind(1, 1, 1, 2, 3));
    }

    @Test
    public void checkYahtzeeTest(){
        assertTrue(yah.checkYahtzee(1,1,1,1,1));
        assertTrue(!yah.checkYahtzee(1,1,1,1,2));
    }

    @Test
    public void checkLargeStraightTest(){
        assertTrue(yah.checkLargeStraight(1, 2, 3, 4, 5));
        assertTrue(!yah.checkLargeStraight(1, 2, 3, 4, 6));
    }

    @Test
    public void checkFullHouseTest(){
        assertTrue(yah.checkFullHouse(1,1,1,2,2));
        assertTrue(!yah.checkFullHouse(1,1,1,2,3));
    }
}



