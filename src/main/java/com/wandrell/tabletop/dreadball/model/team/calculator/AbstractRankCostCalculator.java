/**
 * Copyright 2016 the original author or authors
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

import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;

/**
 * Abstract rank cost calculator. This encapsulates the calculation algorithm,
 * letting the actual implementation handle the configuration values.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public abstract class AbstractRankCostCalculator implements RankCostCalculator {

    /**
     * Default constructor.
     */
    public AbstractRankCostCalculator() {
        super();
    }

    @Override
    public final Integer getRankCost(final SponsorTeam team) {
        Integer valoration;

        checkNotNull(team, "Received a null pointer as the team");

        valoration = 0;

        valoration += team.getCoachingDice() * getDieCost();
        valoration += team.getSabotageCards() * getSabotageCost();
        valoration += team.getSpecialMoveCards() * getSpecialMoveCost();
        valoration += team.getCheerleaders() * getCheerleaderCost();
        valoration += team.getWagers() * getWagerCost();
        valoration += team.getMediBots() * getMedibotCost();

        return valoration;
    }

    /**
     * Returns the cost of a cheerleader.
     * 
     * @return the cost of a cheerleader
     */
    protected abstract Integer getCheerleaderCost();

    /**
     * Returns the cost of a die.
     * 
     * @return the cost of a die
     */
    protected abstract Integer getDieCost();

    /**
     * Returns the cost of a medibot.
     * 
     * @return the cost of a medibot
     */
    protected abstract Integer getMedibotCost();

    /**
     * Returns the cost of a sabotage card.
     * 
     * @return the cost of a sabotage card
     */
    protected abstract Integer getSabotageCost();

    /**
     * Returns the cost of a special move card.
     * 
     * @return the cost of a special move card
     */
    protected abstract Integer getSpecialMoveCost();

    /**
     * Returns the cost of a wager.
     * 
     * @return the cost of a wager
     */
    protected abstract Integer getWagerCost();

}
