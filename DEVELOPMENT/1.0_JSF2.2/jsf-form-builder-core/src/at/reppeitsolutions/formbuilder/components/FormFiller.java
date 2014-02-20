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

import at.reppeitsolutions.formbuilder.components.html.HtmlIFrame;
import at.reppeitsolutions.formbuilder.components.html.renderer.formbuilder.FormFillerRenderer;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlForm;

/**
 *
 * @author Mathias Reppe <mathias.reppe@gmail.com>
 */
@FacesComponent(createTag = true, namespace = Constants.NAMESPACE, tagName = "formFiller")
@ResourceDependencies(value = {
    @ResourceDependency(library = "javax.faces", name = "jsf.js"),
    @ResourceDependency(library = "formbuilder", name = "js/jquery-1.9.1.js"),
    @ResourceDependency(library = "formbuilder", name = "js/jquery-ui-1.10.3.custom.min.js"),
    @ResourceDependency(library = "formbuilder", name = "formbuilderiframe.css"),
    @ResourceDependency(library = "formbuilder", name = "js/iframe.js")
})
public class FormFiller extends FormFillerComponentBase {
    
    public static final String MODE_VIEW = "view";
    public static final String MODE_FILL = "fill";

    private HtmlForm form;
    
    public FormFiller() {
        setRendererType(FormFillerRenderer.RENDERTYPE);
    }
    
    @PostConstruct
    public void init() {
        setMode(MODE_FILL);
        addCallbackButton();
        addIFrame("795px");
    }

    public HtmlForm getForm() {
        return form;
    }
    
    public String getSubmitButtonId() {
        return (String) getStateHelper().eval("submitButtonId");
    }
    
    public void setSubmitButtonId(String submitButtonId) {
        getStateHelper().put("submitButtonId", submitButtonId);
    }

    @Override
    public String getFamily() {
        return FormFillerRenderer.FAMILY;
    }
    
}
