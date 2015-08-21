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

import java.io.Serializable;
import java.util.Collection;

import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.DefaultAffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.TeamPosition;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

/**
 * Default serializable implementation of {@code CompositeAffinityUnit}.
 * <p>
 * It uses composition to inherit from {@link DefaultAffinityUnit}.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class DefaultCompositeAffinityUnit extends AbstractCompositeUnit
        implements CompositeAffinityUnit, Serializable {

    /**
     * Serialization ID.
     */
    private static final long  serialVersionUID = -1404285761905647497L;
    /**
     * {@code AffinityUnit} used for inheritance through composition.
     */
    private final AffinityUnit baseUnit;

    /**
     * Constructs a {@code DefaultCompositeAffinityUnit} with the specified
     * arguments.
     * 
     * @param nameTemplate
     *            the unit's base template name
     * @param cost
     *            cost of the unit
     * @param position
     *            team position role of the unit
     * @param attributes
     *            unit attributes
     * @param abilities
     *            unit abilities
     * @param giant
     *            flag indicating if this is a giant
     * @param affinities
     *            the unit affinities
     * @param allyCost
     *            the unit cost for an ally
     * @param friendCost
     *            the unit cost for a friend
     * @param strangerCost
     *            the unit cost for a stranger
     * @param components
     *            components which create this unit
     */
    public DefaultCompositeAffinityUnit(final String nameTemplate,
            final Integer cost, final TeamPosition position,
            final AttributesHolder attributes,
            final Collection<Ability> abilities, final Boolean giant,
            final Collection<AffinityGroup> affinities, final Integer allyCost,
            final Integer friendCost, final Integer strangerCost,
            final Collection<UnitComponent> components) {
        super(components);

        baseUnit = new DefaultAffinityUnit(nameTemplate, position, attributes,
                abilities, giant, affinities, allyCost, friendCost,
                strangerCost);
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
    public final AttributesHolder getAttributes() {
        return getBaseUnit().getAttributes();
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
    public final TeamPosition getPosition() {
        return getBaseUnit().getPosition();
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
    public final Boolean isGiant() {
        return getBaseUnit().isGiant();
    }

    /**
     * Returns the base unit class being used for inheritance through
     * composition.
     * 
     * @return the base unit class being used for inheritance through
     *         composition
     */
    private final AffinityUnit getBaseUnit() {
        return baseUnit;
    }

}
