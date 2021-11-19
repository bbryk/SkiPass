package tourniquet;

import skipasssystem.SkiPassSystem;
import skipasssystem.SkiPass;

public class Tourniquet {
    private SkiPassSystem skiPassSystem;
    public Tourniquet(SkiPassSystem skiPassSystem){
        this.skiPassSystem = skiPassSystem;
    }
    public boolean checkPass(SkiPass skiPass){
        return skiPass.checkPass();
    }
}
