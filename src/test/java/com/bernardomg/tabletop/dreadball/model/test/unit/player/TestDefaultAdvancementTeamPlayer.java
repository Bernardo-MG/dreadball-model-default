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

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.model.player.AdvancementTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.DefaultAdvancementTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.Role;
import com.bernardomg.tabletop.dreadball.model.player.TeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.TeamPlayerValorationCalculator;
import com.bernardomg.tabletop.dreadball.model.player.stats.Ability;
import com.bernardomg.tabletop.dreadball.model.player.stats.Attributes;

/**
 * Unit tests for {@link DefaultAdvancementTeamPlayer}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestDefaultAdvancementTeamPlayer {

    /**
     * Default constructor.
     */
    public TestDefaultAdvancementTeamPlayer() {
        super();
    }

    /**
     * Tests that abilities are not repeated.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testRepeatAbility_NoRepeats() {
        final TeamPlayer player;             // Tested player
        final Collection<Ability> abilities; // Initial abilities
        final Ability ability;               // Mocked ability
        final Attributes attributes;         // Mocked attributes
        final TeamPlayerValorationCalculator<AdvancementTeamPlayer> calculator;

        // Mocks abilities
        ability = Mockito.mock(Ability.class);
        abilities = new ArrayList<>();
        abilities.add(ability);
        abilities.add(ability);

        // Mocks attributes
        attributes = Mockito.mock(Attributes.class);

        // Mocks calculator
        calculator = Mockito.mock(TeamPlayerValorationCalculator.class);

        // Creates player
        player = new DefaultAdvancementTeamPlayer("name", 0, Role.GUARD,
                attributes, abilities, true, true, calculator);

        Assert.assertEquals(player.getAbilities().size(), 1);
    }

}
