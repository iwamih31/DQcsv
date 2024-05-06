package iwamih31.DQcsv;

public class MEx extends Ex {

	MEx(Character character ,int what) {
		super(character);
		job = what;
		itemList=magicList;
		spell();
	}

	private static Object magicList[][] = {
		{"*" ,"施術名  ","=","使用MP","｛ "},
		{"1.","ﾄﾞｰﾋﾟﾝｸﾞ","=",  10    ,"  " },
		{"2.","蘇生術"  ,"=", 100    ,"  " },
		{"3.","毒爪攻撃","=",  10    ,"  " },
		{"4.","火炎吹き","=", 100    ,"  " },
		{"5.","堅い守り","=",   0    ,"  " },
		{"6.","抱え込み","=",   0    ,"  " }
	};

	public  void spell() {
		Battle.mList();
		Battle.pTable();
		useEx = itemList[job][1];
		useMp = (Integer) itemList[job][3];
		if ( mp < useMp ) {
//			exText = new String[] {"[ "+ name +" ]は[ " + useEx + " ]を行おうとしたが、あきらめた ×××"};
			exText = new String[] {"[ "+ name +" ]は様子をうかがっている・・・"};
		} else {
			switch (job) {
				case 1:
					heal();
					break;
				case 2:
					resu();
					break;
				case 3:
					poison();
					break;
				case 4:
					fire();
					break;
				case 5:
					guard();
					break;
				case 6:
					hug();
					break;
			default:
				exText = new String[] {"[ " + name + " ]はなにもしなかった・・・"};
			}
		}
		Battle.setBattleText(exText);
	}

	private static void hug() {
		if ( hp <= lev*20 ) {
			exText = new String[]{"[ "+ name +" ]は何も出来なかった・・・"};
		} else {
			Battle.mHug = (30);
			user.setHp(user.getHp() - lev * 20);
			exText = new String[2];
			exText[0] = "[ "+ name +" ]は[ " + useEx + " ]を行った・・・";
		}
	}

	private static void guard() {
			Battle.mGuard = true;
			Battle.setgM(null);
			exText = new String[2];
			exText[0] = "[ "+ name +" ]は[ " + useEx + " ]を行った・・・";
			exText[1] = "[ "+ name +" ]は全部受け止めた。";
	}

	private static void fire() {
		exText = new String[5];
		exText[0] = "[ "+ name +" ]は[ " + useEx + " ]を行った・・・";
		for (int i = 0; i < Main.getParty().length; i++) {
			Member p = Main.getParty()[i];
			if (p.getHp() > 0) {
				int r = new java.util.Random().nextInt(10);
				int dmg = (r * 25);
				p.setHp(p.getHp() - dmg);
				user.setMp((user.getMp() - useMp));
				exText[i + 1] = "[ "+ p.getName() +" ]は[ " + dmg + " ]のダメージを受けた!!!";
			}else{
				exText[i + 1] = "[ "+ p.getName() +" ]は死んでいる!!!";
			}
		}
	}

	private static void poison() {
		exText = new String[2];
		exText[0] = "[ "+ name +" ]は[ " + useEx + " ]を行った・・・";
		int r = new java.util.Random ( ).nextInt( 20 ) * lev / 2;
		if( r < 10) {
			exText[1] = "[ " + useEx + " ]は効かなかった・・・";
		} else {
			int who = new java.util.Random ( ).nextInt( 4 );
			Member p = Main.getParty() [ who ];
			p.setHp(p.getHp()/10);
			user.setMp(( user.getMp() - useMp ));
			exText[1] = "[ "+ p.getName() +" ]は瀕死の状態!!!";
		}
	}

	protected static void resu() {
		int who = new java.util.Random().nextInt(4);
		Character target = Battle.mons[who];
		if (target.getHp() > 0) {
			exText = new String[]{"[ "+ name +" ]は混乱している・・・"};
		} else {
			exText = new String[2];
			exText[0] = "[ "+ name +" ]は[ " + useEx + " ]を行った・・・";
			int r = new java.util.Random().nextInt(100) + 1;
			if (r > lev * ep) {
				exText[1] = "[ "+ useEx +" ]は失敗した・・・";
				user.setMp(user.getMp() - (useMp / 10));
			} else {
				target.setHp((int) (target.getLev() * 5));
				target.setMp((int) (target.getEp() * 10));
				exText[1] = "[ "+ target.getName() +" ]は生き返った!!!";
			}
			user.setMp(user.getMp() - useMp);
		}
	}

	protected static void heal() {
		int who = new java.util.Random().nextInt(4);
		Character target = Battle.mons [ who ];
		exText = new String[2];
		exText[0] = "[ "+ name +" ]は[ " + target.getName() + " ]に[ " + useEx + " ]を行った・・・";
		if (target.getHp() > 0) {
			int r = new java.util.Random().nextInt(3) + 1;
			int pP = new java.util.Random().nextInt(5);
			int rp = r * lev * ep / 2 + pP;
			target.setHp(target.getHp() + rp);
			user.setMp(( user.getMp() - useMp ));
			exText[1] = "[ "+ target.getName() +" ]のHPが[ " + rp + " ]回復した!!!";
		} else {
			exText[1] = "[ "+ target.getName() +" ]は死んでいた!!!";
		}
	}
}
