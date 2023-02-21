package CommandInterface.Commands;

import models.TurnModel;

public interface Command {
    boolean argCheck(String[] pr);
    void apply(TurnModel model);
}
