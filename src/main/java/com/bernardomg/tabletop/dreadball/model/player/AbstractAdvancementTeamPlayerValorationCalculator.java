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

package com.bernardomg.tabletop.dreadball.model.player;

import static com.google.common.base.Preconditions.checkNotNull;

import com.bernardomg.tabletop.dreadball.model.player.AdvancementTeamPlayer;

/**
 * Calculates the valoration of an {@link AdvancementTeamPlayer}.
 * <p>
 * It uses the DBO's valoration formula, which consists on: [unit cost] + [unit
 * rank]*[rank value] + [implant cost].
 * <p>
 * This means that the unit should have been grafted an implant, or have a
 * working stub, for this formula to work.
 * <p>
 * This abstract class encapsulates the calculation algorithm, letting the
 * actual implementation handle the configuration values.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public abstract class AbstractAdvancementTeamPlayerValorationCalculator
        implements TeamPlayerValorationCalculator<AdvancementTeamPlayer> {

    /**
     * Default constructor.
     */
    public AbstractAdvancementTeamPlayerValorationCalculator() {
        super();
    }

    @Override
    public final Integer getValoration(final AdvancementTeamPlayer unit) {
        Integer valoration;

        checkNotNull(unit, "Received a null pointer as the unit");

        valoration = unit.getCost();

        valoration += unit.getGraftedImplant().getCost();
        valoration += unit.getRank() * getRankCostIncrease();

        return valoration;
    }

    /**
     * Returns the cost of each rank.
     * <p>
     * This value will be multiplied by the unit's rank to find the actual rank
     * value.
     * 
     * @return the cost of each rank
     */
    protected abstract Integer getRankCostIncrease();

}
