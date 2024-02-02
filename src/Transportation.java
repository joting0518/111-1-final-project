public class Transportation {
	private int speed;
	public Transportation (int speed) {
		this.speed = speed;
	}
	public int getSpeed() {
		return speed;
	}
	public Time travelTime(Time now, Station start, Station end){//not know Time type
		//計算一個行程會花多少時間
		Time taketime = new Time((end.getPosition()-start.getPosition())/speed);
		return taketime;
	}
}