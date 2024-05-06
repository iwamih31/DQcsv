package iwamih31.DQcsv;

public abstract class Monster extends Character{

	private String name = ".モンスター";
	private int code    = 10;
	private int exp =   1;//倒すと貰える経験値
	private int lev =   1;//攻撃力
	private int hp  = 100;//体力
	private int mp  =   0;//能力使用ポイント
	private int sp  =   5;//速さ
	private int gp  =   1;//倒すと貰えるお金
	private int ep  =   1;//特殊能力の強さ
	private int typ =   0;// 0=特殊能力なし, 1=回復系, 2=ドラゴン系, 3=巨人系

	public Monster() {
		super();
	}

	public boolean run() {
		String[] run = new String[2];
		run[0] = "[ "+ name +" ]は、逃げ出した・・・";
		int r = new java.util.Random ( ).nextInt( 100 );
		if ( r < ( getLev( ) + 20 ) ) {
			run[1] = "[ "+ name +" ]は、どこかへ行ってしまった・・・";
			Battle.setBattleText(run);
			return true;
		} else {
			run[1] = "[ "+ name +" ]は逃げ切れない!!";
			Battle.setBattleText(run);
			return false;
		}
	}

	public int attack( ) {
		int dp = ( getLev() * 10 );
		return dp;
	}

	public void ex(int m ){
		Monster mon = Battle.mons [ m ];
		Battle.setBattleText(new String[]{"[ "+mon.name+" ]は、動いた・・・"});
		int typ = mon.typ;
		int what = ( new java.util.Random ( ).nextInt(2) ) - 1;
		new MEx( mon, ( what + ( typ * 2 ) ) );
	}

	public void other( int clickItem ){
		Battle.setBattleText(new String[]{"[ "+ name +" ]は様子をうかがっている・・・"});
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getExp() {
		return exp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getMp() {
		return mp;
	}

	public void setGp(int gp) {
		this.gp = gp;
	}

	public int getGp() {
		return gp;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSp(int sp) {
		this.sp = sp;
	}

	public int getSp() {
		return sp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getHp() {
		return hp;
	}

	public void setLev(int lev) {
		this.lev = lev;
	}

	public int getLev() {
		return lev;
	}

	public void setEp(int ep) {
		this.ep = ep;
	}

	public int getEp() {
		return ep;
	}

	public void setTyp(int typ) {
		this.typ = typ;
	}

	public int getTyp() {
		return typ;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}