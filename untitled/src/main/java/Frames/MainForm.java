package Frames;

import BaseObject.Radio;
import BaseObject.Station;
import Helper.JSONHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainForm extends JFrame {
    private JPanel rootPanel;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton addButton;
    private JButton editButton;
    private JComboBox<String> cbGenre;
    private JComboBox cbStation;
    private List<Radio> radios;
    private Radio selectedRadio;
    private Station selectedStation;

    public MainForm() {
        radios = JSONHelper.importFromJSON();

        inflateGenresComboBox();
        inflateStationsComboBox(radios.get(0));

        cbGenre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cbStation.removeAllItems();
                selectedRadio = radios.get(cbGenre.getSelectedIndex());
                inflateStationsComboBox(selectedRadio);

            }
        });

        selectedRadio = radios.get(0);
        selectedStation = radios.get(0).getStations().get(0);

        cbStation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbStation.getItemCount()>0) {
                  selectedStation = radios.get((radios.indexOf(selectedRadio))).getStations().get(cbStation.getSelectedIndex());
                }

            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateStation createStation = new CreateStation(selectedRadio);
                createStation.setVisible(true);
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateStation createStation = new CreateStation(selectedRadio, selectedStation);
                createStation.setVisible(true);
            }
        });
    }

    private void inflateGenresComboBox() {
        for (Radio r : radios)
            cbGenre.addItem(r.getGenre());
    }

    private void inflateStationsComboBox(Radio radio) {
      cbStation.removeAllItems();
        for (Station s : radio.getStations())
            cbStation.addItem(s.getName());
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("JSONHelper");
        jFrame.setContentPane(new MainForm().rootPanel);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

    }
}
