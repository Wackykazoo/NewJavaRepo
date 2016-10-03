package YoutubeDerekBanasJavaTutorials;

import javax.swing.*;
import java.awt.event.*;
import java.text.NumberFormat;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Lesson22_23 extends JFrame{
    private JButton button1;
    private JLabel label1, label2, label3;
    private JTextField textField1, textField2;
    private JCheckBox dollarSign, commaSeparator;
    private JRadioButton addRadioButton, subtractRadioButton, multiplyRadioButton, divideRadioButton;
    private JSlider howManyTimes;

    private double number1, number2, totalCalculate;

    public static void main(String[] args){
        new Lesson22_23();
    }

    public Lesson22_23(){
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Third Frame");

        JPanel thePanel = new JPanel();

        button1 = new JButton("Calculate");
        ListenForButton buttonListener = new ListenForButton();
        button1.addActionListener(buttonListener);
        thePanel.add(button1);

        label1 = new JLabel("Number 1");
        thePanel.add(label1);
        textField1 = new JTextField("", 5);
        thePanel.add(textField1);

        label2 = new JLabel("Number 2");
        thePanel.add(label2);
        textField2 = new JTextField("", 5);
        thePanel.add(textField2);

        dollarSign = new JCheckBox("Dollars");
        commaSeparator = new JCheckBox("Commas");
        thePanel.add(dollarSign);
        thePanel.add(commaSeparator, true);

        addRadioButton = new JRadioButton("Add");
        subtractRadioButton = new JRadioButton("Subtract");
        multiplyRadioButton = new JRadioButton("Multiply");
        divideRadioButton = new JRadioButton("Divide");
        ButtonGroup operation = new ButtonGroup();
        operation.add(addRadioButton);
        operation.add(subtractRadioButton);
        operation.add(multiplyRadioButton);
        operation.add(divideRadioButton);
        JPanel operationPanel = new JPanel();
        Border operationBorder = BorderFactory.createTitledBorder("Operation");
        operationPanel.setBorder(operationBorder);
        operationPanel.add(addRadioButton);
        operationPanel.add(subtractRadioButton);
        operationPanel.add(multiplyRadioButton);
        operationPanel.add(divideRadioButton);
        addRadioButton.setSelected(true);
        thePanel.add(operationPanel);

        label3 = new JLabel("Perform how many times?");
        thePanel.add(label3);
        howManyTimes = new JSlider(0, 99, 1);
        howManyTimes.setMinorTickSpacing(1);
        howManyTimes.setMajorTickSpacing(10);
        howManyTimes.setPaintTicks(true);
        howManyTimes.setPaintLabels(true);
        ListenForSlider sliderListener = new ListenForSlider();
        howManyTimes.addChangeListener(sliderListener);
        thePanel.add(howManyTimes);

        this.add(thePanel);
        this.setVisible(true);
        textField1.requestFocus();
    }

    private class ListenForButton implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1){
                try{
                    number1 = Double.parseDouble(textField1.getText());
                    number2 = Double.parseDouble(textField2.getText());
                }catch(NumberFormatException exception){
                    JOptionPane.showMessageDialog(Lesson22_23.this, "Please enter the right info", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }

                if(addRadioButton.isSelected()){
                    totalCalculate = addNumbers(number1, number2, howManyTimes.getValue());
                }else if(subtractRadioButton.isSelected()){
                    totalCalculate = subtractNumbers(number1, number2, howManyTimes.getValue());
                }else if(multiplyRadioButton.isSelected()){
                    totalCalculate = multiplyNumbers(number1, number2, howManyTimes.getValue());
                }else if(divideRadioButton.isSelected()){
                    totalCalculate = divideNumbers(number1, number2, howManyTimes.getValue());
                }

                if(dollarSign.isSelected()){
                    NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
                    JOptionPane.showMessageDialog(Lesson22_23.this, numberFormat.format(totalCalculate), "Solution", JOptionPane.INFORMATION_MESSAGE);
                }else if(commaSeparator.isSelected()){
                    NumberFormat numberFormat = NumberFormat.getNumberInstance();
                    JOptionPane.showMessageDialog(Lesson22_23.this, numberFormat.format(totalCalculate), "Solution", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(Lesson22_23.this, totalCalculate, "Solution", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    private class ListenForSlider implements ChangeListener{
        public void stateChanged(ChangeEvent e) {
            if(e.getSource() == howManyTimes){
                label3.setText("Perform how many times? " + howManyTimes.getValue());
            }
        }
    }

    private static double addNumbers(double number1, double number2, int howMany){
        double total = 0;
        int i = 1;
        while (i <= howMany){
            total = total + (number1 + number2);
            i++;
        }
        return total;
    }
    private static double subtractNumbers(double number1, double number2, int howMany){
        double total = 0;
        int i = 1;
        while(i <= howMany){
            total = total + (number1 - number2);
            i++;
        }
        return total;
    }
    private static double multiplyNumbers(double number1, double number2, int howMany){
        double total = 0;
        int i = 1;
        while (i <= howMany){
            total = total + (number1 * number2);
            i++;
        }
        return total;
    }
    private static double divideNumbers(double number1, double number2, int howMany){
        double total = 0;
        int i = 1;
        while(i <= howMany){
            total = total + (number1 / number2);
            i++;
        }
        return total;
    }

}
