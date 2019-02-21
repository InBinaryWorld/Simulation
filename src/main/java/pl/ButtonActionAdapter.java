package pl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * CLASS IS A ACTION LISTENER FOR THE BUTTON FROM DATA PANEL
 */
class ButtonActionAdapter implements ActionListener {

  /**
   * CONSTRUCTOR
   */
  ButtonActionAdapter() {
    super();
  }

  /**
   * ACTIONPERFORMED I DONE WHEN BUTTON IS PRESSED,
   * IT CHECK DOES THE INPUT DATA ARE CORRECT
   * AND INVOKES SIMULATION-PANEL REPLACING METHOD
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    int r, c;
    double p, s;
    try {
      s = Double.parseDouble(DataPanel.speedT.getText());
      p = Double.parseDouble(DataPanel.probabilityT.getText());
      r = Integer.parseInt(DataPanel.rowsT.getText());
      c = Integer.parseInt(DataPanel.colsT.getText());

      if (s > 0 && p >= 0 && p <= 100 && r > 0 && c > 0)
        MyFrame.simPane.replace(r, c, s, p);
    } catch (Exception ignored) {
    }

  }
}
