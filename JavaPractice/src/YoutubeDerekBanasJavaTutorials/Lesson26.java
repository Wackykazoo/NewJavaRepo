package YoutubeDerekBanasJavaTutorials;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.util.Date;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Calendar;

public class Lesson26 extends JFrame{
    JButton button1;
    JSpinner spinner1, spinner2, spinner3, spinner4;
    String outputString = "";

    public static void main(String[] args){
        new Lesson26();
    }

    public Lesson26(){
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Sixth Frame");

        JPanel thePanel = new JPanel();
        button1 = new JButton("Get Answer");
        ListenForButton buttonListener = new ListenForButton();
        button1.addActionListener(buttonListener);

        spinner1 = new JSpinner();
        spinner2 = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));

        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        spinner3 = new JSpinner(new SpinnerListModel(weekDays));
        Dimension dimension = spinner3.getPreferredSize();
        dimension.width = 90;
        spinner3.setPreferredSize(dimension);

        Date todaysDate = new Date();
        spinner4 = new JSpinner(new SpinnerDateModel(todaysDate, null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner4, "dd/MM/yy");
        spinner4.setEditor(dateEditor);

        ListenForSpinner spinnerListener = new ListenForSpinner();
        spinner4.addChangeListener(spinnerListener);

        thePanel.add(button1);
        thePanel.add(spinner1);
        thePanel.add(spinner2);
        thePanel.add(spinner3);
        thePanel.add(spinner4);

        this.add(thePanel);
        this.setVisible(true);
    }

    private class ListenForButton implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1){
                outputString += "Spinner 1 Value: " + spinner1.getValue() + "\n";
                outputString += "Spinner 2 Value: " + spinner2.getValue() + "\n";
                outputString += "Spinner 3 Value: " + spinner3.getValue() + "\n";
                outputString += "Spinner 4 Value: " + spinner4.getValue() + "\n";

                JOptionPane.showMessageDialog(Lesson26.this, outputString, "Information", JOptionPane.INFORMATION_MESSAGE);
                outputString = "";
            }
        }
    }

    private class ListenForSpinner implements ChangeListener{
        public void stateChanged(ChangeEvent e) {
            System.out.println("New Date is " + spinner4.getValue());
        }
    }
}
