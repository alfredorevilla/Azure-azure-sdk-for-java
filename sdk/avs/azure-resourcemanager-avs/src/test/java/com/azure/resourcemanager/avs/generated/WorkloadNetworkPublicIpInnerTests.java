// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.avs.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.avs.fluent.models.WorkloadNetworkPublicIpInner;
import org.junit.jupiter.api.Assertions;

public final class WorkloadNetworkPublicIpInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        WorkloadNetworkPublicIpInner model =
            BinaryData
                .fromString(
                    "{\"properties\":{\"displayName\":\"mfmtdaaygdvw\",\"numberOfPublicIPs\":2693420757845693746,\"publicIPBlock\":\"hgwxrtfudx\",\"provisioningState\":\"Canceled\"},\"id\":\"gyqagvrvmnpkuk\",\"name\":\"himdbl\",\"type\":\"gwimfn\"}")
                .toObject(WorkloadNetworkPublicIpInner.class);
        Assertions.assertEquals("mfmtdaaygdvw", model.displayName());
        Assertions.assertEquals(2693420757845693746L, model.numberOfPublicIPs());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        WorkloadNetworkPublicIpInner model =
            new WorkloadNetworkPublicIpInner()
                .withDisplayName("mfmtdaaygdvw")
                .withNumberOfPublicIPs(2693420757845693746L);
        model = BinaryData.fromObject(model).toObject(WorkloadNetworkPublicIpInner.class);
        Assertions.assertEquals("mfmtdaaygdvw", model.displayName());
        Assertions.assertEquals(2693420757845693746L, model.numberOfPublicIPs());
    }
}
