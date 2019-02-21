# Simulator
Simulator is an application that creates a board with colored squares and assigns a thread to each of them that changes the color of the field.

#### Applied technologies:
- Maven
- Multithreading
- Swing
### Description
Changing the color of the field can occur in two ways depending on the given probability, the mentioned probability means the chance of changing the color to a new random color, otherwise the color taken by the field will be the average of the colors of 4 adjacent fields.
Each of  thread refreshes the color assigned to it randomly every (0.5 - 1.5) * 'Period' ms.

## Features!
- Set the size of the board
- Test multiple probability and period settings

    ![ScreenShot](https://raw.githubusercontent.com/InBinaryWorld/Simulator/master/SS/SS1.png)

    ![ScreenShot](https://raw.githubusercontent.com/InBinaryWorld/Simulator/master/SS/SS2.png)
    
  
## License
MIT

**Free Software!**