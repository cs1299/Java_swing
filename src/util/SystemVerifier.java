package util;

import javax.swing.*;
import javax.swing.text.JTextComponent;

public class SystemVerifier {
    public static InputVerifier integerVerify(String fieldName, Integer min, Integer max, String defaultText){
        return new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                input.setVerifyInputWhenFocusTarget(false);
                String text = ((JTextField)input).getText();
                try {
                    Integer d = Integer.parseInt(text);
                    if(min!=null && d<min) {
                    JOptionPane.showMessageDialog(null,fieldName+"不能小于"+min,"系统提示",JOptionPane.WARNING_MESSAGE);
                        ((JTextComponent)input).setText(defaultText);
                        return false;
                    }
                    if(max!=null && d>max) {
                        JOptionPane.showMessageDialog(null,fieldName+"不能大于"+max,"系统提示",JOptionPane.WARNING_MESSAGE);
                        ((JTextComponent)input).setText(defaultText);
                        return false;
                    }
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null,fieldName+"必须是整数","格式错误",JOptionPane.WARNING_MESSAGE);
                    ((JTextComponent)input).setText(defaultText);
                    return false;
                }
                return  true;
        }
    };

    }
}
