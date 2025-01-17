// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
//
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is regenerated.

package com.azure.search.documents.indexes.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** Removes words that are too long or too short. This token filter is implemented using Apache Lucene. */
@Fluent
public final class LengthTokenFilter extends TokenFilter {
    /*
     * Identifies the concrete type of the token filter.
     */
    private static final String ODATA_TYPE = "#Microsoft.Azure.Search.LengthTokenFilter";

    /*
     * The minimum length in characters. Default is 0. Maximum is 300. Must be less than the value of max.
     */
    private Integer minLength;

    /*
     * The maximum length in characters. Default and maximum is 300.
     */
    private Integer maxLength;

    /**
     * Creates an instance of LengthTokenFilter class.
     *
     * @param name the name value to set.
     */
    public LengthTokenFilter(String name) {
        super(name);
    }

    /**
     * Get the minLength property: The minimum length in characters. Default is 0. Maximum is 300. Must be less than the
     * value of max.
     *
     * @return the minLength value.
     */
    public Integer getMinLength() {
        return this.minLength;
    }

    /**
     * Set the minLength property: The minimum length in characters. Default is 0. Maximum is 300. Must be less than the
     * value of max.
     *
     * @param minLength the minLength value to set.
     * @return the LengthTokenFilter object itself.
     */
    public LengthTokenFilter setMinLength(Integer minLength) {
        this.minLength = minLength;
        return this;
    }

    /**
     * Get the maxLength property: The maximum length in characters. Default and maximum is 300.
     *
     * @return the maxLength value.
     */
    public Integer getMaxLength() {
        return this.maxLength;
    }

    /**
     * Set the maxLength property: The maximum length in characters. Default and maximum is 300.
     *
     * @param maxLength the maxLength value to set.
     * @return the LengthTokenFilter object itself.
     */
    public LengthTokenFilter setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("@odata.type", ODATA_TYPE);
        jsonWriter.writeStringField("name", getName());
        jsonWriter.writeNumberField("min", this.minLength);
        jsonWriter.writeNumberField("max", this.maxLength);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of LengthTokenFilter from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of LengthTokenFilter if the JsonReader was pointing to an instance of it, or null if it was
     *     pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties or the
     *     polymorphic discriminator.
     * @throws IOException If an error occurs while reading the LengthTokenFilter.
     */
    public static LengthTokenFilter fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    boolean nameFound = false;
                    String name = null;
                    Integer minLength = null;
                    Integer maxLength = null;
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("@odata.type".equals(fieldName)) {
                            String odataType = reader.getString();
                            if (!ODATA_TYPE.equals(odataType)) {
                                throw new IllegalStateException(
                                        "'@odata.type' was expected to be non-null and equal to '"
                                                + ODATA_TYPE
                                                + "'. The found '@odata.type' was '"
                                                + odataType
                                                + "'.");
                            }
                        } else if ("name".equals(fieldName)) {
                            name = reader.getString();
                            nameFound = true;
                        } else if ("min".equals(fieldName)) {
                            minLength = reader.getNullable(JsonReader::getInt);
                        } else if ("max".equals(fieldName)) {
                            maxLength = reader.getNullable(JsonReader::getInt);
                        } else {
                            reader.skipChildren();
                        }
                    }
                    if (nameFound) {
                        LengthTokenFilter deserializedLengthTokenFilter = new LengthTokenFilter(name);
                        deserializedLengthTokenFilter.minLength = minLength;
                        deserializedLengthTokenFilter.maxLength = maxLength;

                        return deserializedLengthTokenFilter;
                    }
                    List<String> missingProperties = new ArrayList<>();
                    if (!nameFound) {
                        missingProperties.add("name");
                    }

                    throw new IllegalStateException(
                            "Missing required property/properties: " + String.join(", ", missingProperties));
                });
    }
}
