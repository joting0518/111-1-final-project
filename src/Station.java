public class Station {
	String name;//站的名稱
	int position;//一維座標(eg.station A 在0, station B在5…依此類推),單位m
	public Station(String name, int position) {
		this.name = name;
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public int getPosition() {
		return position;
	}
}