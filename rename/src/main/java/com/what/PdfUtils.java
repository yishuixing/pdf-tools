package com.what;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PdfUtils {
    private static final String imgPath="F:\\imgs";
    public static void main(String[] args) {
            Document doc = new Document();
            try {
                PdfWriter.getInstance(doc, new FileOutputStream("7.pdf"));
                doc.open();
                File file = new File(imgPath);
                for (File f : file.listFiles()) {
                    if (f.getName().endsWith(".jpg")) {
                        Image image = Image.getInstance(f.getAbsolutePath());
                        image.setWidthPercentage(100);
//                        image.setScaleToFitHeight(true);
//                        image.setScaleToFitLineWhenOverflow(true);
                        image.setRotationDegrees(-90);
                        image.scaleToFit(800,700);
                        doc.add(image);
                    }
                }

            } catch (DocumentException | IOException e) {
                e.printStackTrace();
            } finally {
                doc.close();
            }
        }

}
