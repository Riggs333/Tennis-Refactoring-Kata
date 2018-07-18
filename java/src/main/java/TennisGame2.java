public class TennisGame2 implements TennisGame {
    public int P1point = 0;

    public int P2point = 0;

    public String P1res = "";

    public String P2res = "";

    private String player1Name;

    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getStringFromPoint(int point) {
        String result = "";

        switch (point) {
            case 0:
                result = "Love";
                break;
            case 1:
                result = "Fifteen";
                break;
            case 2:
                result = "Thirty";
                break;
            case 3:
                result = "Forty";
                break;

        }
        return result;

    }

    public String getScore() {
        String score = "";

        if (P1point == P2point) {
            if (P1point < 3) {
                score = getStringFromPoint(P1point);
                score += "-All";
            } else {
                score = "Deuce";
            }
        }else{
            score = getStringFromPoint(P1point) + "-" + getStringFromPoint(P2point);
        }

        if (isPlayer1Leading() && P2point >= 3) {
            score = "Advantage player1";
        }

        if (isPlayer2Leading() && P1point >= 3) {
            score = "Advantage player2";
        }

        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            score = "Win for player1";
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    private boolean isPlayer2LeadingAndHasLessThan4Points() {
        return isPlayer2Leading() && P2point < 4;
    }

    private boolean isPlayer1LeadingAndHasLessThan4Points() {
        return isPlayer1Leading() && P1point < 4;
    }

    private boolean leadingPlayerHasLessThan4Points() {
        return isPlayer1LeadingAndHasLessThan4Points() || isPlayer2LeadingAndHasLessThan4Points();
    }

    private boolean isPlayer2Leading() {
        return P2point > P1point;
    }

    private boolean isPlayer1Leading() {
        return P1point > P2point;
    }

    public void SetP1Score(int number) {

        for (int i = 0; i < number; i++) {
            P1Score();
        }

    }

    public void SetP2Score(int number) {

        for (int i = 0; i < number; i++) {
            P2Score();
        }

    }

    public void P1Score() {
        P1point++;
    }

    public void P2Score() {
        P2point++;
    }

    public void wonPoint(String player) {
        if (player.equals(player1Name)) {
            P1Score();
        } else {
            P2Score();
        }
    }
}