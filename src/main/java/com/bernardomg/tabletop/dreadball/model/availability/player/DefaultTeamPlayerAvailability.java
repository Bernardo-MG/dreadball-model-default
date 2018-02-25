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

package com.bernardomg.tabletop.dreadball.model.availability.player;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Objects;

import com.bernardomg.tabletop.dreadball.model.availability.player.TeamPlayerAvailability;
import com.bernardomg.tabletop.dreadball.model.faction.TeamType;
import com.bernardomg.tabletop.dreadball.model.player.TeamPlayer;

/**
 * Unit availabilities for a {@link TeamType}, to be used for both Dreadball
 * Original (DBO) and Dreadball Xtreme (DBX).
 * <p>
 * This is an immutable implementation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class DefaultTeamPlayerAvailability
        implements TeamPlayerAvailability, Serializable {

    /**
     * Serialization id.
     */
    private static final long serialVersionUID = 4392033429541594390L;

    /**
     * {@code TeamPlayer} for which the availability applies.
     */
    private final TeamPlayer  avaUnit;

    /**
     * {@code TeamType} for which the availability applies.
     */
    private final TeamType    teamType;

    /**
     * Constructs a unit availability for the specified team and unit.
     * 
     * @param team
     *            {@code TeamType} for which the availability applies
     * @param unit
     *            {@code Unit} for which the availability applies
     */
    public DefaultTeamPlayerAvailability(final TeamType team,
            final TeamPlayer unit) {
        super();

        teamType = checkNotNull(team,
                "Received a null pointer as the team type");
        avaUnit = checkNotNull(unit, "Received a null pointer as the unit");
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

        final DefaultTeamPlayerAvailability other;

        other = (DefaultTeamPlayerAvailability) obj;
        return Objects.equals(avaUnit, other.avaUnit);
    }

    @Override
    public final TeamType getTeamType() {
        return teamType;
    }

    @Override
    public final TeamPlayer getTeamPlayer() {
        return avaUnit;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(avaUnit);
    }

}
