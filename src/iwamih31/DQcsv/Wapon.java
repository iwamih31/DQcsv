package iwamih31.DQcsv;

import javax.swing.table.AbstractTableModel;

public class Wapon extends AbstractTableModel{

	private static Object itemList[][] = {
		{""  ,""        ,"" ,""          ,"｛ "},
		{"１.","ヒロポン","(", 20 * lev(),"G) "},
		{"２.","毒針"    ,"(", 50 * lev(),"G) "},
		{"３.","爆弾"    ,"(",100 * lev(),"G) "}
	};
	private Object[][] shop;
	private static String[] shopText;

	public Wapon(int i){

		Member member = Main.getParty()[i];

		int wp1 = member.getWp() + 1;
		if (9 < wp1) wp1 = 9;
		int wp2 = member.getWp() + 2;
		if (9 < wp2) wp2 = 9;
		int wp3 = member.getWp() + 3;
		if (9 < wp3) wp3 = 9;

		int price1 = wp1 * wp1 * wp1 * 200;
		int price2 = wp2 * wp2 * wp2 * 200;
		int price3 = wp3 * wp3 * wp3 * 200;

		int minus1 = (wp1 - 1) * 1000;
		int minus2 = (wp2 - 1) * 1000;
		int minus3 = (wp3 - 1) * 1000;

		String weapon1 = member.getWeapon()[wp1];
		String weapon2 = member.getWeapon()[wp2];
		String weapon3 = member.getWeapon()[wp3];

		itemList = new Object[][]{
			{""   , ""                         , "" , ""             , "｛ "},
			{"１.", weapon1                    , "" , ""             , ""   },
			{""   , "攻=" + member.attack(wp1) , "(", price1 - minus1, "G) "},
			{"２.", weapon2                    , "" , ""             , ""   },
			{""   , "攻=" + member.attack(wp2) , "(", price2 - minus2, "G) "},
			{"３.", weapon3                    , "" , ""             , ""   },
			{"   ", "攻=" + member.attack(wp3) , "(", price3 - minus3, "G) "},
		};
	}

	private static int lev() {
		// TODO 自動生成されたメソッド・スタブ
		Member[] party = Main.getParty();
		int lev = (party[0].getLev() + party[1].getLev() + party[2].getLev() + party[3].getLev()) / (party.length);
		return lev;
	}

	public static void  item( int clickItem ) {

		System.out.println( clickItem );
	}

	public void setItemList(Object itemList[][]) {
		Wapon.itemList = itemList;
	}

	public static Object[][] getItemList() {
		return itemList;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		setShop();
		return shop[0][columnIndex].getClass();
	}

	@Override
	public String getColumnName(int column) {
		setShop();
		return (String) shop[column][0];
	}

	@Override
	public int getRowCount() {
		setShop();
		return shop.length;
	}

	@Override
	public int getColumnCount() {
		setShop();
		return shop[0].length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		setShop();
		return shop[rowIndex][columnIndex];
	}

	private void setShop() {
		shop = new Object[][] {
			{itemList[1][1]       , ""                 },
			{itemList[2][1] + " [", itemList[2][3]+"G]"},
			{itemList[3][1]       , ""                 },
			{itemList[4][1] + " [", itemList[4][3]+"G]"},
			{itemList[5][1]       , ""                 },
			{itemList[6][1] + " [", itemList[6][3]+"G]"},
		};
	}

	public static String[] getShopText() {
		return shopText;
	}
}

