package com.wandrell.tabletop.dreadball.testing.model.test.unit.team;

import java.util.LinkedHashMap;
import java.util.Map;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.team.AdvancementTeam;
import com.wandrell.tabletop.dreadball.model.team.AdvancementTeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.team.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.AdvancementUnit;

public final class TestAdvancementTeamValorationCalculator {

    private TeamValorationCalculator<AdvancementTeam> valorator;

    public TestAdvancementTeamValorationCalculator() {
        super();
    }

    @BeforeClass
    public final void initialize() {
        valorator = new AdvancementTeamValorationCalculator(1, 2, 3, 4);
    }

    @Test
    public final void testValoration() {
        final AdvancementTeam team;
        final Map<Integer, AdvancementUnit> players;
        final AdvancementUnit player;

        team = Mockito.mock(AdvancementTeam.class);
        Mockito.when(team.getDice()).thenReturn(2);
        Mockito.when(team.getDreadballCards()).thenReturn(4);
        Mockito.when(team.getCheerleaders()).thenReturn(1);
        Mockito.when(team.hasDefensiveCoachingStaff()).thenReturn(true);
        Mockito.when(team.hasOffensiveCoachingStaff()).thenReturn(true);
        Mockito.when(team.hasSupportCoachingStaff()).thenReturn(true);

        players = new LinkedHashMap<>();
        player = Mockito.mock(AdvancementUnit.class);
        Mockito.when(player.getValoration()).thenReturn(10);
        players.put(1, player);

        Mockito.when(team.getPlayers()).thenReturn(players);

        Assert.assertEquals(valorator.getValoration(team), (Integer) 35);
    }

}
