package skipasssystem;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import strategy.DayNum;
import strategy.DayType;

import java.time.LocalDateTime;

@Setter @Getter @ToString
public class DaySkiPass extends SkiPass {
    private int id;
    private DayNum dayNum;
    private DayType dayType;
    private LocalDateTime currentDate;
    private LocalDateTime expirationDate;
    private DaySkiPass(){}
    DaySkiPass(DayNum dayNum, DayType dayType){
        this.id = SkiPass.id++;
        this.dayNum = dayNum;
        this.dayType = dayType;
        this.currentDate = LocalDateTime.now();
        LocalDateTime expiration = this.currentDate.plusDays(dayNum.getValue());
        this.expirationDate = expiration;
    }

    @Override
    public boolean checkPass() {
        LocalDateTime curDate  = LocalDateTime.now();
        int week_num = curDate.getDayOfWeek().getValue();
        if (curDate.isBefore(this.expirationDate) && this.isActive() ){
            if (this.dayType.equals(DayType.WEEKEND) && week_num>=6){
                return true;

            }else if (this.dayType.equals(DayType.WEEKDAY) && week_num<=5){
                return true;
            }
        }
        return false;
    }
//    public DaySkiPass createPassFactory(DayNum dayNum, DayType dayType){
//
//        return new DaySkiPass(dayNum, dayType);
//
//    }
}
