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

package com.bernardomg.tabletop.dreadball.model.unit;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Objects;

import com.bernardomg.tabletop.dreadball.model.player.stats.AffinityGroup;
import com.google.common.base.MoreObjects;

/**
 * Affinity group.
 * <p>
 * This is an immutable implementation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class DefaultAffinityGroup implements AffinityGroup, Serializable {

    /**
     * Serialization id.
     */
    private static final long serialVersionUID = 9008556689033158827L;

    /**
     * Group's name.
     */
    private final String      groupName;

    /**
     * Constructs an affinity group with the specified arguments.
     * 
     * @param name
     *            the name of the group
     */
    public DefaultAffinityGroup(final String name) {
        super();

        groupName = checkNotNull(name, "Received a null pointer as name");
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

        final DefaultAffinityGroup other;

        other = (DefaultAffinityGroup) obj;
        return Objects.equals(groupName, other.groupName);
    }

    @Override
    public final String getName() {
        return groupName;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(groupName);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", groupName)
                .toString();
    }

}
