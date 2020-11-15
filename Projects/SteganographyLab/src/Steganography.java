import javax.swing.*;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Point;

public class Steganography {
    /*
     * Clear the lower (rightmost) two bits in a pixel.
     */
    public static void clearLow(Pixel p) {
        p.setRed(p.getRed() / 4 * 4);
        p.setGreen(p.getGreen() / 4 * 4);
        p.setBlue(p.getBlue() / 4 * 4);
    }

    //Run clearLow on every pixel in param picture
    public static Picture testClearLow(Picture p) {
        Picture n = new Picture(p);

        for (int y = 0; y < p.getHeight(); y++) {
            for (int x = 0; x < p.getWidth(); x++) {
                clearLow(n.getPixel(x, y));
            }
        }
        return n;
    }

    /*
     * Set the lower 2 bits in a pixel to the highest 2 bits in c
     */
    public static void setLow(Pixel p, Color c) {
        p.setRed(p.getRed() / 4 * 4 + c.getRed() / 64 * 64 / 64);
        p.setGreen(p.getGreen() / 4 * 4 + c.getGreen() / 64 * 64 / 64);
        p.setBlue(p.getBlue() / 4 * 4 + c.getBlue() / 64 * 64 / 64);
    }

    //Run setLow for every pixel in Picture p with modifier Color c
    public static Picture testSetLow(Picture p, Color c) {
        Picture n = new Picture(p);

        for (int y = 0; y < p.getHeight(); y++) {
            for (int x = 0; x < p.getWidth(); x++) {
                setLow(n.getPixel(x, y), c);
            }
        }

        return n;
    }

    /*
     * sets the highest two bits of each pixel's colors
     * to the lowest two bits of each pixel's colors
     */
    public static Picture revealPicture(Picture hidden) {
        Picture copy = new Picture(hidden);
        Pixel[][] pixels = copy.getPixels2D();
        Pixel[][] source = hidden.getPixels2D();
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                Color col = source[r][c].getColor();
                Pixel p = copy.getPixel(c, r);

                p.setRed(col.getRed() % 64 + p.getRed() % 4 * 64);
                p.setGreen(col.getGreen() % 64 + p.getGreen() % 4 * 64);
                p.setBlue(col.getBlue() % 64 + p.getBlue() % 4 * 64);
            }
        }
        return copy;
    }

    /*
     * Determines whether secret can be hidden in source, which is
     * true if source and secret are the same dimensions.
     * @param source is not null
     * @param secret is not null
     * @return true if secret can be hidden in source, false otherwise
     */
    public static boolean canHide(Picture source, Picture secret) {
        if (secret.getHeight() <= source.getHeight()) {
            return false;
        }
        else if (secret.getWidth() <= source.getWidth()) {
            return false;
        }
        return true;
    }

    /*
     * Creates a new picture with data from secret hidden in data from source
     * @param source is not null
     * @param secret is not null
     * @return combined Picture with secret hidden in source
     * precondition: source is the same width and height as secret
     */
    public static Picture hidePicture(Picture source, Picture secret) {
        Picture n = new Picture(source);

        for (int x = 0; x < source.getWidth(); x++) {
            for (int y = 0; y < source.getHeight(); y++) {
                setLow(n.getPixel(x, y), secret.getPixel(x, y).getColor());
            }
        }
        return n;
    }

    public static Picture hidePicture(Picture source, Picture secret, int startRow, int startColumn) {
        Picture n = new Picture(source);

        for (int x = startColumn; x < startColumn + secret.getWidth(); x++) {
            for (int y = startRow; y < startRow + secret.getHeight(); y++) {
                setLow(n.getPixel(x, y), secret.getPixel(x - startColumn, y - startRow).getColor());
            }
        }
        return n;
    }

    /*
     * Returns true if the two pictures are the same
     * False otherwise
     * @param Picture p1
     * @param Picture p2
     */
    public static boolean isSame(Picture p1, Picture p2) {
        if (p1.getWidth() != p2.getWidth()) {
            return false;
        }
        if (p1.getHeight() != p2.getHeight()) {
            return false;
        }
        for (int x = 0; x < p1.getWidth(); x++) {
            for (int y = 0; y < p1.getHeight(); y++) {
                Pixel pixel1 = p1.getPixel(x, y);
                Pixel pixel2 = p2.getPixel(x, y);

                if (pixel1.getRed() != pixel2.getRed() ||
                        pixel1.getGreen() != pixel2.getGreen() ||
                        pixel1.getBlue() != pixel2.getBlue()) {

                    return false;
                }
            }
        }
        return true;
    }

    /*
     * Takes two pictures and makes a list of coordinates
     * that are are different between them
     * @param Picture p1
     * @param Picture p2
     * @return ArrayList of points.coordinates
     */
    public static ArrayList<Point> findDifferences(Picture p1, Picture p2) {
        ArrayList<Point> list = new ArrayList<>();

        if (p1.getWidth() != p2.getWidth()) {
            return list;
        }
        if (p1.getHeight() != p2.getHeight()) {
            return list;
        }
        for (int x = 0; x < p1.getWidth(); x++) {
            for (int y = 0; y < p1.getHeight(); y++) {
                Pixel pixel1 = p1.getPixel(x, y);
                Pixel pixel2 = p2.getPixel(x, y);

                if (pixel1.getRed() != pixel2.getRed() ||
                        pixel1.getGreen() != pixel2.getGreen() ||
                        pixel1.getBlue() != pixel2.getBlue()) {

                    list.add(new Point(x, y));
                }
            }
        }
        return list;
    }

    /*
     * Draw a rectangle around the part of picture that is different
     * @param picture
     * @param list of points that have been modified (created with findDifferences)
     * @return modified picture
     */
    public static Picture showDifferentArea(Picture p, ArrayList<Point> list) {
        Picture out = new Picture(p);
        //Upper left coordinates
        int minX = (int) list.get(0).getX();
        int minY = (int) list.get(0).getY();
        //Lower right coordinates
        int maxX = (int) list.get(0).getX();
        int maxY = (int) list.get(0).getY();
        //Set coordinates
        for (Point point : list) {
            if (point.getX() < minX) {
                minX = (int) point.getX();
            }
            if (point.getX() > maxX) {
                maxX = (int) point.getX();
            }
            if (point.getY() < minY) {
                minY = (int) point.getY();
            }
            if (point.getY() > maxY) {
                maxY = (int) point.getY();
            }
        }

        //Create the top of the rectangle
        for (int x = minX; x < maxX; x++) {
            Pixel pix = out.getPixel(x, minY);
            pix.setColor(Color.black);
        }
        //Create the bottom of the rectangle
        for (int x = minX; x < maxX; x++) {
            Pixel pix = out.getPixel(x, maxY);
            pix.setColor(Color.black);
        }
        //Create the left side of the rectangle
        for (int y = minY; y < maxY; y++) {
            Pixel pix = out.getPixel(minX, y);
            pix.setColor(Color.black);
        }
        //Create the right side of the rectangle
        for (int y = minY; y < maxY; y++) {
            Pixel pix = out.getPixel(maxX, y);
            pix.setColor(Color.black);
        }

        return out;
    }

    /*
     * Takes a string consisting of letters and spaces and
     * encodes the string into an arraylist of integers.
     * The integers are 1-26 for A-Z, 27 for space, and 0 for end of
     * string. The arraylist of integers is returned.
     * @param s string consisting of letters and spaces
     * @return ArrayList containing integer encoding of uppercase
     *       version of s
     */
    public static ArrayList<Integer> encodeString(String s) {
        ArrayList<Integer> result = new ArrayList<>();
        s = s.toUpperCase();
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        ArrayList<Integer> results = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i + 1).equals(" ")) {
                result.add(27);
            }
            else {
                result.add(alpha.indexOf(s.substring(i, i + 1)) + 1);
            }
        }
        result.add(0);
        return result;
    }

    /*
     * Returns the string represented by the codes arraylist.
     * 1-26 = A-Z, 27 = space
     * @param codes encoded string
     * @return decoded string
     */
    private static String decodeString(ArrayList<Integer> codes) {
        String result = "";
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < codes.size(); i++) {
            if (codes.get(i) == 27) {
                result = result + " ";
            }
            else {
                result = result + alpha.substring(codes.get(i) - 1, codes.get(i));
            }
        }
        return result;
    }

    /*
     * Given a number from 0 to 63, creates and returns a 3-element
     * int array consisting of the integers representing the
     * pairs of bits in the number from right to left.
     * @param num number to be broken up
     * @return bit pairs in number
     */
    private static int[] getBitPairs(int num) {
        int[] bits = new int[3];
        int code = num;
        for (int i = 0; i < 3; i++) {
            bits[i] = code % 4;
            code = code / 4;
        }
        return bits;
    }

    /*
     * Hide a string (must be only capital letters and spaces) in a
     * picture.
     * The string always starts in the upper left corner.
     * @param source picture to hide string in
     * @param s string to hide
     * @return picture with hidden string
     */
    public static void hideText(Picture source, String s) {
        //Throw exception if s is too large to hide in source
        //This occurs when there are more characters in s then pixels in source
        if (source.getHeight() * source.getWidth() < s.length()) {
            throw new IllegalArgumentException("Input string is too large to hide in this image");
        }

        ArrayList<Integer> encoded = encodeString(s);

        int i = 0; //Used to iterate through the encoded arraylist

        //Traverse the picture by pixel in column major order
        for (int x = 0; x < source.getWidth(); x++) {
            for (int y = 0; y < source.getHeight(); y++) {
                if (i < encoded.size()) {
                    Pixel p = source.getPixel(x, y);
                    int r = getBitPairs(encoded.get(i))[0];
                    int g = getBitPairs(encoded.get(i))[1];
                    int b = getBitPairs(encoded.get(i))[2];

                    p.setRed(r);
                    p.setGreen(g);
                    p.setBlue(b);

                    i++;
                } else {
                    break;
                }
            }
        }
    }

    /*
     * Returns a string hidden in the picture
     * @param source picture with hidden string
     * @return revealed string
     */
    public static String revealText(Picture source) {
        ArrayList<Integer> code = new ArrayList<>();

        //Traverse source in column major order
        //Convert the last two bits of each pixel to string
        //Stop when we the two bits convert to "0"
        for (int x = 0; x < source.getWidth(); x++) {
            for (int y = 0; y < source.getHeight(); y++) {
                //The last two bits are "00" which means that the message has ended
                if (source.getPixel(x, y).getRed() % 8 == 0 &&
                    source.getPixel(x, y).getGreen() % 8 == 0 &&
                    source.getPixel(x, y).getBlue() % 8 == 0) {
                    //Call the decodeString method to decode the code arraylist and return it
                    return decodeString(code);
                }
                //Take the values of the last 2 bits of pixel as int
                int r = source.getPixel(x, y).getRed() % 8;
                int g = source.getPixel(x, y).getGreen() % 8;
                int b = source.getPixel(x, y).getBlue() % 8;
                //Combine r, g, b to a single num value
                //b represents the left 2 bits, g represents the middle 2 bits, r represents right 2 bits
                int num = b * 16 + g * 4 + r;

                //Add the int to the code arraylist
                code.add(num);
            }
        }
        //There is no string hidden, or the string was
        //hidden improperly (did not contain a 0 to signify end)
        return null;
    }

    public static void main(String[] args) {
        /*
        //Activity 1, Question 8
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        Picture copy = testClearLow(beach);
        copy.explore();
        */
        /*
        //Activity 1, Question 12
        Picture beach2 = new Picture("beach.jpg");
        beach2.explore();
        Picture copy2 = testSetLow(beach2, Color.PINK);
        copy2.explore();

        //Activity 1, Question 14
        Picture copy3 = revealPicture(copy2);
        copy3.explore();
         */
        /*
        //Activity 2, Question 8-11
        //Hides a picture inside of another and then reveals it
        Picture source = new Picture("beach.jpg");
        Picture secret = new Picture("blue-mark.jpg");

        if (canHide(source, secret)) {
            Picture hidden = hidePicture(source, secret);
            hidden.explore();

            Picture revealed = revealPicture(hidden);
            revealed.explore();
        }
        */
        /*
        //Activity 3, Question 1
        //Hides two smaller pictures inside of beach and then reveals them
        Picture beach = new Picture("beach.jpg");
        Picture robot = new Picture("robot.jpg");
        Picture flower1 = new Picture("flower1.jpg");

        // these lines hide 2 pictures
        Picture hidden1 = hidePicture(beach, robot, 65, 208);
        Picture hidden2 = hidePicture(hidden1, flower1, 280, 110);
        hidden2.explore();

        Picture unhidden = revealPicture(hidden2);
        unhidden.explore();
        */
        /*
        //Activity 3, Question 2
        Picture swan = new Picture("swan.jpg");
        Picture swan2 = new Picture("swan.jpg");
        System.out.println("Swan and swan2 are the same: " + isSame(swan, swan2));
        swan = testClearLow(swan);
        System.out.println("Swan and swan2 are the same (after clearLow run on swan): " + isSame(swan, swan2));
         */
        /*
        //Activity 3, Question 3
        Picture arch = new Picture("arch.jpg");
        Picture arch2 = new Picture("arch.jpg");
        Picture koala = new Picture("koala.jpg");
        Picture robot1 = new Picture("robot.jpg");

        ArrayList<Point> pointList = findDifferences(arch, arch2);
        System.out.println("PointList after comparing two identical pictures has a size of " + pointList.size());

        pointList = findDifferences(arch, koala);
        System.out.println("PointList after comparing two different sized pictures has a size of " + pointList.size());

        arch2 = hidePicture(arch, robot1, 65, 102);
        pointList = findDifferences(arch, arch2);
        System.out.println("PointList after hiding a picture has a size of " + pointList.size());
        arch.show();
        arch2.show();
        */
        /*
        //Activity 3, Question 4
        Picture hall = new Picture("femaleLionAndHall.jpg");
        Picture robot2 = new Picture("robot.jpg");
        Picture flower2 = new Picture("flower1.jpg");
        //hide pictures
        Picture hall2 = hidePicture(hall, robot2, 50, 300);
        Picture hall3 = hidePicture(hall2, flower2, 115, 275);
        hall3.explore();
        if (!isSame(hall, hall3)) {
            Picture hall4 = showDifferentArea(hall, findDifferences(hall, hall3));
            hall4.show();
            Picture unhiddenHall3 = revealPicture(hall3);
            unhiddenHall3.show();
        }
         */

        //Activity 4, Question 4
        String message = "Hello World";
        Picture beach = new Picture("beach.jpg");
        hideText(beach, message);
        System.out.println(revealText(beach));
    }
}
