// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.Resource;
import com.azure.core.management.SystemData;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.networkcloud.models.ConsoleDetailedStatus;
import com.azure.resourcemanager.networkcloud.models.ConsoleEnabled;
import com.azure.resourcemanager.networkcloud.models.ConsoleProvisioningState;
import com.azure.resourcemanager.networkcloud.models.ExtendedLocation;
import com.azure.resourcemanager.networkcloud.models.SshPublicKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.Map;

/** Console represents the console of an on-premises Network Cloud virtual machine. */
@Fluent
public final class ConsoleInner extends Resource {
    /*
     * ExtendedLocation represents the Azure custom location where the resource will be created.
     *
     * The extended location of the cluster manager associated with the cluster this virtual machine is created on.
     */
    @JsonProperty(value = "extendedLocation", required = true)
    private ExtendedLocation extendedLocation;

    /*
     * ConsoleProperties represents the properties of the virtual machine console.
     *
     * The list of the resource properties.
     */
    @JsonProperty(value = "properties", required = true)
    private ConsoleProperties innerProperties = new ConsoleProperties();

    /*
     * Azure Resource Manager metadata containing createdBy and modifiedBy information.
     */
    @JsonProperty(value = "systemData", access = JsonProperty.Access.WRITE_ONLY)
    private SystemData systemData;

    /** Creates an instance of ConsoleInner class. */
    public ConsoleInner() {
    }

    /**
     * Get the extendedLocation property: ExtendedLocation represents the Azure custom location where the resource will
     * be created.
     *
     * <p>The extended location of the cluster manager associated with the cluster this virtual machine is created on.
     *
     * @return the extendedLocation value.
     */
    public ExtendedLocation extendedLocation() {
        return this.extendedLocation;
    }

    /**
     * Set the extendedLocation property: ExtendedLocation represents the Azure custom location where the resource will
     * be created.
     *
     * <p>The extended location of the cluster manager associated with the cluster this virtual machine is created on.
     *
     * @param extendedLocation the extendedLocation value to set.
     * @return the ConsoleInner object itself.
     */
    public ConsoleInner withExtendedLocation(ExtendedLocation extendedLocation) {
        this.extendedLocation = extendedLocation;
        return this;
    }

    /**
     * Get the innerProperties property: ConsoleProperties represents the properties of the virtual machine console.
     *
     * <p>The list of the resource properties.
     *
     * @return the innerProperties value.
     */
    private ConsoleProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the systemData property: Azure Resource Manager metadata containing createdBy and modifiedBy information.
     *
     * @return the systemData value.
     */
    public SystemData systemData() {
        return this.systemData;
    }

    /** {@inheritDoc} */
    @Override
    public ConsoleInner withLocation(String location) {
        super.withLocation(location);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public ConsoleInner withTags(Map<String, String> tags) {
        super.withTags(tags);
        return this;
    }

    /**
     * Get the detailedStatus property: The more detailed status of the console.
     *
     * @return the detailedStatus value.
     */
    public ConsoleDetailedStatus detailedStatus() {
        return this.innerProperties() == null ? null : this.innerProperties().detailedStatus();
    }

    /**
     * Get the detailedStatusMessage property: The descriptive message about the current detailed status.
     *
     * @return the detailedStatusMessage value.
     */
    public String detailedStatusMessage() {
        return this.innerProperties() == null ? null : this.innerProperties().detailedStatusMessage();
    }

    /**
     * Get the enabled property: The indicator of whether the console access is enabled.
     *
     * @return the enabled value.
     */
    public ConsoleEnabled enabled() {
        return this.innerProperties() == null ? null : this.innerProperties().enabled();
    }

    /**
     * Set the enabled property: The indicator of whether the console access is enabled.
     *
     * @param enabled the enabled value to set.
     * @return the ConsoleInner object itself.
     */
    public ConsoleInner withEnabled(ConsoleEnabled enabled) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ConsoleProperties();
        }
        this.innerProperties().withEnabled(enabled);
        return this;
    }

    /**
     * Get the expiration property: The date and time after which the key will be disallowed access.
     *
     * @return the expiration value.
     */
    public OffsetDateTime expiration() {
        return this.innerProperties() == null ? null : this.innerProperties().expiration();
    }

    /**
     * Set the expiration property: The date and time after which the key will be disallowed access.
     *
     * @param expiration the expiration value to set.
     * @return the ConsoleInner object itself.
     */
    public ConsoleInner withExpiration(OffsetDateTime expiration) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ConsoleProperties();
        }
        this.innerProperties().withExpiration(expiration);
        return this;
    }

    /**
     * Get the privateLinkServiceId property: The resource ID of the private link service that is used to provide
     * virtual machine console access.
     *
     * @return the privateLinkServiceId value.
     */
    public String privateLinkServiceId() {
        return this.innerProperties() == null ? null : this.innerProperties().privateLinkServiceId();
    }

    /**
     * Get the provisioningState property: The provisioning state of the virtual machine console.
     *
     * @return the provisioningState value.
     */
    public ConsoleProvisioningState provisioningState() {
        return this.innerProperties() == null ? null : this.innerProperties().provisioningState();
    }

    /**
     * Get the sshPublicKey property: SshPublicKey represents the public key used to authenticate with the virtual
     * machine through SSH.
     *
     * <p>The SSH public key that will be provisioned for user access. The user is expected to have the corresponding
     * SSH private key for logging in.
     *
     * @return the sshPublicKey value.
     */
    public SshPublicKey sshPublicKey() {
        return this.innerProperties() == null ? null : this.innerProperties().sshPublicKey();
    }

    /**
     * Set the sshPublicKey property: SshPublicKey represents the public key used to authenticate with the virtual
     * machine through SSH.
     *
     * <p>The SSH public key that will be provisioned for user access. The user is expected to have the corresponding
     * SSH private key for logging in.
     *
     * @param sshPublicKey the sshPublicKey value to set.
     * @return the ConsoleInner object itself.
     */
    public ConsoleInner withSshPublicKey(SshPublicKey sshPublicKey) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ConsoleProperties();
        }
        this.innerProperties().withSshPublicKey(sshPublicKey);
        return this;
    }

    /**
     * Get the virtualMachineAccessId property: The unique identifier for the virtual machine that is used to access the
     * console.
     *
     * @return the virtualMachineAccessId value.
     */
    public String virtualMachineAccessId() {
        return this.innerProperties() == null ? null : this.innerProperties().virtualMachineAccessId();
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (extendedLocation() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException("Missing required property extendedLocation in model ConsoleInner"));
        } else {
            extendedLocation().validate();
        }
        if (innerProperties() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException("Missing required property innerProperties in model ConsoleInner"));
        } else {
            innerProperties().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ConsoleInner.class);
}
