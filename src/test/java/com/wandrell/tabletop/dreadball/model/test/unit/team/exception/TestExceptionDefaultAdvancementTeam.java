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

package com.wandrell.tabletop.dreadball.model.test.unit.team.exception;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.faction.TeamType;
import com.wandrell.tabletop.dreadball.model.team.AdvancementTeam;
import com.wandrell.tabletop.dreadball.model.team.DefaultAdvancementTeam;
import com.wandrell.tabletop.dreadball.model.team.calculator.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.AdvancementUnit;

/**
 * Unit tests for {@link DefaultAdvancementTeam} checking that exceptions are
 * thrown.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Adding an existing player raises an exception</li>
 * <li>Adding a player to a negative position raises an exception</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestExceptionDefaultAdvancementTeam {

    /**
     * Default constructor.
     */
    public TestExceptionDefaultAdvancementTeam() {
        super();
    }

    /**
     * Tests that adding a player to a negative position raises an exception.
     */
    @SuppressWarnings("unchecked")
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAddPlayer_NegativePos() {
        final AdvancementTeam team;   // Tested team
        final AdvancementUnit player; // Mocked player
        final TeamType type;          // Mocked team type
        final TeamValorationCalculator<AdvancementTeam> calculator;

        // Mocks calculator
        calculator = Mockito.mock(TeamValorationCalculator.class);

        // Mocks team type
        type = Mockito.mock(TeamType.class);

        // Mocks player
        player = Mockito.mock(AdvancementUnit.class);

        // Creates team
        team = new DefaultAdvancementTeam(type, calculator);

        team.addPlayer(player, -1);
    }

}
