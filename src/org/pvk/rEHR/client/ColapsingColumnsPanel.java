package org.pvk.rEHR.client;

import java.util.Collection;
import java.util.Iterator;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.layout.client.Layout;
import com.google.gwt.layout.client.Layout.Alignment;
import com.google.gwt.layout.client.Layout.AnimationCallback;
import com.google.gwt.layout.client.Layout.Layer;
import com.google.gwt.user.client.ui.AnimatedLayout;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ProvidesResize;
import com.google.gwt.user.client.ui.RequiresResize;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.WidgetCollection;

public class ColapsingColumnsPanel extends ResizeComposite implements RequiresResize, ProvidesResize, HasWidgets, AnimatedLayout{
	
	private LayoutPanel layout;
	private WidgetCollection widgets;
	
	public ColapsingColumnsPanel() {

		layout = new LayoutPanel();
		initWidget(layout);

		widgets = new WidgetCollection(this);
		
	}
	
	
	public WidgetCollection getChildren() {
		return this.widgets;
	}
	
	public void add(Widget w) {
		widgets.add(w);
		layout.add(w);
		layoutWidgets();
		
	}
	
	private void layoutWidgets () {
		int parentWidth ;
		if (layout.getOffsetWidth()==0) {
			parentWidth = 500;
		} else {
			parentWidth = layout.getOffsetWidth();
		}
			
		int maxRight=0;
		int maxBottom=0;
		int maxWidth=0;
		
		int colWidth = 400;
		int colHeight = 300;
		
		for (Widget w : this.getChildren()) {
			if (maxWidth < w.getOffsetWidth()) {
				maxWidth = w.getOffsetWidth();
			}
			if (maxRight < (w.getAbsoluteLeft()-this.getAbsoluteLeft())+w.getOffsetWidth()) {
				maxRight = (w.getAbsoluteLeft()-this.getAbsoluteLeft())+w.getOffsetWidth();
			}
			if (maxBottom < w.getAbsoluteTop()+w.getOffsetHeight()) {
				maxBottom = w.getAbsoluteTop()+w.getOffsetHeight();
			}
		}
		if (maxRight>parentWidth) {
			for (int i =0; i<this.getChildren().size();i++) {
				Widget w = layout.getWidget(i);
				w.setHeight("100%");
				colHeight = 100;
				layout.setWidgetLeftWidth(layout.getWidget(i), 0, Style.Unit.PX, colWidth, Style.Unit.PX);
				layout.setWidgetTopHeight(layout.getWidget(i), i*colHeight, Style.Unit.PX, colWidth, Style.Unit.PX);

				
			}
			
		} else if (maxWidth*1.5<parentWidth) {
			for (int i =0; i<(this.getChildren().size()/2);i++) {
				Widget w = this.getWidget(i);
				//w.setHeight("100%");
				colHeight = 300;
				layout.setWidgetLeftWidth(layout.getWidget(i), 0, Style.Unit.PX, colWidth, Style.Unit.PX);
				layout.setWidgetTopHeight(layout.getWidget(i), i*colHeight, Style.Unit.PX, colHeight, Style.Unit.PX);
				
			}	
			
			for (int i =(this.getChildren().size()/2); i<this.getChildren().size();i++) {
				VerticalPanel vp = (VerticalPanel)layout.getWidget(i);
				
				//w.setHeight("200px");
				layout.setWidgetLeftWidth(layout.getWidget(i), colWidth, Style.Unit.PX, colWidth, Style.Unit.PX);
				layout.setWidgetTopHeight(layout.getWidget(i), (i-3)*colHeight, Style.Unit.PX, colHeight, Style.Unit.PX);
			}
		}
		//layout.animate(1000);
	}
	
	public Widget getWidget(int index) {
		return widgets.get(index);
		
	}
	
	public void onResize(){

		layoutWidgets();
		layout.onResize();
		this.setWidth(Integer.toString(this.getParent().getOffsetWidth())+"px");
		
		
	}


	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Iterator<Widget> iterator() {
		// TODO Auto-generated method stub
		return this.getChildren().iterator();
	}


	@Override
	public boolean remove(Widget w) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void animate(int duration) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void animate(int duration, AnimationCallback callback) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void forceLayout() {
		// TODO Auto-generated method stub
		
	}





	
	
}
