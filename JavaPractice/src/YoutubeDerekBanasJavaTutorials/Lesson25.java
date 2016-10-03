package YoutubeDerekBanasJavaTutorials;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lesson25 extends JFrame{
    JButton button1;
    String infoOnComponent = "";
    JList favoriteMovies, favoriteColors;
    DefaultListModel defaultListModel = new DefaultListModel();
    JScrollPane scoller;

    public static void main(String[] args){
        new Lesson25();
    }

    public Lesson25(){
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Fifth Frame");

        JPanel thePanel = new JPanel();
        button1 = new JButton("Get Answer");
        ListenForButton buttonListener = new ListenForButton();
        button1.addActionListener(buttonListener);

        String[] movies = {"Matrix", "Minority Report", "Big"};
        favoriteMovies = new JList(movies);
        favoriteMovies.setFixedCellHeight(30);
        favoriteMovies.setFixedCellWidth(150);
        favoriteMovies.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        /*
            All the methods for lists

            getSelectedIndex(): returns the index for the first selected item
            getSelectedIndexes(): returns ever selection in a list
            getSelectedValue(): returns the value of the first selected
            getSelectedValues(): returns an array of all values
            isSelectedIndex(): returns true if the index is selected
         */

        String[] colors = {"Black", "Blue", "White", "Green", "Orange", "Gray", "Pink"};
        for(String color : colors){
            defaultListModel.addElement(color);
        }
        defaultListModel.add(2, "Purple");
        favoriteColors = new JList(defaultListModel);
        favoriteColors.setVisibleRowCount(4);
        scoller = new JScrollPane(favoriteColors, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        favoriteColors.setFixedCellHeight(30); //IMPORTANT
        favoriteColors.setFixedCellWidth(150); //IMPORTANT

        thePanel.add(button1);
        thePanel.add(favoriteMovies);
        thePanel.add(scoller); // Add the scroller not the JList to the panel

        this.add(thePanel);
        this.setVisible(true);
    }

    private class ListenForButton implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1){
                if(defaultListModel.contains("Black")){
                    infoOnComponent += "Black is here\n";
                }

                if(!defaultListModel.isEmpty()){
                    infoOnComponent += "Isn't empty\n";
                }

                infoOnComponent += "Elements in the list " + defaultListModel.size() + "\n";
                infoOnComponent += "Last element " + defaultListModel.lastElement() + "\n";
                infoOnComponent += "First element " + defaultListModel.firstElement() + "\n";
                infoOnComponent += "In Index 1 " + defaultListModel.get(1) + "\n";
                defaultListModel.remove(0);
                defaultListModel.removeElement("Big");
                Object[] arrayOfList = defaultListModel.toArray();
                for(Object color : arrayOfList){
                    infoOnComponent += color + "\n";
                }

                JOptionPane.showMessageDialog(Lesson25.this, infoOnComponent, "Information", JOptionPane.INFORMATION_MESSAGE);
                infoOnComponent = "";
            }
        }
    }
}
