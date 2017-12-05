package com.retail.kiranaStore.configuration;

import java.util.HashMap;
import java.util.Map;

public class WebConfigParametersHolder {

	/** The application parameter map. */
	private Map<String, String> configParameterMap = new HashMap<String, String>();

	/**
	 * Gets the config parameter map.
	 *
	 * @return the config parameter map
	 */
	public Map<String, String> getConfigParameterMap() {
		return configParameterMap;
	}

	/**
	 * Sets the config parameter map.
	 *
	 * @param configParameterMap the config parameter map
	 */
	public void setConfigParameterMap(Map<String, String> configParameterMap) {
		this.configParameterMap = configParameterMap;
	}

}
