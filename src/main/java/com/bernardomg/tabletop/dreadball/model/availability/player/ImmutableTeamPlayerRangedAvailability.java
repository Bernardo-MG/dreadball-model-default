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

/**
 * Player availabilities for a
 * {@link com.bernardomg.tabletop.dreadball.model.faction.TeamType TeamType},
 * where there is a range of how many times it can be acquired.
 * <p>
 * This is an immutable implementation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ImmutableTeamPlayerRangedAvailability
        implements TeamPlayerRangedAvailability, Serializable {

    /**
     * Serialization id.
     */
    private static final long serialVersionUID = 1431974307074955982L;

    /**
     * Initial number of players of this type for the team type.
     */
    private final Integer     initialNumber;

    /**
     * Maximum number of players of this type for the team type.
     */
    private final Integer     maxNumber;

    /**
     * {@code TeamPlayer} for which the availability applies.
     */
    private final TeamPlayer  teamPlayer;

    /**
     * {@code TeamType} for which the availability applies.
     */
    private final TeamType    teamType;

    /**
     * Constructs a ranged player availability for the specified team and
     * player.
     * 
     * @param team
     *            {@code TeamType} for which the availability applies
     * @param player
     *            {@code TeamPlayer} for which the availability applies
     * @param initial
     *            initial number of players of this type
     * @param max
     *            maximum number of players of this type
     */
    public ImmutableTeamPlayerRangedAvailability(final TeamType team,
            final TeamPlayer player, final Integer initial, final Integer max) {
        super();

        teamType = checkNotNull(team,
                "Received a null pointer as the team type");
        teamPlayer = checkNotNull(player,
                "Received a null pointer as the player");
        initialNumber = checkNotNull(initial,
                "Received a null pointer as the initial number of players");
        maxNumber = checkNotNull(max,
                "Received a null pointer as the maximum number of players");
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

        final ImmutableTeamPlayerRangedAvailability other;

        other = (ImmutableTeamPlayerRangedAvailability) obj;
        return Objects.equals(teamPlayer, other.teamPlayer)
                && Objects.equals(teamType, other.teamType);
    }

    @Override
    public final Integer getInitialNumber() {
        return initialNumber;
    }

    @Override
    public final Integer getMaxNumber() {
        return maxNumber;
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

}
