package tictactoe;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class TicTacToeAI extends JFrame implements ActionListener {

    private Container c;
    private GridLayout gridLayout;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, resetButton, clearButton, ManVSMan;
    private JPanel panel;
    private JLabel playerTextJlabel, playerX, playerO, draw;
    private ImageIcon imgo, imgx;
    private int count = 0, pX, pO, Drw;
    private char[] square = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};  ///Main Grid...
    ///this variable use for Human player.
    private boolean btnRepeated1 = false, btnRepeated2 = false, btnRepeated3 = false, btnRepeated4 = false, btnRepeated5 = false, btnRepeated6 = false, btnRepeated7 = false, btnRepeated8 = false, btnRepeated9 = false;
    private boolean X = true, O, playeMoveX = true, playerMoveO = false;
    private Font font = new Font("Arial", Font.BOLD, 13);

    ///For Frame Icon
    private ImageIcon icon = new ImageIcon(getClass().getResource("/Images/iconFrame.png"));

    ///this variable for Computer player(AI).
    private boolean WiningBool = false, WiningXBool = false, checkBool = false, cXwin = false, nextCheck = true, next2Check = false, next3Check = false, next4Check = false;

    TicTacToeAI() {
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
        //  showTurnOfPlayer(); ///For PlayerTextField
        showScoreBoard();
        //scoreFileWriteAndClose();
    }

    ///Main Frame
    public void makeMainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(350, 50, 500, 510);
        this.setResizable(false);
        this.setTitle("Tic Tac Toe  [Man VS Computer]");
        this.setIconImage(icon.getImage());
        c = this.getContentPane();
        c.setLayout(null);

    }

    ///Creating panel.
    public void createPanel() {
        panel = new JPanel();
        panel.setBounds(0, 1, 499, 400);
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
        ManVSMan = new JButton("Man VS Man");
        ManVSMan.setBounds(20, 430, 120, 30);

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
        ManVSMan.setBackground(Color.yellow);

    }
    ///Changing Font 

    public void changeFont() {
        ///Button
        resetButton.setFont(font);
        clearButton.setFont(font);
        ManVSMan.setFont(font);

        ///JLabel
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
        c.add(ManVSMan);
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
        ManVSMan.addActionListener(this);
    }

    public void createJlabel() {
//        playerTextJlabel = new JLabel();
//        playerTextJlabel.setBounds(20, 420, 120, 30);
//        c.add(playerTextJlabel);
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
            if (playeMoveX == true && btnRepeated1 == false) {///this statement use for move player and also fixed auto computer turn after Match draw.For all buttons apply this tricks.
                btnRepeated1 = true;
                square[1] = 'X';
                btn1.setIcon(imgx);
                playerMoveO = true;
                HandleWin(CheckWin('X'), 'X');
            }
            if (playerMoveO == true) {
                playerMoveO = false;
                computer();
                resetComputer();
            }
        } ///Button 2
        else if (e.getSource() == btn2) {
            if (playeMoveX == true && btnRepeated2 == false) {
                btnRepeated2 = true;
                square[2] = 'X';
                btn2.setIcon(imgx);
                playerMoveO = true;
                HandleWin(CheckWin('X'), 'X');
            }
            if (playerMoveO == true) {
                playerMoveO = false;
                computer();
                resetComputer();
            }
        } ///Button 3
        else if (e.getSource() == btn3) {
            if (playeMoveX == true && btnRepeated3 == false) {
                btnRepeated3 = true;
                square[3] = 'X';
                btn3.setIcon(imgx);
                playerMoveO = true;
                HandleWin(CheckWin('X'), 'X');
            }
            if (playerMoveO == true) {
                playerMoveO = false;
                computer();
                resetComputer();
            }
        }///Button 4
        else if (e.getSource() == btn4) {
            if (playeMoveX == true && btnRepeated4 == false) {
                btnRepeated4 = true;
                square[4] = 'X';
                btn4.setIcon(imgx);
                playerMoveO = true;
                HandleWin(CheckWin('X'), 'X');
            }
            if (playerMoveO == true) {
                playerMoveO = false;
                computer();
                resetComputer();
            }

        } ///Button 5
        else if (e.getSource() == btn5) {
            if (playeMoveX == true && btnRepeated5 == false) {
                btnRepeated5 = true;
                square[5] = 'X';
                btn5.setIcon(imgx);
                playerMoveO = true;
                HandleWin(CheckWin('X'), 'X');
            }
            if (playerMoveO == true) {
                playerMoveO = false;
                computer();
                resetComputer();
            }

        } ///Button 6
        else if (e.getSource() == btn6) {
            if (playeMoveX == true && btnRepeated6 == false) {
                btnRepeated6 = true;
                square[6] = 'X';
                btn6.setIcon(imgx);
                playerMoveO = true;
                HandleWin(CheckWin('X'), 'X');
            }
            if (playerMoveO == true) {
                playerMoveO = false;
                computer();
                resetComputer();
            }

        } ///Button 7
        else if (e.getSource() == btn7) {
            if (playeMoveX == true && btnRepeated7 == false) {
                btnRepeated7 = true;
                square[7] = 'X';
                btn7.setIcon(imgx);
                playerMoveO = true;
                HandleWin(CheckWin('X'), 'X');
            }
            if (playerMoveO == true) {
                playerMoveO = false;
                computer();
                resetComputer();
            }

        } ///Button 8
        else if (e.getSource() == btn8) {
            if (playeMoveX == true && btnRepeated8 == false) {
                btnRepeated8 = true;
                square[8] = 'X';
                btn8.setIcon(imgx);
                playerMoveO = true;
                HandleWin(CheckWin('X'), 'X');
            }
            if (playerMoveO == true) {
                playerMoveO = false;
                computer();
                resetComputer();
            }

        } ///Button 9
        else if (e.getSource() == btn9) {
            if (playeMoveX == true && btnRepeated9 == false) {
                btnRepeated9 = true;
                square[9] = 'X';
                btn9.setIcon(imgx);
                playerMoveO = true;
                HandleWin(CheckWin('X'), 'X');
            }
            if (playerMoveO == true) {
                playerMoveO = false;
                computer();
                resetComputer();
            }
        } else if (e.getSource() == clearButton) {
            clearMatch();
        } ///Game is Reset
        else if (e.getSource() == resetButton) {

            resetMatch();
        } ///ManVSMan Button ..For Change game mode..
        else if (e.getSource() == ManVSMan) {
            this.dispose();
            TicTacToe tttNormal = new TicTacToe();
            tttNormal.setVisible(true);
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

            if (player == 'X') {
                pX++;
                showScoreBoard();
            } else if (player == 'O') {
                pO++;
                showScoreBoard();
            }
            if (player == 'O') {
                JOptionPane.showMessageDialog(null, "            You Lose ! ! !", "Match Result", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "            You Win ! ! !", "Match Result", JOptionPane.INFORMATION_MESSAGE);
            }
            clearMatch();
            resetComputer();
        } else if (count == 9) {
            JOptionPane.showMessageDialog(null, "Match Draw !", "Match Result", JOptionPane.INFORMATION_MESSAGE);
            Drw++;
            showScoreBoard();
            clearMatch();
            resetComputer();
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
        btnRepeated1 = false;
        btnRepeated2 = false;
        btnRepeated3 = false;
        btnRepeated4 = false;
        btnRepeated5 = false;
        btnRepeated6 = false;
        btnRepeated7 = false;
        btnRepeated8 = false;
        btnRepeated9 = false;
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

        CheckSquare();///Only for testing Purpose....not Inclue our game.
        //resetComputer();
    }

    public void resetMatch() {
        clearMatch();
        resetComputer();
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

    ////For Computer
    ///
    ///This method only perform for last turn to find Win O(computer) player.
    public void computer() {     ///This Class we think Computer Class.
        if (winingChess()) {
            System.out.println("O is Win");
            System.out.println(square);
        } else if (checkXWin()) {
            //nextCheck=false;
            System.out.println(square);
        } else if (OneScartchPerform()) {
            ///if this method is work then next2Check = false..otherwise next2Check is unchanged . Means true.
            System.out.println(square);
        } else if (twoScartchPerform()) {
            System.out.println(square);
        } else if (lastScartchPerform()) {

        }
        HandleWin(CheckWin('O'), 'O');
    }

    public boolean winingChess() {
        for (int i = 1; i <= 9; i++) {
            if (square[i] == 'O') {
                switch (i) {
                    case 1:
                        check1();
                        if (checkBool == true) {
                            WiningBool = true;
                        }
                        break;
                    case 2:
                        check2();
                        if (checkBool == true) {
                            WiningBool = true;
                        }
                        break;
                    case 3:
                        check3();
                        if (checkBool == true) {
                            WiningBool = true;
                        }
                        break;
                    case 4:
                        check4();
                        if (checkBool == true) {
                            WiningBool = true;
                        }
                        break;
                    case 5:
                        check5();
                        if (checkBool == true) {
                            WiningBool = true;
                        }
                        break;
                    case 6:
                        check6();
                        if (checkBool == true) {
                            WiningBool = true;
                        }
                        break;
                    case 7:
                        check7();
                        if (checkBool == true) {
                            WiningBool = true;
                        }
                        break;
                    case 8:
                        check8();
                        if (checkBool == true) {
                            WiningBool = true;
                        }
                        break;
                    case 9:
                        check9();
                        if (checkBool == true) {
                            WiningBool = true;
                        }
                        break;
                }
            }
            if (WiningBool == true) {
                break;
            }

        }
        if (WiningBool == true) {
            return true;
        } else {
            return false;
        }
    }

    ///Check oposite player winnig posibility .If found the posibility the the position push to O.
    private boolean checkXWin() {
        for (int i = 1; i <= 9; i++) {
            if (square[i] == 'X') {
                switch (i) {
                    case 1:
                        checkX1();
                        if (cXwin) {
                            WiningXBool = true;
                        }
                        break;
                    case 2:
                        checkX2();
                        if (cXwin) {
                            WiningXBool = true;
                        }
                        break;
                    case 3:
                        checkX3();
                        if (cXwin) {
                            WiningXBool = true;
                        }
                        break;
                    case 4:
                        checkX4();
                        if (cXwin) {
                            WiningXBool = true;
                        }
                        break;
                    case 5:
                        checkX5();
                        if (cXwin) {
                            WiningXBool = true;
                        }
                        break;
                    case 6:
                        checkX6();
                        if (cXwin) {
                            WiningXBool = true;
                        }
                        break;
                    case 7:
                        checkX7();
                        if (cXwin) {
                            WiningXBool = true;
                        }
                        break;
                    case 8:
                        checkX8();
                        if (cXwin) {
                            WiningXBool = true;
                        }
                        break;
                    case 9:
                        checkX9();
                        if (cXwin) {
                            WiningXBool = true;
                        }
                        break;
                }
            }
            if (WiningXBool) {
                break;
            }
        }
        if (WiningXBool) {
            return true;
        } else {
            return false;
        }
    }

    ///check Posibility X win
    private void check1() {
        if (square[2] == '2' && square[3] == 'O') {
            square[2] = 'O';
            btn2.setIcon(imgo);
            checkBool = true;
            btnRepeated2 = true;
        } else if (square[2] == 'O' && square[3] == '3') {
            square[3] = 'O';
            btn3.setIcon(imgo);
            checkBool = true;
            btnRepeated3 = true;
        } else if (square[4] == 'O' && square[7] == '7') {
            square[7] = 'O';
            btn7.setIcon(imgo);
            checkBool = true;
            btnRepeated7 = true;
        } else if (square[4] == '4' && square[7] == 'O') {
            square[4] = 'O';
            btn4.setIcon(imgo);
            checkBool = true;
            btnRepeated4 = true;
        } else if (square[5] == 'O' && square[9] == '9') {
            square[9] = 'O';
            btn9.setIcon(imgo);
            checkBool = true;
            btnRepeated9 = true;
        } else if (square[5] == '5' && square[9] == 'O') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            checkBool = true;
            btnRepeated5 = true;
        }
    }

    private void check2() {
        if (square[1] == '1' && square[3] == 'O') {
            square[1] = 'O';
            btn1.setIcon(imgo);
            checkBool = true;
            btnRepeated1 = true;
        } else if (square[1] == 'O' && square[3] == '3') {
            square[3] = 'O';
            btn3.setIcon(imgo);
            checkBool = true;
            btnRepeated3 = true;
        } else if (square[5] == '5' && square[8] == 'O') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            checkBool = true;
            btnRepeated5 = true;
        } else if (square[5] == 'O' && square[8] == '8') {
            square[8] = 'O';
            btn8.setIcon(imgo);
            checkBool = true;
            btnRepeated8 = true;
        }
    }

    private void check3() {
        if (square[1] == '1' && square[2] == 'O') {
            square[1] = 'O';
            btn1.setIcon(imgo);
            checkBool = true;
            btnRepeated1 = true;
        } else if (square[1] == 'O' && square[2] == '2') {
            square[2] = 'O';
            btn2.setIcon(imgo);
            checkBool = true;
            btnRepeated1 = true;
        } else if (square[6] == '6' && square[9] == 'O') {
            square[6] = 'O';
            btn6.setIcon(imgo);
            checkBool = true;
            btnRepeated6 = true;
        } else if (square[6] == 'O' && square[9] == '9') {
            square[9] = 'O';
            btn9.setIcon(imgo);
            checkBool = true;
            btnRepeated9 = true;
        } else if (square[5] == '5' && square[7] == 'O') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            checkBool = true;
            btnRepeated5 = true;
        } else if (square[5] == 'O' && square[7] == '7') {
            square[7] = 'O';
            btn7.setIcon(imgo);
            checkBool = true;
            btnRepeated7 = true;
        }

    }

    private void check4() {
        if (square[1] == '1' && square[7] == 'O') {
            square[1] = 'O';
            btn1.setIcon(imgo);
            checkBool = true;
            btnRepeated1 = true;
        } else if (square[1] == 'O' && square[7] == '7') {
            square[7] = 'O';
            btn7.setIcon(imgo);
            checkBool = true;
            btnRepeated7 = true;
        } else if (square[5] == '5' && square[6] == 'O') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            checkBool = true;
            btnRepeated5 = true;
        } else if (square[5] == 'O' && square[6] == '6') {
            square[6] = 'O';
            btn6.setIcon(imgo);
            checkBool = true;
            btnRepeated6 = true;
        }
    }

    private void check5() {
        if (square[2] == '2' && square[8] == 'O') {
            square[2] = 'O';
            btn2.setIcon(imgo);
            checkBool = true;
            btnRepeated2 = true;
        } else if (square[2] == 'O' && square[8] == '8') {
            square[8] = 'O';
            btn8.setIcon(imgo);
            checkBool = true;
            btnRepeated8 = true;
        } else if (square[4] == '4' && square[6] == 'O') {
            square[4] = 'O';
            btn4.setIcon(imgo);
            checkBool = true;
            btnRepeated4 = true;
        } else if (square[4] == 'O' && square[6] == '6') {
            square[6] = 'O';
            btn6.setIcon(imgo);
            checkBool = true;
            btnRepeated6 = true;
        } else if (square[1] == '1' && square[9] == 'O') {
            square[1] = 'O';
            btn1.setIcon(imgo);
            checkBool = true;
            btnRepeated1 = true;
        } else if (square[1] == 'O' && square[9] == '9') {
            square[9] = 'O';
            btn9.setIcon(imgo);
            checkBool = true;
            btnRepeated9 = true;
        } else if (square[3] == '3' && square[7] == 'O') {
            square[3] = 'O';
            btn3.setIcon(imgo);
            checkBool = true;
            btnRepeated3 = true;
        } else if (square[3] == 'O' && square[7] == '7') {
            square[7] = 'O';
            btn7.setIcon(imgo);
            checkBool = true;
            btnRepeated7 = true;
        }
    }

    private void check6() {
        if (square[3] == '3' && square[9] == 'O') {
            square[3] = 'O';
            btn3.setIcon(imgo);
            checkBool = true;
            btnRepeated3 = true;
        } else if (square[3] == 'O' && square[9] == '9') {
            square[9] = 'O';
            btn9.setIcon(imgo);
            checkBool = true;
            btnRepeated9 = true;
        } else if (square[5] == '5' && square[4] == 'O') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            checkBool = true;
            btnRepeated5 = true;
        } else if (square[5] == 'O' && square[4] == '4') {
            square[4] = 'O';
            btn4.setIcon(imgo);
            checkBool = true;
            btnRepeated4 = true;
        }
    }

    private void check7() {
        if (square[1] == '1' && square[4] == 'O') {
            square[1] = 'O';
            btn1.setIcon(imgo);
            checkBool = true;
            btnRepeated1 = true;
        } else if (square[1] == 'O' && square[4] == '4') {
            square[4] = 'O';
            btn4.setIcon(imgo);
            checkBool = true;
            btnRepeated4 = true;
        } else if (square[8] == 'O' && square[9] == '9') {
            square[9] = 'O';
            btn9.setIcon(imgo);
            checkBool = true;
            btnRepeated9 = true;
        } else if (square[8] == '8' && square[9] == 'O') {
            square[8] = 'O';
            btn8.setIcon(imgo);
            checkBool = true;
            btnRepeated8 = true;
        } else if (square[5] == 'O' && square[3] == '3') {
            square[3] = 'O';
            btn3.setIcon(imgo);
            checkBool = true;
            btnRepeated3 = true;
        } else if (square[5] == '5' && square[3] == 'O') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            checkBool = true;
            btnRepeated5 = true;
        }
    }

    private void check8() {
        if (square[2] == '2' && square[5] == 'O') {
            square[2] = 'O';
            btn2.setIcon(imgo);
            checkBool = true;
            btnRepeated2 = true;
        } else if (square[2] == 'O' && square[5] == '5') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            checkBool = true;
            btnRepeated5 = true;
        } else if (square[7] == '7' && square[9] == 'O') {
            square[7] = 'O';
            checkBool = true;
            btnRepeated7 = true;
        } else if (square[7] == 'O' && square[9] == '9') {
            square[9] = 'O';
            btn9.setIcon(imgo);
            checkBool = true;
            btnRepeated9 = true;
        }
    }

    private void check9() {
        if (square[1] == '1' && square[5] == 'O') {
            square[1] = 'O';
            btn1.setIcon(imgo);
            checkBool = true;
            btnRepeated1 = true;
        } else if (square[1] == 'O' && square[5] == '5') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            checkBool = true;
            btnRepeated5 = true;
        } else if (square[8] == 'O' && square[7] == '7') {
            square[7] = 'O';
            btn7.setIcon(imgo);
            checkBool = true;
            btnRepeated7 = true;
        } else if (square[8] == '8' && square[7] == 'O') {
            square[8] = 'O';
            btn8.setIcon(imgo);
            checkBool = true;
            btnRepeated8 = true;
        } else if (square[3] == 'O' && square[6] == '6') {
            square[6] = 'O';
            btn6.setIcon(imgo);
            checkBool = true;
            btnRepeated6 = true;
        } else if (square[3] == '3' && square[6] == 'O') {
            square[3] = 'O';
            btn3.setIcon(imgo);
            checkBool = true;
            btnRepeated3 = true;
        }
    }

    ///check Posibility O win
    private void checkX1() {
        if (square[2] == '2' && square[3] == 'X') {
            square[2] = 'O';
            btn2.setIcon(imgo);
            cXwin = true;
            btnRepeated2 = true;
        } else if (square[2] == 'X' && square[3] == '3') {
            square[3] = 'O';
            btn3.setIcon(imgo);
            cXwin = true;
            btnRepeated3 = true;
        } else if (square[4] == 'X' && square[7] == '7') {
            square[7] = 'O';
            btn7.setIcon(imgo);
            cXwin = true;
            btnRepeated7 = true;
        } else if (square[4] == '4' && square[7] == 'X') {
            square[4] = 'O';
            btn4.setIcon(imgo);
            cXwin = true;
            btnRepeated4 = true;
        } else if (square[5] == 'X' && square[9] == '9') {
            square[9] = 'O';
            btn9.setIcon(imgo);
            cXwin = true;
            btnRepeated9 = true;
        } else if (square[5] == '5' && square[9] == 'X') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            cXwin = true;
            btnRepeated5 = true;
        }
    }

    private void checkX2() {
        if (square[1] == '1' && square[3] == 'X') {
            square[1] = 'O';
            btn1.setIcon(imgo);
            cXwin = true;
            btnRepeated1 = true;
        } else if (square[1] == 'X' && square[3] == '3') {
            square[3] = 'O';
            btn3.setIcon(imgo);
            cXwin = true;
            btnRepeated3 = true;
        } else if (square[5] == '5' && square[8] == 'X') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            cXwin = true;
            btnRepeated5 = true;
        } else if (square[5] == 'X' && square[8] == '8') {
            square[8] = 'O';
            btn8.setIcon(imgo);
            cXwin = true;
            btnRepeated8 = true;
        }
    }

    private void checkX3() {
        if (square[1] == '1' && square[2] == 'X') {
            square[1] = 'O';
            btn1.setIcon(imgo);
            cXwin = true;
            btnRepeated1 = true;
        } else if (square[1] == 'X' && square[2] == '2') {
            square[2] = 'O';
            btn2.setIcon(imgo);
            cXwin = true;
            btnRepeated2 = true;
        } else if (square[6] == '6' && square[9] == 'X') {
            square[6] = 'O';
            btn6.setIcon(imgo);
            cXwin = true;
            btnRepeated6 = true;
        } else if (square[6] == 'X' && square[9] == '9') {
            square[9] = 'O';
            btn9.setIcon(imgo);
            cXwin = true;
            btnRepeated9 = true;
        } else if (square[5] == '5' && square[7] == 'X') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            cXwin = true;
            btnRepeated5 = true;
        } else if (square[5] == 'X' && square[7] == '7') {
            square[7] = 'O';
            btn7.setIcon(imgo);
            cXwin = true;
            btnRepeated7 = true;
        }

    }

    private void checkX4() {
        if (square[1] == '1' && square[7] == 'X') {
            square[1] = 'O';
            btn1.setIcon(imgo);
            cXwin = true;
            btnRepeated1 = true;
        } else if (square[1] == 'X' && square[7] == '7') {
            square[7] = 'O';
            btn7.setIcon(imgo);
            cXwin = true;
            btnRepeated7 = true;
        } else if (square[5] == '5' && square[6] == 'X') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            cXwin = true;
            btnRepeated5 = true;
        } else if (square[5] == 'X' && square[6] == '6') {
            square[6] = 'O';
            btn6.setIcon(imgo);
            cXwin = true;
            btnRepeated6 = true;
        }
    }

    private void checkX5() {
        if (square[2] == '2' && square[8] == 'X') {
            square[2] = 'O';
            btn2.setIcon(imgo);
            cXwin = true;
            btnRepeated2 = true;
        } else if (square[2] == 'X' && square[8] == '8') {
            square[8] = 'O';
            btn8.setIcon(imgo);
            cXwin = true;
            btnRepeated8 = true;
        } else if (square[4] == '4' && square[6] == 'X') {
            square[4] = 'O';
            btn4.setIcon(imgo);
            cXwin = true;
            btnRepeated4 = true;
        } else if (square[4] == 'X' && square[6] == '6') {
            square[6] = 'O';
            btn6.setIcon(imgo);
            cXwin = true;
            btnRepeated6 = true;
        } else if (square[1] == '1' && square[9] == 'X') {
            square[1] = 'O';
            btn1.setIcon(imgo);
            cXwin = true;
            btnRepeated1 = true;
        } else if (square[1] == 'X' && square[9] == '9') {
            square[9] = 'O';
            btn9.setIcon(imgo);
            cXwin = true;
            btnRepeated9 = true;
        } else if (square[3] == '3' && square[7] == 'X') {
            square[3] = 'O';
            btn3.setIcon(imgo);
            cXwin = true;
            btnRepeated3 = true;
        } else if (square[3] == 'X' && square[7] == '7') {
            square[7] = 'O';
            btn7.setIcon(imgo);
            cXwin = true;
            btnRepeated7 = true;
        }
    }

    private void checkX6() {
        if (square[3] == '3' && square[9] == 'X') {
            square[3] = 'O';
            btn3.setIcon(imgo);
            cXwin = true;
            btnRepeated3 = true;
        } else if (square[3] == 'X' && square[9] == '9') {
            square[9] = 'O';
            btn9.setIcon(imgo);
            cXwin = true;
            btnRepeated9 = true;
        } else if (square[5] == '5' && square[4] == 'X') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            cXwin = true;
            btnRepeated5 = true;
        } else if (square[5] == 'X' && square[4] == '4') {
            square[4] = 'O';
            btn4.setIcon(imgo);
            cXwin = true;
            btnRepeated4 = true;
        }
    }

    private void checkX7() {
        if (square[1] == '1' && square[4] == 'X') {
            square[1] = 'O';
            btn1.setIcon(imgo);
            cXwin = true;
            btnRepeated1 = true;
        } else if (square[1] == 'X' && square[4] == '4') {
            square[4] = 'O';
            btn4.setIcon(imgo);
            cXwin = true;
            btnRepeated4 = true;
        } else if (square[8] == 'X' && square[9] == '9') {
            square[9] = 'O';
            btn9.setIcon(imgo);
            cXwin = true;
            btnRepeated9 = true;
        } else if (square[8] == '8' && square[9] == 'X') {
            square[8] = 'O';
            btn8.setIcon(imgo);
            cXwin = true;
            btnRepeated8 = true;
        } else if (square[5] == 'X' && square[3] == '3') {
            square[3] = 'O';
            btn3.setIcon(imgo);
            cXwin = true;
            btnRepeated3 = true;
        } else if (square[5] == '5' && square[3] == 'X') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            cXwin = true;
            btnRepeated5 = true;
        }
    }

    private void checkX8() {
        if (square[2] == '2' && square[5] == 'X') {
            square[2] = 'O';
            btn2.setIcon(imgo);
            cXwin = true;
            btnRepeated2 = true;
        } else if (square[2] == 'X' && square[5] == '5') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            cXwin = true;
            btnRepeated5 = true;
        } else if (square[7] == '7' && square[9] == 'X') {
            square[7] = 'O';
            btn7.setIcon(imgo);
            cXwin = true;
            btnRepeated7 = true;
        } else if (square[7] == 'X' && square[9] == '9') {
            square[9] = 'O';
            btn9.setIcon(imgo);
            cXwin = true;
            btnRepeated9 = true;
        }
    }

    private void checkX9() {
        if (square[1] == '1' && square[5] == 'X') {
            square[1] = 'O';
            btn1.setIcon(imgo);
            cXwin = true;
            btnRepeated1 = true;
        } else if (square[1] == 'X' && square[5] == '5') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            cXwin = true;
            btnRepeated5 = true;
        } else if (square[8] == 'X' && square[7] == '7') {
            square[7] = 'O';
            btn7.setIcon(imgo);
            cXwin = true;
            btnRepeated7 = true;
        } else if (square[8] == '8' && square[7] == 'X') {
            square[8] = 'O';
            btn8.setIcon(imgo);
            cXwin = true;
            btnRepeated8 = true;
        } else if (square[3] == 'X' && square[6] == '6') {
            square[6] = 'O';
            btn6.setIcon(imgo);
            cXwin = true;
            btnRepeated6 = true;
        } else if (square[3] == '3' && square[6] == 'X') {
            square[3] = 'O';
            btn3.setIcon(imgo);
            cXwin = true;
            btnRepeated3 = true;
        }
    }

    ///if 1 scratch of Square then work this perform this method.
    public boolean OneScartchPerform() {
        if (square[1] == 'X' && square[2] == '2' && square[3] == '3' && square[4] == '4' && square[5] == '5' && square[6] == '6' && square[7] == '7' && square[8] == '8' && square[9] == '9') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            next2Check = true;
            btnRepeated5 = true;
        } else if (square[1] == '1' && square[2] == 'X' && square[3] == '3' && square[4] == '4' && square[5] == '5' && square[6] == '6' && square[7] == '7' && square[8] == '8' && square[9] == '9') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            next2Check = true;
            btnRepeated5 = true;
        } else if (square[1] == '1' && square[2] == '2' && square[3] == 'X' && square[4] == '4' && square[5] == '5' && square[6] == '6' && square[7] == '7' && square[8] == '8' && square[9] == '9') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            next2Check = true;
            btnRepeated5 = true;
        } else if (square[1] == '1' && square[2] == '2' && square[3] == '3' && square[4] == 'X' && square[5] == '5' && square[6] == '6' && square[7] == '7' && square[8] == '8' && square[9] == '9') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            next2Check = true;
            btnRepeated5 = true;
        } else if (square[1] == '1' && square[2] == '2' && square[3] == '3' && square[4] == '4' && square[5] == 'X' && square[6] == '6' && square[7] == '7' && square[8] == '8' && square[9] == '9') {
            square[1] = 'O';
            btn1.setIcon(imgo);
            next2Check = true;
            btnRepeated1 = true;
        } else if (square[1] == '1' && square[2] == '2' && square[3] == '3' && square[4] == '4' && square[5] == '5' && square[6] == 'X' && square[7] == '7' && square[8] == '8' && square[9] == '9') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            next2Check = true;
            btnRepeated5 = true;
        } else if (square[1] == '1' && square[2] == '2' && square[3] == '3' && square[4] == '4' && square[5] == '5' && square[6] == '6' && square[7] == 'X' && square[8] == '8' && square[9] == '9') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            next2Check = true;
            btnRepeated5 = true;
        } else if (square[1] == '1' && square[2] == '2' && square[3] == '3' && square[4] == '4' && square[5] == '5' && square[6] == '6' && square[7] == '7' && square[8] == 'X' && square[9] == '9') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            next2Check = true;
            btnRepeated5 = true;
        } else if (square[1] == '1' && square[2] == '2' && square[3] == '3' && square[4] == '4' && square[5] == '5' && square[6] == '6' && square[7] == '7' && square[8] == '8' && square[9] == 'X') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            next2Check = true;
            btnRepeated5 = true;
        }

        if (next2Check == true) {
            return true;
        } else {
            return false;
        }

    }

    public boolean twoScartchPerform() {
        if (square[1] == 'O' && square[2] == '2' && square[3] == '3') {
            square[3] = 'O';
            btn3.setIcon(imgo);
            next3Check = true;
            btnRepeated3 = true;
        } else if (square[1] == 'O' && square[4] == '4' && square[7] == '7') {
            square[7] = 'O';
            btn7.setIcon(imgo);
            next3Check = true;
            btnRepeated7 = true;
        } else if (square[1] == 'O' && square[5] == '5' && square[9] == '9') {
            square[9] = 'O';
            btn9.setIcon(imgo);
            next3Check = true;
            btnRepeated9 = true;
        } else if (square[2] == 'O' && square[1] == '1' && square[3] == '3') {
            square[1] = 'O';
            btn1.setIcon(imgo);
            next3Check = true;
            btnRepeated1 = true;
        } else if (square[2] == 'O' && square[5] == '5' && square[8] == '8') {
            square[8] = 'O';
            btn8.setIcon(imgo);
            next3Check = true;
            btnRepeated8 = true;
        } else if (square[3] == 'O' && square[2] == '2' && square[1] == '1') {
            square[1] = 'O';
            btn1.setIcon(imgo);
            next3Check = true;
            btnRepeated1 = true;
        } else if (square[3] == 'O' && square[6] == '6' && square[9] == '9') {
            square[9] = 'O';
            btn9.setIcon(imgo);
            next3Check = true;
            btnRepeated9 = true;
        } else if (square[3] == 'O' && square[5] == '5' && square[7] == '7') {
            square[7] = 'O';
            btn7.setIcon(imgo);
            next3Check = true;
            btnRepeated7 = true;
        } else if (square[4] == 'O' && square[1] == '1' && square[7] == '7') {
            square[7] = 'O';
            btn7.setIcon(imgo);
            next3Check = true;
            btnRepeated7 = true;
        } else if (square[4] == 'O' && square[5] == '5' && square[6] == '6') {
            square[6] = 'O';
            btn6.setIcon(imgo);
            next3Check = true;
            btnRepeated6 = true;
        } else if (square[5] == 'O' && square[4] == '4' && square[6] == '6') {
            square[6] = 'O';
            btn6.setIcon(imgo);
            next3Check = true;
            btnRepeated6 = true;
        } else if (square[5] == 'O' && square[2] == '2' && square[8] == '8') {
            square[2] = 'O';
            btn2.setIcon(imgo);
            next3Check = true;
            btnRepeated2 = true;
        } else if (square[5] == 'O' && square[1] == '1' && square[9] == '9') {
            square[1] = 'O';
            btn1.setIcon(imgo);
            next3Check = true;
            btnRepeated1 = true;
        } else if (square[5] == 'O' && square[3] == '3' && square[7] == '7') {
            square[7] = 'O';
            btn7.setIcon(imgo);
            next3Check = true;
            btnRepeated7 = true;
        } else if (square[6] == 'O' && square[3] == '3' && square[9] == '9') {
            square[3] = 'O';
            btn3.setIcon(imgo);
            next3Check = true;
            btnRepeated3 = true;
        } else if (square[6] == 'O' && square[4] == '4' && square[5] == '5') {
            square[4] = 'O';
            btn4.setIcon(imgo);
            next3Check = true;
            btnRepeated3 = true;
        } else if (square[7] == 'O' && square[4] == '4' && square[1] == '1') {
            square[1] = 'O';
            btn1.setIcon(imgo);
            next3Check = true;
            btnRepeated1 = true;
        } else if (square[7] == 'O' && square[8] == '8' && square[9] == '9') {
            square[9] = 'O';
            btn9.setIcon(imgo);
            next3Check = true;
            btnRepeated9 = true;
        } else if (square[7] == 'O' && square[5] == '5' && square[3] == '3') {
            square[3] = 'O';
            btn3.setIcon(imgo);
            next3Check = true;
            btnRepeated3 = true;
        } else if (square[8] == 'O' && square[7] == '7' && square[9] == '9') {
            square[9] = 'O';
            btn9.setIcon(imgo);
            next3Check = true;
            btnRepeated9 = true;
        } else if (square[8] == 'O' && square[5] == '5' && square[2] == '2') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            next3Check = true;
            btnRepeated5 = true;
        } else if (square[9] == 'O' && square[6] == '6' && square[3] == '3') {
            square[3] = 'O';
            btn3.setIcon(imgo);
            next3Check = true;
            btnRepeated3 = true;
        } else if (square[9] == 'O' && square[7] == '7' && square[8] == '8') {
            square[7] = 'O';
            btn7.setIcon(imgo);
            next3Check = true;
            btnRepeated7 = true;
        } else if (square[9] == 'O' && square[1] == '1' && square[5] == '5') {
            square[5] = 'O';
            btn5.setIcon(imgo);
            next3Check = true;
            btnRepeated5 = true;
        }
        if (next3Check) {
            return true;
        } else {
            return false;
        }
    }

    ///Reset Computer Player all veriable ..
    public void resetComputer() {

        WiningBool = false;
        WiningXBool = false;
        checkBool = false;
        cXwin = false;
        nextCheck = false;
        next2Check = false;
        next3Check = false;
        next4Check = false;
        playerMoveO = false;

    }

    ///last scartch for O
    public boolean lastScartchPerform() {
        for (int i = 1; i <= 9; i++) {
            if (square[i] == 'X' || square[i] == 'O') {
                //true....
            } else {
                square[i] = 'O';
                clickButtonOfComputer(i);
                System.out.println("sohag");
                next4Check = true;
                nextCheck = true;

                break;
            }
        }
        if (next4Check) {
            return true;
        } else {
            return false;
        }
    }

    public void clickButtonOfComputer(int i) {
        if (i == 1) {
            btn1.setIcon(imgo);
            btnRepeated1 = true;
        } else if (i == 2) {
            btn2.setIcon(imgo);
            btnRepeated2 = true;
        } else if (i == 3) {
            btn3.setIcon(imgo);
            btnRepeated3 = true;
        } else if (i == 4) {
            btn4.setIcon(imgo);
            btnRepeated4 = true;
        } else if (i == 5) {
            btn5.setIcon(imgo);
            btnRepeated5 = true;
        } else if (i == 6) {
            btn6.setIcon(imgo);
            btnRepeated6 = true;
        } else if (i == 7) {
            btn7.setIcon(imgo);
            btnRepeated7 = true;
        } else if (i == 8) {
            btn8.setIcon(imgo);
            btnRepeated8 = true;
        } else if (i == 9) {
            btn9.setIcon(imgo);
            btnRepeated9 = true;
        }
    }
}
