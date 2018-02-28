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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

import com.bernardomg.tabletop.dreadball.model.player.component.Component;
import com.bernardomg.tabletop.dreadball.model.player.component.ImmutableComponent;
import com.bernardomg.tabletop.dreadball.model.player.component.ImmutableComponentLocation;
import com.bernardomg.tabletop.dreadball.model.player.stats.Ability;
import com.bernardomg.tabletop.dreadball.model.player.stats.Attributes;
import com.bernardomg.tabletop.dreadball.model.player.stats.ImmutableAttributes;
import com.google.common.base.MoreObjects;

/**
 * TeamPlayer which may change and evolve over time, usually between matches.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class DefaultAdvancementTeamPlayer
        implements AdvancementTeamPlayer, Serializable {

    /**
     * Serialization id.
     */
    private static final long                                           serialVersionUID = -9100853601667992893L;

    /**
     * TeamPlayer's attributes.
     */
    private Attributes                                                  attributes;

    /**
     * {@code TeamPlayer} used for inheritance through composition.
     */
    private final TeamPlayer                                            baseTeamPlayer;

    /**
     * Implant grafted to the player. This is a {@code TeamPlayer}, the same
     * objects used for composite players.
     * <p>
     * Be default it will be a stub component.
     */
    private Component                                                   graftedImplant   = new ImmutableComponent(
            "none", new ImmutableComponentLocation("none"), 0,
            new ArrayList<Role>(), new ImmutableAttributes(0, 0, 0, 0, 0),
            new ArrayList<Ability>());

    /**
     * Name given to the player.
     */
    private String                                                      name             = "";

    /**
     * The player's abilities.
     */
    private final Collection<Ability>                                   playerAbilities  = new HashSet<>();

    /**
     * The player's current rank.
     */
    private Integer                                                     rank;

    /**
     * The unspent experience.
     */
    private Integer                                                     unspentExperience;

    /**
     * Object used for calculating the player valoration.
     */
    private final TeamPlayerValorationCalculator<AdvancementTeamPlayer> valorationBuilder;

    /**
     * Constructs an advancement player with the specified arguments.
     * 
     * @param nameTemplate
     *            the player's base template name
     * @param cost
     *            cost of the player
     * @param role
     *            team position role of the player
     * @param attrs
     *            player attributes
     * @param abilities
     *            player abilities
     * @param mvp
     *            flag indicating if this is a MVP
     * @param giant
     *            flag indicating if this is a giant
     * @param valorator
     *            calculator for the valoration
     */
    public DefaultAdvancementTeamPlayer(final String nameTemplate,
            final Integer cost, final Role role, final Attributes attrs,
            final Collection<Ability> abilities, final Boolean mvp,
            final Boolean giant,
            final TeamPlayerValorationCalculator<AdvancementTeamPlayer> valorator) {
        super();

        baseTeamPlayer = new DefaultTeamPlayer(nameTemplate, cost, role, attrs,
                abilities, mvp, giant);

        playerAbilities.addAll(baseTeamPlayer.getAbilities());

        valorationBuilder = checkNotNull(valorator,
                "Received a null pointer as valoration builder");
        attributes = checkNotNull(attrs,
                "Received a null pointer as attributes");
    }

    @Override
    public final void addAbility(final Ability ability) {
        getAbilitiesModifiable().add(ability);
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

        final DefaultAdvancementTeamPlayer other;

        other = (DefaultAdvancementTeamPlayer) obj;
        return Objects.equals(baseTeamPlayer, other.baseTeamPlayer)
                && Objects.equals(name, other.name);
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
        return getBaseTeamPlayer().getCost();
    }

    @Override
    public final Boolean getGiant() {
        return getBaseTeamPlayer().getGiant();
    }

    @Override
    public final Component getGraftedImplant() {
        return graftedImplant;
    }

    @Override
    public final Boolean getMvp() {
        return getBaseTeamPlayer().getMvp();
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final Integer getRank() {
        return rank;
    }

    @Override
    public final Role getRole() {
        return getBaseTeamPlayer().getRole();
    }

    @Override
    public final String getTemplateName() {
        return getBaseTeamPlayer().getTemplateName();
    }

    @Override
    public final Integer getUnspentExperience() {
        return unspentExperience;
    }

    @Override
    public final Integer getValoration() {
        return getValorationCalculator().getValoration(this);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(baseTeamPlayer, name);
    }

    @Override
    public final void removeAbility(final Ability ability) {
        getAbilitiesModifiable().remove(ability);
    }

    @Override
    public final void setAbilities(final Collection<Ability> abilities) {
        checkNotNull(abilities, "Received a null pointer as abilities");

        getAbilitiesModifiable().clear();
        getAbilitiesModifiable().addAll(abilities);
    }

    @Override
    public final void setAttributes(final Attributes attrs) {
        attributes = checkNotNull(attrs,
                "Received a null pointer as attributes");
    }

    @Override
    public final void setGraftedImplant(final Component implant) {
        graftedImplant = checkNotNull(implant,
                "Received a null pointer as implant");
    }

    @Override
    public final void setName(final String playerName) {
        name = checkNotNull(playerName, "Received a null pointer as name");
    }

    @Override
    public final void setRank(final Integer rankValue) {
        rank = checkNotNull(rankValue, "Received a null pointer as rank");
    }

    @Override
    public final void setUnspentExperience(final Integer exp) {
        unspentExperience = checkNotNull(exp,
                "Received a null pointer as experience");
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("rank", rank)
                .add("experience", unspentExperience).add("role", getRole())
                .add("mvp", getMvp()).add("giant", getGiant()).toString();
    }

    /**
     * Returns the modifiable list of the player's abilities.
     * 
     * @return the modifiable list of the player's abilities
     */
    private final Collection<Ability> getAbilitiesModifiable() {
        return playerAbilities;
    }

    /**
     * Returns the base player class being used for inheritance through
     * composition.
     * 
     * @return the base player class being used for inheritance through
     *         composition
     */
    private final TeamPlayer getBaseTeamPlayer() {
        return baseTeamPlayer;
    }

    /**
     * Returns the valoration calculator.
     * 
     * @return the valoration calculator
     */
    private final TeamPlayerValorationCalculator<AdvancementTeamPlayer>
            getValorationCalculator() {
        return valorationBuilder;
    }

}
