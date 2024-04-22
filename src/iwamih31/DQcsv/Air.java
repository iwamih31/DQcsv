package iwamih31.DQcsv;

public class Air extends Monster {

	 Air ( int n ) {    //コンストラクタでフィールドを初期化

		 setName( n + "屍" );
		 setCode(        0 );
		 setExp (      100 );
		 setLev (       10 );
		 setHp  (        0 );
		 setMp  (        0 );
		 setSp  (        1 );
		 setGp  (     1000 );
		 setEp  (        0 );//特殊能力の強さ
		 setTyp (        3 );//0=なし,1=回復系,2=ドラゴン系,3=巨人系
	}
}