import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // return the number of points in a Shape s
        int numPoints = 0;
        for (Point currPoint: s.getPoints()){
            numPoints += 1;
        }
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        // Return the average side length of Shape s
        double avgLength = getPerimeter(s) / getNumPoints(s);
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        // Return largest side from Shape s
        Point prevPt = s.getLastPoint();
        double largestSide = 0;
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Check if currDist > largestSide
            if (currDist > largestSide) {
                // Update largestSide if so.
                largestSide = currDist; 
            }
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Returns the largest X value in a shape
        // Initialize with last point X - to avoid initializing with a
        // particular X. Not all shapes will have points > 0.
        double largestX = s.getLastPoint().getX();
        for (Point p: s.getPoints()){
            double currX = p.getX();
            if (currX > largestX){
                largestX = currX;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Return largest perimeter from a group of files
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currentPerim = getPerimeter(s);
            if (currentPerim > largestPerim) {
                largestPerim = currentPerim;
            }
        }
        return largestPerim;
    }

    public File getFileWithLargestPerimeter() {
        // Return the file with the largest perimeter
        DirectoryResource dr = new DirectoryResource();
        File largestPerimFile = null;
        double largestPerim = 0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currentPerim = getPerimeter(s);
            if (currentPerim > largestPerim) {
                largestPerim = currentPerim;
                largestPerimFile = f;
            }
        }
        return largestPerimFile;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        
        // Test getPerimeter
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        
        // Test getNumPoints
        int numPoints = getNumPoints(s);
        System.out.println("number of points = " + numPoints);
        
        // Test getAverageLength
        double averageLength = getAverageLength(s);
        System.out.println("average side length = " + averageLength);
        
        // Test getLargestSide
        double largestSide = getLargestSide(s);
        System.out.println("largest side length = " + largestSide);
        
        // Test getLargestX
        double largestX = getLargestX(s);
        System.out.println("largest X coordinate = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Test getLargestPerimeterMultipleFiles
        double largestPerim = getLargestPerimeterMultipleFiles();
        System.out.println("largest perimeter = " + largestPerim);
    }

    public void testFileWithLargestPerimeter() {
        // Test getFileWithLargestPerimeter
        File largestPerimFile = getFileWithLargestPerimeter();
        System.out.println("largest perimeter file = " + largestPerimFile.getName());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
