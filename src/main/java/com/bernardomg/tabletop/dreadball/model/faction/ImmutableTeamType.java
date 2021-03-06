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

package com.bernardomg.tabletop.dreadball.model.faction;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;

import com.google.common.base.MoreObjects;

/**
 * Team type, which are the Dreadball Original (DBO) factions. They are also
 * used to group together Dreadball Xtreme (DBX) players.
 * <p>
 * This is an immutable implementation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ImmutableTeamType implements TeamType, Serializable {

    /**
     * Serialization id.
     */
    private static final long          serialVersionUID = -2314476347856532601L;

    /**
     * Team type's name.
     */
    private final String               name;

    /**
     * Team type's rules.
     */
    private final Collection<TeamRule> teamRules        = new LinkedHashSet<>();

    /**
     * Constructs a team type with the specified parameters.
     * 
     * @param teamName
     *            team type's name
     * @param rules
     *            team type's rules
     */
    public ImmutableTeamType(final String teamName,
            final Collection<TeamRule> rules) {
        super();

        name = checkNotNull(teamName, "Received a null pointer as name");
        checkNotNull(rules, "Received a null pointer as rules");

        for (final TeamRule rule : rules) {
            teamRules
                    .add(checkNotNull(rule, "Received a null pointer as rule"));
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

        final ImmutableTeamType other;

        other = (ImmutableTeamType) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final Collection<TeamRule> getTeamRules() {
        return Collections.unmodifiableCollection(getTeamRulesModifiable());
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name)
                .add("rules", teamRules).toString();
    }

    /**
     * Returns the modifiable list of the team type's rules.
     * 
     * @return the modifiable list of the team type's rules
     */
    private final Collection<TeamRule> getTeamRulesModifiable() {
        return teamRules;
    }

}
