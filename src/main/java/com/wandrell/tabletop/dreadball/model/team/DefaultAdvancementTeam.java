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

import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.dreadball.model.faction.TeamType;
import com.wandrell.tabletop.dreadball.model.unit.AdvancementUnit;

/**
 * Default implementation of {@link AdvancementTeam}.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class DefaultAdvancementTeam extends AbstractTeam<AdvancementUnit>
        implements AdvancementTeam {
    /**
     * Flag indicating if the team has a Defensive Coaching Staff.
     */
    private Boolean                                         defensiveCoach = false;
    /**
     * Flag indicating if the team has an Offensive Coaching Staff.
     */
    private Boolean                                         offensiveCoach = false;
    /**
     * Flag indicating if the team has a Support Coaching Staff.
     */
    private Boolean                                         supportCoach   = false;
    /**
     * Number of Dreadball Cards in the team.
     */
    private Integer                                         teamCards      = 0;
    /**
     * Team's unspent cash.
     */
    private Integer                                         teamCash       = 0;
    /**
     * Team's name.
     */
    private String                                          teamName;
    /**
     * The base type of the team.
     */
    private final TeamType                                  teamType;
    /**
     * Builder for calculating the valoration.
     */
    private final TeamValorationCalculator<AdvancementTeam> valorationBuilder;

    /**
     * Constructs a {@code DefaultLicensedTeam} with the specified parameters.
     * 
     * @param name
     *            team's name
     * @param type
     *            team's base type
     * @param valorator
     *            valoration builder
     */
    public DefaultAdvancementTeam(final String name, final TeamType type,
            final TeamValorationCalculator<AdvancementTeam> valorator) {
        super();

        teamName = checkNotNull(name, "Received a null pointer as name");
        teamType = checkNotNull(type, "Received a null pointer as type");
        valorationBuilder = checkNotNull(valorator,
                "Received a null pointer as valoration builder");
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

        final DefaultAdvancementTeam other;

        other = (DefaultAdvancementTeam) obj;
        return Objects.equals(teamName, other.teamName);
    }

    @Override
    public final Integer getCash() {
        return teamCash;
    }

    @Override
    public final Integer getDreadballCards() {
        return teamCards;
    }

    @Override
    public final String getTeamName() {
        return teamName;
    }

    @Override
    public final TeamType getTeamType() {
        return teamType;
    }

    @Override
    public final Integer getValoration() {
        return getValorationCalculator().getValoration(this);
    }

    @Override
    public final Boolean hasDefensiveCoachingStaff() {
        return defensiveCoach;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(teamName);
    }

    @Override
    public final Boolean hasOffensiveCoachingStaff() {
        return offensiveCoach;
    }

    @Override
    public final Boolean hasSupportCoachingStaff() {
        return supportCoach;
    }

    @Override
    public final void setCash(final Integer cash) {
        checkNotNull(cash, "Received a null pointer as cash");

        this.teamCash = cash;
    }

    @Override
    public final void setDefensiveCoachingStaff(final Boolean coach) {
        defensiveCoach = coach;
    }

    @Override
    public final void setDreadballCards(final Integer cards) {
        teamCards = cards;
    }

    @Override
    public final void setOffensiveCoachingStaff(final Boolean coach) {
        offensiveCoach = coach;
    }

    @Override
    public final void setSupportCoachingStaff(final Boolean coach) {
        supportCoach = coach;
    }

    @Override
    public final void setTeamName(final String name) {
        teamName = name;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", teamName)
                .add("type", teamType).add("cash", getCash())
                .add("players", getPlayers()).toString();
    }

    /**
     * Returns a valoration calculator.
     * 
     * @return a valoration calculator
     */
    private final TeamValorationCalculator<AdvancementTeam>
            getValorationCalculator() {
        return valorationBuilder;
    }

}
