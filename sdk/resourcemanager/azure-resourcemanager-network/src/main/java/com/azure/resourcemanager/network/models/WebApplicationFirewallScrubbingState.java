// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** State of the log scrubbing config. Default value is Enabled. */
public final class WebApplicationFirewallScrubbingState
    extends ExpandableStringEnum<WebApplicationFirewallScrubbingState> {
    /** Static value Disabled for WebApplicationFirewallScrubbingState. */
    public static final WebApplicationFirewallScrubbingState DISABLED = fromString("Disabled");

    /** Static value Enabled for WebApplicationFirewallScrubbingState. */
    public static final WebApplicationFirewallScrubbingState ENABLED = fromString("Enabled");

    /**
     * Creates a new instance of WebApplicationFirewallScrubbingState value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public WebApplicationFirewallScrubbingState() {
    }

    /**
     * Creates or finds a WebApplicationFirewallScrubbingState from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding WebApplicationFirewallScrubbingState.
     */
    @JsonCreator
    public static WebApplicationFirewallScrubbingState fromString(String name) {
        return fromString(name, WebApplicationFirewallScrubbingState.class);
    }

    /**
     * Gets known WebApplicationFirewallScrubbingState values.
     *
     * @return known WebApplicationFirewallScrubbingState values.
     */
    public static Collection<WebApplicationFirewallScrubbingState> values() {
        return values(WebApplicationFirewallScrubbingState.class);
    }
}
