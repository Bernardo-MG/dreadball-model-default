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
package com.wandrell.tabletop.dreadball.testing.model.test.unit.unit.component;

import java.util.Collection;
import java.util.LinkedList;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.unit.TeamPosition;
import com.wandrell.tabletop.dreadball.model.unit.component.ComponentLocation;
import com.wandrell.tabletop.dreadball.model.unit.component.DefaultUnitComponent;
import com.wandrell.tabletop.dreadball.model.unit.component.UnitComponent;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

public final class TestDefaultUnitComponent {

    public TestDefaultUnitComponent() {
        super();
    }

    @Test
    public final void test_RepeatAbility_NoRepeats() {
        final UnitComponent component;
        final Collection<Ability> abilities;
        final Collection<TeamPosition> positions;
        final Ability ability;
        final AttributesHolder attributes;
        final ComponentLocation location;

        ability = Mockito.mock(Ability.class);
        abilities = new LinkedList<Ability>();
        abilities.add(ability);
        abilities.add(ability);

        positions = new LinkedList<TeamPosition>();

        attributes = Mockito.mock(AttributesHolder.class);
        location = Mockito.mock(ComponentLocation.class);

        component = new DefaultUnitComponent("name", location, 0, positions,
                attributes, abilities);

        Assert.assertEquals(component.getAbilities().size(), 1);
    }

    @Test
    public final void test_RepeatPosition_NoRepeats() {
        final UnitComponent component;
        final Collection<Ability> abilities;
        final Collection<TeamPosition> positions;
        final AttributesHolder attributes;
        final ComponentLocation location;

        abilities = new LinkedList<Ability>();

        positions = new LinkedList<TeamPosition>();
        positions.add(TeamPosition.STRIKER);
        positions.add(TeamPosition.STRIKER);

        attributes = Mockito.mock(AttributesHolder.class);
        location = Mockito.mock(ComponentLocation.class);

        component = new DefaultUnitComponent("name", location, 0, positions,
                attributes, abilities);

        Assert.assertEquals(component.getTeamPositions().size(), 1);
    }

}
