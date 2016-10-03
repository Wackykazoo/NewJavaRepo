package YoutubeDerekBanasJavaTutorials;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

import java.awt.event.*;


public class Lesson21 extends JFrame{
    JButton button1;
    JTextField textField1;
    JTextArea textArea1;
    int buttonClicked;

    public static void main(String[] args){
        new Lesson21();
    }

    public Lesson21(){
        this.setSize(400, 400);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        int xPos = (dimension.width / 2) - (this.getWidth() / 2);
        int yPos = (dimension.height / 2) - (this.getHeight() / 2);
        this.setLocation(xPos, yPos);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Second Frame");
        JPanel thePanel = new JPanel();

        button1 = new JButton("Click Here");
        ListenForButton buttonListener = new ListenForButton();
        button1.addActionListener(buttonListener);

        textField1 = new JTextField("", 15);
        ListenForKeys keyListener = new ListenForKeys();
        textField1.addKeyListener(keyListener);

        textArea1 = new JTextArea(15, 20);
        textArea1.setText("Tracking Events\n");
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true); //Don't split words
        JScrollPane scrollBar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        thePanel.add(button1);
        thePanel.add(textField1);
        thePanel.add(scrollBar1);
        this.add(thePanel);
        ListenForWindow windowListener = new ListenForWindow();
        this.addWindowListener(windowListener);
        ListenForMouse mouseListener = new ListenForMouse();
        thePanel.addMouseListener(mouseListener);
        this.setVisible(true);
    }

    //Implement Listeners
    private class ListenForButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == button1){
                buttonClicked++;
                textArea1.append("Button Clicked: " + buttonClicked + " times\n");
                System.out.println(e.getSource().toString());
            }
        }
    }

    private class ListenForKeys implements KeyListener{
        public void keyTyped(KeyEvent e) {
            //TODO
        }

        public void keyPressed(KeyEvent e) {
            textArea1.append("Key hit: " + e.getKeyChar() + "\n");
        }

        public void keyReleased(KeyEvent e) {
            //TODO
        }
    }

    private class ListenForWindow implements WindowListener{
        public void windowOpened(WindowEvent e) {
            //Called when originally created
            textArea1.append("Window was created\n");
        }

        public void windowClosing(WindowEvent e) {
            //Called when closed from the menu
            textArea1.append("Window is closed\n");
        }

        public void windowClosed(WindowEvent e) {
            //Called when the window/frame is disposed
            //this.dispose();
        }

        public void windowIconified(WindowEvent e) {
            textArea1.append("Window is minimized\n");
        }

        public void windowDeiconified(WindowEvent e) {
            //when the Frame/window is going from minimized state to active
            textArea1.append("Window is Normal State\n");
        }

        public void windowActivated(WindowEvent e) {
            //Called when the Window/Frame is the active window
            textArea1.append("Window is active\n");
        }

        public void windowDeactivated(WindowEvent e) {
            //No longer the active window/frame, loses focus
            textArea1.append("Window is not active\n");
        }
    }

    private class ListenForMouse implements MouseListener{
        public void mouseClicked(MouseEvent e) {
            textArea1.append("Mouse Panel position: " + e.getX() + ", " + e.getY() + "\n");
            textArea1.append("Mouse Screen position: " + e.getXOnScreen() + ", " + e.getYOnScreen() + "\n");
            textArea1.append("Mouse Button: " + e.getButton() + "\n");
            textArea1.append("Mouse Clicks: " + e.getClickCount() + "\n");
        }

        public void mousePressed(MouseEvent e) {
            //mouse was pressed
        }

        public void mouseReleased(MouseEvent e) {
            //comes after pressed, means it is no longer pressed
        }

        public void mouseEntered(MouseEvent e) {
            //Mouse has entered area you put the listener in
        }

        public void mouseExited(MouseEvent e) {
            //Mouse has left the area you put the listener in
        }
    }
}
