/*--- formatted by Jindent 2.1, (www.c-lab.de/~jindent) ---*/

package fr.capwebct.capdemat.plugins.paymentproviders.spplus.crypto;
import fr.capwebct.capdemat.plugins.paymentproviders.spplus.utils.DoubleWord;

/**
 * Titre :
 * Description :
 * Copyright :    Copyright (c) 2003
 * Société :
 * @author
 * @version 1.0
 */
public class des
{
    private static DoubleWord  M28 = new DoubleWord("FFFFFFF0");
    private static DoubleWord  B01 = new DoubleWord("80000000");
    private static DoubleWord  B02 = new DoubleWord("40000000");
    private static DoubleWord  B03 = new DoubleWord("20000000");
    private static DoubleWord  B04 = new DoubleWord("10000000");
    private static DoubleWord  B05 = new DoubleWord("8000000");
    private static DoubleWord  B06 = new DoubleWord("4000000");
    private static DoubleWord  B07 = new DoubleWord("2000000");
    private static DoubleWord  B08 = new DoubleWord("1000000");
    private static DoubleWord  B09 = new DoubleWord("800000");
    private static DoubleWord  B10 = new DoubleWord("400000");
    private static DoubleWord  B11 = new DoubleWord("200000");
    private static DoubleWord  B12 = new DoubleWord("100000");
    private static DoubleWord  B13 = new DoubleWord("80000");
    private static DoubleWord  B14 = new DoubleWord("40000");
    private static DoubleWord  B15 = new DoubleWord("20000");
    private static DoubleWord  B16 = new DoubleWord("10000");
    private static DoubleWord  B17 = new DoubleWord("8000");
    private static DoubleWord  B18 = new DoubleWord("4000");
    private static DoubleWord  B19 = new DoubleWord("2000");
    private static DoubleWord  B20 = new DoubleWord("1000");
    private static DoubleWord  B21 = new DoubleWord("800");
    private static DoubleWord  B22 = new DoubleWord("400");
    private static DoubleWord  B23 = new DoubleWord("200");
    private static DoubleWord  B24 = new DoubleWord("100");
    private static DoubleWord  B25 = new DoubleWord("80");
    private static DoubleWord  B26 = new DoubleWord("40");
    private static DoubleWord  B27 = new DoubleWord("20");
    private static DoubleWord  B28 = new DoubleWord("10");
    private static DoubleWord  B29 = new DoubleWord("8");
    private static DoubleWord  B30 = new DoubleWord("4");
    private static DoubleWord  B31 = new DoubleWord("2");
    private static DoubleWord  B32 = new DoubleWord("1");
    private DoubleWord			s1[] =
          {		/* 1ere table de substitution de 6 bits en 4 : b4=s[b6] */
        new DoubleWord("E"), new DoubleWord("0"), new DoubleWord("4"),
        new DoubleWord("F"), new DoubleWord("D"), new DoubleWord("7"),
        new DoubleWord("1"), new DoubleWord("4"), new DoubleWord("2"),
        new DoubleWord("E"), new DoubleWord("F"), new DoubleWord("2"),
        new DoubleWord("B"), new DoubleWord("D"), new DoubleWord("8"),
        new DoubleWord("1"), new DoubleWord("3"), new DoubleWord("A"),
        new DoubleWord("A"), new DoubleWord("6"), new DoubleWord("6"),
        new DoubleWord("C"), new DoubleWord("C"), new DoubleWord("B"),
        new DoubleWord("5"), new DoubleWord("9"), new DoubleWord("9"),
        new DoubleWord("5"), new DoubleWord("0"), new DoubleWord("3"),
        new DoubleWord("7"), new DoubleWord("8"), new DoubleWord("4"),
        new DoubleWord("F"), new DoubleWord("1"), new DoubleWord("C"),
        new DoubleWord("E"), new DoubleWord("8"), new DoubleWord("8"),
        new DoubleWord("2"), new DoubleWord("D"), new DoubleWord("4"),
        new DoubleWord("6"), new DoubleWord("9"), new DoubleWord("2"),
        new DoubleWord("1"), new DoubleWord("B"), new DoubleWord("7"),
        new DoubleWord("F"), new DoubleWord("5"), new DoubleWord("C"),
        new DoubleWord("B"), new DoubleWord("9"), new DoubleWord("3"),
        new DoubleWord("7"), new DoubleWord("E"), new DoubleWord("3"),
        new DoubleWord("A"), new DoubleWord("A"), new DoubleWord("0"),
        new DoubleWord("5"), new DoubleWord("6"), new DoubleWord("0"), new DoubleWord("D")
    };
    private DoubleWord			s2[] =
	{                                                                                       		/* 2eme table de substitution de 6 bits en 4 : b4=s[b6] */
        new DoubleWord("F"), new DoubleWord("3"), new DoubleWord("1"),
        new DoubleWord("D"), new DoubleWord("8"), new DoubleWord("4"),
        new DoubleWord("E"), new DoubleWord("7"), new DoubleWord("6"),
        new DoubleWord("F"), new DoubleWord("B"), new DoubleWord("2"),
        new DoubleWord("3"), new DoubleWord("8"), new DoubleWord("4"),
        new DoubleWord("E"), new DoubleWord("9"), new DoubleWord("C"),
        new DoubleWord("7"), new DoubleWord("0"), new DoubleWord("2"),
        new DoubleWord("1"), new DoubleWord("D"), new DoubleWord("A"),
        new DoubleWord("C"), new DoubleWord("6"), new DoubleWord("0"),
        new DoubleWord("9"), new DoubleWord("5"), new DoubleWord("B"),
        new DoubleWord("A"), new DoubleWord("5"), new DoubleWord("0"),
        new DoubleWord("D"), new DoubleWord("E"), new DoubleWord("8"),
        new DoubleWord("7"), new DoubleWord("A"), new DoubleWord("B"),
        new DoubleWord("1"), new DoubleWord("A"), new DoubleWord("3"),
        new DoubleWord("4"), new DoubleWord("F"), new DoubleWord("D"),
        new DoubleWord("4"), new DoubleWord("1"), new DoubleWord("2"),
        new DoubleWord("5"), new DoubleWord("B"), new DoubleWord("8"),
        new DoubleWord("6"), new DoubleWord("C"), new DoubleWord("7"),
        new DoubleWord("6"), new DoubleWord("C"), new DoubleWord("9"),
        new DoubleWord("0"), new DoubleWord("3"), new DoubleWord("5"),
        new DoubleWord("2"), new DoubleWord("E"), new DoubleWord("F"), new DoubleWord("9")
    };
    private DoubleWord			s3[] =
	{                                                                                       		/* 3eme table de substitution de 6 bits en 4 : b4=s[b6] */
        new DoubleWord("A"), new DoubleWord("D"), new DoubleWord("0"),
        new DoubleWord("7"), new DoubleWord("9"), new DoubleWord("0"),
        new DoubleWord("E"), new DoubleWord("9"), new DoubleWord("6"),
        new DoubleWord("3"), new DoubleWord("3"), new DoubleWord("4"),
        new DoubleWord("F"), new DoubleWord("6"), new DoubleWord("5"),
        new DoubleWord("A"), new DoubleWord("1"), new DoubleWord("2"),
        new DoubleWord("D"), new DoubleWord("8"), new DoubleWord("C"),
        new DoubleWord("5"), new DoubleWord("7"), new DoubleWord("E"),
        new DoubleWord("B"), new DoubleWord("C"), new DoubleWord("4"),
        new DoubleWord("B"), new DoubleWord("2"), new DoubleWord("F"),
        new DoubleWord("8"), new DoubleWord("1"), new DoubleWord("D"),
        new DoubleWord("1"), new DoubleWord("6"), new DoubleWord("A"),
        new DoubleWord("4"), new DoubleWord("D"), new DoubleWord("9"),
        new DoubleWord("0"), new DoubleWord("8"), new DoubleWord("6"),
        new DoubleWord("F"), new DoubleWord("9"), new DoubleWord("3"),
        new DoubleWord("8"), new DoubleWord("0"), new DoubleWord("7"),
        new DoubleWord("B"), new DoubleWord("4"), new DoubleWord("1"),
        new DoubleWord("F"), new DoubleWord("2"), new DoubleWord("E"),
        new DoubleWord("C"), new DoubleWord("3"), new DoubleWord("5"),
        new DoubleWord("B"), new DoubleWord("A"), new DoubleWord("5"),
        new DoubleWord("E"), new DoubleWord("2"), new DoubleWord("7"), new DoubleWord("C")
    };
    private DoubleWord			s4[] =
	{                                                                                       		/* 4eme table de substitution de 6 bits en 4 : b4=s[b6] */
        new DoubleWord("7"), new DoubleWord("D"), new DoubleWord("D"),
        new DoubleWord("8"), new DoubleWord("E"), new DoubleWord("B"),
        new DoubleWord("3"), new DoubleWord("5"), new DoubleWord("0"),
        new DoubleWord("6"), new DoubleWord("6"), new DoubleWord("F"),
        new DoubleWord("9"), new DoubleWord("0"), new DoubleWord("A"),
        new DoubleWord("3"), new DoubleWord("1"), new DoubleWord("4"),
        new DoubleWord("2"), new DoubleWord("7"), new DoubleWord("8"),
        new DoubleWord("2"), new DoubleWord("5"), new DoubleWord("C"),
        new DoubleWord("B"), new DoubleWord("1"), new DoubleWord("C"),
        new DoubleWord("A"), new DoubleWord("4"), new DoubleWord("E"),
        new DoubleWord("F"), new DoubleWord("9"), new DoubleWord("A"),
        new DoubleWord("3"), new DoubleWord("6"), new DoubleWord("F"),
        new DoubleWord("9"), new DoubleWord("0"), new DoubleWord("0"),
        new DoubleWord("6"), new DoubleWord("C"), new DoubleWord("A"),
        new DoubleWord("B"), new DoubleWord("1"), new DoubleWord("7"),
        new DoubleWord("D"), new DoubleWord("D"), new DoubleWord("8"),
        new DoubleWord("F"), new DoubleWord("9"), new DoubleWord("1"),
        new DoubleWord("4"), new DoubleWord("3"), new DoubleWord("5"),
        new DoubleWord("E"), new DoubleWord("B"), new DoubleWord("5"),
        new DoubleWord("C"), new DoubleWord("2"), new DoubleWord("7"),
        new DoubleWord("8"), new DoubleWord("2"), new DoubleWord("4"), new DoubleWord("E")
    };
    private DoubleWord			s5[] =
	{                                                                                       		/* 5eme table de substitution de 6 bits en 4 : b4=s[b6] */
        new DoubleWord("2"), new DoubleWord("E"), new DoubleWord("C"),
        new DoubleWord("B"), new DoubleWord("4"), new DoubleWord("2"),
        new DoubleWord("1"), new DoubleWord("C"), new DoubleWord("7"),
        new DoubleWord("4"), new DoubleWord("A"), new DoubleWord("7"),
        new DoubleWord("B"), new DoubleWord("D"), new DoubleWord("6"),
        new DoubleWord("1"), new DoubleWord("8"), new DoubleWord("5"),
        new DoubleWord("5"), new DoubleWord("0"), new DoubleWord("3"),
        new DoubleWord("F"), new DoubleWord("F"), new DoubleWord("A"),
        new DoubleWord("D"), new DoubleWord("3"), new DoubleWord("0"),
        new DoubleWord("9"), new DoubleWord("E"), new DoubleWord("8"),
        new DoubleWord("9"), new DoubleWord("6"), new DoubleWord("4"),
        new DoubleWord("B"), new DoubleWord("2"), new DoubleWord("8"),
        new DoubleWord("1"), new DoubleWord("C"), new DoubleWord("B"),
        new DoubleWord("7"), new DoubleWord("A"), new DoubleWord("1"),
        new DoubleWord("D"), new DoubleWord("E"), new DoubleWord("7"),
        new DoubleWord("2"), new DoubleWord("8"), new DoubleWord("D"),
        new DoubleWord("F"), new DoubleWord("6"), new DoubleWord("9"),
        new DoubleWord("F"), new DoubleWord("C"), new DoubleWord("0"),
        new DoubleWord("5"), new DoubleWord("9"), new DoubleWord("6"),
        new DoubleWord("A"), new DoubleWord("3"), new DoubleWord("4"),
        new DoubleWord("0"), new DoubleWord("5"), new DoubleWord("E"), new DoubleWord("3")
    };
    private DoubleWord			s6[] =
	{                                                                                       		/* 6eme table de substitution de 6 bits en 4 : b4=s[b6] */
        new DoubleWord("C"), new DoubleWord("A"), new DoubleWord("1"),
        new DoubleWord("F"), new DoubleWord("A"), new DoubleWord("4"),
        new DoubleWord("F"), new DoubleWord("2"), new DoubleWord("9"),
        new DoubleWord("7"), new DoubleWord("2"), new DoubleWord("C"),
        new DoubleWord("6"), new DoubleWord("9"), new DoubleWord("8"),
        new DoubleWord("5"), new DoubleWord("0"), new DoubleWord("6"),
        new DoubleWord("D"), new DoubleWord("1"), new DoubleWord("3"),
        new DoubleWord("D"), new DoubleWord("4"), new DoubleWord("E"),
        new DoubleWord("E"), new DoubleWord("0"), new DoubleWord("7"),
        new DoubleWord("B"), new DoubleWord("5"), new DoubleWord("3"),
        new DoubleWord("B"), new DoubleWord("8"), new DoubleWord("9"),
        new DoubleWord("4"), new DoubleWord("E"), new DoubleWord("3"),
        new DoubleWord("F"), new DoubleWord("2"), new DoubleWord("5"),
        new DoubleWord("C"), new DoubleWord("2"), new DoubleWord("9"),
        new DoubleWord("8"), new DoubleWord("5"), new DoubleWord("C"),
        new DoubleWord("F"), new DoubleWord("3"), new DoubleWord("A"),
        new DoubleWord("7"), new DoubleWord("B"), new DoubleWord("0"),
        new DoubleWord("E"), new DoubleWord("4"), new DoubleWord("1"),
        new DoubleWord("A"), new DoubleWord("7"), new DoubleWord("1"),
        new DoubleWord("6"), new DoubleWord("D"), new DoubleWord("0"),
        new DoubleWord("B"), new DoubleWord("8"), new DoubleWord("6"), new DoubleWord("D")
    };
    private DoubleWord			s7[] =
	{                                                                                       		/* 7eme table de substitution de 6 bits en 4 : b4=s[b6] */
        new DoubleWord("4"), new DoubleWord("D"), new DoubleWord("B"),
        new DoubleWord("0"), new DoubleWord("2"), new DoubleWord("B"),
        new DoubleWord("E"), new DoubleWord("7"), new DoubleWord("F"),
        new DoubleWord("4"), new DoubleWord("0"), new DoubleWord("9"),
        new DoubleWord("8"), new DoubleWord("1"), new DoubleWord("D"),
        new DoubleWord("A"), new DoubleWord("3"), new DoubleWord("E"),
        new DoubleWord("C"), new DoubleWord("3"), new DoubleWord("9"),
        new DoubleWord("5"), new DoubleWord("7"), new DoubleWord("C"),
        new DoubleWord("5"), new DoubleWord("2"), new DoubleWord("A"),
        new DoubleWord("F"), new DoubleWord("6"), new DoubleWord("8"),
        new DoubleWord("1"), new DoubleWord("6"), new DoubleWord("1"),
        new DoubleWord("6"), new DoubleWord("4"), new DoubleWord("B"),
        new DoubleWord("B"), new DoubleWord("D"), new DoubleWord("D"),
        new DoubleWord("8"), new DoubleWord("C"), new DoubleWord("1"),
        new DoubleWord("3"), new DoubleWord("4"), new DoubleWord("7"),
        new DoubleWord("A"), new DoubleWord("E"), new DoubleWord("7"),
        new DoubleWord("A"), new DoubleWord("9"), new DoubleWord("F"),
        new DoubleWord("5"), new DoubleWord("6"), new DoubleWord("0"),
        new DoubleWord("8"), new DoubleWord("F"), new DoubleWord("0"),
        new DoubleWord("E"), new DoubleWord("5"), new DoubleWord("2"),
        new DoubleWord("9"), new DoubleWord("3"), new DoubleWord("2"), new DoubleWord("C")
    };
    private DoubleWord			s8[] =
	{                                                                                       		/* 8eme table de substitution de 6 bits en 4 : b4=s[b6] */
        new DoubleWord("D"), new DoubleWord("1"), new DoubleWord("2"),
        new DoubleWord("F"), new DoubleWord("8"), new DoubleWord("D"),
        new DoubleWord("4"), new DoubleWord("8"), new DoubleWord("6"),
        new DoubleWord("A"), new DoubleWord("F"), new DoubleWord("3"),
        new DoubleWord("B"), new DoubleWord("7"), new DoubleWord("1"),
        new DoubleWord("4"), new DoubleWord("A"), new DoubleWord("C"),
        new DoubleWord("9"), new DoubleWord("5"), new DoubleWord("3"),
        new DoubleWord("6"), new DoubleWord("E"), new DoubleWord("B"),
        new DoubleWord("5"), new DoubleWord("0"), new DoubleWord("0"),
        new DoubleWord("E"), new DoubleWord("C"), new DoubleWord("9"),
        new DoubleWord("7"), new DoubleWord("2"), new DoubleWord("7"),
        new DoubleWord("2"), new DoubleWord("B"), new DoubleWord("1"),
        new DoubleWord("4"), new DoubleWord("E"), new DoubleWord("1"),
        new DoubleWord("7"), new DoubleWord("9"), new DoubleWord("4"),
        new DoubleWord("C"), new DoubleWord("A"), new DoubleWord("E"),
        new DoubleWord("8"), new DoubleWord("2"), new DoubleWord("D"),
        new DoubleWord("0"), new DoubleWord("F"), new DoubleWord("6"),
        new DoubleWord("C"), new DoubleWord("A"), new DoubleWord("9"),
        new DoubleWord("D"), new DoubleWord("0"), new DoubleWord("F"),
        new DoubleWord("3"), new DoubleWord("3"), new DoubleWord("5"),
        new DoubleWord("5"), new DoubleWord("6"), new DoubleWord("8"), new DoubleWord("B")
    };
    private int				vect[] =
    {
        '0', 'x', '0', 'b', ',', '0', 'x', '0', 'b', ',', '0', 'x', '0', 'b',
        ',', '0', 'x', '0', 'b', ',', '0', 'x', '0', 'b', ',', '0', 'x', '0',
        'b', ',', '0', 'x', '0', 'b', ',', '0', 'x', '0', 'b'
    };		/* vecteur */
    private long[][]		c64 =
        new long[2][16];	/* 16 cles intermediaires de 48 bits, cadrees a gauche */

    /**
     * Method declaration
     *
     *
     * @param in
     * @param key
     *
     * @return
     *
     * @see
     */
    public int[] DesEncrypt64(int[] in, int[] key, int begin)
    {
        DoubleWord		cra = new DoubleWord("0"),
                        crb = new DoubleWord("0");		/* DES Entry */
        long			cha = 0, chb = 0;			/* DES Output */
        DoubleWord			cla = new DoubleWord("0"),
                        clb = new DoubleWord("0");		/* DES key */
        int				i;							/* Item Loop */
        int				j = 0;
        StringBuffer	out = new StringBuffer();

        /* 1. Convert to type4 */
        for (i = 4; i > 0; i--)
        {
            cra = cra.LShift(8).add(in[begin + j++]);
        }

        for (i = 4; i > 0; i--)
        {
            crb = crb.LShift(8).add(in[begin + j++]);
        }

        j = 0;

        for (i = 4; i > 0; i--)
        {
            cla = cla.LShift(8).add(key[j++]);
        }

        for (i = 4; i > 0; i--)
        {
            clb = clb.LShift(8).add(key[j++]);
        }

        /* 2. Encrypt */
        long[]  ch = des64(cra.toLong(), crb.toLong(), cla.toLong(),
                            clb.toLong());

        DoubleWord temp1 = new DoubleWord(ch[0]);
        DoubleWord temp2 = new DoubleWord(ch[1]);
        int[]   l_out = new int[8];

        l_out[0] = temp1.getHigh() & 0xff;
        l_out[1] = temp1.getMidHigh() & 0xff;
        l_out[2] = temp1.getMidLow() & 0xff;
        l_out[3] = temp1.getLow() & 0xff;
        l_out[4] = temp2.getHigh() & 0xff;
        l_out[5] = temp2.getMidHigh() & 0xff;
        l_out[6] = temp2.getMidLow() & 0xff;
        l_out[7] = temp2.getLow() & 0xff;

        return l_out;
    }

    /**
     * Method declaration
     *
     *
     * @param in
     * @param key
     * @param begin
     *
     * @return
     *
     * @see
     */
    public int[] DesDecrypt64(int[] in, int[] key, int begin)
    {
        DoubleWord		cra = new DoubleWord(0),
                        crb = new DoubleWord(0);		/* DES Entry */
        int				cha = 0, chb = 0;			/* DES Output */
        DoubleWord			cla = new DoubleWord(0),
                        clb = new DoubleWord(0);		/* DES key */
        int				i;							/* Item Loop */
        int				j = 0;
        StringBuffer	out = new StringBuffer();

        /* 1. Convert to type4 */
        for (i = 4; i > 0; i--)
        {
            cra = cra.LShift(8).add(in[begin + j++]);
        }

        for (i = 4; i > 0; i--)
        {
            crb = crb.LShift(8).add(in[begin + j++]);
        }

        j = 0;

        for (i = 4; i > 0; i--)
        {
            cla = cla.LShift(8).add(key[j++]);
        }

        for (i = 4; i > 0; i--)
        {
            clb = clb.LShift(8).add(key[j++]);
        }

        /* 2. Encrypt */
        long[]  ch = invdes64(cra.toLong(), crb.toLong(), cla.toLong(),
                              clb.toLong());

        /* 3. Convert to uchar */
        DoubleWord temp1 = new DoubleWord(ch[0]);
        DoubleWord temp2 = new DoubleWord(ch[1]);
        int[]   l_out = new int[8];

        l_out[0] = temp1.getHigh() & 0xff;
        l_out[1] = temp1.getMidHigh() & 0xff;
        l_out[2] = temp1.getMidLow() & 0xff;
        l_out[3] = temp1.getLow() & 0xff;
        l_out[4] = temp2.getHigh() & 0xff;
        l_out[5] = temp2.getMidHigh() & 0xff;
        l_out[6] = temp2.getMidLow() & 0xff;
        l_out[7] = temp2.getLow() & 0xff;

        return l_out;
    }

    /**
     * Method declaration
     *
     *
     * @param cle
     * @param msg
     *
     * @return
     *
     * @see
     */
    public int[] DecryptCBC(int[] cle, int[] msg)
    {
        int		i;						/* Item Loop */
        int		j = 0;
        int[]   vct = new int[8];		/* Vector */
        int[]   ivs = new int[8];		/* Initial Vector */
        int[]   msgl = new int[msg.length];

        for (i = 0; i < msg.length; i++)
        {
            msgl[i] = msg[i];
        }

        int lng = msgl.length;

        for (i = 0; i < 8; i++)
        {
            ivs[i] = vect[i];
        }

        for (lng = msgl.length; lng > 0; lng -= 8, j += 8)
        {
            for (i = 0; i < 8 && i + j < msgl.length; i++)
            {
                vct[i] = msgl[i + j];
            }

            int[]   res = DesDecrypt64(msgl, cle, j);

            for (i = 0; i < res.length && i + j < msgl.length; i++)
            {
                msgl[i + j] = res[i];
            }

            for (i = 0; (i < lng) && (i < 8) && i + j < msgl.length; i++)
            {
                DoubleWord tempo1 = new DoubleWord(msgl[j + i]);
                DoubleWord tempo2 = new DoubleWord(ivs[i]);

                msgl[j + i] = tempo1.xor(tempo2).toInt();
            }

            for (i = 0; i < 8; i++)
            {
                ivs[i] = vct[i];
            }
        }

        return msgl;
    }

    /**
     * Method declaration
     *
     *
     * @param cle
     * @param msg
     *
     * @see
     */
    public void EncryptCBC(int[] cle, int[] msg)
    {
        int		i;						/* Item Loop */
        int[]   vct = new int[8];		/* Vector */
        int		j = 0;
        int		lng = msg.length;

        for (i = 0; i < 8; i++)
        {
            vct[i] = vect[i];
        }

        for (; lng > 0; lng -= 8, j += 8)
        {
            for (i = 0; (i < lng) && (i < 8); i++)
            {
                DoubleWord tempo = new DoubleWord(msg[j + i] & 0xffL);
                DoubleWord tempo2 = new DoubleWord(vct[i] & 0xFFL);

                msg[j + i] = tempo.xor(tempo2).toInt();
            }

            int[] res = DesEncrypt64(msg, cle, j);
            for (i = 0; i < res.length && i + j < msg.length; i++)
            {
                msg[i + j] = res[i];
            }

            for (i = 0; i < 8; i++)
            {
                vct[i] = msg[i + j];
            }
        }
    }

    /*
     * --------------------------------------------------------------
     * des64()
     * --------------------------------------------------------------
     * Chiffrement d'un bloc de 64 bits par une cle de 64 bits
     *
     * Entree  :	b1b2	(bloc de 64 bits)
     * c1c2	(bloc de 64 bits)
     * Sortie  :	s1s2	(bloc chiffre de 64 bits)
     *
     */

    /**
     * Method declaration
     *
     *
     * @param b1
     * @param b2
     * @param c1
     * @param c2
     *
     * @return
     *
     * @see
     */
    public long[] des64(long b1, long b2, long c1, long c2)
    {
        long	x;
        short   i;

        calcles64(c1, c2);		/* calcul Des16 cles intermediaires */

        long[]  out = initperm64(b1, b2);		/* permutation initiale */

        for (i = 0; i < 16; i++)	/* 16 iterations */
        {
            x = out[0];
            out[0] = out[1];		/* echanger demis-bloc gauche et droit */
            out[1] =
                f64(out[1], c64[0][i],
                    c64[1][i]);		/* fonction f du bloc droit et de la cle */

            DoubleWord tempo1 = new DoubleWord(out[1]);
            DoubleWord tempo2 = new DoubleWord(x);

            out[1] =
                tempo1.xor(tempo2).toLong();	/* ou exclusif bloc gauche et resultat de f */
        }

        return finalperm64(out[1], out[0]);		/* permutation finale */
    }

    /*
     * --------------------------------------------------------------
     * invdes64()
     * --------------------------------------------------------------
     * Dechiffrement d'un bloc de 64 bits par une cle de 64 bits
     *
     * Entree  :	b1b2	(bloc chiffre de 64 bits)
     * c1c2	(bloc de 64 bits)
     * Sortie  :	s1s2	(bloc en clair de 64 bits)
     *
     */

    /**
     * Method declaration
     *
     *
     * @param b1
     * @param b2
     * @param c1
     * @param c2
     *
     * @return
     *
     * @see
     */
    public long[] invdes64(long b1, long b2, long c1, long c2)
    {
        long	l = 0, r = 0, x;
        int		i;

        calcles64(c1, c2);		/* calcul Des16 cles intermediaires */

        long[]  out = initperm64(b1, b2);		/* permutation initiale */

        for (i = 0; i < 16; i++)	/* 16 iterations */
        {
            x = out[0];
            out[0] = out[1];		/* echanger demis-bloc gauche et droit */
            out[1] =
                f64(out[1],
                    c64[0][15 - i],		/* fonction f du bloc droit et de la cle */
            c64[1][15 - i]);

            DoubleWord tempo = new DoubleWord(out[1]);
            DoubleWord tempo2 = new DoubleWord(x);

            out[1] =
                tempo.xor(tempo2).toLong();		/* ou exclusif bloc gauche et resultat de f */
        }

        return finalperm64(out[1], out[0]);		/* permutation finale */
    }

    /*
     * --------------------------------------------------------------
     * calcles64()
     * --------------------------------------------------------------
     * Calcul Des16 cles a partir de la cle initiale
     *
     * Entree  :	c1c2		(64 bits, 1 a 32, 33 a 64, parite paire)
     * Sortie  :	c[1][i]c[2][i]	(48 bits, 1 24,25 a 48, cadre a gauche,
     * i= 0 a 15)
     *
     * Permutation1 : c1-c2 (64 bits) --> bc-bd (56 bits, cadre a gauche)
     * Pour i= 1 a 16
     * Decalage gauche bc
     * Decalage gauche bd
     * Permutation2 : bc-bd (56 bits) --> c[0][i]c[1][i] (48 bits,
     * cadre a gauche)
     */

    /**
     * Method declaration
     *
     *
     * @param c1
     * @param c2
     *
     * @return
     *
     * @see
     */
    public short calcles64(long c1, long c2)
    {
        short   i;
        DoubleWord b1, b2;
        long[]  out = permut1v64(c1, c2);

        b1 = new DoubleWord(out[0]);
        b2 = new DoubleWord(out[1]);
        out[0] = b1.RShift(27).or(b1.LShift(1)).and(M28).toLong();
        out[1] = b2.RShift(27).or(b2.LShift(1)).and(M28).toLong();

        long[]  res = permut2v64(out[0], out[1]);

        c64[0][0] = res[0];
        c64[1][0] = res[1];
        b1 = new DoubleWord(out[0]);
        b2 = new DoubleWord(out[1]);
        out[0] = b1.RShift(27).or(b1.LShift(1)).and(M28).toLong();
        out[1] = b2.RShift(27).or(b2.LShift(1)).and(M28).toLong();
        res = permut2v64(out[0], out[1]);
        c64[0][1] = res[0];
        c64[1][1] = res[1];

        for (i = 2; i < 8; i++)
        {
            b1 = new DoubleWord(out[0]);
            b2 = new DoubleWord(out[1]);
            out[0] = b1.RShift(26).or(b1.LShift(2)).and(M28).toLong();
            out[1] = b2.RShift(26).or(b2.LShift(2)).and(M28).toLong();
            res = permut2v64(out[0], out[1]);
            c64[0][i] = res[0];
            c64[1][i] = res[1];
        }

        b1 = new DoubleWord(out[0]);
        b2 = new DoubleWord(out[1]);
        out[0] = b1.RShift(27).or(b1.LShift(1)).and(M28).toLong();
        out[1] = b2.RShift(27).or(b2.LShift(1)).and(M28).toLong();
        res = permut2v64(out[0], out[1]);
        c64[0][i] = res[0];
        c64[1][i] = res[1];

        for (i++; i < 15; i++)
        {
            b1 = new DoubleWord(out[0]);
            b2 = new DoubleWord(out[1]);
            out[0] = b1.RShift(26).or(b1.LShift(2)).and(M28).toLong();
            out[1] = b2.RShift(26).or(b2.LShift(2)).and(M28).toLong();
            res = permut2v64(out[0], out[1]);
            c64[0][i] = res[0];
            c64[1][i] = res[1];
        }

        b1 = new DoubleWord(out[0]);
        b2 = new DoubleWord(out[1]);
        out[0] = b1.RShift(27).or(b1.LShift(1)).and(M28).toLong();
        out[1] = b2.RShift(27).or(b2.LShift(1)).and(M28).toLong();
        res = permut2v64(out[0], out[1]);
        c64[0][i] = res[0];
        c64[1][i] = res[1];

        return (0);
    }

    /*
     * --------------------------------------------------------------
     * permut1v64()
     * --------------------------------------------------------------
     * Permutation Cle - choix 1
     *
     * Entree  :	e1e2 (64 bits, 1 a 32, 33 a 64)
     * Sortie  :	s1s2 (56 bits, 1 a 28, 29 a 56, cadre a gauche)
     *
     * t1...t64 --> t57...t4
     * s:1 (s1:1)	  =  e:57 (e2:25)     <==>  si e2:25=1	 alors s1:1=1
     * ...........
     * s:56 (s2:28)  =  e:4  (e1:4)      <==>  si e1:4=1	 alors s2:28=1
     */

    /**
     * Method declaration
     *
     *
     * @param pe1
     * @param pe2
     *
     * @return
     *
     * @see
     */
    public long[] permut1v64(long pe1, long pe2)
    {
        DoubleWord e1, e2, s1 = new DoubleWord(0), s2 = new DoubleWord(0);

        e1 = new DoubleWord(pe1);
        e2 = new DoubleWord(pe2);

        if (e2.and(B25).toInt() != 0)
        {
            s1 = s1.or(B01);
        }

        if (e2.and(B17).toInt() != 0)
        {
            s1 = s1.or(B02);
        }

        if (e2.and(B09).toInt() != 0)
        {
            s1 = s1.or(B03);
        }

        if (e2.and(B01).toInt() != 0)
        {
            s1 = s1.or(B04);
        }

        if (e2.and(B26).toInt() != 0)
        {
            s1 = s1.or(B09);
        }

        if (e2.and(B18).toInt() != 0)
        {
            s1 = s1.or(B10);
        }

        if (e2.and(B10).toInt() != 0)
        {
            s1 = s1.or(B11);
        }

        if (e2.and(B02).toInt() != 0)
        {
            s1 = s1.or(B12);
        }

        if (e2.and(B27).toInt() != 0)
        {
            s1 = s1.or(B17);
        }

        if (e2.and(B19).toInt() != 0)
        {
            s1 = s1.or(B18);
        }

        if (e2.and(B11).toInt() != 0)
        {
            s1 = s1.or(B19);
        }

        if (e2.and(B03).toInt() != 0)
        {
            s1 = s1.or(B20);
        }

        if (e2.and(B28).toInt() != 0)
        {
            s1 = s1.or(B25);
        }

        if (e2.and(B20).toInt() != 0)
        {
            s1 = s1.or(B26);
        }

        if (e2.and(B12).toInt() != 0)
        {
            s1 = s1.or(B27);
        }

        if (e2.and(B04).toInt() != 0)
        {
            s1 = s1.or(B28);
        }

        if (e2.and(B31).toInt() != 0)
        {
            s2 = s2.or(B01);
        }

        if (e2.and(B23).toInt() != 0)
        {
            s2 = s2.or(B02);
        }

        if (e2.and(B15).toInt() != 0)
        {
            s2 = s2.or(B03);
        }

        if (e2.and(B07).toInt() != 0)
        {
            s2 = s2.or(B04);
        }

        if (e2.and(B30).toInt() != 0)
        {
            s2 = s2.or(B09);
        }

        if (e2.and(B22).toInt() != 0)
        {
            s2 = s2.or(B10);
        }

        if (e2.and(B14).toInt() != 0)
        {
            s2 = s2.or(B11);
        }

        if (e2.and(B06).toInt() != 0)
        {
            s2 = s2.or(B12);
        }

        if (e2.and(B29).toInt() != 0)
        {
            s2 = s2.or(B17);
        }

        if (e2.and(B21).toInt() != 0)
        {
            s2 = s2.or(B18);
        }

        if (e2.and(B13).toInt() != 0)
        {
            s2 = s2.or(B19);
        }

        if (e2.and(B05).toInt() != 0)
        {
            s2 = s2.or(B20);
        }

        if (e1.and(B31).toInt() != 0)
        {
            s2 = s2.or(B05);
        }

        if (e1.and(B23).toInt() != 0)
        {
            s2 = s2.or(B06);
        }

        if (e1.and(B15).toInt() != 0)
        {
            s2 = s2.or(B07);
        }

        if (e1.and(B07).toInt() != 0)
        {
            s2 = s2.or(B08);
        }

        if (e1.and(B30).toInt() != 0)
        {
            s2 = s2.or(B13);
        }

        if (e1.and(B22).toInt() != 0)
        {
            s2 = s2.or(B14);
        }

        if (e1.and(B14).toInt() != 0)
        {
            s2 = s2.or(B15);
        }

        if (e1.and(B06).toInt() != 0)
        {
            s2 = s2.or(B16);
        }

        if (e1.and(B29).toInt() != 0)
        {
            s2 = s2.or(B21);
        }

        if (e1.and(B21).toInt() != 0)
        {
            s2 = s2.or(B22);
        }

        if (e1.and(B13).toInt() != 0)
        {
            s2 = s2.or(B23);
        }

        if (e1.and(B05).toInt() != 0)
        {
            s2 = s2.or(B24);
        }

        if (e1.and(B28).toInt() != 0)
        {
            s2 = s2.or(B25);
        }

        if (e1.and(B20).toInt() != 0)
        {
            s2 = s2.or(B26);
        }

        if (e1.and(B12).toInt() != 0)
        {
            s2 = s2.or(B27);
        }

        if (e1.and(B04).toInt() != 0)
        {
            s2 = s2.or(B28);
        }

        if (e1.and(B25).toInt() != 0)
        {
            s1 = s1.or(B05);
        }

        if (e1.and(B17).toInt() != 0)
        {
            s1 = s1.or(B06);
        }

        if (e1.and(B09).toInt() != 0)
        {
            s1 = s1.or(B07);
        }

        if (e1.and(B01).toInt() != 0)
        {
            s1 = s1.or(B08);
        }

        if (e1.and(B26).toInt() != 0)
        {
            s1 = s1.or(B13);
        }

        if (e1.and(B18).toInt() != 0)
        {
            s1 = s1.or(B14);
        }

        if (e1.and(B10).toInt() != 0)
        {
            s1 = s1.or(B15);
        }

        if (e1.and(B02).toInt() != 0)
        {
            s1 = s1.or(B16);
        }

        if (e1.and(B27).toInt() != 0)
        {
            s1 = s1.or(B21);
        }

        if (e1.and(B19).toInt() != 0)
        {
            s1 = s1.or(B22);
        }

        if (e1.and(B11).toInt() != 0)
        {
            s1 = s1.or(B23);
        }

        if (e1.and(B03).toInt() != 0)
        {
            s1 = s1.or(B24);
        }

        long[]  out = new long[2];

        out[0] = s1.toLong();
        out[1] = s2.toLong();

        return out;
    }

    /*
     * --------------------------------------------------------------
     * permut2v64()
     * --------------------------------------------------------------
     * Permutation Cle - choix 2
     *
     * Entree  :	e1e2 (56 bits, 1 a 28, 29 a 56, cadre a gauche)
     * Sortie  :	s1s2 (48 bits, 1 a 24, 25 a 48, cadre a gauche)
     *
     * t1...t56 --> t14...t32
     * s:1 (s1:1)	  =  e:14 (e1:14)     <==>  si e1:14=1	 alors s1:1=1
     * ...........
     * s:48 (s2:24)  =  e:32 (e2:4)      <==>  si e2:4=1	 alors s2:24=1
     */

    /**
     * Method declaration
     *
     *
     * @param pe1
     * @param pe2
     *
     * @return
     *
     * @see
     */
    public long[] permut2v64(long pe1, long pe2)
    {
        DoubleWord e1, e2, s1 = new DoubleWord(0), s2 = new DoubleWord(0);

        e1 = new DoubleWord(pe1);
        e2 = new DoubleWord(pe2);

        if (e1.and(B14).toInt() != 0)
        {
            s1 = s1.or(B01);
        }

        if (e1.and(B17).toInt() != 0)
        {
            s1 = s1.or(B02);
        }

        if (e1.and(B11).toInt() != 0)
        {
            s1 = s1.or(B03);
        }

        if (e1.and(B24).toInt() != 0)
        {
            s1 = s1.or(B04);
        }

        if (e1.and(B01).toInt() != 0)
        {
            s1 = s1.or(B05);
        }

        if (e1.and(B05).toInt() != 0)
        {
            s1 = s1.or(B06);
        }

        if (e1.and(B03).toInt() != 0)
        {
            s1 = s1.or(B07);
        }

        if (e1.and(B28).toInt() != 0)
        {
            s1 = s1.or(B08);
        }

        if (e1.and(B15).toInt() != 0)
        {
            s1 = s1.or(B09);
        }

        if (e1.and(B06).toInt() != 0)
        {
            s1 = s1.or(B10);
        }

        if (e1.and(B21).toInt() != 0)
        {
            s1 = s1.or(B11);
        }

        if (e1.and(B10).toInt() != 0)
        {
            s1 = s1.or(B12);
        }

        if (e1.and(B23).toInt() != 0)
        {
            s1 = s1.or(B13);
        }

        if (e1.and(B19).toInt() != 0)
        {
            s1 = s1.or(B14);
        }

        if (e1.and(B12).toInt() != 0)
        {
            s1 = s1.or(B15);
        }

        if (e1.and(B04).toInt() != 0)
        {
            s1 = s1.or(B16);
        }

        if (e1.and(B26).toInt() != 0)
        {
            s1 = s1.or(B17);
        }

        if (e1.and(B08).toInt() != 0)
        {
            s1 = s1.or(B18);
        }

        if (e1.and(B16).toInt() != 0)
        {
            s1 = s1.or(B19);
        }

        if (e1.and(B07).toInt() != 0)
        {
            s1 = s1.or(B20);
        }

        if (e1.and(B27).toInt() != 0)
        {
            s1 = s1.or(B21);
        }

        if (e1.and(B20).toInt() != 0)
        {
            s1 = s1.or(B22);
        }

        if (e1.and(B13).toInt() != 0)
        {
            s1 = s1.or(B23);
        }

        if (e1.and(B02).toInt() != 0)
        {
            s1 = s1.or(B24);
        }

        if (e2.and(B13).toInt() != 0)
        {
            s2 = s2.or(B01);
        }

        if (e2.and(B24).toInt() != 0)
        {
            s2 = s2.or(B02);
        }

        if (e2.and(B03).toInt() != 0)
        {
            s2 = s2.or(B03);
        }

        if (e2.and(B09).toInt() != 0)
        {
            s2 = s2.or(B04);
        }

        if (e2.and(B19).toInt() != 0)
        {
            s2 = s2.or(B05);
        }

        if (e2.and(B27).toInt() != 0)
        {
            s2 = s2.or(B06);
        }

        if (e2.and(B02).toInt() != 0)
        {
            s2 = s2.or(B07);
        }

        if (e2.and(B12).toInt() != 0)
        {
            s2 = s2.or(B08);
        }

        if (e2.and(B23).toInt() != 0)
        {
            s2 = s2.or(B09);
        }

        if (e2.and(B17).toInt() != 0)
        {
            s2 = s2.or(B10);
        }

        if (e2.and(B05).toInt() != 0)
        {
            s2 = s2.or(B11);
        }

        if (e2.and(B20).toInt() != 0)
        {
            s2 = s2.or(B12);
        }

        if (e2.and(B16).toInt() != 0)
        {
            s2 = s2.or(B13);
        }

        if (e2.and(B21).toInt() != 0)
        {
            s2 = s2.or(B14);
        }

        if (e2.and(B11).toInt() != 0)
        {
            s2 = s2.or(B15);
        }

        if (e2.and(B28).toInt() != 0)
        {
            s2 = s2.or(B16);
        }

        if (e2.and(B06).toInt() != 0)
        {
            s2 = s2.or(B17);
        }

        if (e2.and(B25).toInt() != 0)
        {
            s2 = s2.or(B18);
        }

        if (e2.and(B18).toInt() != 0)
        {
            s2 = s2.or(B19);
        }

        if (e2.and(B14).toInt() != 0)
        {
            s2 = s2.or(B20);
        }

        if (e2.and(B22).toInt() != 0)
        {
            s2 = s2.or(B21);
        }

        if (e2.and(B08).toInt() != 0)
        {
            s2 = s2.or(B22);
        }

        if (e2.and(B01).toInt() != 0)
        {
            s2 = s2.or(B23);
        }

        if (e2.and(B04).toInt() != 0)
        {
            s2 = s2.or(B24);
        }

        long[]  out = new long[2];

        out[0] = s1.toLong();
        out[1] = s2.toLong();

        return out;
    }

    /*
     * --------------------------------------------------------------
     * initperm64()
     * --------------------------------------------------------------
     * Permutation Initiale
     *
     * Entree  :	e1e2 (64 bits, 1 a 32, 33 a 64)
     * Sortie  :	s1s2 (64 bits, 1 a 32, 33 a 64)
     *
     * t1t2...t64 --> t58t50...t7
     * s:1 (s1:1)	  =  e:58 (e2:26)  <==>  si e2:26=1  alors s1:1=1
     * s:2 (s1:2)	  =  e:50 (e2:18)  <==>  si e2:18=1  alors s1:2=1
     * ...........
     * s:64 (s2:32)  =  e:7 (e1:7)    <==>  si e2:26=1  alors s2:32=1
     */

    /**
     * Method declaration
     *
     *
     * @param pe1
     * @param pe2
     *
     * @return
     *
     * @see
     */
    public long[] initperm64(long pe1, long pe2)
    {
        DoubleWord e1, e2, s1 = new DoubleWord(0), s2 = new DoubleWord(0);

        e1 = new DoubleWord(pe1);
        e2 = new DoubleWord(pe2);

        if (e2.and(B26).toInt() != 0)
        {
            s1 = s1.or(B01);
        }

        if (e2.and(B18).toInt() != 0)
        {
            s1 = s1.or(B02);
        }

        if (e2.and(B10).toInt() != 0)
        {
            s1 = s1.or(B03);
        }

        if (e2.and(B02).toInt() != 0)
        {
            s1 = s1.or(B04);
        }

        if (e2.and(B28).toInt() != 0)
        {
            s1 = s1.or(B09);
        }

        if (e2.and(B20).toInt() != 0)
        {
            s1 = s1.or(B10);
        }

        if (e2.and(B12).toInt() != 0)
        {
            s1 = s1.or(B11);
        }

        if (e2.and(B04).toInt() != 0)
        {
            s1 = s1.or(B12);
        }

        if (e2.and(B30).toInt() != 0)
        {
            s1 = s1.or(B17);
        }

        if (e2.and(B22).toInt() != 0)
        {
            s1 = s1.or(B18);
        }

        if (e2.and(B14).toInt() != 0)
        {
            s1 = s1.or(B19);
        }

        if (e2.and(B06).toInt() != 0)
        {
            s1 = s1.or(B20);
        }

        if (e2.and(B32).toInt() != 0)
        {
            s1 = s1.or(B25);
        }

        if (e2.and(B24).toInt() != 0)
        {
            s1 = s1.or(B26);
        }

        if (e2.and(B16).toInt() != 0)
        {
            s1 = s1.or(B27);
        }

        if (e2.and(B08).toInt() != 0)
        {
            s1 = s1.or(B28);
        }

        if (e2.and(B25).toInt() != 0)
        {
            s2 = s2.or(B01);
        }

        if (e2.and(B17).toInt() != 0)
        {
            s2 = s2.or(B02);
        }

        if (e2.and(B09).toInt() != 0)
        {
            s2 = s2.or(B03);
        }

        if (e2.and(B01).toInt() != 0)
        {
            s2 = s2.or(B04);
        }

        if (e2.and(B27).toInt() != 0)
        {
            s2 = s2.or(B09);
        }

        if (e2.and(B19).toInt() != 0)
        {
            s2 = s2.or(B10);
        }

        if (e2.and(B11).toInt() != 0)
        {
            s2 = s2.or(B11);
        }

        if (e2.and(B03).toInt() != 0)
        {
            s2 = s2.or(B12);
        }

        if (e2.and(B29).toInt() != 0)
        {
            s2 = s2.or(B17);
        }

        if (e2.and(B21).toInt() != 0)
        {
            s2 = s2.or(B18);
        }

        if (e2.and(B13).toInt() != 0)
        {
            s2 = s2.or(B19);
        }

        if (e2.and(B05).toInt() != 0)
        {
            s2 = s2.or(B20);
        }

        if (e2.and(B31).toInt() != 0)
        {
            s2 = s2.or(B25);
        }

        if (e2.and(B23).toInt() != 0)
        {
            s2 = s2.or(B26);
        }

        if (e2.and(B15).toInt() != 0)
        {
            s2 = s2.or(B27);
        }

        if (e2.and(B07).toInt() != 0)
        {
            s2 = s2.or(B28);
        }

        if (e1.and(B25).toInt() != 0)
        {
            s2 = s2.or(B05);
        }

        if (e1.and(B17).toInt() != 0)
        {
            s2 = s2.or(B06);
        }

        if (e1.and(B09).toInt() != 0)
        {
            s2 = s2.or(B07);
        }

        if (e1.and(B01).toInt() != 0)
        {
            s2 = s2.or(B08);
        }

        if (e1.and(B27).toInt() != 0)
        {
            s2 = s2.or(B13);
        }

        if (e1.and(B19).toInt() != 0)
        {
            s2 = s2.or(B14);
        }

        if (e1.and(B11).toInt() != 0)
        {
            s2 = s2.or(B15);
        }

        if (e1.and(B03).toInt() != 0)
        {
            s2 = s2.or(B16);
        }

        if (e1.and(B29).toInt() != 0)
        {
            s2 = s2.or(B21);
        }

        if (e1.and(B21).toInt() != 0)
        {
            s2 = s2.or(B22);
        }

        if (e1.and(B13).toInt() != 0)
        {
            s2 = s2.or(B23);
        }

        if (e1.and(B05).toInt() != 0)
        {
            s2 = s2.or(B24);
        }

        if (e1.and(B31).toInt() != 0)
        {
            s2 = s2.or(B29);
        }

        if (e1.and(B23).toInt() != 0)
        {
            s2 = s2.or(B30);
        }

        if (e1.and(B15).toInt() != 0)
        {
            s2 = s2.or(B31);
        }

        if (e1.and(B07).toInt() != 0)
        {
            s2 = s2.or(B32);
        }

        if (e1.and(B26).toInt() != 0)
        {
            s1 = s1.or(B05);
        }

        if (e1.and(B18).toInt() != 0)
        {
            s1 = s1.or(B06);
        }

        if (e1.and(B10).toInt() != 0)
        {
            s1 = s1.or(B07);
        }

        if (e1.and(B02).toInt() != 0)
        {
            s1 = s1.or(B08);
        }

        if (e1.and(B28).toInt() != 0)
        {
            s1 = s1.or(B13);
        }

        if (e1.and(B20).toInt() != 0)
        {
            s1 = s1.or(B14);
        }

        if (e1.and(B12).toInt() != 0)
        {
            s1 = s1.or(B15);
        }

        if (e1.and(B04).toInt() != 0)
        {
            s1 = s1.or(B16);
        }

        if (e1.and(B30).toInt() != 0)
        {
            s1 = s1.or(B21);
        }

        if (e1.and(B22).toInt() != 0)
        {
            s1 = s1.or(B22);
        }

        if (e1.and(B14).toInt() != 0)
        {
            s1 = s1.or(B23);
        }

        if (e1.and(B06).toInt() != 0)
        {
            s1 = s1.or(B24);
        }

        if (e1.and(B32).toInt() != 0)
        {
            s1 = s1.or(B29);
        }

        if (e1.and(B24).toInt() != 0)
        {
            s1 = s1.or(B30);
        }

        if (e1.and(B16).toInt() != 0)
        {
            s1 = s1.or(B31);
        }

        if (e1.and(B08).toInt() != 0)
        {
            s1 = s1.or(B32);
        }

        long[]  out = new long[2];

        out[0] = s1.toLong();
        out[1] = s2.toLong();

        return out;
    }

    /*
     * --------------------------------------------------------------
     * f64()
     * --------------------------------------------------------------
     * Fonction de calcul sur un bloc de 32 bits
     *
     * Entree  :	e	(32 bits)
     * c1c2	cle intermediaire (48 bits, 1 a 24, 25 a 48)
     * Sortie  :	e	(32 bits)
     *
     */

    /**
     * Method declaration
     *
     *
     * @param pe
     * @param c1
     * @param c2
     *
     * @return
     *
     * @see
     */
    public long f64(long pe, long c1, long c2)
    {
        int		s1 = 0, s2 = 0;
        long[]  out = expansion64(pe);
        DoubleWord o1 = new DoubleWord(out[0]), o2 = new DoubleWord(out[1]);
        DoubleWord cc1 = new DoubleWord(c1), cc2 = new DoubleWord(c2);

        pe = substitution64(o1.xor(cc1).toLong(), o2.xor(cc2).toLong());

        return permutation64(pe);
    }

    /*
     * --------------------------------------------------------------
     * expansion64()
     * --------------------------------------------------------------
     * Expansion bloc 32 bits en bloc 48 bits
     *
     * Entree  :	e    (32 bits)
     * Sortie  :	s1s2 (48 bits, 1 a 24, 25 a 48, cadre a gauche)
     *
     * On utilise la configuration de bits, en effectuant Desdecalages et en
     * masquant, pour obtenir chaque sous-ensemble de huit bits.
     */

    /**
     * Method declaration
     *
     *
     * @param pe
     *
     * @return
     *
     * @see
     */
    public long[] expansion64(long pe)
    {
        DoubleWord e, s1, s2;

        e = new DoubleWord(pe);
        s1 = new DoubleWord(0);	/* initialisation */

        if (e.and(B32).toInt() != 0)
        {
            s1 = B01;		/* s:1= e:32 */
        }

        e = e.RShift(1);		/* e:1 --> bit2	    e:4 --> bit5 */
        s1 = s1.or(e.and(new DoubleWord("7C000000")));		/* e:1-e:5 --> s:2-s:6 */
        e = e.RShift(2);		/* e:4 --> bit7	    e:8 --> bit11 */
        s1 = s1.or(e.and(new DoubleWord("3F00000")));		/* e:4-e:9 --> s:7-s:12 */
        e = e.RShift(2);		/* e:8 --> bit13	    e:12--> bit17 */
        s1 = s1.or(e.and(new DoubleWord("FC000")));	/* e:8-e:13 --> s:13-s:18 */
        e = e.RShift(2);		/* e:12 --> bit19 */
        s1 = s1.or(e.and(new DoubleWord("3F00")));		/* e:12-e:17 --> s:19-s:24 */
        e = new DoubleWord(pe);
        s2 = new DoubleWord(0);	/* reinitialisation */

        if (e.and(B01).toInt() != 0)
        {
            s2 = B24;		/* s:24= e:1 */
        }

        e = e.LShift(9);	/* e:32 --> bit23	    e:29 --> bit20 */
        s2 = s2.or(e.and(new DoubleWord("3E00")));		/* e:28-e:32 --> s:19-s:23 */
        e = e.LShift(2);	/* e:29 --> bit18	     e:25--> bit14 */
        s2 = s2.or(e.and(new DoubleWord("FC000")));	/* e:24-e:29 --> s:13-s:18 */
        e = e.LShift(2);	/* e:25 --> bit12	     e:21 --> bit8 */
        s2 = s2.or(e.and(new DoubleWord("3F00000")));		/* e:20-e:25 --> s:7-s:12 */
        e = e.LShift(2);	/* e:21 --> bit6 */
        s2 = s2.or(e.and(new DoubleWord("FC000000")));		/* e:16-e:20 --> s:1-s:6 */

        long[]  out = new long[2];

        out[0] = s1.toLong();
        out[1] = s2.toLong();

        return out;
    }

    /*
     * --------------------------------------------------------------
     * substitution64()
     * --------------------------------------------------------------
     * Subtitutions de 8 blocs de 6 bits en 8 blocs de 4bits
     *
     * Entree  :	e1e2	(48 bits, 1 a 24, 25 a 48)
     * Sortie  :	s	(32 bits)
     *
     * pour i=1 a 8 (1 a 4 pour e1, 5 a 8 pour e2) :
     * isoler le bloc b6 de 6 bits de e1 ou e2 (decalage),
     * recuperer le bloc de 4 bits b4 dans la table si[b6],
     * inserer b4 dans s (decalage).
     */

    /**
     * Method declaration
     *
     *
     * @param pe1
     * @param pe2
     *
     * @return
     *
     * @see
     */
    public long substitution64(long pe1, long pe2)
    {
        DoubleWord e, s;

        e = new DoubleWord(pe1);		/* initialisation e1 */
        e = e.RShift(8);	/* supprimer les 8 bits de poids faible (bloc 1) */
        s = s1[(e.and(new DoubleWord("FC0000")).RShift(18)).toInt()];

        /*
         * isoler les 6 bits de poids faible, substituer
         * par le bloc de 4 bits de s1, le mettre dans s
         */
        s = s.LShift(4);			/* bloc de 6 bits suivant (bloc 2) */
        s = s.or(s2[(e.and(new DoubleWord("3F000")).RShift(12)).toInt()]);

        /*
         * isoler les 6 bits de poids faible, substituer
         * par le bloc de 4 bits de s2, le mettre dans s
         */
        s = s.LShift(4);			/* bloc de 6 bits suivant (bloc 3) */
        s = s.or(s3[(e.and(new DoubleWord("FC0")).RShift(6)).toInt()]);

        /*
         * isoler les 6 bits de poids faible, substituer
         * par le bloc de 4 bits de s3, le mettre dans s
         */
        s = s.LShift(4);			/* bloc de 6 bits suivant (bloc 4) */
        s = s.or(s4[e.and(new DoubleWord("3F")).toInt()]);

        /*
         * isoler les 6 bits de poids faible, substituer
         * par le bloc de 4 bits de s4, le mettre dans s
         */
        e = new DoubleWord(pe2);		/* initialisation e2 */
        s = s.LShift(4);
        e = e.RShift(8);	/* supprimer les 8 bits de poids faible (bloc 5) */
        s = s.or(s5[(e.and(new DoubleWord("FC0000")).RShift(18)).toInt()]);

        /*
         * isoler les 6 bits de poids faible, substituer
         * par le bloc de 4 bits de s5, le mettre dans s
         */
        s = s.LShift(4);			/* bloc de 6 bits suivant (bloc 6) */
        s = s.or(s6[(e.and(new DoubleWord("3F000")).RShift(12)).toInt()]);

        /*
         * isoler les 6 bits de poids faible, substituer
         * par le bloc de 4 bits de s6, le mettre dans s
         */
        s = s.LShift(4);			/* bloc de 6 bits suivant (bloc 7) */
        s = s.or(s7[(e.and(new DoubleWord("FC0")).RShift(6)).toInt()]);

        /*
         * isoler les 6 bits de poids faible, substituer
         * par le bloc de 4 bits de s7, le mettre dans s
         */
        s = s.LShift(4);			/* bloc de 6 bits suivant (bloc 8) */
        s = s.or(s8[e.and(new DoubleWord("3F")).toInt()]);

        /*
         * isoler les 6 bits de poids faible, substituer
         * par le bloc de 4 bits de s8, le mettre dans s
         */

        return s.toLong();
    }

    /*
     * --------------------------------------------------------------
     * permutation64()
     * --------------------------------------------------------------
     * Permutation bloc de 32 bits
     *
     * Entree  :	e   (32 bits)
     * Sortie  :	e   (32 bits)
     *
     * t1...t32 --> t16...t25
     * s:1  =  e:16     <==>  si e:14=1   alors s:1=1
     * ...........
     * s:32 =  e:25     <==>  si e:25=1	alors s:32=1
     */

    /**
     * Method declaration
     *
     *
     * @param pe
     *
     * @return
     *
     * @see
     */
    public long permutation64(long pe)
    {
        DoubleWord e, s = new DoubleWord(0);

        e = new DoubleWord(pe);

        if (e.and(B16).toLong() != 0L)
        {
            s = s.or(B01);
        }

        if (e.and(B07).toLong() != 0L)
        {
            s = s.or(B02);
        }

        if (e.and(B20).toLong() != 0L)
        {
            s = s.or(B03);
        }

        if (e.and(B21).toLong() != 0L)
        {
            s = s.or(B04);
        }

        if (e.and(B29).toLong() != 0L)
        {
            s = s.or(B05);
        }

        if (e.and(B12).toLong() != 0L)
        {
            s = s.or(B06);
        }

        if (e.and(B28).toLong() != 0L)
        {
            s = s.or(B07);
        }

        if (e.and(B17).toLong() != 0L)
        {
            s = s.or(B08);
        }

        if (e.and(B01).toLong() != 0L)
        {
            s = s.or(B09);
        }

        if (e.and(B15).toLong() != 0L)
        {
            s = s.or(B10);
        }

        if (e.and(B23).toLong() != 0L)
        {
            s = s.or(B11);
        }

        if (e.and(B26).toLong() != 0L)
        {
            s = s.or(B12);
        }

        if (e.and(B05).toLong() != 0L)
        {
            s = s.or(B13);
        }

        if (e.and(B18).toLong() != 0L)
        {
            s = s.or(B14);
        }

        if (e.and(B31).toLong() != 0L)
        {
            s = s.or(B15);
        }

        if (e.and(B10).toLong() != 0L)
        {
            s = s.or(B16);
        }

        if (e.and(B02).toLong() != 0L)
        {
            s = s.or(B17);
        }

        if (e.and(B08).toLong() != 0L)
        {
            s = s.or(B18);
        }

        if (e.and(B24).toLong() != 0L)
        {
            s = s.or(B19);
        }

        if (e.and(B14).toLong() != 0L)
        {
            s = s.or(B20);
        }

        if (e.and(B32).toLong() != 0L)
        {
            s = s.or(B21);
        }

        if (e.and(B27).toLong() != 0L)
        {
            s = s.or(B22);
        }

        if (e.and(B03).toLong() != 0L)
        {
            s = s.or(B23);
        }

        if (e.and(B09).toLong() != 0L)
        {
            s = s.or(B24);
        }

        if (e.and(B19).toLong() != 0L)
        {
            s = s.or(B25);
        }

        if (e.and(B13).toLong() != 0L)
        {
            s = s.or(B26);
        }

        if (e.and(B30).toLong() != 0L)
        {
            s = s.or(B27);
        }

        if (e.and(B06).toLong() != 0L)
        {
            s = s.or(B28);
        }

        if (e.and(B22).toLong() != 0L)
        {
            s = s.or(B29);
        }

        if (e.and(B11).toLong() != 0L)
        {
            s = s.or(B30);
        }

        if (e.and(B04).toLong() != 0L)
        {
            s = s.or(B31);
        }

        if (e.and(B25).toLong() != 0L)
        {
            s = s.or(B32);
        }

        return s.toLong();
    }

    /*
     * --------------------------------------------------------------
     * finalperm64()
     * --------------------------------------------------------------
     * Permutation Finale
     *
     * Entree  :	e1e2 (64 bits, 1 a 32, 33 a 64)
     * Sortie  :	s1s2 (64 bits, 1 a 32, 33 a 64)
     *
     * t1t2...t64 --> t40t8...t27
     * s:1 (s1:1)	  =  e:40 (e2:8)     <==>  si e2:8=1   alors s1:1=1
     * s:2 (s1:2)	  =  e:8  (e1:8)     <==>  si e1:8=1   alors s1:2=1
     * ...........
     * s:64 (s2:32)  =  e:27 (e1:27)    <==>  si e2:27=1  alors s2:32=1
     */

    /**
     * Method declaration
     *
     *
     * @param pe1
     * @param pe2
     *
     * @return
     *
     * @see
     */
    public long[] finalperm64(long pe1, long pe2)
    {
        DoubleWord e1, e2, s1 = new DoubleWord(0), s2 = new DoubleWord(0);

        e1 = new DoubleWord(pe1);
        e2 = new DoubleWord(pe2);

        if (e2.and(B08).toLong() != 0l)
        {
            s1 = s1.or(B01);
        }

        if (e2.and(B16).toLong() != 0l)
        {
            s1 = s1.or(B03);
        }

        if (e2.and(B24).toLong() != 0l)
        {
            s1 = s1.or(B05);
        }

        if (e2.and(B32).toLong() != 0l)
        {
            s1 = s1.or(B07);
        }

        if (e2.and(B07).toLong() != 0l)
        {
            s1 = s1.or(B09);
        }

        if (e2.and(B15).toLong() != 0l)
        {
            s1 = s1.or(B11);
        }

        if (e2.and(B23).toLong() != 0l)
        {
            s1 = s1.or(B13);
        }

        if (e2.and(B31).toLong() != 0l)
        {
            s1 = s1.or(B15);
        }

        if (e2.and(B06).toLong() != 0l)
        {
            s1 = s1.or(B17);
        }

        if (e2.and(B14).toLong() != 0l)
        {
            s1 = s1.or(B19);
        }

        if (e2.and(B22).toLong() != 0l)
        {
            s1 = s1.or(B21);
        }

        if (e2.and(B30).toLong() != 0l)
        {
            s1 = s1.or(B23);
        }

        if (e2.and(B05).toLong() != 0l)
        {
            s1 = s1.or(B25);
        }

        if (e2.and(B13).toLong() != 0l)
        {
            s1 = s1.or(B27);
        }

        if (e2.and(B21).toLong() != 0l)
        {
            s1 = s1.or(B29);
        }

        if (e2.and(B29).toLong() != 0l)
        {
            s1 = s1.or(B31);
        }

        if (e2.and(B04).toLong() != 0l)
        {
            s2 = s2.or(B01);
        }

        if (e2.and(B12).toLong() != 0l)
        {
            s2 = s2.or(B03);
        }

        if (e2.and(B20).toLong() != 0l)
        {
            s2 = s2.or(B05);
        }

        if (e2.and(B28).toLong() != 0l)
        {
            s2 = s2.or(B07);
        }

        if (e2.and(B03).toLong() != 0l)
        {
            s2 = s2.or(B09);
        }

        if (e2.and(B11).toLong() != 0l)
        {
            s2 = s2.or(B11);
        }

        if (e2.and(B19).toLong() != 0l)
        {
            s2 = s2.or(B13);
        }

        if (e2.and(B27).toLong() != 0l)
        {
            s2 = s2.or(B15);
        }

        if (e2.and(B02).toLong() != 0l)
        {
            s2 = s2.or(B17);
        }

        if (e2.and(B10).toLong() != 0l)
        {
            s2 = s2.or(B19);
        }

        if (e2.and(B18).toLong() != 0l)
        {
            s2 = s2.or(B21);
        }

        if (e2.and(B26).toLong() != 0l)
        {
            s2 = s2.or(B23);
        }

        if (e2.and(B01).toLong() != 0l)
        {
            s2 = s2.or(B25);
        }

        if (e2.and(B09).toLong() != 0l)
        {
            s2 = s2.or(B27);
        }

        if (e2.and(B17).toLong() != 0l)
        {
            s2 = s2.or(B29);
        }

        if (e2.and(B25).toLong() != 0l)
        {
            s2 = s2.or(B31);
        }

        if (e1.and(B04).toLong() != 0l)
        {
            s2 = s2.or(B02);
        }

        if (e1.and(B12).toLong() != 0l)
        {
            s2 = s2.or(B04);
        }

        if (e1.and(B20).toLong() != 0l)
        {
            s2 = s2.or(B06);
        }

        if (e1.and(B28).toLong() != 0l)
        {
            s2 = s2.or(B08);
        }

        if (e1.and(B03).toLong() != 0l)
        {
            s2 = s2.or(B10);
        }

        if (e1.and(B11).toLong() != 0l)
        {
            s2 = s2.or(B12);
        }

        if (e1.and(B19).toLong() != 0l)
        {
            s2 = s2.or(B14);
        }

        if (e1.and(B27).toLong() != 0l)
        {
            s2 = s2.or(B16);
        }

        if (e1.and(B02).toLong() != 0l)
        {
            s2 = s2.or(B18);
        }

        if (e1.and(B10).toLong() != 0l)
        {
            s2 = s2.or(B20);
        }

        if (e1.and(B18).toLong() != 0l)
        {
            s2 = s2.or(B22);
        }

        if (e1.and(B26).toLong() != 0l)
        {
            s2 = s2.or(B24);
        }

        if (e1.and(B01).toLong() != 0l)
        {
            s2 = s2.or(B26);
        }

        if (e1.and(B09).toLong() != 0l)
        {
            s2 = s2.or(B28);
        }

        if (e1.and(B17).toLong() != 0l)
        {
            s2 = s2.or(B30);
        }

        if (e1.and(B25).toLong() != 0l)
        {
            s2 = s2.or(B32);
        }

        if (e1.and(B08).toLong() != 0l)
        {
            s1 = s1.or(B02);
        }

        if (e1.and(B16).toLong() != 0l)
        {
            s1 = s1.or(B04);
        }

        if (e1.and(B24).toLong() != 0l)
        {
            s1 = s1.or(B06);
        }

        if (e1.and(B32).toLong() != 0l)
        {
            s1 = s1.or(B08);
        }

        if (e1.and(B07).toLong() != 0l)
        {
            s1 = s1.or(B10);
        }

        if (e1.and(B15).toLong() != 0l)
        {
            s1 = s1.or(B12);
        }

        if (e1.and(B23).toLong() != 0l)
        {
            s1 = s1.or(B14);
        }

        if (e1.and(B31).toLong() != 0l)
        {
            s1 = s1.or(B16);
        }

        if (e1.and(B06).toLong() != 0l)
        {
            s1 = s1.or(B18);
        }

        if (e1.and(B14).toLong() != 0l)
        {
            s1 = s1.or(B20);
        }

        if (e1.and(B22).toLong() != 0l)
        {
            s1 = s1.or(B22);
        }

        if (e1.and(B30).toLong() != 0l)
        {
            s1 = s1.or(B24);
        }

        if (e1.and(B05).toLong() != 0l)
        {
            s1 = s1.or(B26);
        }

        if (e1.and(B13).toLong() != 0l)
        {
            s1 = s1.or(B28);
        }

        if (e1.and(B21).toLong() != 0l)
        {
            s1 = s1.or(B30);
        }

        if (e1.and(B29).toLong() != 0l)
        {
            s1 = s1.or(B32);
        }

        long[]  out = new long[2];

        out[0] = s1.toLong();
        out[1] = s2.toLong();

        return out;
    }

}
// End of class des

/*--- formatting done in "Sun Java Convention" style on 04-10-2003 ---*/