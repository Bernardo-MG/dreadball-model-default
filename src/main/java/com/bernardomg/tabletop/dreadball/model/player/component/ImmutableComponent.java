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

package com.bernardomg.tabletop.dreadball.model.player.component;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;

import com.bernardomg.tabletop.dreadball.model.player.Role;
import com.bernardomg.tabletop.dreadball.model.player.stats.Ability;
import com.bernardomg.tabletop.dreadball.model.player.stats.Attributes;
import com.google.common.base.MoreObjects;

/**
 * Component used for creating a composite player.
 * <p>
 * This is an immutable implementation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ImmutableComponent implements Component, Serializable {

    /**
     * Serialization id.
     */
    private static final long         serialVersionUID = 409045439122602174L;

    /**
     * Abilities given by this component.
     */
    private final Collection<Ability> abilitiesGiven   = new LinkedHashSet<Ability>();

    /**
     * Attributes given by this component.
     */
    private final Attributes          attributes;

    /**
     * Cost of the component.
     */
    private final Integer             cost;

    /**
     * Location where this component is applied.
     */
    private final ComponentLocation   location;

    /**
     * Component's name.
     */
    private final String              name;

    /**
     * Team position roles which can have this component.
     */
    private final Collection<Role>    roles            = new LinkedHashSet<Role>();

    /**
     * Constructs a component with the specified arguments.
     * 
     * @param componentName
     *            name of the component
     * @param componentLocation
     *            location where the component is applied
     * @param componentCost
     *            cost of the component
     * @param positions
     *            team position roles which can have this component
     * @param attr
     *            attributes granted by the component
     * @param abilities
     *            abilities granted by the component
     */
    public ImmutableComponent(final String componentName,
            final ComponentLocation componentLocation,
            final Integer componentCost, final Collection<Role> componentRoles,
            final Attributes attr, final Collection<Ability> abilities) {
        super();

        name = checkNotNull(componentName, "Received a null pointer as name");
        location = checkNotNull(componentLocation,
                "Received a null pointer as location");
        cost = checkNotNull(componentCost, "Received a null pointer as cost");
        attributes = checkNotNull(attr,
                "Received a null pointer as attributes");
        checkNotNull(abilities, "Received a null pointer as abilities");
        checkNotNull(componentRoles, "Received a null pointer as positions");

        for (final Ability ability : abilities) {
            abilitiesGiven.add(checkNotNull(ability,
                    "Received a null pointer as ability"));
        }

        for (final Role position : componentRoles) {
            roles.add(checkNotNull(position,
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

        final ImmutableComponent other;

        other = (ImmutableComponent) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public final Collection<Ability> getAbilities() {
        return Collections.unmodifiableCollection(getAbilitiesModifiable());
    }

    @Override
    public final Attributes getAttributes() {
        return attributes;
    }

    @Override
    public final Integer getCost() {
        return cost;
    }

    @Override
    public final ComponentLocation getLocation() {
        return location;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final Collection<Role> getRoles() {
        return roles;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name)
                .add("attributes", attributes).add("abilities", abilitiesGiven)
                .toString();
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
