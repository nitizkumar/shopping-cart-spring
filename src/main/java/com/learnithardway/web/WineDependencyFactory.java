package com.learnithardway.web;

public class WineDependencyFactory {

	public static WineDependency getDependency(){
		return new WineDao();
	}
}
