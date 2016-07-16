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

package com.wandrell.tabletop.dreadball.model.availability.asset;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

/**
 * Asset availabilities for a
 * {@link com.wandrell.tabletop.dreadball.model.faction.Sponsor Sponsors}.
 * <p>
 * This is an immutable implementation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class DefaultSponsorAssetsAvailability
        implements SponsorAssetsAvailability {

    /**
     * Cost of an Affinity Group.
     */
    private final Integer costAffinityGroup;

    /**
     * Cost of a Cheerleader.
     */
    private final Integer costCheerleader;

    /**
     * Cost of a Coaching Die.
     */
    private final Integer costDie;

    /**
     * Cost of a Medibot.
     */
    private final Integer costMedibot;

    /**
     * Cost of a Sabotage Card.
     */
    private final Integer costSabotageCard;

    /**
     * Cost of a Special Move Card.
     */
    private final Integer costSpMoveCard;

    /**
     * Cost for unlocking a Cheerleader.
     */
    private final Integer costUnlockCheer;

    /**
     * Cost of a Wager.
     */
    private final Integer costWager;

    /**
     * Maximum number of Wagers allowed.
     */
    private final Integer maxWagerCount;

    /**
     * Minimum allowed cost for a team.
     */
    private final Integer minTeamCost;

    /**
     * Constructs assets availability with the specified asset costs and
     * constraints.
     * 
     * @param diceCost
     *            cost of a Coaching Die
     * @param sabotageCost
     *            cost of a Sabotage Card
     * @param specialMoveCost
     *            cost of a Special Move CArd
     * @param cheerleaderUnlock
     *            cost of unlocking Cheerleaders
     * @param cheerleaderCost
     *            cost of a Cheerleader
     * @param affinityCost
     *            cost of an Affinity Group
     * @param medibotCost
     *            cost of a Medibot
     * @param wagerCost
     *            cost of a Wager
     * @param teamMinCost
     *            minimum cost for a team
     * @param maxWagers
     *            maximum number of Wagers allowed
     */
    public DefaultSponsorAssetsAvailability(final Integer diceCost,
            final Integer sabotageCost, final Integer specialMoveCost,
            final Integer cheerleaderUnlock, final Integer cheerleaderCost,
            final Integer affinityCost, final Integer medibotCost,
            final Integer wagerCost, final Integer teamMinCost,
            final Integer maxWagers) {
        super();

        costDie = checkNotNull(diceCost,
                "Received a null pointer as Coaching Dice cost");
        costSabotageCard = checkNotNull(sabotageCost,
                "Received a null pointer as Sabotage Card cost");
        costSpMoveCard = checkNotNull(specialMoveCost,
                "Received a null pointer as Special Move Card cost");
        costUnlockCheer = checkNotNull(cheerleaderUnlock,
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
        maxWagerCount = checkNotNull(maxWagers,
                "Received a null pointer as the maximum allowed number of Wagers");
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

        final DefaultSponsorAssetsAvailability other;

        other = (DefaultSponsorAssetsAvailability) obj;
        return Objects.equals(costAffinityGroup, other.costAffinityGroup)
                && Objects.equals(costCheerleader, other.costCheerleader)
                && Objects.equals(costDie, other.costDie)
                && Objects.equals(costMedibot, other.costMedibot)
                && Objects.equals(costSabotageCard, other.costSabotageCard)
                && Objects.equals(costSpMoveCard, other.costSpMoveCard)
                && Objects.equals(costUnlockCheer, other.costUnlockCheer)
                && Objects.equals(costWager, other.costWager)
                && Objects.equals(maxWagerCount, other.maxWagerCount)
                && Objects.equals(minTeamCost, other.minTeamCost);
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
        return costUnlockCheer;
    }

    @Override
    public final Integer getCoachingDieCost() {
        return costDie;
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
        return costSpMoveCard;
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

    @Override
    public final int hashCode() {
        return Objects.hash(costAffinityGroup, costCheerleader, costDie,
                costMedibot, costSabotageCard, costSpMoveCard, costUnlockCheer,
                costWager, maxWagerCount, minTeamCost);
    }

}
