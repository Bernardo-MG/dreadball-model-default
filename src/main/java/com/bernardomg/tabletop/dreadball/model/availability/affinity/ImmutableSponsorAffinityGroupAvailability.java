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

package com.bernardomg.tabletop.dreadball.model.availability.affinity;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;

import com.bernardomg.tabletop.dreadball.model.player.stats.AffinityGroup;

/**
 * Affinity group availabilities for a
 * {@link com.bernardomg.tabletop.dreadball.model.faction.Sponsor Sponsors}, to
 * be acquired during their creation.
 * <p>
 * This is an immutable implementation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ImmutableSponsorAffinityGroupAvailability
        implements SponsorAffinityGroupAvailability, Serializable {

    /**
     * Serialization id.
     */
    private static final long               serialVersionUID = -2200485736264981563L;

    /**
     * Available affinities groups.
     */
    private final Collection<AffinityGroup> affinityGroups   = new LinkedHashSet<AffinityGroup>();

    /**
     * Name of the affinities.
     */
    private final String                    avaName;

    /**
     * Flag indicating if the availability allows increasing the rank.
     */
    private final Boolean                   hasRankInc;

    /**
     * Constructs a set of affinity groups availabilities for sponsors.
     * 
     * @param name
     *            name of the availability
     * @param affinities
     *            available affinities
     * @param rankIncrease
     *            flag indicating if a rank increase is available
     */
    public ImmutableSponsorAffinityGroupAvailability(final String name,
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

            affinityGroups.add(affinity);
        }
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final ImmutableSponsorAffinityGroupAvailability other;

        other = (ImmutableSponsorAffinityGroupAvailability) obj;
        return Objects.equals(avaName, other.avaName);
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
    public final int hashCode() {
        return Objects.hashCode(avaName);
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
        return affinityGroups;
    }

}
