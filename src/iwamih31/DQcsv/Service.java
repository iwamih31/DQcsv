package iwamih31.DQcsv;

import javax.sound.sampled.LineUnavailableException;

public class Service {

	public int[][] getOriginalMap(int map_Number) {
		int[][] fieldA = {
				{1,2,3,3,3,1,1,1,2,1,1,3,3,2,1,1,2,3,3,3,3,3,3,3,1},
				{0,0,3,3,2,4,1,4,2,1,2,3,3,3,2,0,4,3,3,2,2,3,3,3,3},
				{3,0,0,0,0,2,1,2,4,1,1,2,3,3,3,3,3,3,3,4,1,2,3,3,3},
				{3,3,3,2,1,0,1,2,2,2,1,1,2,3,3,4,3,3,2,2,1,1,2,3,3},
				{3,3,0,1,0,2,2,2,0,4,2,1,2,3,3,3,3,3,4,8,2,1,1,1,3},
				{3,0,1,2,2,1,1,0,0,3,4,0,2,1,4,3,3,1,1,2,4,1,2,1,3},
				{3,1,2,4,2,1,2,2,0,0,3,2,1,1,3,3,1,1,2,3,2,2,1,1,3},
				{4,1,2,1,2,1,1,1,2,1,2,1,1,3,3,3,1,2,9,2,1,1,1,3,3},
				{2,1,1,1,2,2,2,1,2,1,1,1,2,1,5,2,1,1,1,1,1,3,2,5,3},
				{3,2,2,2,2,9,1,1,9,2,1,1,1,1,2,2,2,2,2,3,1,1,1,1,3},
				{1,1,0,0,0,2,1,1,2,1,1,0,0,1,1,2,4,0,0,1,1,3,3,3,3},
				{1,2,3,3,1,1,1,2,4,2,1,3,3,3,1,1,2,1,3,3,1,0,0,9,3},
				{1,1,1,3,3,3,3,3,1,2,1,3,9,3,3,1,1,1,3,2,1,1,0,3,3},
				{3,3,4,3,3,3,1,1,1,2,1,1,1,3,3,3,3,4,3,4,1,3,3,3,3},
				{2,3,3,3,3,1,1,1,2,1,1,1,3,3,4,2,3,3,3,3,3,3,3,3,4},
				{1,2,3,3,2,1,2,1,1,2,1,3,3,2,1,1,2,3,3,3,3,3,3,2,1},
				{8,3,3,3,2,1,1,2,1,2,1,3,3,3,2,0,0,3,3,2,2,3,3,3,2},
				{3,3,3,9,1,2,1,2,1,1,1,2,3,3,3,3,0,0,0,1,1,2,3,3,3},
				{3,3,3,2,1,1,1,5,2,2,1,5,3,3,3,3,3,3,2,2,1,1,2,3,3},
				{2,4,3,2,2,1,1,2,9,1,1,3,3,3,2,2,4,2,1,1,1,1,4,3,3},
				{1,1,3,4,0,1,2,4,2,1,3,3,3,8,0,1,1,2,0,1,1,0,0,3,3},
				{1,2,3,3,1,1,1,1,2,1,1,3,3,3,3,1,2,1,0,2,1,2,2,2,3},
				{1,1,1,3,1,3,3,1,1,2,1,4,3,3,3,1,1,1,3,2,1,2,9,2,3},
				{3,2,1,1,1,3,3,3,1,2,2,2,1,9,3,3,3,3,3,3,1,2,0,2,3},
				{3,3,3,3,3,3,3,1,1,2,1,1,1,1,1,2,3,3,3,2,1,1,1,1,1}
//				{4,2,3,3,3,3,1,1,1,2,2,1,1,3,3},
//				{1,1,2,3,3,3,1,2,2,1,2,1,3,3,2},
//				{2,0,0,3,3,2,1,1,2,1,2,2,3,3,3},
//				{3,3,0,0,0,1,2,1,2,1,1,1,2,3,3},
//				{3,3,3,3,2,1,1,1,2,1,2,1,1,2,3},
//				{3,3,1,0,1,0,2,2,2,0,0,2,1,1,1},
//				{1,3,1,2,2,2,1,1,0,0,3,0,0,2,1},
//				{3,3,1,2,0,2,1,2,2,0,0,2,2,1,1},
//				{3,2,1,2,1,2,1,1,1,2,0,2,1,1,3},
//				{1,2,1,1,1,2,2,2,1,2,1,2,2,2,1},
//				{2,2,2,2,2,2,1,1,1,2,1,1,1,1,1},
//				{1,2,0,0,0,0,1,2,2,2,1,1,0,0,1},
//				{1,1,2,3,3,2,1,1,1,1,2,1,3,3,3},
//				{3,1,1,1,3,3,3,3,2,1,2,1,3,9,3},
//				{3,3,3,1,2,3,1,3,1,1,2,1,1,1,3}
		};
		int[][] castleA_F1 = {
				{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2,1,1,2,3,3,3},
				{3,3,3,3,3,3,3,3,3,3,2,3,3,3,3,3,3,3,3,2,0,2,3,3,3},
				{3,3,3,3,3,3,3,3,1,2,1,2,1,1,1,3,3,3,3,3,3,0,0,3,3},
				{3,3,3,3,3,2,3,2,1,1,1,2,1,2,1,2,3,3,3,3,3,3,0,8,3},
				{3,3,3,3,8,2,3,0,2,1,2,0,0,2,1,1,0,2,2,2,3,3,0,8,3},
				{3,3,3,2,1,2,0,0,2,0,0,0,2,2,2,2,0,0,0,0,0,0,0,3,3},
				{3,3,3,3,1,2,2,0,2,0,2,2,9,0,0,0,2,2,2,2,1,2,3,3,3},
				{3,3,1,3,1,2,0,0,2,0,0,2,2,2,2,0,0,0,0,2,1,1,3,3,3},
				{3,1,1,2,1,2,0,2,2,2,0,2,0,0,0,2,2,0,0,2,1,1,3,3,3},
				{1,1,2,3,1,2,0,0,0,0,0,0,0,2,0,0,0,0,0,2,1,2,3,3,3},
				{3,3,3,3,1,2,2,0,2,2,2,2,2,2,2,2,2,2,2,2,1,3,3,3,3},
				{3,3,2,1,1,2,0,0,0,0,0,2,0,9,0,2,0,0,0,2,1,3,3,3,3},
				{3,1,0,2,1,2,0,0,2,0,0,2,0,2,0,0,0,0,0,2,1,3,3,3,3},
				{2,1,1,2,1,2,0,0,2,0,0,2,0,0,0,2,2,2,2,2,1,2,3,3,3},
				{1,2,1,3,1,2,2,0,2,0,2,2,2,0,2,2,5,0,0,2,1,2,3,3,3},
				{3,1,2,3,1,2,0,0,2,0,2,0,0,0,0,0,2,0,0,2,1,3,3,3,3},
				{3,3,2,3,1,2,0,0,2,0,0,0,0,0,0,0,7,2,0,2,1,3,3,3,3},
				{3,3,3,3,1,2,0,2,2,2,2,0,0,0,0,0,2,0,0,2,1,3,3,3,3},
				{3,3,0,1,1,0,0,0,0,4,6,0,0,0,0,0,2,0,0,2,1,2,3,3,3},
				{3,2,2,3,2,2,2,2,2,2,2,2,2,0,2,2,2,2,2,2,1,3,3,3,3},
				{2,1,1,2,5,1,1,1,1,1,1,1,2,0,2,1,1,1,1,1,1,3,3,3,3},
				{1,1,1,1,2,2,0,8,0,0,8,1,8,8,8,1,8,0,8,8,3,3,3,3,3},
				{1,2,1,1,8,4,0,0,3,3,3,1,1,1,1,1,3,3,3,3,3,3,3,3,1},
				{1,1,1,0,0,2,2,8,3,3,3,3,3,8,3,3,3,3,3,3,3,3,3,3,1},
				{1,0,0,1,0,0,3,3,3,3,3,3,3,3,3,3,3,3,3,2,2,3,3,3,3}
		};
		int[][] dungeonA_B1 = {
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
		int[][] castleA_F2 = {
				{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
				{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
				{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
				{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
				{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
				{3,3,3,3,3,2,2,8,2,2,2,8,2,2,2,8,2,2,2,2,3,3,3,3,3},
				{3,3,3,3,3,2,6,0,0,0,0,0,0,0,0,0,2,6,6,2,3,3,3,3,3},
				{3,3,3,3,3,2,0,0,0,6,2,0,0,7,0,0,0,0,0,2,3,3,3,3,3},
				{3,3,3,3,3,2,6,0,0,0,2,0,0,6,0,0,2,0,6,2,3,3,3,3,3},
				{3,3,3,3,3,2,2,0,2,2,2,0,0,0,0,0,2,6,6,2,3,3,3,3,3},
				{3,3,3,3,3,2,6,0,0,6,2,0,0,0,0,0,2,2,2,2,3,3,3,3,3},
				{3,3,3,3,3,2,2,2,2,2,2,0,0,5,0,0,2,0,6,2,3,3,3,3,3},
				{3,3,3,3,3,2,6,0,0,0,2,0,0,2,0,0,2,0,0,2,3,3,3,3,3},
				{3,3,3,3,3,2,0,0,2,0,0,2,0,0,0,2,2,0,2,2,3,3,3,3,3},
				{3,3,3,3,3,2,2,0,2,0,6,2,2,0,2,2,0,0,6,2,3,3,3,3,3},
				{3,3,3,3,3,8,0,0,0,2,2,6,2,0,0,0,0,0,0,8,3,3,3,3,3},
				{3,3,3,3,3,2,0,0,6,2,0,0,2,2,6,0,2,2,0,2,3,3,3,3,3},
				{3,3,3,3,3,2,0,2,2,6,0,0,0,0,2,2,6,0,0,2,3,3,3,3,3},
				{3,3,3,3,3,2,0,0,0,0,0,0,2,0,0,0,0,0,0,2,3,3,3,3,3},
				{3,3,3,3,3,2,2,2,2,2,2,2,8,8,2,2,2,2,2,2,3,3,3,3,3},
				{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
				{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
				{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
				{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
				{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}
//				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
//				{1,1,2,1,2,2,2,2,2,2,2,2,2,2,1},
//				{1,1,2,0,0,2,0,9,2,0,2,0,0,2,1},
//				{1,1,2,2,0,2,0,2,0,0,0,0,0,2,1},
//				{1,1,2,0,0,2,0,0,0,0,2,0,2,2,1},
//				{1,1,2,0,2,2,2,2,2,2,0,0,0,2,1},
//				{1,1,2,0,0,2,0,0,0,0,2,0,0,2,1},
//				{1,1,2,0,0,0,0,2,0,0,0,0,0,2,1},
//				{1,1,2,2,2,2,2,2,2,2,2,2,0,2,1},
//				{1,0,0,0,0,0,4,0,0,0,0,0,0,2,1},
//				{1,2,2,2,2,2,2,0,2,2,2,2,2,2,1},
//				{1,1,1,1,1,1,2,0,2,1,1,1,1,1,1},
//				{1,1,1,1,1,1,8,8,8,1,1,1,1,1,1},
//				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
		};
		switch (map_Number) {
			case 0:return fieldA;
			case 1:return castleA_F1;
			case 2:return dungeonA_B1;
			case 3:return castleA_F2;
			default:return fieldA;
		}
	}

	int[] next_Map(int map_Number, int x, int y) {
		int[] next_Map = {0, 0, 0}; // {next_MapNumber, next_X, next_Y}
		switch (map_Number) {
			case 0 : // 今 フィールドA
				// 城A
				if (x == 0 && y == 0) next_Map = new int[] {1, 1, 8}; // 城A 1階 正面出口へ
				break;
			case 1 : // 今 城A 1階
				// 正面出口
				if (x == 0 && y == 6) next_Map = new int[] {0, 0, 0}; // フィールドA X6 Y6
				// 洞窟A
				if (x == -3 && y == 6) next_Map = new int[] {2, 7, 7}; // 洞窟A 地下1階 入口
				// 階段A
				if (x == 1 && y == -1) next_Map = new int[] {3, 1, -1}; // 城A 2階 階段A
				break;
			case 2 : // 今 洞窟A 地下1階
				// 入口
				if (x == 7 && y == 7) next_Map = new int[] {1, 14, 3}; // 城A 1階 洞窟A
				break;
		}
		return next_Map;
	}

	MapPiece mapPiece(int map_Number, int piece_Number) {
		switch (map_Number) {
			case 0: // フィールドA
				return field(piece_Number);
			case 1: // 城A 1階
				return castle1(piece_Number);
			case 2: // 洞窟1
				return dungeon(piece_Number);
			case 3: // 城A 2階
				return castle2(piece_Number);
		default: // その他
			return field(piece_Number);
		}
	}

	// 0 障害物
	// 1 通路
	// 2 魔物出現率アップ
	// 3 ダメージ
	// 4 別マップへ
	// 5 （入口）別マップへ
	// 6 体力回復
	// 7 アトラクション
	// 8 （出口）別マップへ
	// 9 別マップへ

	private MapPiece dungeon(int piece_Number) {
		switch (piece_Number) {
			case 0 :return new MapPiece("闇", 1); // 通路
			case 1 :return new MapPiece("草", 2);
			case 2 :return new MapPiece("山", 0); // 壁
			case 3 :return new MapPiece("海", 0); // 水
			case 4 :return new MapPiece("洞窟", 4);
			case 5 :return new MapPiece("洞窟", 5); // 階段（入口）
			case 6 :return new MapPiece("山", 2);
			case 7 :return new MapPiece("宝箱", 7);
			case 8 :return new MapPiece("草", 8); // 扉（出口）
			case 9 :return new MapPiece("城", 9);
		default :return new MapPiece("山", 1); // 通れる壁
		}
	}

	private MapPiece field(int piece_Number) {
		switch (piece_Number) {
			case 0 :return new MapPiece("砂", 1); // 道
			case 1 :return new MapPiece("草", 2); // 魔物出現率アップ
			case 2 :return new MapPiece("山", 0); // 障害物
			case 3 :return new MapPiece("海", 0); // 障害物
			case 4 :return new MapPiece("洞窟", 4); // 洞窟
			case 5 :return new MapPiece("城", 4); // 村
			case 6 :return new MapPiece("山", 2); // 通れる山
			case 7 :return new MapPiece("砂", 0); // 通れない道
			case 8 :return new MapPiece("城", 4); // 神殿
			case 9 :return new MapPiece("城", 4); // 城
		default :return new MapPiece("砂", 0); // 通れない道
		}
	}

	private MapPiece castle1(int piece_Number) {
		switch (piece_Number) {
			case 0 :return new MapPiece("砂", 1);
			case 1 :return new MapPiece("草", 2);
			case 2 :return new MapPiece("山", 0);
			case 3 :return new MapPiece("海", 0);
			case 4 :return new MapPiece("洞窟", 4);
			case 5 :return new MapPiece("城", 5); // 階段（入口）
			case 6 :return new MapPiece("山", 2);
			case 7 :return new MapPiece("海", 7); // 宝箱（イベント）
			case 8 :return new MapPiece("草", 8); // 扉（出口）
			case 9 :return new MapPiece("城", 9);
		default :return new MapPiece("砂", 0);
		}
	}

	private MapPiece castle2(int piece_Number) {
		switch (piece_Number) {
		case 0 :return new MapPiece("砂", 1); // 通路
		case 1 :return new MapPiece("草", 3); // バリア
		case 2 :return new MapPiece("山", 0); // 壁
		case 3 :return new MapPiece("闇", 0); // 空
		case 4 :return new MapPiece("城", 4); // 階段（上り）
		case 5 :return new MapPiece("洞窟", 4); // 階段（下り）
		case 6 :return new MapPiece("草", 7); // イベント
		case 7 :return new MapPiece("勇者", 0); // 王様
		case 8 :return new MapPiece("海", 4); // 扉（出口）
		case 9 :return new MapPiece("闇", 7); // 穴
		default :return new MapPiece("砂", 0);
		}
	}

	public String map_Name(int mapNumber) {
		switch (mapNumber) {
		case 0: return "フィールドA";
		case 1: return "城A 1階";
		case 2: return "洞窟A 地下1階";
		case 3: return "城A 2階";
		}
		return "どこか";
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

	int[][] shift_Map(int[][] originalMap, int x, int y) {
		int[][] map = new int[originalMap.length][originalMap[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				int row = i + y;
				if (row < 0) row += map.length;
				else if (map.length <= row) row -= map.length;
				int column = j + x;
				if (column < 0) column += map[0].length;
				else if (map[0].length <= column) column -= map[0].length;
				map[i][j] = originalMap[row][column];
			}
		}
		return map;
	}

	private int[] center_XY(int[][] baseArray) {
		int[] centerXY = {baseArray[0].length / 2, baseArray.length / 2};
		return centerXY;
	}

	MapPiece[][] map_Data(int map_Number, int[][] map) {
		MapPiece[][] map_Data = new MapPiece[map.length][map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				int piece_Number = map[i][j];
				map_Data[i][j] = mapPiece(map_Number, piece_Number);
			}
		}
		return map_Data;
	}

	public int piece_Number(int map_Number, int x, int y) {
		int[][] originalMap = getOriginalMap(map_Number);
		int[][] shift_Map = shift_Map(originalMap, x, y);
		int[] mapCenter = center_XY(shift_Map);
		int center_X = mapCenter[0];
		int center_Y = mapCenter[1];
		return shift_Map[center_X][center_Y];
	}

	public boolean isBarrier(int map_Number, int target_X, int target_Y) {
		boolean isBarrier = false;
		int[][] map = getOriginalMap(map_Number);
		int[][] shift_Map = shift_Map(map, target_X, target_Y);
		int[] mapCenter = center_XY(shift_Map);
		int nextX = mapCenter[0];
		int nextY = mapCenter[1];
		MapPiece mapPiece = mapPiece(map_Number, map[nextX][nextY]);
		int role = mapPiece.getRole();
		if (role < 1 ) isBarrier = true;
		return isBarrier;
	}

	public boolean isBarrier(MapPiece mapPiece) {
		boolean isBarrier = false;
		int role = mapPiece.getRole();
		if (role < 1 ) isBarrier = true;
		return isBarrier;
	}

	public int[][] cut_Map(int[][] map, int cut_X, int cut_Y) {
		int[][] cut_Map = new int[map.length - cut_Y * 2][map[0].length - cut_X * 2];
		for (int i = 0; i < cut_Map.length; i++) {
			for (int j = 0; j < cut_Map[0].length; j++) {
				cut_Map[i][j] = map [i + cut_Y][j + cut_X];
			}
		}
		return cut_Map;
	}
}
