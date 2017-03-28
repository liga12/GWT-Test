package com.liga.client;

import java.util.Random;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class ChangeBackgroundColor extends Composite implements EntryPoint {

	private FlowPanel flowPanel = new FlowPanel();
	private Button changeColor = new Button("Change color");
	
	@Override
	public void onModuleLoad() {
		this.setOptionsFlowPanel();
		this.setOptionsButton();
		RootPanel.get().add(this);
	}
	
	private void setOptionsFlowPanel() {
		Style flowPanelSetting = flowPanel.getElement().getStyle();
		initWidget(flowPanel);
		flowPanel.add(changeColor);
		flowPanelSetting.setTextAlign(TextAlign.CENTER);
		flowPanelSetting.setMarginTop(300, Unit.PX);
	}

	private void setOptionsButton() {
		Style changeColorSetting = changeColor.getElement().getStyle();
		changeColorSetting.setHeight(50, Unit.PX);
		changeColorSetting.setWidth(150, Unit.PX);
		changeColorSetting.setFontSize(20, Unit.PX);

		changeColor.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get().getElement().getStyle().setBackgroundColor(generateColor());
			}
		});
	}

	private String generateColor() {
		StringBuilder color = new StringBuilder(Integer.toHexString(new Random().nextInt(16777215)));
		while (color.length() < 6) {
			color.append("0");
		}
		return color.append("#").reverse().toString();

	}
}
