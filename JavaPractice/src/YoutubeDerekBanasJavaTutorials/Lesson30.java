package YoutubeDerekBanasJavaTutorials;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class Lesson30 extends JFrame {
    private JLabel nameLabel, streetLabel, stateLabel, dateLabel, ageLabel;
    private JTextField nameText, streetText;
    private JComboBox stateList;
    private JSpinner dateSpinner;
    private JSlider ageSlider;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private ButtonGroup sexGroup;
    private JTextArea aboutYou;

    public static void main(String[] args){
        new Lesson30();
    }

    public Lesson30(){
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Random Layout");

        JPanel thePanel = new JPanel();
        thePanel.setLayout(new GridBagLayout());

        nameLabel = new JLabel("   Name:");
        addComponent(thePanel, nameLabel, 0, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        nameText = new JTextField(30);
        addComponent(thePanel, nameText, 1, 0, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        streetLabel = new JLabel(" Street:");
        addComponent(thePanel, streetLabel, 0, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        streetText = new JTextField(30);
        addComponent(thePanel, streetText, 1, 1, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        Box sexBox = Box.createVerticalBox();
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        sexGroup = new ButtonGroup(); //ButtonGroup declared up top. This is done so only 1 radio button can be selected
        sexGroup.add(maleRadioButton);
        sexGroup.add(femaleRadioButton);
        sexBox.add(maleRadioButton);
        sexBox.add(femaleRadioButton);
        sexBox.setBorder(BorderFactory.createTitledBorder("Sex"));
        addComponent(thePanel, sexBox, 3, 0, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        JPanel statePanel = new JPanel();
        statePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));

        stateLabel = new JLabel("State: ");
        statePanel.add(stateLabel);

        String[] states = {"PA", "NY", "OH", "WV"};
        stateList = new JComboBox(states);
        statePanel.add(stateList);

        dateLabel = new JLabel("Appointment Date");
        statePanel.add(dateLabel);
        Date todaysDate = new Date();
        dateSpinner = new JSpinner(new SpinnerDateModel(todaysDate, null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yy");
        dateSpinner.setEditor(dateEditor);
        statePanel.add(dateSpinner);

        ageLabel = new JLabel("Age: 50");
        statePanel.add(ageLabel);
        ageSlider = new JSlider(1, 99, 50);
        ListenForSlider listenForSlider = new ListenForSlider();
        ageSlider.addChangeListener(listenForSlider);
        statePanel.add(ageSlider);

        addComponent(thePanel, statePanel, 1, 2, 5, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

        JCheckBox morningCheck, afternoonCheck, eveningCheck;
        Box optionBox = Box.createVerticalBox();
        morningCheck = new JCheckBox("Morning");
        afternoonCheck = new JCheckBox("Afternoon");
        eveningCheck = new JCheckBox("Evening");
        optionBox.add(morningCheck);
        optionBox.add(afternoonCheck);
        optionBox.add(eveningCheck);
        optionBox.setBorder(BorderFactory.createTitledBorder("Time of Day"));
        addComponent(thePanel, optionBox, 1, 3, 2, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE);

        aboutYou = new JTextArea(6, 40);
        aboutYou.setText("Tell us about you");
        aboutYou.setLineWrap(true);
        aboutYou.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(aboutYou, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        addComponent(thePanel, scrollPane, 2, 3, 3, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

        this.add(thePanel);
        this.pack();
        this.setVisible(true);
    }

    private void addComponent(JPanel thePanel, JComponent component, int xPosition, int yPosition, int componentWidth, int componentHeight, int place, int stretch){
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridx = xPosition;
        gridBagConstraints.gridy = yPosition;
        gridBagConstraints.gridwidth = componentWidth;
        gridBagConstraints.gridheight = componentHeight;
        gridBagConstraints.weightx = 100;
        gridBagConstraints.weighty = 100;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        gridBagConstraints.anchor = place;
        gridBagConstraints.fill = stretch;

        thePanel.add(component, gridBagConstraints);
    }

    private class ListenForSlider implements ChangeListener{
        public void stateChanged(ChangeEvent e) {
            if(e.getSource() == ageSlider){
                ageLabel.setText("Age: " + ageSlider.getValue());
            }
        }
    }
}
