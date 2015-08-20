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

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

/**
 * Abstract implementation of {@code Unit}.
 * 
 * @author Bernardo Martínez Garrido
 */
public abstract class AbstractUnit implements Unit {

    /**
     * Unit's attributes.
     */
    private final AttributesHolder    attributesValues;
    private final Integer             baseCost;
    /**
     * Indicates if the unit is a giant.
     */
    private final Boolean             giantFlag;
    private final String              templateName;
    /**
     * The unit's team position.
     */
    private final TeamPosition        templatePosition;
    /**
     * The unit's abilities.
     */
    private final Collection<Ability> unitAbilities = new LinkedHashSet<>();


    public AbstractUnit(final String name, final Integer cost,
            final TeamPosition position, final AttributesHolder attributes,
            final Collection<Ability> abilities, final Boolean giant) {
        super();

        templateName = checkNotNull(name, "Received a null pointer as name");
        attributesValues = checkNotNull(attributes,
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
    public final AttributesHolder getAttributes() {
        return attributesValues;
    }

    @Override
    public final Integer getCost() {
        return baseCost;
    }

    @Override
    public final TeamPosition getPosition() {
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
     * Returns the modifiable list of the unit's abilities.
     * 
     * @return the modifiable list of the unit's abilities
     */
    protected final Collection<Ability> getAbilitiesModifiable() {
        return unitAbilities;
    }

}
