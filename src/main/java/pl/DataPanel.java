package pl;

import javax.swing.*;
import java.awt.*;

/**
 * CLASS IS A TOOL BAR,WHICH COLLECT DATA
 */
class DataPanel extends JPanel {
  static JTextField rowsT, colsT, speedT, probabilityT;

  /**
   * CONSTRUCTOR
   */
  DataPanel() {
    super(new FlowLayout());
    setPreferredSize(new Dimension(230, 1));
    GridLayout layout = new GridLayout(4, 2);
    layout.setHgap(5);
    layout.setVgap(5);
    JPanel pane = new JPanel(layout);
    pane.setPreferredSize(new Dimension(210, 180));

    Font font = new Font(Font.SERIF, Font.PLAIN, 15);

    JLabel rowsL = new JLabel("Rows :", JLabel.CENTER);
    JLabel colsL = new JLabel("Cols :", JLabel.CENTER);
    JLabel speedL = new JLabel("Period :", JLabel.CENTER);
    JLabel probabilityL = new JLabel("Probability (%):", JLabel.CENTER);

    rowsL.setFont(font);
    colsL.setFont(font);
    speedL.setFont(font);
    probabilityL.setFont(font);

    rowsT = new JTextField();
    colsT = new JTextField();
    speedT = new JTextField();
    probabilityT = new JTextField();

    rowsT.setFont(font);
    colsT.setFont(font);
    speedT.setFont(font);
    probabilityT.setFont(font);

    JButton button = new JButton("OK");
    button.addActionListener(new ButtonActionAdapter());

    pane.add(rowsL);
    pane.add(rowsT);
    pane.add(colsL);
    pane.add(colsT);
    pane.add(speedL);
    pane.add(speedT);
    pane.add(probabilityL);
    pane.add(probabilityT);

    add(pane);
    add(button);

  }
}
