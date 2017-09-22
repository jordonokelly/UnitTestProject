/**
 * Created by okellyj on 9/21/17.
 */
public class YahtzeeScorer {

    private boolean openYahtzee = true;


    public boolean playYahtzee(int d1, int d2, int d3, int d4, int d5) {
        if (openYahtzee){
            openYahtzee = false;
            return true;
        }
        else{
            return false;
        }
    }
}
