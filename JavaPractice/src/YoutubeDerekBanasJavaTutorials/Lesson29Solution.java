package YoutubeDerekBanasJavaTutorials;

import javax.swing.*;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Lesson29Solution extends JFrame{


    private static final long serialVersionUID = 1L;

    private JButton but1, but2, but3, but4, but5, but6,
            but7, but8, but9, but0, butPlus, butMinus, butTimes, butDivide, butEquals,
            clearAll;

    private JTextField textResult;

    public String numberEntered1 = "0";
    public String numberEntered2 = "0";
    public int numCount = 1;
    public String operation = "";
    public boolean firstGo = true;
    public boolean justPushedEquals = false;



    public static void main(String[] args) {

        new Lesson29Solution();


    }

    public Lesson29Solution(){
        this.setSize(350, 580);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Calculator");

        JPanel thePanel = new JPanel();

        thePanel.setLayout(new GridBagLayout());

        GridBagConstraints gridConstraints = new GridBagConstraints();

        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        gridConstraints.gridwidth = 1;
        gridConstraints.gridheight = 1;
        gridConstraints.weightx = 50;
        gridConstraints.weighty = 100;
        gridConstraints.insets = new Insets(5,5,5,5);
        gridConstraints.anchor = GridBagConstraints.CENTER;
        gridConstraints.fill = GridBagConstraints.BOTH;

        textResult = new JTextField("0", 20);
        Font font = new Font("Helvetica", Font.PLAIN, 18);
        textResult.setFont(font);

        but1 = new JButton("1");
        but2 = new JButton("2");
        but3 = new JButton("3");
        but4 = new JButton("4");
        but5 = new JButton("5");
        but6 = new JButton("6");
        but7 = new JButton("7");
        but8 = new JButton("8");
        but9 = new JButton("9");
        butPlus = new JButton("+");
        but0 = new JButton("0");
        butMinus = new JButton("-");
        clearAll = new JButton("C");
        butTimes = new JButton("*");
        butDivide = new JButton("/");
        butEquals = new JButton("=");

        but0.setFont(font);
        but1.setFont(font);
        but2.setFont(font);
        but3.setFont(font);
        but4.setFont(font);
        but5.setFont(font);
        but6.setFont(font);
        but7.setFont(font);
        but8.setFont(font);
        but9.setFont(font);
        butPlus.setFont(font);
        butMinus.setFont(font);
        butTimes.setFont(font);
        butDivide.setFont(font);
        butEquals.setFont(font);
        clearAll.setFont(font);

        butPlus.setToolTipText("shift + =");
        butMinus.setToolTipText("-");
        butTimes.setToolTipText("shift + 8");
        butDivide.setToolTipText("shift + /");
        butEquals.setToolTipText("enter");
        clearAll.setToolTipText("backspace / delete");


        UIManager.put("ToolTip.font", new Font("Hevetica",Font.ITALIC,15));


        ListenForButton lForButton = new ListenForButton();

        but0.addActionListener(lForButton);
        but1.addActionListener(lForButton);
        but2.addActionListener(lForButton);
        but3.addActionListener(lForButton);
        but4.addActionListener(lForButton);
        but5.addActionListener(lForButton);
        but6.addActionListener(lForButton);
        but7.addActionListener(lForButton);
        but8.addActionListener(lForButton);
        but9.addActionListener(lForButton);
        clearAll.addActionListener(lForButton);

        ListenForOperation lForOp = new ListenForOperation();

        butPlus.addActionListener(lForOp);
        butMinus.addActionListener(lForOp);
        butTimes.addActionListener(lForOp);
        butDivide.addActionListener(lForOp);
        butEquals.addActionListener(lForOp);

        ListenForKeys lForKeys = new ListenForKeys();

        thePanel.add(clearAll, gridConstraints);
        gridConstraints.gridwidth = 20;
        gridConstraints.gridx = 5;
        thePanel.add(textResult, gridConstraints);
        gridConstraints.gridwidth = 1;
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 2;
        thePanel.add(but1, gridConstraints);
        gridConstraints.gridx = 5;
        thePanel.add(but2, gridConstraints);
        gridConstraints.gridx = 9;
        thePanel.add(but3, gridConstraints);
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 3;
        thePanel.add(but4, gridConstraints);
        gridConstraints.gridx = 5;
        thePanel.add(but5, gridConstraints);
        gridConstraints.gridx = 9;
        thePanel.add(but6, gridConstraints);
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 4;
        thePanel.add(but7, gridConstraints);
        gridConstraints.gridx = 5;
        thePanel.add(but8, gridConstraints);
        gridConstraints.gridx = 9;
        thePanel.add(but9, gridConstraints);
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 5;
        thePanel.add(butPlus, gridConstraints);
        gridConstraints.gridx = 5;
        thePanel.add(butMinus, gridConstraints);
        gridConstraints.gridx = 9;
        thePanel.add(but0, gridConstraints);
        gridConstraints.gridy = 6;
        gridConstraints.gridx = 1;
        thePanel.add(butTimes, gridConstraints);
        gridConstraints.gridx = 5;
        thePanel.add(butDivide, gridConstraints);
        gridConstraints.gridx = 9;
        thePanel.add(butEquals, gridConstraints);

        textResult.addKeyListener(lForKeys);
        this.add(thePanel);
        textResult.setEditable(false);
        this.setResizable(false);
        this.setVisible(true);
        textResult.requestFocus();



    }
    private class ListenForButton implements ActionListener{

        public void actionPerformed(ActionEvent e) {

            justPushedEquals = false;

            if(firstGo){
                if(numCount == 1){
                    numberEntered1 = "";
                    textResult.setText("");
                    firstGo = false;
                }else if (numCount == 2 && e.getSource() != but0){
                    numberEntered2 = "";
                    textResult.setText("");
                    firstGo = false;
                }
            }


            if(numCount == 1){
                if(e.getSource() == but0){
                    if(numberEntered1 != ""){
                        numberEntered1 += "0";
                        textResult.setText(numberEntered1);
                    }else{textResult.setText("0");}
                }else if(e.getSource() == but1){
                    numberEntered1 += "1";
                    textResult.setText(numberEntered1);
                }else if(e.getSource() == but2){
                    numberEntered1 += "2";
                    textResult.setText(numberEntered1);
                }else if(e.getSource() == but3){
                    numberEntered1 += "3";
                    textResult.setText(numberEntered1);
                }else if(e.getSource() == but4){
                    numberEntered1 += "4";
                    textResult.setText(numberEntered1);
                }else if(e.getSource() == but5){
                    numberEntered1 += "5";
                    textResult.setText(numberEntered1);
                }else if(e.getSource() == but6){
                    numberEntered1 += "6";
                    textResult.setText(numberEntered1);
                }else if(e.getSource() == but7){
                    numberEntered1 += "7";
                    textResult.setText(numberEntered1);
                }else if(e.getSource() == but8){
                    numberEntered1 += "8";
                    textResult.setText(numberEntered1);
                }else if(e.getSource() == but9){
                    numberEntered1 += "9";
                    textResult.setText(numberEntered1);
                }else if(e.getSource() == clearAll){
                    numberEntered1 = "0";
                    textResult.setText(numberEntered1);
                    firstGo = true;
                }



            }else if(numCount == 2){
                if(e.getSource() == but0){
                    if(Integer.parseInt(numberEntered2) != 0){
                        numberEntered2 += "0";
                        textResult.setText(numberEntered2);
                    }else{textResult.setText(numberEntered2);}
                }else if(e.getSource() == but1){
                    numberEntered2 += "1";
                    textResult.setText(numberEntered2);
                }else if(e.getSource() == but2){
                    numberEntered2 += "2";
                    textResult.setText(numberEntered2);
                }else if(e.getSource() == but3){
                    numberEntered2 += "3";
                    textResult.setText(numberEntered2);
                }else if(e.getSource() == but4){
                    numberEntered2 += "4";
                    textResult.setText(numberEntered2);
                }else if(e.getSource() == but5){
                    numberEntered2 += "5";
                    textResult.setText(numberEntered2);
                }else if(e.getSource() == but6){
                    numberEntered2 += "6";
                    textResult.setText(numberEntered2);
                }else if(e.getSource() == but7){
                    numberEntered2 += "7";
                    textResult.setText(numberEntered2);
                }else if(e.getSource() == but8){
                    numberEntered2 += "8";
                    textResult.setText(numberEntered2);
                }else if(e.getSource() == but9){
                    numberEntered2 += "9";
                    textResult.setText(numberEntered2);
                }else if(e.getSource() == clearAll){
                    if(numberEntered2 == ""){
                        numberEntered1 = "0";
                        numberEntered2 = "0";
                        numCount = 1;
                        firstGo = true;
                        clearAll.setText("C");

                    }else{
                        numberEntered2 = "0";
                        textResult.setText(numberEntered2);
                        firstGo = true;
                        clearAll.setText("CA");;
                    }

                }



            }

            textResult.requestFocus();


        }

    }

    private class ListenForOperation implements ActionListener{

        public void actionPerformed(ActionEvent e1) {

            textResult.requestFocus();

            if (e1.getSource() != butEquals && justPushedEquals){
                numberEntered1 = textResult.getText();
                justPushedEquals = false;
            }

            if (e1.getSource() == butPlus){
                operation = "add";

            }else if (e1.getSource() == butMinus){
                operation = "subtract";

            }else if (e1.getSource() == butTimes){
                operation = "multiply";

            }else if (e1.getSource() == butDivide){
                operation = "divide";

            }



            if (e1.getSource() == butEquals){
                if (!justPushedEquals){
                    Calculate(numberEntered1, numberEntered2);
                    numCount = 1;
                    justPushedEquals = true;
                }
            }
            else if (numCount == 1 && !justPushedEquals){
                numCount = 2;
            }else if (numCount == 2 && !justPushedEquals){
                numberEntered1 = Calculate(numberEntered1, numberEntered2);
                numCount = 1;
            }
            firstGo = true;

        }

        public String Calculate(String one, String two){

            if(one == ""){
                one = "0";
            }

            if(two == "" | Integer.parseInt(two) == 0){
                textResult.setText(numberEntered1);
                return numberEntered1;
            }

            double doubleOne = Double.parseDouble(one);
            double doubleTwo = Double.parseDouble(two);
            double doubleResult = 0;

            if(operation == "add"){
                doubleResult = (doubleOne + doubleTwo);
            }else if (operation == "subtract"){
                doubleResult = doubleOne - doubleTwo;
            }else if (operation == "multiply"){
                doubleResult = doubleOne * doubleTwo;
            }else if (operation == "divide"){
                if (doubleTwo == 0){
                    textResult.setText("ERROR");
                    numberEntered2 = "0";
                    numberEntered1 = "0";
                    numCount = 1;
                    return "0";


                }else{
                    doubleResult = doubleOne / doubleTwo;
                }
            }


            String result;

            if(doubleResult == (int) doubleResult){
                result = Integer.toString((int)doubleResult);
            }else{
                result = Double.toString(doubleResult);
            }

            textResult.setText(result);
            numberEntered1 = "0";
            numberEntered2 = "0";
            return result;
        }


    }

    private class ListenForKeys implements KeyListener{


        public void keyPressed(KeyEvent e2) {
            if(e2.getKeyChar() == '1'){
                but1.doClick();
            }else if(e2.getKeyChar() == '2'){
                but2.doClick();
            }else if(e2.getKeyChar() == '3'){
                but3.doClick();
            }else if(e2.getKeyChar() == '4'){
                but4.doClick();
            }else if(e2.getKeyChar() == '5'){
                but5.doClick();
            }else if(e2.getKeyChar() == '6'){
                but6.doClick();
            }else if(e2.getKeyChar() == '7'){
                but7.doClick();
            }else if(e2.getKeyChar() == '8'){
                but8.doClick();
            }else if(e2.getKeyChar() == '9'){
                but9.doClick();
            }else if(e2.getKeyChar() == '0'){
                but0.doClick();
            }else if(e2.getKeyChar() == '+'){
                butPlus.doClick();
            }else if(e2.getKeyChar() == '-'){
                butMinus.doClick();
            }else if(e2.getKeyChar() == '*'){
                butTimes.doClick();
            }else if(e2.getKeyChar() == '/'){
                butDivide.doClick();
            }else if(e2.getKeyCode() == 10){
                butEquals.doClick();
            }else if (e2.getKeyCode() == 8 | e2.getKeyCode() == 127){
                clearAll.doClick();
            }else if(e2.getKeyCode() == 27){
                System.exit(0);
            }

        }

        public void keyReleased(KeyEvent arg0) {
            // TODO Auto-generated method stub
        }
        public void keyTyped(KeyEvent arg0) {
            // TODO Auto-generated method stub
        }
    }
}