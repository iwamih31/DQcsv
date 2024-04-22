package iwamih31.DQcsv;

public class Slime extends Monster {

	Slime ( int n ) {            //コンストラクタでフィールドを初期化
		 setName( n + ".スライム");
		 setCode(   1 )           ;
		 setExp (   2 )           ;
		 setLev (   3 )           ;
		 setHp  (  80 )           ;
		 setMp  (   0 )           ;
		 setSp  (   3 )           ;
		 setGp  (  10 )           ;
		 setEp  (   0 )           ;//特殊能力の強さ
		 setTyp (   0 )           ;//0=なし,1=回復系,2=ドラゴン系,3=巨人系
	}
}