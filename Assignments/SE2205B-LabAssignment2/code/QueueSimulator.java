import java.lang.*;

public class QueueSimulator
{
  public enum Event { ARRIVAL, DEPARTURE };     // stores two constants
  private double currTime;
  private double arrivalRate;                   // this is lambda
  private double serviceTime;                   // this is (1/mu)
  private double timeForNextArrival;            // store the time at which the next packet wil arrive into the buffer queue
  private double timeForNextDeparture;          // keeps track of the time at which the next packet will depart from the buffer queue
  private double totalSimTime;                  // denoted the total time duration for which the simulation is run for
  LinkedListQueue<Data> buffer = new LinkedListQueue<Data>();         // represents the queue in a router
  LinkedListQueue<Data> eventQueue = new LinkedListQueue<Data>();     // stores infzo about packets entering and exitring the buffer
  private Event e;                              // is used to store info about the next event that will occur in the simulation
  
  public double getRandTime(double arrivalRate)
  {
    double num, time1, max=1, min=0, randNUM;
    randNUM= Math.random();
    time1= (-1/arrivalRate) * (Math.log(1-randNUM));
    //System.out.println(time1);
    return time1;
  }

  // ar - LAMBDA    servT - 1/MU      simT - RHO
  public QueueSimulator(double aR, double servT, double simT)
  {
    arrivalRate = aR;
    serviceTime = servT;
    totalSimTime = simT;
  }
  
  public double calcAverageWaitingTime()
  {
    int sz = 0;
    double time = 0;
    double returnValue;

    while(!eventQueue.isEmpty())
    {
      Data data = eventQueue.dequeue();
      time += data.getDepartureTime() - data.getArrivalTime();
      sz++;
    }

    returnValue = time/sz;

    return returnValue;
  }
  
  public double runSimulation()
  {
    currTime = 0;
    timeForNextArrival = getRandTime(arrivalRate);
    timeForNextDeparture = serviceTime + timeForNextArrival;

    while(currTime < totalSimTime)
    {
      if(timeForNextArrival < timeForNextDeparture || buffer.isEmpty())
      {
        currTime = currTime + timeForNextArrival;

        Data temp = new Data();

        temp.setArrivalTime(currTime);

        buffer.enqueue(temp);

        timeForNextDeparture = timeForNextDeparture - timeForNextArrival;
        timeForNextArrival = getRandTime(arrivalRate);
      }
      else
      {
        currTime = currTime + timeForNextDeparture;

        Data temp = buffer.dequeue();

        temp.setDepartureTime(currTime);

        eventQueue.enqueue(temp);

        timeForNextArrival = timeForNextArrival - timeForNextDeparture;

        if(buffer.isEmpty())
        {
          timeForNextDeparture = timeForNextArrival + serviceTime;
        }
        else
        {
          timeForNextDeparture = serviceTime;
        }
      }
    }

    return calcAverageWaitingTime();
  }
}