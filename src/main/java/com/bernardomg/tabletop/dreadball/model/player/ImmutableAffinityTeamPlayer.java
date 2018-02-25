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

package com.bernardomg.tabletop.dreadball.model.player;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;

import com.bernardomg.tabletop.dreadball.model.player.stats.Ability;
import com.bernardomg.tabletop.dreadball.model.player.stats.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.player.stats.Attributes;

/**
 * Unit with affinity groups, and various costs which will depend on how many of
 * such affinities are shared.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ImmutableAffinityTeamPlayer
        implements AffinityTeamPlayer, Serializable {

    /**
     * Serialization id.
     */
    private static final long               serialVersionUID = 7590874136661141233L;

    /**
     * The affinities of the player.
     */
    private final Collection<AffinityGroup> affinityGroups   = new LinkedHashSet<AffinityGroup>();

    /**
     * Unit cost for an ally.
     */
    private final Integer                   allyCost;

    /**
     * {@code Unit} used for inheritance through composition.
     */
    private final TeamPlayer                baseUnit;

    /**
     * The actual cost of the player.
     */
    private final Integer                   cost;

    /**
     * Unit cost for a friend.
     */
    private final Integer                   friendCost;

    /**
     * The affinities hated by the player.
     */
    private final Collection<AffinityGroup> hatedAffinities  = new LinkedHashSet<AffinityGroup>();

    /**
     * Name given to the player.
     */
    private String                          name             = "";

    /**
     * Unit cost for a stranger.
     */
    private final Integer                   strangerCost;

    /**
     * Constructs an affinity player with the specified arguments.
     * 
     * @param nameTemplate
     *            the player's base template name
     * @param role
     *            team position role of the player
     * @param attributes
     *            player attributes
     * @param abilities
     *            player abilities
     * @param mvp
     *            flag indicating if this is a MVP
     * @param giant
     *            flag indicating if this is a giant
     * @param affinities
     *            the player affinities
     * @param hated
     *            the player hated affinities
     * @param currentCost
     *            actual cost of the player
     * @param costAlly
     *            the player cost for an ally
     * @param costFriend
     *            the player cost for a friend
     * @param costStranger
     *            the player cost for a stranger
     */
    public ImmutableAffinityTeamPlayer(final String nameTemplate, final Role role,
            final Attributes attributes, final Collection<Ability> abilities,
            final Boolean mvp, final Boolean giant,
            final Collection<AffinityGroup> affinities,
            final Collection<AffinityGroup> hated, final Integer currentCost,
            final Integer costAlly, final Integer costFriend,
            final Integer costStranger) {
        super();

        baseUnit = new DefaultTeamPlayer(nameTemplate, 0, role, attributes,
                abilities, mvp, giant);

        cost = checkNotNull(currentCost, "Received a null pointer as cost");

        allyCost = checkNotNull(costAlly,
                "Received a null pointer as ally cost");
        friendCost = checkNotNull(costFriend,
                "Received a null pointer as friend cost");
        strangerCost = checkNotNull(costStranger,
                "Received a null pointer as stranger cost");
        checkNotNull(affinities, "Received a null pointer as affinities");
        checkNotNull(hated, "Received a null pointer as hated affinities");

        for (final AffinityGroup affinity : affinities) {
            affinityGroups.add(checkNotNull(affinity,
                    "Received a null pointer as affinity"));
        }

        for (final AffinityGroup affinity : hated) {
            hatedAffinities.add(checkNotNull(affinity,
                    "Received a null pointer as hated affinity"));
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

        final ImmutableAffinityTeamPlayer other;

        other = (ImmutableAffinityTeamPlayer) obj;
        return Objects.equals(baseUnit, other.baseUnit)
                && Objects.equals(name, other.name);
    }

    @Override
    public final Collection<Ability> getAbilities() {
        return getBaseUnit().getAbilities();
    }

    @Override
    public final Collection<AffinityGroup> getAffinityGroups() {
        return Collections
                .unmodifiableCollection(getAffinityGroupsModifiable());
    }

    @Override
    public final Integer getAllyCost() {
        return allyCost;
    }

    @Override
    public final Attributes getAttributes() {
        return getBaseUnit().getAttributes();
    }

    @Override
    public final Integer getCost() {
        return cost;
    }

    @Override
    public final Integer getFriendCost() {
        return friendCost;
    }

    @Override
    public final Boolean getGiant() {
        return getBaseUnit().getGiant();
    }

    @Override
    public final Collection<AffinityGroup> getHatedAffinityGroups() {
        return Collections
                .unmodifiableCollection(getHatedAffinityGroupsModifiable());
    }

    @Override
    public final Boolean getMvp() {
        return getBaseUnit().getMvp();
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final Role getRole() {
        return getBaseUnit().getRole();
    }

    @Override
    public final Integer getStrangerCost() {
        return strangerCost;
    }

    @Override
    public final String getTemplateName() {
        return getBaseUnit().getTemplateName();
    }

    @Override
    public final int hashCode() {
        return Objects.hash(baseUnit, name);
    }

    @Override
    public final void setName(final String playerName) {
        name = playerName;
    }

    /**
     * Returns the modifiable collection of the player's affinity groups.
     * 
     * @return the modifiable collection of the player's affinity groups
     */
    private final Collection<AffinityGroup> getAffinityGroupsModifiable() {
        return affinityGroups;
    }

    /**
     * Returns the base player class being used for inheritance through
     * composition.
     * 
     * @return the base player class being used for inheritance through
     *         composition
     */
    private final TeamPlayer getBaseUnit() {
        return baseUnit;
    }

    /**
     * Returns the modifiable collection of the player's hated affinity groups.
     * 
     * @return the modifiable collection of the player's hated affinity groups
     */
    private final Collection<AffinityGroup> getHatedAffinityGroupsModifiable() {
        return hatedAffinities;
    }

}
