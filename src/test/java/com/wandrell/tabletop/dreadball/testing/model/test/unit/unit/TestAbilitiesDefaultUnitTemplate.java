package com.wandrell.tabletop.dreadball.testing.model.test.unit.unit;

import java.util.Collection;
import java.util.LinkedList;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.unit.DefaultUnit;
import com.wandrell.tabletop.dreadball.model.unit.TeamPosition;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

public final class TestAbilitiesDefaultUnitTemplate {

    public TestAbilitiesDefaultUnitTemplate() {
        super();
    }

    @Test
    public final void test_RepeatAbility_NoRepeats() {
        final Unit unit;
        final Collection<Ability> abilities;
        final Ability ability;
        final AttributesHolder attributes;

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
