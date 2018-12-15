package com.controllers.common.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.controllers.common.ILanguageController;
import com.views.common.ILanguagePanel;

public class LanguageController implements ILanguageController {

	private List<ILanguagePanel> panels = new ArrayList<>();
	private ResourceBundle currentLanguage;
	private ResourceBundle roLanguageBundle;
	private ResourceBundle enLanguageBundle;

	
	
	public LanguageController(ResourceBundle roLanguageBundle, ResourceBundle enLanguageBundle) {
		super();
		this.roLanguageBundle = roLanguageBundle;
		this.enLanguageBundle = enLanguageBundle;
	}

	@Override
	public void add(ILanguagePanel languagePanel) {
		panels.add(languagePanel);
	}

	@Override
	public void roLanguageSelected() {
		currentLanguage = roLanguageBundle;
		update();
	}


	@Override
	public void enLanguageSelected() {
		currentLanguage = enLanguageBundle;
		update();
	}

	private void update() {
		for(ILanguagePanel languagePanel : panels) {
			languagePanel.setLanguageBundle(currentLanguage);
		}
	}
}
