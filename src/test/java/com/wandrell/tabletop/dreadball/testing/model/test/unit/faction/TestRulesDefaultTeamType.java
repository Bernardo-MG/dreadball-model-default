package com.wandrell.tabletop.dreadball.testing.model.test.unit.faction;

import java.util.Collection;
import java.util.LinkedList;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.faction.DefaultTeamType;
import com.wandrell.tabletop.dreadball.model.faction.TeamRule;
import com.wandrell.tabletop.dreadball.model.faction.TeamType;

public final class TestRulesDefaultTeamType {

    public TestRulesDefaultTeamType() {
        super();
    }

    @Test
    public final void test_RepeatAbility_NoRepeats() {
        final TeamType team;
        final Collection<TeamRule> rules;
        final TeamRule rule;

        rule = Mockito.mock(TeamRule.class);
        rules = new LinkedList<>();
        rules.add(rule);
        rules.add(rule);

        team = new DefaultTeamType("name", rules);

        Assert.assertEquals(team.getTeamRules().size(), 1);
    }

}
