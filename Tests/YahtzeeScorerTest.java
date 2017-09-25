import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for part of the scoring of Yahtzee
 * Created by Jordon O'Kelly and Quinn Schiller on 9/21/17.
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
    Already scored: the user selects a category that has already been scored
     */

    //Test to see if a yahtzee has already been scored
    @Test
    public void playYahtzeeTest(){
        assertTrue(yah.checkPlayYahtzee(1,1,1,1,1));
        assertTrue(!yah.checkPlayYahtzee(1,1,1,1,1));
    }

    //Test to see if a large straight has already been scored
    @Test
    public void playLargeStraightTest(){
        assertTrue(yah.checkPlayLargeStraight(1,2,3,4,5));
        assertTrue(!yah.checkPlayLargeStraight(1,2,3,4,5));
    }

    //Test to see if a full house has already been scored
    @Test
    public void playFullHouseTest(){
        assertTrue(yah.checkPlayFullHouse(1, 1, 1, 2, 2));
        assertTrue(!yah.checkPlayFullHouse(1, 1, 1, 2, 2));
    }

    //Test to see if a three of a kind has already been scored
    @Test
    public void playThreeOfAKindTest(){
        assertTrue(yah.checkPlayThreeOfAKind(1, 1, 1, 2, 3));
        assertTrue(!yah.checkPlayThreeOfAKind(1, 1, 1, 2, 3));
    }


    /*
    Insufficient dice: The user selects a category that has not yet been scored, but does not have the appropriate dice values
     */


    //Test to see if the values are valid for a yahtzee
    @Test
    public void checkYahtzeeTest(){
        assertTrue(yah.checkYahtzee(1,1,1,1,1));
        assertTrue(!yah.checkYahtzee(1,1,1,1,2));
    }

    //Test to see if the values are valid for a large straight
    @Test
    public void checkLargeStraightTest(){
        assertTrue(yah.checkLargeStraight(1, 2, 3, 4, 5));
        assertTrue(!yah.checkLargeStraight(1, 2, 3, 4, 6));
    }

    //Test to see if the values are valid for a full house
    @Test
    public void checkFullHouseTest(){
        assertTrue(yah.checkFullHouse(5, 5,5,2,2));
        assertTrue(!yah.checkFullHouse(1,1,1,2,3));
    }

    //Test to see if the values are valid for a three of a kind
    @Test
    public void checkThreeOfAKindTest(){
        assertTrue(yah.checkThreeOfAKind(1,1,1,2,2));
        assertTrue(!yah.checkThreeOfAKind(1,2,1,3, 2));
    }

    /*
    Normal Play: The user selects a category that has not been scored and has the approptiate dice values for that category
     */

    //Invalid yahtzee values raises the right error
    @Test(expected = YahtzeeScorer.InvalidScoringCategoryException.class)
    public void badHandYahtzeeTest() throws Exception {
        yah.scoreYahtzee(1,1,1,2,1);
    }

    //a person trying to play a yahtzee twice gets an exception
    @Test(expected = YahtzeeScorer.AlreadyScoredException.class)
    public void alreadyScoredYahtzeeTest() throws Exception {
        yah.scoreYahtzee(1,1,1,1,1);
        yah.scoreYahtzee(1,1,1,1,1);
    }

    //Invalid large straight values raises the right error
    @Test(expected = YahtzeeScorer.InvalidScoringCategoryException.class)
    public void badHandLargeStraightTest() throws Exception {
        yah.scoreLargeStraight(1,1,1,2,1);
    }

    //a person trying to play a large straight twice gets an exception
    @Test(expected = YahtzeeScorer.AlreadyScoredException.class)
    public void alreadyScoredLargeStraightTest() throws Exception {
        yah.scoreLargeStraight(1,2,3,4,5);
        yah.scoreLargeStraight(1,2,3,4,5);
    }

    //Invalid full house values raises the right error
    @Test(expected = YahtzeeScorer.InvalidScoringCategoryException.class)
    public void badHandFullHouse() throws Exception {
        yah.scoreLargeStraight(1,1,1,2,1);
    }

    //a person trying to play a full house twice gets an exception
    @Test(expected = YahtzeeScorer.AlreadyScoredException.class)
    public void alreadyScoredFullHouse() throws Exception {
        yah.scoreFullHouse(1,1,1,5,5);
        yah.scoreFullHouse(1,1,1,5,5);
    }

    //Invalid three of a kind values raises the right error
    @Test(expected = YahtzeeScorer.InvalidScoringCategoryException.class)
    public void badHandThreeOfAKind() throws Exception {
        yah.scoreThreeOfAKind(1,5,5,2,1);
    }

    //a person trying to play a three of a kind twice gets an exception
    @Test(expected = YahtzeeScorer.AlreadyScoredException.class)
    public void alreadyScoredThreeOfAKind() throws Exception {
        yah.scoreThreeOfAKind(1,1,1,5,5);
        yah.scoreThreeOfAKind(1,1,1,5,5);
    }

    /*
    Current Score: When prompted, the correct current score fo the game is returned
    */


    //Test to see that a valid yahtzee is scored correctly
    @Test
    public void goodHandYahtzeeTest() throws Exception {
        yah.scoreYahtzee(1,1,1,1,1);
        assertEquals(50, yah.getScore());
    }

    //Test to see that a valid large straight is scored correctly
    @Test
    public void goodHandLargeStraightTest() throws Exception {
        yah.scoreLargeStraight(1,2,3,4,5);
        assertEquals(40, yah.getScore());
    }

    //Test to see that a valid full house is scored correctly
    @Test
    public void goodHandFullHouseTest() throws Exception {
        yah.scoreFullHouse(1,1,1,5,5);
        assertEquals(25, yah.getScore());
    }

    //Test to see that a valid three of a time is scored correctly
    @Test
    public void goodHandThreeOfAKindTest() throws Exception {
        yah.scoreThreeOfAKind(1, 1, 1, 5, 5);
        assertEquals(13, yah.getScore());
    }

    //test to see that multiple scores are scored correctly
    @Test
    public void multipleScoreTest() throws Exception {
        yah.scoreThreeOfAKind(1,1,1,5,5);
        assertEquals(13, yah.getScore());
        yah.scoreFullHouse(1,1,1,5,5);
        assertEquals(13+25, yah.getScore());
        yah.scoreLargeStraight(1,2,3,4,5);
        assertEquals(13+25+40, yah.getScore());
        yah.scoreYahtzee(1,1,1,1,1);
        assertEquals(13+25+40+50, yah.getScore());
    }
}



