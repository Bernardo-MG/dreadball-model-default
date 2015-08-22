package com.wandrell.tabletop.dreadball.testing.model.test.unit.team.exception;

import org.mockito.Mockito;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.faction.TeamType;
import com.wandrell.tabletop.dreadball.model.team.AdvancementTeam;
import com.wandrell.tabletop.dreadball.model.team.DefaultAdvancementTeam;
import com.wandrell.tabletop.dreadball.model.team.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.AdvancementUnit;

public final class TestExceptionPlayersDefaultAdvancementTeam {

    private AdvancementTeam team;

    public TestExceptionPlayersDefaultAdvancementTeam() {
        super();
    }

    @SuppressWarnings("unchecked")
    @BeforeClass
    public final void initialize() {
        final TeamType type;
        final TeamValorationCalculator<AdvancementTeam> valorator;

        valorator = Mockito.mock(TeamValorationCalculator.class);
        type = Mockito.mock(TeamType.class);

        this.team = new DefaultAdvancementTeam("team_name", type, valorator);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAddPlayer_Existing() {
        final AdvancementUnit player;

        player = Mockito.mock(AdvancementUnit.class);

        team.addPlayer(player, 0);
        team.addPlayer(player, 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAddPlayer_NegativePos() {
        final AdvancementUnit player;

        player = Mockito.mock(AdvancementUnit.class);

        team.addPlayer(player, -1);
    }

}
