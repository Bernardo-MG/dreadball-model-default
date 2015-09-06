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
package com.wandrell.tabletop.dreadball.testing.model.test.unit.unit;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.unit.AdvancementUnit;
import com.wandrell.tabletop.dreadball.model.unit.AdvancementUnitValorationBuilder;
import com.wandrell.tabletop.dreadball.model.unit.UnitValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.component.UnitComponent;

/**
 * Unit tests for {@link UnitValorationCalculator} applied to a
 * {@link AdvancementUnit}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Valoration is calculated correctly</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestAdvancementUnitUnitValorationCalculator {

    /**
     * Default constructor.
     */
    public TestAdvancementUnitUnitValorationCalculator() {
        super();
    }

    /**
     * Tests that the valoration is calculated correctly.
     */
    @Test
    public final void testValoration() {
        final UnitValorationCalculator<AdvancementUnit> valorator; // Tested
                                                                   // class
        final AdvancementUnit unit;     // Unit for the test
        final UnitComponent implant;    // Unit's implant

        implant = Mockito.mock(UnitComponent.class);
        Mockito.when(implant.getCost()).thenReturn(5);

        unit = Mockito.mock(AdvancementUnit.class);
        Mockito.when(unit.getCost()).thenReturn(10);
        Mockito.when(unit.getRank()).thenReturn(3);
        Mockito.when(unit.getGraftedImplant()).thenReturn(implant);

        valorator = new AdvancementUnitValorationBuilder(5);

        Assert.assertEquals(valorator.getValoration(unit), (Integer) 30);
    }

}
