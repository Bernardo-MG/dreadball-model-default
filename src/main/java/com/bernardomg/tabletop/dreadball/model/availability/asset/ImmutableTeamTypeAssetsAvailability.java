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

package com.bernardomg.tabletop.dreadball.model.availability.asset;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Objects;

import com.bernardomg.tabletop.dreadball.model.faction.TeamType;
import com.google.common.base.MoreObjects;

/**
 * Assets availabilities for a {@link TeamType}, which are the Dreadball
 * Original (DBO) factions.
 * <p>
 * This is an immutable implementation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ImmutableTeamTypeAssetsAvailability
        implements TeamTypeAssetsAvailability, Serializable {

    /**
     * Serialization id.
     */
    private static final long serialVersionUID = -4292808611392909379L;

    /**
     * Cost of a Cheerleader.
     */
    private final Integer     cheerleaderCost;

    /**
     * Initial number of Cheerleaders for this {@code TeamType}.
     */
    private final Integer     cheerleaderInitial;

    /**
     * Maximum number of Cheerleaders for this {@code TeamType}.
     */
    private final Integer     cheerleaderMax;

    /**
     * Cost of a Coaching Die.
     */
    private final Integer     coachingDieCost;

    /**
     * Initial number of Coaching Dice for this {@code TeamType}.
     */
    private final Integer     coachingDieInitial;

    /**
     * Maximum number of Coaching Dice for this {@code TeamType}.
     */
    private final Integer     coachingDieMax;

    /**
     * Cost of a Coaching Staff.
     */
    private final Integer     coachingStaffCost;

    /**
     * Cost of a Dreadball card.
     */
    private final Integer     dreadballCardCost;

    /**
     * Initial number of Dreadball Cards for this {@code TeamType}.
     */
    private final Integer     dreadballCardInitial;

    /**
     * Maximum number of Dreadball Cards for this {@code TeamType}.
     */
    private final Integer     dreadballCardMax;

    /**
     * Flag indicating if this {@code TeamType} begins with a Defensive Coaching
     * Staff.
     */
    private final Boolean     startingWithDefensiveCoachingStaff;

    /**
     * Flag indicating if this {@code TeamType} begins with an Offensive
     * Coaching Staff.
     */
    private final Boolean     startingWithOffensiveCoachingStaff;

    /**
     * Flag indicating if this {@code TeamType} begins with a Support Coaching
     * Staff.
     */
    private final Boolean     startingWithSupportCoachingStaff;

    /**
     * {@code TeamType} to which this availability applies.
     */
    private final TeamType    teamType;

    /**
     * Constructs assets availability with the specified asset costs and
     * constraints.
     * 
     * @param team
     *            {@code TeamType} to which this availability applies
     * @param cheerCost
     *            cost of a Cheerleader
     * @param cheerInitial
     *            initial number of Cheerleaders
     * @param cheerMax
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
     * @param offensiveCoach
     *            flag indicating if the {@code TeamType} begins with an
     *            Offensive Coaching Staff
     * @param defensiveCoach
     *            flag indicating if the {@code TeamType} begins with a
     *            Defensive Coaching Staff
     * @param supportCoach
     *            flag indicating if the {@code TeamType} begins with a Support
     *            Coaching Staff
     */
    public ImmutableTeamTypeAssetsAvailability(final TeamType team,
            final Integer cheerCost, final Integer cheerInitial,
            final Integer cheerMax, final Integer diceCost,
            final Integer diceInitial, final Integer diceMax,
            final Integer cardCost, final Integer cardInitial,
            final Integer cardMax, final Integer coachingCost,
            final Boolean offensiveCoach, final Boolean defensiveCoach,
            final Boolean supportCoach) {
        super();

        teamType = checkNotNull(team,
                "Received a null pointer as the Team Type");

        cheerleaderCost = checkNotNull(cheerCost,
                "Received a null pointer as the Cheerleader cost");
        cheerleaderInitial = checkNotNull(cheerInitial,
                "Received a null pointer as initial Cheerleaders");
        cheerleaderMax = checkNotNull(cheerMax,
                "Received a null pointer as maximum Cheerleaders");

        coachingDieCost = checkNotNull(diceCost,
                "Received a null pointer as the Coaching Dice cost");
        coachingDieInitial = checkNotNull(diceInitial,
                "Received a null pointer as initial Coaching Dice");
        coachingDieMax = checkNotNull(diceMax,
                "Received a null pointer as maximum Coaching Dice");

        dreadballCardCost = checkNotNull(cardCost,
                "Received a null pointer as the Dreadball Card cost");
        dreadballCardInitial = checkNotNull(cardInitial,
                "Received a null pointer as initial Dreadball Cards");
        dreadballCardMax = checkNotNull(cardMax,
                "Received a null pointer as maximum Dreadball Cards");

        coachingStaffCost = checkNotNull(coachingCost,
                "Received a null pointer as the Coaching Staff cost");
        startingWithOffensiveCoachingStaff = checkNotNull(offensiveCoach,
                "Received a null pointer as the initial Offensive Coach flag");
        startingWithDefensiveCoachingStaff = checkNotNull(defensiveCoach,
                "Received a null pointer as the initial Defensive Coach flag");
        startingWithSupportCoachingStaff = checkNotNull(supportCoach,
                "Received a null pointer as the initial Support Coach flag");
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

        final ImmutableTeamTypeAssetsAvailability other;

        other = (ImmutableTeamTypeAssetsAvailability) obj;
        return Objects.equals(teamType, other.teamType);
    }

    @Override
    public final Integer getCheerleaderCost() {
        return cheerleaderCost;
    }

    @Override
    public final Integer getCheerleaderInitial() {
        return cheerleaderInitial;
    }

    @Override
    public final Integer getCheerleaderMax() {
        return cheerleaderMax;
    }

    @Override
    public final Integer getCoachingDieCost() {
        return coachingDieCost;
    }

    @Override
    public final Integer getCoachingDieInitial() {
        return coachingDieInitial;
    }

    @Override
    public final Integer getCoachingDieMax() {
        return coachingDieMax;
    }

    @Override
    public final Integer getCoachingStaffCost() {
        return coachingStaffCost;
    }

    @Override
    public final Integer getDreadballCardCost() {
        return dreadballCardCost;
    }

    @Override
    public final Integer getDreadballCardInitial() {
        return dreadballCardInitial;
    }

    @Override
    public final Integer getDreadballCardMax() {
        return dreadballCardMax;
    }

    @Override
    public final Boolean getStartingWithDefensiveCoachingStaff() {
        return startingWithDefensiveCoachingStaff;
    }

    @Override
    public final Boolean getStartingWithOffensiveCoachingStaff() {
        return startingWithOffensiveCoachingStaff;
    }

    @Override
    public final Boolean getStartingWithSupportCoachingStaff() {
        return startingWithSupportCoachingStaff;
    }

    @Override
    public final TeamType getTeamType() {
        return teamType;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(teamType);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("teamType", teamType)
                .add("cheerleaderCost", cheerleaderCost)
                .add("cheerleaderInitial", cheerleaderInitial)
                .add("cheerleaderMax", cheerleaderMax)
                .add("coachingDieCost", coachingDieCost)
                .add("coachingDieInitial", coachingDieInitial)
                .add("coachingDieMax", coachingDieMax)
                .add("coachingStaffCost", coachingStaffCost)
                .add("dreadballCardCost", dreadballCardCost)
                .add("dreadballCardInitial", dreadballCardInitial)
                .add("dreadballCardMax", dreadballCardMax)
                .add("startingWithDefensiveCoachingStaff",
                        startingWithDefensiveCoachingStaff)
                .add("startingWithOffensiveCoachingStaff",
                        startingWithOffensiveCoachingStaff)
                .add("startingWithSupportCoachingStaff",
                        startingWithSupportCoachingStaff)
                .toString();
    }

}
