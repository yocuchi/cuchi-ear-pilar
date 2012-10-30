package es.oepm.areaae;

import java.io.File;
import java.io.RandomAccessFile;


public class ObjectGuid {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		RandomAccessFile f = new RandomAccessFile("src\\es\\oepm\\areaae\\FHERNAN1.guid", "r");
		byte[] b = new byte[(int)f.length()];
		f.read(b);
		
		byte[] SID = b;

		
		//String strSID = getSIDasStringOfBytes(SID);
		System.out.println("GUID_convertToBindingString="+ObjectGUID_Tools.convertToBindingString(b));
		System.out.println("GUID_convertToByteString="+ObjectGUID_Tools.convertToByteString(b));
		System.out.println("GUID_convertToDashedString="+ObjectGUID_Tools.convertToDashedString(b));
		System.out.println("GUID_ cuchi convertToByteString="+ObjectGUID_Tools.cuchi_convertToByteString(b));
		System.out.println("GUID_ SIGEM="+formatBinaryGuid(b));
		//System.out.println("GUID="+strSID);
		

	}
	
	
	private static String formatBinaryGuid(byte[] guidObj)
	{
		if (guidObj==null)
			return null;

		String guidStr = "";
		int len, i;
		String byteStr;

		len = guidObj.length;

		for (i = 0; i < len; i++)
		{
			byteStr = Integer.toHexString(guidObj[i] & 0xff);
			if (byteStr.length() == 1)
				byteStr = "0" + byteStr;

			guidStr = guidStr + byteStr;
		}
		return guidStr;
	}
	
}

 class ObjectGUID_Tools {


    public static String convertToByteString(byte[] objectGUID) {

        StringBuilder result = new StringBuilder();


        for (int i = 0; i < objectGUID.length; i++) {

            String transformed = prefixZeros((int) objectGUID[i] & 0xFF);

            result.append("\\");

            result.append(transformed);

        }


        return result.toString();

    }

    
    public static String cuchi_convertToByteString(byte[] objectGUID) {

        StringBuilder result = new StringBuilder();


        for (int i = 0; i < objectGUID.length; i++) {

            String transformed = prefixZeros((int) objectGUID[i] & 0xFF);

            

            result.append(transformed);

        }


        return result.toString();

    }


    public static String convertToBindingString(byte[] objectGUID) {

        StringBuilder displayStr = new StringBuilder();


        displayStr.append("<GUID=");

        displayStr.append(convertToDashedString(objectGUID));

        displayStr.append(">");


        return displayStr.toString();

    }


    public static String convertToDashedString(byte[] objectGUID) {

        StringBuilder displayStr = new StringBuilder();


        displayStr.append(prefixZeros((int) objectGUID[3] & 0xFF));

        displayStr.append(prefixZeros((int) objectGUID[2] & 0xFF));

        displayStr.append(prefixZeros((int) objectGUID[1] & 0xFF));

        displayStr.append(prefixZeros((int) objectGUID[0] & 0xFF));

        displayStr.append("-");

        displayStr.append(prefixZeros((int) objectGUID[5] & 0xFF));

        displayStr.append(prefixZeros((int) objectGUID[4] & 0xFF));

        displayStr.append("-");

        displayStr.append(prefixZeros((int) objectGUID[7] & 0xFF));

        displayStr.append(prefixZeros((int) objectGUID[6] & 0xFF));

        displayStr.append("-");

        displayStr.append(prefixZeros((int) objectGUID[8] & 0xFF));

        displayStr.append(prefixZeros((int) objectGUID[9] & 0xFF));

        displayStr.append("-");

        displayStr.append(prefixZeros((int) objectGUID[10] & 0xFF));

        displayStr.append(prefixZeros((int) objectGUID[11] & 0xFF));

        displayStr.append(prefixZeros((int) objectGUID[12] & 0xFF));

        displayStr.append(prefixZeros((int) objectGUID[13] & 0xFF));

        displayStr.append(prefixZeros((int) objectGUID[14] & 0xFF));

        displayStr.append(prefixZeros((int) objectGUID[15] & 0xFF));


        return displayStr.toString();

    }


    private static String prefixZeros(int value) {

        if (value <= 0xF) {

            StringBuilder sb = new StringBuilder("0");

            sb.append(Integer.toHexString(value));


            return sb.toString();


        } else {

            return Integer.toHexString(value);

        }

    }

}

