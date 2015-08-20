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
package com.wandrell.tabletop.dreadball.model.faction;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;

/**
 * Default implementation of {@code Sponsor}.
 * 
 * @author Bernardo Martíne Garrido
 */
public final class DefaultSponsor implements Sponsor, Serializable {

    /**
     * Serialization ID.
     */
    private static final long               serialVersionUID = -3799600983257148587L;
    /**
     * Sponsor's player groups.
     */
    private final Collection<AffinityGroup> affinityGroups   = new LinkedHashSet<>();
    /**
     * Sponsor's name.
     */
    private final String                    sponsorName;
    /**
     * Sponsor's rank.
     */
    private Integer                         sponsorRank      = 0;

    /**
     * Constructs a {@code DefaultSponsor} with the specified parameters.
     * 
     * @param name
     *            sponsor's name
     * @param rank
     *            sponsor's rank
     * @param groups
     *            sponsor's groups
     */
    public DefaultSponsor(final String name, final Integer rank,
            final Collection<AffinityGroup> groups) {
        super();

        sponsorName = checkNotNull(name, "Received a null pointer as name");
        sponsorRank = checkNotNull(rank, "Received a null pointer as rank");

        checkNotNull(groups, "Received a null pointer as groups");

        for (final AffinityGroup group : groups) {
            affinityGroups.add(
                    checkNotNull(group, "Received a null pointer as group"));
        }
    }

    @Override
    public void addAfinityGroup(AffinityGroup arg0) {
        // TODO Auto-generated method stub

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
    public Integer getCash() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public final Integer getRank() {
        return sponsorRank;
    }

    @Override
    public final String getSponsorName() {
        return sponsorName;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(sponsorName);
    }

    @Override
    public void removeAfinityGroup(AffinityGroup arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setCash(Integer arg0) {
        // TODO Auto-generated method stub

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
