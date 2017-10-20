package com.giroux.kevin.dofustuff.object.network;

import com.giroux.kevin.dofustuff.commons.item.Item;
import com.giroux.kevin.dofustuff.object.network.exception.NotFoundException;
import com.giroux.kevin.dofustuff.object.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemWS {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping(name="Retrieve Item with Level",  method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE }, value = "/level/{level}")
	public List<Item> retrieveListObjectByLevel(@PathVariable("level") final Integer level){
		List<Item> returnList = itemService.retrieveListObjectByLevel(level);
		if(CollectionUtils.isEmpty(returnList)) {
			throw new NotFoundException();
		}
		return returnList;
	}

	@RequestMapping(name="Retrieve Item with Level and type",  method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE }, value = "/level/{level}/type/{type}")
	public List<Item> retrieveListObjectByLevelAndType(@PathVariable("level") final Integer level, @PathVariable("type") final String type ){
		List<Item> returnList = itemService.retrieveListObjectByTypeAndLevel(level,type);
		if(CollectionUtils.isEmpty(returnList)) {
			throw new NotFoundException();
		}
		return returnList;
	}
}
