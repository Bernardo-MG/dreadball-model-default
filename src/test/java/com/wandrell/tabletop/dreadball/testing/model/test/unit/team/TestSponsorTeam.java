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

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.AdvancementUnit;

/**
 * Unit tests for {@link SponsorTeam}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Adding units to an empty team work as expected</li>
 * <li>Adding a unit to an existing position overwrites the unit</li>
 * <li>Removing a unit using its position works as expected</li>
 * <li>Removing a unit using it as a reference works as expected</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestSponsorTeam {

    /**
     * Default constructor.
     */
    public TestSponsorTeam() {
        super();
    }

    /**
     * Tests that adding units to an empty team work as expected.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testAddPlayer_Empty() {
        final SponsorTeam team;                      // Tested team
        final AdvancementUnit player1;               // Mocked player 1
        final AdvancementUnit player2;               // Mocked player 2
        final Sponsor sponsor;                       // Mocked sponsor
        final TeamValorationCalculator<SponsorTeam> valorator; // Mocked
                                                               // valorator

        sponsor = Mockito.mock(Sponsor.class);
        valorator = Mockito.mock(TeamValorationCalculator.class);

        team = new DefaultSponsorTeam(sponsor, valorator);

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
    public final void testAddPlayer_Overwrite() {
        final SponsorTeam team;                      // Tested team
        final AdvancementUnit player1;               // Mocked player 1
        final AdvancementUnit player2;               // Mocked player 2
        final Sponsor sponsor;                       // Mocked sponsor
        final TeamValorationCalculator<SponsorTeam> valorator; // Mocked
                                                               // valorator

        sponsor = Mockito.mock(Sponsor.class);
        valorator = Mockito.mock(TeamValorationCalculator.class);

        team = new DefaultSponsorTeam(sponsor, valorator);

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
    public final void testRemovePlayer_Number() {
        final SponsorTeam team;                      // Tested team
        final AdvancementUnit player;                // Mocked player
        final Sponsor sponsor;                       // Mocked sponsor
        final TeamValorationCalculator<SponsorTeam> valorator; // Mocked
                                                               // valorator

        sponsor = Mockito.mock(Sponsor.class);
        valorator = Mockito.mock(TeamValorationCalculator.class);

        team = new DefaultSponsorTeam(sponsor, valorator);

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
    public final void testRemovePlayer_Player() {
        final SponsorTeam team;                      // Tested team
        final AdvancementUnit player;                // Mocked player
        final Sponsor sponsor;                       // Mocked sponsor
        final TeamValorationCalculator<SponsorTeam> valorator; // Mocked
                                                               // valorator

        sponsor = Mockito.mock(Sponsor.class);
        valorator = Mockito.mock(TeamValorationCalculator.class);

        team = new DefaultSponsorTeam(sponsor, valorator);

        player = Mockito.mock(AdvancementUnit.class);
        team.addPlayer(player, 1);

        team.removePlayer(player);

        Assert.assertEquals(team.getPlayers().size(), 0);
    }

}
