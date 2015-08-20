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
package com.wandrell.tabletop.dreadball.model.availability.unit;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;

public final class DefaultSponsorAffinityGroupAvailability
        implements SponsorAffinityGroupAvailability, Serializable {

    /**
     * 
     */
    private static final long               serialVersionUID = 308700884293209100L;
    private final Collection<AffinityGroup> avaAffinities    = new LinkedHashSet<AffinityGroup>();
    private final String                    avaName;
    private final Boolean                   includesRankIncrease;

    public DefaultSponsorAffinityGroupAvailability(final String name,
            final Collection<AffinityGroup> affinities,
            final Boolean rankIncrease) {
        super();

        avaName = checkNotNull(name,
                "Received a null pointer as the availability name");
        includesRankIncrease = checkNotNull(rankIncrease,
                "Received a null pointer as the rank increase flag");

        checkNotNull(affinities,
                "Received a null pointer as the affinity groups");

        for (final AffinityGroup affinity : affinities) {
            checkNotNull(affinity,
                    "Received a null pointer as an affinity group");

            avaAffinities.add(affinity);
        }
    }

    @Override
    public final Collection<AffinityGroup> getAffinityGroups() {
        return Collections.unmodifiableCollection(getPlayerGroupsModifiable());
    }

    @Override
    public final String getName() {
        return avaName;
    }

    @Override
    public final Boolean isIncludingRankIncrease() {
        return includesRankIncrease;
    }

    private final Collection<AffinityGroup> getPlayerGroupsModifiable() {
        return avaAffinities;
    }

}
