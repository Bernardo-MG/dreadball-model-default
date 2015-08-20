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
package com.wandrell.tabletop.dreadball.model.availability.unit;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import com.wandrell.tabletop.dreadball.model.faction.TeamType;
import com.wandrell.tabletop.dreadball.model.unit.Unit;

public final class DefaultTeamTypeUnitAvailability
        implements TeamTypeUnitAvailability, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 6800043495581560617L;
    private final Integer     avaInitial;
    private final Integer     avaMax;
    private final Unit        avaUnit;
    private final TeamType    teamType;

    public DefaultTeamTypeUnitAvailability(final TeamType team, final Unit unit,
            final Integer initial, final Integer max) {
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

}
