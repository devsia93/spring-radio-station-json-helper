package Frames;

import BaseObject.Radio;
import BaseObject.Station;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateStation extends JFrame {
  private JPanel rootPanel;
  private JTextField textFieldName;
  private JTextField textFieldStream;
  private JTextField textFieldImage;
  private JButton cancelButton;
  private JButton saveButton;
  private JSlider sliderCounter;
  private JLabel labelCounter;
  private Radio radio;
  private Station station;

  public CreateStation (Radio radio){
    super(radio.getGenre());
    this.radio = radio;
    initializer();
  }

  public CreateStation (Radio radio, Station station){
    super(radio.getGenre());
    this.radio = radio;
    this.station = station;
    initializer();
  }

  private void initializer(){
    setContentPane(this.rootPanel);
    pack();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);

    if (station != null){
      textFieldName.setText(station.getName());
      textFieldImage.setText(station.getImage());
      textFieldStream.setText(station.getStream());
    }

    saveButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (textFieldImage.getText().isEmpty() || textFieldImage.getText().isEmpty() || textFieldStream.getText().isEmpty()) {
          JOptionPane.showMessageDialog(getParent(),
                  "Error",
                  "You must have fill all fields!",
                  JOptionPane.WARNING_MESSAGE);
        } else {
          Station station = new Station(textFieldName.getText(), textFieldStream.getText(), textFieldImage.getText());
          //TODO save station
        }
      }
    });
  }
}
