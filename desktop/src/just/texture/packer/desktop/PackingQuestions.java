/*******************************************************************************
 * Copyright 2014 Tommy Ettinger.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package just.texture.packer.desktop;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Tommy Ettinger on 2/7/2015.
 */
public class PackingQuestions extends JFrame {
    private JPanel panel1;
    private JButton chooseInputDirectoryButton;
    private JTextField pathToImagesText;
    private JButton chooseOutputDirectoryButton;
    private JButton packTexturesButton;
    private JLabel successLabel;
    private JLabel failureLabel;
    private JTextField pathToOutputText;
    private JTextField packFileText;
    private JLabel processingLabel;

    public PackingQuestions() {
        setTitle("LibGDX Texture Packer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(600, 500);
        setLocation(20, 20);
        //setUndecorated(true);

        chooseInputDirectoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                File path = getDirectory();
                if (path != null) {
                    pathToImagesText.setText(path.getAbsolutePath());
                }
            }
        });
        chooseOutputDirectoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                File path = getDirectory();
                if (path != null) {
                    pathToOutputText.setText(path.getAbsolutePath());
                }
            }
        });

        packTexturesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                successLabel.setText("");
                processingLabel.setText("Processing...");
                failureLabel.setText("");
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String prefix = packFileText.getText();
                            if (prefix.isEmpty()) prefix = "pack";
                            TexturePacker.process(pathToImagesText.getText(), pathToOutputText.getText(), prefix);
                            successLabel.setText("SUCCESS!");
                            processingLabel.setText("");
                            failureLabel.setText("");
                        } catch (Exception ex) {
                            successLabel.setText("");
                            processingLabel.setText("");
                            failureLabel.setText("PACKING FAILURE...");
                        }
                    }
                });
            }
        });

        add(panel1);
        pack();
        setVisible(true);


    }

    File getDirectory() {
        if (System.getProperty("os.name").contains("Mac")) {
            System.setProperty("apple.awt.fileDialogForDirectories", "true");
            FileDialog dialog = new FileDialog(PackingQuestions.this, "Choose directory", FileDialog.LOAD);
            dialog.setVisible(true);
            String name = dialog.getFile();
            String dir = dialog.getDirectory();
            if (name == null || dir == null) return null;
            return new File(dialog.getDirectory(), dialog.getFile());
        } else {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setDialogTitle("Choose directory");
            int result = chooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File dir = chooser.getSelectedFile();
                if (dir == null) return null;
                if (dir.getAbsolutePath().trim().length() == 0) return null;
                return dir;
            } else {
                return null;
            }
        }
    }

    File getFile() {
        if (System.getProperty("os.name").contains("Mac")) {
            System.setProperty("apple.awt.fileDialogForDirectories", "false");
            FileDialog dialog = new FileDialog(PackingQuestions.this, "Choose name for atlas file", FileDialog.SAVE);
            dialog.setVisible(true);
            String name = dialog.getFile();
            String dir = dialog.getDirectory();
            if (name == null || dir == null) return null;
            return new File(dialog.getDirectory(), dialog.getFile());
        } else {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.SAVE_DIALOG);
            chooser.setDialogTitle("Choose name for atlas file");
            int result = chooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File fil = chooser.getSelectedFile();
                if (fil == null) return null;
                if (fil.getAbsolutePath().trim().length() == 0) return null;
                return fil;
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PackingQuestions();
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new FormLayout("fill:275px:noGrow,left:4dlu:noGrow,fill:max(m;150px):grow,left:13dlu:noGrow,center:max(p;300px):grow(5.0),left:6dlu:noGrow", "center:d:grow,top:4dlu:noGrow,center:d:grow,top:4dlu:noGrow,center:d:grow,top:4dlu:noGrow,center:d:grow"));
        panel1.setBackground(new Color(-12632257));
        panel1.setFont(UIManager.getFont("TextField.font"));
        chooseInputDirectoryButton = new JButton();
        chooseInputDirectoryButton.setText("Choose Directory");
        CellConstraints cc = new CellConstraints();
        panel1.add(chooseInputDirectoryButton, cc.xy(3, 1, CellConstraints.FILL, CellConstraints.DEFAULT));
        final JLabel label1 = new JLabel();
        label1.setForeground(new Color(-855310));
        label1.setText("Path to images: ");
        panel1.add(label1, cc.xy(1, 1));
        pathToImagesText = new JTextField();
        pathToImagesText.setBackground(new Color(-723724));
        pathToImagesText.setText("<Directory not chosen>");
        panel1.add(pathToImagesText, cc.xy(5, 1, CellConstraints.FILL, CellConstraints.DEFAULT));
        final JLabel label2 = new JLabel();
        label2.setForeground(new Color(-855310));
        label2.setText("Path to write the output:");
        panel1.add(label2, cc.xy(1, 3));
        chooseOutputDirectoryButton = new JButton();
        chooseOutputDirectoryButton.setText("Choose Directory");
        panel1.add(chooseOutputDirectoryButton, cc.xy(3, 3));
        pathToOutputText = new JTextField();
        pathToOutputText.setBackground(new Color(-723724));
        pathToOutputText.setText("<Directory not chosen>");
        panel1.add(pathToOutputText, cc.xy(5, 3, CellConstraints.FILL, CellConstraints.DEFAULT));
        final JLabel label3 = new JLabel();
        label3.setForeground(new Color(-855310));
        label3.setText("[Optional] Prefix for atlas file and texture page(s)");
        panel1.add(label3, cc.xy(1, 5));
        packFileText = new JTextField();
        packFileText.setBackground(new Color(-723724));
        packFileText.setText("pack");
        panel1.add(packFileText, cc.xy(5, 5, CellConstraints.FILL, CellConstraints.DEFAULT));
        packTexturesButton = new JButton();
        packTexturesButton.setText("Pack Textures!");
        panel1.add(packTexturesButton, cc.xy(3, 7));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel2.setBackground(new Color(-12632257));
        panel1.add(panel2, cc.xy(5, 7));
        successLabel = new JLabel();
        successLabel.setEnabled(true);
        successLabel.setFont(new Font(successLabel.getFont().getName(), Font.BOLD, successLabel.getFont().getSize()));
        successLabel.setForeground(new Color(-10816647));
        successLabel.setText("");
        panel2.add(successLabel);
        failureLabel = new JLabel();
        failureLabel.setFont(new Font(failureLabel.getFont().getName(), Font.BOLD, failureLabel.getFont().getSize()));
        failureLabel.setForeground(new Color(-65485));
        failureLabel.setText("");
        panel2.add(failureLabel);
        processingLabel = new JLabel();
        processingLabel.setForeground(new Color(-10027009));
        processingLabel.setText("");
        panel2.add(processingLabel);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}
