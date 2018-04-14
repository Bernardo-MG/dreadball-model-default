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
import java.util.HashSet;
import java.util.Objects;

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
     * TeamPlayer's attributes.
     */
    private final Attributes          attributes;

    /**
     * Base cost of the player.
     */
    private final Integer             cost;

    /**
     * Indicates if the player is a giant.
     */
    private final Boolean             giant;

    /**
     * Indicates if the player is a MVP.
     */
    private final Boolean             mvp;

    /**
     * TeamPlayer's name.
     */
    private String                    name             = "";

    /**
     * The player's abilities.
     */
    private final Collection<Ability> playerAbilities  = new HashSet<>();

    /**
     * The player's team position.
     */
    private final Role                role;

    /**
     * Name of the template from which this player has been created.
     */
    private final String              templateName;

    /**
     * Constructs a player with the specified arguments.
     * 
     * @param nameTemplate
     *            the player's base template name
     * @param playerCost
     *            cost of the player
     * @param playerRole
     *            team position role of the player
     * @param attrs
     *            player attributes
     * @param abilities
     *            player abilities
     * @param mvpFlag
     *            flag indicating if this is a MVP
     * @param giantFlag
     *            flag indicating if this is a giant
     */
    public DefaultTeamPlayer(final String nameTemplate,
            final Integer playerCost, final Role playerRole,
            final Attributes attrs, final Collection<Ability> abilities,
            final Boolean mvpFlag, final Boolean giantFlag) {
        super();

        templateName = checkNotNull(nameTemplate,
                "Received a null pointer as the template name");
        attributes = checkNotNull(attrs,
                "Received a null pointer as attributes");
        role = checkNotNull(playerRole, "Received a null pointer as position");
        giant = checkNotNull(giantFlag,
                "Received a null pointer as giant flag");
        mvp = checkNotNull(mvpFlag, "Received a null pointer as MVP flag");
        cost = checkNotNull(playerCost, "Received a null pointer as cost");

        checkNotNull(abilities, "Received a null pointer as abilities");

        for (final Ability ability : abilities) {
            playerAbilities.add(checkNotNull(ability,
                    "Received a null pointer as ability"));
        }
    }

    /**
     * Constructs a player with the specified arguments.
     * 
     * @param playerName
     *            the player's name
     * @param nameTemplate
     *            the player's base template name
     * @param playerCost
     *            cost of the player
     * @param playerRole
     *            team position role of the player
     * @param attrs
     *            player attributes
     * @param abilities
     *            player abilities
     * @param mvpFlag
     *            flag indicating if this is a MVP
     * @param giantFlag
     *            flag indicating if this is a giant
     */
    public DefaultTeamPlayer(final String playerName, final String nameTemplate,
            final Integer playerCost, final Role playerRole,
            final Attributes attrs, final Collection<Ability> abilities,
            final Boolean mvpFlag, final Boolean giantFlag) {
        super();

        name = checkNotNull(playerName,
                "Received a null pointer as the template name");
        templateName = checkNotNull(nameTemplate,
                "Received a null pointer as the template name");
        attributes = checkNotNull(attrs,
                "Received a null pointer as attributes");
        role = checkNotNull(playerRole, "Received a null pointer as position");
        giant = checkNotNull(giantFlag,
                "Received a null pointer as giant flag");
        mvp = checkNotNull(mvpFlag, "Received a null pointer as MVP flag");
        cost = checkNotNull(playerCost, "Received a null pointer as cost");

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
        return Objects.equals(name, other.name);
    }

    @Override
    public final Collection<Ability> getAbilities() {
        return Collections.unmodifiableCollection(getAbilitiesModifiable());
    }

    @Override
    public final Attributes getAttributes() {
        return attributes;
    }

    @Override
    public final Integer getCost() {
        return cost;
    }

    @Override
    public final Boolean getGiant() {
        return giant;
    }

    @Override
    public final Boolean getMvp() {
        return mvp;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final Role getRole() {
        return role;
    }

    @Override
    public final String getTemplateName() {
        return templateName;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(name);
    }

    /**
     * Sets the player name.
     * 
     * @param playerName
     *            the player name
     */
    public final void setName(final String playerName) {
        name = checkNotNull(playerName,
                "Received a null pointer as the template name");
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
