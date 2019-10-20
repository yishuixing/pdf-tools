package com.what;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import sun.jvm.hotspot.debugger.Page;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class PdfUtils {
    private static final String imgPath = "/Users/anjun/bd/soft/imgs";
    private static final Rectangle rect = new Rectangle(PageSize.A1.getHeight(), PageSize.A1.getWidth());
    public static void main(String[] args) throws IOException, DocumentException {

        java.util.List<String> items = new ArrayList();
        File file = new File(imgPath);
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".jpg")) {
                items.add(f.getName());
            }
        }

        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream("spark机器学习进阶实战.pdf"));
        doc.setPageSize(rect);

        doc.open();
        items=items.stream().sorted().collect(Collectors.toList());

        for (String f : items) {

            Image image = Image.getInstance(Paths.get(imgPath,f).toAbsolutePath().toString());
//                        image.setWidthPercentage(100);
//                        image.setScaleToFitHeight(true);
//                        image.setScaleToFitLineWhenOverflow(true);
//                        image.setRotationDegrees(-90);
//            image.scaleToFit(rect.getWidth(),rect.getHeight()+333);
            image.scaleToFit(doc.getPageSize());
            doc.add(image);
        }
        doc.close();
    }

}
