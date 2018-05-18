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

import com.bernardomg.tabletop.dreadball.model.faction.TeamType;
import com.bernardomg.tabletop.dreadball.model.player.TeamPlayer;
import com.google.common.base.MoreObjects;

/**
 * Player availabilities for a {@link TeamType}, to be used for both Dreadball
 * Original (DBO) and Dreadball Xtreme (DBX).
 * <p>
 * This is an immutable implementation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ImmutableTeamPlayerAvailability
        implements TeamPlayerAvailability, Serializable {

    /**
     * Serialization id.
     */
    private static final long serialVersionUID = 4392033429541594390L;

    /**
     * {@code TeamPlayer} for which the availability applies.
     */
    private final TeamPlayer  teamPlayer;

    /**
     * {@code TeamType} for which the availability applies.
     */
    private final TeamType    teamType;

    /**
     * Constructs a player availability for the specified team and player.
     * 
     * @param team
     *            {@code TeamType} for which the availability applies
     * @param player
     *            {@code TeamPlayer} for which the availability applies
     */
    public ImmutableTeamPlayerAvailability(final TeamType team,
            final TeamPlayer player) {
        super();

        teamType = checkNotNull(team,
                "Received a null pointer as the team type");
        teamPlayer = checkNotNull(player,
                "Received a null pointer as the player");
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

        final ImmutableTeamPlayerAvailability other;

        other = (ImmutableTeamPlayerAvailability) obj;
        return Objects.equals(teamPlayer, other.teamPlayer)
                && Objects.equals(teamType, other.teamType);
    }

    @Override
    public final TeamPlayer getTeamPlayer() {
        return teamPlayer;
    }

    @Override
    public final TeamType getTeamType() {
        return teamType;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(teamPlayer, teamType);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("teamType", teamType)
                .add("teamPlayer", teamPlayer).toString();
    }

}
