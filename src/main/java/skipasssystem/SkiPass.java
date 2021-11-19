package skipasssystem;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
@Setter @Getter @ToString
public abstract class SkiPass {
    static int id = 1;
    private boolean isActive = true;
    public abstract boolean checkPass();

}
