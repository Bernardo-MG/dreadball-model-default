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

import java.io.Serializable;
import java.util.Collection;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

/**
 * Default implementation of {@code Unit}.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class DefaultUnit extends AbstractUnit implements Serializable {

    /**
     * Serialization ID.
     */
    private static final long serialVersionUID = -5871012498706537929L;

    public DefaultUnit(final String name, final Integer cost,
            final TeamPosition position, final AttributesHolder attributes,
            final Collection<Ability> abilities, final Boolean giant) {
        super(name, cost, position, attributes, abilities, giant);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", getTemplateName())
                .add("position", getPosition()).add("giant", isGiant())
                .toString();
    }

}
