/**
 * Created by okellyj on 9/21/17.
 */

import java.util.Arrays;

public class YahtzeeScorer {

    private boolean openYahtzee;
    private boolean openLargeStraight;
    private boolean openFullHouse;
    private boolean openThreeOfAKind;

    public YahtzeeScorer(){
        openYahtzee = true;
        openLargeStraight = true;
        openFullHouse = true;
        openThreeOfAKind = true;
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

    public int scoreYahtzee(int d1, int d2, int d3, int d4, int d5) {
        if (checkPlayYahtzee(d1,d2,d3,d4,d5) && checkYahtzee(d1,d2,d3,d4,d5)){
            return 50;
        }

    }
}
