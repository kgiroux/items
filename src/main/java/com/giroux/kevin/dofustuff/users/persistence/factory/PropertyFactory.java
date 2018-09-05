package com.giroux.kevin.dofustuff.object.persistence.factory;

import com.giroux.kevin.dofustuff.commons.item.Property;
import com.giroux.kevin.dofustuff.commons.utils.Factory;
import com.giroux.kevin.dofustuff.object.persistence.entity.PropertyEntity;
import org.springframework.stereotype.Service;

@Service
public class PropertyFactory implements Factory<PropertyEntity,Property> {

    @Override
    public Property entityToDto(PropertyEntity entity) {
        if(entity != null){
            Property property = new Property();
            property.setPaCost(entity.getPaCost());
            property.setCcBonus(entity.getCcBonus());
            property.setCcHits(entity.getCcHits());
            property.setCcRate(entity.getCcRate());
            property.setHitsCount(entity.getHitsCount());
            property.setPoRange(entity.getPoRange());
            property.setId(entity.getId());

            return property;
        }
        return null;

    }

    @Override
    public PropertyEntity dtoToEntity(Property dto) {
        if(dto != null){
            PropertyEntity property = new PropertyEntity();
            property.setPaCost(dto.getPaCost());
            property.setCcBonus(dto.getCcBonus());
            property.setCcHits(dto.getCcHits());
            property.setCcRate(dto.getCcRate());
            property.setHitsCount(dto.getHitsCount());
            property.setPoRange(dto.getPoRange());
            property.setId(dto.getId());

            return property;
        }
        return null;

    }
}
