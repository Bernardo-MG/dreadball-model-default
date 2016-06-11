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

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.Attributes;

/**
 * Root for the basic features all the Dreadball units have, no matter if they
 * come from Dreadball Original (DBO) or Dreadball Xtreme (DBX).
 * <p>
 * This is an immutable implementation.
 * 
 * @author Bernardo Martínez Garrido
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
     * Unit's name;
     */
    private String                    name          = "";

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
     * @param giant
     *            flag indicating if this is a giant
     */
    public DefaultUnit(final String nameTemplate, final Integer cost,
            final Role position, final Attributes attributes,
            final Collection<Ability> abilities, final Boolean giant) {
        super();

        templateName = checkNotNull(nameTemplate,
                "Received a null pointer as the template name");
        unitAttributes = checkNotNull(attributes,
                "Received a null pointer as attributes");
        templatePosition = checkNotNull(position,
                "Received a null pointer as position");
        giantFlag = checkNotNull(giant, "Received a null pointer as giant");
        baseCost = checkNotNull(cost, "Received a null pointer as cost");

        checkNotNull(abilities, "Received a null pointer as abilities");

        for (final Ability ability : abilities) {
            unitAbilities.add(checkNotNull(ability,
                    "Received a null pointer as ability"));
        }
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
    public final String getName() {
        return name;
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
    public final Boolean isGiant() {
        return giantFlag;
    }

    /**
     * Sets the unit name.
     * 
     * @param name
     *            the unit name
     */
    public final void setName(final String name) {
        this.name = name;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", getTemplateName())
                .add("role", getRole()).add("giant", isGiant()).toString();
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
