/**
 * Copyright 2015-2016 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.wandrell.tabletop.dreadball.model.test.unit.team;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.calculator.RankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.calculator.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.Unit;

/**
 * Unit tests for {@link SponsorTeam}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Adding units to an empty team work as expected</li>
 * <li>Adding a unit to an existing position overwrites the unit</li>
 * <li>Adding a unit without giving a position uses the first empty position
 * </li>
 * <li>Adding a unit without giving a position works when there are no units
 * </li>
 * <li>Adding a unit without giving a position adds correctly to the last
 * position</li>
 * <li>Removing a unit works as expected</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestDefaultSponsorTeam {

    /**
     * Default constructor.
     */
    public TestDefaultSponsorTeam() {
        super();
    }

    /**
     * Tests that adding a unit without giving a position works when there are
     * no units.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testAddPlayer_AutoPos_Empty() {
        final SponsorTeam team; // Tested team
        final Unit player1;     // Mocked player 1
        final Unit player2;     // Mocked player 2
        final Sponsor sponsor;  // Mocked sponsor
        final TeamValorationCalculator<SponsorTeam> calculator; // Mocked
                                                                // calculator
        final RankCostCalculator ranker; // Mocked rank calculator

        // Mocks sponsor
        sponsor = Mockito.mock(Sponsor.class);

        // Mocks calculators
        calculator = Mockito.mock(TeamValorationCalculator.class);
        ranker = Mockito.mock(RankCostCalculator.class);

        // Creates team
        team = new DefaultSponsorTeam(sponsor, calculator, ranker);

        // Mocks players
        player1 = Mockito.mock(Unit.class);
        player2 = Mockito.mock(Unit.class);

        // Adds player
        team.addPlayer(player1);
        team.addPlayer(player2);

        Assert.assertEquals(team.getPlayers().get(1), player1);
    }

    /**
     * Tests that adding a unit without giving a position uses the first empty
     * position.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testAddPlayer_AutoPos_FirstEmpty() {
        final SponsorTeam team; // Tested team
        final Unit player1;     // Mocked player 1
        final Unit player2;     // Mocked player 2
        final Unit player3;     // Mocked player 3
        final Sponsor sponsor;  // Mocked sponsor
        final TeamValorationCalculator<SponsorTeam> calculator; // Mocked
                                                                // calculator
        final RankCostCalculator ranker; // Mocked rank calculator

        // Mocks sponsor
        sponsor = Mockito.mock(Sponsor.class);

        // Mocks calculators
        calculator = Mockito.mock(TeamValorationCalculator.class);
        ranker = Mockito.mock(RankCostCalculator.class);

        // Creates team
        team = new DefaultSponsorTeam(sponsor, calculator, ranker);

        // Mocks players
        player1 = Mockito.mock(Unit.class);
        player2 = Mockito.mock(Unit.class);
        player3 = Mockito.mock(Unit.class);

        // Adds players
        team.addPlayer(player1, 1);
        team.addPlayer(player3, 3);

        team.addPlayer(player2);

        Assert.assertEquals(team.getPlayers().get(2), player2);
    }

    /**
     * Tests that adding a unit without giving a position adds correctly to the
     * last position.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testAddPlayer_AutoPos_LastPos() {
        final SponsorTeam team; // Tested team
        final Unit player1;     // Mocked player 1
        final Unit player2;     // Mocked player 2
        final Unit player3;     // Mocked player 3
        final Sponsor sponsor;  // Mocked sponsor
        final TeamValorationCalculator<SponsorTeam> calculator; // Mocked
                                                                // calculator
        final RankCostCalculator ranker; // Mocked rank calculator

        // Mocks sponsor
        sponsor = Mockito.mock(Sponsor.class);

        // Mocks calculators
        calculator = Mockito.mock(TeamValorationCalculator.class);
        ranker = Mockito.mock(RankCostCalculator.class);

        // Creates team
        team = new DefaultSponsorTeam(sponsor, calculator, ranker);

        // Mocks players
        player1 = Mockito.mock(Unit.class);
        player2 = Mockito.mock(Unit.class);
        player3 = Mockito.mock(Unit.class);

        // Adds player
        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);

        Assert.assertEquals(team.getPlayers().get(3), player3);
    }

    /**
     * Tests that adding units to an empty team work as expected.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testAddPlayer_Position_Empty() {
        final SponsorTeam team; // Tested team
        final Unit player1;     // Mocked player 1
        final Unit player2;     // Mocked player 2
        final Sponsor sponsor;  // Mocked sponsor
        final TeamValorationCalculator<SponsorTeam> calculator; // Mocked
                                                                // calculator
        final RankCostCalculator ranker; // Mocked rank calculator

        // Mocks sponsor
        sponsor = Mockito.mock(Sponsor.class);

        // Mocks calculators
        calculator = Mockito.mock(TeamValorationCalculator.class);
        ranker = Mockito.mock(RankCostCalculator.class);

        // Creates team
        team = new DefaultSponsorTeam(sponsor, calculator, ranker);

        // Mocks players
        player1 = Mockito.mock(Unit.class);
        player2 = Mockito.mock(Unit.class);

        // Adds players
        team.addPlayer(player1, 1);
        team.addPlayer(player2, 3);

        Assert.assertEquals(team.getPlayers().size(), 2);
    }

    /**
     * Tests that adding a unit to an existing position overwrites the unit.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testAddPlayer_Position_Overwrite() {
        final SponsorTeam team; // Tested team
        final Unit player1;     // Mocked player 1
        final Unit player2;     // Mocked player 2
        final Sponsor sponsor;  // Mocked sponsor
        final TeamValorationCalculator<SponsorTeam> calculator; // Mocked
                                                                // calculator
        final RankCostCalculator ranker; // Mocked rank calculator

        // Mocks sponsor
        sponsor = Mockito.mock(Sponsor.class);

        // Mocks calculators
        calculator = Mockito.mock(TeamValorationCalculator.class);
        ranker = Mockito.mock(RankCostCalculator.class);

        // Creates team
        team = new DefaultSponsorTeam(sponsor, calculator, ranker);

        // Mocks players
        player1 = Mockito.mock(Unit.class);
        player2 = Mockito.mock(Unit.class);

        // Adds players
        team.addPlayer(player1, 1);
        team.addPlayer(player2, 1);

        Assert.assertEquals(team.getPlayers().size(), 1);

        Assert.assertTrue(
                team.getPlayers().values().iterator().next() != player1);
        Assert.assertTrue(
                team.getPlayers().values().iterator().next() == player2);
    }

    /**
     * Tests that removing a unit using its position works as expected.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testRemovePlayer() {
        final SponsorTeam team; // Tested team
        final Unit player;      // Mocked player
        final Sponsor sponsor;  // Mocked sponsor
        final TeamValorationCalculator<SponsorTeam> calculator; // Mocked
                                                                // calculator
        final RankCostCalculator ranker; // Mocked rank calculator

        // Mocks sponsor
        sponsor = Mockito.mock(Sponsor.class);

        // Mocks calculators
        calculator = Mockito.mock(TeamValorationCalculator.class);
        ranker = Mockito.mock(RankCostCalculator.class);

        // Creates team
        team = new DefaultSponsorTeam(sponsor, calculator, ranker);

        // Mocks player
        player = Mockito.mock(Unit.class);
        team.addPlayer(player, 1);

        team.removePlayer(1);

        Assert.assertEquals(team.getPlayers().size(), 0);
    }

}
