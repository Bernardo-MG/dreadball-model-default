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

import com.wandrell.tabletop.dreadball.model.team.Team;

/**
 * Calculates the valoration of a {@link Team}.
 * <p>
 * It is a version of the strategy pattern, allowing to create different ways to
 * calculate a team's valoration.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 * @param <T>
 *            the type of the team of which the valoration will be calculated
 */
public interface TeamValorationCalculator<T extends Team<?>> {

    /**
     * Returns a {@code Team}'s valoration.
     * 
     * @param team
     *            the {@code Team} of which the valoration will be calculated
     * @return the valoration of the {@code Team}
     */
    public Integer getValoration(final T team);

}