package iwamih31.DQcsv;

public class MEx extends Ex {

	MEx(Character memb ,int what) {
		super(memb);
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
		if(job < 1 || job > 6){
		}else{
		useEx = itemList[job][1];
		useMp = (Integer) itemList[job][3];
		}
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
			System.out.println( name  + "は、なにもしなかった");
			Battle.setBattleText(new String[]{"[ "+ name +" ]なにもしなかった・・・"});
		}
	}

	private static void hug() {
		if ( hp <= lev*20 ) {
			System.out.println( name  + "は何も出来なかった・・・" );
			Battle.setBattleText(new String[]{"[ "+ name +" ]は何も出来なかった・・・"});
		} else {
			System.out.println( name  + "は" + useEx + "を行った・・・" );
			Battle.mHug = (30);
			user.setHp(user.getHp() - lev * 20);
			String[] text = new String[2];
			text[0] = "[ "+ name +" ]は[ " + useEx + " ]を行った・・・";
		}
	}

	private static void guard() {
			System.out.println( name  + "は" +useEx + "を行った・・・" );
			String[] text = new String[2];
			text[0] = "[ "+ name +" ]は[ " + useEx + " ]を行った・・・";
			Battle.mGuard = true;
			Battle.setgM(null);
			System.out.println( "全部受け止めた。" );
			text[0] = "[ "+ name +" ]は全部受け止めた。";
	}

	private static void fire() {
		if ( mp < useMp ) {
			System.out.println( name + "は様子を窺っている" );
			Battle.setBattleText(new String[]{"[ "+ name +" ]は様子を窺っている・・・"});
		} else {
			System.out.print(name + "は");
			System.out.println(useEx + "を行った・・・");
			String[] text = new String[5];
			text[0] = "[ "+ name +" ]は[ " + useEx + " ]を行った・・・";
			for (int i = 0; i < Main.getParty().length; i++) {
				Member p = Main.getParty()[i];
				if (p.getHp() > 0) {
					int r = new java.util.Random().nextInt(10);
					int dmg = (r * 25);
					p.setHp(p.getHp() - dmg);
					System.out.println("＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠");
					System.out.print(p.getName() + "は" + dmg + "のダメージを受けた!!!");
					System.out.println("★★★★★★★★★★★★★★★★★★★★");
					user.setMp((user.getMp() - useMp));
					text[i + 1] = "[ "+ p.getName() +" ]は[ " + dmg + " ]のダメージを受けた!!!";
				}else{
					text[i + 1] = "[ "+ p.getName() +" ]は死んでいる!!!";
				}
			}
			Battle.setBattleText(text);
		}
	}

	private static void poison() {
		if ( mp < useMp ) {
			System.out.println( name + "は様子を窺っている" );
			Battle.setBattleText(new String[]{"[ "+ name +" ]は様子を窺っている・・・"});
		} else {
			System.out.print( name  + "は" );
			System.out.println( useEx + "を行った・・・" );
			String[] text = new String[2];
			text[0] = "[ "+ name +" ]は[ " + useEx + " ]を行った・・・";
			int r = new java.util.Random ( ).nextInt( 20 ) * lev / 2;
			if( r < 10) {
				System.out.println( useEx + "は効かなかった" );
				text[1] = "[ " + useEx + " ]は効かなかった・・・";
			} else {
				int who = new java.util.Random ( ).nextInt( 4 );
				Member p = Main.getParty() [ who ];
				p.setHp(1);
				user.setMp(( user.getMp() - useMp ));
				System.out.println( p.getName() + "は瀕死の状態!!!" );
				text[1] = "[ "+ p.getName() +" ]は瀕死の状態!!!";
			}
		}
	}

	protected static void resu() {
		if ( mp < useMp ) {
			System.out.println( useEx + "を行おうとしたが、あきらめた ×××" );
			Battle.setBattleText(new String[]{"[ "+ name +" ]は[ " + useEx + " ]を行おうとしたが、あきらめた ×××"});
		} else {
			int who = new java.util.Random().nextInt(4);
			Character select = Battle.mons[who];
			if (select.getHp() > 0) {
				System.out.println(name + "は混乱している・・・");
				Battle.setBattleText(new String[]{"[ "+ name +" ]は混乱している・・・"});
			} else {
				System.out.println(name + "は" + useEx + "を行った・・・");
				String[] text = new String[2];
				text[0] = "[ "+ name +" ]は[ " + useEx + " ]を行った・・・";
				int r = new java.util.Random().nextInt(100) + 1;
				if (r > lev * ep) {
					System.out.println(useEx + "は失敗した");
					text[1] = "[ "+ useEx +" ]は失敗した・・・";
					user.setMp(user.getMp() - (useMp / 10));
				} else {
					System.out.println(select.getName() + "は生き返った!!!");
					select.setHp((int) (select.getLev() * 5));
					select.setMp((int) (select.getEp() * 10));
					text[1] = "[ "+ select.getName() +" ]は生き返った!!!";
				}
				user.setMp(user.getMp() - useMp);
			}
		}
	}

	protected static void heal() {
		if ( mp < useMp ) {
			System.out.println( useEx + "を行おうとしたが、あきらめた ×××" );
			Battle.setBattleText(new String[]{"[ "+ name +" ]は[ " + useEx + " ]を行おうとしたが、あきらめた ×××"});
		} else {
			int who = new java.util.Random ( ).nextInt( 4 );
			Character select = Battle.mons [ who ];
			System.out.println(name + "は" + select.getName() + "に" + useEx + "を行った・・・");
			String[] text = new String[2];
			text[0] = "[ "+ name +" ]は[ " + select.getName() + " ]に[ " + useEx + " ]を行った・・・";
			if (select.getHp() > 0) {
				int r = new java.util.Random().nextInt(3) + 1;
				int pP = new java.util.Random().nextInt(5);
				int rp = r * lev * ep / 2 + pP;
				select.setHp(select.getHp() + rp);
				System.out.println(select.getName() + "のHPが" + rp + "回復した!!!");
				user.setMp(( user.getMp() - useMp ));
				text[1] = "[ "+ select.getName() +" ]のHPが[ " + rp + " ]回復した!!!";
			} else {
				System.out.println(select.getName() + "は死んでいた!!!");
				text[1] = "[ "+ select.getName() +" ]は死んでいた!!!";
			}
		}
	}
}
