package iwamih31.DQcsv;

public class Fighter extends Member {

	 Fighter () {                 //コンストラクタでフィールドを初期化
		 setName( "戦士" );
		 setNo  (      1 );
		 setExp (      0 );
		 setLev (      1 );
		 setHp  (    100 );
		 setMp  (      0 );
		 setSp  (     10 );
		 setWp  (      0 );
		 setAp  (     10 );
		 setEp  (      0 );

		 getWeapon()[ 0 ] ="木の棒"  ;
		 getWeapon()[ 1 ] ="竹やり"  ;
		 getWeapon()[ 2 ] ="ナイフ"  ;
		 getWeapon()[ 3 ] ="棍棒 "   ;
		 getWeapon()[ 4 ] ="青銅の剣";
		 getWeapon()[ 5 ] ="鎖がま"  ;
		 getWeapon()[ 6 ] ="鉄の剣"  ;
		 getWeapon()[ 7 ] ="鋼鉄の剣"  ;
		 getWeapon()[ 8 ] ="鉄槍";
		 getWeapon()[ 9 ] ="ムラマサ";
	}

	 @Override
	 public int attack() {

		int r = ((getLev() * getAp()) + (getWp() * 10));

		return r;
	 }

	 @Override
	 public int attack(int ud) {
		int r = ((getLev() * getAp()) + (ud * 10));
		return r;
	 }

	 @Override
	 public void ex() {
//		Member mem = Main.getParty( )[ getNo() - 1 ];
//		System.out.println( "どの術を使いますか？" );
		new Power( this );
	 }
}
