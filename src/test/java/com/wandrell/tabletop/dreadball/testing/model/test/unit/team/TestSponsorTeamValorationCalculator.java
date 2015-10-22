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

import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.team.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.UnitTemplate;

/**
 * Unit tests for {@link SponsorTeamValorationCalculator}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Valoration is calculated correctly</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
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
        final TeamValorationCalculator<SponsorTeam> valorator; // Tested class
        final SponsorTeam team;           // Team to valorate
        final Map<Integer, UnitTemplate> players; // Team players
        final UnitTemplate player;                // Mocked player

        valorator = new SponsorTeamValorationCalculator(1, 2, 3, 4, 5, 6);

        team = Mockito.mock(SponsorTeam.class);
        Mockito.when(team.getCoachingDice()).thenReturn(2);
        Mockito.when(team.getSabotageCards()).thenReturn(4);
        Mockito.when(team.getSpecialMoveCards()).thenReturn(5);
        Mockito.when(team.getCheerleaders()).thenReturn(1);
        Mockito.when(team.getWagers()).thenReturn(6);
        Mockito.when(team.getMediBots()).thenReturn(3);

        players = new LinkedHashMap<>();
        player = Mockito.mock(UnitTemplate.class);
        Mockito.when(player.getCost()).thenReturn(10);
        players.put(1, player);

        Mockito.when(team.getPlayers()).thenReturn(players);

        Assert.assertEquals(valorator.getValoration(team), (Integer) 87);
    }

}
