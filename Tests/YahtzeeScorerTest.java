import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by okellyj on 9/21/17.
 */
public class YahtzeeScorerTest {
    protected YahtzeeScorer yah;

    @Before
    public void setUp(){
        yah = new YahtzeeScorer();
    }

    @After
    public void tearDown(){
        yah = null;
    }

    /*
    Test to see if you can only play a Yahtzee when it is free
     */
    @Test
    public void playYahtzeeTest(){
        assertTrue(yah.checkPlayYahtzee(1,1,1,1,1));
        assertTrue(!yah.checkPlayYahtzee(1,1,1,1,1));
    }

    @Test
    public void playLargeStraightTest(){
        assertTrue(yah.checkPlayLargeStraight(1,2,3,4,5));
        assertTrue(!yah.checkPlayLargeStraight(1,2,3,4,5));
    }

    @Test
    public void playFullHouseTest(){
        assertTrue(yah.checkPlayFullHouse(1, 1, 1, 2, 2));
        assertTrue(!yah.checkPlayFullHouse(1, 1, 1, 2, 2));
    }

    @Test
    public void playThreeOfAKindTest(){
        assertTrue(yah.checkPlayThreeOfAKind(1, 1, 1, 2, 3));
        assertTrue(!yah.checkPlayThreeOfAKind(1, 1, 1, 2, 3));
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
        assertTrue(yah.checkFullHouse(5, 5,5,2,2));
        assertTrue(!yah.checkFullHouse(1,1,1,2,3));
    }

    @Test
    public void checkThreeOfAKindTest(){
        assertTrue(yah.checkThreeOfAKind(1,1,1,2,2));
        assertTrue(!yah.checkThreeOfAKind(1,2,1,3, 2));
    }

    @Test
    public void goodHandYahtzeeTest() throws Exception {
        yah.scoreYahtzee(1,1,1,1,1);
        assertEquals(50, yah.getScore());
    }

    @Test(expected = YahtzeeScorer.InvalidScoringCategoryException.class)
    public void badHandYahtzeeTest() throws Exception {
        yah.scoreYahtzee(1,1,1,2,1);
    }

    @Test(expected = YahtzeeScorer.AlreadyScoredException.class)
    public void alreadyScoredYahtzeeTest() throws Exception {
        yah.scoreYahtzee(1,1,1,1,1);
        yah.scoreYahtzee(1,1,1,1,1);
    }

    @Test
    public void goodHandLargeStraightTest() throws Exception {
        yah.scoreLargeStraight(1,2,3,4,5);
        assertEquals(40, yah.getScore());
    }

    @Test(expected = YahtzeeScorer.InvalidScoringCategoryException.class)
    public void badHandLargeStraightTest() throws Exception {
        yah.scoreLargeStraight(1,1,1,2,1);
    }

    @Test(expected = YahtzeeScorer.AlreadyScoredException.class)
    public void alreadyScoredLargeStraightTest() throws Exception {
        yah.scoreLargeStraight(1,2,3,4,5);
        yah.scoreLargeStraight(1,2,3,4,5);
    }

    @Test
    public void goodHandFullHouse() throws Exception {
        yah.scoreFullHouse(1,1,1,5,5);
        assertEquals(25, yah.getScore());
    }

    @Test(expected = YahtzeeScorer.InvalidScoringCategoryException.class)
    public void badHandFullHouse() throws Exception {
        yah.scoreLargeStraight(1,1,1,2,1);
    }

    @Test(expected = YahtzeeScorer.AlreadyScoredException.class)
    public void alreadyScoredFullHouse() throws Exception {
        yah.scoreFullHouse(1,1,1,5,5);
        yah.scoreFullHouse(1,1,1,5,5);
    }

    @Test
    public void goodHandThreeOfAKind() throws Exception {
        yah.scoreThreeOfAKind(1,1,1,5,5);
        assertEquals(13, yah.getScore());
    }

    @Test(expected = YahtzeeScorer.InvalidScoringCategoryException.class)
    public void badHandThreeOfAKind() throws Exception {
        yah.scoreThreeOfAKind(1,5,5,2,1);
    }

    @Test(expected = YahtzeeScorer.AlreadyScoredException.class)
    public void alreadyScoredThreeOfAKind() throws Exception {
        yah.scoreThreeOfAKind(1,1,1,5,5);
        yah.scoreThreeOfAKind(1,1,1,5,5);
    }
}



