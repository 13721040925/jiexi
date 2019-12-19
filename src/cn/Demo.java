package cn;

import java.math.BigInteger;

public class Demo {
	// 2000 10 12 12 12 12
	// ~10|01|47|42|E002|FF|FD0A
	// 0/1 2/ 3 4/ 5 6/ 7 8/ 9 10 11 12/13 14/15 16 17 18/19
	private static String commend = "7E 31 30 30 31 34 37 34 32 45 30 30 32 46 46 46 44 30 41 0D";
	private static String arr[] = commend.split(" ");

	public static String hex2Str(String hex) {
		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		// 49204c6f7665204a617661 split into two characters 49, 20, 4c...
		for (int i = 0; i < hex.length() - 1; i += 2) {
			// grab the hex in pairs
			String output = hex.substring(i, (i + 2));
			// convert hex to decimal
			int decimal = Integer.parseInt(output, 16);
			// convert the decimal to character
			sb.append((char) decimal);
			temp.append(decimal);
		}
		return sb.toString();
	}

	/**
	 * ʮ�������ַ���װʮ����
	 * 
	 * @param hex
	 *            ʮ�������ַ���
	 * @return ʮ������ֵ
	 */
	public static int hexStringToAlgorism(String hex) {
		hex = hex.toUpperCase();
		int max = hex.length();
		int result = 0;
		for (int i = max; i > 0; i--) {
			char c = hex.charAt(i - 1);
			int algorism = 0;
			if (c >= '0' && c <= '9') {
				algorism = c - '0';
			} else {
				algorism = c - 55;
			}
			result += Math.pow(16, max - i) * algorism;
		}
		return result;
	}

	public static String getVersion() {
		String v = new BigInteger(hex2Str(arr[2]), 16).toString();
		String version = hex2Str(arr[1]) + "." + v;
		return version;

	}
	public static String getVER() {
		String VER = hex2Str(arr[1]) + hex2Str(arr[2]);
		return VER;

	}

	public static String getADR() {
		String ADR = hex2Str(arr[3]) + hex2Str(arr[4]);
		return ADR;

	}

	public static String getCID1() {
		String CID1 = hex2Str(arr[5]) + hex2Str(arr[6]);
		return CID1;

	}
	public static String getCID2() {
		String CID2 = hex2Str(arr[7]) + hex2Str(arr[8]);
		return CID2;
	}

	public static String CID2toCOM(String CID2) {
		String com = "";
		int hex_85H = hexStringToAlgorism("85");
		int hex_EFH = hexStringToAlgorism("EF");
		int hex_CID2 = hexStringToAlgorism(CID2);
		if (hex_CID2 >= hex_85H && hex_CID2 <= hex_EFH) {
			com = "�û��Զ���";
			return com;
		}
		switch (CID2) {
		case "42": {
			com = "��ȡģ�������������ݣ���������";
			break;
		}
		case "43": {
			com = "��ȡ������״̬";
			break;
		}
		case "44": {
			com = "��ȡ�澯״̬";
			break;
		}
		case "45": {
			com = "ң��";
			break;
		}
		case "47": {
			com = "��ȡϵͳ��������������";
			break;
		}
		case "49": {
			com = "�趨ϵͳ��������������";
			break;
		}
		case "4B": {
			com = "��ȡ��ʷ����*";
			break;
		}
		case "4C": {
			com = "��ȡ��ʷ�澯*";
			break;
		}
		case "4D": {
			com = "��ȡ����豸ʱ��*";
			break;
		}
		case "4E": {
			com = "�趨����豸ʱ��*";
			break;
		}
		case "4F": {
			com = "��ȡͨ��Э��汾��";
			break;
		}
		case "50": {
			com = "��ȡ�豸��ַ";
			break;
		}
		case "80": {
			com = "��ȡң����Ϣ";
			break;
		}
		case "81": {
			com = "��ȡ��ʷ�澯����";
			break;
		}
		case "82": {
			com = "��������ָ��";
			break;
		}
		case "83": {
			com = "������������Ϣ";
			break;
		}
		case "84": {
			com = "��ȡ��������Ϣ";
			break;
		}
		}
		return com;

	}

	public static String getLENGTH() {
		String LENGTH = hex2Str(arr[9]) + hex2Str(arr[10]) + hex2Str(arr[11]) + hex2Str(arr[12]);
		return LENGTH;

	}

	// INFO���ASCII���ֽ���
	public static int getLENID(String LENGTH) {
		String str = LENGTH.substring(1, LENGTH.length());
		return hexStringToAlgorism(str);

	}

	public static String getINFO(int LENID) {
		int len = LENID / 2;
		String INFO = "";
		for (int i = 1; i <= len * 2; i++) {
			INFO += hex2Str(arr[12 + i]);
		}
		return INFO;

	}

	public static String getCHKSUM() {
		String CHKSUM = hex2Str(arr[arr.length - 5]) + hex2Str(arr[arr.length - 4]) + hex2Str(arr[arr.length - 3])
				+ hex2Str(arr[arr.length - 2]);
		return CHKSUM;

	}

	public static String getResult() {
		String result = "~" + getVER() + getADR() + getCID1() + getCID2() + getLENGTH() + getINFO(getLENID(getLENGTH()))
				+ getCHKSUM() + "\\R";
		return result;

	}

	public static void main(String[] args) {
		System.out.println(getResult());
		System.out.println(getResult().length());
	}
	// ~10014742E002FFFD0A
}
