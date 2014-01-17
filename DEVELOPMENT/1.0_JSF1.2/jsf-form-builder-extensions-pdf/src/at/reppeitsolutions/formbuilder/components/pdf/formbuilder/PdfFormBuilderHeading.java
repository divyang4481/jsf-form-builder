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

import com.lowagie.text.Chunk;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import at.reppeitsolutions.formbuilder.components.pdf.itext.formbuilder.ITextParagraph;

/**
 *
 * @author Mathias Reppe <mathias.reppe@gmail.com>
 */
public class PdfFormBuilderHeading extends PdfFormBuilderItem {

    public PdfFormBuilderHeading() {
    }

    @Override
    public Element render() {
        Font font = new Font();
        switch (getProperties().getSize()) {
            case 1:
                font.setSize(30);
                break;
            case 2:
                font.setSize(25);
                break;
            case 3:
                font.setSize(20);
                break;
        }
        Chunk chunk = new Chunk(getProperties().getValues(), font);
        return new ITextParagraph(chunk);
    }
}
