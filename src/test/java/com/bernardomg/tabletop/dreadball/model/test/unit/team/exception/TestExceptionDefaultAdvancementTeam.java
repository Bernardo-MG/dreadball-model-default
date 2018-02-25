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

import com.bernardomg.tabletop.dreadball.model.faction.TeamType;
import com.bernardomg.tabletop.dreadball.model.player.AdvancementTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.team.AdvancementTeam;
import com.bernardomg.tabletop.dreadball.model.team.DefaultAdvancementTeam;
import com.bernardomg.tabletop.dreadball.model.team.calculator.CostCalculator;

/**
 * Unit tests for {@link DefaultAdvancementTeam} checking that exceptions are
 * thrown.
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
    @Test(expected = IllegalArgumentException.class)
    public void testAddPlayer_NegativePos() {
        final AdvancementTeam team;   // Tested team
        final AdvancementTeamPlayer player; // Mocked player
        final TeamType type;          // Mocked team type
        final CostCalculator<AdvancementTeam> calculator;

        // Mocks calculator
        calculator = Mockito.mock(CostCalculator.class);

        // Mocks team type
        type = Mockito.mock(TeamType.class);

        // Mocks player
        player = Mockito.mock(AdvancementTeamPlayer.class);

        // Creates team
        team = new DefaultAdvancementTeam(type, calculator);

        team.addPlayer(player, -1);
    }

}
