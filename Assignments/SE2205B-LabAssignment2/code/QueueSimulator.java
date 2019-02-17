import java.lang.*;

public class QueueSimulator{

  public enum Event { ARRIVAL, DEPARTURE };   // stores two constants
  private double currTime;
  private double arrivalRate;   // this is lambda
  private double serviceTime;   // this is (1/mu)
  private double timeForNextArrival;    // store the time at which the next packet wil arrive into the buffer queue
  private double timeForNextDeparture;  // keeps track of the time at which the next packet will depart from the buffer queue
  private double totalSimTime;          // denoted the total time duration for which the simulation is run for
  LinkedListQueue<Data> buffer = new LinkedListQueue<Data>();         // represents the queue in a router
  LinkedListQueue<Data> eventQueue = new LinkedListQueue<Data>();     // stores info about packets entering and exitring the buffer
  private Event e;                        // is used to store info about the next event that will occur in the simulation
  
  public double getRandTime(double arrivalRate){
    double num, time1, max=1, min=0, randNUM;
    randNUM= Math.random();
    time1= (-1/arrivalRate) * (Math.log(1-randNUM));
    //System.out.println(time1);
    return time1;
  }

  // ar - LAMBDA    servT - 1/MU      simT - RHO
  public QueueSimulator(double aR, double servT, double simT){
    arrivalRate = aR;
    serviceTime = servT;


  }
  
  public double calcAverageWaitingTime(struct Simulation * S){

    return 1;
  }
  
  public double runSimulation(double aR, double servT, doubel simT){

    return 1;
  }
}






