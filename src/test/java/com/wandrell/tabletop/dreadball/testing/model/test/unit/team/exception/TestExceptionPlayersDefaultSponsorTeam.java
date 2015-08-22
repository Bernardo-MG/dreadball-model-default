package com.wandrell.tabletop.dreadball.testing.model.test.unit.team.exception;

import org.mockito.Mockito;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.Unit;

public final class TestExceptionPlayersDefaultSponsorTeam {

    private SponsorTeam team;

    public TestExceptionPlayersDefaultSponsorTeam() {
        super();
    }

    @SuppressWarnings("unchecked")
    @BeforeClass
    public final void initialize() {
        final Sponsor sponsor;
        final TeamValorationCalculator<SponsorTeam> valorator;

        valorator = Mockito.mock(TeamValorationCalculator.class);
        sponsor = Mockito.mock(Sponsor.class);

        this.team = new DefaultSponsorTeam(sponsor, valorator);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAddPlayer_Existing() {
        final Unit player;

        player = Mockito.mock(Unit.class);

        team.addPlayer(player, 0);
        team.addPlayer(player, 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAddPlayer_NegativePos() {
        final Unit player;

        player = Mockito.mock(Unit.class);

        team.addPlayer(player, -1);
    }

}
