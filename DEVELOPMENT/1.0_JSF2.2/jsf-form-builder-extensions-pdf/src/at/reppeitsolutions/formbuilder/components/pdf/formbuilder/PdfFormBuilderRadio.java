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
package at.reppeitsolutions.formbuilder.components.pdf.formbuilder;

import com.lowagie.text.Element;
import at.reppeitsolutions.formbuilder.components.pdf.itext.ITextRadio;
import at.reppeitsolutions.formbuilder.components.pdf.itext.formbuilder.ITextInnerTable;
import at.reppeitsolutions.formbuilder.components.pdf.itext.formbuilder.ITextParagraph;

/**
 *
 * @author Mathias Reppe <mathias.reppe@gmail.com>
 */
public class PdfFormBuilderRadio extends PdfFormBuilderItem {

    public PdfFormBuilderRadio() {
        
    }

    @Override
    public Element render() {
        ITextInnerTable innerTable = new ITextInnerTable(getProperties().getOnelinedescription());
        innerTable.getDescription().addElement(new ITextParagraph(getProperties().getLabel() + getMandatoryString()));
        innerTable.getContent().setCellEvent(new ITextRadio(
                getProperties().getValues().split(";"), 
                getValue(),
                isDisabled()));
        innerTable.getContent().setFixedHeight(getProperties().getValues().length() * 3.5f);
        innerTable.addCells();
        return innerTable;
    }
    
}
