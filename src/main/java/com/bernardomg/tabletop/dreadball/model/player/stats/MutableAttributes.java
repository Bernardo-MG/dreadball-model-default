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
    private Integer           armor       = 0;

    /**
     * Movement value.
     */
    private Integer           movement    = 0;

    /**
     * Skill value.
     */
    private Integer           skill       = 0;

    /**
     * Speed value.
     */
    private Integer           speed       = 0;

    /**
     * Strength value.
     */
    private Integer           strength    = 0;

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
        return Objects.equals(armor, other.armor)
                && Objects.equals(movement, other.movement)
                && Objects.equals(skill, other.skill)
                && Objects.equals(speed, other.speed)
                && Objects.equals(strength, other.strength);
    }

    @Override
    public final Integer getArmor() {
        return armor;
    }

    @Override
    public final Integer getMovement() {
        return movement;
    }

    @Override
    public final Integer getSkill() {
        return skill;
    }

    @Override
    public final Integer getSpeed() {
        return speed;
    }

    @Override
    public final Integer getStrength() {
        return strength;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(armor, movement, skill, speed,
                strength);
    }

    /**
     * Sets the armor value.
     * 
     * @param value
     *            the new armor value
     */
    public final void setArmor(final Integer value) {
        armor = checkNotNull(value, "Received a null pointer as armor");
    }

    /**
     * Sets the movement value.
     * 
     * @param value
     *            the new movement value
     */
    public final void setMovement(final Integer value) {
        movement = checkNotNull(value,
                "Received a null pointer as movement");
    }

    /**
     * Sets the skill value.
     * 
     * @param value
     *            the new skill value
     */
    public final void setSkill(final Integer value) {
        skill = checkNotNull(value, "Received a null pointer as skill");
    }

    /**
     * Sets the speed value.
     * 
     * @param value
     *            the new speed value
     */
    public final void setSpeed(final Integer value) {
        speed = checkNotNull(value, "Received a null pointer as speed");
    }

    /**
     * Sets the strength value.
     * 
     * @param value
     *            the new strength value
     */
    public final void setStrength(final Integer value) {
        strength = checkNotNull(value,
                "Received a null pointer as strength");
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("armor", armor)
                .add("movement", movement).add("skill", skill)
                .add("speed", speed).add("strength", strength)
                .toString();
    }

}
