//Name: Roxy Charisse Abastillas Libor
// It is my own work. I have never passed this program to my friends and I'm willing to accept whatever penalty given to me.
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


class Participant
{
	private String nameButton;
	private String fullName;
	private String tutorialGp;
	private String imageFile;
	
	//constructor
	public Participant(String nameButton, String fullName, String tutorialGp, String imageFile)
	{
		this.nameButton=nameButton;
		this.fullName=fullName;
		this.tutorialGp=tutorialGp;
		this.imageFile=imageFile;
	}

	//get methods	
	public String getNameButton()
	{
		return nameButton;
	}
	
	public String getFullName()
	{
		return fullName;
	}
	
	public String getTutorialGp()
	{
		return tutorialGp;
	}
	
	public String getImageFile()
	{
		return imageFile;
	}
	
	@Override
	public String toString()
	{
		String stringName = "Hi! I am " + getNameButton();
		String stringFullName = "My name is " + getFullName();
		String stringTutorialGp = "I am from tutorial group: " + getTutorialGp();
		return String.format("%s%n %s%n %s%n", stringName, stringFullName, stringTutorialGp);
	}
}

class QARoom extends JFrame
{	
	//declare
	private final JTextField ParticipantArea;
	private final JTextField HostArea;
	private final JButton PicParticipant1;
	private final JButton PicParticipant2;
	private final JButton PicParticipant3;
	private final JButton PicParticipant4;
	private final JButton PicHost;
	private final JButton PicClear;
	
	Participant p1 = new Participant("Participant 1", "John Doe","T05","icons8-profpic.png");
	Participant p2 = new Participant("Participant 2", "Rachel Ray","L05","icons8-profpic.png");
	Participant p3 = new Participant("Participant 3", "Mary Ann","T05","icons8-profpic.png");
	Participant p4 = new Participant("Participant 4", "James Cook","L05","icons8-profpic.png");
	
	public QARoom ()
	{
		super ("Q & A Room");
		setLayout(new FlowLayout());

		// construct textfields with default text
		ParticipantArea = new JTextField(90);
		ParticipantArea.setEditable(true); 
		HostArea = new JTextField(90);
		ParticipantArea.setEditable(true);
 
		// Add textfields to JFrame
		add (new JLabel ("Participant Area ")); // add label
		add(ParticipantArea); // add ParticipantArea to JFrame
		
		add (new JLabel ("Host Area ")); // add label
		add(HostArea); // add HostArea to JFrame
		
		//BUTTONS
		Icon PicLabel1 = new ImageIcon("icons8-profpic.png");
		Icon PicLabel2 = new ImageIcon("icons8-profpic-color.png");
		
		PicParticipant1 = new JButton("Participant 1",PicLabel1); 
		PicParticipant2 = new JButton("Participant 2",PicLabel1); 
		PicParticipant3 = new JButton("Participant 3",PicLabel1); 
		PicParticipant4 = new JButton("Participant 4",PicLabel1); 
		
		PicParticipant1.setRolloverIcon(PicLabel2);
		PicParticipant2.setRolloverIcon(PicLabel2);
		PicParticipant3.setRolloverIcon(PicLabel2);
		PicParticipant4.setRolloverIcon(PicLabel2);
		
		Icon PicLabel5 = new ImageIcon("icons8-teacher.png");
		Icon PicLabel6 = new ImageIcon("icons8-teacher-color.png");
		PicHost = new JButton("Host",PicLabel5); 
		
		PicHost.setRolloverIcon(PicLabel6);
		
		add(PicParticipant1);
		add(PicParticipant2);
		add(PicParticipant3);
		add(PicParticipant4);
		add(PicHost);
		
		Icon PicLabelClear = new ImageIcon("icons8-broom.png");
		PicClear = new JButton("Clear",PicLabelClear); 
		add(PicClear);
		
		ButtonHandler handler = new ButtonHandler();
		PicParticipant1.addActionListener(handler);
		PicParticipant2.addActionListener(handler);
		PicParticipant3.addActionListener(handler);
		PicParticipant4.addActionListener(handler);
		PicHost.addActionListener(handler);
		PicClear.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			String string = "";
			String IconString = "";
			
			//user clicked PicParticipant1 etc buttons
			if(event.getSource()==PicParticipant1)
			{
				string = String.format("%s %s",p1.toString(), ParticipantArea.getText());
				IconString = p1.getImageFile();
				JOptionPane.showMessageDialog(null,string,"Welcome to chat room",JOptionPane.INFORMATION_MESSAGE, new ImageIcon(IconString));
			}
		
			else if(event.getSource()==PicParticipant2)
			{
				string = String.format("%s %s",p2.toString(), ParticipantArea.getText());;
				IconString = p2.getImageFile();
				JOptionPane.showMessageDialog(null,string,"Welcome to chat room",JOptionPane.INFORMATION_MESSAGE, new ImageIcon(IconString));
			}
			
			else if(event.getSource()==PicParticipant3)
			{
				string = String.format("%s %s",p3.toString(), ParticipantArea.getText());
				IconString = p3.getImageFile();
				JOptionPane.showMessageDialog(null,string,"Welcome to chat room",JOptionPane.INFORMATION_MESSAGE, new ImageIcon(IconString));
			}
			
			else if(event.getSource()==PicParticipant4)
			{
				string = String.format("%s %s",p4.toString(), ParticipantArea.getText());
				IconString = p4.getImageFile();
				JOptionPane.showMessageDialog(null,string,"Welcome to chat room",JOptionPane.INFORMATION_MESSAGE, new ImageIcon(IconString));
			}	
			
			else if(event.getSource()==PicHost)
			{
				string = HostArea.getText();
				IconString = "icons8-teacher-color.png";
				JOptionPane.showMessageDialog(null,string,"I am the host",JOptionPane.INFORMATION_MESSAGE, new ImageIcon(IconString));
			}
			else if(event.getSource()==PicClear)
			{
				ParticipantArea.setText("");
				HostArea.setText("");
			}
			
			
		}
	}
}

class Roxy_A3
{
	public static void main (String [ ] args)
	{
		QARoom  qa = new QARoom ();
		qa.setSize (1000, 800);
		qa.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		qa.setVisible (true);	
	}
}