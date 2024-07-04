package main.Java.Util;

import java.awt.*;
import java.awt.print.*;
import java.util.ArrayList;

public class ArrayPrinter implements Printable {
    private final ArrayList<String> lista;

    public ArrayPrinter(ArrayList<String> lista) {
        this.lista = lista;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        Font font = new Font("Monospaced", Font.PLAIN, 6);
        g2d.setFont(font);

        int y = 5;
        int lineWidth = 120;
        FontMetrics metrics = g2d.getFontMetrics();

        for (String item : lista) {
            String[] lines = item.split("\r?\n");
            for (String line : lines) {
                String[] words = line.split("\\s+");
                StringBuilder lineText = new StringBuilder();

                for (String word : words) {
                    if (metrics.stringWidth(lineText.toString() + word + " ") > lineWidth) {
                        g2d.drawString(lineText.toString(), 0, y);
                        y += metrics.getHeight();
                        lineText.setLength(0);
                    }
                    lineText.append(word).append(" ");
                }
                g2d.drawString(lineText.toString(), 0, y);
                y += metrics.getHeight();
            }
            y += metrics.getHeight();
        }

        return PAGE_EXISTS;
    }

    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Observações:");
        lista.add("Este é um texto de exemplo\ncom várias linhas.\nCada linha deve ser impressa corretamente.");
        
        PrinterJob job = PrinterJob.getPrinterJob();
        ArrayPrinter printer = new ArrayPrinter(lista);

        Paper paper = new Paper();
        paper.setSize(124, 1400);
        paper.setImageableArea(0, 0, 120, 1390);

        PageFormat pageFormat = new PageFormat();
        pageFormat.setPaper(paper);
        pageFormat.setOrientation(PageFormat.PORTRAIT);

        Book book = new Book();
        book.append(printer, pageFormat);

        job.setPageable(book);

        if (job.printDialog()) {
            try {
                job.print();
            } catch (PrinterException e) {
                System.err.println("Erro ao imprimir: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
