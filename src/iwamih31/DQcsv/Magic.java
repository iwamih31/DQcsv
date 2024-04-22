package iwamih31.DQcsv;

public class Magic extends Ex{

	private static Object exList[][] = {
		{"*" ,"妖術名"  ,"=","使用MP","｛ "},
		{"1.","瞑想"    ,"=",   0    ,"  " },
		{"2.","死の術"  ,"=",  10    ,"  " },
		{"3.","炎の術"  ,"=", 100    ,"  " },////////////////100
		{"4.","血の契約","=",   0    ,"  " }
	};

	Magic(Character memb) {
		super(memb);
		itemList=exList;
	}

	public void spell() {
		switch (job) {
		case 1:
			praying();
			break;
		case 2:
			death();
			break;
		case 3:
			fire();
			break;
		case 4:
			desolation();
			break;
		default:
			exText = new String[]{"なにもしなかった"};
		}
	}

	private void fire() {
		arrayClear();
		if (Battle.getfMode() == 0) {
			Battle.pTable();
			getArray().add("敵が見当たらない ・・・");
		} else {
			if (mp < useMp) {
				notMp();
			} else {
				Battle.pTable();
				getArray().add(name + "は" + useEx + "を行った・・・");
				for (int i = 0; i < 4; i++) {
					Monster mo = Battle.mons[i];
					if (mo.getHp() > 0) {
						int r = new java.util.Random().nextInt(6);
						int g = new java.util.Random().nextInt(5);
						int dmg = (r * (20 - g) + lev * ep * 2);
						mo.setHp(mo.getHp() - dmg);
						System.out.println("★★★★★★★★★★★★★★★★★★★★");
						System.out.println("＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠");
						getArray().add(mo.getName() + "に" + dmg + "のダメージ!!!");
						if (mo.getHp() < 1) {
							Main.setG(Main.getG() + mo.getGp());
							user.setExp(user.getExp() + mo.getExp());
							getArray().add(name + "は" + mo.getName() + "を倒した!!!");
							System.out.println("  [Exp = " + user.getExp() + "] [G = "+ Main.getG() + "]");
							getArray().add(name + "は " + mo.getGp() + " Ｇと "+ mo.getExp() + " Ｐの経験値を手に入れた!!!");
						}
					}
				}
			}
		}
		setExText(getArray());
	}

	private void death() {
		if (Battle.getfMode() == 0) { ///////////// //アイテムの時と位置が違う
			Battle.pTable();
			exText = new String[]{"敵が見当たらない ・・・"};
		} else {
			if (mp < useMp) {
				System.out.println(user.getName() + "のMP=" + mp + " 消費MP=" + useMp);
				exText = new String[]{useEx + "を行うには力が足りません ×××"};
			} else {
				Battle.mList();
				exText = new String[]{useEx + "を、どのモンスターに行いますか？"};
				Controller.setMode(22503);
			}
		}
	}

	static void death(int who) {
		Magic.exText = new String[2];
		System.out.println("＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠");
		exText[0] = name + "は" + useEx + "を行った・・・";
		int r = new java.util.Random().nextInt(20) * user.getLev() / 2;
		if (r < 10) {
			Battle.mList();
			exText[1] = useEx + "は効かなかった";
		} else {
			Battle.getMons()[who].setHp(1);
			mp=(mp - (Integer) useMp);
			exText[1] = Battle.getMons()[who].getName() + "は瀕死の状態!!!";
		}
	}
}
