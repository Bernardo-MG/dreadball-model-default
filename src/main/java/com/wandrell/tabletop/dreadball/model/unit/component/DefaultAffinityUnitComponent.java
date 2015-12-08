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

package com.wandrell.tabletop.dreadball.model.unit.component;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;

import com.wandrell.tabletop.dreadball.model.unit.TeamPosition;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

/**
 * Default implementation of {@code AffinityUnitComponent}.
 * <p>
 * It uses composition to inherit from {@link DefaultUnitComponent}.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class DefaultAffinityUnitComponent
        implements AffinityUnitComponent {

    /**
     * {@code UnitComponent} used for inheritance through composition.
     */
    private final UnitComponent baseComponent;
    /**
     * The actual cost of the component.
     */
    private Integer             costActual = 0;
    /**
     * Component cost for an ally.
     */
    private final Integer       costAlly;
    /**
     * Component cost for a friend.
     */
    private final Integer       costFriend;
    /**
     * Component cost for a stranger.
     */
    private final Integer       costStranger;

    /**
     * Constructs a {@code DefaultAffinityUnitComponent} with the specified
     * arguments.
     * 
     * @param name
     *            name of the component
     * @param location
     *            location where the component is applied
     * @param allyCost
     *            cost of the component for an ally
     * @param friendCost
     *            cost of the component for a friend
     * @param strangerCost
     *            cost of the component for a stranger
     * @param positions
     *            team position roles which can have this component
     * @param attributes
     *            attributes granted by the component
     * @param abilities
     *            abilities granted by the component
     */
    public DefaultAffinityUnitComponent(final String name,
            final ComponentLocation location, final Integer allyCost,
            final Integer friendCost, final Integer strangerCost,
            final Collection<TeamPosition> positions,
            final AttributesHolder attributes,
            final Collection<Ability> abilities) {
        super();

        costAlly = checkNotNull(allyCost,
                "Received a null pointer as ally cost");
        costFriend = checkNotNull(friendCost,
                "Received a null pointer as friend cost");
        costStranger = checkNotNull(strangerCost,
                "Received a null pointer as stranger cost");

        costActual = costStranger;

        baseComponent = new DefaultUnitComponent(name, location, 0, positions,
                attributes, abilities);
    }

    @Override
    public final Collection<Ability> getAbilities() {
        return getBaseComponent().getAbilities();
    }

    @Override
    public final Integer getAllyCost() {
        return costAlly;
    }

    @Override
    public final AttributesHolder getAttributes() {
        return getBaseComponent().getAttributes();
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
    public final ComponentLocation getLocation() {
        return getBaseComponent().getLocation();
    }

    @Override
    public final String getName() {
        return getBaseComponent().getName();
    }

    @Override
    public final Integer getStrangerCost() {
        return costStranger;
    }

    @Override
    public final Collection<TeamPosition> getTeamPositions() {
        return getBaseComponent().getTeamPositions();
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

    /**
     * Returns the base component class being used for inheritance through
     * composition.
     * 
     * @return the base component class being used for inheritance through
     *         composition
     */
    private final UnitComponent getBaseComponent() {
        return baseComponent;
    }

}
