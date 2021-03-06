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

package com.bernardomg.tabletop.dreadball.model.player.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Objects;

import com.google.common.base.MoreObjects;

/**
 * TeamPlayer attributes.
 * <p>
 * This is a mutable implementation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class MutableAttributes implements Attributes, Serializable {

    /**
     * Serialization id.
     */
    private static final long serialVersionUID = -4043649412211375530L;

    /**
     * Armor value.
     */
    private Integer           armorValue       = 0;

    /**
     * Movement value.
     */
    private Integer           movementValue    = 0;

    /**
     * Skill value.
     */
    private Integer           skillValue       = 0;

    /**
     * Speed value.
     */
    private Integer           speedValue       = 0;

    /**
     * Strength value.
     */
    private Integer           strengthValue    = 0;

    /**
     * Default constructor.
     */
    public MutableAttributes() {
        super();
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

        final MutableAttributes other;

        other = (MutableAttributes) obj;
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

    /**
     * Sets the armor value.
     * 
     * @param armor
     *            the new armor value
     */
    public final void setArmor(final Integer armor) {
        armorValue = checkNotNull(armor, "Received a null pointer as armor");
    }

    /**
     * Sets the movement value.
     * 
     * @param movement
     *            the new movement value
     */
    public final void setMovement(final Integer movement) {
        movementValue = checkNotNull(movement,
                "Received a null pointer as movement");
    }

    /**
     * Sets the skill value.
     * 
     * @param skill
     *            the new skill value
     */
    public final void setSkill(final Integer skill) {
        skillValue = checkNotNull(skill, "Received a null pointer as skill");
    }

    /**
     * Sets the speed value.
     * 
     * @param speed
     *            the new speed value
     */
    public final void setSpeed(final Integer speed) {
        speedValue = checkNotNull(speed, "Received a null pointer as speed");
    }

    /**
     * Sets the strength value.
     * 
     * @param strength
     *            the new strength value
     */
    public final void setStrength(final Integer strength) {
        strengthValue = checkNotNull(strength,
                "Received a null pointer as strength");
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("armor", armorValue)
                .add("movement", movementValue).add("skill", skillValue)
                .add("speed", speedValue).add("strength", strengthValue)
                .toString();
    }

}
