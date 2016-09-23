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

package com.wandrell.tabletop.dreadball.model.unit.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Objects;

import com.google.common.base.MoreObjects;

/**
 * Unit attributes.
 * <p>
 * This is an immutable implementation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ImmutableAttributes implements Attributes, Serializable {

    /**
     * Serialization id.
     */
    private static final long serialVersionUID = 5432386510717307041L;

    /**
     * Armor value.
     */
    private final Integer     armorValue;

    /**
     * Movement value.
     */
    private final Integer     movementValue;

    /**
     * Skill value.
     */
    private final Integer     skillValue;

    /**
     * Speed value.
     */
    private final Integer     speedValue;

    /**
     * Strength value.
     */
    private final Integer     strengthValue;

    /**
     * Constructs attributes with the specified values.
     * 
     * @param armor
     *            armor value
     * @param movement
     *            movement value
     * @param skill
     *            skill value
     * @param speed
     *            speed value
     * @param strength
     *            strength value
     */
    public ImmutableAttributes(final Integer armor, final Integer movement,
            final Integer skill, final Integer speed, final Integer strength) {
        super();

        armorValue = checkNotNull(armor, "Received a null pointer as armor");
        movementValue = checkNotNull(movement,
                "Received a null pointer as movement");
        skillValue = checkNotNull(skill, "Received a null pointer as skill");
        speedValue = checkNotNull(speed, "Received a null pointer as speed");
        strengthValue = checkNotNull(strength,
                "Received a null pointer as strength");
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final ImmutableAttributes other;

        other = (ImmutableAttributes) obj;
        return Objects.equals(armorValue, other.armorValue)
                && Objects.equals(movementValue, other.movementValue)
                && Objects.equals(skillValue, other.skillValue)
                && Objects.equals(speedValue, other.speedValue)
                && Objects.equals(strengthValue, other.strengthValue);
    }

    @Override
    public final Integer getArmor() {
        return armorValue;
    }

    @Override
    public final Integer getMovement() {
        return movementValue;
    }

    @Override
    public final Integer getSkill() {
        return skillValue;
    }

    @Override
    public final Integer getSpeed() {
        return speedValue;
    }

    @Override
    public final Integer getStrength() {
        return strengthValue;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(armorValue, movementValue, skillValue, speedValue,
                strengthValue);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("armor", armorValue)
                .add("movement", movementValue).add("skill", skillValue)
                .add("speed", speedValue).add("strength", strengthValue)
                .toString();
    }

}
