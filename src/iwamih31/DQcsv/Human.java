package iwamih31.DQcsv;

public class Human extends Member {

	 Human () {             //コンストラクタでフィールドを初期化
		 setName( "旅人" );
		 setNo  (      0 );
		 setExp (      0 );
		 setLev (      1 );
		 setHp  (     50 );
		 setMp  (      0 );
		 setSp  (      1 );
		 setWp  (      0 );
		 setAp  (attack());
		 setEp  (      1 );

		 getWeapon()[ 0 ] ="木の棒"  ;
		 getWeapon()[ 1 ] ="竹やり"  ;
		 getWeapon()[ 2 ] ="ナイフ"  ;
		 getWeapon()[ 3 ] ="棍棒 "   ;
		 getWeapon()[ 4 ] ="青銅の剣";
		 getWeapon()[ 5 ] ="鎖鎌"    ;
		 getWeapon()[ 6 ] ="鉄の剣"  ;
		 getWeapon()[ 7 ] ="鉄の槍"  ;
		 getWeapon()[ 8 ] ="鋼鉄の剣";
		 getWeapon()[ 9 ] ="日本刀";
	 }

	 @Override
	 public int attack() {
		setAp(( ( getLev() * 1 ) + ( getWp() * 1 ) ));
		return getAp();
	 }

	@Override
	public void ex() {
		System.out.println( "どの術を使いますか？" );
		new Ex( this );
	 }
}
