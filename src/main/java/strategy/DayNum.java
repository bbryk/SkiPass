package strategy;

public enum DayNum {
    LOW(1), MIDDLE(2), HIGH(5);
    private int value;
    private DayNum(int value){
        this.value =value;
    }
    public int getValue(){
        return this.value;
    }
}
