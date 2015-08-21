/**
 * Copyright 2015 the original author or authors
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
package com.wandrell.tabletop.dreadball.model.unit.component;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Objects;

import com.google.common.base.MoreObjects;

/**
 * Default serializable implementation of {@code ComponentLocation}.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class DefaultComponentLocation
        implements ComponentLocation, Serializable {

    /**
     * Serialization ID.
     */
    private static final long serialVersionUID = -5876022257243242111L;
    /**
     * Location name.
     */
    private final String      locationName;

    /**
     * Constructs a {@code DefaultComponentLocation}.
     * 
     * @param name
     *            name of the location
     */
    public DefaultComponentLocation(final String name) {
        super();

        locationName = checkNotNull(name, "Received a null pointer as name");
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

        final DefaultComponentLocation other;

        other = (DefaultComponentLocation) obj;
        return Objects.equals(locationName, other.locationName);
    }

    @Override
    public final String getComponentLocationName() {
        return locationName;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(locationName);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", locationName)
                .toString();
    }

}
