package skipasssystem;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import strategy.DayType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Setter @Getter @ToString
public class SeasonSkiPass extends SkiPass {
    private int id;
    private DayType dayType = DayType.WEEKEND;
    private LocalDateTime currentDate;
    private LocalDateTime expirationDate;

    SeasonSkiPass(){
        this.id = SkiPass.id++;
        this.dayType = DayType.WEEKEND;
        this.currentDate = LocalDateTime.now();
        int year = currentDate.getYear();
        year++;

        String expiration = String.format("%d-02-28 00:00:00",year);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime expirationDate = LocalDateTime.parse(expiration, formatter);

        this.expirationDate = expirationDate;
    }


    @Override
    public boolean checkPass() {
        LocalDateTime curDate = LocalDateTime.now();
        int week_num = curDate.getDayOfWeek().getValue();
        if (curDate.isBefore(this.expirationDate) && this.isActive() && week_num>=6){
            return true;


        }
        return false;
    }
}
