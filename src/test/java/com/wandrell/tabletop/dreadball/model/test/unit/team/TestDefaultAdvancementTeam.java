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

import com.wandrell.tabletop.dreadball.model.faction.TeamType;
import com.wandrell.tabletop.dreadball.model.team.AdvancementTeam;
import com.wandrell.tabletop.dreadball.model.team.DefaultAdvancementTeam;
import com.wandrell.tabletop.dreadball.model.team.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.AdvancementUnit;

/**
 * Unit tests for {@link AdvancementTeam}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Adding units to an empty team work as expected</li>
 * <li>Adding a unit to an existing position overwrites the unit</li>
 * <li>Adding a unit without giving a position uses the first empty position
 * </li>
 * <li>Removing a unit using its position works as expected</li>
 * <li>Removing a unit using it as a reference works as expected</li>
 * </ol>
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
     * Tests that adding a unit without giving a position uses the first empty
     * position.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testAddPlayer_AutoPos_FirstEmpty() {
        final AdvancementTeam team;                  // Tested team
        final AdvancementUnit player1;               // Mocked player 1
        final AdvancementUnit player2;               // Mocked player 2
        final AdvancementUnit player3;               // Mocked player 3
        final TeamType type;                         // Mocked team type
        final TeamValorationCalculator<AdvancementTeam> calculator; // Mocked
                                                                    // calculator

        // Mocks team type
        type = Mockito.mock(TeamType.class);

        // Mocks valoration calculator
        calculator = Mockito.mock(TeamValorationCalculator.class);

        // Creates team
        team = new DefaultAdvancementTeam(type, calculator);

        // Mocks players
        player1 = Mockito.mock(AdvancementUnit.class);
        player2 = Mockito.mock(AdvancementUnit.class);
        player3 = Mockito.mock(AdvancementUnit.class);

        team.addPlayer(player1, 1);
        team.addPlayer(player3, 3);

        team.addPlayer(player2);

        Assert.assertEquals(team.getPlayers().get(2), player2);
    }

    /**
     * Tests that adding units to an empty team work as expected.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testAddPlayer_Position_Empty() {
        final AdvancementTeam team;                  // Tested team
        final AdvancementUnit player1;               // Mocked player 1
        final AdvancementUnit player2;               // Mocked player 2
        final TeamType type;                         // Mocked team type
        final TeamValorationCalculator<AdvancementTeam> calculator; // Mocked
                                                                    // calculator

        // Mocks team type
        type = Mockito.mock(TeamType.class);

        // Mocks valoration calculator
        calculator = Mockito.mock(TeamValorationCalculator.class);

        // Creates team
        team = new DefaultAdvancementTeam(type, calculator);

        // Mocks players
        player1 = Mockito.mock(AdvancementUnit.class);
        player2 = Mockito.mock(AdvancementUnit.class);

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
        final AdvancementTeam team;                  // Tested team
        final AdvancementUnit player1;               // Mocked player 1
        final AdvancementUnit player2;               // Mocked player 2
        final TeamType type;                         // Mocked team type
        final TeamValorationCalculator<AdvancementTeam> calculator; // Mocked
                                                                    // calculator

        // Mocks team type
        type = Mockito.mock(TeamType.class);

        // Mocks valoration calculator
        calculator = Mockito.mock(TeamValorationCalculator.class);

        // Creates team
        team = new DefaultAdvancementTeam(type, calculator);

        // Mocks players
        player1 = Mockito.mock(AdvancementUnit.class);
        player2 = Mockito.mock(AdvancementUnit.class);

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
    public final void testRemovePlayer_Position_Number() {
        final AdvancementTeam team;                  // Tested team
        final AdvancementUnit player;                // Mocked player
        final TeamType type;                         // Mocked team type
        final TeamValorationCalculator<AdvancementTeam> calculator; // Mocked
                                                                    // calculator

        // Mocks team type
        type = Mockito.mock(TeamType.class);

        // Mocks valoration calculator
        calculator = Mockito.mock(TeamValorationCalculator.class);

        // Creates team
        team = new DefaultAdvancementTeam(type, calculator);

        // Mocks players
        player = Mockito.mock(AdvancementUnit.class);
        team.addPlayer(player, 1);

        team.removePlayer(1);

        Assert.assertEquals(team.getPlayers().size(), 0);
    }

    /**
     * Tests that removing a unit using it as a reference works as expected.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testRemovePlayer_Position_Player() {
        final AdvancementTeam team;                  // Tested team
        final AdvancementUnit player;                // Mocked player
        final TeamType type;                         // Mocked team type
        final TeamValorationCalculator<AdvancementTeam> calculator; // Mocked
                                                                    // calculator

        // Mocks team type
        type = Mockito.mock(TeamType.class);

        // Mocks valoration calculator
        calculator = Mockito.mock(TeamValorationCalculator.class);

        // Creates team
        team = new DefaultAdvancementTeam(type, calculator);

        // Mocks players
        player = Mockito.mock(AdvancementUnit.class);
        team.addPlayer(player, 1);

        team.removePlayer(player);

        Assert.assertEquals(team.getPlayers().size(), 0);
    }

}