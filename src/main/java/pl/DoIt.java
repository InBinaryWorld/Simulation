package pl;

import java.awt.*;
import java.util.Random;

/**
 * CLASS WHICH HAS SYNCHRONIZED METHOD IS RESPONSIBLE FOR SWAPPING COLORS OF RECTANGLES
 */
final class DoIt {
  private static Random random;
  private static MyFrame f;
  private static MyRectangle[][] rectangle;

  /**
   * CONSTRUCTOR
   */
  private DoIt() {
  }

  static void configure(MyFrame f, MyRectangle[][] rectangle) {
    DoIt.rectangle = rectangle;
    random = new Random();
    DoIt.f = f;
  }


  /**
   * METHOD DEPENDS ON PROBABILITY AND IS CHANGING COLORS OF RECTANGLE ON RANDOM OR AVERAGE OF NEIGHBORING COLORS
   */
  synchronized static void make(boolean additionColors,
                                int firstCoordinate, int secondCoordinate) {
    int r = 0;
    int g = 0;
    int b = 0;
    int tmp;
    MyRectangle rect = rectangle[firstCoordinate][secondCoordinate];
    if (additionColors) {
      if (firstCoordinate - 1 < 0)
        tmp = rectangle.length - 1;
      else
        tmp = firstCoordinate - 1;

      r += rectangle[tmp][secondCoordinate].col.getRed();
      g += rectangle[tmp][secondCoordinate].col.getGreen();
      b += rectangle[tmp][secondCoordinate].col.getBlue();


      if (firstCoordinate + 1 == rectangle.length)
        tmp = 0;
      else
        tmp = firstCoordinate + 1;

      r += rectangle[tmp][secondCoordinate].col.getRed();
      g += rectangle[tmp][secondCoordinate].col.getGreen();
      b += rectangle[tmp][secondCoordinate].col.getBlue();

      if (secondCoordinate + 1 == rectangle[0].length)
        tmp = 0;
      else
        tmp = secondCoordinate + 1;

      r += rectangle[firstCoordinate][tmp].col.getRed();
      g += rectangle[firstCoordinate][tmp].col.getGreen();
      b += rectangle[firstCoordinate][tmp].col.getBlue();

      if (secondCoordinate - 1 < 0)
        tmp = rectangle[0].length - 1;
      else
        tmp = secondCoordinate - 1;

      r += rectangle[firstCoordinate][tmp].col.getRed();
      g += rectangle[firstCoordinate][tmp].col.getGreen();
      b += rectangle[firstCoordinate][tmp].col.getBlue();

      rect.col = new Color(r / 4, g / 4, b / 4);
    } else {
      rect.col = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
    f.repaint();
  }
}
