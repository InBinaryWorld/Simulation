package pl;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * CLASS WHICH PRESENTS OBJECT EACH OF RECTANGLES IN SIMULATION PANEL
 */
class MyRectangle {
  Rectangle2D.Double rect;
  Color col;

  /**
   * CONSTRUCTOR
   */
  MyRectangle(Rectangle2D.Double rec, Color col) {
    this.rect = rec;
    this.col = col;
  }
}
