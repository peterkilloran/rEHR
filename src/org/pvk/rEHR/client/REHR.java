package org.pvk.rEHR.client;

import org.pvk.rEHR.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class REHR implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		//DockPanel rootLayout = new DockPanel();
		//rootLayout.setSpacing(4);
		//rootLayout.setHorizontalAlignment(DockPanel.ALIGN_CENTER);
		
		HorizontalPanel banner = new HorizontalPanel();
		banner.add(new Label("Updated rEHR Patient Banner Area"));
		//rootLayout.add(banner, DockPanel.NORTH);
		
		SplitLayoutPanel resizeableLayout = new SplitLayoutPanel(5);
		resizeableLayout.ensureDebugId("cwSplitLayoutPanel");
		resizeableLayout.getElement().getStyle().setProperty("border", "3px solid #e7e7e7");
		final ScrollPanel doPanel = new ScrollPanel();
		doPanel.add(new Label("do"));
		VerticalPanel scratchPanel = new VerticalPanel();
		scratchPanel.add(new Label("scratch"));
		ScrollPanel viewPanel = new ScrollPanel();
		//viewPanel.add(new Label("View"));
		resizeableLayout.addNorth(banner,100);
		resizeableLayout.addWest(scratchPanel, 300);
		resizeableLayout.addEast(doPanel, 300);


		
		ColapsingColumnsPanel colapsingPanel = new ColapsingColumnsPanel();
		//ColapsingColumnsPanel viewLayoutPanel = new ColapsingColumnsPanel();
		
		
		//LayoutPanel viewLayoutPanel = new LayoutPanel();
		

		VerticalPanel item_1 = new VerticalPanel();
		item_1.setBorderWidth(1);
		item_1.setSpacing(5);
		//item_1.setWidth("400px");
		//item_1.setHeight("100px");
		item_1.add(new Button("item_1"));
		item_1.getWidget(0).setHeight("100%");
		item_1.getWidget(0).setWidth("100%");
		
		Frame allergies = new Frame("allergies.html");
		allergies.setWidth("100%");
		allergies.setHeight("1000px");
		item_1.add(allergies);
		
		/*item_1.add(new Label("item"));
		item_1.add(new Label("item"));
		item_1.add(new Label("item"));
		item_1.add(new Label("item"));
		*/
		colapsingPanel.add(item_1);
		
		VerticalPanel item_2 = new VerticalPanel();
		item_2.setBorderWidth(1);
		item_2.setSpacing(5);
		//item_2.setWidth("400px");
		//item_2.setHeight("100px");
		item_2.add(new Button("item_2"));
		item_2.getWidget(0).setWidth("100%");

		Frame medications = new Frame("test_data_medications.html");
		medications.setWidth("100%");
		medications.setHeight("1000px");
		item_2.add(medications);
		//item_2.getWidget(0).setHeight("100%");
		/*
		item_2.add(new Label("item"));
		item_2.add(new Label("item"));
		item_2.add(new Label("item"));
		item_2.add(new Label("item"));
		*/
		colapsingPanel.add(item_2);		
		
		VerticalPanel item_3 = new VerticalPanel();
		item_3.setBorderWidth(1);
		item_3.setSpacing(5);
		//item_3.setWidth("400px");
		//item_3.setHeight("100px");
		item_3.add(new Button("item_3"));
		item_3.getWidget(0).setHeight("100%");
		item_3.getWidget(0).setWidth("100%");
		Frame problems = new Frame("test_data_problems.html");
		problems.setWidth("100%");
		problems.setHeight("1000px");
		item_3.add(problems);
		
		/*
		item_3.add(new Label("item"));
		item_3.add(new Label("item"));
		item_3.add(new Label("item"));
		item_3.add(new Label("item"));
		*/
		colapsingPanel.add(item_3);
		
		VerticalPanel item_4 = new VerticalPanel();
		item_4.setBorderWidth(1);
		item_4.setSpacing(5);
		//item_4.setWidth("400px");
		//item_4.setHeight("100px");
		item_4.add(new Button("item_4"));
		item_4.getWidget(0).setHeight("100%");
		item_4.getWidget(0).setWidth("100%");

		Frame immunizations = new Frame("tmp_immunization1.html");
		immunizations.setWidth("100%");
		immunizations.setHeight("1000px");
		item_4.add(immunizations);
		
		/*
		item_4.add(new Label("item"));
		item_4.add(new Label("item"));
		item_4.add(new Label("item"));
		item_4.add(new Label("item"));
		*/
		colapsingPanel.add(item_4);

		VerticalPanel item_5 = new VerticalPanel();
		item_5.setBorderWidth(1);
		item_5.setSpacing(5);
		//item_5.setWidth("400px");
		//item_5.setHeight("100px");
		item_5.add(new Button("item_5"));
		item_5.getWidget(0).setHeight("100%");
		item_5.getWidget(0).setWidth("100%");
		item_5.add(new Label("item"));
		item_5.add(new Label("item"));
		item_5.add(new Label("item"));
		item_5.add(new Label("item"));
		colapsingPanel.add(item_5);
		
		VerticalPanel item_6 = new VerticalPanel();
		item_6.setBorderWidth(1);
		item_6.setSpacing(5);
		//item_6.setWidth("400px");
		//item_6.setHeight("100px");
		item_6.add(new Button("item_6"));
		item_6.getWidget(0).setHeight("100%");
		item_6.getWidget(0).setWidth("100%");
		item_6.add(new Label("item"));
		item_6.add(new Label("item"));
		item_6.add(new Label("item"));
		item_6.add(new Label("item"));
		colapsingPanel.add(item_6);
		/*
		colapsingPanel.setWidgetLeftWidth(item_1, 0, Style.Unit.PX, 200, Style.Unit.PX);
		colapsingPanel.setWidgetTopHeight(item_1, 0, Style.Unit.PX, 200, Style.Unit.PX);
		colapsingPanel.setWidgetLeftWidth(item_2, 0, Style.Unit.PX, 200, Style.Unit.PX);
		colapsingPanel.setWidgetTopHeight(item_2, 200, Style.Unit.PX, 200, Style.Unit.PX);
		colapsingPanel.setWidgetLeftWidth(item_3, 0, Style.Unit.PX, 200, Style.Unit.PX);
		colapsingPanel.setWidgetTopHeight(item_3, 400, Style.Unit.PX, 200, Style.Unit.PX);

		colapsingPanel.setWidgetLeftWidth(item_4, 300, Style.Unit.PX, 200, Style.Unit.PX);
		colapsingPanel.setWidgetTopHeight(item_4, 0, Style.Unit.PX, 200, Style.Unit.PX);
		colapsingPanel.setWidgetLeftWidth(item_5, 300, Style.Unit.PX, 200, Style.Unit.PX);
		colapsingPanel.setWidgetTopHeight(item_5, 200, Style.Unit.PX, 200, Style.Unit.PX);
		colapsingPanel.setWidgetLeftWidth(item_6, 300, Style.Unit.PX, 200, Style.Unit.PX);
		colapsingPanel.setWidgetTopHeight(item_6, 400, Style.Unit.PX, 200, Style.Unit.PX);
		*/
		viewPanel.setWidth("100%");
		viewPanel.setHeight("100%");
		viewPanel.add(colapsingPanel);
	
		resizeableLayout.add(viewPanel);

		//colapsingPanel.setWidth("1000px");
		//colapsingPanel.setHeight("1000px");
		
		RootLayoutPanel.get().add(resizeableLayout);
		resizeableLayout.forceLayout();
		colapsingPanel.setWidth(colapsingPanel.getParent().getOffsetWidth()+"px");
		colapsingPanel.setHeight(colapsingPanel.getParent().getOffsetHeight()+"px");
		
		
	}
	
}
