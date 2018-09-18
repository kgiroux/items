package com.giroux.kevin.dofustuff.users.persistence.factory;

import com.giroux.kevin.dofustuff.commons.item.ForgeMagie;
import com.giroux.kevin.dofustuff.commons.utils.Factory;
import com.giroux.kevin.dofustuff.users.persistence.entity.ForgeMagieEntity;
import org.springframework.stereotype.Component;

@Component
public class ForgeMagieFactory implements Factory<ForgeMagieEntity,ForgeMagie> {
    @Override
    public ForgeMagie entityToDto(ForgeMagieEntity entity) {

        if(entity != null){
            ForgeMagie forgeMagie = new ForgeMagie();
            forgeMagie.setMax(entity.getMax());
            forgeMagie.setMin(entity.getMin());
            forgeMagie.setElt(entity.getElt());
            forgeMagie.setId(entity.getId());
            forgeMagie.setValue(entity.getValue());
            return forgeMagie;
        }
        return null;

    }

    @Override
    public ForgeMagieEntity dtoToEntity(ForgeMagie dto) {
        if(dto != null){
            ForgeMagieEntity forgeMagie = new ForgeMagieEntity();

            forgeMagie.setMax(dto.getMax());
            forgeMagie.setMin(dto.getMin());
            forgeMagie.setElt(dto.getElt());
            forgeMagie.setId(dto.getId());
            forgeMagie.setValue(dto.getValue());
            return forgeMagie;
        }
        return null;
    }
}
