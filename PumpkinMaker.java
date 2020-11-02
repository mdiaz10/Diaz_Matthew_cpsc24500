import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DrawingPanel extends JPanel {
    private int txtLft;
    private int txtTop;
    private int txtWidth;
    private int txtHeight;
	private int drawCirc;
	public int getShapeType() {
		return drawCirc;
	}

	public void setShapeType(int val) {
		if (val < 0) {
			drawCirc = 0;
		}
		}

	public int getTxtLft() {
		return txtLft;
	}
	public int getTxtTop() {
		return txtTop;
	}
	public int getTxtWidth() {
		return txtWidth;
	}
	public int getTxtHeight() {
		return txtHeight;

	}
	public void setTxtLft(int L) {
    txtLft=L;
	}

  public void setTxtTop(int L) {
    txtTop=L;
	}
  public void setTxtWidth(int L) {
    txtWidth=L;
  }
  public void setTxtHeight(int L) {
    txtHeight=L;
  }


	public void toggleShapeType() {
		if (drawCirc == 0) {
			drawCirc = 1;
		} else {
			drawCirc = 0;
		}
	}
	public DrawingPanel() {
		drawCirc = 0;
		txtLft = 0;
		txtTop = 0;
		txtWidth = 0;
		txtHeight = 0;


	}

	public DrawingPanel(int st) {
		setShapeType(st);
	}
/**
* Takes in user input to Draw the circle 
*
*/
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);             g.setColor(Color.ORANGE);
        if (drawCirc == 0) {
        	g.fillOval(txtLft,txtTop,txtWidth,txtHeight);
        }
        }
    }


class ButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {

	}
}
/**
 * Sets input slot and text for the window 
 *
 */
class PumpkinFrame extends JFrame  {
	public void centerFrame(int width, int height) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int screenWidth = (int)dim.getWidth();
		int screenHeight = (int)dim.getHeight();
		int left = (screenWidth - width)/2;
		int top = (screenHeight - height)/2;
		setBounds(left,top,width,height);
		
	}

    public void setLook(String title, int left, int top, int width, int height) {
        setTitle(title);
        centerFrame(750,500);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        DrawingPanel panCenter = new DrawingPanel();
        c.add(panCenter,BorderLayout.CENTER);
        DrawingPanel panSouth = new DrawingPanel();
        panSouth.setLayout(new FlowLayout());
        JLabel LftText = new JLabel("Left:");
        JButton btnClick = new JButton("Draw");
        panSouth.add(LftText);
        JTextField txtLft = new JTextField(2);
        panSouth.add(txtLft);
        JLabel TopText = new JLabel("Top:");
        panSouth.add(TopText);
        JTextField txtTop = new JTextField(2);
        panSouth.add(txtTop);
        JLabel WidthText = new JLabel("Width");
        panSouth.add(WidthText);
        JTextField txtWidth = new JTextField(2);
        panSouth.add(txtWidth);
        JLabel HeightText = new JLabel("Height");
        panSouth.add(HeightText);
        JTextField txtHeight = new JTextField(2);
        panSouth.add(txtHeight);
        JLabel EyeText = new JLabel("Eye (C S T)");
        panSouth.add(EyeText);
        JTextField txtEye = new JTextField(2);
        panSouth.add(txtEye);
        JLabel NoseText = new JLabel("Nose (C S T)");
        panSouth.add(NoseText);
        JTextField txtNose = new JTextField(2);
        panSouth.add(txtNose);
        JLabel MouthText = new JLabel("Mouth (C S T)");
        panSouth.add(MouthText);
        JTextField txtMouth = new JTextField(2);
        panSouth.add(txtMouth);
        panSouth.add(btnClick);

        btnClick.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
            panCenter.setTxtLft(Integer.parseInt(txtLft.getText()));
            panCenter.setTxtTop(Integer.parseInt(txtTop.getText()));
            panCenter.setTxtWidth(Integer.parseInt(txtWidth.getText()));
            panCenter.setTxtHeight(Integer.parseInt(txtHeight.getText()));
            panCenter.toggleShapeType();
            try {
				int txtLeft = Integer.parseInt(txtLft.getText());
				panCenter.setTxtLft(txtLeft);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null," must be an integer.");
			}

        		repaint();
        	}
        });

        c.add(panSouth,BorderLayout.SOUTH);
    }
 /**
  * Sets dimensions of the Window 
  *
  */
    public PumpkinFrame() {
        setLook("Pumpkin Maker",100,100,800,480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public PumpkinFrame(String title, int left, int top, int width, int height, int closeOp) {
        setLook(title,left,top,width,height);
        setDefaultCloseOperation(closeOp);
    }
}

/**
 * @author Matthew Diaz 
 *
 */
public class PumpkinMaker {
    public static void main(String[] args) {
        PumpkinFrame frm = new PumpkinFrame();
        frm.setVisible(true);

    }
}
