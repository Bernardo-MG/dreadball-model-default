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

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.Attributes;

/**
 * Unit with affinity groups, and various costs which will depend on how many of
 * such affinities are shared.
 * <p>
 * This is an immutable implementation.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class DefaultAffinityUnit implements AffinityUnit {

    /**
     * The affinities of the unit.
     */
    private final Collection<AffinityGroup> affinityGroups  = new LinkedHashSet<AffinityGroup>();

    /**
     * {@code Unit} used for inheritance through composition.
     */
    private final Unit                      baseUnit;

    /**
     * The actual cost of the unit.
     */
    private Integer                         costActual      = 0;

    /**
     * Unit cost for an ally.
     */
    private final Integer                   costAlly;

    /**
     * Unit cost for a friend.
     */
    private final Integer                   costFriend;

    /**
     * Unit cost for a stranger.
     */
    private final Integer                   costStranger;

    /**
     * The affinities hated by the unit.
     */
    private final Collection<AffinityGroup> hatedAffinities = new LinkedHashSet<AffinityGroup>();

    /**
     * Name given to the unit.
     */
    private String                          unitName        = "";

    /**
     * Constructs a {@code DefaultAffinityUnit} with the specified arguments.
     * 
     * @param nameTemplate
     *            the unit's base template name
     * @param position
     *            team position role of the unit
     * @param attributes
     *            unit attributes
     * @param abilities
     *            unit abilities
     * @param giant
     *            flag indicating if this is a giant
     * @param affinities
     *            the unit affinities
     * @param hated
     *            the unit hated affinities
     * @param allyCost
     *            the unit cost for an ally
     * @param friendCost
     *            the unit cost for a friend
     * @param strangerCost
     *            the unit cost for a stranger
     */
    public DefaultAffinityUnit(final String nameTemplate, final Role position,
            final Attributes attributes, final Collection<Ability> abilities,
            final Boolean giant, final Collection<AffinityGroup> affinities,
            final Collection<AffinityGroup> hated, final Integer allyCost,
            final Integer friendCost, final Integer strangerCost) {
        super();

        baseUnit = new DefaultUnit(nameTemplate, 0, position, attributes,
                abilities, giant);

        costAlly = checkNotNull(allyCost,
                "Received a null pointer as ally cost");
        costFriend = checkNotNull(friendCost,
                "Received a null pointer as friend cost");
        costStranger = checkNotNull(strangerCost,
                "Received a null pointer as stranger cost");
        checkNotNull(affinities, "Received a null pointer as affinities");
        checkNotNull(hated, "Received a null pointer as hated affinities");

        for (final AffinityGroup affinity : affinities) {
            affinityGroups.add(checkNotNull(affinity,
                    "Received a null pointer as affinity"));
        }

        for (final AffinityGroup affinity : hated) {
            hatedAffinities.add(checkNotNull(affinity,
                    "Received a null pointer as hated affinity"));
        }
    }

    @Override
    public final Collection<Ability> getAbilities() {
        return getBaseUnit().getAbilities();
    }

    @Override
    public final Collection<AffinityGroup> getAffinityGroups() {
        return Collections
                .unmodifiableCollection(getAffinityGroupsModifiable());
    }

    @Override
    public final Integer getAllyCost() {
        return costAlly;
    }

    @Override
    public final Attributes getAttributes() {
        return getBaseUnit().getAttributes();
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
    public final Collection<AffinityGroup> getHatedAffinityGroups() {
        return Collections
                .unmodifiableCollection(getHatedAffinityGroupsModifiable());
    }

    @Override
    public final String getName() {
        return unitName;
    }

    @Override
    public final Role getRole() {
        return getBaseUnit().getRole();
    }

    @Override
    public final Integer getStrangerCost() {
        return costStranger;
    }

    @Override
    public final String getTemplateName() {
        return getBaseUnit().getTemplateName();
    }

    @Override
    public final Boolean isGiant() {
        return getBaseUnit().isGiant();
    }

    /**
     * Sets the cost as the ally cost.
     */
    public final void setCostForAlly() {
        costActual = getAllyCost();
    }

    /**
     * Sets the cost as the friend cost.
     */
    public final void setCostForFriend() {
        costActual = getFriendCost();
    }

    /**
     * Sets the cost as the stranger cost.
     */
    public final void setCostForStranger() {
        costActual = getStrangerCost();
    }

    @Override
    public final void setName(final String name) {
        unitName = name;
    }

    /**
     * Returns the modifiable collection of the unit's affinity groups.
     * 
     * @return the modifiable collection of the unit's affinity groups
     */
    private final Collection<AffinityGroup> getAffinityGroupsModifiable() {
        return affinityGroups;
    }

    /**
     * Returns the base unit class being used for inheritance through
     * composition.
     * 
     * @return the base unit class being used for inheritance through
     *         composition
     */
    private final Unit getBaseUnit() {
        return baseUnit;
    }

    /**
     * Returns the modifiable collection of the unit's hated affinity groups.
     * 
     * @return the modifiable collection of the unit's hated affinity groups
     */
    private final Collection<AffinityGroup> getHatedAffinityGroupsModifiable() {
        return hatedAffinities;
    }

}
