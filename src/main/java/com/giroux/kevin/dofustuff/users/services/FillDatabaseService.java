package com.giroux.kevin.dofustuff.object.services;

import com.giroux.kevin.dofustuff.commons.item.Effect;
import com.giroux.kevin.dofustuff.commons.item.Property;
import com.google.gson.JsonElement;

import java.util.List;

public interface FillDatabaseService {
    /**
     * Get data, parse them, and store them in a database
     */
    void getParseAndStoreData();

    /**
     * Extract property of the object
     * @param jsonElement element that is needed for extraction
     * @return property after extract
     */
    Property extractProperties(JsonElement jsonElement);

    /**
     * Extract effect of the object
     * @param jsonElement element that is needed for extraction
     * @return list of the effect after extract
     */
    List<Effect> extractEffect(JsonElement jsonElement);
}
