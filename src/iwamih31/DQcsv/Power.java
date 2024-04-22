package iwamih31.DQcsv;

public class Power extends Ex{

	private static Object exList[][] = {
		{"*" ,"術名"    ,"=","使用MP","｛ "},
		{"1.","筋肉の壁","=",    0   ,"  " },
		{"2.","奇跡"    ,"=",   10   ,"  " },
		{"3.","蘇生"    ,"=",  100   ,"  " },
		{"4.","抑え込み","=",    0   ,"  " }
	};

	Power(Character memb) {
		super(memb);
		itemList=exList;
//		exMenu();
//		spell();
	}

	public void spell() {
		switch (job) {
		case 1:
			Battle.pTable();
			System.out.println( "" );
			System.out.println(getName() + "は" + useEx + "を行った・・・");
			Battle.pGuard = true;
			Battle.pTable();
			System.out.println( "" );
			System.out.println(getName() + "は前に出て敵の攻撃を全部受け止めた。");
			break;
		case 2:
			heal();
			break;
		case 3:
			resu();
			break;
		case 4:
			if (hp <= lev * 50) {
				System.out.println(user.getName()+"のHP="+hp+" 消費MP=" + (lev * 50));//////////////////
				System.out.println( "" );
				System.out.println(useEx + "を行うには体力が足りません ×××");
				spell();
			} else {
				Battle.pTable();
				System.out.println( "" );
				System.out.println(getName() + "は" + useEx + "を行った・・・");
				Battle.pHug = 30;
				user.setHp(user.getHp() - lev * 50);
				Battle.pTable();
				System.out.println( "" );
				System.out.println(getName() + "は、敵の動きを封じ込めた・・・");
			}
			break;
		default:
			exText = new String[]{"なにもしなかった"};
		}
	}
}
