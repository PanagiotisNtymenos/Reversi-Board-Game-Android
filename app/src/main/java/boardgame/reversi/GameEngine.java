package boardgame.reversi;

import android.graphics.drawable.Animatable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class GameEngine extends AppCompatActivity {

    int Xs = 0, Os = 0, c = 0;
    char choice = ' ';
    static char revChoice = ' ';
    public static int row, column, endGame = 0, Xnum = 0, Onum = 0;
    static Moves move = new Moves();
    static Board z = new Board();
    public char[][] currentBoardTemp = new char[8][8];
    private boolean pTurn = false;
    private boolean finish = false;
    private boolean hints = false;
    private boolean mute = false;
    private int depth = 1;
    private boolean delayThat = true;
    Animation blink;
    Animation anim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        final MediaPlayer hint_sound = MediaPlayer.create(this, R.raw.hint);
        final MediaPlayer hint_sound_off = MediaPlayer.create(this, R.raw.hintoff);
        final MediaPlayer reset_sound = MediaPlayer.create(this, R.raw.reset);
        final MediaPlayer level_sound = MediaPlayer.create(this, R.raw.level);
        final TextView display = findViewById(R.id.display);
        final Button blacks = findViewById(R.id.black);
        final Button whites = findViewById(R.id.white);
        final TextView onoff = findViewById(R.id.onoff);
        final TextView blackp = findViewById(R.id.black_points);
        final TextView anim_select = findViewById(R.id.anim_select);
        final TextView whitep = findViewById(R.id.white_points);
        final TextView dif_txt = findViewById(R.id.dif_txt);
        final ImageView fast = findViewById(R.id.fast);
        final ImageView slow = findViewById(R.id.slow);
        final ImageView sound = findViewById(R.id.sound);
        final ImageButton reset = findViewById(R.id.reset);

        findViewById(R.id.v_dis).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (true) {
                    findViewById(R.id.b00).setClickable(false);
                    findViewById(R.id.b01).setClickable(false);
                    findViewById(R.id.b02).setClickable(false);
                    findViewById(R.id.b03).setClickable(false);
                    findViewById(R.id.b04).setClickable(false);
                    findViewById(R.id.b05).setClickable(false);
                    findViewById(R.id.b06).setClickable(false);
                    findViewById(R.id.b07).setClickable(false);
                    findViewById(R.id.b10).setClickable(false);
                    findViewById(R.id.b11).setClickable(false);
                    findViewById(R.id.b12).setClickable(false);
                    findViewById(R.id.b13).setClickable(false);
                    findViewById(R.id.b14).setClickable(false);
                    findViewById(R.id.b15).setClickable(false);
                    findViewById(R.id.b16).setClickable(false);
                    findViewById(R.id.b17).setClickable(false);
                    findViewById(R.id.b20).setClickable(false);
                    findViewById(R.id.b21).setClickable(false);
                    findViewById(R.id.b22).setClickable(false);
                    findViewById(R.id.b23).setClickable(false);
                    findViewById(R.id.b24).setClickable(false);
                    findViewById(R.id.b25).setClickable(false);
                    findViewById(R.id.b26).setClickable(false);
                    findViewById(R.id.b27).setClickable(false);
                    findViewById(R.id.b30).setClickable(false);
                    findViewById(R.id.b31).setClickable(false);
                    findViewById(R.id.b32).setClickable(false);
                    findViewById(R.id.b33).setClickable(false);
                    findViewById(R.id.b34).setClickable(false);
                    findViewById(R.id.b35).setClickable(false);
                    findViewById(R.id.b36).setClickable(false);
                    findViewById(R.id.b37).setClickable(false);
                    findViewById(R.id.b40).setClickable(false);
                    findViewById(R.id.b41).setClickable(false);
                    findViewById(R.id.b42).setClickable(false);
                    findViewById(R.id.b43).setClickable(false);
                    findViewById(R.id.b44).setClickable(false);
                    findViewById(R.id.b45).setClickable(false);
                    findViewById(R.id.b46).setClickable(false);
                    findViewById(R.id.b47).setClickable(false);
                    findViewById(R.id.b50).setClickable(false);
                    findViewById(R.id.b51).setClickable(false);
                    findViewById(R.id.b52).setClickable(false);
                    findViewById(R.id.b53).setClickable(false);
                    findViewById(R.id.b54).setClickable(false);
                    findViewById(R.id.b55).setClickable(false);
                    findViewById(R.id.b56).setClickable(false);
                    findViewById(R.id.b57).setClickable(false);
                    findViewById(R.id.b60).setClickable(false);
                    findViewById(R.id.b61).setClickable(false);
                    findViewById(R.id.b62).setClickable(false);
                    findViewById(R.id.b63).setClickable(false);
                    findViewById(R.id.b64).setClickable(false);
                    findViewById(R.id.b65).setClickable(false);
                    findViewById(R.id.b66).setClickable(false);
                    findViewById(R.id.b67).setClickable(false);
                    findViewById(R.id.b70).setClickable(false);
                    findViewById(R.id.b71).setClickable(false);
                    findViewById(R.id.b72).setClickable(false);
                    findViewById(R.id.b73).setClickable(false);
                    findViewById(R.id.b74).setClickable(false);
                    findViewById(R.id.b75).setClickable(false);
                    findViewById(R.id.b76).setClickable(false);
                    findViewById(R.id.b77).setClickable(false);
                }
            }
        });
        findViewById(R.id.v_en).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (true) {
                    findViewById(R.id.b00).setClickable(true);
                    findViewById(R.id.b01).setClickable(true);
                    findViewById(R.id.b02).setClickable(true);
                    findViewById(R.id.b03).setClickable(true);
                    findViewById(R.id.b04).setClickable(true);
                    findViewById(R.id.b05).setClickable(true);
                    findViewById(R.id.b06).setClickable(true);
                    findViewById(R.id.b07).setClickable(true);
                    findViewById(R.id.b10).setClickable(true);
                    findViewById(R.id.b11).setClickable(true);
                    findViewById(R.id.b12).setClickable(true);
                    findViewById(R.id.b13).setClickable(true);
                    findViewById(R.id.b14).setClickable(true);
                    findViewById(R.id.b15).setClickable(true);
                    findViewById(R.id.b16).setClickable(true);
                    findViewById(R.id.b17).setClickable(true);
                    findViewById(R.id.b20).setClickable(true);
                    findViewById(R.id.b21).setClickable(true);
                    findViewById(R.id.b22).setClickable(true);
                    findViewById(R.id.b23).setClickable(true);
                    findViewById(R.id.b24).setClickable(true);
                    findViewById(R.id.b25).setClickable(true);
                    findViewById(R.id.b26).setClickable(true);
                    findViewById(R.id.b27).setClickable(true);
                    findViewById(R.id.b30).setClickable(true);
                    findViewById(R.id.b31).setClickable(true);
                    findViewById(R.id.b32).setClickable(true);
                    findViewById(R.id.b33).setClickable(true);
                    findViewById(R.id.b34).setClickable(true);
                    findViewById(R.id.b35).setClickable(true);
                    findViewById(R.id.b36).setClickable(true);
                    findViewById(R.id.b37).setClickable(true);
                    findViewById(R.id.b40).setClickable(true);
                    findViewById(R.id.b41).setClickable(true);
                    findViewById(R.id.b42).setClickable(true);
                    findViewById(R.id.b43).setClickable(true);
                    findViewById(R.id.b44).setClickable(true);
                    findViewById(R.id.b45).setClickable(true);
                    findViewById(R.id.b46).setClickable(true);
                    findViewById(R.id.b47).setClickable(true);
                    findViewById(R.id.b50).setClickable(true);
                    findViewById(R.id.b51).setClickable(true);
                    findViewById(R.id.b52).setClickable(true);
                    findViewById(R.id.b53).setClickable(true);
                    findViewById(R.id.b54).setClickable(true);
                    findViewById(R.id.b55).setClickable(true);
                    findViewById(R.id.b56).setClickable(true);
                    findViewById(R.id.b57).setClickable(true);
                    findViewById(R.id.b60).setClickable(true);
                    findViewById(R.id.b61).setClickable(true);
                    findViewById(R.id.b62).setClickable(true);
                    findViewById(R.id.b63).setClickable(true);
                    findViewById(R.id.b64).setClickable(true);
                    findViewById(R.id.b65).setClickable(true);
                    findViewById(R.id.b66).setClickable(true);
                    findViewById(R.id.b67).setClickable(true);
                    findViewById(R.id.b70).setClickable(true);
                    findViewById(R.id.b71).setClickable(true);
                    findViewById(R.id.b72).setClickable(true);
                    findViewById(R.id.b73).setClickable(true);
                    findViewById(R.id.b74).setClickable(true);
                    findViewById(R.id.b75).setClickable(true);
                    findViewById(R.id.b76).setClickable(true);
                    findViewById(R.id.b77).setClickable(true);
                }
            }
        });
        findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pTurn = false;
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
                blacks.setClickable(true);
                whites.setClickable(true);
                display.setText("New Game!");
                blackp.setText(Xs + "");
                whitep.setText(Os + "");
                changeBoard("reset", false);
                if (!mute) reset_sound.start();
                reset.animate().rotation(reset.getRotation() - 360).start();
            }
        });
        findViewById(R.id.sound).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation zoomout = AnimationUtils.loadAnimation(GameEngine.this, R.anim.zoomout);
                Animation zoomin = AnimationUtils.loadAnimation(GameEngine.this, R.anim.zoomin);
                if (mute) {
                    mute = false;
                    sound.setImageResource(R.drawable.sound_yellow);
                    level_sound.start();
                    sound.startAnimation(zoomin);
                } else {
                    sound.startAnimation(zoomout);
                    sound.setImageResource(R.drawable.sound_white);
                    mute = true;
                }
            }
        });
        findViewById(R.id.easy_hard).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation bounce = AnimationUtils.loadAnimation(GameEngine.this, R.anim.bounce);
                dif_txt.startAnimation(bounce);
                if (!mute) level_sound.start();
                depth = depth + 2;
                if (depth == 7) {
                    depth = 1;
                    dif_txt.setText("EASY");
                } else if (depth == 3) {
                    dif_txt.setText("HARD");
                } else if (depth == 5) {
                    dif_txt.setText("PRO");
                }
            }
        });
        findViewById(R.id.fast_slow).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!mute) level_sound.start();
                if (delayThat) {
                    fast.setImageResource(R.drawable.fast_yellow_shadow);
                    slow.setImageResource(R.drawable.slow_white_shadow);
                    delayThat = false;
                } else {
                    fast.setImageResource(R.drawable.fast_white_shadow);
                    slow.setImageResource(R.drawable.slow_yellow_shadow);
                    delayThat = true;
                }
            }
        });
        findViewById(R.id.black).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!mute) hint_sound.start();
                choice = 'X';
                revChoice = 'O';
                display.setText("CPU's turn!");
                blacks.setText("P");
                whites.setText("CPU");
                blacks.setClickable(false);
                whites.setClickable(false);
                pTurn = true;
                AITurn(revChoice, choice, display);
            }
        });
        findViewById(R.id.white).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!mute) hint_sound.start();
                choice = 'O';
                revChoice = 'X';
                display.setText("Your turn!");
                blacks.setText("CPU");
                whites.setText("P");
                blacks.setClickable(false);
                whites.setClickable(false);
                pTurn = true;
                playersTurn(choice, display, "R");
                changeBoard("update", false);

            }
        });
        findViewById(R.id.hints).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (hints) {
                    if (!mute) hint_sound_off.start();
                    hints = false;
                    onoff.setText("off");
                } else {
                    if (!mute) hint_sound.start();
                    hints = true;
                    onoff.setText("on");
                }
                showHints();
            }
        });
        findViewById(R.id.animation).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!mute) level_sound.start();
                c++;
                if (c == 1) {
                    anim = AnimationUtils.loadAnimation(GameEngine.this, R.anim.bounce);
                    anim_select.setText("||");
                } else if (c == 2) {
                    anim = AnimationUtils.loadAnimation(GameEngine.this, R.anim.zoomin);
                    anim_select.setText("|||");
                } else if (c == 3) {
                    anim = AnimationUtils.loadAnimation(GameEngine.this, R.anim.flip);
                    anim_select.setText("||||");
                } else if (c == 4) {
                    anim = AnimationUtils.loadAnimation(GameEngine.this, R.anim.lefttoright);
                    anim_select.setText("|||||");
                } else {
                    anim = AnimationUtils.loadAnimation(GameEngine.this, R.anim.blink_anim);
                    c = 0;
                    anim_select.setText("|");
                }
                anim_select.startAnimation(anim);

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
        final Button virtual_enable = findViewById(R.id.v_en);
        final Button virtual_disable = findViewById(R.id.v_dis);
        MediaPlayer roll = MediaPlayer.create(this, R.raw.rollover);
        if (!finish) {
            if (move.possibleMoves(z, choice)) {
                row = 0;
                column = 0;
                endGame = 0;
                if (!position.equals("R")) {
                    display.setText("CPU's turn!");
                    row = Integer.parseInt(String.valueOf(position.charAt(0)));
                    column = Integer.parseInt(String.valueOf(position.charAt(1)));


                    if (!(z.Map[row][column] == 'Z')) {

                        display.setText("Can't move there!");
                    } else {
                        for (int x = 0; x < 8; x++) {
                            for (int y = 0; y < 8; y++) {
                                currentBoardTemp[x][y] = z.currentBoard[x][y];
                            }
                        }
                        if (!mute) roll.start();
                        for (int x = 0; x < 8; x++) {
                            for (int y = 0; y < 8; y++) {
                                z.currentBoard[x][y] = z.nextMoves[row][column].currentBoard[x][y];
                            }
                        }

                        virtual_disable.performClick();
                        changeBoard("update", true);
                        liveScore(z);
                        if (delayThat) {
                            final char cho = choice;
                            final TextView disp = display;
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                public void run() {
                                    AITurn(revChoice, cho, disp);
                                    virtual_enable.performClick();
                                }
                            }, 2000);
                        } else {
                            AITurn(revChoice, choice, display);
                            virtual_enable.performClick();
                        }

                    }
                } else {
                    changeBoard("update", false);
                    showHints();
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
        MediaPlayer roll = MediaPlayer.create(this, R.raw.rollover);
        if (!finish) {
            display.setText("Your turn!");
//            changeBoard("update", false);
            if (move.possibleMoves(z, choice)) {
                if (!mute && delayThat) roll.start();
                endGame = 0;
                Board temp = move.outcomeminimax(z, depth, -10000, 10000, choice, revChoice, true);
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        currentBoardTemp[x][y] = z.currentBoard[x][y];
                    }
                }
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        z.currentBoard[x][y] = temp.currentBoard[x][y];
                    }
                }
                liveScore(z);
                playersTurn(revChoice, display, "R");

            } else {

                display.setText("CPU can't make a move!");
                endGame++;
                if (endGame >= 2 || Os + Xs == 64) {
                    calculateScore(z, choice, display);
                }
            }
        }
    }

    public void calculateScore(Board B, char choice, TextView display) {
        MediaPlayer win = MediaPlayer.create(this, R.raw.win);
        MediaPlayer lose = MediaPlayer.create(this, R.raw.lose);
        if (!finish) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (z.currentBoard[i][j] == 'X') Xnum++;
                    else if (z.currentBoard[i][j] == 'O') Onum++;
                }
            }
            if (Xnum > Onum) {
                if (choice == 'O') {
                    if (!mute) win.start();
                    display.setText("You Won! Score: " + Xnum + " - " + Onum);
                } else {
                    if (!mute) lose.start();
                    display.setText("You Lost! Score: " + Xnum + " - " + Onum);
                }
            } else if (Xnum < Onum) {
                if (choice == 'X') {
                    if (!mute) win.start();
                    display.setText("You Won! Score: " + Xnum + " - " + Onum);
                } else {
                    if (!mute) lose.start();
                    display.setText("You Lost! Score: " + Xnum + " - " + Onum);
                }
            } else {
                if (!mute) win.start();
                display.setText("Draw! Score: " + Xnum + " - " + Onum);
            }
            finish = true;
        }
    }

    private void liveScore(Board B) {
        Xs = 0;
        Os = 0;
        Animation bounce = AnimationUtils.loadAnimation(GameEngine.this, R.anim.bounce);
        TextView blackp = findViewById(R.id.black_points);
        TextView whitep = findViewById(R.id.white_points);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (z.currentBoard[i][j] == 'X') Xs++;
                else if (z.currentBoard[i][j] == 'O') Os++;
            }
        }
        blackp.setText(Xs + "");
        whitep.setText(Os + "");
        blackp.startAnimation(bounce);
        whitep.startAnimation(bounce);
    }

    private void showHints() {
        final ImageView b00 = findViewById(R.id.b00);
        final ImageView b01 = findViewById(R.id.b01);
        final ImageView b02 = findViewById(R.id.b02);
        final ImageView b03 = findViewById(R.id.b03);
        final ImageView b04 = findViewById(R.id.b04);
        final ImageView b05 = findViewById(R.id.b05);
        final ImageView b06 = findViewById(R.id.b06);
        final ImageView b07 = findViewById(R.id.b07);

        final ImageView b10 = findViewById(R.id.b10);
        final ImageView b11 = findViewById(R.id.b11);
        final ImageView b12 = findViewById(R.id.b12);
        final ImageView b13 = findViewById(R.id.b13);
        final ImageView b14 = findViewById(R.id.b14);
        final ImageView b15 = findViewById(R.id.b15);
        final ImageView b16 = findViewById(R.id.b16);
        final ImageView b17 = findViewById(R.id.b17);

        final ImageView b20 = findViewById(R.id.b20);
        final ImageView b21 = findViewById(R.id.b21);
        final ImageView b22 = findViewById(R.id.b22);
        final ImageView b23 = findViewById(R.id.b23);
        final ImageView b24 = findViewById(R.id.b24);
        final ImageView b25 = findViewById(R.id.b25);
        final ImageView b26 = findViewById(R.id.b26);
        final ImageView b27 = findViewById(R.id.b27);

        final ImageView b30 = findViewById(R.id.b30);
        final ImageView b31 = findViewById(R.id.b31);
        final ImageView b32 = findViewById(R.id.b32);
        final ImageView b33 = findViewById(R.id.b33);
        final ImageView b34 = findViewById(R.id.b34);
        final ImageView b35 = findViewById(R.id.b35);
        final ImageView b36 = findViewById(R.id.b36);
        final ImageView b37 = findViewById(R.id.b37);

        final ImageView b40 = findViewById(R.id.b40);
        final ImageView b41 = findViewById(R.id.b41);
        final ImageView b42 = findViewById(R.id.b42);
        final ImageView b43 = findViewById(R.id.b43);
        final ImageView b44 = findViewById(R.id.b44);
        final ImageView b45 = findViewById(R.id.b45);
        final ImageView b46 = findViewById(R.id.b46);
        final ImageView b47 = findViewById(R.id.b47);

        final ImageView b50 = findViewById(R.id.b50);
        final ImageView b51 = findViewById(R.id.b51);
        final ImageView b52 = findViewById(R.id.b52);
        final ImageView b53 = findViewById(R.id.b53);
        final ImageView b54 = findViewById(R.id.b54);
        final ImageView b55 = findViewById(R.id.b55);
        final ImageView b56 = findViewById(R.id.b56);
        final ImageView b57 = findViewById(R.id.b57);

        final ImageView b60 = findViewById(R.id.b60);
        final ImageView b61 = findViewById(R.id.b61);
        final ImageView b62 = findViewById(R.id.b62);
        final ImageView b63 = findViewById(R.id.b63);
        final ImageView b64 = findViewById(R.id.b64);
        final ImageView b65 = findViewById(R.id.b65);
        final ImageView b66 = findViewById(R.id.b66);
        final ImageView b67 = findViewById(R.id.b67);

        final ImageView b70 = findViewById(R.id.b70);
        final ImageView b71 = findViewById(R.id.b71);
        final ImageView b72 = findViewById(R.id.b72);
        final ImageView b73 = findViewById(R.id.b73);
        final ImageView b74 = findViewById(R.id.b74);
        final ImageView b75 = findViewById(R.id.b75);
        final ImageView b76 = findViewById(R.id.b76);
        final ImageView b77 = findViewById(R.id.b77);
        String position;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                position = i + "" + j;
                if (z.currentBoard[i][j] != 'O' && z.currentBoard[i][j] != 'X') {
                    if (z.Map[i][j] == 'Z' && hints) {
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

    public void changeBoard(String reason, boolean CPUsTurn) {
        boolean hintsWereOpen = false;
        final ImageView b00 = findViewById(R.id.b00);
        final ImageView b01 = findViewById(R.id.b01);
        final ImageView b02 = findViewById(R.id.b02);
        final ImageView b03 = findViewById(R.id.b03);
        final ImageView b04 = findViewById(R.id.b04);
        final ImageView b05 = findViewById(R.id.b05);
        final ImageView b06 = findViewById(R.id.b06);
        final ImageView b07 = findViewById(R.id.b07);

        final ImageView b10 = findViewById(R.id.b10);
        final ImageView b11 = findViewById(R.id.b11);
        final ImageView b12 = findViewById(R.id.b12);
        final ImageView b13 = findViewById(R.id.b13);
        final ImageView b14 = findViewById(R.id.b14);
        final ImageView b15 = findViewById(R.id.b15);
        final ImageView b16 = findViewById(R.id.b16);
        final ImageView b17 = findViewById(R.id.b17);

        final ImageView b20 = findViewById(R.id.b20);
        final ImageView b21 = findViewById(R.id.b21);
        final ImageView b22 = findViewById(R.id.b22);
        final ImageView b23 = findViewById(R.id.b23);
        final ImageView b24 = findViewById(R.id.b24);
        final ImageView b25 = findViewById(R.id.b25);
        final ImageView b26 = findViewById(R.id.b26);
        final ImageView b27 = findViewById(R.id.b27);

        final ImageView b30 = findViewById(R.id.b30);
        final ImageView b31 = findViewById(R.id.b31);
        final ImageView b32 = findViewById(R.id.b32);
        final ImageView b33 = findViewById(R.id.b33);
        final ImageView b34 = findViewById(R.id.b34);
        final ImageView b35 = findViewById(R.id.b35);
        final ImageView b36 = findViewById(R.id.b36);
        final ImageView b37 = findViewById(R.id.b37);

        final ImageView b40 = findViewById(R.id.b40);
        final ImageView b41 = findViewById(R.id.b41);
        final ImageView b42 = findViewById(R.id.b42);
        final ImageView b43 = findViewById(R.id.b43);
        final ImageView b44 = findViewById(R.id.b44);
        final ImageView b45 = findViewById(R.id.b45);
        final ImageView b46 = findViewById(R.id.b46);
        final ImageView b47 = findViewById(R.id.b47);

        final ImageView b50 = findViewById(R.id.b50);
        final ImageView b51 = findViewById(R.id.b51);
        final ImageView b52 = findViewById(R.id.b52);
        final ImageView b53 = findViewById(R.id.b53);
        final ImageView b54 = findViewById(R.id.b54);
        final ImageView b55 = findViewById(R.id.b55);
        final ImageView b56 = findViewById(R.id.b56);
        final ImageView b57 = findViewById(R.id.b57);

        final ImageView b60 = findViewById(R.id.b60);
        final ImageView b61 = findViewById(R.id.b61);
        final ImageView b62 = findViewById(R.id.b62);
        final ImageView b63 = findViewById(R.id.b63);
        final ImageView b64 = findViewById(R.id.b64);
        final ImageView b65 = findViewById(R.id.b65);
        final ImageView b66 = findViewById(R.id.b66);
        final ImageView b67 = findViewById(R.id.b67);

        final ImageView b70 = findViewById(R.id.b70);
        final ImageView b71 = findViewById(R.id.b71);
        final ImageView b72 = findViewById(R.id.b72);
        final ImageView b73 = findViewById(R.id.b73);
        final ImageView b74 = findViewById(R.id.b74);
        final ImageView b75 = findViewById(R.id.b75);
        final ImageView b76 = findViewById(R.id.b76);
        final ImageView b77 = findViewById(R.id.b77);
        String position = "";
        if (c == 1) {
            blink = AnimationUtils.loadAnimation(GameEngine.this, R.anim.bounce);
        } else if (c == 2) {
            blink = AnimationUtils.loadAnimation(GameEngine.this, R.anim.zoomin);
        } else if (c == 3) {
            blink = AnimationUtils.loadAnimation(GameEngine.this, R.anim.flip);
        } else if (c == 4) {
            blink = AnimationUtils.loadAnimation(GameEngine.this, R.anim.lefttoright);
        } else {
            blink = AnimationUtils.loadAnimation(GameEngine.this, R.anim.blink_anim);
        }
        if (CPUsTurn) {
            if (hints) {
                hints = false;
                hintsWereOpen = true;
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                position = i + "" + j;
                if (reason.equals("update")) {
                    if (z.currentBoard[i][j] == 'O') {
                        if (position.equals("00")) {
                            b00.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b00.startAnimation(blink);
                        } else if (position.equals("01")) {
                            b01.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b01.startAnimation(blink);
                        } else if (position.equals("02")) {
                            b02.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b02.startAnimation(blink);
                        } else if (position.equals("03")) {
                            b03.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b03.startAnimation(blink);
                        } else if (position.equals("04")) {
                            b04.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b04.startAnimation(blink);
                        } else if (position.equals("05")) {
                            b05.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b05.startAnimation(blink);
                        } else if (position.equals("06")) {
                            b06.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b06.startAnimation(blink);
                        } else if (position.equals("07")) {
                            b07.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b07.startAnimation(blink);
                        } else if (position.equals("10")) {
                            b10.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b10.startAnimation(blink);
                        } else if (position.equals("11")) {
                            b11.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b11.startAnimation(blink);
                        } else if (position.equals("12")) {
                            b12.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b12.startAnimation(blink);
                        } else if (position.equals("13")) {
                            b13.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b13.startAnimation(blink);
                        } else if (position.equals("14")) {
                            b14.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b14.startAnimation(blink);
                        } else if (position.equals("15")) {
                            b15.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b15.startAnimation(blink);
                        } else if (position.equals("16")) {
                            b16.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b16.startAnimation(blink);
                        } else if (position.equals("17")) {
                            b17.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b17.startAnimation(blink);
                        } else if (position.equals("20")) {
                            b20.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b20.startAnimation(blink);
                        } else if (position.equals("21")) {
                            b21.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b21.startAnimation(blink);
                        } else if (position.equals("22")) {
                            b22.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b22.startAnimation(blink);
                        } else if (position.equals("23")) {
                            b23.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b23.startAnimation(blink);
                        } else if (position.equals("24")) {
                            b24.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b24.startAnimation(blink);
                        } else if (position.equals("25")) {
                            b25.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b25.startAnimation(blink);
                        } else if (position.equals("26")) {
                            b26.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b26.startAnimation(blink);
                        } else if (position.equals("27")) {
                            b27.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b27.startAnimation(blink);
                        } else if (position.equals("30")) {
                            b30.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b30.startAnimation(blink);
                        } else if (position.equals("31")) {
                            b31.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b31.startAnimation(blink);
                        } else if (position.equals("32")) {
                            b32.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b32.startAnimation(blink);
                        } else if (position.equals("33")) {
                            b33.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b33.startAnimation(blink);
                        } else if (position.equals("34")) {
                            b34.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b34.startAnimation(blink);
                        } else if (position.equals("35")) {
                            b35.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b35.startAnimation(blink);
                        } else if (position.equals("36")) {
                            b36.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b36.startAnimation(blink);
                        } else if (position.equals("37")) {
                            b37.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b37.startAnimation(blink);
                        } else if (position.equals("40")) {
                            b40.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b40.startAnimation(blink);
                        } else if (position.equals("41")) {
                            b41.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b41.startAnimation(blink);
                        } else if (position.equals("42")) {
                            b42.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b42.startAnimation(blink);
                        } else if (position.equals("43")) {
                            b43.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b43.startAnimation(blink);
                        } else if (position.equals("44")) {
                            b44.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b44.startAnimation(blink);
                        } else if (position.equals("45")) {
                            b45.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b45.startAnimation(blink);
                        } else if (position.equals("46")) {
                            b46.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b46.startAnimation(blink);
                        } else if (position.equals("47")) {
                            b47.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b47.startAnimation(blink);
                        } else if (position.equals("50")) {
                            b50.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b50.startAnimation(blink);
                        } else if (position.equals("51")) {
                            b51.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b51.startAnimation(blink);
                        } else if (position.equals("52")) {
                            b52.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b52.startAnimation(blink);
                        } else if (position.equals("53")) {
                            b53.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b53.startAnimation(blink);
                        } else if (position.equals("54")) {
                            b54.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b54.startAnimation(blink);
                        } else if (position.equals("55")) {
                            b55.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b55.startAnimation(blink);
                        } else if (position.equals("56")) {
                            b56.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b56.startAnimation(blink);
                        } else if (position.equals("57")) {
                            b57.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b57.startAnimation(blink);
                        } else if (position.equals("60")) {
                            b60.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b60.startAnimation(blink);
                        } else if (position.equals("61")) {
                            b61.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b61.startAnimation(blink);
                        } else if (position.equals("62")) {
                            b62.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b62.startAnimation(blink);
                        } else if (position.equals("63")) {
                            b63.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b63.startAnimation(blink);
                        } else if (position.equals("64")) {
                            b64.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b64.startAnimation(blink);
                        } else if (position.equals("65")) {
                            b65.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b65.startAnimation(blink);
                        } else if (position.equals("66")) {
                            b66.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b66.startAnimation(blink);
                        } else if (position.equals("67")) {
                            b67.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b67.startAnimation(blink);
                        } else if (position.equals("70")) {
                            b70.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b70.startAnimation(blink);
                        } else if (position.equals("71")) {
                            b71.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b71.startAnimation(blink);
                        } else if (position.equals("72")) {
                            b72.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b72.startAnimation(blink);
                        } else if (position.equals("73")) {
                            b73.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b73.startAnimation(blink);
                        } else if (position.equals("74")) {
                            b74.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b74.startAnimation(blink);
                        } else if (position.equals("75")) {
                            b75.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b75.startAnimation(blink);
                        } else if (position.equals("76")) {
                            b76.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b76.startAnimation(blink);
                        } else if (position.equals("77")) {
                            b77.setImageResource(R.drawable.white_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b77.startAnimation(blink);
                        }
                    } else if (z.currentBoard[i][j] == 'X') {
                        if (position.equals("00")) {
                            b00.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b00.startAnimation(blink);
                        } else if (position.equals("01")) {
                            b01.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b01.startAnimation(blink);
                        } else if (position.equals("02")) {
                            b02.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b02.startAnimation(blink);
                        } else if (position.equals("03")) {
                            b03.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b03.startAnimation(blink);
                        } else if (position.equals("04")) {
                            b04.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b04.startAnimation(blink);
                        } else if (position.equals("05")) {
                            b05.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b05.startAnimation(blink);
                        } else if (position.equals("06")) {
                            b06.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b06.startAnimation(blink);
                        } else if (position.equals("07")) {
                            b07.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b07.startAnimation(blink);
                        } else if (position.equals("10")) {
                            b10.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b10.startAnimation(blink);
                        } else if (position.equals("11")) {
                            b11.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b11.startAnimation(blink);
                        } else if (position.equals("12")) {
                            b12.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b12.startAnimation(blink);
                        } else if (position.equals("13")) {
                            b13.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b13.startAnimation(blink);
                        } else if (position.equals("14")) {
                            b14.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b14.startAnimation(blink);
                        } else if (position.equals("15")) {
                            b15.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b15.startAnimation(blink);
                        } else if (position.equals("16")) {
                            b16.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b16.startAnimation(blink);
                        } else if (position.equals("17")) {
                            b17.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b17.startAnimation(blink);
                        } else if (position.equals("20")) {
                            b20.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b20.startAnimation(blink);
                        } else if (position.equals("21")) {
                            b21.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b21.startAnimation(blink);
                        } else if (position.equals("22")) {
                            b22.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b22.startAnimation(blink);
                        } else if (position.equals("23")) {
                            b23.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b23.startAnimation(blink);
                        } else if (position.equals("24")) {
                            b24.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b24.startAnimation(blink);
                        } else if (position.equals("25")) {
                            b25.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b25.startAnimation(blink);
                        } else if (position.equals("26")) {
                            b26.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b26.startAnimation(blink);
                        } else if (position.equals("27")) {
                            b27.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b27.startAnimation(blink);
                        } else if (position.equals("30")) {
                            b30.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b30.startAnimation(blink);
                        } else if (position.equals("31")) {
                            b31.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b31.startAnimation(blink);
                        } else if (position.equals("32")) {
                            b32.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b32.startAnimation(blink);
                        } else if (position.equals("33")) {
                            b33.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b33.startAnimation(blink);
                        } else if (position.equals("34")) {
                            b34.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b34.startAnimation(blink);
                        } else if (position.equals("35")) {
                            b35.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b35.startAnimation(blink);
                        } else if (position.equals("36")) {
                            b36.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b36.startAnimation(blink);
                        } else if (position.equals("37")) {
                            b37.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b37.startAnimation(blink);
                        } else if (position.equals("40")) {
                            b40.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b40.startAnimation(blink);
                        } else if (position.equals("41")) {
                            b41.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b41.startAnimation(blink);
                        } else if (position.equals("42")) {
                            b42.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b42.startAnimation(blink);
                        } else if (position.equals("43")) {
                            b43.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b43.startAnimation(blink);
                        } else if (position.equals("44")) {
                            b44.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b44.startAnimation(blink);
                        } else if (position.equals("45")) {
                            b45.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b45.startAnimation(blink);
                        } else if (position.equals("46")) {
                            b46.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b46.startAnimation(blink);
                        } else if (position.equals("47")) {
                            b47.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b47.startAnimation(blink);
                        } else if (position.equals("50")) {
                            b50.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b50.startAnimation(blink);
                        } else if (position.equals("51")) {
                            b51.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b51.startAnimation(blink);
                        } else if (position.equals("52")) {
                            b52.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b52.startAnimation(blink);
                        } else if (position.equals("53")) {
                            b53.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b53.startAnimation(blink);
                        } else if (position.equals("54")) {
                            b54.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b54.startAnimation(blink);
                        } else if (position.equals("55")) {
                            b55.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b55.startAnimation(blink);
                        } else if (position.equals("56")) {
                            b56.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b56.startAnimation(blink);
                        } else if (position.equals("57")) {
                            b57.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b57.startAnimation(blink);
                        } else if (position.equals("60")) {
                            b60.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b60.startAnimation(blink);
                        } else if (position.equals("61")) {
                            b61.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b61.startAnimation(blink);
                        } else if (position.equals("62")) {
                            b62.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b62.startAnimation(blink);
                        } else if (position.equals("63")) {
                            b63.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b63.startAnimation(blink);
                        } else if (position.equals("64")) {
                            b64.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b64.startAnimation(blink);
                        } else if (position.equals("65")) {
                            b65.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b65.startAnimation(blink);
                        } else if (position.equals("66")) {
                            b66.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b66.startAnimation(blink);
                        } else if (position.equals("67")) {
                            b67.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b67.startAnimation(blink);
                        } else if (position.equals("70")) {
                            b70.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b70.startAnimation(blink);
                        } else if (position.equals("71")) {
                            b71.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b71.startAnimation(blink);
                        } else if (position.equals("72")) {
                            b72.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b72.startAnimation(blink);
                        } else if (position.equals("73")) {
                            b73.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b73.startAnimation(blink);
                        } else if (position.equals("74")) {
                            b74.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b74.startAnimation(blink);
                        } else if (position.equals("75")) {
                            b75.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b75.startAnimation(blink);
                        } else if (position.equals("76")) {
                            b76.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b76.startAnimation(blink);
                        } else if (position.equals("77")) {
                            b77.setImageResource(R.drawable.black_shadow);
                            if (currentBoardTemp[i][j] != z.currentBoard[i][j])
                                b77.startAnimation(blink);
                        }
                    }
                } else if (reason.equals("reset")) {
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
                        b33.setImageResource(R.drawable.white_shadow);
                    } else if (position.equals("34")) {
                        b34.setImageResource(R.drawable.black_shadow);
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
                        b43.setImageResource(R.drawable.black_shadow);
                    } else if (position.equals("44")) {
                        b44.setImageResource(R.drawable.white_shadow);
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
        showHints();
        if (hintsWereOpen) {
            hints = true;
        }
    }
}
