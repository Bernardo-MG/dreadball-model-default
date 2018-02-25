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

package com.bernardomg.tabletop.dreadball.model.test.unit.team.exception;

import org.junit.Test;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.model.faction.Sponsor;
import com.bernardomg.tabletop.dreadball.model.player.TeamPlayer;
import com.bernardomg.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.bernardomg.tabletop.dreadball.model.team.calculator.CostCalculator;

/**
 * Unit tests for {@link DefaultSponsorTeam} checking that exceptions are
 * thrown.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestExceptionDefaultSponsorTeam {

    /**
     * Default constructor.
     */
    public TestExceptionDefaultSponsorTeam() {
        super();
    }

    /**
     * Tests that adding a player to a negative position raises an
     * {@code IllegalArgumentException}.
     */
    @SuppressWarnings("unchecked")
    @Test(expected = IllegalArgumentException.class)
    public void testAddPlayer_NegativePos() {
        final SponsorTeam team;          // Tested team
        final Sponsor sponsor;           // Mocked sponsor
        final CostCalculator<SponsorTeam> calculator; // Mocked calculator
        final CostCalculator<SponsorTeam> ranker; // Mocked rank calculator
        final TeamPlayer player;               // Mocked player

        // Mocks calculator
        calculator = Mockito.mock(CostCalculator.class);
        ranker = Mockito.mock(CostCalculator.class);

        // Mocks sponsor
        sponsor = Mockito.mock(Sponsor.class);

        // Mocks player
        player = Mockito.mock(TeamPlayer.class);

        // Creates team
        team = new DefaultSponsorTeam(sponsor, calculator, ranker);

        team.addPlayer(player, -1);
    }

}
