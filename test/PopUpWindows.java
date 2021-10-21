import javax.swing.*;

public class PopUpWindows {
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	JTextField jtf = new JTextField(10);
	String jtf_text = "";
	
	public int customButtonDialog(String label1, String label2, String label3, boolean textField, String button1, String button2, String button3) {
		Object[] buttons = new Object[3];
		JLabel jl1 = new JLabel(label1);
		JLabel jl2 = new JLabel(label2);
		JLabel jl3 = new JLabel(label3);
		
		jp.removeAll();
		jp.revalidate();
		
		if(button1 != null) {
			buttons[0] = button1;
		}
		
		if(button2 != null) {
			buttons[1] = button2;
		}
		
		if(button3 != null) {
			buttons[2] = button3;
		}
		
		if(label1 != null) {
			jp.add(jl1);
		}
		
		if(textField) {
			jp.add(jtf);
		}
		
		if(label2 != null) {
			jp.add(jl2);
		}
		
		if(label3 != null) {
			jp.add(jl3);
		}
		
		int result = JOptionPane.showOptionDialog(null, jp, "Please provide feedback", JOptionPane.YES_NO_CANCEL_OPTION, 
				JOptionPane.PLAIN_MESSAGE, null, buttons, null);
		
		if(result == JOptionPane.YES_OPTION) {
			jtf_text = jtf.getText();
			return 1;
		} else if (result == JOptionPane.NO_OPTION) {
			return 2;
		} else if(result == JOptionPane.CANCEL_OPTION) {
			return 3;
		} else if(result == JOptionPane.CLOSED_OPTION) {
			System.exit(0);
		}
		
		return 0;
	}
	
	public String getTextFieldText() {
		return jtf_text;
	}
	
	public void showDialog(String label) {
		JOptionPane.showMessageDialog(jf, label);
	}
}
