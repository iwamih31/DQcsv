package iwamih31.DQcsv;

import javax.swing.table.AbstractTableModel;

public class Shop extends AbstractTableModel{

	private static Object itemList[][] = {
		{""  ,""        ,"" ,""          ,"｛ "},
		{"１.","ヒロポン","(", 20 * lev(),"G) "},
		{"２.","毒針"    ,"(", 50 * lev(),"G) "},
		{"３.","爆弾"    ,"(",100 * lev(),"G) "},
		{"４.","命の玉"  ,"(",300 * lev(),"G) "}
	};

	private Object[][] shop;
	private static String[] shopText;
	private static Member member;

	private static int lev() {
		Member[] party = Main.getParty();
		int lev = (party[0].getLev() + party[1].getLev() + party[2].getLev() + party[3].getLev()) / (party.length);
		return lev;
	}

	public static void sellItem(Member user, int sellItem) {
		int item = sellItem + 1;
		for (Object[] stocks : itemList) {
			for (Object stock : stocks) {
				System.out.print(stock);
			}
		}
		System.out.println("｝＊()の半額=売値");
		System.out.println("");
		System.out.print("[所持金＝" + Main.getG() + "G] ");
		String name = user.getName();
		if (user == Main.getHu()) name = Main.getName();
		int stock = (Integer) Item.getItemList()[item][3];
		for (int i = 1; i < itemList.length; i++) {
			itemList[i][3]=(Integer)itemList[i][3]/2;
		}
		int g = (Integer) itemList[item][3];
		Battle.pTable();
		Main.setG(Main.getG() + g);
		Item.getItemList()[item][3] = stock - 1;
		shopText = new String[3];
		shopText[0] = (name + "は[" + itemList[item][1] + "]を売って[" + g + "G]手に入れた!");
		shopText[1] = (" 財布の中身は[" + Main.getG() + "G]です");
		shopText[2] = (" ありがとうございました♪ (*^o^*)y-.。o○");
	}

	public static void buyItem(int buyItem) {
		int item = buyItem + 1;
		for (Object[] stocks : itemList) {
			for (Object stock : stocks) {
				System.out.print(stock);
			}
		}
		System.out.println("｝＊()=買い値");
		System.out.println("");
		System.out.print("[所持金＝" + Main.getG() + "G] ");
		String name = Main.getName();
		int stock = (Integer) Item.getItemList()[item][3];
		int buyPrice = (Integer) itemList[item][3];
		if (Main.getG() < buyPrice) {
			Battle.pTable();
			shopText = new String[]{ itemList[item][1] + "を買うには、お金が足りません  ×××" };
		} else {
			Battle.pTable();
			Main.setG(Main.getG() - buyPrice);
			Item.getItemList()[item][3] = stock + 1;
			shopText = new String[3];
			shopText[0] = (name + "は[" + itemList[item][1] + "]を[" + buyPrice + "G]で手に入れた!");
			shopText[1] = (" 財布の中身は[" + Main.getG() + "G]です");
			shopText[2] = (" ありがとうございました♪ (*^o^*)y-.。o○");
		}
	}

	public static void buyWapon(int party_Number) {
		member = Main.getParty()[party_Number];
		Battle.pTable();
		System.out.println( "" );
		System.out.print( "１." );
		member.wep(1);
		System.out.print( "(" + (( member.getWp() + 1) * 200 * 1 * 1 ) + "Ｇ)" );
		System.out.print( "２." );
		member.wep(2);
		System.out.print( "(" + (( member.getWp() + 2) * 200 * 2 * 2 ) + "Ｇ)" );
		System.out.print( "３." );
		member.wep(3);
		System.out.print( "(" + (( member.getWp() + 3) * 200 * 3 * 3 ) + "Ｇ)" );
		System.out.println( "" );
		Controller.setMessage( "どれにいたしましょう？" );
		Controller.setMenu(new String[]{member.wepName(1),member.wepName(2),member.wepName(3)});
	}

	static void buyWaponWhich(int inp) {
		if (0 < inp && inp < 4) {
			int wp = member.getWp();
			int inpWp = wp + inp;
			String buyWapon = member.wepName(inp);
			int buyPrice = (inpWp * inpWp * inpWp * 200) - ((inpWp - 1) * 1000);
			String sellWapon = member.wepName(0);
			int sellPrice = ((wp * wp * wp * 200) - ((wp - 1) * 1000)) / 2;
			status();
			if (Main.getG() < buyPrice) {
				shopText = new String[1];
				shopText[0] = buyWapon + "を買うには、お金が足りません  ×××";
			} else {
				Main.setG(Main.getG() - buyPrice + sellPrice);
				member.setWp(member.getWp() + inp);
				shopText = new String[2];
				shopText[0] = buyWapon + "だね。まいどあり!!";
				shopText[1] = sellWapon + "は(" + sellPrice + "Ｇ)で引き取ってくれた・・・";
			}
		} else {
			leave();
		}
	}

	private static void status() {
		Battle.pTable();
		Common.___logOut___("<所持金(" + Main.getG() + "Ｇ)> ");
	}

	public static void leave() {
		Battle.pTable();
		shopText = new String[]{ "また来てくださいね （*^o^*）" };
	}

	public static void  item( int clickItem ) {
		System.out.println( clickItem );
	}

	public void setItemList(Object itemList[][]) {
		Shop.itemList = itemList;
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
			{itemList[1][1], "["+itemList[1][3]+"]" },
			{itemList[2][1], "["+itemList[2][3]+"]" },
			{itemList[3][1], "["+itemList[3][3]+"]" },
			{itemList[4][1], "["+itemList[4][3]+"]" }
		};
	}

	public static String[] getShopText() {
		return shopText;
	}
}

