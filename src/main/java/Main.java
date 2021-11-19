import skipasssystem.SkiPass;
import skipasssystem.SkiPassSystem;
import strategy.DayNum;
import strategy.DayType;
import strategy.LiftNum;
import tourniquet.Tourniquet;



public class Main {
    public static void main(String[] args){
        SkiPassSystem sys = new SkiPassSystem();
        Tourniquet tourniquet = new Tourniquet(sys);
        SkiPass daysPass = sys.createPass(DayNum.HIGH, DayType.WEEKEND);
        SkiPass liftPass = sys.createPass(LiftNum.LOW, DayType.WEEKDAY);
        SkiPass seasonPass = sys.createPass();

        System.out.println(tourniquet.checkPass(liftPass));
        System.out.println(tourniquet.checkPass(daysPass));
        System.out.println(tourniquet.checkPass(seasonPass));
        System.out.println(daysPass);
        System.out.println(liftPass);
        System.out.println(seasonPass);

    }
}
