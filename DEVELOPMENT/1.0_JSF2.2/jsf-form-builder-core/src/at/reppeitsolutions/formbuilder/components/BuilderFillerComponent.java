/*
 * Copyright (C) 2014 Mathias Reppe <mathias.reppe@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package at.reppeitsolutions.formbuilder.components;

import at.reppeitsolutions.formbuilder.components.html.HtmlDiv;
import at.reppeitsolutions.formbuilder.components.html.HtmlIFrame;
import at.reppeitsolutions.formbuilder.components.html.HtmlUnorderedList;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.faces.component.UICommand;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Mathias Reppe <mathias.reppe@gmail.com>
 */
public abstract class BuilderFillerComponent extends UICommand {

    protected HtmlCommandButton callbackButton;
    protected HtmlUnorderedList formContent;
    protected HtmlIFrame iframe;

    @PostConstruct
    public void initBase() {
        setInvokeCallback(false);
    }

    /*
     * @param width: width in pixel
     */
    protected void addIFrame(int width) {
        HtmlDiv div = new HtmlDiv();
        div.setStyle("margin:0;padding:0;position:relative;width:" + width + "px;");

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HtmlOutputText loadImage = new HtmlOutputText();
        loadImage.setEscape(false);
        loadImage.setValue("<div id=\"loadImg\" style=\"position:absolute; left: " + (width / 2 - 25) + "px; top: 200px;\">"
                + "<img width=\"50px\" height=\"50px\" src=\"" + request.getContextPath() + "/javax.faces.resource/formbuilder/images/ajaxReload.gif.xhtml\" />"
                + "</div>");
        div.getChildren().add(loadImage);

        iframe = new HtmlIFrame();
        iframe.setStyle("width: " + width + "px;");
        iframe.setBorder(0);
        iframe.setScrolling(false);
        iframe.setId("iframe" + UUID.randomUUID().toString());
        iframe.setOnload("document.getElementById('loadImg').style.display='none';");
        div.getChildren().add(iframe);
        getChildren().add(div);
    }

    protected void addCallbackButton() {
        callbackButton = new HtmlCommandButton();
        callbackButton.setId("callbackbutton");
        callbackButton.addClientBehavior("action", new AjaxBehavior());
        callbackButton.setStyle("display:none;");
        callbackButton.setValue("callback button");
        getChildren().add(callbackButton);
    }

    public HtmlUnorderedList getFormContent() {
        return formContent;
    }

    public HtmlIFrame getIFrame() {
        return iframe;
    }

    public HtmlCommandButton getCallbackButton() {
        return callbackButton;
    }

    public boolean getInvokeCallback() {
        return (boolean) getStateHelper().eval("invokeCallback");
    }

    public void setInvokeCallback(boolean invokeCallback) {
        getStateHelper().put("invokeCallback", invokeCallback);
    }
}
