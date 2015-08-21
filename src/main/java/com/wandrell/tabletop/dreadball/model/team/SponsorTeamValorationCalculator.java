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
package com.wandrell.tabletop.dreadball.model.team;

import static com.google.common.base.Preconditions.checkNotNull;

import com.wandrell.tabletop.dreadball.model.unit.Unit;

/**
 * Implementation of {@link TeamValorationCalculator} for {@link SponsorTeam}.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class SponsorTeamValorationCalculator
        implements TeamValorationCalculator<SponsorTeam> {

    /**
     * Cost of a Cheerleader.
     */
    private final Integer costCheerleader;
    /**
     * Cost of a Coaching Die.
     */
    private final Integer costDie;
    /**
     * Cost of a Sabotage Card.
     */
    private final Integer costSabotage;
    /**
     * Cost of a Special Move Card.
     */
    private final Integer costSpecialMove;
    /**
     * Cost of a Wager.
     */
    private final Integer costWager;

    /**
     * Constructs a {@code SponsorTeamValorationCalculator}.
     * 
     * @param dieCost
     *            cost of a Coaching Die
     * @param sabotageCost
     *            cost of a Sabotage Card
     * @param specialMoveCost
     *            cost of a Special Move Card
     * @param cheerleaderCost
     *            cost of a Cheerleader
     * @param wagerCost
     *            cost of a Wager
     */
    public SponsorTeamValorationCalculator(final Integer dieCost,
            final Integer sabotageCost, final Integer specialMoveCost,
            final Integer cheerleaderCost, final Integer wagerCost) {
        super();

        costDie = checkNotNull(dieCost,
                "Received a null pointer as the dice cost");
        costSabotage = checkNotNull(sabotageCost,
                "Received a null pointer as the sabotage card cost");
        costSpecialMove = checkNotNull(specialMoveCost,
                "Received a null pointer as the special move card cost");
        costCheerleader = checkNotNull(cheerleaderCost,
                "Received a null pointer as the cheerleader cost");
        costWager = checkNotNull(wagerCost,
                "Received a null pointer as the wager cost");
    }

    @Override
    public final Integer getValoration(final SponsorTeam team) {
        Integer valoration;

        checkNotNull(team, "Received a null pointer as the team");

        valoration = 0;
        for (final Unit unit : team.getPlayers().values()) {
            valoration += unit.getCost();
        }

        valoration += team.getDice() * costDie;
        valoration += team.getSabotageCards() * costSabotage;
        valoration += team.getSpecialMoveCards() * costSpecialMove;
        valoration += team.getCheerleaders() * costCheerleader;
        valoration += team.getWagers() * costWager;

        return valoration;
    }

}
