public class DecimalToBinary
{

    public static String toBinaryString(int decimal)
    {
        String result = "";
        if (decimal == 0)
        {
            return "0";
        }
        while (decimal != 0)
        {

            // Solution 0:
            /*int modulo = decimal % 2;
            if (modulo == 0) {
                result += '0';
            } else {
                result += '1';
            }*/

            // Solution 1:
            /*result += decimal % 2 == 0 ? '0' : '1';*/

            // Solution 2:
            result += String.valueOf(decimal % 2);

            decimal /= 2;
        }
        return new StringBuffer(result).reverse().toString();

        // Solutions to prepend:
        // result = myBit + result;
        // result.insert(0,myBit);
    }
}
