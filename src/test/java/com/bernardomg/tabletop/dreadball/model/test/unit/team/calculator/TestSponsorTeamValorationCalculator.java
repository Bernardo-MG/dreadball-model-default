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

import com.bernardomg.tabletop.dreadball.model.player.TeamPlayer;
import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.bernardomg.tabletop.dreadball.model.team.calculator.CostCalculator;
import com.bernardomg.tabletop.dreadball.model.team.calculator.SponsorTeamValorationCalculator;

/**
 * Unit tests for {@link SponsorTeamValorationCalculator}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestSponsorTeamValorationCalculator {

    /**
     * Default constructor.
     */
    public TestSponsorTeamValorationCalculator() {
        super();
    }

    /**
     * Tests that the valoration is calculated correctly.
     */
    @Test
    public final void testValoration() {
        final CostCalculator<SponsorTeam> calculator; // Tested class
        final SponsorTeam team;           // Team to valorate
        final Map<Integer, TeamPlayer> players; // Team players
        final TeamPlayer player;                // Mocked player

        // Mocks team
        team = Mockito.mock(SponsorTeam.class);
        Mockito.when(team.getCoachingDice()).thenReturn(2);
        Mockito.when(team.getNastySurpriseCards()).thenReturn(4);
        Mockito.when(team.getSpecialMoveCards()).thenReturn(5);
        Mockito.when(team.getCheerleaders()).thenReturn(1);
        Mockito.when(team.getWagers()).thenReturn(6);
        Mockito.when(team.getMediBots()).thenReturn(3);

        // Mocks players
        players = new HashMap<>();
        player = Mockito.mock(TeamPlayer.class);
        Mockito.when(player.getCost()).thenReturn(10);
        players.put(1, player);

        Mockito.when(team.getPlayers()).thenReturn(players);

        // Creates calculator
        calculator = new SponsorTeamValorationCalculator(1, 2, 3, 4, 5, 6);

        Assert.assertEquals(calculator.getCost(team), (Integer) 87);
    }

}
