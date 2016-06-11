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

import static com.google.common.base.Preconditions.checkNotNull;

import com.wandrell.tabletop.dreadball.model.unit.AdvancementUnit;

/**
 * Team valoration calculator for an {@code AdvancementTeam}.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class AdvancementTeamValorationCalculator
        implements TeamValorationCalculator<AdvancementTeam> {

    /**
     * Cost of a Dreadball Card.
     */
    private final Integer costCard;

    /**
     * Cost of a Cheerleader.
     */
    private final Integer costCheerleader;

    /**
     * Cost of a Coaching Staff.
     */
    private final Integer costCoaching;

    /**
     * Cost of a Coaching Die.
     */
    private final Integer costDie;

    /**
     * Constructs a {@code AdvancementTeamValorationCalculator}.
     * 
     * @param dieCost
     *            the cost of a Coaching Die
     * @param cardCost
     *            the cost of a Dreadball Card
     * @param cheerleaderCost
     *            the cost of a Cheerleader
     * @param coachingCost
     *            the cost of a Coaching Staff
     */
    public AdvancementTeamValorationCalculator(final Integer dieCost,
            final Integer cardCost, final Integer cheerleaderCost,
            final Integer coachingCost) {
        super();

        costDie = checkNotNull(dieCost,
                "Received a null pointer as the dice cost");
        costCard = checkNotNull(cardCost,
                "Received a null pointer as the Dreadball card cost");
        costCheerleader = checkNotNull(cheerleaderCost,
                "Received a null pointer as the cheerleader cost");
        costCoaching = checkNotNull(coachingCost,
                "Received a null pointer as the coaching staff cost");
    }

    @Override
    public final Integer getValoration(final AdvancementTeam team) {
        Integer valoration;

        checkNotNull(team, "Received a null pointer as the team");

        valoration = team.getCash();
        for (final AdvancementUnit unit : team.getPlayers().values()) {
            valoration += unit.getValoration();
        }

        valoration += team.getCoachingDice() * costDie;
        valoration += team.getDreadballCards() * costCard;
        valoration += team.getCheerleaders() * costCheerleader;
        if (team.hasDefensiveCoachingStaff()) {
            valoration += costCoaching;
        }
        if (team.hasOffensiveCoachingStaff()) {
            valoration += costCoaching;
        }
        if (team.hasSupportCoachingStaff()) {
            valoration += costCoaching;
        }

        return valoration;
    }

}
