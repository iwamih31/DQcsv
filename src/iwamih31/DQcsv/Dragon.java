package iwamih31.DQcsv;

public class Dragon extends Monster {

	Dragon( int n ) {
		 setName( n + ".ドラゴイル" );
		 setCode(   4)               ;
		 setExp ( 500)               ;
		 setLev (  10)               ;
		 setHp  ( 800)               ;
		 setMp  (1000)               ;
		 setSp  (  11)               ;
		 setGp  ( 500)               ;
		 setEp  (  10)               ;
		 setTyp (   2)               ;//0=なし,1=回復系,2=ドラゴン系,3=巨人系
	}

	public void item(int clickItem) {
		Object choiceItem = Item.getItemList() [clickItem][0];
		System.out.println(getName() + "は" + choiceItem + "を使った");
		Item.item(clickItem);
	}
}




