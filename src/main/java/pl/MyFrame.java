package pl;

import javax.swing.*;
import java.awt.*;

/**
 * CLASS IS A MAIN FRAME OF PROGRAM
 */
class MyFrame extends JFrame {
  static SimulationPanel simPane;

  /**
   * CONSTRUCTOR
   */
  private MyFrame() {
    super();
    setTitle("Simulation");
    setPreferredSize(new Dimension(1200, 675));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    simPane = new SimulationPanel(this, 10, 15, 50, 1000);
    add(simPane, BorderLayout.CENTER);
    add(new DataPanel(), BorderLayout.EAST);
    pack();
  }

  public static void main(String args[]) {
    MyFrame f = new MyFrame();
    f.setVisible(true);
  }
}
