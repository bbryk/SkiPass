package skipasssystem;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import strategy.DayType;
import strategy.LiftNum;

import java.time.LocalDateTime;

@Setter @Getter @ToString
public class LiftSkiPass extends SkiPass {
    private int id;
    private LiftNum liftNum;
    private DayType dayType;
    private  int currentNum;
    private LiftSkiPass(){}
    LiftSkiPass(LiftNum liftNum, DayType dayType){
        this.id = SkiPass.id++;
        this.liftNum = liftNum;
        this.dayType = dayType;
        this.currentNum = 0;


    }
//    public LiftSkiPass createPassFactory(LiftNum liftNum, DayType dayType){
//
//        return new LiftSkiPass(liftNum, dayType);
//
//    }

    @Override
    public boolean checkPass() {
        LocalDateTime curDate  = LocalDateTime.now();
        int week_num = curDate.getDayOfWeek().getValue();

        if (this.currentNum < this.liftNum.getValue() && this.isActive()){
            if (this.dayType.equals(DayType.WEEKEND) && week_num>=6){
                this.currentNum++;
                return true;

            }else if (this.dayType.equals(DayType.WEEKDAY) && week_num<=5){
                this.currentNum++;
                return true;
            }


        }
        return false;
    }
}
