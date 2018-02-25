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
import java.util.LinkedHashSet;
import java.util.Objects;

import com.bernardomg.tabletop.dreadball.model.player.AffinityTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.DefaultAffinityTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.Role;
import com.bernardomg.tabletop.dreadball.model.player.component.Component;
import com.bernardomg.tabletop.dreadball.model.player.component.CompositeAffinityTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.stats.Ability;
import com.bernardomg.tabletop.dreadball.model.player.stats.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.player.stats.Attributes;

/**
 * Composite affinity unit.
 * <p>
 * This is an immutable implementation.
 * <p>
 * It uses composition to inherit from {@link DefaultAffinityTeamPlayer}.
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
     * {@code AffinityUnit} used for inheritance through composition.
     */
    private final AffinityTeamPlayer    baseUnit;

    /**
     * Components of the unit.
     */
    private final Collection<Component> unitComponents   = new LinkedHashSet<Component>();

    /**
     * Constructs a composite affinities unit with the specified arguments.
     * 
     * @param nameTemplate
     *            the unit's base template name
     * @param position
     *            team position role of the unit
     * @param attributes
     *            unit attributes
     * @param abilities
     *            unit abilities
     * @param mvp
     *            flag indicating if this is a MVP
     * @param giant
     *            flag indicating if this is a giant
     * @param affinities
     *            the unit affinities
     * @param hated
     *            the unit hated affinities
     * @param allyCost
     *            the unit cost for an ally
     * @param friendCost
     *            the unit cost for a friend
     * @param strangerCost
     *            the unit cost for a stranger
     * @param components
     *            components which create this unit
     */
    public DefaultCompositeAffinityTeamPlayer(final String nameTemplate,
            final Role position, final Attributes attributes,
            final Collection<Ability> abilities, final Boolean mvp,
            final Boolean giant, final Collection<AffinityGroup> affinities,
            final Collection<AffinityGroup> hated, final Integer allyCost,
            final Integer friendCost, final Integer strangerCost,
            final Collection<Component> components) {
        super();

        baseUnit = new DefaultAffinityTeamPlayer(nameTemplate, position, attributes,
                abilities, mvp, giant, affinities, hated, allyCost, friendCost,
                strangerCost);

        checkNotNull(components,
                "Received a null pointer as valoration the components");

        for (final Component component : components) {
            checkNotNull(component,
                    "Received a null pointer as valoration a component");

            unitComponents.add(component);
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
        return Objects.equals(baseUnit, other.baseUnit);
    }

    @Override
    public final Collection<Ability> getAbilities() {
        return getBaseUnit().getAbilities();
    }

    @Override
    public final Collection<AffinityGroup> getAffinityGroups() {
        return getBaseUnit().getAffinityGroups();
    }

    @Override
    public final Integer getAllyCost() {
        return getBaseUnit().getAllyCost();
    }

    @Override
    public final Attributes getAttributes() {
        return getBaseUnit().getAttributes();
    }

    /**
     * Returns the components which make up the unit.
     * 
     * @return the components which make up the unit
     */
    @Override
    public final Collection<Component> getComponents() {
        return Collections.unmodifiableCollection(getComponentsModifiable());
    }

    @Override
    public final Integer getCost() {
        return getBaseUnit().getCost();
    }

    @Override
    public final Integer getFriendCost() {
        return getBaseUnit().getFriendCost();
    }

    @Override
    public final Boolean getGiant() {
        return getBaseUnit().getGiant();
    }

    @Override
    public final Collection<AffinityGroup> getHatedAffinityGroups() {
        return getBaseUnit().getAffinityGroups();
    }

    @Override
    public final Boolean getMvp() {
        return getBaseUnit().getMvp();
    }

    @Override
    public final String getName() {
        return getBaseUnit().getName();
    }

    @Override
    public final Role getRole() {
        return getBaseUnit().getRole();
    }

    @Override
    public final Integer getStrangerCost() {
        return getBaseUnit().getStrangerCost();
    }

    @Override
    public final String getTemplateName() {
        return getBaseUnit().getTemplateName();
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(baseUnit);
    }

    @Override
    public final void setName(final String name) {
        getBaseUnit().setName(name);
    }

    /**
     * Returns the base unit class being used for inheritance through
     * composition.
     * 
     * @return the base unit class being used for inheritance through
     *         composition
     */
    private final AffinityTeamPlayer getBaseUnit() {
        return baseUnit;
    }

    /**
     * Returns a modifiable collection with the unit components.
     * 
     * @return a modifiable collection with the unit components
     */
    private final Collection<Component> getComponentsModifiable() {
        return unitComponents;
    }

}
