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

/**
 * Team valoration calculator for an {@code SponsorTeam}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class SponsorTeamValorationCalculator
        extends AbstractSponsorTeamValorationCalculator {

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
    private final Integer costMediBot;

    /**
     * Cost of a Sabotage Card.
     */
    private final Integer costSabotage;

    /**
     * Cost of a Special Move Card.
     */
    private final Integer costSpecialMove;

    /**
     * Cost of a Wager.
     */
    private final Integer costWager;

    /**
     * Constructs a team valoration calculator using the specified cost.
     * <p>
     * These costs will be applied to the team assets to find out the final
     * cost.
     * 
     * @param dieCost
     *            cost of a Coaching Die
     * @param sabotageCost
     *            cost of a Sabotage Card
     * @param specialMoveCost
     *            cost of a Special Move Card
     * @param cheerleaderCost
     *            cost of a Cheerleader
     * @param wagerCost
     *            cost of a Wager
     * @param medibotCost
     *            cost of a Medibot
     */
    public SponsorTeamValorationCalculator(final Integer dieCost,
            final Integer sabotageCost, final Integer specialMoveCost,
            final Integer cheerleaderCost, final Integer wagerCost,
            final Integer medibotCost) {
        super();

        costDie = checkNotNull(dieCost,
                "Received a null pointer as the dice cost");
        costSabotage = checkNotNull(sabotageCost,
                "Received a null pointer as the sabotage card cost");
        costSpecialMove = checkNotNull(specialMoveCost,
                "Received a null pointer as the special move card cost");
        costCheerleader = checkNotNull(cheerleaderCost,
                "Received a null pointer as the cheerleader cost");
        costWager = checkNotNull(wagerCost,
                "Received a null pointer as the wager cost");
        costMediBot = checkNotNull(medibotCost,
                "Received a null pointer as the wager cost");
    }

    @Override
    protected final Integer getCheerleaderCost() {
        return costCheerleader;
    }

    @Override
    protected final Integer getDieCost() {
        return costDie;
    }

    @Override
    protected final Integer getMediBotCost() {
        return costMediBot;
    }

    @Override
    protected final Integer getSabotageCost() {
        return costSabotage;
    }

    @Override
    protected final Integer getSpecialMoveCost() {
        return costSpecialMove;
    }

    @Override
    protected final Integer getWagerCost() {
        return costWager;
    }

}
