// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.elasticsan.models;

import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.elasticsan.fluent.models.VolumeGroupInner;
import java.util.Map;

/** An immutable client-side representation of VolumeGroup. */
public interface VolumeGroup {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     *
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     *
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     *
     * @return the type value.
     */
    String type();

    /**
     * Gets the systemData property: Resource metadata required by ARM RPC.
     *
     * @return the systemData value.
     */
    SystemData systemData();

    /**
     * Gets the tags property: Azure resource tags.
     *
     * @return the tags value.
     */
    Map<String, String> tags();

    /**
     * Gets the provisioningState property: State of the operation on the resource.
     *
     * @return the provisioningState value.
     */
    ProvisioningStates provisioningState();

    /**
     * Gets the protocolType property: Type of storage target.
     *
     * @return the protocolType value.
     */
    StorageTargetType protocolType();

    /**
     * Gets the encryption property: Type of encryption.
     *
     * @return the encryption value.
     */
    EncryptionType encryption();

    /**
     * Gets the networkAcls property: A collection of rules governing the accessibility from specific network locations.
     *
     * @return the networkAcls value.
     */
    NetworkRuleSet networkAcls();

    /**
     * Gets the name of the resource group.
     *
     * @return the name of the resource group.
     */
    String resourceGroupName();

    /**
     * Gets the inner com.azure.resourcemanager.elasticsan.fluent.models.VolumeGroupInner object.
     *
     * @return the inner object.
     */
    VolumeGroupInner innerModel();

    /** The entirety of the VolumeGroup definition. */
    interface Definition
        extends DefinitionStages.Blank, DefinitionStages.WithParentResource, DefinitionStages.WithCreate {
    }
    /** The VolumeGroup definition stages. */
    interface DefinitionStages {
        /** The first stage of the VolumeGroup definition. */
        interface Blank extends WithParentResource {
        }
        /** The stage of the VolumeGroup definition allowing to specify parent resource. */
        interface WithParentResource {
            /**
             * Specifies resourceGroupName, elasticSanName.
             *
             * @param resourceGroupName The name of the resource group. The name is case insensitive.
             * @param elasticSanName The name of the ElasticSan.
             * @return the next definition stage.
             */
            WithCreate withExistingElasticSan(String resourceGroupName, String elasticSanName);
        }
        /**
         * The stage of the VolumeGroup definition which contains all the minimum required properties for the resource
         * to be created, but also allows for any other optional properties to be specified.
         */
        interface WithCreate
            extends DefinitionStages.WithTags,
                DefinitionStages.WithProtocolType,
                DefinitionStages.WithEncryption,
                DefinitionStages.WithNetworkAcls {
            /**
             * Executes the create request.
             *
             * @return the created resource.
             */
            VolumeGroup create();

            /**
             * Executes the create request.
             *
             * @param context The context to associate with this operation.
             * @return the created resource.
             */
            VolumeGroup create(Context context);
        }
        /** The stage of the VolumeGroup definition allowing to specify tags. */
        interface WithTags {
            /**
             * Specifies the tags property: Azure resource tags..
             *
             * @param tags Azure resource tags.
             * @return the next definition stage.
             */
            WithCreate withTags(Map<String, String> tags);
        }
        /** The stage of the VolumeGroup definition allowing to specify protocolType. */
        interface WithProtocolType {
            /**
             * Specifies the protocolType property: Type of storage target.
             *
             * @param protocolType Type of storage target.
             * @return the next definition stage.
             */
            WithCreate withProtocolType(StorageTargetType protocolType);
        }
        /** The stage of the VolumeGroup definition allowing to specify encryption. */
        interface WithEncryption {
            /**
             * Specifies the encryption property: Type of encryption.
             *
             * @param encryption Type of encryption.
             * @return the next definition stage.
             */
            WithCreate withEncryption(EncryptionType encryption);
        }
        /** The stage of the VolumeGroup definition allowing to specify networkAcls. */
        interface WithNetworkAcls {
            /**
             * Specifies the networkAcls property: A collection of rules governing the accessibility from specific
             * network locations..
             *
             * @param networkAcls A collection of rules governing the accessibility from specific network locations.
             * @return the next definition stage.
             */
            WithCreate withNetworkAcls(NetworkRuleSet networkAcls);
        }
    }
    /**
     * Begins update for the VolumeGroup resource.
     *
     * @return the stage of resource update.
     */
    VolumeGroup.Update update();

    /** The template for VolumeGroup update. */
    interface Update extends UpdateStages.WithTags, UpdateStages.WithProtocolType, UpdateStages.WithEncryption {
        /**
         * Executes the update request.
         *
         * @return the updated resource.
         */
        VolumeGroup apply();

        /**
         * Executes the update request.
         *
         * @param context The context to associate with this operation.
         * @return the updated resource.
         */
        VolumeGroup apply(Context context);
    }
    /** The VolumeGroup update stages. */
    interface UpdateStages {
        /** The stage of the VolumeGroup update allowing to specify tags. */
        interface WithTags {
            /**
             * Specifies the tags property: Resource tags..
             *
             * @param tags Resource tags.
             * @return the next definition stage.
             */
            Update withTags(Map<String, String> tags);
        }
        /** The stage of the VolumeGroup update allowing to specify protocolType. */
        interface WithProtocolType {
            /**
             * Specifies the protocolType property: Type of storage target.
             *
             * @param protocolType Type of storage target.
             * @return the next definition stage.
             */
            Update withProtocolType(StorageTargetType protocolType);
        }
        /** The stage of the VolumeGroup update allowing to specify encryption. */
        interface WithEncryption {
            /**
             * Specifies the encryption property: Type of encryption.
             *
             * @param encryption Type of encryption.
             * @return the next definition stage.
             */
            Update withEncryption(EncryptionType encryption);
        }
    }
    /**
     * Refreshes the resource to sync with Azure.
     *
     * @return the refreshed resource.
     */
    VolumeGroup refresh();

    /**
     * Refreshes the resource to sync with Azure.
     *
     * @param context The context to associate with this operation.
     * @return the refreshed resource.
     */
    VolumeGroup refresh(Context context);
}
