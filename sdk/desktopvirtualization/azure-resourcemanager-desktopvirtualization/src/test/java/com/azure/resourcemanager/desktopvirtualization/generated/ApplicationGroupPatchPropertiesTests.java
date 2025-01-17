// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.desktopvirtualization.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.desktopvirtualization.fluent.models.ApplicationGroupPatchProperties;
import org.junit.jupiter.api.Assertions;

public final class ApplicationGroupPatchPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ApplicationGroupPatchProperties model =
            BinaryData
                .fromString("{\"description\":\"hvgyuguosvmk\",\"friendlyName\":\"sxqu\"}")
                .toObject(ApplicationGroupPatchProperties.class);
        Assertions.assertEquals("hvgyuguosvmk", model.description());
        Assertions.assertEquals("sxqu", model.friendlyName());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ApplicationGroupPatchProperties model =
            new ApplicationGroupPatchProperties().withDescription("hvgyuguosvmk").withFriendlyName("sxqu");
        model = BinaryData.fromObject(model).toObject(ApplicationGroupPatchProperties.class);
        Assertions.assertEquals("hvgyuguosvmk", model.description());
        Assertions.assertEquals("sxqu", model.friendlyName());
    }
}
