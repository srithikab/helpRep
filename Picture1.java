import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
/** 
  * To pixelate by dividing area into size x size.
  * 
  * @param size Side length of square area to pixelate.
  */
public void pixelate(int size) {
    Pixel[][] pixels = this.getPixels2D();
    Picture pictureCopy = new Picture(this);
    Pixel[][] cpixels = pictureCopy.getPixels2D();
    for (int i = 0; i < pixels.length; i += size) {
        for (int j = 0; j < pixels[0].length; j += size) {
            calculateColor(pixels, cpixels, i, j, size);
        }
    }
}

private void calculateColor(Pixel[][] pixels, Pixel[][] cpixels, int xStart, int yStart, int size) {
    int rSum = 0, gSum = 0, bSum = 0, count = 0;
    for (int x = xStart; x < (xStart + size) && x < cpixels.length; x++) {
        for (int y = yStart; y < (yStart + size) && y < cpixels[0].length; y++) {
            rSum += cpixels[x][y].getRed();
            gSum += cpixels[x][y].getGreen();
            bSum += cpixels[x][y].getBlue();
            count++;
        }
    }

    if (count == 0) {
        return;
    }
    int rAvg = rSum/count;
    int gAvg = gSum/count;
    int bAvg = bSum/count;

    for (int x = xStart; x < (xStart + size) && x < pixels.length; x++) {
        for (int y = yStart; y < (yStart + size) && y < pixels[0].length; y++) {
            pixels[x][y].setColor(new Color(rAvg, gAvg, bAvg));
        }
    }
}

/** 
  * Method that blurs the picture
  * 
  * @param size Blur size, greater is more blur
  * @return Blurred picture
  */
public Picture blur(int size)
{
    Pixel[][] pixels = this.getPixels2D();
    Picture result = new Picture(pixels.length, pixels[0].length);
    Pixel[][] resultPixels = result.getPixels2D();
    for (int i = 0; i < pixels.length; i++) {
        for (int j = 0; j < pixels[0].length; j++) {
            calculateColor(resultPixels, pixels, i, j, size);
        }
    }
    return result;
}

/** 
 * Method that enhances a picture by getting average Color around
 * a pixel then applies the following formula:
 *
 * pixelColor <- 2 * currentValue - averageValue
 *
 * size is the area to sample for blur.
 *
 * @param size Larger means more area to average around pixel
 * and longer compute time.
 * @return enhanced picture
 */
public Picture enhance(int size)
{
    Pixel[][] pixels = this.getPixels2D();
    Picture result = new Picture(pixels.length, pixels[0].length);
    Pixel[][] resultPixels = result.getPixels2D();
    for (int i = 0; i < pixels.length; i++) {
        for (int j = 0; j < pixels[0].length; j++) {
            enhanceColor(resultPixels, pixels, i, j, size);
        }
    }
    return result;
}

private void enhanceColor(Pixel[][] pixels, Pixel[][] cpixels, int xStart, int yStart, int size) {
    int rSum = 0, gSum = 0, bSum = 0, count = 0;
    for (int x = xStart; x < (xStart + size) && x < cpixels.length; x++) {
        for (int y = yStart; y < (yStart + size) && y < cpixels[0].length; y++) {
            rSum += cpixels[x][y].getRed();
            gSum += cpixels[x][y].getGreen();
            bSum += cpixels[x][y].getBlue();
            count++;
        }
    }

    if (count == 0) {
        return;
    }
    int rAvg = rSum/count;
    int gAvg = gSum/count;
    int bAvg = bSum/count;

    for (int x = xStart; x < (xStart + size) && x < pixels.length; x++) {
        for (int y = yStart; y < (yStart + size) && y < pixels[0].length; y++) {
            pixels[x][y].setColor(new Color(validColorValue(cpixels[x][y].getRed() * 2 - rAvg), 
                                            validColorValue(cpixels[x][y].getGreen() * 2 - gAvg), 
                                            validColorValue(cpixels[x][y].getBlue() * 2 - bAvg)));
        }
    }
}

/**
 * Return the picture after shifting pixels to the right and wrap around to the left.
 * 
 * @return The picture that is shifted right to left
 */
public Picture wrapLeftRight()
{
    Pixel[][] pixels = this.getPixels2D();
    int width = pixels[0].length;
    Picture result = new Picture(pixels.length, pixels[0].length);
    Pixel[][] resultPixels = result.getPixels2D();
    for (int i = 0; i < pixels.length; i++) {
        for (int j = 0; j < pixels[0].length/2; j++) {
          int newColumn = (j + width / 2) % width;
          resultPixels[i][newColumn].setColor(pixels[i][j].getColor());
          resultPixels[i][j].setColor(pixels[i][newColumn].getColor());
        }
    }
    return result;
}

/**
 * Return picture by applying stair steps of shifted pixels
 *
 * @param shiftCount The number of pixels to shift to the right
 * @param steps The number of steps
 * @return The picture with pixels shifted in stair steps
 */
public Picture stairStep(int shiftCount, int steps) {
    Pixel[][] pixels = this.getPixels2D();
    int width = pixels[0].length;
    int stepSize = pixels.length/steps;
    Picture result = new Picture(pixels.length, pixels[0].length);
    Pixel[][] resultPixels = result.getPixels2D();
    for (int i = 0; i < pixels.length; i++) {
        int stepCount = i/stepSize;
        int shift = stepCount * shiftCount;
        for (int j = 0; j < pixels[0].length; j++) {
          int newColumn = (j + shift) % width;
          resultPixels[i][newColumn].setColor(pixels[i][j].getColor());
        }
    }
    return result;
}

/**
 * Creates a picture by applying distorts Gaussian shift
 * 
 * @param maxFactor Max height (shift) of curve in pixels
 * @return Liquified picture
 */
public Picture liquify(int maxHeight)
{
    Pixel[][] pixels = this.getPixels2D();
    int width = pixels[0].length;
    int height = pixels.length;
    int centerY = height / 2;  
    double bellWidth = height / 9;  // Bell curve width

    Picture result = new Picture(pixels.length, pixels[0].length);
    Pixel[][] resultPixels = result.getPixels2D();
    for (int y = 0; y < height; y++) {
        // Compute Gaussian shift for this row
        double exponent = Math.pow(y - centerY, 2) / (2.0 * Math.pow(bellWidth, 2));
        int rightShift = (int) (maxHeight * Math.exp(-exponent));

        for (int x = 0; x < width; x++) {
            // Compute new x position with wrapping
            int newX = (x + rightShift + width) % width;
            resultPixels[y][newX].setColor(pixels[y][x].getColor());
        }
    }
    return result;
}

/**
 * Creates a picture by applying distorts left and right in a sinusoidal pattern.
 * 
 * @param amplitude amplitude
 * @return wavy picture
 */
public Picture wavy(int amplitude) {
    // adjustable
    double frequency = 0.007;
    int phaseShift = 10;

    Pixel[][] pixels = this.getPixels2D();
    int width = pixels[0].length;
    Picture result = new Picture(pixels.length, width);
    Pixel[][] resultPixels = result.getPixels2D();
    for (int y = 0; y < pixels.length; y++) {
        // Compute sinusoidal shift for this row
        int shift = (int) (amplitude * Math.sin(2 * Math.PI * frequency * y + phaseShift));
        for (int x = 0; x < width; x++) {
            // Compute new x position with wrapping
            int newX = (x + shift + width) % width;

            // Copy color value to prevent reference issues
            resultPixels[y][newX].setColor(pixels[y][x].getColor());
        }
    }
    return result;
}

private int validColorValue(int value) {
    return Math.max(0, Math.min(255, value));
}
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("images/insideout.png");
    beach.explore();
    //beach.pixelate(25);
    //Picture beach2 = beach.blur(11);
    
    //Picture beach2 = beach.enhance(11);
    //Picture beach2 = beach.wrapLeftRight();
    //Picture beach2 = beach.stairStep(10, 10);
    //Picture beach2 = beach.liquify(100);
    Picture beach2 = beach.wavy(20);
    //beach.explore();
    beach2.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
