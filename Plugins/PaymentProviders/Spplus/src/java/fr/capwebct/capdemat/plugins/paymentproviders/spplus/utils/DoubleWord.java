/*--- formatted by Jindent 2.1, (www.c-lab.de/~jindent) ---*/

/**
 * Titre : Class DoubleWord used in the crypto package
 * Description : Class used to perform logical operations in sha and Desalgorithm
 * Copyright :    Copyright (c) 2003
 * Société : SPPLUS
 * @author D. Vieilleden
 * @version 1.0
 */

package fr.capwebct.capdemat.plugins.paymentproviders.spplus.utils;

public class DoubleWord
{
    private byte	low;								// Low byte
    private byte	midlow;								// MidLow byte
    private byte	midhigh;							// MidHigh byte
    private byte	high;								// High byte
    private String  hexBytes = "0123456789abcdef";		// Hex values

    /**
     * Constructor declaration
     *
     * Construct a new DoubleWord object using the integer <b>value</b>
     *
     * @param value An integer representing the DoubleWord
     *
     * @see
     */
    public DoubleWord(int value)
    {
        low = (byte) value;
        midlow = (byte) ((value & 0xFFL) >> 8);
        midhigh = (byte) ((value & 0xFFL) >> 16);
        high = (byte) ((value & 0xFFL) >> 24);
    }

    /**
     * Constructor declaration
     *
     * Construct a new DoubleWord object using the long <b>value</b>
     *
     * @param value A Long representing the DoubleWord
     *
     * @see
     */
    public DoubleWord(long value)
    {
        low = (byte) value;
        midlow = (byte) (value >> 8);
        midhigh = (byte) (value >> 16);
        high = (byte) (value >> 24);
    }

    /**
     * Constructor declaration
     *
     * Construct a new DoubleWord from the string <b>value</b>
     *
     * @param value a String representing the DoubleWord
     *
     * @see
     */
    public DoubleWord(String value)
    {
        String  lvalue = value.toLowerCase();

        while (lvalue.length() < 8)
        {
            lvalue = "0" + lvalue;
        }

        high = (byte) (hexBytes.indexOf(lvalue.charAt(0)) * 16
                       + hexBytes.indexOf(lvalue.charAt(1)));
        midhigh = (byte) (hexBytes.indexOf(lvalue.charAt(2)) * 16
                          + hexBytes.indexOf(lvalue.charAt(3)));
        midlow = (byte) (hexBytes.indexOf(lvalue.charAt(4)) * 16
                         + hexBytes.indexOf(lvalue.charAt(5)));
        low = (byte) (hexBytes.indexOf(lvalue.charAt(6)) * 16
                      + hexBytes.indexOf(lvalue.charAt(7)));
    }

    /**
     * Constructor declaration
     *
     * Construct a new DoubleWord object from the byte array <b>value</b>
     *
     * @param value a byte array representing the DoubleWord
     *
     * @see
     */
    public DoubleWord(byte[] value)
    {
        int		i;
        byte[]  lvalue = new byte[4];

        if (value.length < 4)
        {
            for (i = 0; i < 4 - value.length; i++)
            {
                lvalue[i] = 0;
            }

            for (; i < 4; i++)
            {
                lvalue[i] = value[i - value.length];
            }
        }
        else
        {
            for (i = value.length - 4; i < value.length; i++)
            {
                lvalue[i - value.length + 4] = value[i];
            }
        }

        high = lvalue[0];
        midhigh = lvalue[1];
        midlow = lvalue[2];
        low = lvalue[3];
    }

    /**
     * Method declaration
     *
     * Shift to the right the bits contained in the DoubleWord object
     *
     * @param amount the number of bits to shift to the right
     *
     * @return a new DoubleWord object containg the right shifted value of the
     * current DoubleWord object
     *
     * @see
     */
    public DoubleWord RShift(int amount)
    {
        int		llow = 0;
        int		lmidlow = 0;
        int		lmidhigh = 0;
        int		lhigh = 0;
        byte	tempo;
        int		lamount;

        // Check that the number of bits to shift is in the range 1 -> 31
        // 0 bits to shift means no modification
        // 32 bits to shift means set to 0 the value
        if (amount > 31 || amount < 1)
        {
            String  error = "invalid amount : " + amount;
            return null;
        }

        // If the numebr of bits to shift is lower or equal than 7
        if (amount <= 7)
        {
            // shift (number of bits to shift) to the right the low byte
            llow = (low & 0xFF) >> amount;
            // Shift 8-(number of bits to shift) to the left the midlow byte
            tempo = (byte) ((midlow & 0xFF) << 8 - amount);
            // Add the value obtained to the low value
            llow += (tempo & 0xFF);
            // shift (number of bits to shift) to the right the midlow byte
            lmidlow = (midlow & 0xff) >> amount;
            // Shift 8-(number of bits to shift) to the left the midhigh byte
            tempo = (byte) ((midhigh & 0xff) << 8 - amount);
            // Add the value obtained to the midlow value
            lmidlow += (tempo & 0xff);
            // shift (number of bits to shift) to the right the midhigh byte
            lmidhigh = (midhigh & 0xff) >> amount;
            // Shift 8-(number of bits to shift) to the left the high byte
            tempo = (byte) ((high & 0xff) << 8 - amount);
            // Add the value obtained to the midhigh value
            lmidhigh += (tempo & 0xff);
            // shift (number of bits to shift) to the right the high byte
            lhigh = (high & 0xff) >> amount;

            byte[]  ret = new byte[4];
            // give the values to a byte array
            ret[3] = (byte) llow;
            ret[2] = (byte) lmidlow;
            ret[1] = (byte) lmidhigh;
            ret[0] = (byte) lhigh;
            // Return a new DoubleWord built from the byte array
            return new DoubleWord(ret);
        }

        // Same as above except that  :
        //  - the new low byte is built from the midlow and midhigh bytes
        //  - the new midlow byte is built from the midhigh and high bytes
        //  - the new midhigh byte is built from the high byte
        //  - the new high byte is set to 0
        if (amount <= 15)
        {
            lamount = amount - 8;
            llow = ((midlow & 0xFF) >> lamount);
            tempo = (byte) ((midhigh & 0xff) << 8 - lamount);
            llow += (tempo & 0xFF);
            lmidlow = ((midhigh & 0xff) >> lamount);
            tempo = (byte) ((high & 0xff) << 8 - lamount);
            lmidlow += (tempo & 0xff);
            lmidhigh = ((high & 0xff) >> lamount);
            lhigh = 0;

            byte[]  ret = new byte[4];

            ret[3] = (byte) llow;
            ret[2] = (byte) lmidlow;
            ret[1] = (byte) lmidhigh;
            ret[0] = (byte) lhigh;

            return new DoubleWord(ret);
        }

        // Same as above except that  :
        //  - the new low byte is built from the midhigh and high bytes
        //  - the new midlow byte is built from the high byte
        //  - the new midhigh byte is set to 0
        //  - the new high byte is set to 0
        if (amount <= 23)
        {
            lamount = amount - 16;
            llow = (midhigh & 0xFF) >> lamount;
            tempo = (byte) ((high & 0xFF) << 8 - lamount);
            llow += (tempo & 0xFF);
            lmidlow = (high & 0xff) >> lamount;
            lmidhigh = 0;
            lhigh = 0;

            byte[]  ret = new byte[4];

            ret[3] = (byte) llow;
            ret[2] = (byte) lmidlow;
            ret[1] = (byte) lmidhigh;
            ret[0] = (byte) lhigh;

            return new DoubleWord(ret);
        }

         // Same as above except that  :
        //  - the new low byte is built from the high byte
        //  - the new midlow byte is set to 0
        //  - the new midhigh byte is set to 0
        //  - the new high byte is set to 0
       if (amount <= 31)
        {
            lamount = amount - 24;
            llow = (high & 0xFF) >> lamount;
            lmidlow = 0;
            lmidhigh = 0;
            lhigh = 0;

            byte[]  ret = new byte[4];

            ret[3] = (byte) llow;
            ret[2] = (byte) lmidlow;
            ret[1] = (byte) lmidhigh;
            ret[0] = (byte) lhigh;

            return new DoubleWord(ret);
        }

        return this;
    }

    /**
     * Method declaration
     *
     * Shift amount bits to the left current DoubleWord value
     *
     * @param amount the number of bits to shift to the left
     *
     * @return a new DoubleWord object containg the left shifted value of the
     * current DoubleWord object
     *
     * @see
     */
    public DoubleWord LShift(int amount)
    {
        int		llow = 0;
        int		lmidlow = 0;
        int		lmidhigh = 0;
        int		lhigh = 0;
        byte	tempo;
        int		lamount;

        // Check that the number of bits to shift is in the range 1 -> 31
        // 0 bits to shift means no modification
        // 32 bits to shift means set to 0 the value
        if (amount > 31 || amount < 1)
        {
            String  error = "invalid amount : " + amount;

            return null;
        }

        // If the number of bits to shift is lower or equal than 7
        if (amount <= 7)
        {
            // shift (number of bits to shift) to the left the high byte
            lhigh = (high & 0xFF) << amount;
            // shift 8 - (number of bits to shift) to the right the midhigh byte
            tempo = (byte) ((midhigh & 0xFF) >> 8 - amount);
            // Add this value to the high byte
            lhigh += (tempo & 0xFF);
            // shift (number of bits to shift) to the left the midhigh byte
            lmidhigh = (midhigh & 0xff) << amount;
            // shift 8 - (number of bits to shift) to the right the midlow byte
            tempo = (byte) ((midlow & 0xff) >> 8 - amount);
            // Add this value to the midhigh byte
            lmidhigh += (tempo & 0xff);
            // shift (number of bits to shift) to the left the midlow byte
            lmidlow = (midlow & 0xff) << amount;
            // shift 8 - (number of bits to shift) to the right the low byte
            tempo = (byte) ((low & 0xff) >> 8 - amount);
            // Add this value to the midlow byte
            lmidlow += (tempo & 0xff);
            // shift (number of bits to shift) to the left the low byte
            llow = (low & 0xff) << amount;

            byte[]  ret = new byte[4];
            // give the values to a byte array
            ret[3] = (byte) llow;
            ret[2] = (byte) lmidlow;
            ret[1] = (byte) lmidhigh;
            ret[0] = (byte) lhigh;
            // Return a new DoubleWord built from the byte array
            return new DoubleWord(ret);
        }

        // Same as above except that  :
        //  - the new high byte is built from the midlow and midhigh bytes
        //  - the new midhigh byte is built from the midlow and low bytes
        //  - the new midlow byte is built from the low byte
        //  - the new low byte is set to 0
        if (amount <= 15)
        {
            lamount = amount - 8;
            lhigh = (midhigh & 0xFF) << lamount;
            tempo = (byte) ((midlow & 0xff) >> 8 - lamount);
            lhigh += (tempo & 0xFF);
            lmidhigh = (midlow & 0xff) << lamount;
            tempo = (byte) ((low & 0xff) >> 8 - lamount);
            lmidhigh += (tempo & 0xff);
            lmidlow = (low & 0xff) << lamount;
            llow = 0;

            byte[]  ret = new byte[4];

            ret[3] = (byte) llow;
            ret[2] = (byte) lmidlow;
            ret[1] = (byte) lmidhigh;
            ret[0] = (byte) lhigh;

            return new DoubleWord(ret);
        }

        // Same as above except that  :
        //  - the new high byte is built from the low and midlow bytes
        //  - the new midhigh byte is built from the low byte
        //  - the new midlow byte is set to 0
        //  - the new low byte is set to 0
        if (amount <= 23)
        {
            lamount = amount - 16;
            lhigh = (midlow & 0xFF) << lamount;
            tempo = (byte) ((low & 0xff) >> 8 - lamount);
            lhigh += (tempo & 0xFF);
            lmidhigh = (low & 0xff) << lamount;
            lmidlow = 0;
            llow = 0;

            byte[]  ret = new byte[4];

            ret[3] = (byte) llow;
            ret[2] = (byte) lmidlow;
            ret[1] = (byte) midhigh;
            ret[0] = (byte) high;

            return new DoubleWord(ret);
        }

        // Same as above except that  :
        //  - the new high byte is built from the low byte
        //  - the new midhigh byte is set to 0
        //  - the new midlow byte is set to 0
        //  - the new low byte is set to 0
        if (amount <= 31)
        {
            lamount = amount - 24;
            lhigh = (low & 0xFF) << lamount;
            lmidhigh = 0;
            lmidlow = 0;
            llow = 0;

            byte[]  ret = new byte[4];

            ret[3] = (byte) llow;
            ret[2] = (byte) lmidlow;
            ret[1] = (byte) lmidhigh;
            ret[0] = (byte) lhigh;

            return new DoubleWord(ret);
        }

        return this;
    }

    /**
     * Method declaration
     *
     * Add two DoubleWord and return the result as a new DoubleWord
     *
     * @param anOtherBigByte the DoubleWord to add to current
     *
     * @return a new DoubleWord representing the addition of current and <b>onOtherBigByte</b>
     *
     * @see
     */
    public DoubleWord add(DoubleWord anOtherBigByte)
    {
        // Get the long value of current DoubleWord object
        long	v1 = toLong();
        // Get the long value of anOtherBigByte object
        long	v2 = anOtherBigByte.toLong();
        // Add the values
        v1 += v2;
        // Return a new DoubleWord built from the addition result
        return new DoubleWord(v1);
    }

    /**
     * Method declaration
     *
     * Add a DoubleWord and an integer
     *
     * @param avalue the int to add to current DoubleWord
     *
     * @return a new DoubleWord object containing the result of the addition between
     * current DoubleWord and <b>avalue</b>
     *
     * @see
     */
    public DoubleWord add(int avalue)
    {
        // Buil a DoubleWord from the int value
        DoubleWord local = new DoubleWord((avalue & 0xffl));

        // Return the result of the addition between current DoubleWord and newly created one
        return this.add(local);
    }

    /**
     * Method declaration
     *
     * Add current DoubleWord with the long <b>avalue</b>
     *
     * @param avalue the long to add
     *
     * @return a new DoubleWord object containing the result of the addition between
     * current DoubleWord and <b>avalue</b>
     *
     * @see
     */
    public DoubleWord add(long avalue)
    {
        // Return the result of the addition between current DoubleWord and new one
        // built from <b>avalue</b>
        return this.add(new DoubleWord(avalue));
    }

    /**
     * Method declaration
     *
     * Perform the subtraction between current DoubleWord and <b>anOtherBigByte</b>
     *
     * @param anOtherBigByte the DoubleWord to subtract to current
     *
     * @return a new DoubleWord containing the subtraction between current DoubleWord
     * and <b>anOtherBigByte</b>
     *
     * @see
     */
    public DoubleWord sub(DoubleWord anOtherBigByte)
    {
        long	v1 = toLong();
        long	v2 = anOtherBigByte.toLong();

        v1 -= v2;
        return new DoubleWord(v1);
    }

    /**
     * Method declaration
     *
     * Performs an or between current DoubleWord and <b>anOtherBigByte</b>
     *
     * @param anOtherBigByte the DoubleWord to  use to perform a bitwise inclusive or
     *
     * @return a newly created DoubleWord built from the result of the or operation
     *
     * @see
     */
    public DoubleWord or(DoubleWord anOtherBigByte)
    {
        byte[]  bvalue = anOtherBigByte.getBytes();
        byte[]  ret = new byte[4];

        ret[3] = (byte) ((low & 0xff) | (bvalue[3] & 0xFF));
        ret[2] = (byte) ((midlow & 0xff) | (bvalue[2] & 0xff));
        ret[1] = (byte) ((midhigh & 0xff) | (bvalue[1] & 0xff));
        ret[0] = (byte) ((high & 0xff) | (bvalue[0] & 0xff));

        return new DoubleWord(ret);
    }

    /**
     * Method declaration
     *
     * Performs an xor between current DoubleWord and <b>anOtherBigByte</b>
     *
     * @param anOTherBigByte the DoubleWord to  use to perform a bitwise exclusive or
     *
     * @return a newly created DoubleWord built from the result of the xor operation
     *
     * @see
     */
    public DoubleWord xor(DoubleWord anOtherBigByte)
    {
        byte[]  bvalue = anOtherBigByte.getBytes();
        byte[]  ret = new byte[4];

        ret[3] = (byte) ((low & 0xff) ^ (bvalue[3] & 0xFF));
        ret[2] = (byte) ((midlow & 0xff) ^ (bvalue[2] & 0xff));
        ret[1] = (byte) ((midhigh & 0xff) ^ (bvalue[1] & 0xff));
        ret[0] = (byte) ((high & 0xff) ^ (bvalue[0] & 0xff));

        return new DoubleWord(ret);
    }

    /**
     * Method declaration
     *
     * Performs an and between current DoubleWord and <b>anOtherBigByte</b>
     *
     * @param anOtherBigByte the DoubleWord to  use to perform a bitwise and
     *
     * @return a newly created DoubleWord built from the result of the and operation
     *
     * @see
     */
    public DoubleWord and(DoubleWord anOtherBigByte)
    {
        byte[]  bvalue = anOtherBigByte.getBytes();
        byte[]  ret = new byte[4];

        ret[3] = (byte) ((low & 0xff) & (bvalue[3] & 0xFF));
        ret[2] = (byte) ((midlow & 0xff) & (bvalue[2] & 0xff));
        ret[1] = (byte) ((midhigh & 0xff) & (bvalue[1] & 0xff));
        ret[0] = (byte) ((high & 0xff) & (bvalue[0] & 0xff));

        return new DoubleWord(ret);
    }

    /**
     * Method declaration
     *
     * Performs a not to all bits of current DoubleWord
     *
     * @return a new DoubleWord object representing the not value of current DoubleWord
     *
     * @see
     */
    public DoubleWord not()
    {
        byte[]  ret = new byte[4];

        ret[3] = (byte) ~(low & 0xFF);
        ret[2] = (byte) ~(midlow & 0xFF);
        ret[1] = (byte) ~(midhigh & 0xFF);
        ret[0] = (byte) ~(high & 0xFF);

        return new DoubleWord(ret);
    }

    /**
     * Method declaration
     *
     * Build a string representing the DoubleWord value
     *
     * @return the DoubleWord as a string
     *
     * @see
     */
    public String toString()
    {
        String  value = "";

        value = hexBytes.charAt((high & 0xFF) / 16) + ""
                + hexBytes.charAt((high & 0xFF) % 16) + ""
                + hexBytes.charAt((midhigh & 0xFF) / 16) + ""
                + hexBytes.charAt((midhigh & 0xFF) % 16) + ""
                + hexBytes.charAt((midlow & 0xFF) / 16) + ""
                + hexBytes.charAt((midlow & 0xFF) % 16) + ""
                + hexBytes.charAt((low & 0xFF) / 16) + ""
                + hexBytes.charAt((low & 0xFF) % 16);

        return value;
    }

    /**
     * Method declaration
     *
     * Build an int fromt he DoubleWord value
     *
     * @return the int value of current DoubleWord
     *
     * @see
     */
    public int toInt()
    {
        long	value = toLong();

        return (int) value;
    }

    /**
     * Method declaration
     *
     * Build a long from current DoubleWord value
     *
     * @return the long value of current DoubleWord
     *
     * @see
     */
    public long toLong()
    {
        long	value = 0L;
        long	lhigh = (high & 0xFFL);
        long	lmidhigh = (midhigh & 0xFFL);
        long	lmidlow = (midlow & 0xFFL);
        long	llow = (low & 0xFFL);

        value = (lhigh << 24) + (lmidhigh << 16) + (lmidlow << 8) + llow;

        return value;
    }

    /**
     * Method declaration
     *
     * Return the lowest byte of current DoubleWord object
     *
     * @return the low attribute
     *
     * @see
     */
    public byte getLow()
    {
        return low;
    }

    /**
     * Method declaration
     *
     *Return the highest byte of current DoubleWord object
     *
     * @return the high attribute
     *
     * @see
     */
    public byte getHigh()
    {
        return high;
    }

    /**
     * Method declaration
     *
     * Return the midlow byte of current DoubleWord object
     *
     * @return the midlow attribute
     *
     * @see
     */
    public byte getMidLow()
    {
        return midlow;
    }

    /**
     * Method declaration
     *
     * Return the midhigh byte of current DoubleWord object
     *
     * @return the midhigh attribute
     *
     * @see
     */
    public byte getMidHigh()
    {
        return midhigh;
    }

    /**
     * Method declaration
     *
     * Build a byte array from the DoubleWord value
     *
     * @return a byte array containg the DoubleWord bytes
     *
     * @see
     */
    public byte[] getBytes()
    {
        byte[]  value =
        {
            high, midhigh, midlow, low
        };

        return value;
    }

}
// End of class DoubleWord

/*--- formatting done in "Sun Java Convention" style on 04-10-2003 ---*/