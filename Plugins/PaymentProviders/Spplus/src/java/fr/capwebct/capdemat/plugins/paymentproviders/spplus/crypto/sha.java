/*--- formatted by Jindent 2.1, (www.c-lab.de/~jindent) ---*/

package fr.capwebct.capdemat.plugins.paymentproviders.spplus.crypto;
import fr.capwebct.capdemat.plugins.paymentproviders.spplus.utils.DoubleWord;

import java.lang.StringBuffer;
import java.util.StringTokenizer;

/**
 * Class declaration
 *
 *
 * @author
 * @version %I%, %G%
 */
public class sha
{
    private DoubleWord[]   W64 = new DoubleWord[80];		/* Word Input Sequence */
    private DoubleWord[]   H64 = new DoubleWord[5];		/* 160 Bits Message Digest */
    private DoubleWord		A64;
    private DoubleWord		B64;
    private DoubleWord		C64;
    private DoubleWord		D64;
    private DoubleWord		E64;						/* A, B, C, D, E Registers for 80 Rounds */

    /**
     * Method declaration
     *
     *
     * @param aString
     * @param len
     *
     * @return
     *
     * @see
     */
    public int[] proceed(int[] aString, int len)
    {
        int		iter;		/* Number of 512 Bits Blocks */
        int		lg;			/* Length To Process */
        DoubleWord val;		/* Temporary Value */
        int		i;			/* Item Loop */
        int[]   lastBlock = new int[64];
        String  Output = "";

        /* 1. Initialization */
        H64[0] = new DoubleWord("67452301");
        H64[1] = new DoubleWord("EFCDAB89");
        H64[2] = new DoubleWord("98BADCFE");
        H64[3] = new DoubleWord("10325476");
        H64[4] = new DoubleWord("C3D2E1F0");

        for (i = 0; i < 80; i++)
        {
            W64[i] = new DoubleWord(0);
        }

        DoubleWord tempo = new DoubleWord((long)len);

        iter = tempo.add(72).RShift(6).toInt();

        int		peind = 0;
        int[]   pe = aString;

        /* 2. Message Block Processing */
        for (lg = len; iter > 0; iter--, lg -= 64)
        {

            /* 2.1 Message Padding */
            if (lg < 64)
            {
                reset(lastBlock);

                if (lg > 0)
                {
                    copy(lastBlock, pe, peind, lg);
                }

                if (lg >= 0)
                {
                    lastBlock[lg] = 0x80;
                }

                if (lg <= 55)
                {
                    lastBlock[61] = tempo.RShift(13).toInt();
                    lastBlock[62] = tempo.RShift(5).toInt();
                    lastBlock[63] = tempo.LShift(3).toInt();
                }

                pe = lastBlock;
                peind = 0;
            }

            /* 2.2 Divide Mi Into W0,...,W15 (step a) */
            for (i = 0; i < 64; i++)
            {
                W64[i >> 2] = W64[i >> 2].LShift(8).add(pe[peind++] & 0xFFL);
            }

            /* 2.3 Processing W16 To W79 - Init A To E (step b c) */
            for (i = 16; i < 80; i++)
            {
                val =
                    W64[i - 3].xor(W64[i - 8]).xor(W64[i - 14]).xor(W64[i - 16]);
                W64[i] = val.LShift(1).add(val.RShift(31));
            }

            A64 = H64[0];
            B64 = H64[1];
            C64 = H64[2];
            D64 = H64[3];
            E64 = H64[4];

            /* 2.4 Round 0 To 79 (step d) */
            for (i = 0; i < 20; i++)
            {
                val =
                    A64.LShift(5).add(A64.RShift(27)).add((B64.and(C64)).or((B64.not()).and(D64))).add(E64).add(W64[i]).add(new DoubleWord("5A827999"));
                E64 = D64;
                D64 = C64;
                C64 = B64.LShift(30).add(B64.RShift(2));
                B64 = A64;
                A64 = val;
            }

            for (; i < 40; i++)
            {
                val =
                    A64.LShift(5).add(A64.RShift(27)).add(B64.xor(C64).xor(D64)).add(E64).add(W64[i]).add(new DoubleWord("6ED9EBA1"));
                E64 = D64;
                D64 = C64;
                C64 = B64.LShift(30).add(B64.RShift(2));
                B64 = A64;
                A64 = val;
            }

            for (; i < 60; i++)
            {
                val =
                    A64.LShift(5).add(A64.RShift(27)).add((B64.and(C64)).or(B64.and(D64)).or(C64.and(D64))).add(E64).add(W64[i]).add(new DoubleWord("8F1BBCDC"));
                E64 = D64;
                D64 = C64;
                C64 = B64.LShift(30).add(B64.RShift(2));
                B64 = A64;
                A64 = val;
            }

            for (; i < 80; i++)
            {
                val =
                    A64.LShift(5).add(A64.RShift(27)).add((B64.xor(C64).xor(D64))).add(E64).add(W64[i]).add(new DoubleWord("CA62C1D6"));
                E64 = D64;
                D64 = C64;
                C64 = B64.LShift(30).add(B64.RShift(2));
                B64 = A64;
                A64 = val;
            }

            /* 2.5 Update Digest (step e) */
            H64[0] = H64[0].add(A64);
            H64[1] = H64[1].add(B64);
            H64[2] = H64[2].add(C64);
            H64[3] = H64[3].add(D64);
            H64[4] = H64[4].add(E64);
        }

        /* 3. Message Digest */
        int[]   pe2 = new int[20];

        for (i = 19; i >= 0; i--)
        {
            pe2[i] = H64[i >> 2].and(new DoubleWord("FF")).toInt();
            H64[i >> 2] = H64[i >> 2].RShift(8);
        }

        return (pe2);
    }

    /**
     * Method declaration
     *
     *
     * @param key
     * @param size
     * @param Source
     *
     * @return
     *
     * @see
     */
    public int[] Hmac(int[] key, int size, String Source)
    {
        String  pad;	/* Padding */
        int		i;		/* Item Loop */
        int[]   b_buf = new int[1064];
        byte[]  source_b = Source.getBytes();
        int[]   b_source = new int[source_b.length];

        for (i = 0; i < source_b.length; i++)
        {
            b_source[i] = source_b[i];
        }

        for (i = 0; i < 64; i++)
        {
            b_buf[i] = 0x36;
        }

        for (i = 0; i < size; i++)
        {
            DoubleWord tempo1 = new DoubleWord(b_buf[i] & 0xffL);
            DoubleWord tempo2 = new DoubleWord(key[i] & 0xffL);

            b_buf[i] = tempo1.xor(tempo2).toInt();
        }

        for (i = 64; i < 64 + b_source.length; i++)
        {
            b_buf[i] = b_source[i - 64];
        }

        int[]   b_return = proceed(b_buf, 64 + Source.length());
        for (i = 64; i < 64 + b_return.length; i++)
        {
            b_buf[i] = b_return[i - 64];
        }

        for (i = 0; i < 64; i++)
        {
            b_buf[i] = 0x5C;
        }

        for (i = 0; i < size; i++)
        {
            DoubleWord tempo1 = new DoubleWord(b_buf[i] & 0xffl);
            DoubleWord tempo2 = new DoubleWord(key[i] & 0xffl);

            b_buf[i] = tempo1.xor(tempo2).toInt();
        }
        return (proceed(b_buf, 84));
    }

    /**
     * Method declaration
     *
     *
     * @param hmacInHexa
     *
     * @return
     *
     * @see
     */
    public String ConvertInAsciiStream(int[] hmacInHexa)
    {
        int				i;		/* Item Loop */
        char			v;
        StringBuffer	returnval = new StringBuffer("");

        for (i = 0; i < hmacInHexa.length; i++)
        {
            v = (char) (hmacInHexa[i] >> 4);

            if (v > 9)
            {
                returnval.append((char) (v + 0x37));
            }
            else
            {
                returnval.append((char) (v + 0x30));
            }

            v = (char) (hmacInHexa[i++] & 0x0f);

            if (v > 9)
            {
                returnval.append((char) (v + 0x37));
            }
            else
            {
                returnval.append((char) (v + 0x30));
            }
        }

        return (returnval.toString());
    }

    static final String hexDigitChars = "0123456789ABCDEF";

    /**
     * Method declaration
     *
     *
     * @param a
     *
     * @return
     *
     * @see
     */
    public String hmacToString(int[] a)
    {
        int				hn, ln;
        int				cx;
        StringBuffer	buf = new StringBuffer(a.length * 2);

        for (cx = 0; cx < a.length; cx++)
        {
            hn = ((int) (a[cx]) & 0x00ff) / 16;
            ln = ((int) (a[cx]) & 0x000f);

            buf.append(hexDigitChars.charAt(hn));
            buf.append(hexDigitChars.charAt(ln));
        }

        return buf.toString();
    }

    /**
     * Method declaration
     *
     *
     * @param toreset
     *
     * @see
     */
    public void reset(int[] toreset)
    {
        for (int i = 0; i < toreset.length; i++)
        {
            toreset[i] = 0;
        }
    }

    /**
     * Method declaration
     *
     *
     * @param dest
     * @param source
     * @param index
     *
     * @return
     *
     * @see
     */
    public int[] append(int[] dest, int[] source, int index)
    {
        int[]   result = new int[dest.length + source.length];

        for (int i = 0; i < dest.length; i++)
        {
            result[i] = dest[i];
        }

        for (int i = 0; i < source.length; i++)
        {
            result[i + index] = source[i];
        }

        return result;
    }

    /**
     * Method declaration
     *
     *
     * @param dest
     * @param source
     * @param from
     * @param number
     *
     * @see
     */
    public void copy(int[] dest, int[] source, int from, int number)
    {
        for (int i = 0; i < number; i++)
        {
            dest[i] = source[i + from];
        }
    }

    /**
     * Method declaration
     *
     *
     * @param theKey a String containing the trader key
     *
     * @Return an int array containing the key
     * @see
     */
    public int[] keyToInt(String theKey)
    {
        StringTokenizer ost_keyExploder = new StringTokenizer(theKey," ");
        int[] key = new int[ost_keyExploder.countTokens()];
        int i =0;
        while(ost_keyExploder.hasMoreElements())
        {
            String component = ost_keyExploder.nextToken().toUpperCase();
            key[i++] = hexDigitChars.indexOf(component.charAt(0))*16+hexDigitChars.indexOf(component.charAt(1));
        }
        return key;
    }

    public String calculHmac(String key, int dataLength, String data)
    {
        des		d1 = new des();
        // Convert key to int array
        int[] merkey = keyToInt(key);

        // Generate a Des key
        int [] ks = genks.GenKs(this);
        // decrypt Cipher Bloc Chaining
        merkey = d1.DecryptCBC(ks, merkey);
        int[]   hmacAsIntArray = Hmac(merkey, dataLength, data);
        // Convert hmac to string (value that should be sent to SPPLUS payment server)
        return hmacToString(hmacAsIntArray);
    }

}
// End of class sha


/*--- formatting done in "Sun Java Convention" style on 04-10-2003 ---*/