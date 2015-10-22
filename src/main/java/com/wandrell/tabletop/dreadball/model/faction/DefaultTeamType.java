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
package com.wandrell.tabletop.dreadball.model.faction;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;

import com.google.common.base.MoreObjects;

/**
 * Default implementation of {@link TeamType}.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class DefaultTeamType implements TeamType {

    /**
     * Team type's name.
     */
    private final String               teamName;
    /**
     * Team type's rules.
     */
    private final Collection<TeamRule> teamRules = new LinkedHashSet<>();

    /**
     * Constructs a {@code DefaultTeamType} with the specified parameters.
     * 
     * @param name
     *            team type's name
     * @param rules
     *            team type's rules
     */
    public DefaultTeamType(final String name,
            final Collection<TeamRule> rules) {
        super();

        teamName = checkNotNull(name, "Received a null pointer as name");
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

        final DefaultTeamType other;

        other = (DefaultTeamType) obj;
        return Objects.equals(teamName, other.teamName);
    }

    @Override
    public final String getName() {
        return teamName;
    }

    @Override
    public final Collection<TeamRule> getTeamRules() {
        return Collections.unmodifiableCollection(getTeamRulesModifiable());
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(teamName);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", teamName)
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
