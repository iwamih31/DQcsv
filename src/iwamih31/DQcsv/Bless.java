package iwamih31.DQcsv;

public class Bless extends Ex{

	private static Object exList[][] = {
		{" ＊","施術名"  ,"=","使用MP","｛ "},
		{"１.","祈り"    ,"=",     0  ,"  " },
		{"２.","奇跡の手","=",    10  ,"  " },
		{"３.","蘇生術"  ,"=",   100  ,"  " },
		{"４.","荒行"    ,"=",     0  ,"  " }
		};

	Bless(Character memb) {
		super(memb);
		itemList=exList;
//		exMenu();
//		spell();
	}

	public void spell() {
		switch ( job ) {
			case 1:
				praying( );
				break;
			case 2:
				heal( );
				break;
			case 3:
				resu( );
				break;
			case 4:
				desolation( );
				break;
			default:
				exText = new String[]{"なにもしなかった"};
		}
	}
}
