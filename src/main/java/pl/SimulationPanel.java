package pl;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 * CLASS PRESENTS GRAPHICS INTERPRETATION OF RECTANGLES AND CHANGES ON THEM
 */
class SimulationPanel extends JPanel {
  private MyFrame f;
  private int rows, cols;
  private double recSize;
  private MyRectangle[][] rectangles;
  private SimulationTread[][] simulationTreads;
  private Rectangle simPanBounds = new Rectangle(980, 640);

  /**
   * METHOD IS REPLACING AND RESET SIMULATION-PANEL
   */
  void replace(int r, int c, double s, double p) {
    f.invalidate();
    f.remove(MyFrame.simPane);
    for (SimulationTread[] stTab : simulationTreads) {
      for (SimulationTread st : stTab) {
        st.flag = false;
      }
    }
    MyFrame.simPane = new SimulationPanel(f, r, c, p, s);
    f.add(MyFrame.simPane,BorderLayout.CENTER);
    f.validate();
    f.repaint();
  }

  /**
   * CONSTRUCTOR, SET RECTANGLES NUMBER AND DIMENSIONS, SET THREAD NUMBER AND START THEM
   */
  SimulationPanel(MyFrame f, int rows, int cols, double probability, double speed) {
    super();
    this.f = f;
    this.rows = rows;
    this.cols = cols;
    setDoubleBuffered(true);
    Random random = new Random();
    rectangles = new MyRectangle[rows][cols];
    DoIt.configure(f, rectangles);

    recSize = Math.min(((double) simPanBounds.width) / cols, ((double) simPanBounds.height) / rows);
    simulationTreads = new SimulationTread[rows][cols];
    for (int n = 0; n < rows; n++) {
      for (int m = 0; m < cols; m++) {
        rectangles[n][m] = new MyRectangle(new Rectangle2D.Double(m * recSize, n * recSize, recSize, recSize),
                new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        simulationTreads[n][m] = new SimulationTread(n, m, (int) ((0.5 + random.nextDouble()) * speed),
                probability);
      }
    }
    for (int n = 0; n < rows; n++) {
      for (int m = 0; m < cols; m++) {
        simulationTreads[n][m].start();
      }
    }
  }

  /**
   * SCALING ALL RECTANGLES DEPENDING ON THE WINDOW SIZE
   */
  private void graduation() {
    simPanBounds = getBounds();
    recSize = Math.min(((double) simPanBounds.width) / cols, ((double) simPanBounds.height) / rows);
    for (int n = 0; n < rows; n++) {
      for (int m = 0; m < cols; m++) {
        rectangles[n][m].rect.setRect(m * recSize, n * recSize, recSize, recSize);
      }
    }
    f.repaint();
  }

  /**
   * METHOD IS OVERRIDE AND PAINT SIMULATION-PANEL, DRAW AND FILL TAB OF RECTANGLES
   */
  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    if (!simPanBounds.equals(getBounds())) {
      graduation();
    }
    for (int n = 0; n < rows; n++) {
      for (int m = 0; m < cols; m++) {
        g2d.setColor(rectangles[n][m].col);
        g2d.fill(rectangles[n][m].rect);
      }
    }
  }
}
