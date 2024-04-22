package iwamih31.DQcsv;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class Item extends AbstractTableModel{
	private static Object[][] itemList = {
		{""   ,""        ,""    ,"" ,""   },
		{"１.","ヒロポン","[残=", 3 ,"] " },
		{"２.","毒針"    ,"[残=", 3 ,"] " },
		{"３.","爆弾"    ,"[残=", 2 ,"] " },
		{"４.","命の玉"  ,"[残=", 1 ,"] " }
	};

	private static Object[][] item = {
		{itemList[1][1], "[残="+itemList[1][3]+"]" },
		{itemList[2][1], "[残="+itemList[2][3]+"]" },
		{itemList[3][1], "[残="+itemList[3][3]+"]" },
		{itemList[4][1], "[残="+itemList[4][3]+"]" }
	};

	protected static Object useI;
	protected static String p;

	private static String[] itemText;

	public static void bag(Member user) {
		System.out.print("｛");
		for (Object[] stocks : itemList) {
			for (Object stock : stocks) {
				System.out.print(stock);
			}
		}
		System.out.println("｝");
		System.out.println("");
	}

	static void use(Member user, int inp) {
		// TODO 自動生成されたメソッド・スタブ
		inp = inp + 1;
		int stock = -1;
		p = user.getName();
		if (p.equals("旅人")) {
			p = Main.getName();
		}
		if (0 < inp && inp < 5) {
			useI = itemList[inp][1];
			// Ofjectであるストック数をIntegerに変換しstock1に代入
			stock = (Integer) itemList[inp][3];
		}
		if (stock == 0) {
			System.out.println(itemList[inp][1] + "は持っていません ×××");
			itemText = new String[1];
			itemText[0] = (itemList[inp][1] + "は持っていません ×××");
		} else {
			switch (inp) {
				case 1 :
					Battle.pTable();
//					Battle.pList();
					Main.controller.setMessage("[ "+ useI + " ]を誰に使いますか？");
					itemText = new String[2];
					itemText[0] = (p + "は" + useI + "を使った・・・");
					itemText[1] = ("○○のHPが○○回復した❤❤❤");
					break;
				case 2 :
					if (Battle.getfMode() == 0) {
						noMonster();
					} else {
						Battle.mList();
						Main.controller.setMessage("[ "+ useI + " ]をどのモンスターに使いますか？");
						itemText = new String[2];
						itemText[0] = (p + "は" + useI + "を使った・・・");
						itemText[1] = (useI + "は効かなかった");
					}
					break;
				case 3 :
						if (Battle.getfMode() == 0) {
							noMonster();
						} else {//////////////////////////////////////////////////////////////＊未作成＊
							ArrayList<String> text = new ArrayList<String>();
							System.out.print(p + "は");
							System.out.println(useI + "を使った・・・");
							text.add("[ "+ p + " ]は[ " + useI + " ]を使った・・・");
							for (int i = 0; i < 4; i++) {
								Monster mo = Battle.mons[i];
								if (mo.getHp() > 0) {
									int r = new java.util.Random().nextInt(10);
									int pP = new java.util.Random().nextInt(5);
									int dmg = (r * (25 - pP));
									mo.setHp(mo.getHp() - dmg);
									System.out.println("★★★★★★★★★★★★★★★★★★★★");
									System.out.println(mo.getName() + "に" + dmg + "のダメージ!!!");
									System.out.println("＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠");
									text.add("[ " + mo.getName() + " ]に[ " + dmg + " ]のダメージ!!!");
									if (mo.getHp() < 1) {
										Main.setG(Main.getG() + mo.getGp());
										user.setExp(user.getExp() + mo.getExp());
										System.out.println(p + "は" + mo.getName() + "を倒した!!!");
										System.out.println("");
										text.add("[ "+ p + " ]は[ " + mo.getName() + " ]を倒した!!!");
										System.out.print(p + "は " + mo.getGp() + " Ｇと " + mo.getExp() + " Ｐの経験値を手に入れた!!!");
										System.out.println("  [Exp = " + user.getExp() + "] [G = " + Main.getG() + "]");
										text.add("[ "+ p + " ]は[ " + mo.getGp() + " ]Ｇと[ " + mo.getExp() + " ]Ｐの経験値を手に入れた!!!");
									}
								}
							}
							itemList[inp][3] = (stock - 1);
							itemText = new String[text.size()];
							for (int i = 0; i < text.size(); i++) {
								itemText[i] = text.get(i);
							}
							Battle.setBattleText(itemText);
						}
					break;
				case 4 :
					Battle.pTable();
					System.out.println("");
					System.out.print("[ "+ useI + " ]を誰に使いますか？");
//					Battle.pList();
					System.out.println("");
					Main.controller.setMessage("[ "+ useI + " ]を誰に使いますか？");
					itemText = new String[2];
					itemText[0] = (p + "は" + useI + "を使った・・・");
					itemText[1] = ("○○は生き返った!!!");
					break;
				default :
					System.out.println(p + "は、何もしなかった");
					itemText = new String[]{p + "は、何もしなかった"};
			}
			if (inp < 0 || inp > (itemList.length - 1)) {
			} else {
				Battle.pTable();
				System.out.println("");
				System.out.println("  [ " + itemList[inp][1] + " ] 残り数=[ " + itemList[inp][3] + " ]個");
			}
		}
		Battle.setBattleText(itemText);
	}

	static void who1(int who) {
		int inp = 1;
		int stock = (Integer) itemList[inp][3];
		Member select = Main.getParty()[who];
		int fH = select.getHp();
		if (select.getHp() > 0) {
			System.out.println(p + "は" + useI + "を使った・・・");
			int r = new java.util.Random().nextInt(7) + 20;
			int rp = r + (select.getAp() * 3);/////////////////////回復値
			select.setHp((select.getHp() + rp));
			if (select.getHp() > (select.getLev() * select.getAp() * 10)) {
				select.setHp(select.getLev() * select.getAp() * 10);
			}
			int rH = select.getHp() - fH;
			System.out.println(select.getName() + "のHPが" + rH + "回復した❤❤❤");
			itemText[1] = (select.getName() + "のHPが" + rH + "回復した❤❤❤");
			itemList[inp][3] = (stock - 1);
		} else {
			System.out.println(select.getName() + "は死んでいた!!!");
			itemText[1] = (select.getName() + "は死んでいた!!!");
		}
		Battle.setBattleText(itemText);
	}

	static void who2(int who) {
		int inp = 2;
		int stock = (Integer) itemList[inp][3];
		System.out.println("＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠");
		System.out.println("");
		System.out.print(p + "は");
		System.out.println(useI + "を使った・・・");
		int r = new java.util.Random().nextInt(4);
		if (r == 1) {
			Battle.mList();
			System.out.println("");
			System.out.println(useI + "は効かなかった");
			itemText[1] = (useI + "は効かなかった");
		} else {
			int mons_HP = Battle.getMons()[who].getHp();
			Battle.getMons()[who].setHp(mons_HP / 10);
			Battle.mList();
			System.out.println("");
			System.out.println(Battle.getMons()[who].getName() + "は瀕死の状態!!!");
			itemText[1] = (Battle.getMons()[who].getName() + "は瀕死の状態!!!");
		}
		itemList[inp][3] = (stock - 1);
		Battle.setBattleText(itemText);
	}

	private static void who3(int i) {
		Battle.setBattleText(itemText);
	}

	static void who4(int who) {
		int inp = 4;
		int stock = (Integer) itemList[inp][3];
		Member select = Main.getParty()[who];
		System.out.println(p + "は" + select.getName() + "に" + useI + "を使った・・・");
		if (select.getHp() > 0) {
			select.setHp(select.getLev() * select.getAp() * 10);
			select.setMp(select.getLev() * select.getEp() * 3);
			System.out.println(select.getName() + "は全快した!!!");
			itemText[1] = (select.getName() + "は全快した!!!");
		} else {
			System.out.println(select.getName() + "は生き返った!!!");
			itemText[1] = (select.getName() + "は生き返った!!!");
			select.setHp(select.getLev() * select.getAp() * 3);
			select.setMp(select.getLev() * select.getEp() * 3);
		}
		itemList[inp][3] = (stock - 1);
		Battle.setBattleText(itemText);
	}

	private static void noMonster() {
		System.out.println("");
		System.out.println("敵が見当たらない ・・・");
		System.out.println("");
		itemText = new String[1];
		itemText[0] = ("敵が見当たらない ・・・");
	}

	public static void plus(int i) {
		itemList[i][3] = ((Integer) itemList[i][3] + 1);
		System.out.print(itemList[i][1]);
	}

	public static void item(int clickItem) {
		System.out.println(clickItem);
	}

	public static void setItemList(Object[][] i) {
		Item.itemList = i;
	}

	public static Object[][] getItemList() {
		return itemList;
	}

	public static void items() {
		for (Object[] stocks : itemList) {
			System.out.print(stocks[1]);
			System.out.print(stocks[2]);
			System.out.print(stocks[3]);
			System.out.print(stocks[4]);
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return item[0][columnIndex].getClass();
	}

	@Override
	public String getColumnName(int column) {
		return (String) item[column][0];
	}

	@Override
	public int getRowCount() {
		return item.length;
	}

	@Override
	public int getColumnCount() {
		return item[0].length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		setItem();
		return item[rowIndex][columnIndex];
	}

	private void setItem() {
		item = new Object[][] {
			{itemList[1][1], "[残="+itemList[1][3]+"]" },
			{itemList[2][1], "[残="+itemList[2][3]+"]" },
			{itemList[3][1], "[残="+itemList[3][3]+"]" },
			{itemList[4][1], "[残="+itemList[4][3]+"]" }
		};
	}

	public static Object[] menu() {
		Object[] menu = new Object[itemList.length-1];
		for (int i = 0; i < menu.length; i++) {
			menu[i] = itemList[i+1][1];
		}
		return menu;
	}

	public static void setItemText(String[] itemText) {
		Item.itemText = itemText;
	}

	public static String[] getItemText() {
		return itemText;
	}

	public static String get_Item_Name(int item_Number) {
		return (String) itemList[item_Number][1];
	}
}
