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
import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.Attributes;

/**
 * Root for the basic features all the Dreadball units have, no matter if they
 * come from Dreadball Original (DBO) or Dreadball Xtreme (DBX).
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class DefaultUnit implements Unit {

    /**
     * Base cost of the unit.
     */
    private final Integer             baseCost;

    /**
     * Indicates if the unit is a giant.
     */
    private final Boolean             giantFlag;

    /**
     * Indicates if the unit is a MVP.
     */
    private final Boolean             mvpFlag;

    /**
     * Name of the template from which this unit has been created.
     */
    private final String              templateName;

    /**
     * The unit's team position.
     */
    private final Role                templatePosition;

    /**
     * The unit's abilities.
     */
    private final Collection<Ability> unitAbilities = new LinkedHashSet<>();

    /**
     * Unit's attributes.
     */
    private final Attributes          unitAttributes;

    /**
     * Unit's name.
     */
    private String                    unitName      = "";

    /**
     * Constructs a {@code DefaultUnit} with the specified arguments.
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
     */
    public DefaultUnit(final String nameTemplate, final Integer cost,
            final Role position, final Attributes attributes,
            final Collection<Ability> abilities, final Boolean mvp,
            final Boolean giant) {
        super();

        templateName = checkNotNull(nameTemplate,
                "Received a null pointer as the template name");
        unitAttributes = checkNotNull(attributes,
                "Received a null pointer as attributes");
        templatePosition = checkNotNull(position,
                "Received a null pointer as position");
        giantFlag = checkNotNull(giant,
                "Received a null pointer as giant flag");
        mvpFlag = checkNotNull(mvp, "Received a null pointer as MVP flag");
        baseCost = checkNotNull(cost, "Received a null pointer as cost");

        checkNotNull(abilities, "Received a null pointer as abilities");

        for (final Ability ability : abilities) {
            unitAbilities.add(checkNotNull(ability,
                    "Received a null pointer as ability"));
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

        final DefaultUnit other;

        other = (DefaultUnit) obj;
        return Objects.equals(unitName, other.unitName);
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
        return baseCost;
    }

    @Override
    public final Boolean getGiant() {
        return giantFlag;
    }

    @Override
    public final Boolean getMvp() {
        return mvpFlag;
    }

    @Override
    public final String getName() {
        return unitName;
    }

    @Override
    public final Role getRole() {
        return templatePosition;
    }

    @Override
    public final String getTemplateName() {
        return templateName;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(unitName);
    }

    /**
     * Sets the unit name.
     * 
     * @param name
     *            the unit name
     */
    public final void setName(final String name) {
        unitName = name;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", getTemplateName())
                .add("role", getRole()).add("mvp", getMvp())
                .add("giant", getGiant()).toString();
    }

    /**
     * Returns the modifiable collection of the unit's abilities.
     * 
     * @return the modifiable collection of the unit's abilities
     */
    private final Collection<Ability> getAbilitiesModifiable() {
        return unitAbilities;
    }

}
