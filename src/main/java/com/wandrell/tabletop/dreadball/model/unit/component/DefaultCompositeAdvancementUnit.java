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

import com.wandrell.tabletop.dreadball.model.unit.AdvancementUnit;
import com.wandrell.tabletop.dreadball.model.unit.DefaultAdvancementUnit;
import com.wandrell.tabletop.dreadball.model.unit.TeamPosition;
import com.wandrell.tabletop.dreadball.model.unit.UnitValorationBuilder;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

public final class DefaultCompositeAdvancementUnit extends AbstractCompositeUnit
        implements CompositeAdvancementUnit, Serializable {

    /**
     * 
     */
    private static final long     serialVersionUID = -321423729599012626L;
    private final AdvancementUnit baseUnit;

    public DefaultCompositeAdvancementUnit(final String name,
            final Integer cost, final TeamPosition position,
            final AttributesHolder attributes,
            final Collection<Ability> abilities, final Boolean giant,
            final UnitValorationBuilder valorator,
            final Collection<UnitComponent> components) {
        super(components);

        baseUnit = new DefaultAdvancementUnit(name, cost, position, attributes,
                abilities, giant, valorator);
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

    @Override
    public final Integer getCost() {
        return getBaseUnit().getCost();
    }

    @Override
    public final UnitComponent getGraftedImplant() {
        return getBaseUnit().getGraftedImplant();
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
    public final void setRank(final Integer rank) {
        getBaseUnit().setRank(rank);
    }

    @Override
    public final void setUnspentExperience(final Integer experience) {
        getBaseUnit().setUnspentExperience(experience);
    }

    private final AdvancementUnit getBaseUnit() {
        return baseUnit;
    }

}
