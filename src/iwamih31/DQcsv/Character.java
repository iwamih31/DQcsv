package iwamih31.DQcsv;

public abstract class Character {
	private String name = "生物";
	private int no  =        0;
	private int exp =        1;
	private int lev =        1;
	private int hp  =      100;
	private int mp  =        0;
	private int sp  =        5;
	private int wp  =        0;
	private int gp  =        1;
	private int ap  =        1;
	private int ep  =        0;

	abstract boolean run();

	abstract int attack();


	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getExp() {
		return exp;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setLev(int lev) {
		this.lev = lev;
	}

	public int getLev() {
		return lev;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getHp() {
		return hp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getMp() {
		return mp;
	}

	public int getEp() {
		return ep;
	}


}
