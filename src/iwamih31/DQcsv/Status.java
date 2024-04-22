package iwamih31.DQcsv;

import javax.swing.table.AbstractTableModel;

public class Status extends AbstractTableModel{

	private static Member[] par;

	static Member fi;
	static Member he;
	static Member pr;
	static Member mg;

	private static Status statusModel;

	private Object[][] st;

	private Object[][] mSt;

	private Object[][] status;

	private Object[][] sta;

	public Status() {

		par = Main.getParty ( );

		fi = par [ 0 ];
		he = par [ 1 ];
		pr = par [ 2 ];
		mg = par [ 3 ];

		for (int j = 0; j < par.length; j++) {
			if (par[j].getHp() < 0) {
				par[j].setHp(0);
				par[j].setMp(0);
			}
		}

		int fiP = fi.getLev( )*fi.getAp( );
		int heP = he.getLev( )*he.getAp( );
		int prP = pr.getLev( )*pr.getAp( );
		int mgP = mg.getLev( )*mg.getAp( );

		int fiE = fi.getLev( )*fi.getEp( );
		int heE = he.getLev( )*he.getEp( );
		int prE = pr.getLev( )*pr.getEp( );
		int mgE = mg.getLev( )*mg.getEp( );

		int[] nLE = {0,10,30,60,100,150,250,500,1000,2000,3000,4000,5000,6000,7000,8000,9000,10000,15000,20000};

		st = new Object[][] {
				{"名前"       ,"Lev."      ,"経験値"    ,"体力"     ,"術力"     ,"強さ","素早さ"    ,"武器"                     ,"攻撃力"    ,"技能力"    },
				{fi.getName( ),fi.getLev( ),fi.getExp( ),fi.getHp( ),fi.getMp( ),fiP   ,fi.getSp( ) ,fi.getWeapon()[fi.getWp( )], fi.attack(), fi.getEp( )},
				{he.getName( ),he.getLev( ),he.getExp( ),he.getHp( ),he.getMp( ),heP   ,he.getSp( ) ,he.getWeapon()[he.getWp( )], he.attack(), he.getEp( )},
				{pr.getName( ),pr.getLev( ),pr.getExp( ),pr.getHp( ),pr.getMp( ),prP   ,pr.getSp( ) ,pr.getWeapon()[pr.getWp( )], pr.attack(), pr.getEp( )},
				{mg.getName( ),mg.getLev( ),mg.getExp( ),mg.getHp( ),mg.getMp( ),mgP   ,mg.getSp( ) ,mg.getWeapon()[mg.getWp( )], mg.attack(), mg.getEp( )},
		};

		mSt = new Object[][] {
				{"       ",     "nextLev"                ,""     ,"MaxHP","MaxMP",""      ,""      ,"武器Lev"      ,""         ,""          },
				{"次Lev=",nLE[fi.getLev( )]-fi.getExp( ),"MaxHP=",fiP*10 ,fiE*3  ,"=MaxMP","wLev.=",fi.attack()-fiP,""         ,""          },
				{"次Lev=",nLE[he.getLev( )]-he.getExp( ),"MaxHP=",heP*10 ,heE*3  ,"=MaxMP","wLev.=",he.attack()-heP,""         ,""          },
				{"次Lev=",nLE[pr.getLev( )]-pr.getExp( ),"MaxHP=",prP*10 ,prE*3  ,"=MaxMP","wLev.=",pr.attack()-prP,""         ,""          },
				{"次Lev=",nLE[mg.getLev( )]-mg.getExp( ),"MaxHP=",mgP*10 ,mgE*3  ,"=MaxMP","wLev.=",mg.attack()-mgP,""         ,""          },
				};

		String fiExp = fi.getExp() + "/" +  nLE[fi.getLev( )];
		String heExp = he.getExp() + "/" +  nLE[he.getLev( )];
		String prExp = pr.getExp() + "/" +  nLE[pr.getLev( )];
		String mgExp = mg.getExp() + "/" +  nLE[mg.getLev( )];

		String fiHp = fi.getHp() + "/" +  mSt[1][3];
		String heHp = he.getHp() + "/" +  mSt[2][3];
		String prHp = pr.getHp() + "/" +  mSt[3][3];
		String mgHp = mg.getHp() + "/" +  mSt[4][3];

		String fiMp = fi.getMp() + "/" +  mSt[1][4];
		String heMp = he.getMp() + "/" +  mSt[2][4];
		String prMp = pr.getMp() + "/" +  mSt[3][4];
		String mgMp = mg.getMp() + "/" +  mSt[4][4];

		String fiWp = st[1][7] + "(" + mSt[1][7] + ")";
		String heWp = st[2][7] + "(" + mSt[2][7] + ")";
		String prWp = st[3][7] + "(" + mSt[3][7] + ")";
		String mgWp = st[4][7] + "(" + mSt[4][7] + ")";

		sta = new Object[][] {
				{ "名前" , fi.getName(), he.getName(), pr.getName(), mg.getName() },
				{ "Lev." , fi.getLev() , he.getLev() , pr.getLev() , mg.getLev()  },
				{"経験値",fiExp        ,heExp        ,prExp        ,mgExp         },
				{"体力"  ,fiHp         ,heHp         ,prHp         ,mgHp          },
				{"術力"  ,fiMp         ,heMp         ,prMp         ,mgMp          },
				{"強さ"  ,fiP          ,heP          ,prP          ,mgP           },
				{"素早さ",fi.getSp()   ,he.getSp()   ,pr.getSp()   ,mg.getSp()    },
				{"武器"  ,fiWp         ,heWp         ,prWp         ,mgWp          },
				{"攻撃力",st[1][8]     ,st[2][8]     ,st[3][8]     ,st[4][8]      },
				{"技能力",st[1][9]     ,st[2][9]     ,st[3][9]     ,st[4][9]      }
		};

		setStatus();

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
		switch (Main.bHp) {
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

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return status[0][columnIndex].getClass();
	}

	@Override
	public String getColumnName(int column) {
		return (String) status[0][column];
	}

	@Override
	public int getRowCount() {
		return status.length - 1;
	}

	@Override
	public int getColumnCount() {
		return status[0].length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		setStatus();
		return status[rowIndex + 1][columnIndex];
	}

	private void setStatus() {
		status = sta;
	}

	public static void statusModel() {
		setStatusModel(new Status());
	}

	public static  void setStatusModel(Status statusModel) {
		Status.statusModel = statusModel;
	}

	public static Status getStatusModel() {
		return statusModel;
	}

}
