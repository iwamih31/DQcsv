package iwamih31.DQcsv;

public class Golem extends Monster {

	 Golem( int n ) {

		 setName( n + ".巨人");
		 setCode(   3)        ;
		 setExp (  50)        ;
		 setLev (  15)        ;
		 setHp  (1000)        ;
		 setMp  (   0)        ;
		 setSp  (   2)        ;
		 setGp  (1000)        ;
		 setEp  (   0)        ;//特殊能力の強さ
		 setTyp (   3)        ;// 0=なし, 1=回復系, 2=ドラゴン系, 3=巨人系
	}
}
