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

import com.bernardomg.tabletop.dreadball.model.player.AffinityTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.Role;
import com.bernardomg.tabletop.dreadball.model.player.TeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.stats.Ability;
import com.bernardomg.tabletop.dreadball.model.player.stats.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.player.stats.Attributes;

/**
 * Unit with affinity groups, and various costs which will depend on how many of
 * such affinities are shared.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class DefaultAffinityTeamPlayer
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
     * {@code Unit} used for inheritance through composition.
     */
    private final TeamPlayer                baseUnit;

    /**
     * The actual cost of the player.
     */
    private Integer                         costActual       = 0;

    /**
     * Unit cost for an ally.
     */
    private final Integer                   costAlly;

    /**
     * Unit cost for a friend.
     */
    private final Integer                   costFriend;

    /**
     * Unit cost for a stranger.
     */
    private final Integer                   costStranger;

    /**
     * The affinities hated by the player.
     */
    private final Collection<AffinityGroup> hatedAffinities  = new LinkedHashSet<AffinityGroup>();

    /**
     * Name given to the player.
     */
    private String                          playerName       = "";

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
     * @param allyCost
     *            the player cost for an ally
     * @param friendCost
     *            the player cost for a friend
     * @param strangerCost
     *            the player cost for a stranger
     */
    public DefaultAffinityTeamPlayer(final String nameTemplate, final Role role,
            final Attributes attributes, final Collection<Ability> abilities,
            final Boolean mvp, final Boolean giant,
            final Collection<AffinityGroup> affinities,
            final Collection<AffinityGroup> hated, final Integer allyCost,
            final Integer friendCost, final Integer strangerCost) {
        super();

        baseUnit = new DefaultTeamPlayer(nameTemplate, 0, role, attributes,
                abilities, mvp, giant);

        costAlly = checkNotNull(allyCost,
                "Received a null pointer as ally cost");
        costFriend = checkNotNull(friendCost,
                "Received a null pointer as friend cost");
        costStranger = checkNotNull(strangerCost,
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

        final DefaultAffinityTeamPlayer other;

        other = (DefaultAffinityTeamPlayer) obj;
        return Objects.equals(baseUnit, other.baseUnit)
                && Objects.equals(playerName, other.playerName);
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
        return costAlly;
    }

    @Override
    public final Attributes getAttributes() {
        return getBaseUnit().getAttributes();
    }

    @Override
    public final Integer getCost() {
        return costActual;
    }

    @Override
    public final Integer getFriendCost() {
        return costFriend;
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
        return playerName;
    }

    @Override
    public final Role getRole() {
        return getBaseUnit().getRole();
    }

    @Override
    public final Integer getStrangerCost() {
        return costStranger;
    }

    @Override
    public final String getTemplateName() {
        return getBaseUnit().getTemplateName();
    }

    @Override
    public final int hashCode() {
        return Objects.hash(baseUnit, playerName);
    }

    /**
     * Sets the cost as the ally cost.
     */
    public final void setCostForAlly() {
        costActual = getAllyCost();
    }

    /**
     * Sets the cost as the friend cost.
     */
    public final void setCostForFriend() {
        costActual = getFriendCost();
    }

    /**
     * Sets the cost as the stranger cost.
     */
    public final void setCostForStranger() {
        costActual = getStrangerCost();
    }

    @Override
    public final void setName(final String name) {
        playerName = name;
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
