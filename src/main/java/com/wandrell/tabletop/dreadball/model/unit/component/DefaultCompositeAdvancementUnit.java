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

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;

import com.wandrell.tabletop.dreadball.model.unit.AdvancementUnit;
import com.wandrell.tabletop.dreadball.model.unit.DefaultAdvancementUnit;
import com.wandrell.tabletop.dreadball.model.unit.Role;
import com.wandrell.tabletop.dreadball.model.unit.UnitValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.Attributes;

/**
 * Composite advancement unit.
 * <p>
 * It uses composition to inherit from {@link DefaultAdvancementUnit}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class DefaultCompositeAdvancementUnit
        implements CompositeAdvancementUnit, Serializable {

    /**
     * Serialization id.
     */
    private static final long           serialVersionUID = 6492427235549316354L;

    /**
     * {@code AdvancementUnit} used for inheritance through composition.
     */
    private final AdvancementUnit       baseUnit;

    /**
     * Components of the unit.
     */
    private final Collection<Component> unitComponents   = new LinkedHashSet<Component>();

    /**
     * Constructs a composite advancement unit with the specified arguments.
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
     * @param mvp
     *            flag indicating if this is a MVP
     * @param giant
     *            flag indicating if this is a giant
     * @param valorator
     *            calculator for the valoration
     * @param components
     *            components which create this unit
     */
    public DefaultCompositeAdvancementUnit(final String nameTemplate,
            final Integer cost, final Role position,
            final Attributes attributes, final Collection<Ability> abilities,
            final Boolean mvp, final Boolean giant,
            final UnitValorationCalculator<AdvancementUnit> valorator,
            final Collection<Component> components) {
        super();

        baseUnit = new DefaultAdvancementUnit(nameTemplate, cost, position,
                attributes, abilities, mvp, giant, valorator);

        checkNotNull(components,
                "Received a null pointer as valoration the components");

        for (final Component component : components) {
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

        final DefaultCompositeAdvancementUnit other;

        other = (DefaultCompositeAdvancementUnit) obj;
        return Objects.equals(baseUnit, other.baseUnit);
    }

    @Override
    public final Collection<Ability> getAbilities() {
        return getBaseUnit().getAbilities();
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
    public final Boolean getGiant() {
        return getBaseUnit().getGiant();
    }

    @Override
    public final Component getGraftedImplant() {
        return getBaseUnit().getGraftedImplant();
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
    public final Integer getRank() {
        return getBaseUnit().getRank();
    }

    @Override
    public final Role getRole() {
        return getBaseUnit().getRole();
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
    public final int hashCode() {
        return Objects.hashCode(baseUnit);
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
    public final void setAttributes(final Attributes attributes) {
        getBaseUnit().setAttributes(attributes);
    }

    @Override
    public final void setGraftedImplant(final Component implant) {
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
    private final Collection<Component> getComponentsModifiable() {
        return unitComponents;
    }

}
