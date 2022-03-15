package com.controller.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilterPhotoDTO {
	
	private Map<String, List<Object>> filters;
	
	public FilterPhotoDTO() {
		filters = new HashMap<>();
		filters.put("brand",new ArrayList<>());
		filters.put("promoter",new ArrayList<>());
		filters.put("chain",new ArrayList<>());
		filters.put("shop",new ArrayList<>());
		filters.put("section",new ArrayList<>());
		filters.put("project",new ArrayList<>());

	}
	
	public Map<String, List<Object>> getFilters() {
		return filters;
	}
}
