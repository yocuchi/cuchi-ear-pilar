package dia12;

import java.awt.*;
import javax.swing.*;
public class _10GridBagLayout {
   public static void main(String[] a) {
      JFrame myFrame = new JFrame("GridBagLayout Test");
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container myPane = myFrame.getContentPane();
      myPane.setLayout(new GridBagLayout());
      GridBagConstraints c = new GridBagConstraints();
      setMyConstraints(c,0,0,GridBagConstraints.CENTER);
      myPane.add(getFieldPanel(),c);
      setMyConstraints(c,0,1,GridBagConstraints.CENTER);
      myPane.add(getButtonPanel(),c);
      myFrame.pack();
      myFrame.setVisible(true);
   }
   private static JPanel getFieldPanel() {
      JPanel p = new JPanel(new GridBagLayout());
      p.setBorder(BorderFactory.createTitledBorder("Details"));
      GridBagConstraints c = new GridBagConstraints();
      setMyConstraints(c,0,0,GridBagConstraints.EAST);
      p.add(new JLabel("Name:"),c);
      setMyConstraints(c,1,0,GridBagConstraints.WEST);
      p.add(new JTextField(16),c);
      setMyConstraints(c,0,1,GridBagConstraints.EAST);
      p.add(new JLabel("System:"),c);
      setMyConstraints(c,1,1,GridBagConstraints.WEST);
      p.add(getSystemPanel(),c);
      setMyConstraints(c,0,2,GridBagConstraints.EAST);
      p.add(new JLabel("Language:"),c);
      setMyConstraints(c,1,2,GridBagConstraints.WEST);
      p.add(getLanguagePanel(),c);
      setMyConstraints(c,0,3,GridBagConstraints.EAST);
      p.add(new JLabel("Year:"),c);
      setMyConstraints(c,1,3,GridBagConstraints.WEST);
      p.add(new JComboBox(new String[] {"2001","2002","2003"}),c);
      return p;
   }
   private static JPanel getButtonPanel() {
      JPanel p = new JPanel(new GridBagLayout());
      p.add(new JButton("OK"));
      p.add(new JButton("Cancel"));
      return p;
   }
   private static JPanel getSystemPanel() {
      JRadioButton unixButton = new JRadioButton("Unix",true);
      JRadioButton winButton = new JRadioButton("Window",false);
      ButtonGroup systemGroup = new ButtonGroup();
      systemGroup.add(unixButton);
      systemGroup.add(winButton);
      JPanel p = new JPanel(new GridBagLayout());
      p.add(unixButton);
      p.add(winButton);
      return p;
   }
   private static JPanel getLanguagePanel() {
      JPanel p = new JPanel(new GridBagLayout());
      p.add(new JCheckBox("Java",true));
      p.add(new JCheckBox("C++",true));
      p.add(new JCheckBox("Perl",false));
      return p;
   }
   private static void setMyConstraints(GridBagConstraints c, 
      int gridx, int gridy, int anchor) {
      c.gridx = gridx;
      c.gridy = gridy;
      c.anchor = anchor;
   }
}