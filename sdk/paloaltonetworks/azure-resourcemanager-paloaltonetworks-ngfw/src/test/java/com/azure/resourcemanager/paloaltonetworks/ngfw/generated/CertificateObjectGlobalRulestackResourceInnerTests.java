// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.paloaltonetworks.ngfw.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.paloaltonetworks.ngfw.fluent.models.CertificateObjectGlobalRulestackResourceInner;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.BooleanEnum;
import org.junit.jupiter.api.Assertions;

public final class CertificateObjectGlobalRulestackResourceInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        CertificateObjectGlobalRulestackResourceInner model =
            BinaryData
                .fromString(
                    "{\"properties\":{\"certificateSignerResourceId\":\"hm\",\"certificateSelfSigned\":\"TRUE\",\"auditComment\":\"a\",\"description\":\"uhrzayvvt\",\"etag\":\"vdfgiotk\",\"provisioningState\":\"Canceled\"},\"id\":\"qxlngx\",\"name\":\"efgugnxk\",\"type\":\"xdqmidtthzrvqdra\"}")
                .toObject(CertificateObjectGlobalRulestackResourceInner.class);
        Assertions.assertEquals("hm", model.certificateSignerResourceId());
        Assertions.assertEquals(BooleanEnum.TRUE, model.certificateSelfSigned());
        Assertions.assertEquals("a", model.auditComment());
        Assertions.assertEquals("uhrzayvvt", model.description());
        Assertions.assertEquals("vdfgiotk", model.etag());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        CertificateObjectGlobalRulestackResourceInner model =
            new CertificateObjectGlobalRulestackResourceInner()
                .withCertificateSignerResourceId("hm")
                .withCertificateSelfSigned(BooleanEnum.TRUE)
                .withAuditComment("a")
                .withDescription("uhrzayvvt")
                .withEtag("vdfgiotk");
        model = BinaryData.fromObject(model).toObject(CertificateObjectGlobalRulestackResourceInner.class);
        Assertions.assertEquals("hm", model.certificateSignerResourceId());
        Assertions.assertEquals(BooleanEnum.TRUE, model.certificateSelfSigned());
        Assertions.assertEquals("a", model.auditComment());
        Assertions.assertEquals("uhrzayvvt", model.description());
        Assertions.assertEquals("vdfgiotk", model.etag());
    }
}
