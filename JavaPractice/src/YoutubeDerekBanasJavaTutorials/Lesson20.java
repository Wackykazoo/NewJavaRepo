package YoutubeDerekBanasJavaTutorials;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

public class Lesson20 extends JFrame{
    public static void main(String[] args){
        new Lesson20();
    }

    public Lesson20(){
        this.setSize(400, 400); //Make a window 400 by 400
        Toolkit toolKit = Toolkit.getDefaultToolkit(); //make a toolkit object to ask questions to OS
        Dimension dimension = toolKit.getScreenSize(); //Get dimensions of screen from OS

        //this.setLocationRelativeTo(null); //Centers window relative to the screen
        int xPos = (dimension.width / 2) - (this.getWidth() / 2);
        int yPos = (dimension.height /2) - (this.getHeight() /2);
        this.setLocation(xPos, yPos); //Also centers windows to the middle of the screen

        this.setTitle("My First Frame"); //name or title that is at the top bar of the window created

        JPanel thePanel = new JPanel();

        JLabel label1 = new JLabel("Tell me something");
        label1.setText("New Text");
        label1.setToolTipText("Doesn't do anything");

        JButton button1 = new JButton("Send");
        //button1.setBorderPainted(false);
        //button1.setContentAreaFilled(false);
        //button1.setText("New Button");
        button1.setToolTipText("It's a button");

        JTextField textField1 = new JTextField("Type here", 15);
        textField1.setColumns(10);
        textField1.setText("Type again");
        textField1.setToolTipText("It's a field");

        JTextArea textArea1 = new JTextArea(15, 20);
        textArea1.setText("Just a whole bunch of text that is important \n");
        textArea1.setLineWrap(true); //when it gets to end the of the line, go to second automatically
        textArea1.setWrapStyleWord(true);
        int numberOfLines = textArea1.getLineCount();
        textArea1.append(" number of lines: " + numberOfLines);
        JScrollPane scrollBar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        thePanel.add(label1);
        thePanel.add(button1);
        thePanel.add(textField1);
        thePanel.add(textArea1);
        this.add(thePanel);

        this.setResizable(false); //don't change the window size of the window created. true by default
        this.setVisible(true); // Make the window visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //destroy windows
        textArea1.requestFocus();
    }
}
