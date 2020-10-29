package br.com.brasilPrev.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

public class CustomSortDeserializer extends JsonDeserializer<Sort> {

	@Override
	public Sort deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public Sort deserialize(JsonParser p, DeserializationContext ctxt)
	 * throws IOException, JsonProcessingException { ArrayNode node =
	 * jsonParser.getCodec().readTree(jsonParser); Sort.Order[] orders = new
	 * Sort.Order[node.size()]; int i = 0; for(JsonNode json : node) { orders[i] =
	 * new Sort.Order(Sort.Direction.valueOf(json.get("direction").asText()),
	 * json.get("propert").asText()); i++; } return new Sort(orders);
	 * 
	 * }
	 */
}
