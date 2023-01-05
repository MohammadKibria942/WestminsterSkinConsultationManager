package w1824056MohammadKibriaCoursework;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class VeiwConsultationGUI extends JFrame implements ActionListener{
    ArrayList<Consultation> list;
    JButton backButton = new JButton("Go Back");
    
    public VeiwConsultationGUI(ArrayList<Consultation> list) {
        this.list = list;
        
        JTable consultationTable;
        ConsultationTableModel tableModel;

        tableModel = new ConsultationTableModel(list);//creates a table
        consultationTable = new JTable(tableModel);//uses a table model

        setBounds(0, 0, 1300, 600);//boounds of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        consultationTable.setAutoCreateRowSorter(true);//the automatic sorter
        
        backButton.setBounds(1000,500,160,50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        this.add(backButton);

        JScrollPane scrollPane = new JScrollPane(consultationTable);//add the table to the panel
        scrollPane.setPreferredSize(new Dimension(1000, 400));
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        
        add(panel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {//if a button is pressed
        if (evt.getSource() == backButton) {
            this.dispose();
            MainMenuGUI frame5 = new MainMenuGUI();//go back to main menu
        }
    }
}
