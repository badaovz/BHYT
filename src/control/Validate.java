/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.JOptionPane;
//import static jdk.nashorn.internal.runtime.JSType.isNumber;

/**
 *
 * @author duong
 */
public class Validate {
    public static boolean validatePercent(String text, String index) {
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Trường " + index + " bị bỏ trống");
            return false;
        }
        if (!isNumber(text)) {
            JOptionPane.showMessageDialog(null, "Trường " + index + " dữ liệu không hợp lệ");
            return false;
        }
        float p = Float.parseFloat(text);
        if (p < 0.0 || p > 100.0) {
            JOptionPane.showMessageDialog(null, "Trường " + index + " dữ liệu yêu cầu 0 -> 100");
            return false;
        }
        return true;
    }
    public static boolean isNumber(String number) {
        try {
            Float.parseFloat(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
}
