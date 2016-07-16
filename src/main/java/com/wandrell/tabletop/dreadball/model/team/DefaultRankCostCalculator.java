
package com.wandrell.tabletop.dreadball.model.team;

import static com.google.common.base.Preconditions.checkNotNull;

public final class DefaultRankCostCalculator implements RankCostCalculator {

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
    private final Integer costSabotage;

    /**
     * Cost of a Special Move Card.
     */
    private final Integer costSpecialMove;

    /**
     * Cost of a Wager.
     */
    private final Integer costWager;

    public DefaultRankCostCalculator(final Integer dieCost,
            final Integer sabotageCost, final Integer specialMoveCost,
            final Integer cheerleaderCost, final Integer wagerCost,
            final Integer medibotCost) {
        super();

        // TODO: Test this class

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
        costMedibot = checkNotNull(medibotCost,
                "Received a null pointer as the wager cost");
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
    private final Integer getCheerleaderCost() {
        return costCheerleader;
    }

    /**
     * Returns the cost of a die.
     * 
     * @return the cost of a die
     */
    private final Integer getDieCost() {
        return costDie;
    }

    /**
     * Returns the cost of a medibot.
     * 
     * @return the cost of a medibot
     */
    private final Integer getMedibotCost() {
        return costMedibot;
    }

    /**
     * Returns the cost of a sabotage card.
     * 
     * @return the cost of a sabotage card
     */
    private final Integer getSabotageCost() {
        return costSabotage;
    }

    /**
     * Returns the cost of a special move card.
     * 
     * @return the cost of a special move card
     */
    private final Integer getSpecialMoveCost() {
        return costSpecialMove;
    }

    /**
     * Returns the cost of a wager.
     * 
     * @return the cost of a wager
     */
    private final Integer getWagerCost() {
        return costWager;
    }

}
