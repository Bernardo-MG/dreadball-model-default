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

package com.wandrell.tabletop.dreadball.model.unit;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Implementation of {@link UnitValorationCalculator} for
 * {@link AdvancementUnit}.
 * <p>
 * It uses the DBO's valoration formula, which consists on: [unit cost] + [unit
 * rank]*[rank value] + [implant cost].
 * <p>
 * This means that the unit should have been grafted an implant, or have a
 * working stub, for this formula to work.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class AdvancementUnitValorationBuilder
        implements UnitValorationCalculator<AdvancementUnit> {

    /**
     * Value of each rank.
     * <p>
     * A unit's rank will be multiplied by this number to find its value.
     */
    private final Integer rankValue;

    /**
     * Constructs a {@code AdvancementUnitValorationBuilder} with the specified
     * arguments.
     * 
     * @param rankCostIncrease
     *            the cost of each rank
     */
    public AdvancementUnitValorationBuilder(final Integer rankCostIncrease) {
        super();

        rankValue = checkNotNull(rankCostIncrease,
                "Received a null pointer as the rank cost increase");
    }

    @Override
    public final Integer getValoration(final AdvancementUnit unit) {
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
    private final Integer getRankCostIncrease() {
        return rankValue;
    }

}
