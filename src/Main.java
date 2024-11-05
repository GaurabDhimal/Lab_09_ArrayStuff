import java.util.Random;
import java.util.Scanner;

public class Main
{

    static int[] dataPoints = new int[100];
    static Random gen = new Random();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        dataSetup();
        showData();
        
        int sum = calculateSum(dataPoints);
        double average = (double) sum / dataPoints.length;

        System.out.println("The sum of the values is: " + sum);
        System.out.println("The average of the values is: " + average);
        
        findAllInstances();
        
        findFirstInstance();
        
        findMinMax();
    }

    // Data points 1-100
    private static void dataSetup()
    {
        for (int x = 0; x < dataPoints.length; x++) 
            dataPoints[x] = gen.nextInt(100) + 1;
    }

    // Display data points
    private static void showData() {
        System.out.println("Array values: ");
        for (int x = 0; x < dataPoints.length; x++)
            System.out.print(dataPoints[x] + " | ");
        System.out.println();
    }

    // Sum of array values
    private static int calculateSum(int[] data)
    {
        int sum = 0;
        for (int value : data)
            sum += value;
        return sum;
    }

    // findAll
    private static void findAllInstances()
    {
        int target = SafeInput.getRangedInt(in, "Enter target value to find all instances", 1, 100);
        System.out.println("\nFind all instances of target (" + target + "):");
        boolean found = false;
        for (int x = 0; x < dataPoints.length; x++)
        {
            if (dataPoints[x] == target)
            {
                System.out.println("Found target (" + target + ") at location: " + (x + 1)); // 1-based instead of 0-based
                found = true;
            }
        }
        if (!found)
            System.out.println("Target " + target + " was not found.");
    }

    // findFirst
    private static void findFirstInstance()
    {
        int target = SafeInput.getRangedInt(in, "Enter target value to find the first instance", 1, 100);
        System.out.println("\nFind first instance of target (" + target + "):");
        int foundIndex = -1;
        for (int x = 0; x < dataPoints.length; x++)
        {
            if (dataPoints[x] == target)
            {
                foundIndex = x;
                break;
            }
        }
        if (foundIndex == -1)
            System.out.println("Target " + target + " was not found.");
         else
            System.out.println("First Instance of target is at location: " + (foundIndex + 1)); // 1-based
    }

    // Min Max values
    private static void findMinMax()
    {
        int maxVal = dataPoints[0];
        int minVal = dataPoints[0];
        int maxIndex = 0;
        int minIndex = 0;
        
        for (int v = 1; v < dataPoints.length; v++)
        {
            if (dataPoints[v] > maxVal)
            {
                maxVal = dataPoints[v];
                maxIndex = v;
            }
            if (dataPoints[v] < minVal)
            {
                minVal = dataPoints[v];
                minIndex = v;
            }
        }

        // Display min
        System.out.println("Minimum value is " + minVal + " found at indices: ");
        for (int i = 0; i < dataPoints.length; i++)
        {
            if (dataPoints[i] == minVal)
                System.out.print((i + 1) + " ");
        }
        System.out.println();

        // Display max
        System.out.println("Maximum value is " + maxVal + " found at indices: ");
        for (int i = 0; i < dataPoints.length; i++)
        {
            if (dataPoints[i] == maxVal)
                System.out.print((i + 1) + " ");
        }
        System.out.println();
    }

    private static double calculateAverage(double[] values)
    {
        double sum = 0.0;
        for (double value : values)
            sum += value;
        return sum/values.length;
    }
}
