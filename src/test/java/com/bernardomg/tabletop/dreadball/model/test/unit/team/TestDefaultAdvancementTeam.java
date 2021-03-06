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
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.model.faction.TeamType;
import com.bernardomg.tabletop.dreadball.model.player.AdvancementTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.team.AdvancementTeam;
import com.bernardomg.tabletop.dreadball.model.team.DefaultAdvancementTeam;
import com.bernardomg.tabletop.dreadball.model.team.calculator.CostCalculator;

/**
 * Unit tests for {@link AdvancementTeam}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestDefaultAdvancementTeam {

    /**
     * Default constructor.
     */
    public TestDefaultAdvancementTeam() {
        super();
    }

    /**
     * Tests that adding a player without giving a position works when there are
     * no players.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testAddPlayer_AutoPos_Empty() {
        final AdvancementTeam team;    // Tested team
        final AdvancementTeamPlayer player1; // Mocked player 1
        final TeamType type;           // Mocked team type
        final CostCalculator<AdvancementTeam> calculator; // Mocked
                                                          // calculator

        // Mocks team type
        type = Mockito.mock(TeamType.class);

        // Mocks calculators
        calculator = Mockito.mock(CostCalculator.class);

        // Creates team
        team = new DefaultAdvancementTeam(type, calculator);

        // Mocks players
        player1 = Mockito.mock(AdvancementTeamPlayer.class);

        // Adds player
        team.addPlayer(player1);

        Assert.assertEquals(team.getPlayers().get(1), player1);
    }

    /**
     * Tests that adding a player without giving a position uses the first empty
     * position.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testAddPlayer_AutoPos_FirstEmpty() {
        final AdvancementTeam team;    // Tested team
        final AdvancementTeamPlayer player1; // Mocked player 1
        final AdvancementTeamPlayer player2; // Mocked player 2
        final AdvancementTeamPlayer player3; // Mocked player 3
        final TeamType type;           // Mocked team type
        final CostCalculator<AdvancementTeam> calculator; // Mocked
                                                          // calculator

        // Mocks team type
        type = Mockito.mock(TeamType.class);

        // Mocks valoration calculator
        calculator = Mockito.mock(CostCalculator.class);

        // Creates team
        team = new DefaultAdvancementTeam(type, calculator);

        // Mocks players
        player1 = Mockito.mock(AdvancementTeamPlayer.class);
        player2 = Mockito.mock(AdvancementTeamPlayer.class);
        player3 = Mockito.mock(AdvancementTeamPlayer.class);

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
        final AdvancementTeam team;    // Tested team
        final AdvancementTeamPlayer player1; // Mocked player 1
        final AdvancementTeamPlayer player2; // Mocked player 2
        final AdvancementTeamPlayer player3; // Mocked player 3
        final TeamType type;           // Mocked team type
        final CostCalculator<AdvancementTeam> calculator; // Mocked
                                                          // calculator

        // Mocks team type
        type = Mockito.mock(TeamType.class);

        // Mocks calculators
        calculator = Mockito.mock(CostCalculator.class);

        // Creates team
        team = new DefaultAdvancementTeam(type, calculator);

        // Mocks players
        player1 = Mockito.mock(AdvancementTeamPlayer.class);
        player2 = Mockito.mock(AdvancementTeamPlayer.class);
        player3 = Mockito.mock(AdvancementTeamPlayer.class);

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
        final AdvancementTeam team;    // Tested team
        final AdvancementTeamPlayer player1; // Mocked player 1
        final AdvancementTeamPlayer player2; // Mocked player 2
        final TeamType type;           // Mocked team type
        final CostCalculator<AdvancementTeam> calculator; // Mocked
                                                          // calculator

        // Mocks team type
        type = Mockito.mock(TeamType.class);

        // Mocks valoration calculator
        calculator = Mockito.mock(CostCalculator.class);

        // Creates team
        team = new DefaultAdvancementTeam(type, calculator);

        // Mocks players
        player1 = Mockito.mock(AdvancementTeamPlayer.class);
        player2 = Mockito.mock(AdvancementTeamPlayer.class);

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
        final AdvancementTeam team;    // Tested team
        final AdvancementTeamPlayer player1; // Mocked player 1
        final AdvancementTeamPlayer player2; // Mocked player 2
        final TeamType type;           // Mocked team type
        final CostCalculator<AdvancementTeam> calculator; // Mocked
                                                          // calculator

        // Mocks team type
        type = Mockito.mock(TeamType.class);

        // Mocks valoration calculator
        calculator = Mockito.mock(CostCalculator.class);

        // Creates team
        team = new DefaultAdvancementTeam(type, calculator);

        // Mocks players
        player1 = Mockito.mock(AdvancementTeamPlayer.class);
        player2 = Mockito.mock(AdvancementTeamPlayer.class);

        team.addPlayer(player1, 1);
        team.addPlayer(player2, 1);

        Assert.assertEquals(team.getPlayers().size(), 1);

        Assert.assertTrue(
                team.getPlayers().values().iterator().next() != player1);
        Assert.assertTrue(
                team.getPlayers().values().iterator().next() == player2);
    }

    /**
     * Tests that removing a player works as expected.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testRemovePlayer() {
        final AdvancementTeam team;   // Tested team
        final AdvancementTeamPlayer player; // Mocked player
        final TeamType type;          // Mocked team type
        final CostCalculator<AdvancementTeam> calculator; // Mocked
                                                          // calculator

        // Mocks team type
        type = Mockito.mock(TeamType.class);

        // Mocks valoration calculator
        calculator = Mockito.mock(CostCalculator.class);

        // Creates team
        team = new DefaultAdvancementTeam(type, calculator);

        // Mocks players
        player = Mockito.mock(AdvancementTeamPlayer.class);
        team.addPlayer(player, 1);

        team.removePlayer(1);

        Assert.assertEquals(team.getPlayers().size(), 0);
    }

}
