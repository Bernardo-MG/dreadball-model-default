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
package com.wandrell.tabletop.dreadball.model.unit.component;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

/**
 * Abstract root class for composite units.
 * <p>
 * It stores the unit components.
 * 
 * @author Bernardo Martínez Garrido
 */
public class BaseCompositeUnit {

    /**
     * Components of the unit.
     */
    private final Collection<UnitComponent> unitComponents = new LinkedHashSet<UnitComponent>();

    /**
     * Constructs an {@code AbstractCompositeUnit} with the specified arguments.
     * 
     * @param components
     *            the components which make up the unit
     */
    public BaseCompositeUnit(final Collection<UnitComponent> components) {
        super();

        checkNotNull(components,
                "Received a null pointer as valoration the components");

        for (final UnitComponent component : components) {
            checkNotNull(component,
                    "Received a null pointer as valoration a component");

            unitComponents.add(component);
        }
    }

    /**
     * Returns the components which make up the unit.
     * 
     * @return the components which make up the unit
     */
    public final Collection<UnitComponent> getComponents() {
        return Collections.unmodifiableCollection(getComponentsModifiable());
    }

    /**
     * Returns a modifiable collection with the unit components.
     * 
     * @return a modifiable collection with the unit components
     */
    private final Collection<UnitComponent> getComponentsModifiable() {
        return unitComponents;
    }

}
