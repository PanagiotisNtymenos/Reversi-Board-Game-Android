package boardgame.reversi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameEngine extends AppCompatActivity {

    static char choice = ' ';
    static char revChoice = ' ';
    public static int row, column, endGame = 0, Xnum = 0, Onum = 0;
    static Moves move = new Moves();
    static Board z = new Board();
    private boolean pTurn = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_activity);
        final TextView display = findViewById(R.id.display);
        final Button blacks = findViewById(R.id.black);
        final Button whites = findViewById(R.id.white);

        findViewById(R.id.black).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                choice = 'X';
                revChoice = 'O';
                display.setText("CPU's turn(" + choice + "): ");
                blacks.setText("P");
                whites.setText("CPU");
                blacks.setClickable(false);
                whites.setClickable(false);
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
            }
        });

        findViewById(R.id.b00).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "00");
                    pTurn = false;
                }
                pTurn = true;

            }
        });

        findViewById(R.id.b01).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "01");
                    pTurn = false;
                }

                pTurn = true;

            }
        });
        findViewById(R.id.b02).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "02");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b03).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "03");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b04).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "04");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b05).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "05");
                    pTurn = false;
                }
                pTurn = true;
            }
        });

        findViewById(R.id.b06).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "06");
                    pTurn = false;
                }
                pTurn = true;
            }
        });

        findViewById(R.id.b07).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "07");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b11).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "11");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b12).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "12");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b13).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "13");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b14).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "14");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b15).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "15");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b16).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "16");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b17).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "17");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b20).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "20");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b21).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "21");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b22).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "22");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b23).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "23");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b24).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "24");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b25).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "25");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b26).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "26");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b27).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "27");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b30).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "30");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b31).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "31");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b32).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "32");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b33).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "33");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b34).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "34");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b35).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "35");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b36).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "36");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b37).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "37");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b40).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "40");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b41).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "41");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b42).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "42");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b43).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "43");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b44).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "44");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b45).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "45");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b46).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "46");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b47).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "47");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b50).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "50");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b51).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "51");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b52).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "52");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b53).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "53");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b54).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "54");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b55).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "55");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b56).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "56");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b57).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "57");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b60).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "60");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b61).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "61");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b62).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "62");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b63).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "63");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b64).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "64");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b65).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "65");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b66).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "66");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b67).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "67");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b70).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "70");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b71).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "71");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b72).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "72");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b73).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "73");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b74).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "74");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b75).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "75");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b76).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "76");
                    pTurn = false;
                }
                pTurn = true;
            }
        });
        findViewById(R.id.b77).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pTurn) {
                    playersTurn(choice, display, "77");
                    pTurn = false;
                }
                pTurn = true;
            }
        });

    }

    public static void playersTurn(char choice, TextView display, String position) {
        display.setText("Player's turn(" + choice + "): ");
        if (move.possibleMoves(z, choice)) {
            row = 0;
            column = 0;
            endGame = 0;
//            z.printWithMap(z);

            row = Integer.parseInt(String.valueOf(position.charAt(0)));
            column = Integer.parseInt(String.valueOf(position.charAt(1)));


            if (!(z.Map[row][column] == 'Z')) {

                display.setText("No move in such coordinates.");
            } else {

                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        z.currentBoard[x][y] = z.nextMoves[row][column].currentBoard[x][y];
                    }
                }

                AITurn(revChoice, choice, display);
            }
        } else {
            display.setText("No moves to make.");
            endGame++;
        }
    }

    public static void AITurn(char choice, char revChoice, TextView display) {

        display.setText("CPU's turn(" + revChoice + "): ");
        if (move.possibleMoves(z, choice)) {
            endGame = 0;
            Board temp = move.outcomeminimax(z, 5, -10000, 10000, choice, revChoice, true);
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    z.currentBoard[x][y] = temp.currentBoard[x][y];
                }
            }

            display.setText("CPU Played.");
        } else {
            display.setText("No moves to make.");
            endGame++;
        }
    }

    public static void calculateScore(Board B, char choice, TextView display) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (z.currentBoard[i][j] == 'X') Xnum++;
                else if (z.currentBoard[i][j] == 'O') Onum++;
            }
        }
        B.print(B);
        if (Xnum > Onum) {
            if (choice == 'X') display.setText("You Won! Score: " + Xnum + " - " + Onum);
            else display.setText("You Lost! Score: " + Xnum + " - " + Onum);
        } else if (Xnum < Onum) {
            if (choice == 'O') display.setText("You Won! Score: " + Xnum + " - " + Onum);
            else display.setText("You Lost! Score: " + Xnum + " - " + Onum);
        } else display.setText("Draw! Score:" + Xnum + " - " + Onum);
    }


}
