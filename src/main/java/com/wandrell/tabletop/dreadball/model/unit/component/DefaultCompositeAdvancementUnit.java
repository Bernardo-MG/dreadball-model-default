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

package com.wandrell.tabletop.dreadball.model.unit.component;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import com.wandrell.tabletop.dreadball.model.unit.AdvancementUnit;
import com.wandrell.tabletop.dreadball.model.unit.DefaultAdvancementUnit;
import com.wandrell.tabletop.dreadball.model.unit.TeamPosition;
import com.wandrell.tabletop.dreadball.model.unit.UnitValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

/**
 * Default implementation of {@code CompositeAdvancementUnit}.
 * <p>
 * It uses composition to inherit from {@link DefaultAdvancementUnit}.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class DefaultCompositeAdvancementUnit
        implements CompositeAdvancementUnit {

    /**
     * {@code AdvancementUnit} used for inheritance through composition.
     */
    private final AdvancementUnit           baseUnit;

    /**
     * Components of the unit.
     */
    private final Collection<UnitComponent> unitComponents = new LinkedHashSet<UnitComponent>();

    /**
     * Constructs a {@code DefaultCompositeAdvancementUnit} with the specified
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
     * @param valorator
     *            calculator for the valoration
     * @param components
     *            components which create this unit
     */
    public DefaultCompositeAdvancementUnit(final String nameTemplate,
            final Integer cost, final TeamPosition position,
            final AttributesHolder attributes,
            final Collection<Ability> abilities, final Boolean giant,
            final UnitValorationCalculator<AdvancementUnit> valorator,
            final Collection<UnitComponent> components) {
        super();

        baseUnit = new DefaultAdvancementUnit(nameTemplate, cost, position,
                attributes, abilities, giant, valorator);

        checkNotNull(components,
                "Received a null pointer as valoration the components");

        for (final UnitComponent component : components) {
            checkNotNull(component,
                    "Received a null pointer as valoration a component");

            unitComponents.add(component);
        }
    }

    @Override
    public final void addAbility(final Ability ability) {
        getBaseUnit().addAbility(ability);
    }

    @Override
    public final Collection<Ability> getAbilities() {
        return getBaseUnit().getAbilities();
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
    public final UnitComponent getGraftedImplant() {
        return getBaseUnit().getGraftedImplant();
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
    public final Integer getRank() {
        return getBaseUnit().getRank();
    }

    @Override
    public final String getTemplateName() {
        return getBaseUnit().getTemplateName();
    }

    @Override
    public final Integer getUnspentExperience() {
        return getBaseUnit().getUnspentExperience();
    }

    @Override
    public final Integer getValoration() {
        return getBaseUnit().getValoration();
    }

    @Override
    public final Boolean isGiant() {
        return getBaseUnit().isGiant();
    }

    @Override
    public final void removeAbility(final Ability ability) {
        getBaseUnit().removeAbility(ability);
    }

    @Override
    public final void setAbilities(final Collection<Ability> abilities) {
        getBaseUnit().setAbilities(abilities);
    }

    @Override
    public final void setAttributes(final AttributesHolder attributes) {
        getBaseUnit().setAttributes(attributes);
    }

    @Override
    public final void setGraftedImplant(final UnitComponent implant) {
        getBaseUnit().setGraftedImplant(implant);
    }

    @Override
    public final void setName(final String name) {
        getBaseUnit().setName(name);
    }

    @Override
    public final void setRank(final Integer rank) {
        getBaseUnit().setRank(rank);
    }

    @Override
    public final void setUnspentExperience(final Integer experience) {
        getBaseUnit().setUnspentExperience(experience);
    }

    /**
     * Returns the base unit class being used for inheritance through
     * composition.
     * 
     * @return the base unit class being used for inheritance through
     *         composition
     */
    private final AdvancementUnit getBaseUnit() {
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
