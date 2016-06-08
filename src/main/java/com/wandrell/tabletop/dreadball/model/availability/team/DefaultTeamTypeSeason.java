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

package com.wandrell.tabletop.dreadball.model.availability.team;

import static com.google.common.base.Preconditions.checkNotNull;

import com.wandrell.tabletop.dreadball.model.availability.faction.TeamTypeSeason;
import com.wandrell.tabletop.dreadball.model.faction.TeamType;

/**
 * Default serializable implementation of {@link TeamTypeSeason}.
 * 
 * @author Bernardo Martínez Garrido
 */
public class DefaultTeamTypeSeason implements TeamTypeSeason {

    /**
     * The season the team appeared in.
     */
    private final Integer  seasonNumber;

    /**
     * The team which appeared in this season.
     */
    private final TeamType team;

    /**
     * Constructs a {@code DefaultTeamTypeSeason}.
     * 
     * @param teamType
     *            team type which appeared in the season
     * @param season
     *            season in which the team appeared
     */
    public DefaultTeamTypeSeason(final TeamType teamType,
            final Integer season) {
        super();

        team = checkNotNull(teamType, "Received a null pointer as Team");
        seasonNumber = checkNotNull(season,
                "Received a null pointer as season number");
    }

    @Override
    public final Integer getSeasonNumber() {
        return seasonNumber;
    }

    @Override
    public final TeamType getTeam() {
        return team;
    }

}
