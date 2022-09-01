package misc;

import java.util.HashMap;
import java.util.Scanner;

public class TollCount
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        HashMap<String, Event> vehicleIdToEvent = new HashMap<>();
        long finalTollCost = 0L;
        while(T-- > 0) {
            String entryOrExit = sc.next();
            String vehicleId = sc.next();
            int time = sc.nextInt();
            if(!vehicleIdToEvent.containsKey(vehicleId)) {
                vehicleIdToEvent.put(vehicleId, new Event(entryOrExit, vehicleId, time));
            } else {
                //vehicle with this vehicleId is already entered the parking lot and the current event is leaving event
                //get exitTime
                int exitTime = time;
                int enteredTime = vehicleIdToEvent.get(vehicleId).noOfMinutesFrom12AM;
                int hoursSpent= Math.round((exitTime - enteredTime) / 60.0F);
                if(hoursSpent > 1) {
                    hoursSpent -= 1;
                    finalTollCost += 60 + (hoursSpent * 30);
                } else if(hoursSpent == 1) {
                    finalTollCost += 60;
                }
            }
        }
        System.out.println(finalTollCost);
    }
}
class Event {
    String entryOrExit;
    String vehicleId;
    int noOfMinutesFrom12AM;

    public Event(String entryOrExit, String vehicleId, int noOfMinutesFrom12AM)
    {
        this.entryOrExit = entryOrExit;
        this.vehicleId = vehicleId;
        this.noOfMinutesFrom12AM = noOfMinutesFrom12AM;
    }
}
