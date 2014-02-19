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

import at.reppeitsolutions.formbuilder.model.Form;
import at.reppeitsolutions.formbuilder.model.IGroup;
import at.reppeitsolutions.formbuilder.model.IUser;
import at.reppeitsolutions.formbuilder.model.IWorkflowState;
import java.util.List;
import javax.faces.component.UICommand;

/**
 *
 * @author Mathias Reppe <mathias.reppe@gmail.com>
 */
public abstract class BuilderFillerComponent extends UICommand {
        
    public List<IWorkflowState> getWorkflowStates() {
        return (List<IWorkflowState>) getStateHelper().eval("workflowStates");
    }

    public void setWorkflowStates(List<IWorkflowState> workflowStates) {
        getStateHelper().put("workflowStates", workflowStates);
    }

    public List<IUser> getUser() {
        return (List<IUser>) getStateHelper().eval("user");
    }

    public void setUser(List<IUser> user) {
        getStateHelper().put("user", user);
    }
    
    public List<IGroup> getGroups() {
        return (List<IGroup>) getStateHelper().eval("groups");
    }

    public void setGroups(List<IGroup> groups) {
        getStateHelper().put("groups", groups);
    }
    
}
