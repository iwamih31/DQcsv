package iwamih31.DQcsv;

public class Wonder extends Ex {

	private static Object exList[][] = {
		{"*" ,"妖術名","=","使用MP","｛ "},
		{"1.","感謝"  ,"=",   10   ,"  " },
		{"2.","奇跡"  ,"=",   10   ,"  " },
		{"3.","蘇生"  ,"=",   100  ,"  " },
		{"4.","覚醒"  ,"=",   100  ,"  " }
	};

	Wonder(Character memb) {
		super(memb);
		itemList=exList;
	}
}
