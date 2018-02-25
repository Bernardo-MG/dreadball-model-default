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

package com.bernardomg.tabletop.dreadball.model.player;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;

import com.bernardomg.tabletop.dreadball.model.player.Role;
import com.bernardomg.tabletop.dreadball.model.player.TeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.stats.Ability;
import com.bernardomg.tabletop.dreadball.model.player.stats.Attributes;
import com.google.common.base.MoreObjects;

/**
 * Root for the basic features all the Dreadball players have, no matter if they
 * come from Dreadball Original (DBO) or Dreadball Xtreme (DBX).
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class DefaultTeamPlayer implements TeamPlayer, Serializable {

    /**
     * Serialization id.
     */
    private static final long         serialVersionUID = 2114193062568651459L;

    /**
     * Base cost of the player.
     */
    private final Integer             baseCost;

    /**
     * Indicates if the player is a giant.
     */
    private final Boolean             giantFlag;

    /**
     * Indicates if the player is a MVP.
     */
    private final Boolean             mvpFlag;

    /**
     * Name of the template from which this player has been created.
     */
    private final String              templateName;

    /**
     * The player's team position.
     */
    private final Role                templateRole;

    /**
     * The player's abilities.
     */
    private final Collection<Ability> playerAbilities  = new LinkedHashSet<>();

    /**
     * Unit's attributes.
     */
    private final Attributes          playerAttributes;

    /**
     * Unit's name.
     */
    private String                    playerName       = "";

    /**
     * Constructs a player with the specified arguments.
     * 
     * @param nameTemplate
     *            the player's base template name
     * @param cost
     *            cost of the player
     * @param role
     *            team position role of the player
     * @param attributes
     *            player attributes
     * @param abilities
     *            player abilities
     * @param mvp
     *            flag indicating if this is a MVP
     * @param giant
     *            flag indicating if this is a giant
     */
    public DefaultTeamPlayer(final String nameTemplate, final Integer cost,
            final Role role, final Attributes attributes,
            final Collection<Ability> abilities, final Boolean mvp,
            final Boolean giant) {
        super();

        templateName = checkNotNull(nameTemplate,
                "Received a null pointer as the template name");
        playerAttributes = checkNotNull(attributes,
                "Received a null pointer as attributes");
        templateRole = checkNotNull(role,
                "Received a null pointer as position");
        giantFlag = checkNotNull(giant,
                "Received a null pointer as giant flag");
        mvpFlag = checkNotNull(mvp, "Received a null pointer as MVP flag");
        baseCost = checkNotNull(cost, "Received a null pointer as cost");

        checkNotNull(abilities, "Received a null pointer as abilities");

        for (final Ability ability : abilities) {
            playerAbilities.add(checkNotNull(ability,
                    "Received a null pointer as ability"));
        }
    }

    /**
     * Constructs a player with the specified arguments.
     * 
     * @param name
     *            the player's name
     * @param nameTemplate
     *            the player's base template name
     * @param cost
     *            cost of the player
     * @param role
     *            team position role of the player
     * @param attributes
     *            player attributes
     * @param abilities
     *            player abilities
     * @param mvp
     *            flag indicating if this is a MVP
     * @param giant
     *            flag indicating if this is a giant
     */
    public DefaultTeamPlayer(final String name, final String nameTemplate,
            final Integer cost, final Role role, final Attributes attributes,
            final Collection<Ability> abilities, final Boolean mvp,
            final Boolean giant) {
        super();

        playerName = checkNotNull(name,
                "Received a null pointer as the template name");
        templateName = checkNotNull(nameTemplate,
                "Received a null pointer as the template name");
        playerAttributes = checkNotNull(attributes,
                "Received a null pointer as attributes");
        templateRole = checkNotNull(role,
                "Received a null pointer as position");
        giantFlag = checkNotNull(giant,
                "Received a null pointer as giant flag");
        mvpFlag = checkNotNull(mvp, "Received a null pointer as MVP flag");
        baseCost = checkNotNull(cost, "Received a null pointer as cost");

        checkNotNull(abilities, "Received a null pointer as abilities");

        for (final Ability ability : abilities) {
            playerAbilities.add(checkNotNull(ability,
                    "Received a null pointer as ability"));
        }
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

        final DefaultTeamPlayer other;

        other = (DefaultTeamPlayer) obj;
        return Objects.equals(playerName, other.playerName);
    }

    @Override
    public final Collection<Ability> getAbilities() {
        return Collections.unmodifiableCollection(getAbilitiesModifiable());
    }

    @Override
    public final Attributes getAttributes() {
        return playerAttributes;
    }

    @Override
    public final Integer getCost() {
        return baseCost;
    }

    @Override
    public final Boolean getGiant() {
        return giantFlag;
    }

    @Override
    public final Boolean getMvp() {
        return mvpFlag;
    }

    @Override
    public final String getName() {
        return playerName;
    }

    @Override
    public final Role getRole() {
        return templateRole;
    }

    @Override
    public final String getTemplateName() {
        return templateName;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(playerName);
    }

    /**
     * Sets the player name.
     * 
     * @param name
     *            the player name
     */
    public final void setName(final String name) {
        playerName = name;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", getTemplateName())
                .add("role", getRole()).add("mvp", getMvp())
                .add("giant", getGiant()).toString();
    }

    /**
     * Returns the modifiable collection of the player's abilities.
     * 
     * @return the modifiable collection of the player's abilities
     */
    private final Collection<Ability> getAbilitiesModifiable() {
        return playerAbilities;
    }

}
