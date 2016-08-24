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

package com.wandrell.tabletop.dreadball.model.team.calculator;

import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;

/**
 * Calculates the rank cost of a {@link SponsorTeam}.
 * <p>
 * It is a version of the strategy pattern, allowing to create different ways to
 * calculate a team's rank cost.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface RankCostCalculator {

    /**
     * Returns a {@code SponsorTeam}'s rank cost.
     * 
     * @param team
     *            the {@code SponsorTeam} of which the rank cost will be
     *            calculated
     * @return the rank cost of the {@code SponsorTeam}
     */
    public Integer getRankCost(final SponsorTeam team);

}
