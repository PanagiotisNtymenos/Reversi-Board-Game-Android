package boardgame.reversi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameEngine extends AppCompatActivity {

    int Xs = 0, Os = 0;
    static char choice = ' ';
    static char revChoice = ' ';
    public static int row, column, endGame = 0, Xnum = 0, Onum = 0;
    static Moves move = new Moves();
    static Board z = new Board();
    private boolean pTurn = false;
    private boolean finish = false;
    private boolean hints = false;
    private int depth = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_activity);
        final TextView display = findViewById(R.id.display);
        final Button blacks = findViewById(R.id.black);
        final Button whites = findViewById(R.id.white);
        final TextView onoff = findViewById(R.id.onoff);
        final Button difficulty = findViewById(R.id.easy_hard);

        findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pTurn = false;
                depth = 3;
                difficulty.setText("EASY");
                hints = false;
                onoff.setText("off");
                Xs = 0;
                Os = 0;
                choice = ' ';
                revChoice = ' ';
                row = 0;
                column = 0;
                endGame = 0;
                Xnum = 0;
                Onum = 0;
                move = new Moves();
                z = new Board();
                finish = false;
                blacks.setText("X");
                whites.setText("O");
                changeBoard();
            }
        });

        findViewById(R.id.easy_hard).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (depth == 3) {
                    depth = 5;
                    difficulty.setText("HARD");
                } else {
                    depth = 3;
                    difficulty.setText("EASY");
                }
            }
        });

        findViewById(R.id.black).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                choice = 'X';
                revChoice = 'O';
                display.setText("CPU's turn(" + choice + "): ");
                blacks.setText("P");
                whites.setText("CPU");
                blacks.setClickable(false);
                whites.setClickable(false);
                AITurn(revChoice, choice, display);
            }
        });
        findViewById(R.id.white).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                choice = 'O';
                revChoice = 'X';
                display.setText("Player's turn(" + choice + "): ");
                blacks.setText("CPU");
                whites.setText("P");
                blacks.setClickable(false);
                whites.setClickable(false);
                pTurn = true;
                playersTurn(choice, display, "R");
                changeBoard();

            }
        });

        findViewById(R.id.hints).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (hints) {
                    hints = false;
                    onoff.setText("off");
                    changeBoard();
                } else {
                    hints = true;
                    onoff.setText("on");
                    changeBoard();
                }

            }
        });

        findViewById(R.id.b00).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "00");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });

        findViewById(R.id.b01).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "01");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b02).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "02");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;

            }
        });
        findViewById(R.id.b03).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "03");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;

            }
        });
        findViewById(R.id.b04).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "04");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;

            }
        });
        findViewById(R.id.b05).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "05");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });

        findViewById(R.id.b06).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "06");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });

        findViewById(R.id.b07).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "07");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b10).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "10");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b11).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "11");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b12).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "12");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b13).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "13");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b14).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "14");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b15).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "15");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b16).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "16");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b17).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "17");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b20).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "20");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b21).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "21");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b22).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "22");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b23).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "23");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b24).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "24");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b25).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "25");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b26).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "26");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b27).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "27");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b30).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "30");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b31).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "31");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b32).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "32");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b33).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "33");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b34).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "34");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b35).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "35");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b36).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "36");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b37).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "37");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b40).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "40");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b41).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "41");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b42).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "42");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b43).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "43");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b44).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "44");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b45).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "45");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b46).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "46");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b47).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "47");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b50).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "50");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b51).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "51");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b52).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "52");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b53).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "53");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b54).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "54");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b55).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "55");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b56).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "56");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b57).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "57");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b60).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "60");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b61).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "61");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b62).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "62");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b63).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "63");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b64).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "64");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b65).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "65");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b66).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "66");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b67).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "67");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b70).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "70");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b71).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "71");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b72).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "72");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b73).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "73");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b74).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "74");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b75).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "75");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b76).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "76");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b77).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "77");
                    pTurn = false;
                } else {
                    findViewById(R.id.black).performClick();
                }
                pTurn = true;
            }
        });

    }

    public void playersTurn(char choice, TextView display, String position) {
        if (!finish) {
            display.setText("Player's turn(" + choice + "): ");
            if (move.possibleMoves(z, choice)) {
                row = 0;
                column = 0;
                endGame = 0;
//            z.printWithMap(z);
                changeBoard();
                if (!position.equals("R")) {
                    row = Integer.parseInt(String.valueOf(position.charAt(0)));
                    column = Integer.parseInt(String.valueOf(position.charAt(1)));


                    if (!(z.Map[row][column] == 'Z')) {

                        display.setText("Can't move there!");
                    } else {

                        for (int x = 0; x < 8; x++) {
                            for (int y = 0; y < 8; y++) {
                                z.currentBoard[x][y] = z.nextMoves[row][column].currentBoard[x][y];
                            }
                        }
                        changeBoard();
                        liveScore(z);
                        AITurn(revChoice, choice, display);
                    }
                }
            } else {

                display.setText("No moves to make.");
                endGame++;
                liveScore(z);
                AITurn(revChoice, choice, display);
                if (endGame >= 2) {
                    calculateScore(z, choice, display);
                }
            }
        }
    }

    public void AITurn(char choice, char revChoice, TextView display) {
        if (!finish) {
            display.setText("CPU's turn(" + revChoice + "): ");
            changeBoard();
            if (move.possibleMoves(z, choice)) {
                endGame = 0;
                Board temp = move.outcomeminimax(z, depth, -10000, 10000, choice, revChoice, true);
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        z.currentBoard[x][y] = temp.currentBoard[x][y];
                    }
                }

                display.setText("CPU Played.");
                liveScore(z);
                playersTurn(revChoice, display, "R");

            } else {

                display.setText("No moves to make for CPU.");
                endGame++;
                if (endGame >= 2 || Os + Xs == 64) {
                    calculateScore(z, choice, display);
                }
            }
        }
    }

    public void calculateScore(Board B, char choice, TextView display) {
        if (!finish) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (z.currentBoard[i][j] == 'X') Xnum++;
                    else if (z.currentBoard[i][j] == 'O') Onum++;
                }
            }
            if (Xnum > Onum) {
                if (choice == 'O') display.setText("You Won! Score: " + Xnum + " - " + Onum);
                else display.setText("You Lost! Score: " + Xnum + " - " + Onum);
            } else if (Xnum < Onum) {
                if (choice == 'X') display.setText("You Won! Score: " + Xnum + " - " + Onum);
                else display.setText("You Lost! Score: " + Xnum + " - " + Onum);
            } else display.setText("Draw! Score:" + Xnum + " - " + Onum);
            finish = true;
        }
    }

    private void liveScore(Board B) {
        Xs = 0;
        Os = 0;
        final TextView blackp = findViewById(R.id.black_points);
        final TextView whitep = findViewById(R.id.white_points);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (z.currentBoard[i][j] == 'X') Xs++;
                else if (z.currentBoard[i][j] == 'O') Os++;
            }
        }
        blackp.setText(Xs + "");
        whitep.setText(Os + "");
    }

    public void changeBoard() {
        final ImageButton b00 = findViewById(R.id.b00);
        final ImageButton b01 = findViewById(R.id.b01);
        final ImageButton b02 = findViewById(R.id.b02);
        final ImageButton b03 = findViewById(R.id.b03);
        final ImageButton b04 = findViewById(R.id.b04);
        final ImageButton b05 = findViewById(R.id.b05);
        final ImageButton b06 = findViewById(R.id.b06);
        final ImageButton b07 = findViewById(R.id.b07);

        final ImageButton b10 = findViewById(R.id.b10);
        final ImageButton b11 = findViewById(R.id.b11);
        final ImageButton b12 = findViewById(R.id.b12);
        final ImageButton b13 = findViewById(R.id.b13);
        final ImageButton b14 = findViewById(R.id.b14);
        final ImageButton b15 = findViewById(R.id.b15);
        final ImageButton b16 = findViewById(R.id.b16);
        final ImageButton b17 = findViewById(R.id.b17);

        final ImageButton b20 = findViewById(R.id.b20);
        final ImageButton b21 = findViewById(R.id.b21);
        final ImageButton b22 = findViewById(R.id.b22);
        final ImageButton b23 = findViewById(R.id.b23);
        final ImageButton b24 = findViewById(R.id.b24);
        final ImageButton b25 = findViewById(R.id.b25);
        final ImageButton b26 = findViewById(R.id.b26);
        final ImageButton b27 = findViewById(R.id.b27);

        final ImageButton b30 = findViewById(R.id.b30);
        final ImageButton b31 = findViewById(R.id.b31);
        final ImageButton b32 = findViewById(R.id.b32);
        final ImageButton b33 = findViewById(R.id.b33);
        final ImageButton b34 = findViewById(R.id.b34);
        final ImageButton b35 = findViewById(R.id.b35);
        final ImageButton b36 = findViewById(R.id.b36);
        final ImageButton b37 = findViewById(R.id.b37);

        final ImageButton b40 = findViewById(R.id.b40);
        final ImageButton b41 = findViewById(R.id.b41);
        final ImageButton b42 = findViewById(R.id.b42);
        final ImageButton b43 = findViewById(R.id.b43);
        final ImageButton b44 = findViewById(R.id.b44);
        final ImageButton b45 = findViewById(R.id.b45);
        final ImageButton b46 = findViewById(R.id.b46);
        final ImageButton b47 = findViewById(R.id.b47);

        final ImageButton b50 = findViewById(R.id.b50);
        final ImageButton b51 = findViewById(R.id.b51);
        final ImageButton b52 = findViewById(R.id.b52);
        final ImageButton b53 = findViewById(R.id.b53);
        final ImageButton b54 = findViewById(R.id.b54);
        final ImageButton b55 = findViewById(R.id.b55);
        final ImageButton b56 = findViewById(R.id.b56);
        final ImageButton b57 = findViewById(R.id.b57);

        final ImageButton b60 = findViewById(R.id.b60);
        final ImageButton b61 = findViewById(R.id.b61);
        final ImageButton b62 = findViewById(R.id.b62);
        final ImageButton b63 = findViewById(R.id.b63);
        final ImageButton b64 = findViewById(R.id.b64);
        final ImageButton b65 = findViewById(R.id.b65);
        final ImageButton b66 = findViewById(R.id.b66);
        final ImageButton b67 = findViewById(R.id.b67);

        final ImageButton b70 = findViewById(R.id.b70);
        final ImageButton b71 = findViewById(R.id.b71);
        final ImageButton b72 = findViewById(R.id.b72);
        final ImageButton b73 = findViewById(R.id.b73);
        final ImageButton b74 = findViewById(R.id.b74);
        final ImageButton b75 = findViewById(R.id.b75);
        final ImageButton b76 = findViewById(R.id.b76);
        final ImageButton b77 = findViewById(R.id.b77);
        String position = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                position = i + "" + j;
                if (z.currentBoard[i][j] == 'O') {
                    if (position.equals("00")) {
                        b00.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("01")) {
                        b01.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("02")) {
                        b02.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("03")) {
                        b03.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("04")) {
                        b04.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("05")) {
                        b05.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("06")) {
                        b06.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("07")) {
                        b07.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("10")) {
                        b10.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("11")) {
                        b11.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("12")) {
                        b12.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("13")) {
                        b13.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("14")) {
                        b14.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("15")) {
                        b15.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("16")) {
                        b16.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("17")) {
                        b17.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("20")) {
                        b20.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("21")) {
                        b21.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("22")) {
                        b22.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("23")) {
                        b23.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("24")) {
                        b24.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("25")) {
                        b25.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("26")) {
                        b26.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("27")) {
                        b27.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("30")) {
                        b30.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("31")) {
                        b31.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("32")) {
                        b32.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("33")) {
                        b33.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("34")) {
                        b34.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("35")) {
                        b35.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("36")) {
                        b36.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("37")) {
                        b37.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("40")) {
                        b40.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("41")) {
                        b41.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("42")) {
                        b42.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("43")) {
                        b43.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("44")) {
                        b44.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("45")) {
                        b45.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("46")) {
                        b46.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("47")) {
                        b47.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("50")) {
                        b50.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("51")) {
                        b51.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("52")) {
                        b52.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("53")) {
                        b53.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("54")) {
                        b54.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("55")) {
                        b55.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("56")) {
                        b56.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("57")) {
                        b57.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("60")) {
                        b60.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("61")) {
                        b61.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("62")) {
                        b62.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("63")) {
                        b63.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("64")) {
                        b64.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("65")) {
                        b65.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("66")) {
                        b66.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("67")) {
                        b67.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("70")) {
                        b70.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("71")) {
                        b71.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("72")) {
                        b72.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("73")) {
                        b73.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("74")) {
                        b74.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("75")) {
                        b75.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("76")) {
                        b76.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("77")) {
                        b77.setImageResource(R.drawable.white_shadow);
                    }
                } else if (z.currentBoard[i][j] == 'X') {
                    if (position.equals("00")) {
                        b00.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("01")) {
                        b01.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("02")) {
                        b02.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("03")) {
                        b03.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("04")) {
                        b04.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("05")) {
                        b05.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("06")) {
                        b06.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("07")) {
                        b07.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("10")) {
                        b10.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("11")) {
                        b11.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("12")) {
                        b12.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("13")) {
                        b13.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("14")) {
                        b14.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("15")) {
                        b15.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("16")) {
                        b16.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("17")) {
                        b17.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("20")) {
                        b20.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("21")) {
                        b21.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("22")) {
                        b22.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("23")) {
                        b23.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("24")) {
                        b24.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("25")) {
                        b25.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("26")) {
                        b26.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("27")) {
                        b27.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("30")) {
                        b30.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("31")) {
                        b31.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("32")) {
                        b32.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("33")) {
                        b33.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("34")) {
                        b34.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("35")) {
                        b35.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("36")) {
                        b36.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("37")) {
                        b37.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("40")) {
                        b40.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("41")) {
                        b41.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("42")) {
                        b42.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("43")) {
                        b43.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("44")) {
                        b44.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("45")) {
                        b45.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("46")) {
                        b46.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("47")) {
                        b47.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("50")) {
                        b50.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("51")) {
                        b51.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("52")) {
                        b52.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("53")) {
                        b53.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("54")) {
                        b54.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("55")) {
                        b55.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("56")) {
                        b56.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("57")) {
                        b57.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("60")) {
                        b60.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("61")) {
                        b61.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("62")) {
                        b62.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("63")) {
                        b63.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("64")) {
                        b64.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("65")) {
                        b65.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("66")) {
                        b66.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("67")) {
                        b67.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("70")) {
                        b70.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("71")) {
                        b71.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("72")) {
                        b72.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("73")) {
                        b73.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("74")) {
                        b74.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("75")) {
                        b75.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("76")) {
                        b76.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("77")) {
                        b77.setImageResource(R.drawable.black_shadow);
                    }
                } else if (z.Map[i][j] == 'Z' && hints) {

                    if (position.equals("00")) {
                        b00.setImageResource(R.drawable.hint);
                    } else if (position.equals("01")) {
                        b01.setImageResource(R.drawable.hint);
                    } else if (position.equals("02")) {
                        b02.setImageResource(R.drawable.hint);
                    } else if (position.equals("03")) {
                        b03.setImageResource(R.drawable.hint);
                    } else if (position.equals("04")) {
                        b04.setImageResource(R.drawable.hint);
                    } else if (position.equals("05")) {
                        b05.setImageResource(R.drawable.hint);
                    } else if (position.equals("06")) {
                        b06.setImageResource(R.drawable.hint);
                    } else if (position.equals("07")) {
                        b07.setImageResource(R.drawable.hint);
                    } else if (position.equals("10")) {
                        b10.setImageResource(R.drawable.hint);
                    } else if (position.equals("11")) {
                        b11.setImageResource(R.drawable.hint);
                    } else if (position.equals("12")) {
                        b12.setImageResource(R.drawable.hint);
                    } else if (position.equals("13")) {
                        b13.setImageResource(R.drawable.hint);
                    } else if (position.equals("14")) {
                        b14.setImageResource(R.drawable.hint);
                    } else if (position.equals("15")) {
                        b15.setImageResource(R.drawable.hint);
                    } else if (position.equals("16")) {
                        b16.setImageResource(R.drawable.hint);
                    } else if (position.equals("17")) {
                        b17.setImageResource(R.drawable.hint);
                    } else if (position.equals("20")) {
                        b20.setImageResource(R.drawable.hint);
                    } else if (position.equals("21")) {
                        b21.setImageResource(R.drawable.hint);
                    } else if (position.equals("22")) {
                        b22.setImageResource(R.drawable.hint);
                    } else if (position.equals("23")) {
                        b23.setImageResource(R.drawable.hint);
                    } else if (position.equals("24")) {
                        b24.setImageResource(R.drawable.hint);
                    } else if (position.equals("25")) {
                        b25.setImageResource(R.drawable.hint);
                    } else if (position.equals("26")) {
                        b26.setImageResource(R.drawable.hint);
                    } else if (position.equals("27")) {
                        b27.setImageResource(R.drawable.hint);
                    } else if (position.equals("30")) {
                        b30.setImageResource(R.drawable.hint);
                    } else if (position.equals("31")) {
                        b31.setImageResource(R.drawable.hint);
                    } else if (position.equals("32")) {
                        b32.setImageResource(R.drawable.hint);
                    } else if (position.equals("33")) {
                        b33.setImageResource(R.drawable.hint);
                    } else if (position.equals("34")) {
                        b34.setImageResource(R.drawable.hint);
                    } else if (position.equals("35")) {
                        b35.setImageResource(R.drawable.hint);
                    } else if (position.equals("36")) {
                        b36.setImageResource(R.drawable.hint);
                    } else if (position.equals("37")) {
                        b37.setImageResource(R.drawable.hint);
                    } else if (position.equals("40")) {
                        b40.setImageResource(R.drawable.hint);
                    } else if (position.equals("41")) {
                        b41.setImageResource(R.drawable.hint);
                    } else if (position.equals("42")) {
                        b42.setImageResource(R.drawable.hint);
                    } else if (position.equals("43")) {
                        b43.setImageResource(R.drawable.hint);
                    } else if (position.equals("44")) {
                        b44.setImageResource(R.drawable.hint);
                    } else if (position.equals("45")) {
                        b45.setImageResource(R.drawable.hint);
                    } else if (position.equals("46")) {
                        b46.setImageResource(R.drawable.hint);
                    } else if (position.equals("47")) {
                        b47.setImageResource(R.drawable.hint);
                    } else if (position.equals("50")) {
                        b50.setImageResource(R.drawable.hint);
                    } else if (position.equals("51")) {
                        b51.setImageResource(R.drawable.hint);
                    } else if (position.equals("52")) {
                        b52.setImageResource(R.drawable.hint);
                    } else if (position.equals("53")) {
                        b53.setImageResource(R.drawable.hint);
                    } else if (position.equals("54")) {
                        b54.setImageResource(R.drawable.hint);
                    } else if (position.equals("55")) {
                        b55.setImageResource(R.drawable.hint);
                    } else if (position.equals("56")) {
                        b56.setImageResource(R.drawable.hint);
                    } else if (position.equals("57")) {
                        b57.setImageResource(R.drawable.hint);
                    } else if (position.equals("60")) {
                        b60.setImageResource(R.drawable.hint);
                    } else if (position.equals("61")) {
                        b61.setImageResource(R.drawable.hint);
                    } else if (position.equals("62")) {
                        b62.setImageResource(R.drawable.hint);
                    } else if (position.equals("63")) {
                        b63.setImageResource(R.drawable.hint);
                    } else if (position.equals("64")) {
                        b64.setImageResource(R.drawable.hint);
                    } else if (position.equals("65")) {
                        b65.setImageResource(R.drawable.hint);
                    } else if (position.equals("66")) {
                        b66.setImageResource(R.drawable.hint);
                    } else if (position.equals("67")) {
                        b67.setImageResource(R.drawable.hint);
                    } else if (position.equals("70")) {
                        b70.setImageResource(R.drawable.hint);
                    } else if (position.equals("71")) {
                        b71.setImageResource(R.drawable.hint);
                    } else if (position.equals("72")) {
                        b72.setImageResource(R.drawable.hint);
                    } else if (position.equals("73")) {
                        b73.setImageResource(R.drawable.hint);
                    } else if (position.equals("74")) {
                        b74.setImageResource(R.drawable.hint);
                    } else if (position.equals("75")) {
                        b75.setImageResource(R.drawable.hint);
                    } else if (position.equals("76")) {
                        b76.setImageResource(R.drawable.hint);
                    } else if (position.equals("77")) {
                        b77.setImageResource(R.drawable.hint);
                    }

                } else if (z.Map[i][j] == ' ' || (z.Map[i][j] == 'Z' && !hints)) {

                    if (position.equals("00")) {
                        b00.setImageResource(R.drawable.transparent);
                    } else if (position.equals("01")) {
                        b01.setImageResource(R.drawable.transparent);
                    } else if (position.equals("02")) {
                        b02.setImageResource(R.drawable.transparent);
                    } else if (position.equals("03")) {
                        b03.setImageResource(R.drawable.transparent);
                    } else if (position.equals("04")) {
                        b04.setImageResource(R.drawable.transparent);
                    } else if (position.equals("05")) {
                        b05.setImageResource(R.drawable.transparent);
                    } else if (position.equals("06")) {
                        b06.setImageResource(R.drawable.transparent);
                    } else if (position.equals("07")) {
                        b07.setImageResource(R.drawable.transparent);
                    } else if (position.equals("10")) {
                        b10.setImageResource(R.drawable.transparent);
                    } else if (position.equals("11")) {
                        b11.setImageResource(R.drawable.transparent);
                    } else if (position.equals("12")) {
                        b12.setImageResource(R.drawable.transparent);
                    } else if (position.equals("13")) {
                        b13.setImageResource(R.drawable.transparent);
                    } else if (position.equals("14")) {
                        b14.setImageResource(R.drawable.transparent);
                    } else if (position.equals("15")) {
                        b15.setImageResource(R.drawable.transparent);
                    } else if (position.equals("16")) {
                        b16.setImageResource(R.drawable.transparent);
                    } else if (position.equals("17")) {
                        b17.setImageResource(R.drawable.transparent);
                    } else if (position.equals("20")) {
                        b20.setImageResource(R.drawable.transparent);
                    } else if (position.equals("21")) {
                        b21.setImageResource(R.drawable.transparent);
                    } else if (position.equals("22")) {
                        b22.setImageResource(R.drawable.transparent);
                    } else if (position.equals("23")) {
                        b23.setImageResource(R.drawable.transparent);
                    } else if (position.equals("24")) {
                        b24.setImageResource(R.drawable.transparent);
                    } else if (position.equals("25")) {
                        b25.setImageResource(R.drawable.transparent);
                    } else if (position.equals("26")) {
                        b26.setImageResource(R.drawable.transparent);
                    } else if (position.equals("27")) {
                        b27.setImageResource(R.drawable.transparent);
                    } else if (position.equals("30")) {
                        b30.setImageResource(R.drawable.transparent);
                    } else if (position.equals("31")) {
                        b31.setImageResource(R.drawable.transparent);
                    } else if (position.equals("32")) {
                        b32.setImageResource(R.drawable.transparent);
                    } else if (position.equals("33")) {
                        b33.setImageResource(R.drawable.transparent);
                    } else if (position.equals("34")) {
                        b34.setImageResource(R.drawable.transparent);
                    } else if (position.equals("35")) {
                        b35.setImageResource(R.drawable.transparent);
                    } else if (position.equals("36")) {
                        b36.setImageResource(R.drawable.transparent);
                    } else if (position.equals("37")) {
                        b37.setImageResource(R.drawable.transparent);
                    } else if (position.equals("40")) {
                        b40.setImageResource(R.drawable.transparent);
                    } else if (position.equals("41")) {
                        b41.setImageResource(R.drawable.transparent);
                    } else if (position.equals("42")) {
                        b42.setImageResource(R.drawable.transparent);
                    } else if (position.equals("43")) {
                        b43.setImageResource(R.drawable.transparent);
                    } else if (position.equals("44")) {
                        b44.setImageResource(R.drawable.transparent);
                    } else if (position.equals("45")) {
                        b45.setImageResource(R.drawable.transparent);
                    } else if (position.equals("46")) {
                        b46.setImageResource(R.drawable.transparent);
                    } else if (position.equals("47")) {
                        b47.setImageResource(R.drawable.transparent);
                    } else if (position.equals("50")) {
                        b50.setImageResource(R.drawable.transparent);
                    } else if (position.equals("51")) {
                        b51.setImageResource(R.drawable.transparent);
                    } else if (position.equals("52")) {
                        b52.setImageResource(R.drawable.transparent);
                    } else if (position.equals("53")) {
                        b53.setImageResource(R.drawable.transparent);
                    } else if (position.equals("54")) {
                        b54.setImageResource(R.drawable.transparent);
                    } else if (position.equals("55")) {
                        b55.setImageResource(R.drawable.transparent);
                    } else if (position.equals("56")) {
                        b56.setImageResource(R.drawable.transparent);
                    } else if (position.equals("57")) {
                        b57.setImageResource(R.drawable.transparent);
                    } else if (position.equals("60")) {
                        b60.setImageResource(R.drawable.transparent);
                    } else if (position.equals("61")) {
                        b61.setImageResource(R.drawable.transparent);
                    } else if (position.equals("62")) {
                        b62.setImageResource(R.drawable.transparent);
                    } else if (position.equals("63")) {
                        b63.setImageResource(R.drawable.transparent);
                    } else if (position.equals("64")) {
                        b64.setImageResource(R.drawable.transparent);
                    } else if (position.equals("65")) {
                        b65.setImageResource(R.drawable.transparent);
                    } else if (position.equals("66")) {
                        b66.setImageResource(R.drawable.transparent);
                    } else if (position.equals("67")) {
                        b67.setImageResource(R.drawable.transparent);
                    } else if (position.equals("70")) {
                        b70.setImageResource(R.drawable.transparent);
                    } else if (position.equals("71")) {
                        b71.setImageResource(R.drawable.transparent);
                    } else if (position.equals("72")) {
                        b72.setImageResource(R.drawable.transparent);
                    } else if (position.equals("73")) {
                        b73.setImageResource(R.drawable.transparent);
                    } else if (position.equals("74")) {
                        b74.setImageResource(R.drawable.transparent);
                    } else if (position.equals("75")) {
                        b75.setImageResource(R.drawable.transparent);
                    } else if (position.equals("76")) {
                        b76.setImageResource(R.drawable.transparent);
                    } else if (position.equals("77")) {
                        b77.setImageResource(R.drawable.transparent);
                    }

                }
            }
        }
    }
}
