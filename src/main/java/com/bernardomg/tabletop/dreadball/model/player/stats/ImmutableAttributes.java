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
    private final Integer     armor;

    /**
     * Movement value.
     */
    private final Integer     movement;

    /**
     * Skill value.
     */
    private final Integer     skill;

    /**
     * Speed value.
     */
    private final Integer     speed;

    /**
     * Strength value.
     */
    private final Integer     strength;

    /**
     * Constructs attributes with the specified values.
     * 
     * @param arm
     *            armor value
     * @param move
     *            movement value
     * @param skl
     *            skill value
     * @param spd
     *            speed value
     * @param str
     *            strength value
     */
    public ImmutableAttributes(final Integer arm, final Integer move,
            final Integer skl, final Integer spd, final Integer str) {
        super();

        armor = checkNotNull(arm, "Received a null pointer as armor");
        movement = checkNotNull(move, "Received a null pointer as movement");
        skill = checkNotNull(skl, "Received a null pointer as skill");
        speed = checkNotNull(spd, "Received a null pointer as speed");
        strength = checkNotNull(str, "Received a null pointer as strength");
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
        return Objects.hash(armor, movement, skill, speed, strength);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("armor", armor)
                .add("movement", movement).add("skill", skill)
                .add("speed", speed).add("strength", strength).toString();
    }

}
