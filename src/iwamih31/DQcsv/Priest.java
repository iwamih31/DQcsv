package iwamih31.DQcsv;

public class Priest extends Member {

	 Priest () {                 //コンストラクタでフィールドを初期化
		 setName( "司祭" );
		 setNo  (      3 );
		 setExp (      0 );
		 setLev (      1 );
		 setHp  (     60 );
		 setMp  (     30 );
		 setSp  (      6 );
		 setWp  (      0 );
		 setAp  (      6 );
		 setEp  (      8 );

		 getWeapon()[ 0 ] ="木の棒"    ;
		 getWeapon()[ 1 ] ="樫の杖"    ;
		 getWeapon()[ 2 ] ="竹やり"    ;
		 getWeapon()[ 3 ] ="ナイフ "   ;
		 getWeapon()[ 4 ] ="鉄の杖 "   ;
		 getWeapon()[ 5 ] ="ヌンチャク";
		 getWeapon()[ 6 ] ="鎖がま"    ;
		 getWeapon()[ 7 ] ="円月剣"    ;
		 getWeapon()[ 8 ] ="神官の杖"  ;
		 getWeapon()[ 9 ] ="神の十字架";
	 }

	@Override
	public int attack() {
		int r = ((getLev() * getAp()) + (getWp() * 5));
		return r;
	}

	@Override
	public int attack(int ud) {
		int r = ((getLev() * getAp()) + (ud * 5));
		return r;
	}

	@Override
	public void ex() {
		System.out.print( "どの術を使いますか？" );
		new Ex(this);
	}
}
