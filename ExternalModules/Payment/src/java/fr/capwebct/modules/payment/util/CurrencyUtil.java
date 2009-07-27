package fr.capwebct.modules.payment.util;

import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyUtil {

    private static NumberFormat euroFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);

    public static String getFormattedAmount(int amountInCents) {
        String formattedAmount = euroFormat.format(amountInCents / 100.00);
        try {
            return new String(formattedAmount.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            // Can UTF-8 still be unsupported somewhere ??
            return "";
        }
    }
}
