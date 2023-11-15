package com.valtech.training.spring;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UtilsBean {

	private List<String> names;
	private Properties settings;
	private Map<Point, Line> linePoints;
	

	public Map<Point, Line> getLinePoints() {
		return linePoints;
	}

	public void setLinePoints(Map<Point, Line> linePoints) {
		this.linePoints = linePoints;
	}

	public Properties getSettings() {
		return settings;
	}

	public void setSettings(Properties settings) {
		this.settings = settings;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}
}
