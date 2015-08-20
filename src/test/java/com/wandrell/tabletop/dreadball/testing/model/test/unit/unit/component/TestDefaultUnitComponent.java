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
