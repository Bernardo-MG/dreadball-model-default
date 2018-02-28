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

package com.bernardomg.tabletop.dreadball.model.team.calculator;

/**
 * Calculates the rank cost of an object.
 * <p>
 * It is a version of the strategy pattern, allowing to create different ways to
 * calculate, for example, a team's rank cost or its valoration.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 * 
 * @param <T>
 *            the type of object for calculating costs
 */
public interface CostCalculator<T> {

    /**
     * Returns the cost of the received object.
     * 
     * @param obj
     *            the object of which the cost will be calculated
     * @return the cost of the received object
     */
    public Integer getCost(final T obj);

}
