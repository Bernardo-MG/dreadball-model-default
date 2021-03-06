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

import com.bernardomg.tabletop.dreadball.model.player.AffinityTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.ImmutableAffinityTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.DefaultTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.Role;
import com.bernardomg.tabletop.dreadball.model.player.TeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.stats.Ability;
import com.bernardomg.tabletop.dreadball.model.player.stats.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.player.stats.Attributes;

/**
 * Unit tests for {@link DefaultTeamPlayer}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestImmutableAffinityTeamPlayer {

    /**
     * Default constructor.
     */
    public TestImmutableAffinityTeamPlayer() {
        super();
    }

    /**
     * Tests that abilities are not repeated.
     */
    @Test
    public final void testRepeatAbility_NoRepeats() {
        final TeamPlayer player;             // Tested player
        final Collection<Ability> abilities; // Initial abilities
        final Ability ability;               // Mocked ability
        final Attributes attributes;         // Mocked attributes

        // Mocks abilities
        ability = Mockito.mock(Ability.class);
        abilities = new ArrayList<>();
        abilities.add(ability);
        abilities.add(ability);

        // Mocks attributes
        attributes = Mockito.mock(Attributes.class);

        // Creates player
        player = new ImmutableAffinityTeamPlayer("name", Role.GUARD, attributes,
                abilities, true, true, new ArrayList<AffinityGroup>(),
                new ArrayList<AffinityGroup>(), 0, 0, 0, 0);

        Assert.assertEquals(player.getAbilities().size(), 1);
    }

    /**
     * Tests that affinities are not repeated.
     */
    @Test
    public final void testRepeatAffinity_NoRepeats() {
        final AffinityTeamPlayer player;            // Tested player
        final Collection<AffinityGroup> affinities; // Initial affinities
        final AffinityGroup affinity;               // Mocked ability
        final Attributes attributes;                // Mocked attributes

        // Mocks abilities
        affinity = Mockito.mock(AffinityGroup.class);
        affinities = new ArrayList<>();
        affinities.add(affinity);
        affinities.add(affinity);

        // Mocks attributes
        attributes = Mockito.mock(Attributes.class);

        // Creates player
        player = new ImmutableAffinityTeamPlayer("name", Role.GUARD, attributes,
                new ArrayList<Ability>(), true, true, affinities,
                new ArrayList<AffinityGroup>(), 0, 0, 0, 0);

        Assert.assertEquals(player.getAffinityGroups().size(), 1);
    }

    /**
     * Tests that hated affinities are not repeated.
     */
    @Test
    public final void testRepeatHatedAffinity_NoRepeats() {
        final AffinityTeamPlayer player;            // Tested player
        final Collection<AffinityGroup> affinities; // Initial affinities
        final AffinityGroup affinity;               // Mocked ability
        final Attributes attributes;                // Mocked attributes

        // Mocks abilities
        affinity = Mockito.mock(AffinityGroup.class);
        affinities = new ArrayList<>();
        affinities.add(affinity);
        affinities.add(affinity);

        // Mocks attributes
        attributes = Mockito.mock(Attributes.class);

        // Creates player
        player = new ImmutableAffinityTeamPlayer("name", Role.GUARD, attributes,
                new ArrayList<Ability>(), true, true,
                new ArrayList<AffinityGroup>(), affinities, 0, 0, 0, 0);

        Assert.assertEquals(player.getHatedAffinityGroups().size(), 1);
    }

}
