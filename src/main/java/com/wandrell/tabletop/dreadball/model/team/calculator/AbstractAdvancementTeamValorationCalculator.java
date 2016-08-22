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

package com.wandrell.tabletop.dreadball.model.team.calculator;

import static com.google.common.base.Preconditions.checkNotNull;

import com.wandrell.tabletop.dreadball.model.team.AdvancementTeam;
import com.wandrell.tabletop.dreadball.model.unit.AdvancementUnit;

/**
 * Abstract team valoration calculator for an {@code AdvancementTeam}. This
 * encapsulates the calculation algorithm, letting the actual implementation
 * handle the configuration values.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public abstract class AbstractAdvancementTeamValorationCalculator
        implements TeamValorationCalculator<AdvancementTeam> {

    /**
     * Default constructor.
     */
    public AbstractAdvancementTeamValorationCalculator() {
        super();
    }

    @Override
    public final Integer getValoration(final AdvancementTeam team) {
        Integer valoration;

        checkNotNull(team, "Received a null pointer as the team");

        valoration = team.getCash();
        for (final AdvancementUnit unit : team.getPlayers().values()) {
            valoration += unit.getValoration();
        }

        valoration += team.getCoachingDice() * getCostDie();
        valoration += team.getDreadballCards() * getCostCard();
        valoration += team.getCheerleaders() * getCostCheerleader();

        if (team.getDefensiveCoachingStaff()) {
            valoration += getCostCoaching();
        }
        if (team.getOffensiveCoachingStaff()) {
            valoration += getCostCoaching();
        }
        if (team.getSupportCoachingStaff()) {
            valoration += getCostCoaching();
        }

        return valoration;
    }

    /**
     * Returns the cost of a dreadball card.
     * 
     * @return the cost of a dreadball card
     */
    protected abstract Integer getCostCard();

    /**
     * Returns the cost of a cheerleader.
     * 
     * @return the cost of a dreadball card
     */
    protected abstract Integer getCostCheerleader();

    /**
     * Returns the cost of coaching staff.
     * 
     * @return the cost of coaching staff
     */
    protected abstract Integer getCostCoaching();

    /**
     * Returns the cost of a Dreadball die.
     * 
     * @return the cost of a Dreadball die
     */
    protected abstract Integer getCostDie();

}
