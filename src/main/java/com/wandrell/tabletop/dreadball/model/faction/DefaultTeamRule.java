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

package com.wandrell.tabletop.dreadball.model.faction;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;

/**
 * Special rule for teams.
 * <p>
 * This is an immutable implementation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class DefaultTeamRule implements TeamRule {

    /**
     * Rule's name.
     */
    private final String ruleName;

    /**
     * Constructs a team rule with the specified parameters.
     * 
     * @param name
     *            the team's name
     */
    public DefaultTeamRule(final String name) {
        super();

        ruleName = checkNotNull(name, "Received a null pointer as name");
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

        final DefaultTeamRule other;

        other = (DefaultTeamRule) obj;
        return Objects.equals(ruleName, other.ruleName);
    }

    @Override
    public final String getName() {
        return ruleName;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(ruleName);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", ruleName)
                .toString();
    }

}
