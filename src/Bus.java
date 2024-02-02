import java.util.ArrayList;
public class Bus extends Transportation {
    private String name = "";
	private Route route;
    private ArrayList <Station> stop;
    private Time startOperation;
    public String getName(){
        return name;
    }
    public Bus (String name, int speed, ArrayList <Station> stop, Time startOperation, Time finishOperation, Time gap){
    	super(speed);
        this.name = name;
    	this.stop = stop;
    	this.startOperation = startOperation;
    	this.route = new Route(startOperation, finishOperation, gap);
    }    
    //判斷是否在營運時間內
    public boolean operate (Time time, Time walkTime, Station start, Station end){
        boolean op = false;
        if (time.howManyMinute()<=18*60 && 
    		time.howManyMinute()>=
        	startOperation.howManyMinute()-walkTime.howManyMinute()+
        	super.travelTime(time, start, end).howManyMinute()){
            op = true;
        }
        return op;
    }
    //判斷公車是否停靠此站
    public boolean stop (Station station){
        boolean st = false;
        for (Station stations:stop){
            if (stations.equals(station)){
                st = true;
            }
        }
        return st;
    }
    //計算等公車時間+行駛時間
    public Time travelTime (Time now, Station start, Station end){
    	Time travel = super.travelTime(now, start,end);//from transportation function:traveltime
		Time wait = new Time(0);
		ArrayList<Time> timeTableStart = route.getStationTimeTable(start, getSpeed());
		for (int i=0; i<timeTableStart.size(); i++){
			if (now.howManyMinute() - timeTableStart.get(i).howManyMinute()<=0){
				wait = timeTableStart.get(i).subtract(now);
				break;
			}
		}
		return wait.add(travel);
    }
}