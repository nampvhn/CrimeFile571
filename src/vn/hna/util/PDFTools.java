/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hna.util;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.io.FileOutputStream;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Edison
 */
public class PDFTools extends JFrame {
    public void print(JTable table, String filePath) {
        Document document = new Document(PageSize.A4.rotate());
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));

            document.open();
            PdfContentByte cb = writer.getDirectContent();

            cb.saveState();
            Graphics2D g2 = cb.createGraphicsShapes(1000, 500);

            Shape oldClip = g2.getClip();
            g2.clipRect(0, 0, 1000, 500);
            
            table.getTableHeader().print(g2);
            g2.setClip(oldClip);
            table.print(g2);
            g2.setClip(oldClip);

            g2.dispose();
            cb.restoreState();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        document.close();
    }
}
