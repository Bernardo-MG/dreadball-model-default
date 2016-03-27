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

package com.wandrell.tabletop.dreadball.model.test.unit.unit;

import java.util.Collection;
import java.util.LinkedList;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.unit.DefaultAffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.DefaultUnit;
import com.wandrell.tabletop.dreadball.model.unit.TeamPosition;
import com.wandrell.tabletop.dreadball.model.unit.UnitTemplate;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

/**
 * Unit tests for {@link DefaultAffinityUnit}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Repeated abilities received through the constructor are not repeated</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestDefaultUnit {

    /**
     * Default constructor.
     */
    public TestDefaultUnit() {
        super();
    }

    /**
     * Tests that repeated abilities received through the constructor are not
     * repeated.
     */
    @Test
    public final void test_RepeatAbility_NoRepeats_Constructor() {
        final UnitTemplate unit;             // Tested unit
        final Collection<Ability> abilities; // Initial abilities
        final Ability ability;               // Mocked ability
        final AttributesHolder attributes;   // Mocked attributes

        ability = Mockito.mock(Ability.class);
        abilities = new LinkedList<>();
        abilities.add(ability);
        abilities.add(ability);

        attributes = Mockito.mock(AttributesHolder.class);

        unit = new DefaultUnit("name", 0, TeamPosition.GUARD, attributes,
                abilities, true);

        Assert.assertEquals(unit.getAbilities().size(), 1);
    }

}
