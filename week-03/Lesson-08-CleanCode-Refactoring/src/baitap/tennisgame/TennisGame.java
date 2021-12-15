package baitap.tennisgame;

public class TennisGame {
    public static final String LOVE_ALL = "Love-All";
    public static final String FIFTEEN_ALL = "Fifteen-All";
    public static final String THIRTY_ALL = "Thirty-All";
    public static final String FORTY_ALL = "Forty-All";
    public static final String DEUCE = "Deuce";
    public static final String ADVANTAGE_FOR_FIRST_PLAYER = "Advantage for first player";
    public static final String ADVANTAGE_FOR_SECOND_PLAYER = "Advantage for second player";
    public static final String WIN_FOR_FIRST_PLAYER = "Win for first player";
    public static final String WIN_FOR_SECOND_PLAYER = "Win for second player";

    public static String getScore(String firstPlayer, String secondPlayer, int firstPlayerScore, int secondPlayerScore) {
        String score = "";
        int tempScore = 0;
        boolean compareTwoScore = firstPlayerScore == secondPlayerScore;
        if (compareTwoScore) {
            score = compareTwoScore(firstPlayerScore);
        } else {
            boolean compareScoresBy4 = firstPlayerScore >= 4 || secondPlayerScore >= 4;
            score = compareScoresBy4(firstPlayerScore, secondPlayerScore, score, compareScoresBy4);
        }
        return score;
    }

    private static String compareScoresBy4(int firstPlayerScore, int secondPlayerScore, String score, boolean compareScoresBy4) {
        int tempScore;
        if (compareScoresBy4) {
            int minusResult = firstPlayerScore - secondPlayerScore;
            boolean compareMinusResultBy1 = minusResult == 1;
            if (compareMinusResultBy1) score = ADVANTAGE_FOR_FIRST_PLAYER;
            else {
                boolean compareMinusResultByNegative1 = minusResult == -1;
                if (compareMinusResultByNegative1) score = ADVANTAGE_FOR_SECOND_PLAYER;
                else {
                    boolean compareMinusResultBy2 = minusResult >= 2;
                    if (compareMinusResultBy2) score = WIN_FOR_FIRST_PLAYER;
                    else score = WIN_FOR_SECOND_PLAYER;
                }
            }
        } else {
            for (int i = 1; i < 3; i++) {
                boolean compareBy1 = i == 1;
                if (compareBy1) tempScore = firstPlayerScore;
                else {
                    score += "-";
                    tempScore = secondPlayerScore;
                }
                switch (tempScore) {
                    case 0:
                        score += LOVE_ALL;
                        break;
                    case 1:
                        score += FIFTEEN_ALL;
                        break;
                    case 2:
                        score += THIRTY_ALL;
                        break;
                    case 3:
                        score += FORTY_ALL;
                        break;
                }
            }
        }
        return score;
    }

    private static String compareTwoScore(int firstPlayerScore) {
        String score;
        switch (firstPlayerScore) {
            case 0:
                score = LOVE_ALL;
                break;
            case 1:
                score = FIFTEEN_ALL;
                break;
            case 2:
                score = THIRTY_ALL;
                break;
            case 3:
                score = FORTY_ALL;
                break;
            default:
                score = DEUCE;
                break;

        }
        return score;
    }
}