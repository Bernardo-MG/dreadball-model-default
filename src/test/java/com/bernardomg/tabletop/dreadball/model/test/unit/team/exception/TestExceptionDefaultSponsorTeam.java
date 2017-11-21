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

import org.mockito.Mockito;
import org.testng.annotations.Test;

import com.bernardomg.tabletop.dreadball.model.team.DefaultSponsorTeam;
import com.bernardomg.tabletop.dreadball.model.team.calculator.CostCalculator;
import com.bernardomg.tabletop.dreadball.model.faction.Sponsor;
import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.bernardomg.tabletop.dreadball.model.unit.Unit;

/**
 * Unit tests for {@link DefaultSponsorTeam} checking that exceptions are
 * thrown.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Adding an existing player raises an {@code IllegalArgumentException}</li>
 * <li>Adding a player to a negative position raises an
 * {@code IllegalArgumentException}</li>
 * </ol>
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
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAddPlayer_NegativePos() {
        final SponsorTeam team;          // Tested team
        final Sponsor sponsor;           // Mocked sponsor
        final CostCalculator<SponsorTeam> calculator; // Mocked calculator
        final CostCalculator<SponsorTeam> ranker; // Mocked rank calculator
        final Unit player;               // Mocked player

        // Mocks calculator
        calculator = Mockito.mock(CostCalculator.class);
        ranker = Mockito.mock(CostCalculator.class);

        // Mocks sponsor
        sponsor = Mockito.mock(Sponsor.class);

        // Mocks player
        player = Mockito.mock(Unit.class);

        // Creates team
        team = new DefaultSponsorTeam(sponsor, calculator, ranker);

        team.addPlayer(player, -1);
    }

}
