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

import com.wandrell.tabletop.dreadball.model.faction.TeamType;

public final class DefaultTeamTypeAssetsAvailability
        implements TeamTypeAssetsAvailability, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8736398538873453410L;
    private final Boolean     beginsDefensiveCoach;
    private final Boolean     beginsOffensiveCoach;
    private final Boolean     beginsSupportCoach;
    private final Integer     costCard;
    private final Integer     costCheerleader;
    private final Integer     costCoaching;
    private final Integer     costDie;
    private final Integer     initialCard;
    private final Integer     initialCheerleader;
    private final Integer     initialDie;
    private final Integer     maxCard;
    private final Integer     maxCheerleader;
    private final Integer     maxDie;
    private final TeamType    teamType;

    public DefaultTeamTypeAssetsAvailability(final TeamType team,
            final Integer cheerleaderCost, final Integer cheerleaderInitial,
            final Integer cheerleaderMax, final Integer diceCost,
            final Integer diceInitial, final Integer diceMax,
            final Integer cardCost, final Integer cardInitial,
            final Integer cardMax, final Integer coachingCost,
            final Boolean initialOffensiveCoach,
            final Boolean initialDefensiveCoach,
            final Boolean initialSupportCoach) {
        super();

        teamType = checkNotNull(team,
                "Received a null pointer as the Team Type");

        costCheerleader = checkNotNull(cheerleaderCost,
                "Received a null pointer as the Cheerleader cost");
        initialCheerleader = checkNotNull(cheerleaderInitial,
                "Received a null pointer as initial Cheerleaders");
        maxCheerleader = checkNotNull(cheerleaderMax,
                "Received a null pointer as maximum Cheerleaders");

        costDie = checkNotNull(diceCost,
                "Received a null pointer as the Coaching Dice cost");
        initialDie = checkNotNull(diceInitial,
                "Received a null pointer as initial Coaching Dice");
        maxDie = checkNotNull(diceMax,
                "Received a null pointer as maximum Coaching Dice");

        costCard = checkNotNull(cardCost,
                "Received a null pointer as the Dreadball Card cost");
        initialCard = checkNotNull(cardInitial,
                "Received a null pointer as initial Dreadball Cards");
        maxCard = checkNotNull(cardMax,
                "Received a null pointer as maximum Dreadball Cards");

        costCoaching = checkNotNull(coachingCost,
                "Received a null pointer as the Coaching Staff cost");
        beginsOffensiveCoach = checkNotNull(initialOffensiveCoach,
                "Received a null pointer as the initial Offensive Coach flag");
        beginsDefensiveCoach = checkNotNull(initialDefensiveCoach,
                "Received a null pointer as the initial Defensive Coach flag");
        beginsSupportCoach = checkNotNull(initialSupportCoach,
                "Received a null pointer as the initial Support Coach flag");
    }

    @Override
    public final Integer getCheerleadersCost() {
        return costCheerleader;
    }

    @Override
    public final Integer getCheerleadersInitial() {
        return initialCheerleader;
    }

    @Override
    public final Integer getCheerleadersMax() {
        return maxCheerleader;
    }

    @Override
    public final Integer getCoachingDieCost() {
        return costDie;
    }

    @Override
    public final Integer getCoachingDieInitial() {
        return initialDie;
    }

    @Override
    public final Integer getCoachingDieMax() {
        return maxDie;
    }

    @Override
    public final Integer getCoachingStaffCost() {
        return costCoaching;
    }

    @Override
    public final Integer getDreadballCardCost() {
        return costCard;
    }

    @Override
    public final Integer getDreadballCardInitial() {
        return initialCard;
    }

    @Override
    public final Integer getDreadballCardMax() {
        return maxCard;
    }

    @Override
    public final TeamType getTeamType() {
        return teamType;
    }

    @Override
    public final Boolean isStartingWithDefensiveCoachingStaff() {
        return beginsDefensiveCoach;
    }

    @Override
    public final Boolean isStartingWithOffensiveCoachingStaff() {
        return beginsOffensiveCoach;
    }

    @Override
    public final Boolean isStartingWithSupportCoachingStaff() {
        return beginsSupportCoach;
    }

}
