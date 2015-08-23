package com.wandrell.tabletop.dreadball.testing.model.test.unit.team;

import java.util.LinkedHashMap;
import java.util.Map;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.team.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.Unit;

public final class TestSponsorTeamValorationCalculator {

    private TeamValorationCalculator<SponsorTeam> valorator;

    public TestSponsorTeamValorationCalculator() {
        super();
    }

    @BeforeClass
    public final void initialize() {
        valorator = new SponsorTeamValorationCalculator(1, 2, 3, 4, 5, 6);
    }

    @Test
    public final void testValoration() {
        final SponsorTeam team;
        final Map<Integer, Unit> players;
        final Unit player;

        team = Mockito.mock(SponsorTeam.class);
        Mockito.when(team.getDice()).thenReturn(2);
        Mockito.when(team.getSabotageCards()).thenReturn(4);
        Mockito.when(team.getSpecialMoveCards()).thenReturn(5);
        Mockito.when(team.getCheerleaders()).thenReturn(1);
        Mockito.when(team.getWagers()).thenReturn(6);
        Mockito.when(team.getMediBots()).thenReturn(3);

        players = new LinkedHashMap<>();
        player = Mockito.mock(Unit.class);
        Mockito.when(player.getCost()).thenReturn(10);
        players.put(1, player);

        Mockito.when(team.getPlayers()).thenReturn(players);

        Assert.assertEquals(valorator.getValoration(team), (Integer) 87);
    }

}
