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

import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.bernardomg.tabletop.dreadball.model.team.calculator.CostCalculator;
import com.bernardomg.tabletop.dreadball.model.team.calculator.DefaultRankCostCalculator;
import com.bernardomg.tabletop.dreadball.model.unit.AdvancementUnit;
import com.bernardomg.tabletop.dreadball.model.unit.Unit;

/**
 * Unit tests for {@link DefaultRankCostCalculator}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Rank cost is calculated correctly</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestDefaultRankCostCalculator {

    /**
     * Default constructor.
     */
    public TestDefaultRankCostCalculator() {
        super();
    }

    /**
     * Tests that the rank cost is calculated correctly.
     */
    @Test
    public final void testRankCost() {
        final CostCalculator<SponsorTeam> calculator; // Tested class
        final SponsorTeam team;              // Team to valorate
        final Map<Integer, Unit> players;    // Team players
        final Unit player;                   // Mocked player

        // Mocks team
        team = Mockito.mock(SponsorTeam.class);
        Mockito.when(team.getCoachingDice()).thenReturn(2);
        Mockito.when(team.getSabotageCards()).thenReturn(4);
        Mockito.when(team.getSpecialMoveCards()).thenReturn(5);
        Mockito.when(team.getCheerleaders()).thenReturn(1);
        Mockito.when(team.getMediBots()).thenReturn(2);
        Mockito.when(team.getWagers()).thenReturn(3);

        // Mocks players
        players = new HashMap<>();
        player = Mockito.mock(AdvancementUnit.class);
        players.put(1, player);

        Mockito.when(team.getPlayers()).thenReturn(players);

        // Creates calculator
        calculator = new DefaultRankCostCalculator(1, 2, 3, 4, 5, 6);

        Assert.assertEquals(calculator.getCost(team), (Integer) 56);
    }

}
