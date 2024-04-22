package iwamih31.DQcsv;

public class MadDoctor extends Monster {

	 MadDoctor( int n ) {

		 setName( n + ".狂った医者");
		 setCode(   2 )             ;
		 setExp (  10 )             ;
		 setLev (   3 )             ;
		 setHp  ( 200 )             ;
		 setMp  ( 300 )             ;
		 setSp  (  10 )             ;
		 setGp  ( 100 )             ;
		 setEp  (  10 )             ;//特殊能力の強さ
		 setTyp (   1 )             ;// 0=なし, 1=回復系, 2=ドラゴン系, 3=巨人系
	}
}



