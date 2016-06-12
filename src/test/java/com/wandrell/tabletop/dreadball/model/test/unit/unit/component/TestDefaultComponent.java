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

package com.wandrell.tabletop.dreadball.model.test.unit.unit.component;

import java.util.Collection;
import java.util.LinkedList;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.unit.Role;
import com.wandrell.tabletop.dreadball.model.unit.component.Component;
import com.wandrell.tabletop.dreadball.model.unit.component.ComponentLocation;
import com.wandrell.tabletop.dreadball.model.unit.component.DefaultComponent;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.Attributes;

/**
 * Unit tests for {@link DefaultComponent}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Abilities are not repeated</li>
 * <li>Team roles are not repeated</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestDefaultComponent {

    /**
     * Default constructor.
     */
    public TestDefaultComponent() {
        super();
    }

    /**
     * Tests that abilities are not repeated.
     */
    @Test
    public final void testRepeatAbility_NoRepeats() {
        final Component component;           // Tested component
        final Collection<Ability> abilities; // Component abilities
        final Ability ability;               // Mocked ability
        final Attributes attributes;         // Mocked attributes
        final ComponentLocation location;    // Mocked location

        // Mocks abilities
        ability = Mockito.mock(Ability.class);
        abilities = new LinkedList<Ability>();
        abilities.add(ability);
        abilities.add(ability);

        // Mocks attributes
        attributes = Mockito.mock(Attributes.class);

        // Mocks location
        location = Mockito.mock(ComponentLocation.class);

        // Creates component
        component = new DefaultComponent("name", location, 0,
                new LinkedList<Role>(), attributes, abilities);

        Assert.assertEquals(component.getAbilities().size(), 1);
    }

    /**
     * Tests that team roles are not repeated.
     */
    @Test
    public final void testRepeatRole_NoRepeats() {
        final Component component;           // Tested component
        final Collection<Role> roles;        // Component roles
        final Attributes attributes;         // Mocked attributes
        final ComponentLocation location;    // Mocked location

        // Sets roles
        roles = new LinkedList<Role>();
        roles.add(Role.STRIKER);
        roles.add(Role.STRIKER);

        // Mocks attributes
        attributes = Mockito.mock(Attributes.class);

        // Mocks location
        location = Mockito.mock(ComponentLocation.class);

        // Creates component
        component = new DefaultComponent("name", location, 0, roles, attributes,
                new LinkedList<Ability>());

        Assert.assertEquals(component.getRoles().size(), 1);
    }

}
