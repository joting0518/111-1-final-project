import java.util.ArrayList;

public class Route {
    private ArrayList <Time> timeTable0 = new ArrayList <Time>();
    private Station departStation = new Station("A", 0);
    public Route (Time startOperation, Time finishOperation, Time gap){
    	departStation = new Station("A", 0);
    	Time first = startOperation;
        timeTable0.add(first);
        int comeTimes = startOperation.subtract(finishOperation).howManyMinute()/gap.howManyMinute();
        for(int i=0; i<comeTimes; i++){
        	Time addable = new Time(gap.howManyMinute()*(i+1));
            timeTable0.add(first.add(addable));
        }
    }
//回傳request的公車時刻表(adjust不要寫死)
    public ArrayList<Time> getStationTimeTable (Station station, int speed){
    	int adjust = (station.getPosition()-departStation.getPosition())/speed;
        ArrayList<Time> request = new ArrayList<Time>();
        for(Time t:timeTable0){
            request.add(t.add(new Time(adjust)));
        }
        return request;
    }
}