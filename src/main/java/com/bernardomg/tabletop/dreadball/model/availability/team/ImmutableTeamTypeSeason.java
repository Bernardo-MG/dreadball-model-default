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

package com.bernardomg.tabletop.dreadball.model.availability.team;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Objects;

import com.bernardomg.tabletop.dreadball.model.availability.faction.TeamTypeSeason;
import com.bernardomg.tabletop.dreadball.model.faction.TeamType;
import com.google.common.base.MoreObjects;

/**
 * Season in which a team appeared.
 * <p>
 * This is an immutable implementation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ImmutableTeamTypeSeason
        implements TeamTypeSeason, Serializable {

    /**
     * Serialization id.
     */
    private static final long serialVersionUID = 2243352801856981700L;

    /**
     * The season the team appeared in.
     */
    private final Integer     seasonNumber;

    /**
     * The team which appeared in this season.
     */
    private final TeamType    team;

    /**
     * Constructs a team season.
     * 
     * @param teamType
     *            team type which appeared in the season
     * @param season
     *            season in which the team appeared
     */
    public ImmutableTeamTypeSeason(final TeamType teamType,
            final Integer season) {
        super();

        team = checkNotNull(teamType, "Received a null pointer as Team");
        seasonNumber = checkNotNull(season,
                "Received a null pointer as season number");
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

        final ImmutableTeamTypeSeason other;

        other = (ImmutableTeamTypeSeason) obj;
        return Objects.equals(team, other.team)
                && Objects.equals(seasonNumber, other.seasonNumber);
    }

    @Override
    public final Integer getSeasonNumber() {
        return seasonNumber;
    }

    @Override
    public final TeamType getTeam() {
        return team;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(team, seasonNumber);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("team", team)
                .add("seasonNumber", seasonNumber).toString();
    }

}
