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

package com.wandrell.tabletop.dreadball.model.unit;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.dreadball.model.unit.component.Component;
import com.wandrell.tabletop.dreadball.model.unit.component.DefaultComponent;
import com.wandrell.tabletop.dreadball.model.unit.component.DefaultComponentLocation;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.Attributes;
import com.wandrell.tabletop.dreadball.model.unit.stats.ImmutableAttributes;

/**
 * Unit which may change and evolve over time, usually between matches.
 * <p>
 * This is an immutable implementation.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class DefaultAdvancementUnit implements AdvancementUnit {

    /**
     * {@code Unit} used for inheritance through composition.
     */
    private final Unit                                      baseUnit;

    /**
     * The unspent experience.
     */
    private Integer                                         experienceValue;

    /**
     * Implant grafted to the unit. This is a {@code Unit}, the same objects
     * used for composite units.
     * <p>
     * Be default it will be a stub component.
     */
    private Component                                       graftedImplant = new DefaultComponent(
            "none", new DefaultComponentLocation("none"), 0,
            new LinkedList<Role>(), new ImmutableAttributes(0, 0, 0, 0, 0),
            new LinkedList<Ability>());

    /**
     * The unit's current rank.
     */
    private Integer                                         rankValue;

    /**
     * The unit's abilities.
     */
    private final Collection<Ability>                       unitAbilities  = new LinkedHashSet<>();

    /**
     * Unit's attributes.
     */
    private Attributes                                      unitAttributes;

    /**
     * Name given to the unit.
     */
    private String                                          unitName       = "";

    /**
     * Object used for calculating the unit valoration.
     */
    private final UnitValorationCalculator<AdvancementUnit> valorationBuilder;

    /**
     * Constructs a {@code DefaultAdvancementUnit} with the specified arguments.
     * 
     * @param nameTemplate
     *            the unit's base template name
     * @param cost
     *            cost of the unit
     * @param role
     *            team position role of the unit
     * @param attributes
     *            unit attributes
     * @param abilities
     *            unit abilities
     * @param giant
     *            flag indicating if this is a giant
     * @param valorator
     *            calculator for the valoration
     */
    public DefaultAdvancementUnit(final String nameTemplate, final Integer cost,
            final Role role, final Attributes attributes,
            final Collection<Ability> abilities, final Boolean giant,
            final UnitValorationCalculator<AdvancementUnit> valorator) {
        super();

        baseUnit = new DefaultUnit(nameTemplate, cost, role, attributes,
                abilities, giant);

        unitAbilities.addAll(baseUnit.getAbilities());

        valorationBuilder = checkNotNull(valorator,
                "Received a null pointer as valoration builder");
    }

    @Override
    public final void addAbility(final Ability ability) {
        getAbilitiesModifiable().add(ability);
    }

    @Override
    public final Collection<Ability> getAbilities() {
        return Collections.unmodifiableCollection(getAbilitiesModifiable());
    }

    @Override
    public final Attributes getAttributes() {
        return unitAttributes;
    }

    @Override
    public final Integer getCost() {
        return getBaseUnit().getCost();
    }

    @Override
    public final Component getGraftedImplant() {
        return graftedImplant;
    }

    @Override
    public final String getName() {
        return unitName;
    }

    @Override
    public final Integer getRank() {
        return rankValue;
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
        return experienceValue;
    }

    @Override
    public final Integer getValoration() {
        return getValorationCalculator().getValoration(this);
    }

    @Override
    public final Boolean isGiant() {
        return getBaseUnit().isGiant();
    }

    @Override
    public final void removeAbility(final Ability ability) {
        getAbilitiesModifiable().remove(ability);
    }

    @Override
    public final void setAbilities(final Collection<Ability> abilities) {
        getAbilitiesModifiable().clear();
        getAbilitiesModifiable().addAll(abilities);
    }

    @Override
    public final void setAttributes(final Attributes attributes) {
        unitAttributes = attributes;
    }

    @Override
    public final void setGraftedImplant(final Component implant) {
        graftedImplant = implant;
    }

    @Override
    public final void setName(final String name) {
        unitName = name;
    }

    @Override
    public final void setRank(final Integer rank) {
        rankValue = checkNotNull(rank, "Received a null pointer as rank");
    }

    @Override
    public final void setUnspentExperience(final Integer experience) {
        experienceValue = checkNotNull(experience,
                "Received a null pointer as experience");
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("rank", rankValue)
                .add("experience", experienceValue).add("role", getRole())
                .add("giant", isGiant()).toString();
    }

    /**
     * Returns the modifiable list of the unit's abilities.
     * 
     * @return the modifiable list of the unit's abilities
     */
    private final Collection<Ability> getAbilitiesModifiable() {
        return unitAbilities;
    }

    /**
     * Returns the base unit class being used for inheritance through
     * composition.
     * 
     * @return the base unit class being used for inheritance through
     *         composition
     */
    private final Unit getBaseUnit() {
        return baseUnit;
    }

    /**
     * Returns the valoration calculator.
     * 
     * @return the valoration calculator
     */
    private final UnitValorationCalculator<AdvancementUnit>
            getValorationCalculator() {
        return valorationBuilder;
    }

}
