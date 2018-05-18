package tictactoe;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class TicTacToe extends JFrame implements ActionListener {

    private Container c;
    private GridLayout gridLayout;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, resetButton, clearButton, ManVSComputer;
    private boolean btnRepeated1 = true, btnRepeated2 = true, btnRepeated3 = true, btnRepeated4 = true, btnRepeated5 = true, btnRepeated6 = true, btnRepeated7 = true, btnRepeated8 = true, btnRepeated9 = true;
    private boolean X = true, O;
    private JPanel panel;
    private JLabel playerTextJlabel, playerX, playerO, draw;
    private ImageIcon imgo, imgx;
    private int count = 0, pX, pO, Drw;
    private char[] square = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}; ///Main Grid...
    private Font font = new Font("Arial", Font.BOLD, 13);
    
    ///For Frame Icon
    
    private ImageIcon icon = new ImageIcon(getClass().getResource("/Images/iconFrame.png"));

    TicTacToe() {
        makeMainFrame();
        createPanel();
        createImageObject();
        createJlabel();
        setLayoutIntoPanel();
        createButton();
        changeAllColor();
        changeFont();
        setButtonIntoPanel();
        setButtonIntoFrame();
        setAllButtonActionListener();

        ///We declear this method at First.Becasue begging of the game Turn of X Player...
        showTurnOfPlayer(); ///For PlayerTextField 
        showScoreBoard();

    }

    ///Main Frame
    public void makeMainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(350, 50, 500, 510);
        this.setResizable(false);
        this.setTitle("Tic Tac Toe  [Man VS Man]");
        this.setIconImage(icon.getImage());
        c = this.getContentPane();
        c.setLayout(null);
    }

    ///Creating panel.
    public void createPanel() {
        panel = new JPanel();
        panel.setBounds(0, 1, 499, 400);
        panel.setBackground(Color.yellow);
        //panel.setBackground(Color.red);
        c.add(panel);
    }

    ///Create grid obj and adding this Obj into the Panel
    public void setLayoutIntoPanel() {
        gridLayout = new GridLayout(3, 3);
        gridLayout.setHgap(8);
        gridLayout.setVgap(8);
        panel.setLayout(gridLayout);
    }

    ///Create all Button 
    public void createButton() {
        btn1 = new JButton();
        btn2 = new JButton();
        btn3 = new JButton();
        btn4 = new JButton();
        btn5 = new JButton();
        btn6 = new JButton();
        btn7 = new JButton();
        btn8 = new JButton();
        btn9 = new JButton();

        clearButton = new JButton("Clear");
        clearButton.setBounds(400, 410, 80, 30);

        resetButton = new JButton("Reset");
        resetButton.setBounds(400, 445, 80, 30);

        ManVSComputer = new JButton("Man VS Computer");
        ManVSComputer.setBounds(15, 445, 150, 30);
    }

    ///Changing Button Color 
    public void changeAllColor() {
        ///Frame color
        c.setBackground(Color.YELLOW);
        ///Panel Color
        panel.setBackground(Color.yellow);
        ///Button Color
        btn1.setBackground(Color.ORANGE);
        btn2.setBackground(Color.ORANGE);
        btn3.setBackground(Color.ORANGE);
        btn4.setBackground(Color.ORANGE);
        btn5.setBackground(Color.ORANGE);
        btn6.setBackground(Color.ORANGE);
        btn7.setBackground(Color.ORANGE);
        btn8.setBackground(Color.ORANGE);
        btn9.setBackground(Color.ORANGE);

        resetButton.setBackground(Color.yellow);
        clearButton.setBackground(Color.yellow);
        ManVSComputer.setBackground(Color.yellow);

    }

    ///Changing Font 
    public void changeFont() {
        ///Button
        resetButton.setFont(font);
        clearButton.setFont(font);
        ManVSComputer.setFont(font);

        ///JLabel
        playerTextJlabel.setFont(font);
        playerX.setFont(font);
        playerO.setFont(font);
        draw.setFont(font);
    }
    ///Adding Button into the GridLayout

    public void setButtonIntoPanel() {
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(btn5);
        panel.add(btn6);
        panel.add(btn7);
        panel.add(btn8);
        panel.add(btn9);
    }
    ///Adding panel into the Main Frame

    public void setButtonIntoFrame() {
        c.add(resetButton);///add Main frame
        c.add(clearButton);
        c.add(ManVSComputer);
    }

    ///Set all Button Action Listener.
    public void setAllButtonActionListener() {
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        clearButton.addActionListener(this);
        resetButton.addActionListener(this);
        ManVSComputer.addActionListener(this);
    }

    public void createJlabel() {
        playerTextJlabel = new JLabel();
        playerTextJlabel.setBounds(25, 410, 120, 30);
        c.add(playerTextJlabel);
        playerX = new JLabel("Player X : ");
        playerX.setBounds(200, 423, 90, 20);
        c.add(playerX);
        playerO = new JLabel("Player O : ");
        playerO.setBounds(200, 445, 90, 20);
        c.add(playerO);
        draw = new JLabel("Draw : ");
        draw.setBounds(290, 434, 90, 20);
        c.add(draw);
    }

    ///Create All image Object
    public void createImageObject() {
        imgo = new ImageIcon(getClass().getResource("/Images/o.png"));
        imgx = new ImageIcon(getClass().getResource("/Images/x.png"));
    }

    public void showTurnOfPlayer() {
        if (X == true) {
            playerTextJlabel.setText("Turn of Player : X");
        } else {
            playerTextJlabel.setText("Turn of Player : O");
        }
    }

    public void showScoreBoard() {

        playerX.setText("Player X : " + String.valueOf(pX));
        playerO.setText("Player O : " + String.valueOf(pO));
        draw.setText("Draw : " + String.valueOf(Drw));
    }

    ///Action Listener for All  Buttons.
    @Override
    public void actionPerformed(ActionEvent e) {
        ///Button 1
        if (e.getSource() == btn1) {
            if (btnRepeated1 == true) {///Checking Repeated Clicked.
                System.out.println("It's Button 1.");
                btnRepeated1 = false;
                ///Player Moving..
                if (X == true) {
                    btn1.setIcon(imgx);
                    X = false;
                    showTurnOfPlayer();
                    square[1] = 'X';
                    HandleWin(CheckWin('X'), 'X');
                    CheckSquare();///Use for testing 

                } else {

                    btn1.setIcon(imgo);
                    X = true;
                    showTurnOfPlayer();
                    square[1] = 'O';
                    HandleWin(CheckWin('O'), 'O');

                    CheckSquare();///Use for testing     
                }
            }
        } ///Button 2
        else if (e.getSource() == btn2) {
            if (btnRepeated2 == true) {
                System.out.println("It's Button 2.");
                btnRepeated2 = false;
                if (X == true) {

                    btn2.setIcon(imgx);
                    X = false;
                    showTurnOfPlayer();
                    square[2] = 'X';
                    HandleWin(CheckWin('X'), 'X');
                    CheckSquare();

                } else {

                    btn2.setIcon(imgo);
                    X = true;
                    showTurnOfPlayer();
                    square[2] = 'O';
                    HandleWin(CheckWin('O'), 'O');
                    CheckSquare();

                }
            }

        } ///Button 3
        else if (e.getSource() == btn3) {
            if (btnRepeated3 == true) {
                System.out.println("It's Button 3.");
                btnRepeated3 = false;
                if (X == true) {

                    btn3.setIcon(imgx);
                    X = false;
                    showTurnOfPlayer();
                    square[3] = 'X';
                    HandleWin(CheckWin('X'), 'X');
                    CheckSquare();
                } else {

                    btn3.setIcon(imgo);
                    X = true;
                    showTurnOfPlayer();
                    square[3] = 'O';
                    HandleWin(CheckWin('O'), 'O');
                    CheckSquare();
                }
            }
        } ///Button 4
        else if (e.getSource() == btn4) {
            if (btnRepeated4 == true) {
                System.out.println("It's Button 4.");
                btnRepeated4 = false;
                if (X == true) {
                    btn4.setIcon(imgx);
                    X = false;
                    showTurnOfPlayer();
                    square[4] = 'X';
                    HandleWin(CheckWin('X'), 'X');
                    CheckSquare();
                } else {
                    btn4.setIcon(imgo);
                    X = true;
                    showTurnOfPlayer();
                    square[4] = 'O';
                    HandleWin(CheckWin('O'), 'O');
                    CheckSquare();

                }
            }
        } ///Button 5
        else if (e.getSource() == btn5) {
            if (btnRepeated5 == true) {
                System.out.println("It's Button 5.");
                btnRepeated5 = false;
                if (X == true) {
                    btn5.setIcon(imgx);
                    X = false;
                    showTurnOfPlayer();
                    square[5] = 'X';
                    HandleWin(CheckWin('X'), 'X');
                    CheckSquare();

                } else {
                    btn5.setIcon(imgo);
                    X = true;
                    showTurnOfPlayer();
                    square[5] = 'O';
                    HandleWin(CheckWin('O'), 'O');
                    CheckSquare();

                }
            }
        } ///Button 6
        else if (e.getSource() == btn6) {
            if (btnRepeated6 == true) {
                System.out.println("It's Button 6.");
                btnRepeated6 = false;
                if (X == true) {
                    btn6.setIcon(imgx);
                    X = false;
                    showTurnOfPlayer();
                    square[6] = 'X';
                    HandleWin(CheckWin('X'), 'X');
                    CheckSquare();

                } else {

                    btn6.setIcon(imgo);
                    X = true;
                    showTurnOfPlayer();
                    square[6] = 'O';
                    HandleWin(CheckWin('O'), 'O');
                    CheckSquare();

                }
            }
        } ///Button 7
        else if (e.getSource() == btn7) {
            if (btnRepeated7 == true) {
                System.out.println("It's Button 7.");
                btnRepeated7 = false;
                if (X == true) {

                    btn7.setIcon(imgx);
                    X = false;
                    showTurnOfPlayer();
                    square[7] = 'X';
                    HandleWin(CheckWin('X'), 'X');
                    CheckSquare();

                } else {

                    btn7.setIcon(imgo);
                    X = true;
                    showTurnOfPlayer();
                    square[7] = 'O';
                    HandleWin(CheckWin('O'), 'O');
                    CheckSquare();

                }
            }
        } ///Button 8
        else if (e.getSource() == btn8) {
            if (btnRepeated8 == true) {
                System.out.println("It's Button 8.");
                btnRepeated8 = false;
                if (X == true) {

                    btn8.setIcon(imgx);
                    X = false;
                    showTurnOfPlayer(); ///this method  declear under boolean X .Becaue X false means X player turn already gone then we want to show the next Player turn.
                    square[8] = 'X';
                    HandleWin(CheckWin('X'), 'X');
                    CheckSquare();

                } else {

                    btn8.setIcon(imgo);
                    X = true;
                    showTurnOfPlayer();///this method  declear under boolean O .Becaue O false means O player turn already gone then we want to show the next Player turn.
                    square[8] = 'O';
                    HandleWin(CheckWin('O'), 'O');
                    CheckSquare();

                }
            }
        } ///Button 9
        else if (e.getSource() == btn9) {
            if (btnRepeated9 == true) {
                System.out.println("It's Button 9.");
                btnRepeated9 = false;
                if (X == true) {

                    btn9.setIcon(imgx);
                    X = false;
                    showTurnOfPlayer();
                    square[9] = 'X';
                    HandleWin(CheckWin('X'), 'X');
                    CheckSquare();

                } else {

                    btn9.setIcon(imgo);
                    X = true;
                    showTurnOfPlayer();
                    square[9] = 'O';
                    HandleWin(CheckWin('O'), 'O');
                    CheckSquare();

                }
            }
        } else if (e.getSource() == clearButton) {
            clearMatch();
        } ///Game is Reset
        else if (e.getSource() == resetButton) {
            resetMatch();
        } else if (e.getSource() == ManVSComputer) {
            this.dispose();
            TicTacToeAI tttAI = new TicTacToeAI();
            tttAI.setVisible(true);
        }
    }

    ///Game Program
    ///Checking all situation to findout the win player . If any player is win then return this method -1.Otherwise return 1.
    ///We use count variable for Calculate Match draw situation.. If count value is 9 then return  Match is draw.
    public int CheckWin(char check) {
        count++;
        if (check == square[1] && check == square[2] && check == square[3]) {
            return -1;
        } else if (check == square[1] && check == square[4] && check == square[7]) {
            return -1;
        } else if (check == square[1] && check == square[5] && check == square[9]) {
            return -1;
        } ///Base 2
        else if (check == square[2] && check == square[5] && check == square[8]) {
            return -1;
        } ///Base 3
        else if (check == square[3] && check == square[6] && check == square[9]) {
            return -1;
        } else if (check == square[3] && check == square[5] && check == square[7]) {
            return -1;
        } ///Base 4
        else if (check == square[4] && check == square[5] && check == square[6]) {
            return -1;
        } //Base 7
        else if (check == square[7] && check == square[8] && check == square[9]) {
            return -1;
        } else {
            return 1;
        }
    }

    ///This method get CheckWin return value And then Calculate Draw Match or Win 
    public void HandleWin(int returnValue, char player) {
        if (returnValue == -1) {
            JOptionPane.showMessageDialog(null, player + "   Player Win ! ! !", "Match Result", JOptionPane.INFORMATION_MESSAGE);
            if (player == 'X') {
                pX++;
                showScoreBoard();

            } else if (player == 'O') {
                pO++;
                showScoreBoard();

            }
            clearMatch();
        } else if (count == 9) {
            JOptionPane.showMessageDialog(null, "         Match Draw");
            Drw++;
            showScoreBoard();

            clearMatch();
        }
    }

    ///Reset Match
    public void clearMatch() {
        count = 0;
        btn1.setIcon(null);
        btn2.setIcon(null);
        btn3.setIcon(null);
        btn4.setIcon(null);
        btn5.setIcon(null);
        btn6.setIcon(null);
        btn7.setIcon(null);
        btn8.setIcon(null);
        btn9.setIcon(null);
        btnRepeated1 = true;
        btnRepeated2 = true;
        btnRepeated3 = true;
        btnRepeated4 = true;
        btnRepeated5 = true;
        btnRepeated6 = true;
        btnRepeated7 = true;
        btnRepeated8 = true;
        btnRepeated9 = true;
        X = true;
        square[1] = '1';
        square[2] = '2';
        square[3] = '3';
        square[4] = '4';
        square[5] = '5';
        square[6] = '6';
        square[7] = '7';
        square[8] = '8';
        square[9] = '9';
        showTurnOfPlayer();
        CheckSquare();///Only for testing Purpose....not Inclue our game. 
    }

    public void resetMatch() {
        clearMatch();
        pX = 0;
        pO = 0;
        Drw = 0;

        showScoreBoard();
    }

    ///Not use this method , Only for testing...
    public void CheckSquare() {
        System.out.println(square);
        System.out.println(count);
    }
}
