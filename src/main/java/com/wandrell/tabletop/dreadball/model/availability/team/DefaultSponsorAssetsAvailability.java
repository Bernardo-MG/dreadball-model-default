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
package com.wandrell.tabletop.dreadball.model.availability.team;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

public final class DefaultSponsorAssetsAvailability
        implements SponsorAssetsAvailability, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2367219275396620712L;
    private final Integer     costAffinityGroup;
    private final Integer     costCheerleader;
    private final Integer     costDice;
    private final Integer     costMedibot;
    private final Integer     costSabotageCard;
    private final Integer     costSpecialMoveCard;
    private final Integer     costUnlockCheerleader;
    private final Integer     costWager;
    private final Integer     maxWagerCount;
    private final Integer     minTeamCost;

    public DefaultSponsorAssetsAvailability(final Integer diceCost,
            final Integer sabotageCost, final Integer specialMoveCost,
            final Integer cheerleaderUnlock, final Integer cheerleaderCost,
            final Integer affinityCost, final Integer medibotCost,
            final Integer teamMinCost, final Integer wagerCost,
            final Integer maxWageCount) {
        super();

        costDice = checkNotNull(diceCost,
                "Received a null pointer as Coaching Dice cost");
        costSabotageCard = checkNotNull(sabotageCost,
                "Received a null pointer as Sabotage Card cost");
        costSpecialMoveCard = checkNotNull(specialMoveCost,
                "Received a null pointer as Special Move Card cost");
        costUnlockCheerleader = checkNotNull(cheerleaderUnlock,
                "Received a null pointer as Cheerleader unlocking cost");
        costCheerleader = checkNotNull(cheerleaderCost,
                "Received a null pointer as Cheerleader cost");
        costAffinityGroup = checkNotNull(affinityCost,
                "Received a null pointer as Affinity Group cost");
        costMedibot = checkNotNull(medibotCost,
                "Received a null pointer as Medibot cost");
        minTeamCost = checkNotNull(teamMinCost,
                "Received a null pointer as the team minimum cost cost");
        costWager = checkNotNull(wagerCost,
                "Received a null pointer as the Wager cost");
        maxWagerCount = checkNotNull(wagerCost,
                "Received a null pointer as the maximum allowed number of Wagers");
    }

    @Override
    public final Integer getAffinityGroupCost() {
        return costAffinityGroup;
    }

    @Override
    public final Integer getCheerleaderCost() {
        return costCheerleader;
    }

    @Override
    public final Integer getCheerleaderUnlockCost() {
        return costUnlockCheerleader;
    }

    @Override
    public final Integer getCoachingDieCost() {
        return costDice;
    }

    @Override
    public Integer getMediBotCost() {
        return costMedibot;
    }

    @Override
    public final Integer getSabotageCardCost() {
        return costSabotageCard;
    }

    @Override
    public final Integer getSpecialMovementCardCost() {
        return costSpecialMoveCard;
    }

    @Override
    public final Integer getTeamCostMin() {
        return minTeamCost;
    }

    @Override
    public final Integer getWagerCost() {
        return costWager;
    }

    @Override
    public final Integer getWagerMaxCount() {
        return maxWagerCount;
    }

}
