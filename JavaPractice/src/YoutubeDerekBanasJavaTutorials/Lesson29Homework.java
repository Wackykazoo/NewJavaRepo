package YoutubeDerekBanasJavaTutorials;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lesson29Homework extends JFrame {
    private JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, plusButton, minusButton, clearAll, multiplyButton, divideButton, evaluateButton;
    private JTextField textResult;
    private int firstNumber, secondNumber;
    private String displayText = "0";
    private char expression;

    public static void main(String[] args){
        new Lesson29Homework();
    }

    public Lesson29Homework(){
        this.setSize(300, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Calculator");

        JPanel thePanel = new JPanel();
        thePanel.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        ButtonListener buttonListener = new ButtonListener();

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.weightx = 50;
        gridBagConstraints.weighty = 100;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;

        textResult = new JTextField(displayText, 20);
        Font font = new Font("Helvetica", Font.PLAIN, 15);
        textResult.setFont(font);
        textResult.setEditable(false);

        button1 = new JButton("1");
        button1.addActionListener(buttonListener);

        button2 = new JButton("2");
        button2.addActionListener(buttonListener);

        button3 = new JButton("3");
        button3.addActionListener(buttonListener);

        button4 = new JButton("4");
        button4.addActionListener(buttonListener);

        button5 = new JButton("5");
        button5.addActionListener(buttonListener);

        button6 = new JButton("6");
        button6.addActionListener(buttonListener);

        button7 = new JButton("7");
        button7.addActionListener(buttonListener);

        button8 = new JButton("8");
        button8.addActionListener(buttonListener);

        button9 = new JButton("9");
        button9.addActionListener(buttonListener);

        plusButton = new JButton("+");
        plusButton.addActionListener(buttonListener);

        button0 = new JButton("0");
        button0.addActionListener(buttonListener);

        minusButton = new JButton("-");
        minusButton.addActionListener(buttonListener);

        clearAll = new JButton("C");
        clearAll.addActionListener(buttonListener);

        multiplyButton = new JButton("*");
        multiplyButton.addActionListener(buttonListener);

        divideButton = new JButton("/");
        divideButton.addActionListener(buttonListener);

        evaluateButton = new JButton("=");
        evaluateButton.addActionListener(buttonListener);

        thePanel.add(clearAll, gridBagConstraints);

        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridx = 5;
        thePanel.add(textResult, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        thePanel.add(button1, gridBagConstraints);

        gridBagConstraints.gridx = 5;
        thePanel.add(button2, gridBagConstraints);

        gridBagConstraints.gridx = 9;
        thePanel.add(button3, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        thePanel.add(button4, gridBagConstraints);

        gridBagConstraints.gridx = 5;
        thePanel.add(button5, gridBagConstraints);

        gridBagConstraints.gridx = 9;
        thePanel.add(button6, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        thePanel.add(button7, gridBagConstraints);

        gridBagConstraints.gridx = 5;
        thePanel.add(button8, gridBagConstraints);

        gridBagConstraints.gridx = 9;
        thePanel.add(button9, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        thePanel.add(plusButton, gridBagConstraints);

        gridBagConstraints.gridx = 5;
        thePanel.add(button0, gridBagConstraints);

        gridBagConstraints.gridx = 9;
        thePanel.add(minusButton, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        thePanel.add(multiplyButton, gridBagConstraints);

        gridBagConstraints.gridx = 5;
        thePanel.add(divideButton, gridBagConstraints);

        gridBagConstraints.gridx = 9;
        thePanel.add(evaluateButton, gridBagConstraints);

        this.add(thePanel);
        this.setVisible(true);
    }

    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == clearAll){
                displayText = "0";
                textResult.setText(displayText);
                firstNumber = 0;
                secondNumber = 0;
            }else if(e.getSource() == evaluateButton){
                secondNumber = Integer.parseInt(displayText);
                System.out.println("It's working, it's working!");
                System.out.println(secondNumber);
                switch (expression) {
                    case '+':
                        displayText = Integer.toString((firstNumber + secondNumber));
                        textResult.setText(displayText);
                        break;
                    case '-':
                        displayText = Integer.toString((firstNumber - secondNumber));
                        textResult.setText(displayText);
                        break;
                    case '*':
                        displayText = Integer.toString((firstNumber * secondNumber));
                        textResult.setText(displayText);
                        break;
                    case '/':
                        displayText = Integer.toString((firstNumber / secondNumber));
                        textResult.setText(displayText);
                        break;
                    default:
                        textResult.setText("Something Broke Folks");
                }
            }else if(e.getSource() == plusButton){
                expression = '+';
                firstNumber = Integer.parseInt(displayText);
                displayText = "0";
                textResult.setText(displayText);
            }else if(e.getSource() == minusButton){
                expression = '-';
                firstNumber = Integer.parseInt(displayText);
                displayText = "0";
                textResult.setText(displayText);
            }else if(e.getSource() == multiplyButton){
                expression = '*';
                firstNumber = Integer.parseInt(displayText);
                displayText = "0";
                textResult.setText(displayText);
            }else if(e.getSource() == divideButton){
                expression = '/';
                firstNumber = Integer.parseInt(displayText);
                displayText = "0";
                textResult.setText(displayText);
            }else if(e.getSource() == button1){
                if(displayText.equals("0")){
                    displayText = "1";
                }else{
                    displayText = displayText + "1";
                }
                textResult.setText(displayText);
            }else if(e.getSource() == button2){
                if(displayText.equals("0")){
                    displayText = "2";
                }else{
                    displayText = displayText + "2";
                }
                textResult.setText(displayText);
            }else if(e.getSource() == button3){
                if(displayText.equals("0")){
                    displayText = "3";
                }else{
                    displayText = displayText + "3";
                }
                textResult.setText(displayText);
            }else if(e.getSource() == button4){
                if(displayText.equals("0")){
                    displayText = "4";
                }else{
                    displayText = displayText + "4";
                }
                textResult.setText(displayText);
            }else if(e.getSource() == button5){
                if(displayText.equals("0")){
                    displayText = "5";
                }else{
                    displayText = displayText + "5";
                }
                textResult.setText(displayText);
            }else if(e.getSource() == button6){
                if(displayText.equals("0")){
                    displayText = "6";
                }else{
                    displayText = displayText + "6";
                }
                textResult.setText(displayText);
            }else if(e.getSource() == button7){
                if(displayText.equals("0")){
                    displayText = "7";
                }else{
                    displayText = displayText + "7";
                }
                textResult.setText(displayText);
            }else if(e.getSource() == button8){
                if(displayText.equals("0")){
                    displayText = "8";
                }else{
                    displayText = displayText + "8";
                }
                textResult.setText(displayText);
            }else if(e.getSource() == button9){
                if(displayText.equals("0")){
                    displayText = "9";
                }else{
                    displayText = displayText + "9";
                }
                textResult.setText(displayText);
            }else if(e.getSource() == button0){
                if(displayText.equals("0")){
                    displayText = "0";
                }else{
                    displayText = displayText + "0";
                }
                textResult.setText(displayText);
            }
        }
    }
}
