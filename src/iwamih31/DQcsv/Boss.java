package iwamih31.DQcsv;

public class Boss extends Monster {

	 Boss( int n ) {
		 setName( n + "." + Main.getbName());
		 setCode(   5)                      ;
		 setExp (1000)                      ;
		 setLev (  20)                      ;
		 setHp  (5000)                      ;
		 setMp  (5000)                      ;
		 setSp  (   1)                      ;
		 setGp  (   0)                      ;
		 setEp  (  20)                      ;
		 setTyp (   2)                      ;//0=なし,1=回復系,2=ドラゴン系,3=巨人系
	}
}
