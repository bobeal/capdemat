package fr.capwebct.capdemat.plugins.paymentproviders.spplus.utils;

/**
 * Titre :
 * Description :
 * Copyright :    Copyright (c) 2003
 * Société :
 * @author
 * @version 1.0
 */



public class URLEncryption
{
    public static int MAXLINE = 1024;
    public static String DW_EOL = "\n";
    public static String base64tab = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    public static char[] base64idx = {
        '\377','\377','\377','\377','\377','\377','\377','\377',
        '\377','\377','\377','\377','\377','\377','\377','\377',
        '\377','\377','\377','\377','\377','\377','\377','\377',
        '\377','\377','\377','\377','\377','\377','\377','\377',
        '\377','\377','\377','\377','\377','\377','\377','\377',
        '\377','\377','\377',    62,'\377','\377','\377',    63,
        52,    53,    54,    55,    56,    57,    58,    59,
        60,    61,'\377','\377','\377','\377','\377','\377',
        '\377',     0,     1,     2,     3,     4,     5,     6,
         7,     8,     9,    10,    11,    12,    13,    14,
        15,    16,    17,    18,    19,    20,    21,    22,
        23,    24,    25,'\377','\377','\377','\377','\377',
        '\377',    26,    27,    28,    29,    30,    31,    32,
        33,    34,    35,    36,    37,    38,    39,    40,
        41,    42,    43,    44,    45,    46,    47,    48,
        49,    50,    51,'\377','\377','\377','\377','\377'
        };

    static String hextab = "0123456789ABCDEF";
    public static boolean isbase64(char aChar)
    {
        return ('A' <= aChar && aChar <= 'Z')
               || ('a' <= aChar && aChar <= 'z')
               || ('0' <= aChar && aChar <= '9')
               || aChar == '+' || aChar == '/';
    }
    public URLEncryption()
    {

    }

    public static String encode_base64(String toEncrypt)
    {
        StringBuffer osb_out = new StringBuffer();
        int c1, c2, c3;
        int lineLen = 0;
        int outSize;
        int inPos  = 0;
        int i =0;
        int inLen = toEncrypt.length();

        outSize = (inLen+2)/3*4;     /* 3:4 conversion ratio */
        outSize += 2*outSize/MAXLINE + 2;  /* Space for newlines and NUL */
        /* Get three characters at a time and encode them. */
        for (i=0; i < inLen/3; ++i)
        {
            c1 = toEncrypt.charAt(inPos++) & 0xFF;
            c2 = toEncrypt.charAt(inPos++) & 0xFF;
            c3 = toEncrypt.charAt(inPos++) & 0xFF;
            osb_out.append(base64tab.charAt((c1 & 0xFC) >> 2));
            osb_out.append(base64tab.charAt(((c1 & 0x03) << 4) | ((c2 & 0xF0) >> 4)));
            osb_out.append(base64tab.charAt(((c2 & 0x0F) << 2) | ((c3 & 0xC0) >> 6)));
            osb_out.append(base64tab.charAt(c3 & 0x3F));
            lineLen += 4;
            if (lineLen >= MAXLINE-3)
            {
                osb_out.append(DW_EOL);
                lineLen = 0;
            }
        }
        /* Encode the remaining one or two characters. */

        switch (inLen % 3)
        {
        case 0:
            osb_out.append('=');
            break;
        case 1:
            c1 = toEncrypt.charAt(inPos) & 0xFF;
            osb_out.append(base64tab.charAt(((c1 & 0xFC) >> 2)));
            osb_out.append(base64tab.charAt(((c1 & 0x03) << 4)));
            osb_out.append('=');
            osb_out.append('=');
            break;
        case 2:
            c1 = toEncrypt.charAt(inPos++) & 0xFF;
            c2 = toEncrypt.charAt(inPos) & 0xFF;
            osb_out.append(base64tab.charAt(((c1 & 0xFC) >> 2)));
            osb_out.append(base64tab.charAt(((c1 & 0x03) << 4) | ((c2 & 0xF0) >> 4)));
            osb_out.append(base64tab.charAt(((c2 & 0x0F) << 2)));
            osb_out.append('=');
            break;
        }
        return osb_out.toString();
    }
    public static String decode_base64(String toDecrypt)
    {
        StringBuffer osb_out = new StringBuffer();
        boolean isErr = false;
        boolean isEndSeen = false;
        int b1, b2, b3;
        int a1, a2, a3, a4;
        int inPos = 0;
        int outPos = 0;
        int inLen =0;

        inLen = toDecrypt.length();
        /* Get four input chars at a time and decode them. Ignore white space
         * chars (CR, LF, SP, HT). If '=' is encountered, terminate input. If
         * a char other than white space, base64 char, or '=' is encountered,
         * flag an input error, but otherwise ignore the char.
         */

        while (inPos < inLen)
        {
            a1 = a2 = a3 = a4 = 0;
            while (inPos < inLen)
            {
                a1 = toDecrypt.charAt(inPos++) & 0xFF;
                if (isbase64((char)a1))
                {
                    break;
                }
                else
                {
                    if (a1 == '=')
                    {
                        isEndSeen = true;
                        break;
                    }
                    else
                    {
                        if (a1 != '\r' && a1 != '\n' && a1 != ' ' && a1 != '\t')
                        {
                            isErr = true;
                        }
                    }
                }
            }
            while (inPos < inLen)
            {
                a2 = toDecrypt.charAt(inPos++) & 0xFF;
                if (isbase64((char)a2))
                {
                    break;
                }
                else
                {
                    if (a2 == '=')
                    {
                        isEndSeen = true;
                        break;
                    }
                    else
                    {
                        if (a2 != '\r' && a2 != '\n' && a2 != ' ' && a2 != '\t')
                        {
                            isErr = true;
                        }
                    }
                }
            }
            while (inPos < inLen)
            {
                a3 = toDecrypt.charAt(inPos++) & 0xFF;
                if (isbase64((char)a3))
                {
                    break;
                }
                else
                {
                    if (a3 == '=')
                    {
                        isEndSeen = true;
                        break;
                    }
                    else
                    {
                        if (a3 != '\r' && a3 != '\n' && a3 != ' ' && a3 != '\t')
                        {
                            isErr = true;
                        }
                    }
                }
            }
            while (inPos < inLen)
            {
                a4 = toDecrypt.charAt(inPos++) & 0xFF;
                if (isbase64((char)a4))
                {
                    break;
                }
                else
                {
                    if (a4 == '=')
                    {
                        isEndSeen = true;
                        break;
                    }
                    else
                    {
                        if (a4 != '\r' && a4 != '\n' && a4 != ' ' && a4 != '\t')
                        {
                            isErr = true;
                        }
                    }
                }
            }
            if (isbase64((char)a1) && isbase64((char)a2) && isbase64((char)a3) && isbase64((char)a4))
            {
                a1 = base64idx[a1] & 0xFF;
                a2 = base64idx[a2] & 0xFF;
                a3 = base64idx[a3] & 0xFF;
                a4 = base64idx[a4] & 0xFF;
                b1 = ((a1 << 2) & 0xFC) | ((a2 >> 4) & 0x03);
                b2 = ((a2 << 4) & 0xF0) | ((a3 >> 2) & 0x0F);
                b3 = ((a3 << 6) & 0xC0) | ( a4       & 0x3F);
                osb_out.append((char)b1);
                osb_out.append((char)b2);
                osb_out.append((char)b3);
            }
            else
            {
                if (isbase64((char)a1) && isbase64((char)a2) && isbase64((char)a3) && a4 == '=')
                {
                    a1 = base64idx[a1] & 0xFF;
                    a2 = base64idx[a2] & 0xFF;
                    a3 = base64idx[a3] & 0xFF;
                    b1 = ((a1 << 2) & 0xFC) | ((a2 >> 4) & 0x03);
                    b2 = ((a2 << 4) & 0xF0) | ((a3 >> 2) & 0x0F);
                    osb_out.append((char)b1);
                    osb_out.append((char)b2);
                    break;
                }
                else
                {
                    if (isbase64((char)a1) && isbase64((char)a2) && a3 == '=' && a4 == '=')
                    {
                        a1 = base64idx[a1] & 0xFF;
                        a2 = base64idx[a2] & 0xFF;
                        b1 = ((a1 << 2) & 0xFC) | ((a2 >> 4) & 0x03);
                        osb_out.append((char)b1);
                        break;
                    }
                    else
                    {
                        break;
                    }
                }
            }
            if (isEndSeen)
            {
                break;
            }
        } /* end while loop */
        if(isErr)
        {
            return null;
        }
        else
        {
            return osb_out.toString();
        }
    }

    public static String encode(String toEncode)
    {
        String hexChars = "0123456789ABCDEF";
        String charsOk = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789&=";
        char i, j;
        StringBuffer code = new StringBuffer();
        int   inc;

        for (inc = 0; inc < toEncode.length();inc++)
        {
            if (toEncode.charAt(inc) == ' ')
                code.append('+');
            else
                if(charsOk.indexOf(toEncode.charAt(inc)) == -1)
                {
                    code.append( '%');
                    code.append( hexChars.charAt((toEncode.charAt(inc)&0xFF)/16));
                    code.append(hexChars.charAt((toEncode.charAt(inc)&0xFF)%16));
                }
                else
                {
                    code.append(toEncode.charAt(inc));
                }
        }
        return code.toString();
    }

}