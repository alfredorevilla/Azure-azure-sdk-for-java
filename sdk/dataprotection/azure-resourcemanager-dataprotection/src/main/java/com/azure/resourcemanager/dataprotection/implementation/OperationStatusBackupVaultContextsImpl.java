// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.dataprotection.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.dataprotection.fluent.OperationStatusBackupVaultContextsClient;
import com.azure.resourcemanager.dataprotection.fluent.models.OperationResourceInner;
import com.azure.resourcemanager.dataprotection.models.OperationResource;
import com.azure.resourcemanager.dataprotection.models.OperationStatusBackupVaultContexts;

public final class OperationStatusBackupVaultContextsImpl implements OperationStatusBackupVaultContexts {
    private static final ClientLogger LOGGER = new ClientLogger(OperationStatusBackupVaultContextsImpl.class);

    private final OperationStatusBackupVaultContextsClient innerClient;

    private final com.azure.resourcemanager.dataprotection.DataProtectionManager serviceManager;

    public OperationStatusBackupVaultContextsImpl(
        OperationStatusBackupVaultContextsClient innerClient,
        com.azure.resourcemanager.dataprotection.DataProtectionManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Response<OperationResource> getWithResponse(
        String resourceGroupName, String vaultName, String operationId, Context context) {
        Response<OperationResourceInner> inner =
            this.serviceClient().getWithResponse(resourceGroupName, vaultName, operationId, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new OperationResourceImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public OperationResource get(String resourceGroupName, String vaultName, String operationId) {
        OperationResourceInner inner = this.serviceClient().get(resourceGroupName, vaultName, operationId);
        if (inner != null) {
            return new OperationResourceImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    private OperationStatusBackupVaultContextsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.dataprotection.DataProtectionManager manager() {
        return this.serviceManager;
    }
}
