package com.giroux.kevin.dofustuff.object.services.impl;

import com.giroux.kevin.dofustuff.commons.item.*;
import com.giroux.kevin.dofustuff.commons.media.Media;
import com.giroux.kevin.dofustuff.commons.media.TypeMedia;
import com.giroux.kevin.dofustuff.object.network.clients.ItemClient;
import com.giroux.kevin.dofustuff.object.services.FillDatabaseService;
import com.giroux.kevin.dofustuff.object.services.ItemService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class FillDatabaseServiceImpl implements FillDatabaseService {

	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(FillDatabaseServiceImpl.class);

	@Autowired
	private ItemService itemService;

	@Autowired
	private ItemClient itemClient;

	private static final String META="meta";
	private static final String PAGINATION="pagination";
	private static final String LINKS="links";
	private static final String NEXT="next";
	private static final String EXTENSION = "_0.png";
	private static final String PROPERTIES = "properties";
	private static final String EFFECTS = "effects";
	private static final String OTHER = "other";
	private static final String EMOTE = "emote";
	private static final String TITLE = "title";
	private static final String SPELL = "spell";
	private static final String ISEXO = "is_exo";
	private static final String FM = "fm";
	private static final String ELT = "elt";
	private static final String MIN = "min";
	private static final String MAX = "max";



	@Override
	@Scheduled(cron = "0 0 1 1 1/1 ? ")
	public void getParseAndStoreData(){
		String urlStr = "https://www.dofusbook.net/api/items?page=3";
	//	String urlStr = "https://www.dofusbook.net/api/items?context=item&equipment=am-an-bo-br-ca-ce-ch-do-fa-mt-mo-mu-sa-tr&level_min=1&level_max=200&page=1&display=list";
		StringBuilder stringBuilder = new StringBuilder();
	    try 
	    {
			do{
				stringBuilder =new StringBuilder();
				HttpGet httpGet = new HttpGet(urlStr);
				HttpClient client = HttpClientBuilder.create().build();
				HttpResponse response = client.execute(httpGet);
				HttpEntity entity = response.getEntity();
				InputStream stream = entity.getContent();
				int b;
				while ((b = stream.read()) != -1) {
					stringBuilder.append((char) b);
				}
				stream.close();
				JsonParser parser = new JsonParser();
				JsonElement content  = parser.parse(stringBuilder.toString());
				JsonObject data = content.getAsJsonObject();
				LOGGER.info("{}",urlStr);
				JsonArray arrays = data.get("data").getAsJsonArray();
				for (JsonElement jsonElement : arrays) {
					Item item = new Item();
					item.setLevel(jsonElement.getAsJsonObject().get("level").getAsInt());
					item.setName(jsonElement.getAsJsonObject().get("name").getAsString());
					item.setDescription(jsonElement.getAsJsonObject().get("description").getAsString());
					if(!jsonElement.getAsJsonObject().has("cloth"))
						item.setCloth(jsonElement.getAsJsonObject().get("cloth").getAsString());
					item.setCategory(ItemCategory.findByCategory(jsonElement.getAsJsonObject().get("category").getAsString()));
					item.setImageId(jsonElement.getAsJsonObject().get("picture").getAsInt());

					Property property = this.extractProperties(jsonElement);
					List<Effect> effectList = this.extractEffect(jsonElement);
					item.setProperty(property);
					item.setEffects(effectList);

					LOGGER.info("Item name {}", item.getName());
					itemService.saveItem(item);
					getPicturesFromUrl(item);
					Media media = new Media();
					media.setFileName( item.getImageId() + EXTENSION);
					media.setId(String.valueOf(item.getImageId()));
					media.setName(item.getName());
					media.setPath("/Users/girouxkevin/downloadImage/" + item.getImageId() + EXTENSION);
					media.setTypeMedia(TypeMedia.PICTURE);
					itemClient.saveImageMetadata(media);

				}
				if(data.has(META)
						&& data.get(META).getAsJsonObject().has(PAGINATION)
						&& data.get(META).getAsJsonObject().get(PAGINATION).getAsJsonObject().has(LINKS)
						&& data.get(META).getAsJsonObject().get(PAGINATION).getAsJsonObject().get(LINKS).getAsJsonObject().has(NEXT)
				) {
					urlStr = data.get(META).getAsJsonObject().get(PAGINATION).getAsJsonObject().get(LINKS).getAsJsonObject().get(NEXT).getAsString();
				}else {
					urlStr = null;
				}
			}while(urlStr != null);
		       	
	    } catch (IOException e) {
			LOGGER.error("{}",e);
			LOGGER.error("{}",stringBuilder.toString());
		}
	}

	private void getPicturesFromUrl(Item item) throws IOException {
		HttpGet httpGet;
		HttpClient client;
		HttpResponse response;
		HttpEntity entity;
		InputStream stream;
		httpGet = new HttpGet("https://dofusbook.net/assets/img/items/" + item.getImageId() + EXTENSION);
		client = HttpClientBuilder.create().build();
		response = client.execute(httpGet);
		entity = response.getEntity();
		stream = entity.getContent();
		try (OutputStream out = new BufferedOutputStream(new FileOutputStream("/Users/girouxkevin/downloadImage/" + item.getImageId() + EXTENSION))) {
            for (int bit; (bit = stream.read()) != -1; ) {
                out.write(bit);
            }
            out.close();
        }
		stream.close();
	}

	@Override
	public Property extractProperties(JsonElement jsonElement) {

		Property properties = new Property();
		if(null != jsonElement.getAsJsonObject().getAsJsonObject(PROPERTIES) ){
			properties.setPaCost(jsonElement.getAsJsonObject().getAsJsonObject(PROPERTIES).get("pa_cost").getAsInt());
			properties.setPoRange(jsonElement.getAsJsonObject().getAsJsonObject(PROPERTIES).get("po_range").getAsString());
			properties.setCcBonus(jsonElement.getAsJsonObject().getAsJsonObject(PROPERTIES).get("cc_bonus").getAsInt());
			properties.setCcRate(jsonElement.getAsJsonObject().getAsJsonObject(PROPERTIES).get("cc_rate").getAsInt());
			properties.setCcHits(jsonElement.getAsJsonObject().getAsJsonObject(PROPERTIES).get("cc_hits").getAsInt());
			properties.setHitsCount(jsonElement.getAsJsonObject().getAsJsonObject(PROPERTIES).get("hits_count").getAsInt());
		}


		return properties;
	}

	@Override
	public List<Effect> extractEffect(JsonElement jsonElement) {
		List<Effect> effects = new ArrayList<>();
		if(null != jsonElement.getAsJsonObject().getAsJsonArray(EFFECTS) ){

			for(JsonElement effectElement : jsonElement.getAsJsonObject().getAsJsonArray(EFFECTS)){
				Effect effect = new Effect();
				effect.setId(effectElement.getAsJsonObject().get("id").getAsInt());
				effect.setMin(effectElement.getAsJsonObject().get(MIN).getAsInt());
				effect.setMax(effectElement.getAsJsonObject().get(MAX).getAsInt());
				if(effectElement.getAsJsonObject().has(FM) && !effectElement.getAsJsonObject().get(FM).isJsonNull()){

					effect.setFm(this.extractForgemagie(effectElement));
				}
				effect.setName(effectElement.getAsJsonObject().get("name").getAsString());
				effect.setType(effectElement.getAsJsonObject().get("type").getAsString());
				if(effectElement.getAsJsonObject().has(OTHER) && !effectElement.getAsJsonObject().get(OTHER).isJsonNull()){
					effect.setOther(effectElement.getAsJsonObject().get(OTHER).getAsString());
				}
				if(effectElement.getAsJsonObject().has(EMOTE) && !effectElement.getAsJsonObject().get(EMOTE).isJsonNull()) {
					effect.setEmotes(effectElement.getAsJsonObject().get(EMOTE).getAsString());
				}
				if(effectElement.getAsJsonObject().has(TITLE) && !effectElement.getAsJsonObject().get(TITLE).isJsonNull()) {
					effect.setTitle(effectElement.getAsJsonObject().get(TITLE).getAsString());
				}
				if(effectElement.getAsJsonObject().has(SPELL) && !effectElement.getAsJsonObject().get(SPELL).isJsonNull()) {
					effect.setSpell(effectElement.getAsJsonObject().get(SPELL).getAsString());
				}
				if(effectElement.getAsJsonObject().has(ISEXO) && !effectElement.getAsJsonObject().get(ISEXO).isJsonNull()) {
					effect.setExo(effectElement.getAsJsonObject().get(ISEXO).getAsBoolean());
				}
				effects.add(effect);
			}
		}

		return effects;
	}

	private ForgeMagie extractForgemagie(JsonElement jsonElement){
		ForgeMagie forgeMagie = new ForgeMagie();
		if(jsonElement.getAsJsonObject().has(FM)  && !jsonElement.getAsJsonObject().get(FM).isJsonNull()){
			if(jsonElement.getAsJsonObject().get(FM).isJsonObject()){
				if(jsonElement.getAsJsonObject().get(FM).getAsJsonObject().has(ELT)  && !jsonElement.getAsJsonObject().get(FM).getAsJsonObject().get(ELT).isJsonNull()){
					forgeMagie.setElt(jsonElement.getAsJsonObject().get(FM).getAsJsonObject().get(ELT).getAsString());
				}
				forgeMagie.setMax(jsonElement.getAsJsonObject().get(FM).getAsJsonObject().get(MAX).getAsInt());
				forgeMagie.setMin(jsonElement.getAsJsonObject().get(FM).getAsJsonObject().get(MIN).getAsInt());
			}else{
				forgeMagie.setValue(jsonElement.getAsJsonObject().get(FM).getAsInt());
			}
		}

		return forgeMagie;
	}
}
