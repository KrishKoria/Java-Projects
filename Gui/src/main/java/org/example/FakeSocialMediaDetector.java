package org.example;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;

public class FakeSocialMediaDetector extends JFrame {
    private JTextField profileNameField;
    private JLabel profilePicLabel;

    public FakeSocialMediaDetector() {
        setTitle("Fake Social Media Account Detector");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel profileNameLabel = new JLabel("Profile Name:");
        profileNameField = new JTextField(20);

        inputPanel.add(profileNameLabel);
        inputPanel.add(profileNameField);

        JButton detectButton = new JButton("Detect");
        detectButton.addActionListener(e -> detectFakeAccount());

        JButton uploadButton = new JButton("Upload Picture");
        uploadButton.addActionListener(e -> uploadProfilePicture());

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(uploadButton, BorderLayout.WEST);
        mainPanel.add(detectButton, BorderLayout.CENTER);

        profilePicLabel = new JLabel();
        mainPanel.add(profilePicLabel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void uploadProfilePicture() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose Profile Picture");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showOpenDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String imagePath = selectedFile.getAbsolutePath();

            ImageIcon icon = new ImageIcon(imagePath);
            profilePicLabel.setIcon(icon);
        }
    }

    private void detectFakeAccount() {
        String profileName = profileNameField.getText();
        boolean isFakeName = profileName.length() < 6;

        // Fake name detection
        String nameResult = isFakeName ? "Fake" : "Genuine";

        JOptionPane.showMessageDialog(this, "Profile Name: " + nameResult, "Profile Name Detection Result", JOptionPane.INFORMATION_MESSAGE);

        // Detect humans in profile picture
        if (profilePicLabel.getIcon() != null) {
            ImageIcon icon = (ImageIcon) profilePicLabel.getIcon();
            BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics g = bufferedImage.createGraphics();
            icon.paintIcon(null, g, 0, 0);
            g.dispose();

            boolean hasHuman = detectHuman(bufferedImage);

            // Human detection result
            String picResult = hasHuman ? "Genuine" : "Fake";

            JOptionPane.showMessageDialog(this, "Profile Picture: " + picResult, "Profile Picture Detection Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please upload a profile picture first.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean detectHuman(BufferedImage image) {
        // Convert the BufferedImage to TYPE_3BYTE_BGR if it's not
        if (image.getType() != BufferedImage.TYPE_3BYTE_BGR) {
            BufferedImage convertedImg = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
            convertedImg.getGraphics().drawImage(image, 0, 0, null);
            image = convertedImg;
        }

        CascadeClassifier faceDetector = new CascadeClassifier("C:/Users/thein/Desktop/Java Projects/Gui/src/main/java/org/example/haarcascade_frontalface_alt.xml");

        // Extract pixels
        byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        Mat matImage = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC3);
        matImage.put(0, 0, pixels);

        Mat grayImage = new Mat();
        Imgproc.cvtColor(matImage, grayImage, Imgproc.COLOR_BGR2GRAY);

        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(grayImage, faceDetections);

        return faceDetections.toArray().length > 0;
    }

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        SwingUtilities.invokeLater(() -> new FakeSocialMediaDetector().setVisible(true));
    }
}