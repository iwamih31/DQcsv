package iwamih31.DQcsv;


public class Common {

	/**
	 * コンソールに引数 string を表示（上下に空白行付き）
	 * @param string - コンソールに表示する文字列
	 */
	public static void ___logOut___(String string) {
		System.out.println("");
		System.out.println(string);
		System.out.println("");
	}

	/**
	 * 引数 string の文字バイト数を返す
	 * @param string - 文字バイト数を返す文字列
	 * @return 文字バイト数
	 */
	public static int character_Bytes(String string) {
		int character_Bytes = 0;
		char[] chars = string.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			character_Bytes += (String.valueOf(chars[i]).getBytes().length);
		}
		___logOut___("文字バイト数 = " + character_Bytes);
		return character_Bytes;
	}

	/**
	 * 引数 string の文字バイト数が引数 max_Bytes 以下か？を返す
	 * @param string - 対象文字列
	 * @param max_Bytes - 判定ライン値
	 * @return 文字バイト数が判定ライン値以下なら true 超える場合は false
	 */
	public static boolean isBelow_Character_Bytes(String string, int max_Bytes) {
		// 文字バイト数を取得
		int character_Bytes = Common.character_Bytes(string);
		if (character_Bytes <= max_Bytes) {
			___logOut___("文字バイト数は " + max_Bytes + "以下です");
			return true;
		} else {
			___logOut___("文字バイト数は " + max_Bytes + "を超えています");
			return false;
		}
	}
}


