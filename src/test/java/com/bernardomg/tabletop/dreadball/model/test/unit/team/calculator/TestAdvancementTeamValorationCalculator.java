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

package com.bernardomg.tabletop.dreadball.model.test.unit.team.calculator;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.model.player.AdvancementTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.team.AdvancementTeam;
import com.bernardomg.tabletop.dreadball.model.team.calculator.AdvancementTeamValorationCalculator;
import com.bernardomg.tabletop.dreadball.model.team.calculator.CostCalculator;

/**
 * Unit tests for {@link TeamValorationCalculator} applied to a
 * {@link AdvancementTeam}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestAdvancementTeamValorationCalculator {

    /**
     * Default constructor.
     */
    public TestAdvancementTeamValorationCalculator() {
        super();
    }

    /**
     * Tests that the valoration is calculated correctly.
     */
    @Test
    public final void testValoration() {
        final CostCalculator<AdvancementTeam> calculator; // Tested
                                                          // class
        final AdvancementTeam team;                  // Team to valorate
        final Map<Integer, AdvancementTeamPlayer> players; // Team players
        final AdvancementTeamPlayer player;                // Mocked player

        // Mocks team
        team = Mockito.mock(AdvancementTeam.class);
        Mockito.when(team.getCoachingDice()).thenReturn(2);
        Mockito.when(team.getDreadballCards()).thenReturn(4);
        Mockito.when(team.getCheerleaders()).thenReturn(1);
        Mockito.when(team.getDefensiveCoachingStaff()).thenReturn(true);
        Mockito.when(team.getOffensiveCoachingStaff()).thenReturn(true);
        Mockito.when(team.getSupportCoachingStaff()).thenReturn(true);

        // Mocks players
        players = new HashMap<>();
        player = Mockito.mock(AdvancementTeamPlayer.class);
        Mockito.when(player.getValoration()).thenReturn(10);
        players.put(1, player);

        Mockito.when(team.getPlayers()).thenReturn(players);

        // Creates calculator
        calculator = new AdvancementTeamValorationCalculator(1, 2, 3, 4);

        Assert.assertEquals(calculator.getCost(team), (Integer) 35);
    }

}
