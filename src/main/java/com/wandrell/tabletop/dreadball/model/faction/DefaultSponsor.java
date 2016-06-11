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

package com.wandrell.tabletop.dreadball.model.faction;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;

/**
 * Sponsor, which are the Dreadball Xtreme (DBX) factions.
 * <p>
 * This is an immutable implementation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class DefaultSponsor implements Sponsor {

    /**
     * Sponsor's player groups.
     */
    private final Collection<AffinityGroup> affinityGroups = new LinkedHashSet<>();

    /**
     * Sponsor's unspent cash.
     */
    private Integer                         sponsorCash    = 0;

    /**
     * Sponsor's name.
     */
    private String                          sponsorName    = "";

    /**
     * Sponsor's rank.
     */
    private Integer                         sponsorRank    = 0;

    /**
     * Constructs a {@code DefaultSponsor}.
     */
    public DefaultSponsor() {
        super();
    }

    @Override
    public final void addAffinityGroup(final AffinityGroup affinity) {
        getAffinityGroupsModifiable().add(affinity);
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

        final DefaultSponsor other;

        other = (DefaultSponsor) obj;
        return Objects.equals(sponsorName, other.sponsorName);
    }

    @Override
    public final Collection<AffinityGroup> getAffinityGroups() {
        return Collections
                .unmodifiableCollection(getAffinityGroupsModifiable());
    }

    @Override
    public final Integer getCash() {
        return sponsorCash;
    }

    @Override
    public final String getName() {
        return sponsorName;
    }

    @Override
    public final Integer getRank() {
        return sponsorRank;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(sponsorName);
    }

    @Override
    public final void removeAffinityGroup(final AffinityGroup affinity) {
        getAffinityGroupsModifiable().remove(affinity);
    }

    @Override
    public final void
            setAffinityGroups(final Collection<AffinityGroup> affinities) {
        getAffinityGroupsModifiable().clear();
        getAffinityGroupsModifiable().addAll(affinities);
    }

    @Override
    public final void setCash(final Integer cash) {
        sponsorCash = cash;
    }

    @Override
    public final void setName(final String name) {
        sponsorName = name;
    }

    @Override
    public final void setRank(final Integer rank) {
        sponsorRank = checkNotNull(rank, "Received a null pointer as rank");
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", sponsorName)
                .add("rank", sponsorRank).toString();
    }

    /**
     * Returns the modifiable list of the sponsor's player groups.
     * 
     * @return the modifiable list of the sponsor's player groups
     */
    private final Collection<AffinityGroup> getAffinityGroupsModifiable() {
        return affinityGroups;
    }

}
