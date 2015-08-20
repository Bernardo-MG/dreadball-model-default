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

import java.io.Serializable;
import java.util.Collection;

import com.wandrell.tabletop.dreadball.model.unit.TeamPosition;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

public final class DefaultAffinityUnitComponent
        implements AffinityUnitComponent, Serializable {

    /**
     * 
     */
    private static final long   serialVersionUID = 3423113640593046333L;
    private final UnitComponent baseComponent;
    private Integer             costActual       = 0;
    private final Integer       costAlly;
    private final Integer       costFriend;
    private final Integer       costStranger;

    public DefaultAffinityUnitComponent(final String name,
            final ComponentLocation location, final Integer allyCost,
            final Integer friendCost, final Integer strangerCost,
            final Collection<TeamPosition> positions,
            final AttributesHolder attributes,
            final Collection<Ability> abilities) {
        super();

        costAlly = checkNotNull(allyCost,
                "Received a null pointer as ally cost");
        costFriend = checkNotNull(friendCost,
                "Received a null pointer as friend cost");
        costStranger = checkNotNull(strangerCost,
                "Received a null pointer as stranger cost");

        costActual = costStranger;

        baseComponent = new DefaultUnitComponent(name, location, 0, positions,
                attributes, abilities);
    }

    @Override
    public final Collection<Ability> getAbilities() {
        return getBaseComponent().getAbilities();
    }

    @Override
    public final Integer getAllyCost() {
        return costAlly;
    }

    @Override
    public final AttributesHolder getAttributes() {
        return getBaseComponent().getAttributes();
    }

    @Override
    public final String getComponentName() {
        return getBaseComponent().getComponentName();
    }

    @Override
    public final Integer getCost() {
        return costActual;
    }

    @Override
    public final Integer getFriendCost() {
        return costFriend;
    }

    @Override
    public final ComponentLocation getLocation() {
        return getBaseComponent().getLocation();
    }

    @Override
    public final Integer getStrangerCost() {
        return costStranger;
    }

    @Override
    public final Collection<TeamPosition> getTeamPositions() {
        return getBaseComponent().getTeamPositions();
    }

    public final void setPriceForAlly() {
        costActual = getAllyCost();
    }

    public final void setPriceForFriend() {
        costActual = getFriendCost();
    }

    public final void setPriceForStranger() {
        costActual = getStrangerCost();
    }

    private final UnitComponent getBaseComponent() {
        return baseComponent;
    }

}
