package com.example.labelapplication;
import android.content.Context;
import android.util.Log;

import com.bixolon.labelprinter.BixolonLabelPrinter;

public class LabelPrinter {
    private static final String PRINTER_IP = "192.168.1.100"; // Replace with your printer IP
    private static final int PRINTER_PORT = 9100;
    private BixolonLabelPrinter bixolonPrinter;
    private Context context;

    public LabelPrinter(Context context) {
        this.context = context;
        bixolonPrinter = new BixolonLabelPrinter(context);
    }
    public void printLabel(String text) {
        try {
            bixolonPrinter.connect(PRINTER_IP, PRINTER_PORT);
            bixolonPrinter.beginTransactionPrint();
            bixolonPrinter.drawText(text, 10, 10, BixolonLabelPrinter.FONT_SIZE_24, 0, 0, 10,BixolonLabelPrinter.ROTATION_NONE,false,true,0);
            bixolonPrinter.print(1, 1);
            bixolonPrinter.endTransactionPrint();
            bixolonPrinter.disconnect();
        } catch (Exception e) {
            Log.e("LabelPrinter", "Printing Error: " + e.getMessage());
        }
    }
}
