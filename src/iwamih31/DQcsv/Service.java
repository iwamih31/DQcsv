package iwamih31.DQcsv;

public class Service {

	public int[][] getOriginalMap(int mapNumber) {
		int[][] originalMap = null;
		int[][] field1_Map = {
				{4,2,3,3,3,3,1,1,1,2,2,1,1,3,3},
				{1,1,2,3,3,3,1,2,2,1,2,1,3,3,2},
				{2,0,0,3,3,2,1,1,2,1,2,2,3,3,3},
				{3,3,0,0,0,1,2,1,2,1,1,1,2,3,3},
				{3,3,3,3,2,1,1,1,2,1,2,1,1,2,3},
				{3,3,1,0,1,0,2,2,2,0,0,2,1,1,1},
				{1,3,1,2,2,2,1,1,0,0,3,0,0,2,1},
				{3,3,1,2,0,2,1,2,2,0,0,2,2,1,1},
				{3,2,1,2,1,2,1,1,1,2,0,2,1,1,3},
				{1,2,1,1,1,2,2,2,1,2,1,2,2,2,1},
				{2,2,2,2,2,2,1,1,1,2,1,1,1,1,1},
				{1,2,0,0,0,0,1,2,2,2,1,1,0,0,1},
				{1,1,2,3,3,2,1,1,1,1,2,1,3,3,3},
				{3,1,1,1,3,3,3,3,2,1,2,1,3,9,3},
				{3,3,3,1,2,3,1,3,1,1,2,1,1,1,3}
		};
		int[][] castle1_Map = {
				{3,3,3,3,3,3,3,3,3,3,3,3,3,3,1},
				{3,3,3,1,1,1,1,1,1,1,1,1,1,1,1},
				{3,3,2,1,2,2,2,2,2,2,2,2,2,2,1},
				{3,1,2,0,0,2,0,9,2,0,2,0,0,2,1},
				{3,1,2,2,0,2,0,2,0,0,0,0,0,2,1},
				{3,1,2,0,0,2,0,0,0,0,2,0,2,2,1},
				{3,1,2,0,2,2,2,2,2,2,0,0,0,2,1},
				{3,1,2,0,0,2,0,0,0,0,2,0,0,2,1},
				{3,1,2,0,0,0,0,2,0,0,0,0,0,2,1},
				{3,1,2,2,2,2,2,2,2,2,2,2,0,2,1},
				{3,0,0,0,0,0,4,0,0,0,0,0,0,2,1},
				{3,2,2,2,2,2,2,0,2,2,2,2,2,2,1},
				{3,9,1,1,1,1,2,0,2,1,1,1,1,1,1},
				{3,3,3,1,3,1,8,8,8,1,3,3,3,3,3},
				{3,4,1,1,3,1,1,1,1,1,3,1,1,1,1}
		};
		int[][] dungeon1_Map = {
				{0,9,0,0,0,0,2,0,2,0,2,2,2,2,2},
				{0,0,0,2,2,0,2,0,2,0,0,0,0,0,2},
				{2,2,2,0,0,0,2,0,2,2,2,2,2,0,2},
				{0,0,0,0,2,2,2,0,0,0,2,0,2,0,2},
				{0,2,0,2,0,0,0,2,2,0,2,0,2,0,2},
				{0,2,0,2,0,2,0,0,0,0,2,0,0,0,2},
				{0,0,2,2,0,0,2,2,2,2,2,2,2,2,2},
				{2,0,2,2,2,0,2,0,0,0,0,0,0,0,0},
				{2,0,0,0,0,0,2,0,2,2,2,2,2,2,0},
				{2,0,2,2,2,2,2,0,2,0,0,0,0,2,0},
				{2,0,2,0,0,0,2,0,0,0,0,2,0,2,0},
				{2,0,2,0,2,0,2,2,2,2,2,0,0,2,0},
				{2,0,2,2,2,0,2,0,0,0,0,0,0,2,0},
				{2,0,0,0,0,0,2,0,2,2,2,2,2,0,0},
				{2,2,2,2,2,2,2,0,2,0,0,0,0,0,4}
		};
		switch (mapNumber) {
			case 0:
				originalMap = field1_Map;
				break;
			case 1:
				originalMap = castle1_Map;
				break;
			case 2:
				originalMap = dungeon1_Map;
				break;
			default:
				originalMap = field1_Map;
				break;
		}
		return originalMap;
	}
}
