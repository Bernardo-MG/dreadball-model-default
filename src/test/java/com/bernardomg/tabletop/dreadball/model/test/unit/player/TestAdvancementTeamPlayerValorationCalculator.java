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

package com.bernardomg.tabletop.dreadball.model.test.unit.player;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.model.player.AdvancementTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.AdvancementTeamPlayerValorationCalculator;
import com.bernardomg.tabletop.dreadball.model.player.TeamPlayerValorationCalculator;
import com.bernardomg.tabletop.dreadball.model.player.component.Component;

/**
 * Unit tests for {@link TeamPlayerValorationCalculator} applied to a
 * {@link AdvancementTeamPlayer}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestAdvancementTeamPlayerValorationCalculator {

    /**
     * Default constructor.
     */
    public TestAdvancementTeamPlayerValorationCalculator() {
        super();
    }

    /**
     * Tests that the valoration is calculated correctly.
     */
    @Test
    public final void testValoration() {
        final TeamPlayerValorationCalculator<AdvancementTeamPlayer> calculator; // Tested
        // class
        final AdvancementTeamPlayer player;     // Unit for the test
        final Component implant;        // Unit's implant

        // Mocks implant
        implant = Mockito.mock(Component.class);
        Mockito.when(implant.getCost()).thenReturn(5);

        // Mocks player
        player = Mockito.mock(AdvancementTeamPlayer.class);
        Mockito.when(player.getCost()).thenReturn(10);
        Mockito.when(player.getRank()).thenReturn(3);
        Mockito.when(player.getGraftedImplant()).thenReturn(implant);

        // Creates calculator
        calculator = new AdvancementTeamPlayerValorationCalculator(5);

        Assert.assertEquals(calculator.getValoration(player), (Integer) 30);
    }

}
