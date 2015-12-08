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
import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.dreadball.model.unit.TeamPosition;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

/**
 * Default implementation of {@code UnitComponent}.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class DefaultUnitComponent implements UnitComponent {

    /**
     * Abilities given by this component.
     */
    private final Collection<Ability>      abilitiesGiven = new LinkedHashSet<Ability>();
    /**
     * Attributes given by this component.
     */
    private final AttributesHolder         attributesGiven;
    /**
     * Cost of the component.
     */
    private final Integer                  componentCost;
    /**
     * Location where this component is applied.
     */
    private final ComponentLocation        componentLocation;
    /**
     * Component's name.
     */
    private final String                   componentName;
    /**
     * Team position roles which can have this component.
     */
    private final Collection<TeamPosition> componentPos   = new LinkedHashSet<TeamPosition>();

    /**
     * Constructs a {@code DefaultUnitComponent} with the specified arguments.
     * 
     * @param name
     *            name of the component
     * @param location
     *            location where the component is applied
     * @param cost
     *            cost of the component
     * @param positions
     *            team position roles which can have this component
     * @param attributes
     *            attributes granted by the component
     * @param abilities
     *            abilities granted by the component
     */
    public DefaultUnitComponent(final String name,
            final ComponentLocation location, final Integer cost,
            final Collection<TeamPosition> positions,
            final AttributesHolder attributes,
            final Collection<Ability> abilities) {
        super();

        componentName = checkNotNull(name, "Received a null pointer as name");
        componentLocation = checkNotNull(location,
                "Received a null pointer as location");
        componentCost = checkNotNull(cost, "Received a null pointer as cost");
        attributesGiven = checkNotNull(attributes,
                "Received a null pointer as attributes");
        checkNotNull(abilities, "Received a null pointer as abilities");
        checkNotNull(positions, "Received a null pointer as positions");

        for (final Ability ability : abilities) {
            abilitiesGiven.add(checkNotNull(ability,
                    "Received a null pointer as ability"));
        }

        for (final TeamPosition position : positions) {
            componentPos.add(checkNotNull(position,
                    "Received a null pointer as position"));
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

        final DefaultUnitComponent other;

        other = (DefaultUnitComponent) obj;
        return Objects.equals(componentName, other.componentName);
    }

    @Override
    public final Collection<Ability> getAbilities() {
        return Collections.unmodifiableCollection(getAbilitiesModifiable());
    }

    @Override
    public final AttributesHolder getAttributes() {
        return attributesGiven;
    }

    @Override
    public final Integer getCost() {
        return componentCost;
    }

    @Override
    public final ComponentLocation getLocation() {
        return componentLocation;
    }

    @Override
    public final String getName() {
        return componentName;
    }

    @Override
    public final Collection<TeamPosition> getTeamPositions() {
        return componentPos;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(componentName);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", componentName)
                .add("attributes", attributesGiven)
                .add("abilities", abilitiesGiven).toString();
    }

    /**
     * Returns the modifiable list of the component's abilities.
     * 
     * @return the modifiable list of the component's abilities
     */
    private final Collection<Ability> getAbilitiesModifiable() {
        return abilitiesGiven;
    }

}
