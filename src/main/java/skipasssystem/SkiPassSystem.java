package skipasssystem;

import strategy.DayNum;
import strategy.DayType;
import strategy.LiftNum;

import java.util.ArrayList;

public class SkiPassSystem {
    private ArrayList<SkiPass> register = new ArrayList<SkiPass>();
    public boolean addPass(SkiPass skiPass){
        this.register.add(skiPass);
        return true;
    }
    public void blockPass(SkiPass skiPass){

        skiPass.setActive(false);
    }

    public SkiPass createPass(DayNum dayNum, DayType dayType){
        return new DaySkiPass(dayNum,dayType);
    }
    public SkiPass createPass(){
        return new SeasonSkiPass();
    }
    public SkiPass createPass(LiftNum liftNum, DayType dayType){
        return new LiftSkiPass(liftNum, dayType);
    }
}
