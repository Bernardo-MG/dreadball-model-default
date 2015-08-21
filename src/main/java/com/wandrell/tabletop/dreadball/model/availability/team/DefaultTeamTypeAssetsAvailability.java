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

/**
 * Default serializable implementation of {@link TeamTypeAssetsAvailability}.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class DefaultTeamTypeAssetsAvailability
        implements TeamTypeAssetsAvailability, Serializable {

    /**
     * Serialization ID.
     */
    private static final long serialVersionUID = -8736398538873453410L;
    /**
     * Flag indicating if this {@code TeamType} begins with a Defensive Coaching
     * Staff.
     */
    private final Boolean     beginsDefensiveCoach;
    /**
     * Flag indicating if this {@code TeamType} begins with an Offensive
     * Coaching Staff.
     */
    private final Boolean     beginsOffensiveCoach;
    /**
     * Flag indicating if this {@code TeamType} begins with a Support Coaching
     * Staff.
     */
    private final Boolean     beginsSupportCoach;
    /**
     * Cost of a Dreadball card.
     */
    private final Integer     costCard;
    /**
     * Cost of a Cheerleader.
     */
    private final Integer     costCheerleader;
    /**
     * Cost of a Coaching Staff.
     */
    private final Integer     costCoaching;
    /**
     * Cost of a Coaching Die.
     */
    private final Integer     costDie;
    /**
     * Initial number of Dreadball Cards for this {@code TeamType}.
     */
    private final Integer     initialCard;
    /**
     * Initial number of Cheerleaders for this {@code TeamType}.
     */
    private final Integer     initialCheerleader;
    /**
     * Initial number of Coaching Dice for this {@code TeamType}.
     */
    private final Integer     initialDie;
    /**
     * Maximum number of Dreadball Cards for this {@code TeamType}.
     */
    private final Integer     maxCard;
    /**
     * Maximum number of Cheerleaders for this {@code TeamType}.
     */
    private final Integer     maxCheerleader;
    /**
     * Maximum number of Coaching Dice for this {@code TeamType}.
     */
    private final Integer     maxDie;
    /**
     * {@code TeamType} to which this availability applies.
     */
    private final TeamType    teamType;

    /**
     * Constructs a {@code DefaultTeamTypeAssetsAvailability} with the specified
     * arguments.
     * 
     * @param team
     *            {@code TeamType} to which this availability applies
     * @param cheerleaderCost
     *            cost of a Cheerleader
     * @param cheerleaderInitial
     *            initial number of Cheerleaders
     * @param cheerleaderMax
     *            maximum number of Cheerleaders
     * @param diceCost
     *            cost of a Coaching Die
     * @param diceInitial
     *            initial number of Coaching Dice
     * @param diceMax
     *            maximum number of Coaching Dice
     * @param cardCost
     *            cost of a Dreadball Card
     * @param cardInitial
     *            initial number of Dreadball Cards
     * @param cardMax
     *            maximum number of Dreadball Cards
     * @param coachingCost
     *            cost of a Coaching Staff
     * @param initialOffensiveCoach
     *            flag indicating if the {@code TeamType} begins with an
     *            Offensive Coaching Staff
     * @param initialDefensiveCoach
     *            flag indicating if the {@code TeamType} begins with a
     *            Defensive Coaching Staff
     * @param initialSupportCoach
     *            flag indicating if the {@code TeamType} begins with a Support
     *            Coaching Staff
     */
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
