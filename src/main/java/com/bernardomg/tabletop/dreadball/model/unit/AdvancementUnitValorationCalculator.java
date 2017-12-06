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

package com.bernardomg.tabletop.dreadball.model.unit;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

/**
 * Valoration calculator for {@link AdvancementUnit}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class AdvancementUnitValorationCalculator extends
        AbstractAdvancementUnitValorationCalculator implements Serializable {

    /**
     * Serialization id.
     */
    private static final long serialVersionUID = 7339981867271775690L;

    /**
     * Value of each rank.
     * <p>
     * A unit's rank will be multiplied by this number to find its value.
     */
    private final Integer     rankValue;

    /**
     * Constructs an advancement unit valoration calculator with the specified
     * arguments.
     * 
     * @param rankCostIncrease
     *            the cost of each rank
     */
    public AdvancementUnitValorationCalculator(final Integer rankCostIncrease) {
        super();

        rankValue = checkNotNull(rankCostIncrease,
                "Received a null pointer as the rank cost increase");
    }

    /**
     * Returns the cost of each rank.
     * <p>
     * This value will be multiplied by the unit's rank to find the actual rank
     * value.
     * 
     * @return the cost of each rank
     */
    @Override
    protected final Integer getRankCostIncrease() {
        return rankValue;
    }

}
