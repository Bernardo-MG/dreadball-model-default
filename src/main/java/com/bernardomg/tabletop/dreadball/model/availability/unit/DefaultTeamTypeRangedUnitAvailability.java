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

package com.bernardomg.tabletop.dreadball.model.availability.unit;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Objects;

import com.bernardomg.tabletop.dreadball.model.faction.TeamType;
import com.bernardomg.tabletop.dreadball.model.unit.Unit;

/**
 * Unit availabilities for a
 * {@link com.bernardomg.tabletop.dreadball.model.faction.TeamType TeamType},
 * where there is a range of how many times it can be acquired.
 * <p>
 * This is an immutable implementation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class DefaultTeamTypeRangedUnitAvailability
        implements TeamTypeRangedUnitAvailability, Serializable {

    /**
     * Serialization id.
     */
    private static final long serialVersionUID = 1431974307074955982L;

    /**
     * Initial number of units of this type for the team type.
     */
    private final Integer     avaInitial;

    /**
     * Maximum number of units of this type for the team type.
     */
    private final Integer     avaMax;

    /**
     * {@code Unit} for which the availability applies.
     */
    private final Unit        avaUnit;

    /**
     * {@code TeamType} for which the availability applies.
     */
    private final TeamType    teamType;

    /**
     * Constructs a ranged unit availability for the specified team and unit.
     * 
     * @param team
     *            {@code TeamType} for which the availability applies
     * @param unit
     *            {@code Unit} for which the availability applies
     * @param initial
     *            initial number of units of this type
     * @param max
     *            maximum number of units of this type
     */
    public DefaultTeamTypeRangedUnitAvailability(final TeamType team,
            final Unit unit, final Integer initial, final Integer max) {
        super();

        teamType = checkNotNull(team,
                "Received a null pointer as the team type");
        avaUnit = checkNotNull(unit, "Received a null pointer as the unit");
        avaInitial = checkNotNull(initial,
                "Received a null pointer as the initial number of units");
        avaMax = checkNotNull(max,
                "Received a null pointer as the maximum number of units");
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

        final DefaultTeamTypeRangedUnitAvailability other;

        other = (DefaultTeamTypeRangedUnitAvailability) obj;
        return Objects.equals(avaUnit, other.avaUnit);
    }

    @Override
    public final Integer getInitialNumber() {
        return avaInitial;
    }

    @Override
    public final Integer getMaxNumber() {
        return avaMax;
    }

    @Override
    public final TeamType getTeamType() {
        return teamType;
    }

    @Override
    public final Unit getUnit() {
        return avaUnit;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(avaUnit);
    }

}
