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
package com.wandrell.tabletop.dreadball.model.unit;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

public final class DefaultUnitValorationBuilder
        implements UnitValorationBuilder, Serializable {

    private static final long serialVersionUID = -1723086163134895663L;
    private final Integer     rankValue;

    public DefaultUnitValorationBuilder(final Integer rankCostIncrease) {
        super();

        rankValue = checkNotNull(rankCostIncrease,
                "Received a null pointer as the rank cost increase");
    }

    @Override
    public final Integer getValoration(final Unit unit) {
        final AdvancementUnit advUnit;
        Integer valoration;

        checkNotNull(unit, "Received a null pointer as the unit");

        valoration = unit.getCost();
        if (unit instanceof AdvancementUnit) {
            advUnit = (AdvancementUnit) unit;

            valoration += advUnit.getGraftedImplant().getCost();
            valoration += advUnit.getRank() * getRankCostIncrease();
        }

        return valoration;
    }

    private final Integer getRankCostIncrease() {
        return rankValue;
    }

}
