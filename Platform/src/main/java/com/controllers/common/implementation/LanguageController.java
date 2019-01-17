package com.controllers.common.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.controllers.common.ILanguageController;
import com.views.common.ILanguagePanel;

@Component
public class LanguageController implements ILanguageController {

	private List<ILanguagePanel> panels = new ArrayList<>();
	private ResourceBundle currentLanguage;
	
	@Autowired
	@Qualifier("roLanguageBundle")
	private ResourceBundle roLanguageBundle;
	
	@Autowired
	@Qualifier("enLanguageBundle")
	private ResourceBundle enLanguageBundle;

	public LanguageController(ResourceBundle roLanguageBundle, ResourceBundle enLanguageBundle) {
		super();
		this.roLanguageBundle = roLanguageBundle;
		this.enLanguageBundle = enLanguageBundle;
	}

	public LanguageController() {
		super();
		// TODO Auto-generated constructor stub
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
