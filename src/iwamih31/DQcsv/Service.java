package iwamih31.DQcsv;

import javax.sound.sampled.LineUnavailableException;

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

	MapPiece mapPiece(int map_Number, int piece_Number) {
		switch (map_Number) {
			case 0: // フィールド1
				switch (piece_Number) {
					case 0 :
						return new MapPiece("砂", 1); // 道
					case 1 :
						return new MapPiece("草", 2); // 魔物出現率アップ
					case 2 :
						return new MapPiece("山", 0); // 障害物
					case 3 :
						return new MapPiece("海", 0); // 障害物
					case 4 :
						return new MapPiece("洞窟", 4); // 別マップへ
					case 5 :
						return new MapPiece("洞窟", 5); // 階段（入口）
					case 6 :
						return new MapPiece("山", 2);
					case 7 :
						return new MapPiece("砂", 0); // 通れない道
					case 8 :
						return new MapPiece("草", 8); // 扉（出口）
					case 9 :
						return new MapPiece("城", 9);
					default :
						return new MapPiece("砂", 0); // 通れない道
			}
			case 1: // 城1
				switch (piece_Number) {
					case 0 :
						return new MapPiece("砂", 1);
					case 1 :
						return new MapPiece("草", 2);
					case 2 :
						return new MapPiece("山", 0);
					case 3 :
						return new MapPiece("海", 0);
					case 4 :
						return new MapPiece("洞窟", 4);
					case 5 :
						return new MapPiece("洞窟", 5); // 階段（入口）
					case 6 :
						return new MapPiece("山", 2);
					case 7 :
						return new MapPiece("宝箱", 7);
					case 8 :
						return new MapPiece("草", 8); // 扉（出口）
					case 9 :
						return new MapPiece("城", 9);
					default :
						return new MapPiece("砂", 0);
			}
			case 2: // 洞窟1
				switch (piece_Number) {
					case 0 :
						return new MapPiece("闇", 1); // 通路
					case 1 :
						return new MapPiece("草", 2);
					case 2 :
						return new MapPiece("山", 0); // 壁
					case 3 :
						return new MapPiece("海", 0); // 水
					case 4 :
						return new MapPiece("洞窟", 4);
					case 5 :
						return new MapPiece("洞窟", 5); // 階段（入口）
					case 6 :
						return new MapPiece("山", 2);
					case 7 :
						return new MapPiece("宝箱", 7);
					case 8 :
						return new MapPiece("草", 8); // 扉（出口）
					case 9 :
						return new MapPiece("城", 9);
					default :
						return new MapPiece("山", 1); // 通れる壁
			}
			default :
				return new MapPiece("闇", 0);
		}
	}

	int[] next_Map(int mapNumber, int x, int y) {
		int[] next_Map = {0, 0, 0}; // {next_MapNumber, next_X, next_Y}
		switch (mapNumber) {
			case 0 : // フィールド1
				if (x == 6 && y == 6) next_Map = new int[] {1, 0, 5};
				break;
			case 1 : // 城1
				if (x == 0 && y == 6) next_Map = new int[] {0, 0, 0};
				break;
			case 2 : // 洞窟1
				if (x == 0 && y == 0) next_Map = new int[] {0, 0, 0};
				break;
		}
		return next_Map;
	}

	private void sound(float frequency, int soundLength) {
		try {
			new Sound(frequency, soundLength);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	void pushSound() {
//			Toolkit.getDefaultToolkit().beep(); // ビープ音を鳴らす
		sound(440f,100);
	}

	void mapChangeSound() {
		sound(100f,150);
		sound(100f,150);
	}
}
