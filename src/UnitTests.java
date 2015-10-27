
public class UnitTests
{

    public static void main(String[] args) throws Exception
    {
        if (!UnitTests.run())
        {
            System.out.println("Failure");
            return;
        }
        System.out.println("Success");
    }

    public static boolean run() throws Exception
    {
        // Test DecimalToBinary
        for (int decimal = 0; decimal < 100; decimal++)
        {
            String tested = DecimalToBinary.toBinaryString(decimal);
            String expected = Integer.toBinaryString(decimal);
            if (!tested.equals(expected))
            {
                System.err.println(Integer.toString(decimal) + ": expected '"
                    + expected + "' got '" + tested + "'");
                return false;
            }
        }

        // Test PresentationPicker
        Picker picker = new Picker();
        for (int i = 0; i < 5; i++)
        {
            int sizep = picker.getPickedSize();
            int sizenp = picker.getNotPickedSize();
            Picker.Pick pick = picker.pick();
            System.out.println(pick);
            picker.unpick(pick);

            int newSizep = picker.getPickedSize();
            int newSizenp = picker.getNotPickedSize();
            if (sizep != newSizep)
            {
                System.err.println(
                    "Picked size changed from " + sizep + " to " + newSizep);
                return false;
            }
            if (sizenp != newSizenp)
            {
                System.err.println("Non picked size changed from " + sizenp
                    + " to " + newSizenp);
                return false;
            }
        }
        return true;
    }
}
