import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ChatBot extends JFrame implements KeyListener {
	
	JMenuBar menuBar;
	JMenu file;
	JMenuItem tuitionCalc;

	JPanel panel;
	JTextArea dialog;
	JTextArea input;
	JScrollPane scroll;
	JLabel label;
	String testudoResponse = "What does testudo look like?";
	String testudoResponse2 = "what is the UMD mascot?";
	String testudoResponse3 = "UMD Mascot?";
	String studentUnion = "Where is the student union?";
	String studentUnion2 = "where is stamp?";
	String musicPlay = "What is the Maryland State Song?";
	String musicPlay2 = "maryland state song";
	String musicPlay3 = "Maryland song?";

	String[][] responses = {
			{ "Hello", "Hi", "Hey", "howdy", "ni hao", "What is your name" },
			{ "Hello this is a UMD Freshmen Advice ChatBot! "
					+ "\n\tAsk me some general questions"
					+ "\n\tabout UMD like where is the student union?"
					+ " \n\tWhere is the best place to eat?"
					+ "\n\tWhat are some easy classes to take?"
					+ " \n\tWhat does Testudo look like? "
					+ "\n\tWhat is the Maryland State Song?" },

			{ "How many Students attend UMD?",
					"how many students are at the University of Maryland",
					" What is the total population at UMD",
					" how many kids are at UMD?", "total enrollment",
					"how many students are enrolled at UMD?" },
			{ "As of 2017, a total of 40,521 students are enrolled at the University of Maryland" },

			{ "Who is the president of UMD?", "president of UMD?",
					"president" },
			{ "President of UMD is Wallace Loh. Mr.Loh has been president since Nov 1, 2010" },
			
			{"What is the introductory programming class?", "what is the first CS class", "what is the first comp sci class"},
			{"The first Computer Science course for students is CMSC131"},

			{ "What is the average gpa for the incoming freshmen class?",
					"average gpa for freshmen?", "freshmen gpa",
					"what is the avg sat",
					"what is average gpa for freshmen class",
					"what is the average gpa for the freshmen class" },
			{ "The average gpa for incoming freshmen students is 4.2 (weighted)" },

			{ "What is the avg sat score?", "what is the average sat?", "sat" },
			{ "The average sat score score is 1375/1600 (new) and 1980 (old)" },

			{ "What is the average act score?", "what is the avg act score?",
					"what is the avg act score" },
			{ "The average act score is  30 at UMD" },

			{ "give me some umd history", "what is some umd history",
					"give me some history on the Univeristy of Maryland?",
					"history", "umd history" },
			{ "The University of Maryland was founded in 1856"
					+ "\n\tand originally served as an Agricultural college from 1856-1916" },

			{ "Where is the best place to eat?",
					"What are some of the best places to eat",
					"best place to eat around campus?", "best place to eat" },
			{ "Some of my personal favorites : Pho Delight, Blaze Pizza, Aroy Thai, Nando's" },

			{ "What are some easy classes to take?", "easy classes?",
					"easy classes to take?" },
			{ "Easy Classes in terms of high A% : ENES140 (74%), ENES210(60%)"
					+ "\n\tBSCI189I(59%)"
					+ ".These are just to name a few you can \n\tfind a better list yourself"
					+ " @ ourumd.com" },
			
			
			{"Ed", "Edward", "eddy", "edward tong"},
			{"That is my creator! He is a very smart and handsome guy!", "He coded me !"},
			
				
			
			{"Where is the University of Maryland?", "where is umd?", "where umd"},
			{"The University of Maryland is located in Prince George County \n\tin the city of College Park, Maryland"},
			
			{"quiet places to study?", "where are some good study spots?"},
			{"Mckeldin Library (carrels), Hornbake library /n/tBio-Engineering building, Physical Science building, ESJ, SPH"},
		
			{"Bye","byee", "byi"},
			{"Bye!", "BYEEE", "bye"},

			// default
			{ "Please rephrase what you said, sometimes your question could be correct"
					+ "\n\tbut you need to reword it for me to "
					+ "understand " },

	};

	public ChatBot() {

		panel = new JPanel();
		dialog = new JTextArea(20, 50);
		dialog.setEditable(false);
		input = new JTextArea(1, 50);

		scroll = new JScrollPane(dialog,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		input.addKeyListener(this);
		panel.add(scroll);
		panel.add(input);
		panel.setBackground(new Color(255, 0, 0));
		getContentPane().add(panel);

		setTitle("UMD Fresh Advice ChatBot");
		setSize(685, 471);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
		menuBar = new JMenuBar();
		panel.add(menuBar);
		file = new JMenu("More");
		menuBar.add(file);
		tuitionCalc = new JMenuItem("UMD Cost Calculator");
		file.add(tuitionCalc);
		setJMenuBar(menuBar);
		
		event e = new event();
		tuitionCalc.addActionListener(e);
		
		
		

	}
	public class event implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TuitionCalc calc = new TuitionCalc();
			calc.setVisible(true);
			calc.setSize(368,190);
		}
		
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			input.setEditable(false);
			String response = input.getText();
			input.setText("");
			addText("\n-->You:\t" + response);
			while (response.charAt(response.length() - 1) == '!'
					|| response.charAt(response.length() - 1) == '.'
					|| response.charAt(response.length() - 1) == '?'
					|| response.charAt(response.length() - 1) == ',') {
				response = response.substring(0, response.length() - 1);

			}
			response = response.trim();

			byte result = 0;
			// 0 means we did not find anything,
			// 1 means we are still looking
			// 2 means we found a match

			int tracker = 0;
			// keep track off which group we are on
			while (result == 0) {
				if (inArray(response, responses[tracker * 2])) {
					result = 2;
					int r = (int) (Math.random()
							* responses[(tracker * 2) + 1].length);
					// r = possible responses
					addText("\n-->ChatBot:\t"
							+ responses[(tracker * 2) + 1][r]);
				}
				tracker++;
				if (tracker * 2 == responses.length - 1 && result == 0) {
					result = 1;
				}
			}
			if (response.replaceAll("[^A-Za-z]+", "").equalsIgnoreCase(testudoResponse.replaceAll("[^A-Za-z]+", ""))
				|| response.replaceAll("[^A-Za-z]+", "").equalsIgnoreCase(testudoResponse2.replaceAll("[^A-Za-z]+", ""))
				|| response.replaceAll("[^A-Za-z]+", "").equalsIgnoreCase(testudoResponse3.replaceAll("[^A-Za-z]+", ""))) {
				ChatBot.showTestudo();
			} else if(response.replaceAll("[^A-Za-z]+", "").equalsIgnoreCase(studentUnion.replaceAll("[^A-Za-z]+", ""))||
					response.replaceAll("[^A-Za-z]+", "").equalsIgnoreCase(studentUnion2.replaceAll("[^A-Za-z]+", ""))) {
				ChatBot.showStudentUnion();
			}else if(response.replaceAll("[^A-Za-z]+", "").equalsIgnoreCase(musicPlay.replaceAll("[^A-Za-z]+", ""))
					|| response.replaceAll("[^A-Za-z]+", "").equalsIgnoreCase(musicPlay2.replaceAll("[^A-Za-z]+", ""))||
					response.replaceAll("[^A-Za-z]+", "").equalsIgnoreCase(musicPlay3.replaceAll("[^A-Za-z]+", ""))) {
				MusicWindow music = new MusicWindow();
				music.pack();
				music.setVisible(true);
			}else if (result == 1) {
				int r = (int) (Math.random()
						* responses[responses.length - 1].length);
				addText("\n-->ChatBot:\t" + responses[responses.length - 1][r]);
			}
			addText("\n");

		}

	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			input.setEditable(true);
		}

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void addText(String str) {
		dialog.setText(dialog.getText() + str);
	}

	public boolean inArray(String match, String[] str) {
		boolean matched = false;
		for (int i = 0; i < str.length; i++) {
			if (str[i].replaceAll("[^A-Za-z]+", "").toLowerCase()
					.equals(match.replaceAll("[^A-Za-z]+", "").toLowerCase())) {
				matched = true;
			}
		}
		return matched;
	}

	public static void showTestudo() {
		ImageIcon tstdo = new ImageIcon(
				ChatBot.class.getResource("terrapin.jpg"));
		JOptionPane.showMessageDialog(null,
				"This is Testudo, After exiting press enter", "Testudo Pic",
				JOptionPane.INFORMATION_MESSAGE, tstdo);
		
	}
	public static void showStudentUnion() {
		ImageIcon stamp = new ImageIcon(ChatBot.class.getResource("stamp.jpg"));
		JOptionPane.showMessageDialog(null,"This is the location of Stamp on UMD Map, After exiting press enter", "Stamp Pic",
			JOptionPane.INFORMATION_MESSAGE,stamp);
	}

	public static void main(String[] args) {
		new ChatBot();
	}

}

