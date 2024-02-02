public class Time {
    private int hour=0;
    private int minute=0;
    public Time(int hour, int minute){
        setHour(hour);
        setMinute(minute);
    }
    public Time (int minute) {//例：130 min → 02:10
        setHour(minute/60);
        setMinute(minute%60);
    }
    public int getHour (){
        return hour;
    }
    public int getMinute (){
        return minute;
    }
    public void setHour(int hour){
        this.hour=hour;
    }
    public void setMinute(int minute){
        this.minute=minute;
    }
    public int howManyMinute() {//例：02:10 → 130 min
        int min=0;
        min=getHour()*60+getMinute();
        return min;
    }
    public Time add(Time later) {// 01:00+00:30=01:30
        int min = howManyMinute()+later.howManyMinute();
        Time added = new Time(min/60, min%60);
        return added;
    }
    public void add1(Time later) {// 01:00+00:30=01:30
        int min = howManyMinute()+later.howManyMinute();
        setHour(min/60);
        setMinute(min%60);
    }
    public Time subtract(Time before) {// 01:00-00:30=00:30 算差(恆正)
        int min = Math.abs(howManyMinute()-before.howManyMinute());
        Time subtracted = new Time(min/60, min%60);
        return subtracted;
    }
    public void subtract1(Time later) {// 01:00+00:30=01:30
        int min = howManyMinute()-later.howManyMinute();
        setHour(min/60);
        setMinute(min%60);
    }
}