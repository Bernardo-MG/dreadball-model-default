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

package com.bernardomg.tabletop.dreadball.model.player.component;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

import com.bernardomg.tabletop.dreadball.model.player.AffinityTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.ImmutableAffinityTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.Role;
import com.bernardomg.tabletop.dreadball.model.player.stats.Ability;
import com.bernardomg.tabletop.dreadball.model.player.stats.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.player.stats.Attributes;
import com.google.common.base.MoreObjects;

/**
 * Composite affinity player.
 * <p>
 * This is an immutable implementation.
 * <p>
 * It uses composition to inherit from {@link ImmutableAffinityTeamPlayer}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class DefaultCompositeAffinityTeamPlayer
        implements CompositeAffinityTeamPlayer, Serializable {

    /**
     * Serialization id.
     */
    private static final long           serialVersionUID = 7289790050324765193L;

    /**
     * {@code AffinityTeamPlayer} used for inheritance through composition.
     */
    private final AffinityTeamPlayer    baseTeamPlayer;

    /**
     * Components of the player.
     */
    private final Collection<Component> components       = new HashSet<Component>();

    /**
     * Constructs a composite affinities player with the specified arguments.
     * 
     * @param nameTemplate
     *            the player's base template name
     * @param position
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
     * @param allyCost
     *            the player cost for an ally
     * @param friendCost
     *            the player cost for a friend
     * @param strangerCost
     *            the player cost for a stranger
     * @param comps
     *            components which create this player
     */
    public DefaultCompositeAffinityTeamPlayer(final String nameTemplate,
            final Role position, final Attributes attributes,
            final Collection<Ability> abilities, final Boolean mvp,
            final Boolean giant, final Collection<AffinityGroup> affinities,
            final Collection<AffinityGroup> hated, final Integer currentCost,
            final Integer allyCost, final Integer friendCost,
            final Integer strangerCost, final Collection<Component> comps) {
        super();

        baseTeamPlayer = new ImmutableAffinityTeamPlayer(nameTemplate, position,
                attributes, abilities, mvp, giant, affinities, hated,
                currentCost, allyCost, friendCost, strangerCost);

        checkNotNull(comps,
                "Received a null pointer as valoration the components");

        for (final Component component : comps) {
            checkNotNull(component,
                    "Received a null pointer as valoration a component");

            components.add(component);
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

        final DefaultCompositeAffinityTeamPlayer other;

        other = (DefaultCompositeAffinityTeamPlayer) obj;
        return Objects.equals(baseTeamPlayer, other.baseTeamPlayer);
    }

    @Override
    public final Collection<Ability> getAbilities() {
        return getBaseTeamPlayer().getAbilities();
    }

    @Override
    public final Collection<AffinityGroup> getAffinityGroups() {
        return getBaseTeamPlayer().getAffinityGroups();
    }

    @Override
    public final Integer getAllyCost() {
        return getBaseTeamPlayer().getAllyCost();
    }

    @Override
    public final Attributes getAttributes() {
        return getBaseTeamPlayer().getAttributes();
    }

    /**
     * Returns the components which make up the player.
     * 
     * @return the components which make up the player
     */
    @Override
    public final Collection<Component> getComponents() {
        return Collections.unmodifiableCollection(getComponentsModifiable());
    }

    @Override
    public final Integer getCost() {
        return getBaseTeamPlayer().getCost();
    }

    @Override
    public final Integer getFriendCost() {
        return getBaseTeamPlayer().getFriendCost();
    }

    @Override
    public final Boolean getGiant() {
        return getBaseTeamPlayer().getGiant();
    }

    @Override
    public final Collection<AffinityGroup> getHatedAffinityGroups() {
        return getBaseTeamPlayer().getAffinityGroups();
    }

    @Override
    public final Boolean getMvp() {
        return getBaseTeamPlayer().getMvp();
    }

    @Override
    public final String getName() {
        return getBaseTeamPlayer().getName();
    }

    @Override
    public final Role getRole() {
        return getBaseTeamPlayer().getRole();
    }

    @Override
    public final Integer getStrangerCost() {
        return getBaseTeamPlayer().getStrangerCost();
    }

    @Override
    public final String getTemplateName() {
        return getBaseTeamPlayer().getTemplateName();
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(baseTeamPlayer);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("baseTeamPlayer", baseTeamPlayer)
                .add("components", components).toString();
    }

    /**
     * Returns the base player class being used for inheritance through
     * composition.
     * 
     * @return the base player class being used for inheritance through
     *         composition
     */
    private final AffinityTeamPlayer getBaseTeamPlayer() {
        return baseTeamPlayer;
    }

    /**
     * Returns a modifiable collection with the player components.
     * 
     * @return a modifiable collection with the player components
     */
    private final Collection<Component> getComponentsModifiable() {
        return components;
    }

}
