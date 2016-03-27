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

package com.wandrell.tabletop.dreadball.model.test.unit.faction;

import java.util.Collection;
import java.util.LinkedList;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.faction.DefaultSponsor;
import com.wandrell.tabletop.dreadball.model.faction.DefaultTeamType;
import com.wandrell.tabletop.dreadball.model.faction.TeamRule;
import com.wandrell.tabletop.dreadball.model.faction.TeamType;

/**
 * Unit tests for {@link DefaultSponsor}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Repeated team rules received through the constructor are not repeated
 * </li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestRulesDefaultTeamType {

    /**
     * Default constructor.
     */
    public TestRulesDefaultTeamType() {
        super();
    }

    /**
     * Tests that repeated team rules received through the constructor are not
     * repeated.
     */
    @Test
    public final void test_RepeatTeamRule_NoRepeats() {
        final TeamType team; // Tested team type
        final Collection<TeamRule> rules; // Team type rules
        final TeamRule rule; // Mocked rule

        rule = Mockito.mock(TeamRule.class);
        rules = new LinkedList<>();
        rules.add(rule);
        rules.add(rule);

        team = new DefaultTeamType("name", rules);

        Assert.assertEquals(team.getTeamRules().size(), 1);
    }

}
