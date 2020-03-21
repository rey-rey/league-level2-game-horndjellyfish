package src;

import java.util.ArrayList;
import java.util.Random;

public class SimonPatternManager {
    // List of Colors to use
    public static final int GREEN = 0;
    public static final int BLUE = 1;
    public static final int RED = 2;
    public static final int YELLOW = 3;

    // List of Pattern matching values
    public static final int PATTERN_SAME = 0;
    public static final int PATTERN_SAME_AND_DONE = 1;
    public static final int PATTERN_DIFFERENT = 2;

    private ArrayList<Integer> compPattern;
    private ArrayList<Integer> userPattern = new ArrayList<Integer>();
    private Random rand = new Random();

    SimonPatternManager() {
    }

    // Create new Pattern.
    // IE Start of New Game
    public void startNewPattern() {
        compPattern = new ArrayList<Integer>();
        addToPattern();
    }

    // Add a color to our Pattern
    public void addToPattern() {
        int nextColor = getRandomColor();
        compPattern.add(nextColor);
//System.out.println( "SimonPatterManager-AddColor: " + nextColor + "  Size: " + compPattern.size() ) ;
    }

    //  Generate Random Color
    private int getRandomColor() {
        int lastColor =  -1;

        // get the last color add to the pattern
        if ( compPattern.size() > 0 ) {
            lastColor = compPattern.get( compPattern.size()-1 );
        }

        // get random color
        int nextColor = rand.nextInt(YELLOW);

        // now check if random is same as last color
        // KLDUDGE. For now, I do not want 2 colors in a row
//        if (nextColor == lastColor) {
//            nextColor = getRandomColor();
//        }

        return  nextColor;
    }

    public int getPatternSize( ) {
       return compPattern.size();
    }

    public int checkPattern( ArrayList<Integer> pattern ) {
        int status = PATTERN_DIFFERENT;

        boolean equals = false;
        if (pattern == null ) {
            System.out.println( "PatterManager: user selection null");
        } else if (compPattern == null ) {
            System.out.println( "PatterManager: comp pattern null");
        } else if (pattern.size() > compPattern.size() ) {
            System.out.println( "PatterManager: user selection bigger than comp pattern");
        } else {
            for (int ii = 0; ii < pattern.size(); ii++){
                //check each item against the compPattern
                equals = pattern.get(ii) == compPattern.get(ii) ;

                // if not equal, then we can stop check, and just exit
                if (!equals) {
                    break;  // exit the for loop
                }
            }

            //  now figure out if we completed the entire pattern
            if (equals && ( pattern.size() == compPattern.size()))  {
                status = PATTERN_SAME_AND_DONE;
            } else if ( equals ) {
                status = PATTERN_SAME;
            } else {
                status = PATTERN_DIFFERENT;
            }
        }
        return status;
    }

    //  DO NOT want anyone updating pattern
    //  SO, Never return the actual pattern.
    public ArrayList<Integer> getClonePattern()  {
       return (ArrayList<Integer>)compPattern.clone();
    }
}
