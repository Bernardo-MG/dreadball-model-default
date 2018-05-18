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
import java.util.Objects;

import com.bernardomg.tabletop.dreadball.model.player.Role;
import com.bernardomg.tabletop.dreadball.model.player.stats.Ability;
import com.bernardomg.tabletop.dreadball.model.player.stats.Attributes;
import com.google.common.base.MoreObjects;

/**
 * Component with affinity groups, and various costs which will depend on how
 * many of such affinities are shared.
 * <p>
 * It uses composition to inherit from {@link ImmutableComponent}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ImmutableAffinityComponent
        implements AffinityComponent, Serializable {

    /**
     * Serialization id.
     */
    private static final long serialVersionUID = -8763313281233982534L;

    /**
     * Component cost for an ally.
     */
    private final Integer     allyCost;

    /**
     * {@code Component} used for inheritance through composition.
     */
    private final Component   baseComponent;

    /**
     * The actual cost of the component.
     */
    private Integer           cost             = 0;

    /**
     * Component cost for a friend.
     */
    private final Integer     friendCost;

    /**
     * Component cost for a stranger.
     */
    private final Integer     strangerCost;

    /**
     * Constructs an affinities component with the specified arguments.
     * 
     * @param name
     *            name of the component
     * @param location
     *            location where the component is applied
     * @param currentCost
     *            actual cost of the component
     * @param costAlly
     *            cost of the component for an ally
     * @param costFriend
     *            cost of the component for a friend
     * @param costStranger
     *            cost of the component for a stranger
     * @param positions
     *            team position roles which can have this component
     * @param attributes
     *            attributes granted by the component
     * @param abilities
     *            abilities granted by the component
     */
    public ImmutableAffinityComponent(final String name,
            final ComponentLocation location, final Integer currentCost,
            final Integer costAlly, final Integer costFriend,
            final Integer costStranger, final Collection<Role> positions,
            final Attributes attributes, final Collection<Ability> abilities) {
        super();

        cost = checkNotNull(currentCost, "Received a null pointer as cost");

        allyCost = checkNotNull(costAlly,
                "Received a null pointer as ally cost");
        friendCost = checkNotNull(costFriend,
                "Received a null pointer as friend cost");
        strangerCost = checkNotNull(costStranger,
                "Received a null pointer as stranger cost");

        baseComponent = new ImmutableComponent(name, location, 0, positions,
                attributes, abilities);
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

        final ImmutableAffinityComponent other;

        other = (ImmutableAffinityComponent) obj;
        return Objects.equals(baseComponent, other.baseComponent);
    }

    @Override
    public final Collection<Ability> getAbilities() {
        return getBaseComponent().getAbilities();
    }

    @Override
    public final Integer getAllyCost() {
        return allyCost;
    }

    @Override
    public final Attributes getAttributes() {
        return getBaseComponent().getAttributes();
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
    public final ComponentLocation getLocation() {
        return getBaseComponent().getLocation();
    }

    @Override
    public final String getName() {
        return getBaseComponent().getName();
    }

    @Override
    public final Collection<Role> getRoles() {
        return getBaseComponent().getRoles();
    }

    @Override
    public final Integer getStrangerCost() {
        return strangerCost;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(baseComponent);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("baseComponent", baseComponent)
                .add("strangerCost", strangerCost).add("allyCost", allyCost)
                .add("friendCost", friendCost).add("cost", cost).toString();
    }

    /**
     * Returns the base component class being used for inheritance through
     * composition.
     * 
     * @return the base component class being used for inheritance through
     *         composition
     */
    private final Component getBaseComponent() {
        return baseComponent;
    }

}
