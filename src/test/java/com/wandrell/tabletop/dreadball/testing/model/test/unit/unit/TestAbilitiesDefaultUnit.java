package com.wandrell.tabletop.dreadball.testing.model.test.unit.unit;

import java.util.Collection;
import java.util.LinkedList;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.DefaultAffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.TeamPosition;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

public final class TestAbilitiesDefaultUnit {

    public TestAbilitiesDefaultUnit() {
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

        unit = new DefaultAffinityUnit("name", TeamPosition.GUARD, attributes,
                abilities, true, new LinkedList<AffinityGroup>(), 0, 0, 0);

        Assert.assertEquals(unit.getAbilities().size(), 1);
    }

}
