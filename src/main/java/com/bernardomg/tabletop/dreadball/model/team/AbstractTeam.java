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

package com.bernardomg.tabletop.dreadball.model.team;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bernardomg.tabletop.dreadball.model.player.TeamPlayer;

/**
 * Abstract root team representing the basic features all the Dreadball teams
 * have, no matter if they come from Dreadball Original (DBO) or Dreaball Xtreme
 * (DBX), serving as a root interface for both games.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 * @param <U>
 *            the type of unit the team is composed of
 */
public abstract class AbstractTeam<U extends TeamPlayer> implements Team<U> {

    /**
     * Team's players.
     */
    private final Map<Integer, U> playersMap       = new HashMap<>();

    /**
     * Number of Cheerleaders on the team.
     */
    private Integer               teamCheerleaders = 0;

    /**
     * Number of Coaching Dice in the team.
     */
    private Integer               teamDice         = 0;

    /**
     * Default constructor.
     */
    public AbstractTeam() {
        super();
    }

    @Override
    public final void addPlayer(final U player) {
        checkNotNull(player, "Received a null pointer as player");

        final List<Integer> positions; // Team positions taken
        final Integer maxPos;          // Maximum position
        Integer position;              // Team position searched

        position = 1;

        if (getPlayersModifiable().isEmpty()) {
            addPlayer(player, position);
        } else {
            positions = new ArrayList<>(getPlayersModifiable().keySet());
            Collections.sort(positions);

            maxPos = positions.get(positions.size() - 1);
            while ((positions.contains(position)) && (position <= maxPos)) {
                position++;
            }

            if (!positions.contains(position)) {
                addPlayer(player, position);
            }
        }
    }

    @Override
    public final void addPlayer(final U player, final Integer position) {
        checkNotNull(player, "Received a null pointer as player");
        checkNotNull(position, "Received a null pointer as position");

        checkArgument(position > 0, "The position should be higher than zero");

        getPlayersModifiable().put(position, player);
    }

    @Override
    public final Integer getCheerleaders() {
        return teamCheerleaders;
    }

    @Override
    public final Integer getCoachingDice() {
        return teamDice;
    }

    @Override
    public final Map<Integer, U> getPlayers() {
        return Collections.unmodifiableMap(getPlayersModifiable());
    }

    @Override
    public final void removePlayer(final Integer position) {
        getPlayersModifiable().remove(position);
    }

    @Override
    public final void setCheerleaders(final Integer cheerleaders) {
        teamCheerleaders = cheerleaders;
    }

    @Override
    public final void setCoachingDice(final Integer dice) {
        teamDice = dice;
    }

    /**
     * Returns the team's modifiable map of players.
     * 
     * @return the team's modifiable map of players
     */
    protected final Map<Integer, U> getPlayersModifiable() {
        return playersMap;
    }

}
