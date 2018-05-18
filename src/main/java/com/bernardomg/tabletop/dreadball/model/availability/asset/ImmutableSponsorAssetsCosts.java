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

import com.google.common.base.MoreObjects;

/**
 * Asset availabilities for a
 * {@link com.bernardomg.tabletop.dreadball.model.faction.Sponsor Sponsors}.
 * <p>
 * This is an immutable implementation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ImmutableSponsorAssetsCosts
        implements SponsorAssetsCosts, Serializable {

    /**
     * Serialization id.
     */
    private static final long serialVersionUID = -8859149010870860449L;

    /**
     * Cost of an Affinity Group.
     */
    private final Integer     affinityGroupCost;

    /**
     * Cost of a Cheerleader.
     */
    private final Integer     cheerleaderCost;

    /**
     * Cost of a Coaching Die.
     */
    private final Integer     dieCost;

    /**
     * Cost of a Medibot.
     */
    private final Integer     medibotCost;

    /**
     * Cost of a Sabotage Card.
     */
    private final Integer     nastySurpriseCardCost;

    /**
     * Cost of a Special Move Card.
     */
    private final Integer     specialMoveCardCost;

    /**
     * Cost of a Wager.
     */
    private final Integer     wagerCost;

    /**
     * Constructs assets availability with the specified asset costs and
     * constraints.
     * 
     * @param dice
     *            cost of a Coaching Die
     * @param sabotage
     *            cost of a Sabotage Card
     * @param specialMove
     *            cost of a Special Move CArd
     * @param cheerleader
     *            cost of a Cheerleader
     * @param affinity
     *            cost of an Affinity Group
     * @param medibot
     *            cost of a Medibot
     * @param wager
     *            cost of a Wager
     */
    public ImmutableSponsorAssetsCosts(final Integer dice,
            final Integer sabotage, final Integer specialMove,
            final Integer cheerleader, final Integer affinity,
            final Integer medibot, final Integer wager) {
        super();

        dieCost = checkNotNull(dice,
                "Received a null pointer as Coaching Dice cost");
        nastySurpriseCardCost = checkNotNull(sabotage,
                "Received a null pointer as Sabotage Card cost");
        specialMoveCardCost = checkNotNull(specialMove,
                "Received a null pointer as Special Move Card cost");
        cheerleaderCost = checkNotNull(cheerleader,
                "Received a null pointer as Cheerleader cost");
        affinityGroupCost = checkNotNull(affinity,
                "Received a null pointer as Affinity Group cost");
        medibotCost = checkNotNull(medibot,
                "Received a null pointer as Medibot cost");
        wagerCost = checkNotNull(wager,
                "Received a null pointer as the Wager cost");
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

        final ImmutableSponsorAssetsCosts other;

        other = (ImmutableSponsorAssetsCosts) obj;
        return Objects.equals(affinityGroupCost, other.affinityGroupCost)
                && Objects.equals(cheerleaderCost, other.cheerleaderCost)
                && Objects.equals(dieCost, other.dieCost)
                && Objects.equals(medibotCost, other.medibotCost)
                && Objects.equals(nastySurpriseCardCost,
                        other.nastySurpriseCardCost)
                && Objects.equals(specialMoveCardCost,
                        other.specialMoveCardCost)
                && Objects.equals(wagerCost, other.wagerCost);
    }

    @Override
    public final Integer getAffinityGroupCost() {
        return affinityGroupCost;
    }

    @Override
    public final Integer getCheerleaderCost() {
        return cheerleaderCost;
    }

    @Override
    public final Integer getCoachingDieCost() {
        return dieCost;
    }

    @Override
    public final Integer getMediBotCost() {
        return medibotCost;
    }

    @Override
    public final Integer getNastySurpriseCardCost() {
        return nastySurpriseCardCost;
    }

    @Override
    public final Integer getSpecialMoveCardCost() {
        return specialMoveCardCost;
    }

    @Override
    public final Integer getWagerCost() {
        return wagerCost;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(affinityGroupCost, cheerleaderCost, dieCost,
                medibotCost, nastySurpriseCardCost, specialMoveCardCost,
                wagerCost);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("affinityGroupCost", affinityGroupCost)
                .add("cheerleaderCost", cheerleaderCost).add("dieCost", dieCost)
                .add("medibotCost", medibotCost)
                .add("nastySurpriseCardCost", nastySurpriseCardCost)
                .add("specialMoveCardCost", specialMoveCardCost)
                .add("wagerCost", wagerCost).toString();
    }

}
