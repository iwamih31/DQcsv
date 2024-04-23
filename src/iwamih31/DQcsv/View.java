package iwamih31.DQcsv;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.OverlayLayout;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class View extends JFrame implements ActionListener, KeyListener {

	JLabel ansLabel;
	JLabel display;
	protected String value;
	String op1;
	String op2;
	String operator;
	int opMode;
	private JLabel q;
	JTextArea inp_Text;
	private Story sto;
	private JComponent pict;
	private JTextArea textAreaN;
	private JTextArea textAreaW;
	private JTextArea textAreaC;
	private JTextArea textAreaE;
	private JTextArea textAreaS;
	private  Border border;
	private JTextArea textAreaB;
	private JTextArea menuAreaB;
	private  JTextArea pictAreaB;
	private  JPanel eventPanel;
	private  JPanel backPanel;
	private JLabel[][] drawMap;
	private JPanel mapPanel;
	private ImageIcon centerIcon;
	private JLabel centerLabel;
	private JButton button_Ent;
	private JButton[] menuButton;
	private JButton cancelButton;
	Music music;
	private Controller controller;
	private int w;
	private int h;
	private int fontSize;
	private int count;
	private Object[] menu;
	private Component panelN;
	private Component panelW;
	private Component panelC;
	private Component panelE;
	private Component panelS;
	private JLabel labelN;
	private JLabel labelW;
	private JLabel labelC;
	private JLabel labelE;
	private JLabel labelS;
	private JFrame frame;
	private JPanel panelSet;
	private JPanel changePanelSet;
	private CardLayout cardLayout;
	private JPanel clear;
	private JLabel space;

	public View(Object[] mList) {
		super("メニュー");
		menu(mList);
	}

	public View(String title) {
		super(title);
		controller = Main.controller;
		start(title);
	}

	private void start(String title) {

//		setMode(0);
		// ディスプレイサイズを基準に、横1％、縦1％、フォントサイズを決定
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    w = screenSize.width / 100;
    h = screenSize.height / 100;
    fontSize = w;
		border = new LineBorder(Color.WHITE, 2, true);
		labelSet("");
		int bWE = 30;
		textAreaB = textAreaSet("",1,5);
		menuAreaB = textAreaSet("",1,1);
		textAreaN = textAreaSet("",5,5);/////////////メンバーステータス
		textAreaW = textAreaSet("",5,bWE);///////////現状
		textAreaC = textAreaSet("",5,9);////////////画面
		textAreaE = textAreaSet("",5,bWE);///////////コマンド
		textAreaS = textAreaSet("",1,5);/////////////メッセージ
		labelN = labelSet("メンバーステータス");
		labelW = labelSet("現状");
		labelC = labelSet("画面");
		labelE = labelSet("コマンド");
		labelS = labelSet("メッセージ");
		panelN = panelSetUD(textAreaN, textAreaB);
		panelW = panelSetUD(null, textAreaW);
		panelC = panelSetUD(null,labelC);
		panelE = panelSetUD(null, textAreaE);
		panelS = panelSetUD(null, textAreaS);
		space = labelSet("                                       ");
		music = null;
		repeatMusic("オープニング");
		outer();
		Console._____OUT_____("テスト");
	}

	private JLabel b() {
		JLabel b = labelSet(" ");
		return b;
	}

	private JTextArea textAreaSet(String text, int rows, int columns) {
		JTextArea textAreaSet = new JTextArea(text, rows,columns);
		format(textAreaSet);
		textAreaSet.setEditable(false);
		textAreaSet.setOpaque(false);///////////////背景を透明にする
		return textAreaSet;
	}

	private JLabel labelSet(String string) {
		JLabel labelSet = new JLabel(string, JLabel.CENTER);
		format(labelSet);
		labelSet.setOpaque(false);///////////////背景を透明にする
		return labelSet;
	}

	private JPanel panelSetLR(Object left, Object right) {
		JPanel panelSet = new JPanel();
		format(panelSet, 100, 100);
		panelSet.setLayout(new BoxLayout(panelSet, BoxLayout.X_AXIS));
		if (left != null) {
			panelSet.add((Component) left);
		}
		if (right != null) {
			panelSet.add((Component) right);
		}
		return panelSet;
	}

	private JPanel panelSetUD(Object up, Object down) {
		JPanel panelSet = new JPanel();
		format(panelSet, 100, 100);
		panelSet.setLayout(new BoxLayout(panelSet, BoxLayout.Y_AXIS));
		if (up != null) {
			panelSet.add((Component) up);
		}
		if (down != null) {
			panelSet.add((Component) down);
		}
		return panelSet;
	}

	private JPanel panelSetWCE(Object west, Object center, Object east) {
		JPanel panelSet = new JPanel();
		format(panelSet, 100, 100);
		panelSet.setLayout(new BorderLayout());
		if (west != null) {
			panelSet.add((Component) west, BorderLayout.WEST);
		}
		if (center != null) {
			panelSet.add((Component) center, BorderLayout.CENTER);
		}
		if (east != null) {
			panelSet.add((Component) east, BorderLayout.EAST);
		}
		return panelSet;
	}

	private JPanel panelSetNCS(Object north, Object center, Object south) {
		JPanel panelSet = new JPanel();
		format(panelSet);
		panelSet.setLayout(new BorderLayout());
		if (north != null) {
			panelSet.add((Component) north, BorderLayout.NORTH);
		}
		if (center != null) {
			panelSet.add((Component) center, BorderLayout.CENTER);
		}
		if (south != null) {
			panelSet.add((Component) south, BorderLayout.SOUTH);
		}
		return panelSet;
	}

	private JPanel panelSetTMB(Object top, Object middle, Object bottom) {
		JPanel panelSet = new JPanel();
		format(panelSet);
		panelSet.setLayout(new FlowLayout());
		if (top != null) {
			panelSet.add((Component) top);
		}
		if (middle != null) {
			panelSet.add((Component) middle);
		}
		if (bottom != null) {
			panelSet.add((Component) bottom);
		}
		return panelSet;
	}

	private void outer() {
		Console._____OUT_____("outer() します");
		if (frame != null) {
			frame.setVisible(false);
		}
		frame = new JFrame("RPG");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(w*100, h*100);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setLayout(new FlowLayout());
		changePanelSet = new JPanel();
		format(changePanelSet);
		cardLayout = new CardLayout();
		changePanelSet.setLayout(cardLayout);
		changePanelSet.add(panelSet(), "通常");
		clear = new JPanel();
		format(clear);
		changePanelSet.add(clear, "背景");
		frame.add(changePanelSet);
		change("通常");
		frame.setVisible(true);
	}

	private void change(String view_Mode) {
		Console._____OUT_____("change(" + view_Mode + ") します");
		cardLayout.removeLayoutComponent(panelSet);
		changePanelSet.add(panelSet, view_Mode);
		cardLayout.show(changePanelSet,view_Mode);
	}

	void change() {
		panelSet();
		change("通常");
	}

	private JPanel panelSet() {
		JPanel panelSetC = panelSetNCS(panelN, panelC, panelS);
		panelSetC.setPreferredSize(new Dimension(w*70, h*80));
		panelSet = new JPanel();
		format(panelSet);
		panelSet.setLayout(new FlowLayout());
		panelSet.add(panelW);
		panelSet.add(b());
		panelSet.add(panelSetC);
		panelSet.add(b());
		panelSet.add(panelE);
		return panelSet;
	}

	private void centerSet(Object west, Object center, Object east) {
		JLabel space = labelSet("                                       ");
		JPanel panelQ = panelSetWCE(west, center, east);
		JPanel panelQA = panelSetWCE(space, panelQ, space);
		JLabel blankAreaN = labelSet("");
		blankAreaN.setPreferredSize(new Dimension(w*2, h*20));
		JLabel blankAreaS = labelSet("");
		blankAreaS.setPreferredSize(new Dimension(w*2, h*30));
		panelC = panelSetNCS(blankAreaN, panelQA,blankAreaS);
		change();
	}

	private void format(Component component, int width, int height) {
		format(component);
		component.setSize(width, height);
	}

	private void format(Component component) {
		component.setFont(new Font("Monospaced", Font.BOLD, fontSize));
		component.setForeground(Color.WHITE);
		component.setBackground(Color.BLACK);
		if (getMode() > 0 && dead() > 0) {
			component.setForeground(Color.RED);
		}
	}

	private Border border() {
		border = new LineBorder(Color.WHITE, 2, true);
		if (getMode() > 0 && denger() > 0) {
			border = new LineBorder(Color.YELLOW, 2, true);
		}
		return border;
	}

	private static int denger() {
		int dengerLevel = 0;
		Member[] party = Main.getParty();
		for (int i = 0; i < party.length; i++) {
			if (party[i].getHp() <= party[i].getAp()) dengerLevel++;
		}
		return dengerLevel;
	}

	private static int dead() {
		int deadNumber = 0;
		Member[] party = Main.getParty();
		for (int i = 0; i < party.length; i++) {
			if (party[i].getHp() < 1) deadNumber++;
		}
		return deadNumber;
	}

	void que(String question, String[] answers) { // 質問 複数回答
		setTex(question);
		labelC = labelSet(getTex());
		JPanel bPanel = new JPanel();
		format(bPanel);
		int b_Num = answers.length; // 回答ボタンの数
		bPanel.setLayout(new GridLayout(b_Num, 0, 0, 0));
		bPanel.setPreferredSize(new Dimension(w*5, h/2));
		JButton[] button = new JButton[b_Num];
		for (int i = 0; i < b_Num; i++) {
			String bN = (String) answers[i];
			button[i] = new JButton(bN);
			format(button[i]);
			button[i].setFocusPainted(false);
			button[i].addActionListener(this);
			button[i].addKeyListener(this);
			button[i].setBorder(border());
			bPanel.add(button[i]);
		}
		centerSet(space,labelC, bPanel);
	}

	void input(String text) {
		buttonName(null);
		inp_Text = new JTextArea(1, 8);
		format(inp_Text);
		inp_Text.setBorder(border());
		JPanel b_Panel = new JPanel();
		format(b_Panel);
		b_Panel.setLayout(new GridLayout(1, 0, 0, 0));
		int b_Num = 1; // ボタンの数
		JButton[] button = new JButton[b_Num];
		String[] bList = { "OK" };
		for (int i = 0; i < b_Num; i++) {
			String b_Name = (String) bList[i];
			button[i] = new JButton(b_Name);
			format(button[i]);
			button[i].setPreferredSize(new Dimension(w*2, h*2));
			button[i].setMargin(new Insets(20, 10, 20, 10));///////文字周りの幅
			button[i].setFocusPainted(false);
			button[i].addActionListener(this);
			button[i].addKeyListener(this);
			button[i].setBorder(border());
			b_Panel.add(button[i]);
		}
		q = labelSet(text);
		JLabel blankAreaN = labelSet("");
		blankAreaN.setPreferredSize(new Dimension(w*2, h*4));
		JLabel blankAreaS = labelSet("");
		blankAreaS.setPreferredSize(new Dimension(w*2, h*4));
		JPanel a = panelSetLR(inp_Text, b_Panel);
		JPanel answer = panelSetNCS(blankAreaN, a, blankAreaS);
		centerSet(space, q, answer);
	}

	public void menu(Object[] mList) {
		JPanel panel = new JPanel();
		format(panel);
		panel.setLayout(new GridLayout(5, 0, 0, 0));
		panel.setPreferredSize(new Dimension(w * 10, h * 50));
		int b_Num = mList.length; // ボタンの数
		menuButton = new JButton[b_Num];
		for (int i = 0; i < b_Num; i++) {
			String b_Name =  String.valueOf(mList[i]);
			menuButton[i] = new JButton(b_Name);
			format(menuButton[i], 50, 50);
			menuButton[i].setMargin(new Insets(20, 10, 20, 10));///////文字周りの幅
			menuButton[i].setFocusPainted(false);
			menuButton[i].addActionListener(this);
			menuButton[i].addKeyListener(this);
			menuButton[i].setBorder(border());
			panel.add(menuButton[i]);
		}
		String b_Name =  cancel();
		cancelButton = new JButton(b_Name);
		format(cancelButton);
		cancelButton.setMargin(new Insets(20, 10, 20, 10));///////文字周りの幅
		cancelButton.setFocusPainted(false);
		cancelButton.addActionListener(this);
		cancelButton.addKeyListener(this);
		cancelButton.setBorder(border());
		cancelButton.setPreferredSize(new Dimension(w*10, h*13));
		JPanel bPanel = panelSetNCS(panel, menuAreaB,cancelButton);
		bPanel.setPreferredSize(new Dimension(w*10, h*80));
		bPanel.setFocusable(true);
		panelE = panelSetWCE(null, bPanel, null);
		menuNum(0);
		if(getMode() == 1) menuNum(1);
		selectStyle();
	}

	private String cancel() {
		return controller.getCancel();
	}

	private void menuNum(int i) {
		controller.setMenuNum(i);

	}

	public void actionPerformed(ActionEvent e) {
		// キープッシュ音を鳴らす
		pushSound();
		// 押されたボタン名を取得
		String select = e.getActionCommand();
		// フォーカスをframeに持ってくる
		frame.setFocusable(true);
		Common.___logOut___("frameにフォーカスをあてました");
		//キー入力の有効化
		frame.addKeyListener(this);
		Common.___logOut___("frameのキー入力を有効化しました");
		controller.actionPerformed(select);
	}

	void musicReset() {
		if (music != null) {
			music.stop();
			music = null;
		}
	}

	void repeatMusic(String musicName) {
		Console._____OUT_____("repeatMusic(" + musicName + ") します");
		if (music == null) {
			music = new Music(musicName);
			music.playRepeat();
		}
	}

	void partyStAll() {
		JTable pTab = new JTable();
		format(pTab);
		Status tableModel = new Status();
		pTab.setModel(tableModel);
		pTab.setAutoCreateRowSorter(true);
		pTab.setRowHeight(30);
		pTab.setShowVerticalLines(true);// 縦枠
		pTab.setShowHorizontalLines(false);// 横枠
		pTab.setPreferredSize(new Dimension(890, 280));
		pTab.setBorder(border());
		DefaultTableCellRenderer tableCellRendererC = new DefaultTableCellRenderer();
		tableCellRendererC.setHorizontalAlignment(JLabel.CENTER);
		TableColumn[] name = new TableColumn[pTab.getColumnModel().getColumnCount()];
		for (int i = 0; i < name.length; i++) {
			name[i] = pTab.getColumnModel().getColumn(i);
			name[i].setCellRenderer(tableCellRendererC);
		}
		format(pTab.getTableHeader(), 30, 30);
		pTab.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		JPanel panel = panelSetUD(pTab.getTableHeader(), pTab);
		format(panel);
		panel.setBorder(border());
		panelN = panelSetWCE(null, panel, null);
	}

	void partySt() {
		JTable pTab = new JTable();
		format(pTab);
		Main tableModel1 = Main.mai;
		pTab.setModel(tableModel1);
		pTab.setRowHeight(fontSize * 2);
		pTab.setShowVerticalLines(true);// 縦枠
		pTab.setShowHorizontalLines(false);// 横枠
		pTab.setBorder(border());
		DefaultTableCellRenderer tableCellRendererC = new DefaultTableCellRenderer();
		tableCellRendererC.setHorizontalAlignment(JLabel.CENTER);
		TableColumn[] name = new TableColumn[pTab.getColumnModel().getColumnCount()];
		for (int i = 0; i < name.length; i++) {
			name[i] = pTab.getColumnModel().getColumn(i);
			name[i].setCellRenderer(tableCellRendererC);
		}
		format(pTab.getTableHeader());
		pTab.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		JPanel panel = panelSetUD(pTab.getTableHeader(), pTab);
		format(panel);
		panel.setBorder(border());
		panelN = panelSetWCE(null, panel, null);
	}

	void partyStBlank() {
		JTextArea partyStBlank = textAreaSet(" ", 5, 10);
		panelN = panelSetNCS(null, partyStBlank, null);
	}

	void monster() {
		JTable pTab = new JTable();
		format(pTab);
		Battle tableModel1 = Main.getBat();
		pTab.setModel(tableModel1);
		pTab.setRowHeight(fontSize * 2);
		pTab.setShowVerticalLines(true);// 縦枠
		pTab.setShowHorizontalLines(false);// 横枠
		pTab.setBorder(border());
		DefaultTableCellRenderer tableCellRendererC = new DefaultTableCellRenderer();
		tableCellRendererC.setHorizontalAlignment(JLabel.CENTER);
		TableColumn[] name = new TableColumn[pTab.getColumnModel().getColumnCount()];
		for (int i = 0; i < name.length; i++) {
			name[i] = pTab.getColumnModel().getColumn(i);
			name[i].setCellRenderer(tableCellRendererC);
		}
		format(pTab.getTableHeader());
		pTab.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		JPanel stPanel = panelSetUD(pTab.getTableHeader(), pTab);
		format(stPanel);
		stPanel.setBorder(border());
		setBackPanel(backPanel_Battle());
		ImageIcon icon0 = createImageIcon(drawMonster(0));
		JLabel label0 = new JLabel(icon0);
		ImageIcon icon1 = createImageIcon(drawMonster(1));
		JLabel label1 = new JLabel(icon1);
		ImageIcon icon2 = createImageIcon(drawMonster(2));
		JLabel label2 = new JLabel(icon2);
		ImageIcon icon3 = createImageIcon(drawMonster(3));
		JLabel label3 = new JLabel(icon3);
		ImageIcon iconItem = createImageIcon(drawItem());
		JLabel labelItem = new JLabel(iconItem);
		JPanel monsterPanel = new JPanel();
		format(monsterPanel);
		monsterPanel.setOpaque(false);///////////////背景を透明にする
		int m = Battle.mNumber();
		if (m < 1){/////////////////////////////////////////////////戦闘後の場合
			monsterPanel.setLayout(new GridLayout(0, 1, 0, 0));
			monsterPanel.add(labelItem);
		} else {////////////////////////////////////////////////////戦闘中の場合
			monsterPanel.setLayout(new GridLayout(0, m, 0, 0));
			if (Battle.mons[0].getHp() > 0) monsterPanel.add(label0);
			if (Battle.mons[1].getHp() > 0) monsterPanel.add(label1);
			if (Battle.mons[2].getHp() > 0) monsterPanel.add(label2);
			if (Battle.mons[3].getHp() > 0) monsterPanel.add(label3);
		}
		JPanel scenePanel = new JPanel();
		format(scenePanel);
		scenePanel.setPreferredSize(new Dimension(890, 200));
		SpringLayout layout = new SpringLayout();
		scenePanel.setLayout(layout);
		layout.putConstraint(SpringLayout.NORTH, backPanel, 1, SpringLayout.NORTH, scenePanel);
		layout.putConstraint(SpringLayout.NORTH, monsterPanel, 1, SpringLayout.NORTH, scenePanel);
		layout.putConstraint(SpringLayout.WEST, backPanel, 5, SpringLayout.WEST, scenePanel);
		layout.putConstraint(SpringLayout.WEST, monsterPanel, 5, SpringLayout.WEST, scenePanel);
		layout.putConstraint(SpringLayout.EAST, backPanel, 5, SpringLayout.EAST, scenePanel);
		layout.putConstraint(SpringLayout.EAST, monsterPanel, 5, SpringLayout.EAST, scenePanel);
		scenePanel.add(monsterPanel);
		scenePanel.add(backPanel);
		JTextArea monsterBlank = textAreaSet(" ", 1, 10);
		JPanel battlePanel = panelSetUD(scenePanel, stPanel);
		panelC = panelSetNCS(monsterBlank, battlePanel,monsterBlank);
	}

	private String backPanel_Battle() {
		return controller.backPanel_Battle();
	}

	private JPanel map2D(String[][] map_Image) {
		drawMap = new JLabel[map_Image.length][map_Image[0].length];
		mapPanel = new JPanel();
		format(mapPanel);
		mapPanel.setLayout(new BoxLayout(mapPanel, BoxLayout.Y_AXIS));
		for (int i = 0; i < map_Image.length; i++) {
			JPanel row = new JPanel();
			row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));
			for (int j = 0; j < map_Image[i].length; j++) {
				String image = map_Image[i][j];
				ImageIcon icon = createImageIcon("image_map/" + image + ".png");
				drawMap[i][j] = new JLabel(icon);
				if(i == map_Image.length / 2 && j == map_Image[0].length /2) {
					row.add(mapCenter(drawMap[i][j]));
				} else {
					row.add(drawMap[i][j]);
				}
			}
			mapPanel.add(row);
		}

		frame.setFocusable(true);
		return mapPanel;
	}

	void set_Map2D(String[][] map_Image) {
		eventPanel =  map2D(map_Image);
	}

	private JPanel mapCenter(JLabel centerPiecelabel) {
		centerIcon = createImageIcon(image_Url());
		centerLabel = new JLabel(centerIcon);
		JPanel panel = new JPanel();
		OverlayLayout layout=new OverlayLayout(panel);
		panel.setLayout(layout);
		panel.add(centerLabel);
		panel.add(centerPiecelabel);
		return panel;
	}

	private String image_Url() {
		return controller.image_Url();
	}

	JPanel setBackPanel(String backURL) {
		ImageIcon iconBack = createImageIcon(backURL);
		JLabel labelBack = new JLabel(iconBack);
		backPanel = new JPanel();
		format(backPanel);
		backPanel.add(labelBack);
		return backPanel;
	}

	private ImageIcon createImageIcon(String imageUrl) {
		ClassLoader classLoader = this.getClass().getClassLoader();
		return new ImageIcon(classLoader.getResource(imageUrl));
	}

	private String drawMonster(int number) {
		return controller.drawMonster(number);
	}

	private String drawItem() {
		return controller.drawItem();
	}

	JPanel infoTable(Object setTableModel,String tableName) {
		JTable pTab = new JTable();
		format(pTab);
		pTab.setModel((TableModel) setTableModel);
		pTab.setAutoCreateRowSorter(true);
		pTab.setRowHeight(fontSize * 2);
		pTab.setShowVerticalLines(false);// 縦枠
		pTab.setShowHorizontalLines(false);// 横枠
		pTab.setPreferredSize(new Dimension(w*25, pTab.getRowCount() * fontSize));
		DefaultTableCellRenderer tableCellRendererC = new DefaultTableCellRenderer();
		tableCellRendererC.setHorizontalAlignment(JLabel.LEFT);
		TableColumn[] name = new TableColumn[pTab.getColumnModel().getColumnCount()];
		for (int i = 0; i < name.length; i++) {
			name[i] = pTab.getColumnModel().getColumn(i);
			name[i].setCellRenderer(tableCellRendererC);
		}
		JLabel tName = labelSet(tableName);
		JPanel panelT = panelSetLR(b(), pTab);
		panelT.setBorder(border());
		JPanel panel = panelSetUD(tName, panelT);
		format(panel);
		panel.setBorder(border());
		panel.setPreferredSize(new Dimension(w*13, (pTab.getRowCount()+1) * fontSize * 2 - 4));
		return panel;
	}

	void info(TableSet topSet, TableSet middleSet, TableSet bottomSet) {
		JPanel top = null;
		JPanel middle = null;
		JPanel bottom = null;
		if(topSet != null) top = infoTable(topSet.tableModel, topSet.tableName);
		if(middleSet != null) middle = infoTable(middleSet.tableModel, middleSet.tableName);
		if(bottomSet != null) bottom = infoTable(bottomSet.tableModel, bottomSet.tableName);
		JPanel infoPanel = panelSetTMB(top, middle, bottom);
		format(infoPanel);
		infoPanel.setPreferredSize(new Dimension(w*13, h*80));
		panelW = panelSetNCS(infoPanel, null, null);
	}

	JPanel ent() {
		int bI = 1;/////////////////////////////////////ボタンの数
		JPanel panel = new JPanel();
		format(panel);
		panel.setLayout(new GridLayout(bI, 0, 10, 1));
		LineBorder b = new LineBorder(getForeground(), 2, true);
		panel.setBorder(b);
		Common.___logOut___("ent = " + getEnt());
			button_Ent = new JButton(getEnt());
			format(button_Ent);
			button_Ent.setFocusPainted(false);
			button_Ent.addActionListener(this);
			button_Ent.addKeyListener(this);
			panel.add(button_Ent);
		return panel;
	}

	void scene() {
		Console._____OUT_____("View.scene() します");
		JPanel fieldPanel = new JPanel();
		format(fieldPanel);
		fieldPanel.setPreferredSize(new Dimension(890, 200));
		SpringLayout layout = new SpringLayout();
		fieldPanel.setLayout(layout);
		layout.putConstraint(SpringLayout.NORTH, backPanel, 1, SpringLayout.NORTH, fieldPanel);
		layout.putConstraint(SpringLayout.NORTH, eventPanel, 1, SpringLayout.NORTH, fieldPanel);
		layout.putConstraint(SpringLayout.WEST, backPanel, 0, SpringLayout.WEST, fieldPanel);
		layout.putConstraint(SpringLayout.WEST, eventPanel, 0, SpringLayout.WEST, fieldPanel);
		layout.putConstraint(SpringLayout.EAST, backPanel, 0, SpringLayout.EAST, fieldPanel);
		layout.putConstraint(SpringLayout.EAST, eventPanel, 0, SpringLayout.EAST, fieldPanel);
		fieldPanel.add(eventPanel);
		fieldPanel.add(backPanel);
		JPanel scene = panelSetNCS(null, fieldPanel,null);
		scene.setPreferredSize(new Dimension(890, 300));
		scene.setForeground(Color.BLACK);
		scene.setBackground(Color.GRAY);
		scene.setBorder(border());
		panelC = panelSetNCS(pictAreaB(), scene,pictAreaB());
	}

	JPanel setEventImage(String imageFileName) {
		ImageIcon eventIcon = createImageIcon(imageFileName);
		JLabel label = new JLabel(eventIcon);
		eventPanel = new JPanel();
		format(eventPanel);
		eventPanel.setOpaque(false);///////////////背景を透明にする
		eventPanel.add(label);
		return eventPanel;
	}

	void sceneBlank() {
		pict = textAreaSet("",7,1);
		pict.setOpaque(true);
		panelC = panelSetNCS(null, pict,null);
	}

	 JTextArea pictAreaB() {
		pictAreaB = textAreaSet("",1,4);
		pictAreaB.setFont(new Font("Monospaced", Font.BOLD, 16));
		return pictAreaB;
	}

	void comment() {
		sto = new Story();
		JTable st = new JTable();
		Story tableModel2 = sto;
		st.setAutoCreateRowSorter(true);
		st.setModel(tableModel2);
		DefaultTableCellRenderer tableCellRendererC = new DefaultTableCellRenderer();
		tableCellRendererC.setHorizontalAlignment(JLabel.CENTER);
		TableColumn col = st.getColumnModel().getColumn(0);
		col.setCellRenderer(tableCellRendererC);
		format(st);
		st.setRowHeight(fontSize*2);
		st.setShowVerticalLines(false);// 縦枠
		st.setShowHorizontalLines(false);// 横枠
		st.setPreferredSize(new Dimension(w*70, h*15));
		format(st.getTableHeader());
		st.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		JPanel panel = new JPanel();
		format(panel);
		panel.setLayout(new BorderLayout());
		panel.setBorder(border());
		panel.add(st, BorderLayout.CENTER);
		panelS= panelSetWCE(null, panel, ent());
	}

	public void keyTyped(KeyEvent keyEvent) {
	}

	public void keyPressed(KeyEvent keyEvent) {
		controller.keyPressed(keyEvent);
		keyPressed(null);
	}

	private void pushSound() {
//		Toolkit.getDefaultToolkit().beep(); // ビープ音を鳴らす
		sound(440f,100);
	}

	private void sound(float frequency, int soundLength) {
		try {
			new Sound(frequency, soundLength);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	void selectStyle() {
		if (entMark().equals(getEnt()) == false) {
			if (getMenuNum() < 0) setMenuNum(getMenuNum() + menuButton.length);
			if (menuButton.length <= getMenuNum()) setMenuNum(getMenuNum() - menuButton.length);
			for (JButton jButton : menuButton) {
				format(jButton);
			}
			menuButton[getMenuNum()].setForeground(Color.BLACK);
			menuButton[getMenuNum()].setBackground(Color.WHITE);
		}
	}

	private void setMenuNum(int number) {
		controller.setMenuNum(number);
	}

	private int getMenuNum() {
		return controller.getMenuNum();
	}

	private String entMark() {
		return controller.getEntMark();
	}

	public void setMapNumber(int mapNumber) {
		mapChangeSound();
	}

	private void mapChangeSound() {
		sound(100f,150);
		sound(100f,150);
	}

	public void keyReleased(KeyEvent keyEvent) {
	}

	public String inpDS(String s) {
		UIManager.put("OptionPane.okButtonText", "OK");
		UIManager.put("OptionPane.cancelButtonText", "Cancel");
		do {
			value = JOptionPane.showInputDialog(s);
			if (value == null) {// Cancelボタンが押された時
				display.setText("取消されました。");
				break;
			}
		} while (value.equals(null));
		if (value.equals("")) {
		} else {
			display.setText(value + " ");
		}
		return value;
	}

	public int inpDI(String s) {
		UIManager.put("OptionPane.okButtonText", "OK");
		UIManager.put("OptionPane.cancelButtonText", "Cancel");
		do {
			value = JOptionPane.showInputDialog(s);
			if (value == null) {// Cancelボタンが押された時
				display.setText("取消されました。");
				break;
			}
		} while (value.equals(null));
		if (value.equals("")) {
			display.setText("数値を入力してください。");
			inpDI(s);
		} else {
			display.setText(value + " ");
		}
		int r = Integer.parseInt(value);
		return r;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JFrame getFrame() {
		return this.frame;
	}

	public void setTex(String text) {
		controller.setTex(text);
	}

	public String getTex() {
		return controller.getTex();
	}

	public void setMessage(String text) {
		controller.setMessage(text);
	}

	public void setMessageEnt(String text) {
		controller.setMessageEnt(text);
	}

	public String getMessage() {
		return controller.getMessage();
	}

	public void setMode(int mode) {
		controller.setMode(mode);
	}

	public int getMode() {
		return controller.getMode();
	}

	public void setMenu(Object[] menu) {
		this.menu = menu;
	}

	public Object[] getMenu() {
		return menu;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return this.count;
	}

	public void setEnt(String ent) {
		controller.setEnt(ent);
	}

	public String getEnt() {
		return controller.getEnt();
	}

	private void buttonName(String string) {
		_____OUT_____("buttonName(" + string + ") します");
		controller.setButtonName(string);
	}

	private void _____OUT_____(String string) {
		Console._____OUT_____(string);
	}

}
