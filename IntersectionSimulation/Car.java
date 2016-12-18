/**
 * Car represents a waiting car.
 */
public class Car
{
    private int arrivalTime, departureTime;

    /**
     * Creates a new car with the specified arrival time.
     * @param arrives the arrival time
     */
    public Car(int arrives)
    {
        arrivalTime = arrives;
        departureTime = 0;
    }

    /**
     * Returns the arrival time of this car.
     * @return the arrival time
     */
    public int getArrivalTime()
    {
        return arrivalTime;
    }

    /**
     * Sets the departure time for this car.
     * @param departs the departure time
     **/
    public void setDepartureTime(int departs)
    {
        departureTime = departs;
    }
   
    /**
     * Returns the departure time of this car.
     * @return the departure time
     */
    public int getDepartureTime()
    {
        return departureTime;
    }

    /**
     * Computes and returns the total time spent by this car.
     * @return the total car time
     */
    public int totalTime()
    {
        return departureTime - arrivalTime;
    }
}
