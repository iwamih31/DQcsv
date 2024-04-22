package iwamih31.DQcsv;

public class Hero extends Member {

	 Hero () {             //コンストラクタでフィールドを初期化
		 setName( "勇者" );
		 setNo  (      2 );
		 setExp (      0 );
		 setLev (      1 );
		 setHp  (     80 );
		 setMp  (     20 );
		 setSp  (      8 );
		 setWp  (      0 );
		 setAp  (      8 );
		 setEp  (      5 );

		 getWeapon()[ 0 ] ="木の棒"        ;
		 getWeapon()[ 1 ] ="ナイフ"        ;
		 getWeapon()[ 2 ] ="棍棒"        ;
		 getWeapon()[ 3 ] ="青銅の剣 "         ;
		 getWeapon()[ 4 ] ="鎖鎌 "     ;
		 getWeapon()[ 5 ] ="鉄の剣"          ;
		 getWeapon()[ 6 ] ="鋼鉄の剣"        ;
		 getWeapon()[ 7 ] ="鉄槍"      ;
		 getWeapon()[ 8 ] ="エクスカリバー";
		 getWeapon()[ 9 ] ="英雄の剣"      ;

		 setName( Main.getyName() );
	 }

	@Override
	public int attack() {
		if(Battle.fly==0) Battle.fly = 1;
		int r = ((getLev() * getAp()) + (getWp() * 12)) * Battle.fly;
		return r;
	}

	@Override
	public int attack(int ud) {
		if(Battle.fly==0) Battle.fly = 1;
		int r = ((getLev() * getAp()) + (ud * 12));
		return r;
	}

	@Override
	public void ex() {
//		Member mem = Main.getParty( )[ getNo() - 1 ];
		System.out.println( "どの術を使いますか？" );
		new Wonder( this );
	}
}
