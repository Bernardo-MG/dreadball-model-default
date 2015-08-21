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

import java.io.Serializable;

import com.wandrell.tabletop.dreadball.model.unit.AdvancementUnit;

public final class AdvancementTeamValorationCalculator
        implements TeamValorationCalculator<AdvancementTeam>, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5071274138826934377L;
    private final Integer     costCard;
    private final Integer     costCheerleader;
    private final Integer     costCoaching;
    private final Integer     costDice;

    public AdvancementTeamValorationCalculator(final Integer diceCost,
            final Integer cardCost, final Integer cheerleaderCost,
            final Integer coachingCost) {
        super();

        costDice = checkNotNull(diceCost,
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

        valoration += team.getDice() * costDice;
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
