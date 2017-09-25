package com.giroux.kevin.dofustuff.object.starter;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

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

import com.giroux.kevin.dofustuff.object.dto.Item;
import com.giroux.kevin.dofustuff.object.dto.ItemCategory;
import com.giroux.kevin.dofustuff.object.services.ItemService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class FillDataBase {

	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(FillDataBase.class);

	@Autowired
	private ItemService itemService;

	private static final String META="meta";
	private static final String PAGINATION="pagination";
	private static final String LINKS="links";
	private static final String NEXT="next";
	
	
	@Scheduled(cron = "0 0/1 0-23 * * *")
	public void parseData(){
		//String urlStr = "https://www.dofusbook.net/api/items?page=188";
		String urlStr = "https://www.dofusbook.net/api/items?context=item&equipment=am-an-bo-br-ca-ce-ch-do-fa-mt-mo-mu-sa-tr&level_min=1&level_max=200&page=1&display=list";
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
					itemService.saveItem(item);
					httpGet = new HttpGet("https://dofusbook.net/assets/img/items/"+item.getImageId() + "_0.png");
					client = HttpClientBuilder.create().build();
					response = client.execute(httpGet);
					entity = response.getEntity();
					stream = entity.getContent();
					OutputStream out = new BufferedOutputStream(new FileOutputStream("/Users/girouxkevin/downloadImage/"+ item.getImageId() + "_0.png"));
					for (int bit; (bit = stream.read()) != -1;) {
						out.write(bit);
					}
					out.close();
					stream.close();

					
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


}
