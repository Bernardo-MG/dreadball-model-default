/**
 * Copyright 2015 the original author or authors
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
package com.wandrell.tabletop.dreadball.testing.model.test.unit.team;

import java.util.LinkedHashMap;
import java.util.Map;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.team.AdvancementTeam;
import com.wandrell.tabletop.dreadball.model.team.AdvancementTeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.team.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.AdvancementUnit;

/**
 * Unit tests for {@link AdvancementTeamValorationCalculator}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Valoration is calculated correctly</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
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
        final TeamValorationCalculator<AdvancementTeam> valorator; // Tested
        // class
        final AdvancementTeam team;                  // Team to valorate
        final Map<Integer, AdvancementUnit> players; // Team players
        final AdvancementUnit player;                // Mocked player

        valorator = new AdvancementTeamValorationCalculator(1, 2, 3, 4);

        team = Mockito.mock(AdvancementTeam.class);
        Mockito.when(team.getCoachingDice()).thenReturn(2);
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
