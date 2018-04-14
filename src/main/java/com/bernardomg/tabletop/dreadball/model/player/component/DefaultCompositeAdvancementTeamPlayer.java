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

package com.bernardomg.tabletop.dreadball.model.player.component;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

import com.bernardomg.tabletop.dreadball.model.player.AdvancementTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.DefaultAdvancementTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.Role;
import com.bernardomg.tabletop.dreadball.model.player.TeamPlayerValorationCalculator;
import com.bernardomg.tabletop.dreadball.model.player.stats.Ability;
import com.bernardomg.tabletop.dreadball.model.player.stats.Attributes;

/**
 * Composite advancement player.
 * <p>
 * It uses composition to inherit from {@link DefaultAdvancementTeamPlayer}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class DefaultCompositeAdvancementTeamPlayer
        implements CompositeAdvancementTeamPlayer, Serializable {

    /**
     * Serialization id.
     */
    private static final long           serialVersionUID = 6492427235549316354L;

    /**
     * {@code AdvancementTeamPlayer} used for inheritance through composition.
     */
    private final AdvancementTeamPlayer baseTeamPlayer;

    /**
     * Components of the player.
     */
    private final Collection<Component> components       = new HashSet<Component>();

    /**
     * Constructs a composite advancement player with the specified arguments.
     * 
     * @param nameTemplate
     *            the player's base template name
     * @param cost
     *            cost of the player
     * @param position
     *            team position role of the player
     * @param attributes
     *            player attributes
     * @param abilities
     *            player abilities
     * @param mvp
     *            flag indicating if this is a MVP
     * @param giant
     *            flag indicating if this is a giant
     * @param valorator
     *            calculator for the valoration
     * @param comps
     *            components which create this player
     */
    public DefaultCompositeAdvancementTeamPlayer(final String nameTemplate,
            final Integer cost, final Role position,
            final Attributes attributes, final Collection<Ability> abilities,
            final Boolean mvp, final Boolean giant,
            final TeamPlayerValorationCalculator<AdvancementTeamPlayer> valorator,
            final Collection<Component> comps) {

        super();

        baseTeamPlayer = new DefaultAdvancementTeamPlayer(nameTemplate, cost,
                position, attributes, abilities, mvp, giant, valorator);

        checkNotNull(comps,
                "Received a null pointer as valoration the components");

        for (final Component component : comps) {
            checkNotNull(component,
                    "Received a null pointer as valoration a component");

            components.add(component);
        }
    }

    @Override
    public final void addAbility(final Ability ability) {
        getBaseTeamPlayer().addAbility(ability);
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

        final DefaultCompositeAdvancementTeamPlayer other;

        other = (DefaultCompositeAdvancementTeamPlayer) obj;
        return Objects.equals(baseTeamPlayer, other.baseTeamPlayer);
    }

    @Override
    public final Collection<Ability> getAbilities() {
        return getBaseTeamPlayer().getAbilities();
    }

    @Override
    public final Attributes getAttributes() {
        return getBaseTeamPlayer().getAttributes();
    }

    /**
     * Returns the components which make up the player.
     * 
     * @return the components which make up the player
     */
    @Override
    public final Collection<Component> getComponents() {
        return Collections.unmodifiableCollection(getComponentsModifiable());
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
        return getBaseTeamPlayer().getGraftedImplant();
    }

    @Override
    public final Boolean getMvp() {
        return getBaseTeamPlayer().getMvp();
    }

    @Override
    public final String getName() {
        return getBaseTeamPlayer().getName();
    }

    @Override
    public final Integer getRank() {
        return getBaseTeamPlayer().getRank();
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
        return getBaseTeamPlayer().getUnspentExperience();
    }

    @Override
    public final Integer getValoration() {
        return getBaseTeamPlayer().getValoration();
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(baseTeamPlayer);
    }

    @Override
    public final void removeAbility(final Ability ability) {
        getBaseTeamPlayer().removeAbility(ability);
    }

    @Override
    public final void setAbilities(final Collection<Ability> abilities) {
        getBaseTeamPlayer().setAbilities(abilities);
    }

    @Override
    public final void setAttributes(final Attributes attributes) {
        getBaseTeamPlayer().setAttributes(attributes);
    }

    @Override
    public final void setGraftedImplant(final Component implant) {
        getBaseTeamPlayer().setGraftedImplant(implant);
    }

    @Override
    public final void setName(final String name) {
        getBaseTeamPlayer().setName(name);
    }

    @Override
    public final void setRank(final Integer rank) {
        getBaseTeamPlayer().setRank(rank);
    }

    @Override
    public final void setUnspentExperience(final Integer experience) {
        getBaseTeamPlayer().setUnspentExperience(experience);
    }

    /**
     * Returns the base player class being used for inheritance through
     * composition.
     * 
     * @return the base player class being used for inheritance through
     *         composition
     */
    private final AdvancementTeamPlayer getBaseTeamPlayer() {
        return baseTeamPlayer;
    }

    /**
     * Returns a modifiable collection with the player components.
     * 
     * @return a modifiable collection with the player components
     */
    private final Collection<Component> getComponentsModifiable() {
        return components;
    }

}
