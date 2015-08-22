package com.wandrell.tabletop.dreadball.testing.model.test.unit.unit;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dreadball.model.unit.AdvancementUnit;
import com.wandrell.tabletop.dreadball.model.unit.AdvancementUnitValorationBuilder;
import com.wandrell.tabletop.dreadball.model.unit.UnitValorationCalculator;
import com.wandrell.tabletop.dreadball.model.unit.component.UnitComponent;

public final class TestAdvancementUnitValorationBuilder {

    public TestAdvancementUnitValorationBuilder() {
        super();
    }

    @Test
    public final void testValoration() {
        final AdvancementUnit unit;
        final UnitValorationCalculator<AdvancementUnit> valorator;
        final UnitComponent implant;

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
