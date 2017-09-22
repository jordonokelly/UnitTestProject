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
    public void npYahtzee(){
        assertTrue(yah.playYahtzee(1,1,1,1,1));
        assertTrue(!yah.playYahtzee(1,1,1,1,1));
    }
}



