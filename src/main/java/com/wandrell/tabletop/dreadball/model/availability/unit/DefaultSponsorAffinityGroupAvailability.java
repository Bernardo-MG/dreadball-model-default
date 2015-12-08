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

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;

/**
 * Default serializable implementation of
 * {@link SponsorAffinityGroupAvailability}.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class DefaultSponsorAffinityGroupAvailability
        implements SponsorAffinityGroupAvailability {

    /**
     * Available affinities groups.
     */
    private final Collection<AffinityGroup> avaAffinities = new LinkedHashSet<AffinityGroup>();
    /**
     * Name of the affinities.
     */
    private final String                    avaName;
    /**
     * Flag indicating if the availability allows increasing the rank.
     */
    private final Boolean                   hasRankInc;

    /**
     * Constructs a {@code DefaultSponsorAffinityGroupAvailability} with the
     * specified arguments.
     * 
     * @param name
     *            name of the availability
     * @param affinities
     *            available affinities
     * @param rankIncrease
     *            flag indicating if a rank increase is available
     */
    public DefaultSponsorAffinityGroupAvailability(final String name,
            final Collection<AffinityGroup> affinities,
            final Boolean rankIncrease) {
        super();

        avaName = checkNotNull(name,
                "Received a null pointer as the availability name");
        hasRankInc = checkNotNull(rankIncrease,
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
        return Collections
                .unmodifiableCollection(getAffinityGroupsModifiable());
    }

    @Override
    public final String getName() {
        return avaName;
    }

    @Override
    public final Boolean isIncludingRankIncrease() {
        return hasRankInc;
    }

    /**
     * Returns a modifiable collection with the available affinities.
     * 
     * @return a modifiable collection with the available affinities
     */
    private final Collection<AffinityGroup> getAffinityGroupsModifiable() {
        return avaAffinities;
    }

}
