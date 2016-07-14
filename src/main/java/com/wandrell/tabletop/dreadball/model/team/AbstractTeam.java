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

package com.wandrell.tabletop.dreadball.model.team;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.wandrell.tabletop.dreadball.model.unit.Unit;

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
public abstract class AbstractTeam<U extends Unit> implements Team<U> {

    /**
     * Team's players.
     */
    private final Map<Integer, U> playersMap       = new LinkedHashMap<>();

    /**
     * Number of Cheerleaders on the team.
     */
    private Integer               teamCheerleaders = 0;

    /**
     * Number of Coaching Dice in the team.
     */
    private Integer               teamDice         = 0;

    /**
     * Constructs an {@code AbstractTeam}.
     */
    public AbstractTeam() {
        super();
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
    public final void removePlayer(final U player) {
        removePlayer(getUnitPosition(player));
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
     * Finds a unit on the team and returns his position on the rooster.
     * 
     * @param unit
     *            the unit to find
     * @return the unit's rooster position
     */
    private final Integer getUnitPosition(final U unit) {
        final Iterator<Entry<Integer, U>> itr;
        U current;
        Integer pos;
        Integer result;

        checkNotNull(unit, "Received a null pointer as player");

        itr = getPlayersModifiable().entrySet().iterator();

        result = -1;
        pos = 1;
        while ((itr.hasNext()) && (result < 0)) {
            current = itr.next().getValue();
            if ((current == unit) || (current.equals(unit))) {
                result = pos;
            }
            pos++;
        }

        return result;
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
