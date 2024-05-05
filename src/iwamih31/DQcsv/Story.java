package iwamih31.DQcsv;

import javax.swing.table.AbstractTableModel;

public class Story extends AbstractTableModel{

	static String[][] sent = {
				{ "" },
				{ "" },
				{ "" },
			};

	static Member fi = Main.fi;
	static Member he = Main.he;
	static Member pr = Main.pr;
	static Member mg = Main.mg;

	private static String[] textList;

	static String p_Name = Main.getyName();
	static String m_Name = Main.getmName();
	static String b_Name = Main.getbName();

	Story(){
		textList = new String[16];
		textList[0] = "";
		textList[1] = "「勇者[ " + Main.getyName() + " ]よ、よくぞ来てくれた・・・ 」";
		textList[2] = "「[ " + Main.getbName() + " ]と呼ばれる魔物が現れて、世界を滅ぼそうとしている・・・ 」";
		textList[3] = "「勇者[ " + Main.getyName() + " ]よ、[ " + Main.getbName() + " ]を倒し、世界に平和をもたらすのじゃ!!! 」";
		textList[4] = "";
		textList[5] = "["+Main.getyName()+" は [" + Main.getG() +"G ] と道具を手に入れた";
		textList[6] = "";
		textList[7] = "・・・・・" + fi.getName( ) + "が仲間に加わった!!";
		textList[8] = "";
		textList[9] = "・・・・・" + pr.getName( ) + "が仲間に加わった!!";
		textList[10] = "";
		textList[11] = "・・・・・" + mg.getName( ) + "が仲間に加わった!!";
		textList[12] = "";
		textList[13] = "そして[" + Main.getName( ) + "]の伝説が始まった・・・";
		textList[14] = "";
		textList[15] = "☆[ " + Main.getName() + " ]の物語";
	}

	public static void end( ) {
//		System.out.println( Main.getbName() + "は断末魔の叫びをあげた" );
//		System.out.println( Main.getName() + "は" + Main.getbName() + "を退治した" );
//		System.out.println( "世界にまた穏やかな日々がが戻ってきた" );
//		System.out.println(   "                                           Fin?" );
//		System.out.println(   "  もう一度最初から始めますか？ [ 1.YES  2.NO ]" );
//		int inp = Input.input();
//		switch ( inp ) {
//			case 1:
//				Main s = new Main();
//				break;
//			case 2:
//				System.out.println( "修了します" );
//				break;
//			default:
//				System.out.println( "1か2でお願いします" );
//		}
	}

	public void beBack() {
		Battle.pTable();
		textList = new String[4];
		textList[0] = "「おお!! [" + Main.getyName( ) + " ]よ、調子はどうだ？」" ;
		textList[1] = "「[" + Main.getName( ) + "]の活躍は、我が耳にも色々と届いておるぞ・・・」";
		textList[2] = "「[ " + p_Name + " ]よ、一刻も早く[ " + b_Name + " ]を倒し、世界に平和をもたらすのじゃ!!!」";
		textList[3] = "";
	}

	public static void relief() {
		Battle.pTable();
		textList = new String[11];
		textList[0] = "";
		textList[1] = "「目覚めたか、[ " + p_Name + " ]よ・・・」";
		textList[2] = "";
		textList[3] = "「[ " + p_Name + " ]を全滅させるとは、[ " + m_Name + " ]は、やはり相当手強いのう・・・」";
		textList[4] = "";
		textList[5] = "「なんとか [ " + p_Name+ " ]達の命を救う事は出来たが、お金を大分消費してしまった・・・」";
		textList[6] = "";
		textList[7] = "「だが[ " + p_Name + " ]の命を救えて、本当に何よりじゃ・・・」";
		textList[8] = "";
		textList[9] = "「さあ、[ " + p_Name + " ]よ、一刻も早く[ " + b_Name + " ]を倒し、世界に平和をもたらすのじゃ!!!」";
		textList[10] = "";
	}

	@Override
	public int getRowCount() {
		return sent.length;
	}

	@Override
	public int getColumnCount() {
		return sent[0].length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return sent[rowIndex][columnIndex];
	}

	public void on(String s) {
		Common.___logOut___("Story.on(" + s + ") します ");
		Story.sent[1][0] = (s);
		fireTableDataChanged();//テーブル更新
	}

	public static void setTextList(String[] textList) {
		Story.textList = textList;
	}

	public String[] getTextList() {
		return textList;
	}

	public String[] talk(int number) {
		Battle.pTable();
		switch(number) {
			case 101:
				textList = new String[2];
				textList[0] = "「[ " + p_Name + " ]よ、一刻も早く[ " + b_Name + " ]を倒し、世界に平和をもたらすのじゃ!!!」";
				textList[1] = "";
				break;
			case 102:
				textList = new String[2];
				textList[0] = "「」";
				textList[1] = "";
				break;
		default:
			textList = new String[2];
			textList[0] = "「わしの城はどうじゃ？」";
			textList[1] = "";
		}
		return textList;
	}
}
