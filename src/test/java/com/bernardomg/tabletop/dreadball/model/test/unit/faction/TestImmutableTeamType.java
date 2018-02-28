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

package com.bernardomg.tabletop.dreadball.model.test.unit.faction;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.model.faction.ImmutableTeamType;
import com.bernardomg.tabletop.dreadball.model.faction.TeamRule;
import com.bernardomg.tabletop.dreadball.model.faction.TeamType;

/**
 * Unit tests for {@link ImmutableTeamType}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestImmutableTeamType {

    /**
     * Default constructor.
     */
    public TestImmutableTeamType() {
        super();
    }

    /**
     * Tests that team rules are not repeated.
     */
    @Test
    public final void test_RepeatTeamRule_NoRepeats() {
        final TeamType team; // Tested team type
        final Collection<TeamRule> rules; // Team type rules
        final TeamRule rule; // Mocked rule

        // Mocks rules
        rule = Mockito.mock(TeamRule.class);
        rules = new ArrayList<>();
        rules.add(rule);
        rules.add(rule);

        // Creates team
        team = new ImmutableTeamType("name", rules);

        Assert.assertEquals(team.getTeamRules().size(), 1);
    }

}
