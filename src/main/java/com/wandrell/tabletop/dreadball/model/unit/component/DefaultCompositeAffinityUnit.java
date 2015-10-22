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
import java.util.Collections;
import java.util.LinkedHashSet;

import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.DefaultAffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.TeamPosition;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

/**
 * Default implementation of {@code CompositeAffinityUnit}.
 * <p>
 * It uses composition to inherit from {@link DefaultAffinityUnit}.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class DefaultCompositeAffinityUnit
        implements CompositeAffinityUnit {

    /**
     * {@code AffinityUnit} used for inheritance through composition.
     */
    private final AffinityUnit              baseUnit;
    /**
     * Components of the unit.
     */
    private final Collection<UnitComponent> unitComponents = new LinkedHashSet<UnitComponent>();

    /**
     * Constructs a {@code DefaultCompositeAffinityUnit} with the specified
     * arguments.
     * 
     * @param nameTemplate
     *            the unit's base template name
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
    public DefaultCompositeAffinityUnit(final String nameTemplate,
            final TeamPosition position, final AttributesHolder attributes,
            final Collection<Ability> abilities, final Boolean giant,
            final Collection<AffinityGroup> affinities,
            final Collection<AffinityGroup> hated, final Integer allyCost,
            final Integer friendCost, final Integer strangerCost,
            final Collection<UnitComponent> components) {
        super();

        baseUnit = new DefaultAffinityUnit(nameTemplate, position, attributes,
                abilities, giant, affinities, hated, allyCost, friendCost,
                strangerCost);

        checkNotNull(components,
                "Received a null pointer as valoration the components");

        for (final UnitComponent component : components) {
            checkNotNull(component,
                    "Received a null pointer as valoration a component");

            unitComponents.add(component);
        }
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

    /**
     * Returns the components which make up the unit.
     * 
     * @return the components which make up the unit
     */
    @Override
    public final Collection<UnitComponent> getComponents() {
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
    public final Collection<AffinityGroup> getHatedAffinityGroups() {
        return getBaseUnit().getAffinityGroups();
    }

    @Override
    public final String getName() {
        return getBaseUnit().getName();
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
    private final AffinityUnit getBaseUnit() {
        return baseUnit;
    }

    /**
     * Returns a modifiable collection with the unit components.
     * 
     * @return a modifiable collection with the unit components
     */
    private final Collection<UnitComponent> getComponentsModifiable() {
        return unitComponents;
    }

}
