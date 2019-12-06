package com.learnithardway.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WineServiceRegistry {

	private List<String> dependencyClasses = new ArrayList<>();

	private List<Object> dependencies = new ArrayList<>();

	public void scanAllDependencies() {
		dependencyClasses.add("com.learnithardway.web.WineDao");
	}

	public void initializeDependency() {
		scanAllDependencies();
		for (int i = 0; i < dependencyClasses.size(); i++) {
			try {
				String clazzName = dependencyClasses.get(i);
				Object instance = Class.forName(clazzName).newInstance();
				dependencies.add(instance);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Object getWineDependency(Class clazzname) {
		for (Object object : dependencies) {
			if (clazzname.isAssignableFrom(object.getClass()))
				return object;
		}
		return null;
	}
}
