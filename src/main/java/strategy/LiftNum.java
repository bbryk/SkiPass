package strategy;

public enum LiftNum {
    VERYLOW(10), LOW(20), MIDDLE(50), HIGH(100);
    private int value;
    private LiftNum(int value){
        this.value =value;
    }
    public int getValue(){
        return this.value;
    }
}
