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

import java.io.Serializable;
import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.calculator.RankCostCalculator;
import com.wandrell.tabletop.dreadball.model.team.calculator.TeamValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.Unit;

/**
 * Dreadball Xtreme (DBX) team, composed of units with affinities, and a Sponsor
 * which changes over time.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class DefaultSponsorTeam extends AbstractTeam<Unit>
        implements SponsorTeam, Serializable {

    /**
     * Serialization id.
     */
    private static final long                           serialVersionUID  = -6502596684517851116L;

    /**
     * Rank cost calculator.
     */
    private final RankCostCalculator                    rankCostCalculator;

    /**
     * Number of Medibots in the team.
     */
    private Integer                                     teamMedibots      = 0;

    /**
     * Number of Sabotage Cards in the team.
     */
    private Integer                                     teamSabotageCards = 0;

    /**
     * Number of Special Move Cards.
     */
    private Integer                                     teamSpMoveCards   = 0;

    /**
     * Team's sponsor.
     */
    private final Sponsor                               teamSponsor;

    /**
     * Number of Wagers in the team.
     */
    private Integer                                     teamWagers        = 0;

    /**
     * Valoration calculator.
     */
    private final TeamValorationCalculator<SponsorTeam> valorationCalculator;

    /**
     * Constructs a sponsor team with the specified arguments.
     * 
     * @param sponsor
     *            the team's sponsor
     * @param valorator
     *            valoration calculator for the team
     * @param rankCoster
     *            rank cost calculator for the team
     */
    public DefaultSponsorTeam(final Sponsor sponsor,
            final TeamValorationCalculator<SponsorTeam> valorator,
            final RankCostCalculator rankCoster) {
        super();

        teamSponsor = checkNotNull(sponsor,
                "Received a null pointer as sponsor");
        valorationCalculator = checkNotNull(valorator,
                "Received a null pointer as valoration calculator");
        rankCostCalculator = checkNotNull(rankCoster,
                "Received a null pointer as rank cost calculator");
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

        final DefaultSponsorTeam other;

        other = (DefaultSponsorTeam) obj;
        return Objects.equals(teamSponsor, other.teamSponsor);
    }

    @Override
    public final Integer getMediBots() {
        return teamMedibots;
    }

    @Override
    public final Integer getRankCost() {
        return getRankCostCalculator().getRankCost(this);
    }

    @Override
    public final Integer getSabotageCards() {
        return teamSabotageCards;
    }

    @Override
    public final Integer getSpecialMoveCards() {
        return teamSpMoveCards;
    }

    @Override
    public final Sponsor getSponsor() {
        return teamSponsor;
    }

    @Override
    public final Integer getValoration() {
        return getValorationCalculator().getValoration(this);
    }

    @Override
    public final Integer getWagers() {
        return teamWagers;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(teamSponsor);
    }

    @Override
    public final void setMediBots(final Integer medibots) {
        teamMedibots = medibots;
    }

    @Override
    public final void setSabotageCards(final Integer cards) {
        teamSabotageCards = cards;
    }

    @Override
    public final void setSpecialMoveCards(final Integer cards) {
        teamSpMoveCards = cards;
    }

    @Override
    public final void setWagers(final Integer wagers) {
        teamWagers = wagers;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("sponsor", teamSponsor)
                .add("players", getPlayers()).toString();
    }

    /**
     * Returns the rank cost calculator.
     * 
     * @return the rank cost calculator
     */
    private final RankCostCalculator getRankCostCalculator() {
        return rankCostCalculator;
    }

    /**
     * Returns the valoration calculator.
     * 
     * @return the valoration calculator
     */
    private final TeamValorationCalculator<SponsorTeam>
            getValorationCalculator() {
        return valorationCalculator;
    }

}
