package fr.kinstone.core.rank;

import fr.kinstone.core.module.Module;
import lombok.Getter;

public class RankManager extends Module {

    @Getter
    private RankManager rankManager;

    @Override
    public void moduleEnable() {

        rankManager = this;

       registerCommand(new RankCommand());

    }

    @Override
    public void moduleDisable() {

    }
}
