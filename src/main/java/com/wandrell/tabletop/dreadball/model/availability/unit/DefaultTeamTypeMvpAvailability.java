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

package com.wandrell.tabletop.dreadball.model.availability.unit;

import static com.google.common.base.Preconditions.checkNotNull;

import com.wandrell.tabletop.dreadball.model.faction.TeamType;
import com.wandrell.tabletop.dreadball.model.unit.Unit;

/**
 * MVP availabilities for a {@link TeamType}, which are the Dreadball Original
 * (DBO) factions.
 * <p>
 * This is an immutable implementation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class DefaultTeamTypeMvpAvailability
        implements TeamTypeMvpAvailability {

    /**
     * {@code Unit} for which the availability applies.
     */
    private final Unit     avaUnit;

    /**
     * {@code TeamType} for which the availability applies.
     */
    private final TeamType teamType;

    /**
     * Constructs a {@code DefaultTeamTypeMvpAvailability} with the specified
     * arguments.
     * 
     * @param team
     *            {@code TeamType} for which the availability applies
     * @param unit
     *            {@code Unit} for which the availability applies
     */
    public DefaultTeamTypeMvpAvailability(final TeamType team,
            final Unit unit) {
        super();

        teamType = checkNotNull(team,
                "Received a null pointer as the Team Type");
        avaUnit = checkNotNull(unit, "Received a null pointer as the Unit");
    }

    @Override
    public final TeamType getTeamType() {
        return teamType;
    }

    @Override
    public final Unit getUnit() {
        return avaUnit;
    }

}
