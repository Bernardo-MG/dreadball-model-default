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
package com.wandrell.tabletop.dreadball.model.unit;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.dreadball.model.unit.component.DefaultComponentLocation;
import com.wandrell.tabletop.dreadball.model.unit.component.DefaultUnitComponent;
import com.wandrell.tabletop.dreadball.model.unit.component.UnitComponent;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;
import com.wandrell.tabletop.dreadball.model.unit.stats.ImmutableAttributesHolder;

/**
 * Default serializable implementation of {@code AdvancementUnit}.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class DefaultAdvancementUnit extends AbstractUnit
        implements AdvancementUnit, Serializable {

    /**
     * Serialization ID.
     */
    private static final long                               serialVersionUID = -6573589542322283909L;
    /**
     * The unspent experience.
     */
    private Integer                                         experienceValue;
    /**
     * Implant grafted to the unit. This is a {@code UnitComponent}, the same
     * objects used for composite units.
     * <p>
     * Be default it will be a stub component.
     */
    private UnitComponent                                   graftedImplant   = new DefaultUnitComponent(
            "none", new DefaultComponentLocation("none"), 0,
            new LinkedList<TeamPosition>(),
            new ImmutableAttributesHolder(0, 0, 0, 0, 0),
            new LinkedList<Ability>());
    /**
     * The unit's current rank.
     */
    private Integer                                         rankValue;
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
     */
    public DefaultAdvancementUnit(final String nameTemplate, final Integer cost,
            final TeamPosition position, final AttributesHolder attributes,
            final Collection<Ability> abilities, final Boolean giant,
            final UnitValorationCalculator<AdvancementUnit> valorator) {
        super(nameTemplate, cost, position, attributes, abilities, giant);

        valorationBuilder = checkNotNull(valorator,
                "Received a null pointer as valoration builder");
    }

    @Override
    public final void addAbility(final Ability ability) {
        getAbilitiesModifiable().add(ability);
    }

    @Override
    public final UnitComponent getGraftedImplant() {
        return graftedImplant;
    }

    @Override
    public final Integer getRank() {
        return rankValue;
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
    public final void removeAbility(final Ability ability) {
        getAbilitiesModifiable().remove(ability);
    }

    @Override
    public final void setAbilities(final Collection<Ability> abilities) {
        getAbilitiesModifiable().clear();
        getAbilitiesModifiable().addAll(abilities);
    }

    @Override
    public final void setAttributes(final AttributesHolder attributes) {
        setUnitAttributes(attributes);
    }

    @Override
    public final void setGraftedImplant(final UnitComponent implant) {
        graftedImplant = implant;
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
                .add("experience", experienceValue)
                .add("position", getPosition()).add("giant", isGiant())
                .toString();
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
