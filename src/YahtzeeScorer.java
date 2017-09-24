/**
 * Created by okellyj on 9/21/17.
 */

import java.util.Arrays;

public class YahtzeeScorer {

    private boolean openYahtzee;
    private boolean openLargeStraight;
    private boolean openFullHouse;
    private boolean openThreeOfAKind;
    private int score;



    public YahtzeeScorer(){
        openYahtzee = true;
        openLargeStraight = true;
        openFullHouse = true;
        openThreeOfAKind = true;
        score = 0;
    }

    public int getScore() {
        return this.score;
    }


    public class AlreadyScoredException extends Exception{
        public AlreadyScoredException(String errorText){
            super(errorText);
        }
    }

    public class InvalidScoringCategoryException extends Exception{
        public InvalidScoringCategoryException(String errorText){
            super(errorText);
        }
    }
    public boolean checkPlayYahtzee(int d1, int d2, int d3, int d4, int d5) {
        if (openYahtzee){
            openYahtzee = false;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkPlayLargeStraight(int d1, int d2, int d3, int d4, int d5) {
        if (openLargeStraight){
            openLargeStraight = false;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkPlayFullHouse(int d1, int d2, int d3, int d4, int d5) {
        if (openFullHouse){
            openFullHouse = false;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkPlayThreeOfAKind(int d1, int d2, int d3, int d4, int d5) {
        if (openThreeOfAKind){
            openThreeOfAKind = false;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkYahtzee(int d1, int d2, int d3, int d4, int d5) {
        return d1 == d2 && d2 == d3 && d3 == d4 && d4 == d5;
    }

    public boolean checkLargeStraight(int d1, int d2, int d3, int d4, int d5) {
        if (d1 != d2 && d1 != d3 && d1 != d4 && d1 != d5 && d2 != d3 && d2 != d4 && d2 != d5 && d3 != d4 && d3 != d5 && d4 != d5){
            int diceSum = d1 + d2 + d3 + d4 + d5;
            if (diceSum == 15 || diceSum == 20){
                return true;
            }

        }
        return false;
    }

    public boolean checkFullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] dice = {d1,d2,d3,d4,d5};
        Arrays.sort(dice);
        //make sure we have a three of a kind and a pair
        return ((dice[0] == dice[1] && dice[0] == dice[2] && dice[0] != dice[3] && dice[3]==dice[4]) ||
                (dice[0] == dice[1] && dice[0] != dice[2] &&  dice[2] == dice[3] && dice[2]==dice[4]));
    }

    public boolean checkThreeOfAKind(int d1, int d2, int d3, int d4, int d5) {
        int[] dice = {d1,d2,d3,d4,d5};
        Arrays.sort(dice);
        //first middle or last  set of three die are all of a kind
        return ((dice[0] == dice[1] && dice[0] == dice[2]||
                (dice[1] == dice[2] && dice[1] == dice[3])||
                (dice[2] == dice[3] && dice[2] == dice[4])));
    }

    public void scoreYahtzee(int d1, int d2, int d3, int d4, int d5) throws Exception {
        //check to see if a Yahtzee has already been scored
        if (checkPlayYahtzee(d1,d2,d3,d4,d5)){
            //check to see if the hand is a valid Yahtzee
            if (checkYahtzee(d1,d2,d3,d4,d5)) {
                //give 50 points
                this.score = this.score + 50;
            }
            else {
                throw new InvalidScoringCategoryException("You do not have the dice to use this category");
            }
        }
        else{
            throw new AlreadyScoredException("You have already played a Yahtzee"); //TODO make this not this way because the rules are different for Yahtzees
        }
    }

    public void scoreLargeStraight(int d1, int d2, int d3, int d4, int d5) throws Exception {
        //check to see if a Large Straight has already been scored
        if (checkPlayLargeStraight(d1,d2,d3,d4,d5)){
            //check to see if the hand is a valid Large Straight
            if (checkLargeStraight(d1,d2,d3,d4,d5)) {
                //give 40 points
                this.score = this.score + 40;
            }
            else {
                throw new InvalidScoringCategoryException("You do not have the dice to use this category");
            }
        }
        else{
            throw new AlreadyScoredException("You have already played a Large Straight");
        }
    }

    public void scoreFullHouse(int d1, int d2, int d3, int d4, int d5) throws Exception {
        //check to see if a Full House has already been scored
        if (checkPlayFullHouse(d1,d2,d3,d4,d5)){
            //check to see if the hand is a valid Full House
            if (checkFullHouse(d1,d2,d3,d4,d5)) {
                //give 25 points
                this.score = this.score + 25;
            }
            else {
                throw new InvalidScoringCategoryException("You do not have the dice to use this category");
            }
        }
        else{
            throw new AlreadyScoredException("You have already played a Full House");
        }
    }

    public void scoreThreeOfAKind(int d1, int d2, int d3, int d4, int d5) throws Exception {
        //check to see if a three of a kind has already been scored
        if (checkPlayThreeOfAKind(d1,d2,d3,d4,d5)){
            //check to see if the hand is a valid three of a kind
            if (checkThreeOfAKind(d1,d2,d3,d4,d5)) {
                //give points
                this.score = this.score + d1 + d2 + d3 + d4 + d5;
            }
            else {
                throw new InvalidScoringCategoryException("You do not have the dice to use this category");
            }
        }
        else{
            throw new AlreadyScoredException("You have already played a three of a kind");
        }
    }
}
