/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.reppeitsolutions.formbuilder.components.pdf.helper;

import at.reppeitsolutions.formbuilder.components.pdf.renderer.formbuilder.FormFillerPdfRenderer;
import at.reppeitsolutions.formbuilder.components.pdf.renderkit.PdfResponseWriter;
import at.reppeitsolutions.formbuilder.model.FormData;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author Mathias Reppe <mathias.reppe@gmail.com>
 */
public class FormBuilderPdfFactory {
    
    public static void getPdf(OutputStream output, FormData formData) throws IOException {
        PdfResponseWriter writer = new PdfResponseWriter("UTF-8");
        writer.startDocumentInternal(output);
        FormFillerPdfRenderer renderer = new FormFillerPdfRenderer();
        renderer.encodePdf(formData, writer.getDocument());
        writer.endDocumentInternal();
    }
    
}
