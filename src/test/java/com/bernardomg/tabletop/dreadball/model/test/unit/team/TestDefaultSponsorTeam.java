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

package com.bernardomg.tabletop.dreadball.model.test.unit.team;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.model.faction.Sponsor;
import com.bernardomg.tabletop.dreadball.model.player.TeamPlayer;
import com.bernardomg.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.bernardomg.tabletop.dreadball.model.team.calculator.CostCalculator;

/**
 * Unit tests for {@link SponsorTeam}.
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
     * Tests that adding a player without giving a position works when there are
     * no players.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testAddPlayer_AutoPos_Empty() {
        final SponsorTeam team; // Tested team
        final TeamPlayer player1;     // Mocked player 1
        final TeamPlayer player2;     // Mocked player 2
        final Sponsor sponsor;  // Mocked sponsor
        final CostCalculator<SponsorTeam> calculator; // Mocked
                                                      // calculator
        final CostCalculator<SponsorTeam> ranker; // Mocked rank calculator

        // Mocks sponsor
        sponsor = Mockito.mock(Sponsor.class);

        // Mocks calculators
        calculator = Mockito.mock(CostCalculator.class);
        ranker = Mockito.mock(CostCalculator.class);

        // Creates team
        team = new DefaultSponsorTeam(sponsor, calculator, ranker);

        // Mocks players
        player1 = Mockito.mock(TeamPlayer.class);
        player2 = Mockito.mock(TeamPlayer.class);

        // Adds player
        team.addPlayer(player1);
        team.addPlayer(player2);

        Assert.assertEquals(team.getPlayers().get(1), player1);
    }

    /**
     * Tests that adding a player without giving a position uses the first empty
     * position.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testAddPlayer_AutoPos_FirstEmpty() {
        final SponsorTeam team; // Tested team
        final TeamPlayer player1;     // Mocked player 1
        final TeamPlayer player2;     // Mocked player 2
        final TeamPlayer player3;     // Mocked player 3
        final Sponsor sponsor;  // Mocked sponsor
        final CostCalculator<SponsorTeam> calculator; // Mocked
                                                      // calculator
        final CostCalculator<SponsorTeam> ranker; // Mocked rank calculator

        // Mocks sponsor
        sponsor = Mockito.mock(Sponsor.class);

        // Mocks calculators
        calculator = Mockito.mock(CostCalculator.class);
        ranker = Mockito.mock(CostCalculator.class);

        // Creates team
        team = new DefaultSponsorTeam(sponsor, calculator, ranker);

        // Mocks players
        player1 = Mockito.mock(TeamPlayer.class);
        player2 = Mockito.mock(TeamPlayer.class);
        player3 = Mockito.mock(TeamPlayer.class);

        // Adds players
        team.addPlayer(player1, 1);
        team.addPlayer(player3, 3);

        team.addPlayer(player2);

        Assert.assertEquals(team.getPlayers().get(2), player2);
    }

    /**
     * Tests that adding a player without giving a position adds correctly to
     * the last position.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testAddPlayer_AutoPos_LastPos() {
        final SponsorTeam team; // Tested team
        final TeamPlayer player1;     // Mocked player 1
        final TeamPlayer player2;     // Mocked player 2
        final TeamPlayer player3;     // Mocked player 3
        final Sponsor sponsor;  // Mocked sponsor
        final CostCalculator<SponsorTeam> calculator; // Mocked
                                                      // calculator
        final CostCalculator<SponsorTeam> ranker; // Mocked rank calculator

        // Mocks sponsor
        sponsor = Mockito.mock(Sponsor.class);

        // Mocks calculators
        calculator = Mockito.mock(CostCalculator.class);
        ranker = Mockito.mock(CostCalculator.class);

        // Creates team
        team = new DefaultSponsorTeam(sponsor, calculator, ranker);

        // Mocks players
        player1 = Mockito.mock(TeamPlayer.class);
        player2 = Mockito.mock(TeamPlayer.class);
        player3 = Mockito.mock(TeamPlayer.class);

        // Adds player
        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);

        Assert.assertEquals(team.getPlayers().get(3), player3);
    }

    /**
     * Tests that adding players to an empty team work as expected.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testAddPlayer_Position_Empty() {
        final SponsorTeam team; // Tested team
        final TeamPlayer player1;     // Mocked player 1
        final TeamPlayer player2;     // Mocked player 2
        final Sponsor sponsor;  // Mocked sponsor
        final CostCalculator<SponsorTeam> calculator; // Mocked
                                                      // calculator
        final CostCalculator<SponsorTeam> ranker; // Mocked rank calculator

        // Mocks sponsor
        sponsor = Mockito.mock(Sponsor.class);

        // Mocks calculators
        calculator = Mockito.mock(CostCalculator.class);
        ranker = Mockito.mock(CostCalculator.class);

        // Creates team
        team = new DefaultSponsorTeam(sponsor, calculator, ranker);

        // Mocks players
        player1 = Mockito.mock(TeamPlayer.class);
        player2 = Mockito.mock(TeamPlayer.class);

        // Adds players
        team.addPlayer(player1, 1);
        team.addPlayer(player2, 3);

        Assert.assertEquals(team.getPlayers().size(), 2);
    }

    /**
     * Tests that adding a player to an existing position overwrites the player.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testAddPlayer_Position_Overwrite() {
        final SponsorTeam team; // Tested team
        final TeamPlayer player1;     // Mocked player 1
        final TeamPlayer player2;     // Mocked player 2
        final Sponsor sponsor;  // Mocked sponsor
        final CostCalculator<SponsorTeam> calculator; // Mocked
                                                      // calculator
        final CostCalculator<SponsorTeam> ranker; // Mocked rank calculator

        // Mocks sponsor
        sponsor = Mockito.mock(Sponsor.class);

        // Mocks calculators
        calculator = Mockito.mock(CostCalculator.class);
        ranker = Mockito.mock(CostCalculator.class);

        // Creates team
        team = new DefaultSponsorTeam(sponsor, calculator, ranker);

        // Mocks players
        player1 = Mockito.mock(TeamPlayer.class);
        player2 = Mockito.mock(TeamPlayer.class);

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
     * Tests that the base rank is calculated correctly.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testGetBaseRank() {
        final SponsorTeam team; // Tested team
        final Sponsor sponsor;  // Mocked sponsor
        final CostCalculator<SponsorTeam> calculator; // Mocked
                                                      // calculator
        final CostCalculator<SponsorTeam> ranker; // Mocked rank calculator

        // Mocks sponsor
        sponsor = Mockito.mock(Sponsor.class);
        Mockito.when(sponsor.getRank()).thenReturn(5);

        // Mocks calculators
        calculator = Mockito.mock(CostCalculator.class);
        ranker = Mockito.mock(CostCalculator.class);

        // Creates team
        team = new DefaultSponsorTeam(sponsor, calculator, ranker);

        Assert.assertEquals(new Integer(5), team.getBaseRank());
    }

    /**
     * Tests that the current rank is calculated correctly.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testGetCurrentRank() {
        final SponsorTeam team; // Tested team
        final Sponsor sponsor;  // Mocked sponsor
        final CostCalculator<SponsorTeam> calculator; // Mocked
                                                      // calculator
        final CostCalculator<SponsorTeam> ranker; // Mocked rank calculator

        // Mocks sponsor
        sponsor = Mockito.mock(Sponsor.class);
        Mockito.when(sponsor.getRank()).thenReturn(5);

        // Mocks calculators
        calculator = Mockito.mock(CostCalculator.class);
        ranker = Mockito.mock(CostCalculator.class);
        Mockito.when(ranker.getCost(Matchers.any(SponsorTeam.class)))
                .thenReturn(3);

        // Creates team
        team = new DefaultSponsorTeam(sponsor, calculator, ranker);

        Assert.assertEquals(new Integer(2), team.getCurrentRank());
    }

    /**
     * Tests that removing a player using its position works as expected.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testRemovePlayer() {
        final SponsorTeam team; // Tested team
        final TeamPlayer player;      // Mocked player
        final Sponsor sponsor;  // Mocked sponsor
        final CostCalculator<SponsorTeam> calculator; // Mocked
                                                      // calculator
        final CostCalculator<SponsorTeam> ranker; // Mocked rank calculator

        // Mocks sponsor
        sponsor = Mockito.mock(Sponsor.class);

        // Mocks calculators
        calculator = Mockito.mock(CostCalculator.class);
        ranker = Mockito.mock(CostCalculator.class);

        // Creates team
        team = new DefaultSponsorTeam(sponsor, calculator, ranker);

        // Mocks player
        player = Mockito.mock(TeamPlayer.class);
        team.addPlayer(player, 1);

        team.removePlayer(1);

        Assert.assertEquals(team.getPlayers().size(), 0);
    }

}
