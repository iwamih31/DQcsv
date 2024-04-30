package iwamih31.DQcsv;

public class Mage extends Member {

	 Mage () {                 //コンストラクタでフィールドを初期化
		 setName( "魔術師" );
		 setNo  (      4 )    ;
		 setExp (      0 )    ;
		 setLev (      1 )    ;
		 setHp  (     30 )    ;
		 setMp  (     50 )    ;
		 setSp  (      1 )    ;
		 setWp  (      0 )    ;
		 setAp  (      3 )    ;
		 setEp  (     10 )    ;

		 getWeapon()[ 0 ] ="小石"        ;
		 getWeapon()[ 1 ] ="木の杖"      ;
		 getWeapon()[ 2 ] ="樫の杖"      ;
		 getWeapon()[ 3 ] ="まやかしの杖";
		 getWeapon()[ 4 ] ="宝石の杖"  ;
		 getWeapon()[ 5 ] ="ゴルゴダの杖";
		 getWeapon()[ 6 ] ="刹那の杖"    ;
		 getWeapon()[ 7 ] ="仕込杖"      ;
		 getWeapon()[ 8 ] ="殺戮の杖"    ;
		 getWeapon()[ 9 ] ="魔導師の杖"  ;
	 }

	@Override
	public int attack() {
		int r = ((getLev() * getAp()) + (getWp() * 3));
		return r;
	}

	@Override
public int attack(int ud) {
		int r = ((getLev() * getAp()) + (ud * 3));
		return r;
	}

	@Override
	public void ex() {
//		Member mem = Main.getParty()[ 3 ];
//		System.out.println( "どの術を使いますか？" );
		new Magic( this );
	}
}
