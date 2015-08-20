package com.wandrell.tabletop.dreadball.testing.model.test.unit.faction;

import java.util.Collection;
import java.util.LinkedList;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.faction.DefaultSponsor;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;

public final class TestUnitGroupsDefaultSponsor {

    public TestUnitGroupsDefaultSponsor() {
        super();
    }

    @Test
    public final void test_RepeatAbility_NoRepeats() {
        final Sponsor sponsor;
        final Collection<AffinityGroup> groups;
        final AffinityGroup group;

        group = Mockito.mock(AffinityGroup.class);
        groups = new LinkedList<>();
        groups.add(group);
        groups.add(group);

        sponsor = new DefaultSponsor("name", 0, groups);

        Assert.assertEquals(sponsor.getAffinityGroups().size(), 1);
    }

}
