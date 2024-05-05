package iwamih31.DQcsv;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class Battle extends AbstractTableModel{

	private static Object menuList[ ][ ] = {
		{"","どうしますか?｛ "     },
		{"1."          ,"戦う"     },
		{"2."          ,"道具"     },
		{"3."          ,"能力"     },
		{"4."          ,"逃げる"   }
	};

	private static Object menu[] = {
		menuList[1][1],
		menuList[2][1],
		menuList[3][1],
		menuList[4][1],
	};

	private static Member[] par = Main.getParty ( );

	static Member fi = par [ 0 ];
	static Member he = par [ 1 ];
	static Member pr = par [ 2 ];
	static Member mg = par [ 3 ];

	private static Object pList[ ][ ] = {
		{""  ,""                                                                                           },
		{"１=",fi.getName( ) + " [Lev." + fi.getLev( ) + " HP=" + fi.getHp( ) + ",MP=" + fi.getMp( ) + "]  "},
		{"２=",he.getName( ) + " [Lev." + he.getLev( ) + " HP=" + he.getHp( ) + ",MP=" + he.getMp( ) + "]  "},
		{"３=",pr.getName( ) + " [Lev." + pr.getLev( ) + " HP=" + pr.getHp( ) + ",MP=" + pr.getMp( ) + "]  "},
		{"４=",mg.getName( ) + " [Lev." + mg.getLev( ) + " HP=" + mg.getHp( ) + ",MP=" + mg.getMp( ) + "]  "}
	};

	static Monster[] mons ;

	int pHp;
  int mHp;

  private static int k;
  private static int mK;

  public static int fly;

	public static boolean pGuard;
	public static boolean mGuard;

	public static int pHug;
	public static int mHug;

	private int pFSp = 10;// Ｐメンバーの先制攻撃率( 1/mSF回 )
	private int mFSp = 10;// モンスターの先制攻撃率( 1/mSF回 )

	private int pfs;
	private int mfs;

	private int p1s;
	private int p2s;
	private int p3s;
	private int p4s;

	private int p1h;
	private int p2h;
	private int p3h;
	private int p4h;

	private int m1s;
	private int m2s;
	private int m3s;
	private int m4s;

	private int m1h;
	private int m2h;
	private int m3h;
	private int m4h;

	private int p;

	private ArrayList<Integer> turn;

	private int count;

	private static int[] fpExp;

	private static int fg;

	private int around;

	private int monsNum;

	private static int actor;

	private static int fMode = 0;

	private static Monster gM ;

	private static String[] mNa;

	private static Object[][] mSt;

	private static String[] battleText;

	private static int item;

	private static ArrayList<String> array;

	Battle() {
		monsNum = 4;
		mons = new Monster[ monsNum ];
		par = Main.getParty();
		pHp = 1;
		mHp = 1;
		k = 1;
		mK =1;
		fly = 1;
		pGuard = false;
		mGuard = false;
		gM = mons[3];//////////モンスター側の[ガード]使用者判別用スイッチ
	}

	public void battle() {									/////敵の出現
		Common.___logOut___("battle() します");
		fMode = 1;
		item = 0;
		for( int i = 0 ; i < monsNum ; i++ ) {
			int r = new java.util.Random ( ).nextInt( 10 ) + 1;
			switch ( r ) {
				case 1:
					mons[i] = new Slime( i + 1 );
					break;
				case 2:
					mons[i] = new MadDoctor( i + 1 );
					break;
				case 3:
					mons[i] = new Golem( i + 1 );
					break;
				case 4:
					int lev = 80-par[0].getLev()+par[1].getLev()+par[2].getLev()+par[3].getLev();
					int dora = new java.util.Random ( ).nextInt( 3 + lev);//[ 1 : nextInt(x) = Doragon : MadDoctor ]
					switch ( dora ) {
						case 1:
							mons[i] = new Dragon( i + 1 );
							break;
						default:
							mons[i] = new MadDoctor( i + 1 );
							break;
					}
					break;
				case 5:
					int bos = new java.util.Random ( ).nextInt( 50 );//[ 1 : nextInt(x) = Boss : Slime ]
					switch ( bos ) {
						case 1:
							mons[i] = new Boss( i + 1 );
							break;
						default:
							mons[i] = new Slime( i + 1 );
							break;
					}
					break;
				default:
					mons[i] = new Air( i + 1 );
					break;
			}
		}
		initial();
		if( mHp < 1 ){
			System.out.println("");
			System.out.println("  ＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
			Robot rob;              //////////表示ディレイ
			try {
				rob = new Robot();
				rob.delay(1000);
			} catch (AWTException e1) {
				e1.printStackTrace();
			}
			System.out.println("");
		    System.out.println("気のせいだったようだ・・・");
		    System.out.println("");
		    battleText = new String[]{ "気のせいだったようだ・・・" };
		    fMode = 0;
		    Main.controller.setMode(555);
		}else{
			System.out.println( "" );
			mList();
			Robot rob;              //////////表示ディレイ
			try {
				rob = new Robot();
				rob.delay(1000);
			} catch (AWTException e1) {
				System.out.println("エラー");
				e1.printStackTrace();
			}
			battleText = new String[]{};//////////////////////////////////////戦闘開始(事前設定)
			fpExp = new int[par.length];//////////////////////////戦闘前経験値
			for (int i = 0; i < fpExp.length; i++) {
				fpExp[i] = par[i].getExp();
			}
			fg = Main.getG();//////////////////////////戦闘前所持金
			k = 1;
			mK = 1;
			fly = 1;
			pFSp = 10;
			mFSp = 10;
			gM = null;
			pHug = 0;
			mHug = 0;
			fMode = 1;
			if( pHp > 0 && mHp > 0 && fMode == 1){              //////////
			}else{                                              //確認用//
				System.out.println("この時点で終了しています");   //////////                                   //
			}                                                   //////////
			count = 1;
			fight();
		}
	}



	public void fight() {
		Common.___logOut___("Battle.fight() します");
		if (is_Fight()) { ///////////////////////戦闘中↓
			int rs = new java.util.Random().nextInt(pFSp);
			if (rs == 0) {
				pfs = (0);
			} else {
				pfs = (5);
			}
			int mrs = new java.util.Random().nextInt(mFSp);
			if (mrs == 0) {
				mfs = (0);
			} else {
				mfs = (5);
			}
			for (Member member : par) {
				member.setHp(member.getHp() - 1);
				member.setMp(member.getMp() + 1);
			}
			initial();
			// ターン(順番)決め
			turn = new ArrayList<Integer>();
			for (int i = 30; i > 0; i--) {
				gM = null;
				if (p1s + pfs + mHug == i && 0 < p1h) {
					turn.add(0);
				}
				if (p2s * fly + pfs + mHug == i && 0 < p2h) {
					turn.add(1);
				}
				if (p3s + pfs + mHug == i && 0 < p3h) {
					turn.add(2);
				}
				if (p4s + pfs + mHug == i && 0 < p4h) {
					turn.add(3);
				}
				if (m1s + mfs + pHug == i && 0 < m1h) {
					turn.add(4);
				}
				if (m2s + mfs + pHug == i && 0 < m2h) {
					turn.add(5);
				}
				if (m3s + mfs + pHug == i && 0 < m3h) {
					turn.add(6);
				}
				if (m4s + mfs + pHug == i && 0 < m4h) {
					turn.add(7);
				}
			}
			Common.___logOut___(count + "ターン目開始");
			count++;
			around = 0;
			turn();
		} else {
			if (pHp > 0 && 1 > mHp) { //戦闘終了後(勝ちの場合)
				battleText = new String[]{ Main.getName() + "は" + Main.getmName() + "に勝利した♪" };
				pTable();
				Main.controller.setMode(5555);
			}
			if (pHp < 1) { // 全滅時
				battleText = new String[]{ Main.getName() + "は全滅した・・・" };
				initial();
				for (Member p : par) {
					p.setHp(p.getLev() * p.getAp() * 10);
					p.setMp(p.getLev() * p.getEp() * 3);
				}
				// 持ち金半減
				Main.setG(Main.getG() / 2);
				// 続き
				Story.relief();
				Main.controller.setMode(9);
			}
		Main.save();
		}
	}

	private boolean is_Fight() {
		if(0 < pHp && 0 < mHp && fMode == 1) return true;
		return false;
	}

	public void turn() {
		Common.___logOut___("Battle.turn() します");
		Common.___logOut___("[ " + (around + 1) + " ]人目のアクション");
		if (mHp > 0 && fMode == 1 && pHp > 0 && turn.size() > around) {
			switch (turn.get(around)) {
				case 0 ://パーティ[0]
					setActor(0);
					pGuard = false;
					mHug = 0;
					pBattle(0);
					break;
				case 1 ://パーティ[1]
					setActor(1);
					if (k == 2) {
						int reK = new java.util.Random().nextInt(3);// 感謝持続判定
						if (reK == 0) {
							k = 1;
							pTable();
							System.out.println("");
							battleText = new String[]{ "感謝の効果が消え、仲間の攻撃力が元に戻った・・・" };
						}
					}
					pBattle(1);
					break;
				case 2 ://パーティ[2]
					setActor(2);
					pBattle(2);
					break;
				case 3 ://パーティ[3]
					setActor(3);
					pBattle(3);
					mGuard = false;
					mHug = 0;
					break;
				case 4 ://モンスター[0]
					setActor(4);
					mBattle(0);
					if (gM == null) gM = mons[0];
					break;
				case 5 ://モンスター[1]
					setActor(5);
					mBattle(1);
					if (gM == null) gM = mons[1];
					break;
				case 6 ://モンスター[2]
					setActor(6);
					mBattle(2);
					if (gM == null) gM = mons[2];
					break;
				case 7 ://モンスター[3]
					setActor(7);
					mBattle(3);
					if (gM == null) gM = mons[3];
					break;
				default ://次のターンへ
					fight();
					break;
			}
			around++;
		}else{
			fight();
		}
	}

	static void item() {
		int r = new java.util.Random().nextInt(10);
		if (r < 8) {
			Main.controller.setMode(55555);
			Main.getItem();
		} else {
			battleText = new String[]{ Main.getmName() + "の居た場所には何もなかった・・・" };
		}
		fMode = 0;
	}

	static void gold() {
		if (fg != Main.getG()) {////////////////////獲得Gが有る場合
			battleText = new String[]{ Main.getName() + "は全部で " + (Main.getG() - fg) + " Ｇを手に入れた" };
		}
	}

	static void exp() {
		arrayClear();
		for (int i = 0; i < par.length; i++) {
			int f = fpExp[i];
			Member p = par[i];
			if (f != p.getExp()) {/////////////////////獲得経験値が有る場合
				array.add(p.getName() + "は合計 " + (p.getExp() - f) + " Ｐの経験値を獲得した");
				if (p.getLev() < upLev(p.getExp())) {
					p.setLev(upLev(p.getExp()));
					array.add(p.getName() + "はレベルが" + p.getLev() + "に上がった!!! ");
				}
				pTable();
			}
		}
		setBattleText(array);
	}

	public static void p_Initial() {
		par = Main.getParty ();
		for (Member member : par) {
			// Hp0以下は0とする
			if (member.getHp() < 0) {
				member.setHp(0);
				member.setMp(0);
			}
			// Hpの最大値は超えない
			int max_Hp = member.getLev( ) * member.getAp() * 10;
			if (member.getHp() > max_Hp){
				member.setHp(max_Hp);
			}
			// Mpの最大値は超えない
			int max_Mp =  member.getLev( ) * member.getEp() * 3;
			if (member.getMp() > max_Mp) {
				member.setMp(max_Mp);
			}
		}
	}

	public static void m_Initial() {
		for (Monster monster : mons) {
			// Hp0以下は0とする
			if (monster.getHp() < 0) {
				monster.setHp(0);
				monster.setMp(0);
			}
		}
	}

	private void initial() {

		p_Initial();

		m_Initial();

		p1s = par [ 0 ].getSp();
		p2s = par [ 1 ].getSp();
		p3s = par [ 2 ].getSp();
		p4s = par [ 3 ].getSp();

		p1h = par [ 0 ].getHp();
		p2h = par [ 1 ].getHp();
		p3h = par [ 2 ].getHp();
		p4h = par [ 3 ].getHp();

		m1s = mons[ 0 ].getSp();
		m2s = mons[ 1 ].getSp();
		m3s = mons[ 2 ].getSp();
		m4s = mons[ 3 ].getSp();

		m1h = mons[ 0 ].getHp();
		m2h = mons[ 1 ].getHp();
		m3h = mons[ 2 ].getHp();
		m4h = mons[ 3 ].getHp();

		pHp = p1h + p2h + p3h + p4h;
	  mHp = m1h + m2h + m3h + m4h;
	}

//	public static void bMenu() {
//		for(Object[] stocks : menuList){
//			for(Object stock : stocks){
//				System.out.print(stock);
//			}
//		}
//		System.out.print("⇒⇒⇒⇒⇒⇒⇒⇒⇒⇒⇒⇒⇒⇒");
//	}

//	static void pList() {											//パーティーリスト
//		fi = ( par [ 0 ] );
//		he = ( par [ 1 ] );
//		pr = ( par [ 2 ] );
//		mg = ( par [ 3 ] );
//		for (int j = 0; j < par.length; j++) {
//			if (par[j].getHp() < 0) {
//				par[j].setHp(0);
//				par[j].setMp(0);
//			}
//		}
//		pList[1][1] = fi.getName( ) + " ";
//		pList[2][1] = he.getName( ) + " ";
//		pList[3][1] = pr.getName( ) + " ";
//		pList[4][1] = mg.getName( ) + " ";
//		System.out.print("｛ ");
//		for( Object[ ] menus : pList ){
//			for( Object menu : menus ){
//			System.out.print(menu);
//			}
//		}
//		System.out.println(" ｝");
//	}

	public static void mList() {									//モンスターリスト
		if( mons[ 0 ].getHp( ) > 0 ){
			System.out.print( "  ★"+mons[ 0 ].getName() + "＝" + mons[ 0 ].getHp( ) + "HP" );
		}
		if( mons[ 1 ].getHp( ) > 0 ){
			System.out.print( "  ★"+mons[ 1 ].getName( ) + "＝" + mons[ 1 ].getHp( ) + "HP" );
		}
		if( mons[ 2 ].getHp( ) > 0 ){
			System.out.print( "  ★"+mons[ 2 ].getName( ) + "＝" + mons[ 2 ].getHp( ) + "HP" );
		}
		if( mons[ 3 ].getHp( ) > 0 ){
			System.out.print( "  ★"+mons[ 3 ].getName( ) + "＝" + mons[ 3 ].getHp( ) + "HP" );
		}
		System.out.println( "" );
	}

	public void pBattle(int turnP) {// //////////////////////////////////////仲間のターン
		p = turnP;
		mList();
		pTable();
		System.out.println("");
		par = Main.getParty();
		if(par[p].getHp()>0){
//			bMenu();
			battleText = new String[]{"⇒☆[[ " + par[p].getName() + " ]]☆は、どうしますか？"};
			Main.controller.setMenu(menu);
			Main.controller.setMode(50);
		}
	}

	void pSelect(int inp) {
		switch (inp) {
			case 0 : // 戦う
				battleText = new String[]{"⇒☆[[ " + par[p].getName() + "の攻撃]]☆誰を攻撃しますか？   "};
				break;
			case 1 : // 道具
				Item.bag(par[p]);
				break;
			case 2 : // 能力
				par[p].ex();
				break;
			case 3 : // 逃げる
				boolean ok = par[p].run();
				if (ok) {
					battleText = new String[]{ "[ " + par[p].getName() + " ]は、何とか逃げ切った・・・" };
					fMode = 0;
					Robot rb;
					try {
						rb = new Robot();
						System.out.println("      ◆◆◆◆◆◆◆◆◆◆◆◆◆");
						rb.delay(100);
						System.out.println("    ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
						rb.delay(200);
						System.out.println("  ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
					} catch (AWTException e) {
						e.printStackTrace();
					}
				} else { // 戦闘の続き
					par[p].setHp(par[p].getHp() - 1);
				}
				break;
			default :
				initial();
				par[p].setHp(par[p].getHp() - 1);
				battleText = new String[]{ "[[ " + par[p].getName() + " ]]は、コケた・・・" };
		}
		initial();
	}

	void attack(int select) {
		if (select < 0 || select > 3) {
			mList();
			System.out.println("");
			System.out.println("そこには誰もいなかった・・・");
			battleText = new String[]{"そこには誰もいなかった・・・"};
		} else {
			Monster who = mons[select];
			if (mGuard)
				who = gM;
			if (who.getHp() < 1) {
				mList();
				System.out.println("");
				System.out.println("そこには誰もいなかった・・・");
				battleText = new String[]{"そこには誰もいなかった・・・"};
			} else {
				int judg = new java.util.Random().nextInt(par[p].getSp() * par[p].getLev());
				if (judg == 1) {
					System.out.println("!!?外した!!!");
					battleText = new String[]{"!!?外した!!!"};
					System.out.println(who.getName() + "にかわされてしまった・・・");
					battleText = new String[]{who.getName() + "にかわされてしまった・・・"};
				} else {
					System.out.println("★★★★★★★★★★★★★★★★★★★★");
					System.out.println(par[p].getName() + "の攻撃が命中!!!");
					System.out.println("  ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑  ");
					battleText = new String[4];
					battleText[0] = par[p].getName() + "の攻撃が命中!!!";
					double bp = ((new java.util.Random().nextInt(7)) * 0.1) + 0.7;
					int dm = (int) ((par[p].attack() * bp) * k  * fly);////ダメージ
					///////////クリティカルヒット判定/////////////
					int cH = (new java.util.Random().nextInt(20 - par[p].getLev()));
					if (p == 0 && par[0].getWp() == 9) {///////////////////ムラマサ装備の場合
						dm = dm + 100;
					}
					if (p == 1 && par[1].getWp() == 9) {///////////////////英雄の剣装備の場合
						cH = 3 - (new java.util.Random().nextInt(2));
					}
					if (cH == 0){//////////////////////////クリティカルヒットの場合
						dm = dm * 3;
					}
					who.setHp(who.getHp() - dm);
					System.out.println("");
					System.out.println("  " + who.getName() + "に[ " + dm + " ]Pのダメージを与えた!!!");
					battleText[1] = "  " + who.getName() + "に[ " + dm + " ]Pのダメージを与えた!!!";
					System.out.println("");
					initial();
					if (who.getHp() < 1) {
						Main.setG(Main.getG() + who.getGp());
						par[p].setExp(par[p].getExp() + who.getExp());
						System.out.println(par[p].getName() + "は" + who.getName() + "を倒した!!!");
						battleText[2] = par[p].getName() + "は" + who.getName() + "を倒した!!!";
						String string = par[p].getName() + "は" + who.getGp() + "Gと" + who.getExp() + "の経験値を手に入れた!!!";
						System.out.print(string);
						System.out.println("  [Exp = " + who.getExp() + "] [G = " + who.getGp() + "]");
						battleText[3] = string;
					}else{
						battleText = new String[2];
						battleText[0] = par[p].getName() + "の攻撃が命中!!!";
						battleText[1] = "  " + who.getName() + "に[ " + dm + " ]Pのダメージを与えた!!!";
					}
				}
			}
		}
	}

	private void mBattle(int m) {///////////////////////////////////////////モンスターのターン
		Monster mon = mons[m];
		if (mon.getHp() > 0) {
			Main.controller.setMode(555);
			pTable();
			System.out.println("");
			System.out.print("⇒★[[ " + mon.getName() + " ]]★は、");
			int job = new java.util.Random().nextInt(7) + mon.getTyp();
			switch (job) {
				case 3 : // 戦う
				case 4 :
				case 9 :
					int who;
					if (pGuard) {
						who = 0;
					} else {
						who = new java.util.Random().nextInt(4);
					}
					if (par[who].getHp() < 1) {
						mBattle(m);
					} else {
						System.out.println(par[who].getName() + "に襲いかかってきた!!!");
						String text1 = "[ " + mon.getName() + " ]は、[ " + par[who].getName() + " ]に襲いかかってきた!!!";
						int judg = new java.util.Random().nextInt(mon.getSp() * mon.getLev());
						if (judg == 1) {
							String text2 = "ミス!!!" + par[who].getName() + "に当たらない!!!";
							System.out.println(text2);
							battleText = new String[2];
							battleText[0] = text1;
							battleText[1] = text2;
						} else {
							String text2 = mon.getName() + "の攻撃が、" + par[who].getName() + "に命中!!!";
							System.out.println("  ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓  ");
							System.out.println(text2);
							System.out.println("★★★★★★★★★★★★★★★★★★★★");
							double bp = ((new java.util.Random().nextInt(7)) * 0.1) + 0.7;
							int dm = (int) ((mon.attack() * bp) * mK);
							///////////クリティカルヒット判定/////////////
							int cH = (new java.util.Random().nextInt(par[who].getLev()));
							if (p == 0 && par[0].getWp() == 9) {///////////////////ムラマサ装備の場合
								dm = dm - (dm / 3);
							}
							String big = "";
							if (cH == 0){//////////////////////////クリティカルヒットの場合
								dm = dm * 3;
								big = "大";
							}
							par[who].setHp(par[who].getHp() - dm);
							pTable();
							String text3 = par[who].getName() + "は" + dm + "Pの" + big + "ダメージを受けた!!!";
							System.out.println("");
							//					System.out.println("mon.attack("+ mon.attack() + ") * pb(" + bp + ") * mk(" + getmK() + ") = dm<" + dm);//////////
							System.out.println(text3);
							if (who == 1) {
								setFly(1);
							}
							battleText = new String[3];
							battleText[0] = text1;
							battleText[1] = text2;
							battleText[2] = text3;
							if (par[who].getHp() < 1) {
								pTable();
								String text4 = par[who].getName() + "は、死んでしまった!!! ×m(__)m×";
								System.out.println("");
								System.out.println(par[who].getName() + "は、死んでしまった!!! ×m(__)m×");
								battleText = new String[4];
								battleText[0] = text1;
								battleText[1] = text2;
								battleText[2] = text3;
								battleText[3] = text4;
							}
						}
					}
					break;
				case 5 : // 使う
					System.out.println("様子を窺っている・・・");
					//			Input.ent();
					battleText = new String[]{ "[ " + mon.getName() + " ]は、様子を窺っている・・・" };
					break;
				case 6 : // 能力
				case 7 :
				case 8 :
					Main.controller.setMode(555);
					mons[m].ex(m);
					break;
				case 0 : // 逃げる
				case 1 :
				case 2 :
					boolean ok = mons[m].run();
					if (ok == true) {
						mons[m].setHp(0);
					} else { ///////////////////////////戦闘の続き
						System.out.println("");
					}
					break;
				default : // コケる
					System.out.println("コケた・・・");
					battleText = new String[]{ "コケた・・・" };
			}
			initial();
		}
	}

	public void setItemList(Object menuList[][]) {
		Battle.menuList = menuList;
	}

	public static Object[][] getItemList() {
		return menuList;
	}

	private static int upLev(int exp) {
		int lev = 0;
		     if(exp <     10) lev = 1;
		else if(exp <     30) lev = 2;
		else if(exp <     60) lev = 3;
		else if(exp <    100) lev = 4;
		else if(exp <    150) lev = 5;
		else if(exp <    250) lev = 6;
		else if(exp <    500) lev = 7;
		else if(exp <   1000) lev = 8;
		else if(exp <   2000) lev = 9;
		else if(exp <   3000) lev = 10;
		else if(exp <   4000) lev = 11;
		else if(exp <   5000) lev = 12;
		else if(exp <   6000) lev = 13;
		else if(exp <   7000) lev = 14;
		else if(exp <   8000) lev = 15;
		else if(exp <   9000) lev = 16;
		else if(exp <  10000) lev = 17;
		else if(exp <  15000) lev = 18;
		else if(exp <  20000) lev = 19;
		else                  lev = 20;
		return lev;
	}

	public static void inn() {
		for (Member p : par) {
			if (p.getHp() < 1) {
				p.setHp(0);
				p.setMp(0);
			} else {
				p.setHp(p.getLev() * p.getAp() * 10);
				p.setMp(p.getLev() * p.getEp() * 3);
			}
		}
	}

	public static void setK(int k) {
		Battle.k = k;
	}

	public int getK() {
		return k;
	}

	public static void setMons(Monster[ ] mons) {
		Battle.mons = mons;
	}

	public static Monster[ ] getMons() {
		return mons;
	}

	public static void setFly(int fly) {
		Battle.fly = fly;
	}

	public double getFly() {
		return fly;
	}

	public static void setgM(Monster gM) {
		Battle.gM = gM;
	}

	public Monster getgM() {
		return gM;
	}

	public static void status() {
		p_Initial();
		int fiA = fi.getLev( )*fi.getAp( );
		int heA = he.getLev( )*he.getAp( );
		int prA = pr.getLev( )*pr.getAp( );
		int mgA = mg.getLev( )*mg.getAp( );
		int fiE = fi.getLev( )*fi.getEp( );
		int heE = he.getLev( )*he.getEp( );
		int prE = pr.getLev( )*pr.getEp( );
		int mgE = mg.getLev( )*mg.getEp( );
		int[] nLE = {0,10,30,60,100,150,250,500,1000,2000,3000,4000,5000,6000,7000,8000,9000,10000,15000,20000};
		Object[][] st = {
				{"名前"       ,"Lev."      ,"経験値"    ,"体力"     ,"術力"     ,"強さ","素早さ"     ,"武器"                , "攻撃力"   , "技能力"  },
				{fi.getName( ),fi.getLev( ),fi.getExp( ),fi.getHp( ),fi.getMp( ),fiA   ,fi.getSp( ) ,fi.getWeapon()[fi.getWp( )], fi.attack(), fi.getEp( )},
				{he.getName( ),he.getLev( ),he.getExp( ),he.getHp( ),he.getMp( ),heA   ,he.getSp( ) ,he.getWeapon()[he.getWp( )], he.attack(), he.getEp( )},
				{pr.getName( ),pr.getLev( ),pr.getExp( ),pr.getHp( ),pr.getMp( ),prA   ,pr.getSp( ) ,pr.getWeapon()[pr.getWp( )], pr.attack(), pr.getEp( )},
				{mg.getName( ),mg.getLev( ),mg.getExp( ),mg.getHp( ),mg.getMp( ),mgA   ,mg.getSp( ) ,mg.getWeapon()[mg.getWp( )], mg.attack(), mg.getEp( )},
			};
		Object[][] mSt = {
				{"       ",     "nextLev"                ,""     ,"MaxHP","MaxMP",""      ,""      ,"武器Lev"             ,""         ,""          },
				{"次Lev=",nLE[fi.getLev( )]-fi.getExp( ),"MaxHP=",fiA*10 ,fiE*3  ,"=MaxMP","wLev.=",fi.attack()-fiA + 1   ,""         ,""          },
				{"次Lev=",nLE[he.getLev( )]-he.getExp( ),"MaxHP=",heA*10 ,heE*3  ,"=MaxMP","wLev.=",he.attack()-heA + 1   ,""         ,""          },
				{"次Lev=",nLE[pr.getLev( )]-pr.getExp( ),"MaxHP=",prA*10 ,prE*3  ,"=MaxMP","wLev.=",pr.attack()-prA + 1   ,""         ,""          },
				{"次Lev=",nLE[mg.getLev( )]-mg.getExp( ),"MaxHP=",mgA*10 ,mgE*3  ,"=MaxMP","wLev.=",mg.attack()-mgA + 1   ,""         ,""          },
			};
		for (int i = 1; i < (st.length); i++) {
			for (int j = 0; j < st[0].length; j++) {
				System.out.print("|" + st[0][j] + '\t');
			}
			System.out.println("|");
			for (int j = 0; j < st[0].length; j++) {
				System.out.print("|" + st[i][j] + '\t');
			}
			System.out.println("|");
			System.out.print(" Lev.UP残["+ mSt[i][1] + "]\t  MAX[HP("+ mSt[i][3]);
			System.out.println("),MP("+ mSt[i][4] + ")]           武器の強さ["+ mSt[i][7] +"]");
		}
		System.out.print("<アイテム( ");
		Item.items();
		System.out.println(")>");
		System.out.println("");
		System.out.print("<所持金(" + Main.getG() + "Ｇ)> ");
		switch (Main.getbHp()) {
		case 3:
			System.out.println("");
			break;
		case 2:
			System.out.println("☆");
			break;
		case 1:
			System.out.println("☆☆");
			break;
		case 0:
			System.out.println("☆☆☆");
			break;
		default:
			System.out.println("");
			break;
		}
	}

	public static void setmK(int mK) {
		Battle.mK = mK;
	}

	public static int getmK() {
		return mK;
	}

	public void setfMode(int fMode) {
		Battle.fMode = fMode;
	}

	public static int getfMode() {
		return fMode;
	}

	public static void pTable() {
		p_Initial();
		for (Member me : par) {
			String sHP = String.valueOf(me.getHp( ));
			if(me.getHp( ) < 1) sHP ="死";
			String status = me.getName( ) + "(Lev." + me.getLev( ) + ")HP=" + sHP + ",MP=" + me.getMp( );
			System.out.print("☆[" + status + "] ");
		}
		System.out.println("");
	}

	static void mGet() {
		int mCount = 0;
		for (int i = 0; i < mons.length; i++) {
			if (mons[i].getHp() > 0) mCount++;
		}
//		Common.___logOut___("現モンスター数 = " + mCount);
		mNa = new String[mCount];
		mSt = new Object[3][mCount];
		int i = 0;
		while (i < mCount) {
			for (int j = 0; j < mons.length; j++) {
				if (mons[j].getHp() > 0) {
					mNa[i] = mons[j].getName();
					mSt[0][i] = ("Lev = " + mons[j].getLev());
					mSt[1][i] = ("HP = " + mons[j].getHp());
					mSt[2][i] = ("MP = " + mons[j].getMp());
					i = (i + 1);
				}
			}
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return mSt[0][columnIndex].getClass();
	}

	@Override
	public String getColumnName(int column) {
		return mNa[column];
	}

	@Override
	public int getRowCount() {
		return mSt.length;
	}

	@Override
	public int getColumnCount() {
		mGet();
		return mNa.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return mSt[rowIndex][columnIndex];
	}

	public static void setBattleText(String[] battleText) {
		Battle.battleText = battleText;
	}

	public static String[] getBattleText() {
		return battleText;
	}

	public static void setMenu(Object menu[]) {
		Battle.menu = menu;
	}

	public static Object[] getMenu() {
		return menu;
	}

	public static Object[] mNa() {
		mGet();
		return mNa;
	}

	public static int mNumber() {
		mGet();
		return mNa.length;
	}

	public static void setItem(int item) {
		Battle.item = item;
	}

	public static int getItem() {
		return item;
	}

	public void setActor(int actor) {
		Battle.actor = actor;
	}

	public static int getActor() {
		return actor;
	}

	private static void arrayClear() {
		if (array == null) {
			array = new ArrayList<String>();
		} else {
			for (int i = array.size(); i > 0; i--) {
				array.remove(i - 1);
			}
		}
	}

	public static void setBattleText(ArrayList<String> arrayList) {
		battleText = new String[arrayList.size()];
		for (int i = 0; i < arrayList.size(); i++) {
			battleText[i] = arrayList.get(i);
		}
	}
}