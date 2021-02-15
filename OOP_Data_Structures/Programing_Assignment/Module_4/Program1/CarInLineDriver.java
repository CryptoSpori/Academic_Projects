package Mod4PA.Program1;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date: 11/01/2020
 *
 * CarInLineDriver.java
 */
public class CarInLineDriver
{


    public static void main(String[] args) {

        int maxNumOfLines = 10;
        int[] processTime = new int[maxNumOfLines];

        //Generate 10 Queues and send to simulation method for processing
        for (int i = 0; i < maxNumOfLines; i++) {
            int result = simulator(i + 1);

            //Write result to an array
            processTime[i] = result;
        }
        System.out.println();

        //Find most efficient cashier
        int minNumber = processTime[0];
        int optCashier = 0;
        for (int i = 1; i < processTime.length; i++) {
            int test = processTime[i];
            if (test < minNumber) {
                minNumber = test;
                optCashier = i + 1;
            }
        }

        //Display Results and find average
        int average = 0;
        System.out.print("Number of Cashiers: ");
        for (int i = 0; i < maxNumOfLines; i++) {
            average = average + processTime[i];
            System.out.printf(" %-6s ", (i + 1));
        }
        System.out.println();
        System.out.print("Average Time:       ");
        for (int i = 0; i < maxNumOfLines; i++) {
            System.out.printf(" %-6s ", processTime[i]);
        }
        System.out.println("");
        System.out.println("Optimum number of cashiers is: " + optCashier);
        System.out.println("Average Processing time: " + (average) / 100);

    }
    public static int simulator(int maxNumOfLines)
    {
        int minSize = 100;
        int smallLine = 0;
        int clock = 0;
        int numCarsProcessed = 100;

        //Line queues
        CarInLineQueue<CarInLine>[] lines = new CarInLineQueue[maxNumOfLines];
        int waitTime = 0;

        //Create lines
        for (int i = 0; i < maxNumOfLines; i++)
        {
            lines[i] = new CarInLineQueue<>();
        }

        //Process lines and Cars
        while (numCarsProcessed > 0)
        {
            minSize = lines[0].size();
            smallLine = 0;

            //Find smallest line and select it
            for (int i = 0; i < maxNumOfLines; i++) {
                int test = lines[i].size();

                if (test < minSize) {
                    minSize = test;
                    smallLine = i;
                }
            }

            if (clock == 0) {
                //If queue is empty, Enqueue and create new car to line and log time of arrival
                lines[smallLine].enqueue(new CarInLine(clock));
                //System.out.println("Adding to line " + smallLine);
            }
            //If queue is not empty, Enqueue and create new car to line and log time of arrival
            else if ((clock % 10) == 0) {
                lines[smallLine].enqueue(new CarInLine(clock));
               // System.out.println("Adding to line " + smallLine);
            }

            //Dequeue first car in line every 90 seconds if line is not empty
            if ((clock % 90) == 0 && clock != 0) {
                for (int i = 0; i < maxNumOfLines; i++) {
                    if (lines[i].size() > 0) {
                        if (lines[i].peekAtFront().getDepartureTime() == 0)
                            lines[i].peekAtFront().setDepartureTime(clock);
                        CarInLine temp = lines[i].dequeue();
                        if (lines[i].peekAtFront() != null) {
                            lines[i].peekAtFront().setServiceStartTime(clock);
                            lines[i].peekAtFront().setDepartureTime(clock);
                        }
                        numCarsProcessed--;
                        //Log time in queues and some
                        waitTime = waitTime + (temp.getProcessTime());

                    }
                }
            }
            clock++;
        }
        //Return average time in queue
        return waitTime / 100;
    }
}














