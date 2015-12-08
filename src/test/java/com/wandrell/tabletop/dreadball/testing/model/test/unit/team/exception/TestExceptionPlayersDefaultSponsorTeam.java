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

package com.wandrell.tabletop.dreadball.testing.model.test.unit.team.exception;

import org.mockito.Mockito;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.team.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.UnitTemplate;

/**
 * Unit tests for {@link SponsorTeam} checking that exceptions are thrown.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Adding an existing player raises an {@code IllegalArgumentException}</li>
 * <li>Adding a player to a negative position raises an
 * {@code IllegalArgumentException}</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestExceptionPlayersDefaultSponsorTeam {

    /**
     * Tested team.
     */
    private SponsorTeam team;

    /**
     * Default constructor.
     */
    public TestExceptionPlayersDefaultSponsorTeam() {
        super();
    }

    /**
     * Initializes the team.
     */
    @SuppressWarnings("unchecked")
    @BeforeClass
    public final void initialize() {
        final Sponsor sponsor;
        final TeamValorationCalculator<SponsorTeam> valorator;

        valorator = Mockito.mock(TeamValorationCalculator.class);
        sponsor = Mockito.mock(Sponsor.class);

        this.team = new DefaultSponsorTeam(sponsor, valorator);
    }

    /**
     * Tests that adding an existing player raises an
     * {@code IllegalArgumentException}.
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAddPlayer_Existing() {
        final UnitTemplate player;

        player = Mockito.mock(UnitTemplate.class);

        team.addPlayer(player, 0);
        team.addPlayer(player, 1);
    }

    /**
     * Tests that adding a player to a negative position raises an
     * {@code IllegalArgumentException}.
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAddPlayer_NegativePos() {
        final UnitTemplate player;

        player = Mockito.mock(UnitTemplate.class);

        team.addPlayer(player, -1);
    }

}
