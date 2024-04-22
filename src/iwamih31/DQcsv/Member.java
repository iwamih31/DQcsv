package iwamih31.DQcsv;

import java.io.Serializable;

public abstract class Member extends Character implements Serializable{

	private String name = "メンバー";
	private int no  =        0;
	private int exp =        1;
	private int lev =        1;
	private int hp  =      100;
	private int mp  =        0;
	private int sp  =        5;
	private int wp  =        0;
	private int ap  =        1;
	private int ep  =        0;

	private String weapon[ ] = {
			"武器 ０",
			"武器 １",
			"武器 ２",
			"武器 ３",
			"武器 ４",
			"武器 ５",
			"武器 ６",
			"武器 ７",
			"武器 ８",
			"武器 ９"
	};

	public int attack() {
		int dp = ( lev * ap );
		return dp;
	}

	public int attack(int ud) {
		int dp = ( lev * ap + ud * 1);
		return dp;
	}

	public void item() {
//		System.out.println( "[HP = " + hp + "][敵 = " + Main.mHp +"]です。");
		System.out.println( "何を使いますか？" );
//		int n = Item.fBag(hp);
		Battle.setBattleText(new String[]{"何を使いますか？"});
	}

	public void ex() {
//		Member mem = Main.getParty( )[ getNo() - 1 ];
		System.out.println( "どの術を使いますか？" );
//		new Ex( this );
		Battle.setBattleText(new String[]{"どの術を使いますか？"});
	}

	public boolean run() {
		System.out.println( getName( ) + "は、逃げ出した・・・");
		String[] run = new String[2];
		run[0] = "[ "+ name +" ]は、逃げ出した・・・";
		int r = new java.util.Random ( ).nextInt( 100 );
		if ( r < ( getLev( ) + 20 ) ) {
			System.out.println( getName( ) + "は、何とか逃げ切った・・・" );
			run[1] = "[ "+ name +" ]は、何とか逃げ切った・・・";
			Battle.setBattleText(run);
			return true;
		} else {
			System.out.println( getName( ) + "は、見っかっちゃった!!!" );
			run[1] = "[ "+ name +" ]は、見っかっちゃった!!!";
			Battle.setBattleText(run);
			return false;
		}
	}

	public void item(int clickItem) {
		Object choiceItem = Item.getItemList() [clickItem][0];
		System.out.println("[ " + getName() + " ]は、[ " + choiceItem + " ]を使った");
		Battle.setBattleText(new String[]{"[ "+ name +" ]は、[ " + choiceItem + " ]を使った"});
		Item.item(clickItem);
	}

	public String wep() {
		System.out.print( "[ 武器＝" + weapon[wp] + " 攻撃力＝" + attack() + " ]");
		return weapon[wp];
	}

	public void wep(int ud) {
		if ( weapon.length <= wp + ud) ud = 0;
		System.out.print( "[ 武器＝" + weapon[wp + ud] + " 攻撃力＝" + attack(ud) + " ]");
	}

	public String wepName(int ud) {
		if ( weapon.length <= wp + ud) ud = 0;
		return weapon[wp + ud];
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

	public void setWp(int wp) {
		this.wp = wp;
	}

	public int getWp() {
		return wp;
	}

	public void setWeapon(String weapon[]) {
		this.weapon = weapon;
	}

	public String[] getWeapon() {
		return weapon;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setEp(int ep) {
		this.ep = ep;
	}

	public int getEp() {
		return ep;
	}

	public void setAp(int ap) {
		this.ap = ap;
	}

	public int getAp() {
		return ap;
	}

	public int getmp() {
		return mp;
	}
}

