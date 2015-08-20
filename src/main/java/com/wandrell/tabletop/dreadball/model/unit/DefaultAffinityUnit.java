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
import java.util.Collection;
import java.util.LinkedList;

import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

public final class DefaultAffinityUnit extends AbstractUnit
        implements AffinityUnit, Serializable {

    private static final long               serialVersionUID = -7923136650997946968L;
    private final Collection<AffinityGroup> affinityGroups   = new LinkedList<AffinityGroup>();
    private final Integer                   costAlly;
    private final Integer                   costFriend;
    private final Integer                   costStranger;

    public DefaultAffinityUnit(final String name, final Integer cost,
            final TeamPosition position, final AttributesHolder attributes,
            final Collection<Ability> abilities, final Boolean giant,
            final Collection<AffinityGroup> affinities, final Integer allyCost,
            final Integer friendCost, final Integer strangerCost) {
        super(name, cost, position, attributes, abilities, giant);

        costAlly = checkNotNull(allyCost,
                "Received a null pointer as ally cost");
        costFriend = checkNotNull(friendCost,
                "Received a null pointer as friend cost");
        costStranger = checkNotNull(strangerCost,
                "Received a null pointer as stranger cost");
        checkNotNull(affinities, "Received a null pointer as affinities");

        for (final AffinityGroup affinity : affinities) {
            affinityGroups.add(checkNotNull(affinity,
                    "Received a null pointer as affinity"));
        }
    }

    @Override
    public final Collection<AffinityGroup> getAffinityGroups() {
        return affinityGroups;
    }

    @Override
    public final Integer getAllyCost() {
        return costAlly;
    }

    @Override
    public final Integer getFriendCost() {
        return costFriend;
    }

    @Override
    public final Integer getStrangerCost() {
        return costStranger;
    }

}
