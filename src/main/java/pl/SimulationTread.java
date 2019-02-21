package pl;

import java.util.Random;

/**
 * THREAD CONTROLLING ONE OF THE RECTANGLES COLORS --> INVOKE SYNCHRONIZED METHOD
 */
class SimulationTread extends Thread {
  boolean flag = true;
  private int time, firstCoordinate, secondCoordinate;
  private double probability;
  private static Random random = new Random();

  /**
   * CONSTRUCTOR
   */
  SimulationTread(int firstCoordinate, int secondCoordinate,
                  int time, double probability) {
    this.time = time;
    this.probability = probability;
    this.firstCoordinate = firstCoordinate;
    this.secondCoordinate = secondCoordinate;
  }

  /**
   * METHOD IS START WHEN THREAD IS STARTED AND INVOKES SYNCHRONIZED METHOD 'MAKE' FROM CLASS 'DOIT'
   * DECIDE WHAT SHOULD BE DONE WITH RECTANGLE AND HEAPS THE THREAD FOR A TIME
   */
  public void run() {
    while (flag) {
      if ( random.nextDouble()*100 < probability) {
        DoIt.make(false, firstCoordinate, secondCoordinate);
      } else {
        DoIt.make(true, firstCoordinate, secondCoordinate);
      }
      try {
        sleep(time);
      } catch (Exception ignored) {
      }
    }
  }
}
