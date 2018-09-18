package com.giroux.kevin.dofustuff.users.persistence.factory;

import com.giroux.kevin.dofustuff.commons.item.Effect;
import com.giroux.kevin.dofustuff.commons.utils.Factory;
import com.giroux.kevin.dofustuff.users.persistence.entity.EffectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EffectFactory implements Factory<EffectEntity,Effect>{

    @Autowired
    private ForgeMagieFactory forgeMagieFactory;

    @Override
    public Effect entityToDto(EffectEntity entity) {
        if(entity != null){
            Effect effect = new Effect();
            effect.setEmotes(entity.getEmotes());
            effect.setExo(entity.isExo());
            effect.setFm(forgeMagieFactory.entityToDto(entity.getFm()));
            effect.setId(entity.getId());
            effect.setMax(entity.getMax());
            effect.setMin(entity.getMin());
            effect.setName(entity.getName());
            effect.setOther(entity.getOther());
            effect.setSpell(entity.getSpell());
            effect.setTitle(entity.getTitle());
            effect.setType(entity.getType());
            effect.setInternalId(entity.getInternalId());
            return effect;
        }
        return null;

    }

    @Override
    public EffectEntity dtoToEntity(Effect dto) {
        if(dto != null){
            EffectEntity effect = new EffectEntity();
            effect.setEmotes(dto.getEmotes());
            effect.setExo(dto.isExo());
            effect.setFm(forgeMagieFactory.dtoToEntity(dto.getFm()));
            effect.setId(dto.getId());
            effect.setMax(dto.getMax());
            effect.setMin(dto.getMin());
            effect.setName(dto.getName());
            effect.setOther(dto.getOther());
            effect.setSpell(dto.getSpell());
            effect.setTitle(dto.getTitle());
            effect.setType(dto.getType());
            effect.setInternalId(String.valueOf(UUID.randomUUID()));
            return effect;
        }
        return null;

    }
}
