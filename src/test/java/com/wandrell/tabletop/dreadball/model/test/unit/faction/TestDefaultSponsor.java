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

import java.util.ArrayList;
import java.util.Collection;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.faction.DefaultSponsor;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;

/**
 * Unit tests for {@link DefaultSponsor}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Affinities are not repeated</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestDefaultSponsor {

    /**
     * Default constructor.
     */
    public TestDefaultSponsor() {
        super();
    }

    /**
     * Tests that affinities are not repeated.
     */
    @Test
    public final void testRepeatAffinity_NoRepeats() {
        final Sponsor sponsor;     // Tested sponsor
        final Collection<AffinityGroup> groups; // Sponsor affinities
        final AffinityGroup group; // Mocked affinity group

        // Mocks affinities
        group = Mockito.mock(AffinityGroup.class);
        groups = new ArrayList<>();
        groups.add(group);
        groups.add(group);

        // Creates sponsor
        sponsor = new DefaultSponsor();

        sponsor.setAffinityGroups(groups);

        Assert.assertEquals(sponsor.getAffinityGroups().size(), 1);
    }

}
